package entity;

import java.util.Calendar;

//収支の履歴
public class ExchangeLog {
	private String exchangeId;
	private String userName;
	private int amount;
	private boolean isIncome;//収入->true, 支出->false
	private Calendar exchangeDate;

	public ExchangeLog(String exchangeId, String userName, int amount, boolean isIncome, Calendar exchangeDate) {
		super();
		this.exchangeId = exchangeId;
		this.userName = userName;
		this.amount = amount;
		this.isIncome = isIncome;
		this.exchangeDate = exchangeDate;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}

	public Calendar getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Calendar exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
}
