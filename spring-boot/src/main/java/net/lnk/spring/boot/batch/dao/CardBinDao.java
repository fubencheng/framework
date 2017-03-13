package net.lnk.spring.boot.batch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.lnk.spring.boot.batch.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
public interface CardBinDao extends JpaRepository<CardBinEntity, Long> {

	public CardBinEntity findByPrimaryNo(String primaryCode);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

}
