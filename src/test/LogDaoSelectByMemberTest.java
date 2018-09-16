//LogDaoSelectByMemberTest.java
//Created by Akihiro Yamada on 2018/09/14.
//Copyright (c) 2018. All Rights Reserved.

package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.LogDao;
import entity.ExchangeLog;
import utility.ConnectionOperator;

/**
 *LogDaoのselectByMemberTest()メソッドをテストする
 *
 */
public class LogDaoSelectByMemberTest {

	/**
	 *
	 * logDaoのselectLogByMemberを使って
	 * excange_logテーブルからデータを取得し、
	 * それを標準出力に出力する。
	 * 取得したデータが空の時はlog size is zeroと表示する
	 */
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionOperator.getConnection();
			con.setAutoCommit(false);

			LogDao logDao = new LogDao(con);

			//member_idが1のデータを取得する
			List<ExchangeLog> log = logDao.selectLogByMember(1);
			if (log.size() == 0) {
				System.out.println("log size is zero.");
			}
			for (ExchangeLog l : log) {
				System.out.println(l);
			}
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
