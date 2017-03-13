package net.lnk.spring.boot.jpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import net.lnk.spring.boot.common.util.CardType;
import net.lnk.spring.boot.jpa.SpringBootJpaApplication;
import net.lnk.spring.boot.jpa.entity.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月22日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootJpaApplication.class })
public class CardBinServiceTest {

	@Autowired
	private CardBinService cardBinService;

	@Test
	public void testSave() {
		CardBinEntity cardBin = new CardBinEntity();
		cardBin.setIssuerName("中国银联支付标记");
		cardBin.setIssuerCode("00010030");
		cardBin.setForATM(1);
		cardBin.setForPOS(1);
		cardBin.setCardLength(17);
		cardBin.setPrimaryLength(7);
		cardBin.setPrimaryNo("6201362");
		cardBin.setCardType(CardType.PREPAID_CARD.getType());
		cardBinService.save(cardBin);

		System.out.println(cardBin.getId());
	}

	@Test
	public void testFindById() {
		CardBinEntity cardBin = cardBinService.findById(1L);

		System.err.println(JSON.toJSONString(cardBin));
	}

	@Test
	public void testFindByPrimaryNo() {
		CardBinEntity cardBin = cardBinService.findByPrimaryNo("6201361");

		System.err.println(JSON.toJSONString(cardBin));
	}

	@Test
	public void testFindByIssuerCode() {
		List<CardBinEntity> cardBins = cardBinService.findByIssuerCode("00010030");

		System.err.println(JSON.toJSONString(cardBins));
	}

	@Test
	public void testFindByCardName() {
		List<CardBinEntity> cardBins = cardBinService.findByCardName("中国银联移动支付标记化产品");

		System.err.println(JSON.toJSONString(cardBins));
	}

}
