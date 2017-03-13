package net.lnk.spring.boot.jpa.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import net.lnk.spring.boot.jpa.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月23日
 */
public class CardBinSpecs {

	public static Specification<CardBinEntity> fromCardName(final String cardName) {

		return new Specification<CardBinEntity>() {

			@Override
			public Predicate toPredicate(Root<CardBinEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

				return cb.equal(root.get("cardName"), cardName);
			}
		};
	}

}
