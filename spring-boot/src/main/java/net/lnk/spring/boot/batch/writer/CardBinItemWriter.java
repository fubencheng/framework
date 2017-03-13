package net.lnk.spring.boot.batch.writer;

import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.lnk.spring.boot.batch.entity.CardBinEntity;
import net.lnk.spring.boot.batch.service.CardBinService;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
@Component
@StepScope
public class CardBinItemWriter implements ItemWriter<CardBinEntity> {

	@Autowired
	private CardBinService cardBinService;

	public void write(List<? extends CardBinEntity> cardBins) throws Exception {
		cardBinService.save(cardBins);
	}

}
