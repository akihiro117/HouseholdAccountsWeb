package entity;

import java.util.Calendar;

public class Member {
	private String id; //DBで自動採番される
	private String name;
	private String password;
	private Calendar registrationDate;
	private String email;
	private int balance;

	//入力フォームからデータを取得した際に使用する
	public Member(String name, String password, Calendar registrationDate, String email, int balance) {
		super();
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.email = email;
		this.balance = balance;
	}

	public Member(String id, String name, String password, Calendar registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	public Member(String id, String name, String password, Calendar registrationDate,
			String email, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.registrationDate = registrationDate;
		this.email = email;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "Member [name=" + name + ", password=" + password + ", email=" + email + "]";
	}
}
