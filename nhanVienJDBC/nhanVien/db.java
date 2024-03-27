package nhanVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
	public static Connection con = null; 
	private static db instance = new db();
	public static db getInstance() {
		return instance;
	}
	public Connection getConnection() {
		return con;
	}
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=LopHoc";
		String user = "sa";
		String password = "123";
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
