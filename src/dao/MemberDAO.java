package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Member;
import utility.Conversion;

public class MemberDAO {
	private Connection con;

	public MemberDAO(Connection con) {
		super();
		this.con = con;
	}

	public void insert(Member member) throws SQLException {
		PreparedStatement pst = null;
		try {

			pst = con.prepareStatement("insert into members "
					+ "(id, name, password, email, balance, registration_date)"
					+ " values(?, ?, ?, ?, ?, ?)");
			pst.setString(1, member.getId());
			pst.setString(2, member.getName());
			pst.setString(3, member.getPassword());
			pst.setString(4, member.getEmail());
			pst.setInt(5, member.getBalance());
			pst.setDate(6, Conversion.convertCalendarToDate(member.getRegistrationDate()));

			pst.executeUpdate();

		} finally {
			if (pst != null) {
				pst.close();
			}
		}

	}
}
