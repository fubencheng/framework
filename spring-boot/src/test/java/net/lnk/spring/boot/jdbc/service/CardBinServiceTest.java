package net.lnk.spring.boot.jdbc.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import net.lnk.spring.boot.common.util.CardType;
import net.lnk.spring.boot.jdbc.SpringBootJdbcApplication;
import net.lnk.spring.boot.jdbc.model.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月22日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootJdbcApplication.class })
public class CardBinServiceTest {

	@Autowired
	private CardBinService cardBinService;

	@Test
	public void testSave() {
		CardBinEntity cardBin = new CardBinEntity();
		cardBin.setIssuerName("中国银联支付标记");
		cardBin.setIssuerCode("00010030");
		cardBin.setCardName("中国银联移动支付标记化产品");
		cardBin.setForATM(1);
		cardBin.setForPOS(1);
		cardBin.setCardLength(16);
		cardBin.setPrimaryLength(7);
		cardBin.setPrimaryNo("6201361");
		cardBin.setCardType(CardType.PREPAID_CARD.getType());
		cardBinService.save(cardBin);

		System.err.println("New save card Bin id is : " + cardBin.getId());
	}

	@Test
	public void testFindById() {
		CardBinEntity cardBin = cardBinService.findById(1L);

		System.err.println(JSON.toJSONString(cardBin));
	}

	@Test
	public void testFindByIssuerCode() {
		List<CardBinEntity> cardBins = cardBinService.findByIssuerCode("00010030");

		System.err.println(JSON.toJSONString(cardBins));
	}

	@Test
	public void testUpdate() {
		CardBinEntity cardBin = new CardBinEntity();
		cardBin.setCardName("中国银联移动支付标记化产品");

		cardBinService.update(cardBin, 3L);
	}

}
