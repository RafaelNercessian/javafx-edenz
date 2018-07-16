package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static String url = "jdbc:mysql://localhost:3306/javafx?&serverTimezone=UTC";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password = "";
	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				System.out.println(ex);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Driver not found.");
		}
		return connection;
	}

}
