package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOperator {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		}
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/household_account"
						+ "?useSSL=false&useUnicode=true&characterEncoding=utf8",
				"userName", "password");
		return con;
	}
}
