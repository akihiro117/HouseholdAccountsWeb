//Member.java
//Created by Akihiro Yamada on 2018/07/30.
//Copyright (c) 2018. All Rights Reserved.

package entity;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 会員情報を保持するクラス
 *
 */
public class Member {
	private int id; //DBで自動採番される
	private String name;
	private String password;
	private Calendar registrationDate;
	private String email;
	private int balance;
	private ArrayList<ExchangeLog> exchangeLogsList;

	//会員登録をするときに使う
	public Member(String name, String password, Calendar registrationDate,
			String email, int balance) {
		super();
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.email = email;
		this.balance = balance;
	}

	//membersテーブルから会員情報を取得する際に使用する
	public Member(int id, String name, String password,
			Calendar registrationDate,
			String email, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.email = email;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public ArrayList<ExchangeLog> getExchangeLogsList() {
		return exchangeLogsList;
	}

	public void setExchangeLogsList(ArrayList<ExchangeLog> exchangeLogsList) {
		this.exchangeLogsList = exchangeLogsList;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", password=" + password + ", email="
				+ email + "]";
	}
}
