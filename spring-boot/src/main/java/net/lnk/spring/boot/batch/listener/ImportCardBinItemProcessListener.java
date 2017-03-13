package net.lnk.spring.boot.batch.listener;

import org.springframework.batch.core.ItemProcessListener;

import net.lnk.spring.boot.batch.entity.CardBinEntity;
import net.lnk.spring.boot.batch.vo.CardBinVo;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class ImportCardBinItemProcessListener implements ItemProcessListener<CardBinVo, CardBinEntity> {

	public void afterProcess(CardBinVo vo, CardBinEntity cardBin) {
		// TODO Auto-generated method stub

	}

	public void beforeProcess(CardBinVo vo) {
		// TODO Auto-generated method stub

	}

	public void onProcessError(CardBinVo vo, Exception exception) {
		// TODO Auto-generated method stub

	}

}
