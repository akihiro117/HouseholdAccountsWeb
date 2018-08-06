package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import dao.MemberDAO;
import entity.Member;
import utility.ConnectionOperator;

public class MemberDAOInsertTest {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionOperator.getConnection();
			con.setAutoCommit(false);
			MemberDAO memberDao = new MemberDAO(con);
			Member member = new Member("2", "aaa2", "bbb2", Calendar.getInstance(),
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