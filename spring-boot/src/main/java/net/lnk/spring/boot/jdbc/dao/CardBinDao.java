package net.lnk.spring.boot.jdbc.dao;

import java.util.List;

import net.lnk.spring.boot.jdbc.model.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月21日
 */
public interface CardBinDao {

	public void save(CardBinEntity cardBin);

	public void update(CardBinEntity cardBin, Long id);

	public CardBinEntity findById(Long id);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

}
