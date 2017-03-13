package net.lnk.spring.boot.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import net.lnk.spring.boot.batch.entity.CardBinEntity;
import net.lnk.spring.boot.batch.listener.ImportCardBinChunkListener;
import net.lnk.spring.boot.batch.listener.ImportCardBinItemProcessListener;
import net.lnk.spring.boot.batch.listener.ImportCardBinItemReadListener;
import net.lnk.spring.boot.batch.listener.ImportCardBinItemWriteListener;
import net.lnk.spring.boot.batch.listener.ImportCardBinJobListener;
import net.lnk.spring.boot.batch.listener.ImportCardBinStepExecutionListener;
import net.lnk.spring.boot.batch.vo.CardBinVo;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
@Component
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ItemProcessor<CardBinVo, CardBinEntity> itemProcessor;

	@Autowired
	private ItemWriter<CardBinEntity> itemWriter;

	@Bean
	public JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setDatabaseType("mysql");
		factoryBean.setTransactionManager(transactionManager());
		return factoryBean.getObject();
	}

	@Bean
	public SimpleJobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		return jobLauncher;
	}

	@Bean
	public Job importCardBinJob(JobBuilderFactory jobs, Step importCardBinStep) {
		return jobs.get("import-CardBin").incrementer(new RunIdIncrementer()).listener(new ImportCardBinJobListener())
				.flow(importCardBinStep).end().build();
	}

	@Bean
	public Step importCardBinStep(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("importCardBinStep").<CardBinVo, CardBinEntity> chunk(50).reader(reader())
				.processor(itemProcessor).writer(itemWriter).faultTolerant().retry(Exception.class) // 异常重试
				.noRetry(ParseException.class) // 解析异常不重试
				.retryLimit(3) // 每条记录最多重试3次
				.skipPolicy(new AlwaysSkipItemSkipPolicy()).skipLimit(100) // 总共允许跳过100次异常
				.listener(new ImportCardBinItemReadListener()) // 注册读取监听器
				.listener(new ImportCardBinItemProcessListener()) // 注册处理监听器
				.listener(new ImportCardBinItemWriteListener()) // 注册写监听器
				.taskExecutor(new SimpleAsyncTaskExecutor()) // 并发执行
				.throttleLimit(10) // 并发任务数
				.transactionManager(transactionManager()) // 事务管理器
				.listener(new ImportCardBinStepExecutionListener()) // 步骤执行监听器
				.listener(new ImportCardBinChunkListener()) // 数据块处理监听器
				.build();
	}

	@Bean
	@StepScope
	// 类型要是FlatFileItemReader 否则会报Reader not open exception，有AOP逻辑
	public FlatFileItemReader<CardBinVo> reader() {
		FlatFileItemReader<CardBinVo> reader = new FlatFileItemReader<CardBinVo>();
		reader.setResource(new ClassPathResource("batch/data.txt"));
		reader.setLinesToSkip(0);
		reader.setLineMapper(lineMapper());
		return reader;
	}

	@Bean
	@StepScope
	public LineMapper<CardBinVo> lineMapper() {
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter("|");
		tokenizer.setStrict(true);
		tokenizer.setNames(new String[] { "issuerName", "cardName", "forATM", "forPOS", "cardLength", "cardNo",
				"primaryLength", "primaryNo", "cardType" });

		BeanWrapperFieldSetMapper<CardBinVo> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(CardBinVo.class);

		DefaultLineMapper<CardBinVo> lineMapper = new DefaultLineMapper<CardBinVo>();
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}

}
