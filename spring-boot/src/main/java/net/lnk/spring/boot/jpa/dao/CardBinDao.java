package net.lnk.spring.boot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import net.lnk.spring.boot.jpa.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
public interface CardBinDao extends JpaRepository<CardBinEntity, Long>, JpaSpecificationExecutor<CardBinEntity> {

	public CardBinEntity findByPrimaryNo(String primaryCode);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

}
