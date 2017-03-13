package net.lnk.spring.boot.common.util;

/**
 * @author Ben
 * @memo 2017年2月22日
 */
public enum CardType {

	UNKNOWN(0, "未知"),
	DEBIT_CARD(1, "借记卡"), 
	CREDIT_CARD(2, "贷记卡"), 
	PREPAID_CARD(3, "预付费卡");

	private CardType(int type, String description) {
		this.setType(type);
		this.setDescription(description);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private int type;
	private String description;
}
