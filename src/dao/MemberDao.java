//MemberDao.java
//Created by Akihiro Yamada on 2018/07/30.
//Copyright (c) 2018. All Rights Reserved.

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
