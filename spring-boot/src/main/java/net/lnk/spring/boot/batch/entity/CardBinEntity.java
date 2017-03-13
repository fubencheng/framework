package net.lnk.spring.boot.batch.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ben
 * @memo 2017年2月19日
 */
@Entity
@Table(name = "t_card_bin")
public class CardBinEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "issuer_name")
	private String issuerName;

	@Column(name = "issuer_code")
	private String issuerCode;

	@Column(name = "card_name")
	private String cardName;

	@Column(name = "for_atm")
	private Integer forATM;

	@Column(name = "for_pos")
	private Integer forPOS;

	@Column(name = "card_length")
	private Integer cardLength;

	@Column(name = "primary_length")
	private Integer primaryLength;

	@Column(name = "primary_no")
	private String primaryNo;

	@Column(name = "card_type")
	private Integer cardType;

	@Column(name = "create_time")
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
