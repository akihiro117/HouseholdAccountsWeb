//LogDao.java
//Created by Akihiro Yamada on 2018/09/13.
//Copyright (c) 2018. All Rights Reserved.

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.ExchangeLog;
import utility.Conversion;

public class LogDao {
	private Connection con;

	public LogDao(Connection con) {
		this.con = con;
	}

	public List<ExchangeLog> selectLogByMember(int memberId)
			throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement("select amount, exchange_date, "
					+ "isIncome, detail from exchange_log where member_id=?");
			pst.setInt(1, memberId);

			ResultSet rs = pst.executeQuery();

			List<ExchangeLog> exchangeLog = new ArrayList<ExchangeLog>();
			while (rs.next()) {
				ExchangeLog log = new ExchangeLog();
				log.setAmount(rs.getInt("amount"));
				log.setExchangeDate(Conversion
						.convertDateToCalendar(rs.getDate("exchange_date")));
				log.setIsIncome(rs.getBoolean("isIncome"));
				log.setDetail(rs.getString("detail"));

				exchangeLog.add(log);
			}

			return exchangeLog;

		} finally {
			if (pst != null) {
				pst.close();
			}
		}

	}
}
