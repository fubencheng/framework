package net.lnk.spring.boot.batch.listener;

import org.springframework.batch.core.ItemReadListener;

import net.lnk.spring.boot.batch.vo.CardBinVo;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinItemReadListener implements ItemReadListener<CardBinVo> {

	public void afterRead(CardBinVo vo) {
		// TODO Auto-generated method stub

	}

	public void beforeRead() {
		// TODO Auto-generated method stub

	}

	public void onReadError(Exception exception) {
		// TODO Auto-generated method stub

	}

}
