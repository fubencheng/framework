package net.lnk.spring.boot.batch.listener;

import javax.batch.api.chunk.listener.AbstractChunkListener;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinChunkListener extends AbstractChunkListener {

	public void beforeChunk() throws Exception {
		System.err.println("Before chunk " + Thread.currentThread().getName());
		super.beforeChunk();
	}

	public void onError(Exception exception) throws Exception {
		System.err.println(exception.getMessage());
		super.onError(exception);
	}

	public void afterChunk() throws Exception {
		System.err.println("After chunk " + Thread.currentThread().getName());
		super.afterChunk();
	}

}
