package net.lnk.spring.boot.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinJobListener implements JobExecutionListener {

	public void afterJob(JobExecution jobexecution) {
		System.out.println("完成导入。。。");
	}

	public void beforeJob(JobExecution jobexecution) {
		System.out.println("开始执行job。。。");
	}

}
