//MemberDaoInsertTest.java
//Created by Akihiro Yamada on 2018/07/31.
//Copyright (c) 2018. All Rights Reserved.

package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import dao.MemberDao;
import entity.Member;
import utility.ConnectionOperator;

/**
 * MemberDaoクラスのinsert()メソッドのテストコード
 * これを実行した後に入力したデータがDBに反映されているかを確認する
 *
 */
public class MemberDaoInsertTest {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionOperator.getConnection();
			con.setAutoCommit(false);
			MemberDao memberDao = new MemberDao(con);
			//テストデータをmemberオブジェクトに入れる
			Member member = new Member("aaa4", "bbb3", Calendar.getInstance(),
					"xx--@gmail.com", 10000);
			memberDao.insert(member);
			con.commit();
		} catch (SQLException e1) {
			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e2) {

			}
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

			}
		}
	}

}
