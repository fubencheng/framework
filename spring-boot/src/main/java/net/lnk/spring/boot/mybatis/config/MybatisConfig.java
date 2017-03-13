package net.lnk.spring.boot.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @author Ben
 * @memo 2017年3月1日
 */
@Configurable
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer {

	@Autowired
	@Qualifier("c3p0DataSource")
	private DataSource dataSource;

	@Bean
	private SqlSessionFactory sqlSessionFactory() {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(new ClassPathResource("classpath:/mybatis/mybatis-config.xml"));

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			factoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/*Mapper.xml"));
			return factoryBean.getObject();
		} catch (Exception e) {
			throw new RuntimeException("Init mybatis sqlSessionFactory failed!!!");
		}
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {

		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public TransactionInterceptor transactionInterceptor() {
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		transactionInterceptor.setTransactionManager(annotationDrivenTransactionManager());
		transactionInterceptor.setTransactionAttributeSource(new AnnotationTransactionAttributeSource());
		return transactionInterceptor;
	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
		proxyCreator.setBeanNames(new String[] { "*Service", "*ServiceImpl" });
		proxyCreator.setInterceptorNames(new String[] { "transactionInterceptor" });
		return proxyCreator;
	}
}
