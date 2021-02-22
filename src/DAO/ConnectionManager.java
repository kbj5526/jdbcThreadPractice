package DAO;

import java.sql.*;

public class ConnectionManager {

	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String id = "hr";
	private static final String pw = "hr";

	// 클래스 초기화 블럭(한번만 실행됨,
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConnectionManager() {
		// TODO Auto-generated constructor stub

	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
