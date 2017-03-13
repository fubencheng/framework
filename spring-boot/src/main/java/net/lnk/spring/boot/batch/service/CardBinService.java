package net.lnk.spring.boot.batch.service;

import java.util.List;

import net.lnk.spring.boot.batch.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
public interface CardBinService {

	public void save(List<? extends CardBinEntity> cardBins);

	public CardBinEntity findById(long id);

	public CardBinEntity findByPrimaryNo(String primaryCode);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

}
