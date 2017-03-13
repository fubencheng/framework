package net.lnk.spring.boot.jpa.service;

import java.util.List;

import net.lnk.spring.boot.jpa.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
public interface CardBinService {

	public void save(CardBinEntity cardBin);

	public CardBinEntity findById(long id);

	public CardBinEntity findByPrimaryNo(String primaryCode);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

	public List<CardBinEntity> findByCardName(String cardName);

}
