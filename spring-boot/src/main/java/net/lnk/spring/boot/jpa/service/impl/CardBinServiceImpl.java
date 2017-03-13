package net.lnk.spring.boot.jpa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lnk.spring.boot.jpa.dao.CardBinDao;
import net.lnk.spring.boot.jpa.entity.CardBinEntity;
import net.lnk.spring.boot.jpa.service.CardBinService;
import static net.lnk.spring.boot.jpa.specs.CardBinSpecs.fromCardName;

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

	public CardBinEntity findByPrimaryNo(String primaryCode) {

		return cardBinDao.findByPrimaryNo(primaryCode);
	}

	public List<CardBinEntity> findByIssuerCode(String issuerCode) {

		return cardBinDao.findByIssuerCode(issuerCode);
	}

	public List<CardBinEntity> findByCardName(String cardName) {

		return cardBinDao.findAll(fromCardName(cardName));
	}

}
