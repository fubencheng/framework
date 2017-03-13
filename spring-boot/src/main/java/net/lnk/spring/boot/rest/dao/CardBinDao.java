package net.lnk.spring.boot.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import net.lnk.spring.boot.rest.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
@RepositoryRestResource(path = "cardbin")
public interface CardBinDao extends JpaRepository<CardBinEntity, Long>, JpaSpecificationExecutor<CardBinEntity> {

	public CardBinEntity findByPrimaryNo(String primaryCode);

	public List<CardBinEntity> findByIssuerCode(String issuerCode);

	// 阻止通过rest调用误删数据
	@Override
	@RestResource(exported = false)
	public void delete(Long id);

}
