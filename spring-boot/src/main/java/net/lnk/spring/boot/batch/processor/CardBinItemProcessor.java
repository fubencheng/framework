package net.lnk.spring.boot.batch.processor;

import java.util.Date;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import net.lnk.spring.boot.batch.entity.CardBinEntity;
import net.lnk.spring.boot.batch.vo.CardBinVo;
import net.lnk.spring.boot.common.util.CardType;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
@Component
@StepScope
public class CardBinItemProcessor implements ItemProcessor<CardBinVo, CardBinEntity> {

	public CardBinEntity process(CardBinVo cardBinVo) throws Exception {
		CardBinEntity cardBin = new CardBinEntity();
		cardBin.setCardLength(Integer.parseInt(cardBinVo.getCardLength().trim()));
		if (cardBinVo.getCardName() != null && cardBinVo.getCardName().length() != 0) {
			cardBin.setCardName(cardBinVo.getCardName());
		}

		cardBin.setForATM(0);
		if (cardBinVo.getForATM() != null && cardBinVo.getForATM().length() != 0) {
			cardBin.setForATM(1);
		}

		cardBin.setForPOS(0);
		if (cardBinVo.getForPOS() != null && cardBinVo.getForPOS().length() != 0) {
			cardBin.setForPOS(1);
		}

		cardBin.setPrimaryLength(Integer.parseInt(cardBinVo.getPrimaryLength().trim()));
		cardBin.setPrimaryNo(cardBinVo.getPrimaryNo().trim());

		cardBin.setCardType(CardType.UNKNOWN.getType());
		if (CardType.DEBIT_CARD.getDescription().equals(cardBinVo.getCardType().trim())) {
			cardBin.setCardType(CardType.DEBIT_CARD.getType());
		}
		if (CardType.CREDIT_CARD.getDescription().equals(cardBinVo.getCardType().trim())) {
			cardBin.setCardType(CardType.CREDIT_CARD.getType());
		}
		if (CardType.PREPAID_CARD.getDescription().equals(cardBinVo.getCardType().trim())) {
			cardBin.setCardType(CardType.PREPAID_CARD.getType());
		}

		String issuerName = cardBinVo.getIssuerName().substring(0, cardBinVo.getIssuerName().lastIndexOf("("));
		cardBin.setIssuerName(issuerName);

		String issuerCode = cardBinVo.getIssuerName().substring(cardBinVo.getIssuerName().lastIndexOf("(") + 1,
				cardBinVo.getIssuerName().lastIndexOf(")"));
		cardBin.setIssuerCode(issuerCode);

		cardBin.setCreateTime(new Date());

		return cardBin;
	}

}
