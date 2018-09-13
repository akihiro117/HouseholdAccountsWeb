//ExchangeLog.java
//Created by Akihiro Yamada on 2018/07/30.
//Copyright (c) 2018. All Rights Reserved.

package entity;

import java.util.Calendar;

//収支の履歴
public class ExchangeLog {
	private String detail;//取引の内容
	private int amount;//支出したまたは得た金額
	private boolean isIncome;//収入->true, 支出->false
	private Calendar exchangeDate;//収入または支出の日付

	public ExchangeLog() {

	}

	public ExchangeLog(int amount, boolean isIncome, Calendar exchangeDate) {
		super();
		this.amount = amount;
		this.isIncome = isIncome;
		this.exchangeDate = exchangeDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isIncome() {
		return isIncome;
	}

	public void setIsIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}

	public Calendar getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Calendar exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
}
