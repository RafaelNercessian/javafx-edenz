package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	
	public static boolean login(String username, String password) throws SQLException{
		Connection connection = ConnectionManager.getConnection();
		String sql="SELECT * FROM users WHERE login=? AND password=?";
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, username);
		prepareStatement.setString(2, password);
		ResultSet resultSet = prepareStatement.executeQuery();
		return resultSet.first();
	}

}
