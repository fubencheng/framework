package net.lnk.spring.boot.batch.vo;

/**
 * @author Ben
 * @memo 2017年2月24日
 */
public class CardBinVo {

	private String issuerName;

	private String cardName;

	private String forATM;

	private String forPOS;

	private String cardLength;

	private String cardNo;

	private String primaryLength;

	private String primaryNo;

	private String cardType;

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getForATM() {
		return forATM;
	}

	public void setForATM(String forATM) {
		this.forATM = forATM;
	}

	public String getForPOS() {
		return forPOS;
	}

	public void setForPOS(String forPOS) {
		this.forPOS = forPOS;
	}

	public String getCardLength() {
		return cardLength;
	}

	public void setCardLength(String cardLength) {
		this.cardLength = cardLength;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPrimaryLength() {
		return primaryLength;
	}

	public void setPrimaryLength(String primaryLength) {
		this.primaryLength = primaryLength;
	}

	public String getPrimaryNo() {
		return primaryNo;
	}

	public void setPrimaryNo(String primaryNo) {
		this.primaryNo = primaryNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
