package net.lnk.spring.boot.jdbc.model;

import java.util.Date;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
public class CardBinEntity {

	private Long id;

	private String issuerName;

	private String issuerCode;

	private String cardName;

	private Integer forATM;

	private Integer forPOS;

	private Integer cardLength;

	private Integer primaryLength;

	private String primaryNo;

	private Integer cardType;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getIssuerCode() {
		return issuerCode;
	}

	public void setIssuerCode(String issuerCode) {
		this.issuerCode = issuerCode;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public Integer getForATM() {
		return forATM;
	}

	public void setForATM(Integer forATM) {
		this.forATM = forATM;
	}

	public Integer getForPOS() {
		return forPOS;
	}

	public void setForPOS(Integer forPOS) {
		this.forPOS = forPOS;
	}

	public Integer getCardLength() {
		return cardLength;
	}

	public void setCardLength(Integer cardLength) {
		this.cardLength = cardLength;
	}

	public Integer getPrimaryLength() {
		return primaryLength;
	}

	public void setPrimaryLength(Integer primaryLength) {
		this.primaryLength = primaryLength;
	}

	public String getPrimaryNo() {
		return primaryNo;
	}

	public void setPrimaryNo(String primaryNo) {
		this.primaryNo = primaryNo;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
