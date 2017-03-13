package net.lnk.spring.boot.batch.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lnk.spring.boot.batch.dao.CardBinDao;
import net.lnk.spring.boot.batch.entity.CardBinEntity;
import net.lnk.spring.boot.batch.service.CardBinService;

/**
 * @author Ben
 * @memo 2017年2月22日
 */
@Service
public class CardBinServiceImpl implements CardBinService {

	@Autowired
	private CardBinDao cardBinDao;

	public CardBinEntity findById(long id) {

		return cardBinDao.findOne(id);
	}

	@Transactional
	public void save(CardBinEntity cardBin) {
		cardBin.setCreateTime(new Date());

		cardBinDao.save(cardBin);
	}

	@Transactional
	public void save(List<? extends CardBinEntity> cardBins) {

		cardBinDao.save(cardBins);
	}

	public CardBinEntity findByPrimaryNo(String primaryCode) {

		return cardBinDao.findByPrimaryNo(primaryCode);
	}

	public List<CardBinEntity> findByIssuerCode(String issuerCode) {

		return cardBinDao.findByIssuerCode(issuerCode);
	}

}
