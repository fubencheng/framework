package net.lnk.spring.boot.jdbc.service;

import java.util.List;

import net.lnk.spring.boot.jdbc.model.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月21日
 */
public interface CardBinService {

	public void save(CardBinEntity cardBin);

	public CardBinEntity findById(long id);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);
	
	public void update(CardBinEntity cardBin, long id);

}
