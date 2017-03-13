package net.lnk.spring.boot.batch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import net.lnk.spring.boot.batch.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinItemWriteListener implements ItemWriteListener<CardBinEntity> {

	public void afterWrite(List<? extends CardBinEntity> list) {
		// TODO Auto-generated method stub

	}

	public void beforeWrite(List<? extends CardBinEntity> list) {
		// TODO Auto-generated method stub

	}

	public void onWriteError(Exception exception, List<? extends CardBinEntity> list) {
		// TODO Auto-generated method stub

	}

}
