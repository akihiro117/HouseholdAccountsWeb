//RegistExchangeDao.java
//Created by Akihiro Yamada on 2018/10/15.
//Copyright (c) 2018. All Rights Reserved.

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import entity.InputData;
import utility.Conversion;

/**
 * exchange_logテーブルを操作するためのDaoクラス。
 */
public class RegistExchangeDao {

	private Connection con;

	public RegistExchangeDao(Connection con) {
		this.con = con;
	}

	/**
	 * 収支履歴をexchange_logテーブルに登録する。
	 * @param inputData 入力された収支情報。
	 * @return テーブルに挿入した行数。
	 */
	public int insertExchange(InputData inputData) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(
					"insert into exchange_log(amount, exchange_date, isIncome,"
							+ "member_id, detail) values(?, ?, ?, ?, ?)");

			//システム日時を収支の日時とする。
			Calendar currentDate = Calendar.getInstance();

			pst.setInt(1, inputData.getPrice());
			pst.setDate(2, Conversion.convertCalendarToDate(currentDate));
			pst.setBoolean(3, inputData.getIsIncome());
			pst.setInt(4, inputData.getLoginUserId());
			pst.setString(5, inputData.getDetail());

			int insertedRows = pst.executeUpdate();

			return insertedRows;

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
	}

	/**
	 * membersテーブルの残高を更新する。
	 * @param id 会員ID。
	 * @param amount 金額。
	 * @param isIncome 収入か支出か。
	 * @return 更新した行数。
	 */
	public int updateBalnce(int id, int amount, boolean isIncome)
			throws SQLException {
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		try {
			pst1 = con.prepareStatement(
					"select balance from members where id = ?");
			pst1.setInt(1, id);

			//membersテーブルの残高を取得。
			ResultSet rs = pst1.executeQuery();

			int balance = 0;
			if (rs.next()) {
				balance = rs.getInt("balance");
			}

			if (isIncome) {
				balance += amount;
			} else {
				balance -= amount;
			}

			pst2 = con.prepareStatement(
					"update members set balance = ? where id = ?");
			pst2.setInt(1, balance);
			pst2.setInt(2, id);

			//membersテーブルの残高を更新。
			int updatedRows = pst2.executeUpdate();

			return updatedRows;

		} finally {
			if (pst1 != null) {
				pst1.close();
			}
			if (pst2 != null) {
				pst2.close();
			}
		}
	}
}
