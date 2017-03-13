package net.lnk.spring.boot.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lnk.spring.boot.jdbc.dao.CardBinDao;
import net.lnk.spring.boot.jdbc.model.CardBinEntity;
import net.lnk.spring.boot.jdbc.service.CardBinService;

/**
 * @author Ben
 * @memo 2017年2月21日
 */
@Service
public class CardBinServiceImpl implements CardBinService {

	@Autowired
	private CardBinDao cardBinDao;

	@Transactional
	public void save(CardBinEntity cardBin) {
		cardBinDao.save(cardBin);
	}

	@Transactional
	public void update(CardBinEntity cardBin, long id) {
		cardBinDao.update(cardBin, id);
	}

	public CardBinEntity findById(long id) {
		return cardBinDao.findById(id);
	}

	public List<CardBinEntity> findByIssuerCode(String issuerCode) {
		return cardBinDao.findByIssuerCode(issuerCode);
	}

}
