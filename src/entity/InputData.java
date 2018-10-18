//InputData.java
//Created by Akihiro Yamada on 2018/10/14.
//Copyright (c) 2018. All Rights Reserved.

package entity;

/**
 * 入力された収支データ。
 *
 */
public class InputData {
	private int price;

	private String detail;

	private boolean isIncome;

	private int loginUserId;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean getIsIncome() {
		return isIncome;
	}

	public void setIsIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}

	public int getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(int loginUserId) {
		this.loginUserId = loginUserId;
	}

}
