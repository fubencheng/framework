package net.lnk.spring.boot.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

import com.alibaba.fastjson.JSON;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinStepExecutionListener extends StepExecutionListenerSupport {

	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("ImportCardBinStepExecutionListener, stepExecution:" + JSON.toJSONString(stepExecution));
		return super.afterStep(stepExecution);
	}

	public void beforeStep(StepExecution stepexecution) {
		super.beforeStep(stepexecution);
	}

}
