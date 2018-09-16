//MemberDao.java
//Created by Akihiro Yamada on 2018/07/30.
//Copyright (c) 2018. All Rights Reserved.

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import entity.Member;
import utility.Conversion;

/**
 * membersテーブルへの操作を行うためのクラス
 *
 */
public class MemberDao {
	private Connection con;

	public MemberDao(Connection con) {
		super();
		this.con = con;
	}

	/**
	 * 引数として渡されたMemberオブジェクトに格納された
	 * 会員情報をmembersテーブルに挿入する
	 * @param member Member型のオブジェクトでフォームに入力された
	 * 会員情報が入っている
	 * @throws SQLException
	 */
	public void insert(Member member) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("insert into members "
					+ "(name, password, email, balance, registration_date)"
					+ " values(?, ?, ?, ?, ?)");
			pst.setString(1, member.getName());
			pst.setString(2, member.getPassword());
			pst.setString(3, member.getEmail());
			pst.setInt(4, member.getBalance());
			//登録日はjava.sql.Date型に変換して登録する
			pst.setDate(5, Conversion
					.convertCalendarToDate(member.getRegistrationDate()));

			pst.executeUpdate();

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
	}

	/**
	 * 引数で渡されたemailとパスワードの組をもつ会員情報をmembersテーブルから
	 * 取得し、Memberオブジェクトとして返す。
	 * @param emailParam ユーザがログインフォームに入力したメールアドレス
	 * @param passwordParam ユーザがログインフォームに入力したパスワード
	 * @return 引数で渡されたemailとパスワードの組がmembersテーブルに存在する場合は、
	 * その組に対応する会員情報をもつMemberオブジェクトを返す。
	 * 引数で渡されたemailとパスワードの組がmembersテーブルに存在しない場合は、
	 * nullを返す。
	 * @throws SQLException
	 */
	public Member selectMemberByParam(String emailParam, String passwordParam)
			throws SQLException {
		PreparedStatement pst = null;
		try {
			//変更し終わったらgit commitする
			pst = con.prepareStatement("select id, name, password, "
					+ "email, balance, registration_date from members "
					+ "where email = ? and password = ?");
			pst.setString(1, emailParam);
			pst.setString(2, passwordParam);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				Calendar registrationDate = Conversion.convertDateToCalendar(
						rs.getDate("registration_date"));
				String email = rs.getString("email");
				int balance = rs.getInt("balance");
				Member member = new Member(id, name, password, registrationDate,
						email, balance);
				return member;
			} else {
				//引数で渡されたemailとpasswordを持つ行がない場合は
				//nullを返す
				return null;
			}

		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {

			}
		}
	}
}
