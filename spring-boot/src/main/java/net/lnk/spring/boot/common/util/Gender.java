package net.lnk.spring.boot.common.util;

/**
 * @author Ben
 * @memo 2017年3月1日
 */
public enum Gender {

	MALE(1, "男性"), 
	FEMALE(0, "女性");

	private int gender;
	private String description;

	private Gender(int gender, String description) {
		this.setGender(gender);
		this.setDescription(description);
	}

	public int getGender() {
		return gender;
	}

	private void setGender(int gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

}
