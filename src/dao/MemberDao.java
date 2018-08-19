package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Member;
import utility.Conversion;

public class MemberDao {
	private Connection con;

	public MemberDao(Connection con) {
		super();
		this.con = con;
	}

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
			pst.setDate(5, Conversion.convertCalendarToDate(member.getRegistrationDate()));

			pst.executeUpdate();

		} finally {
			if (pst != null) {
				pst.close();
			}
		}

	}
}
