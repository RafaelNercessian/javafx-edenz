package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;

public class StudentDao {
	
	public static void register(Student student){
		try {
			Connection connection = ConnectionManager.getConnection();
			String sql="INSERT INTO student(name, subject, grade) VALUES (?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, student.getName());
			prepareStatement.setString(2, student.getSubject());
			prepareStatement.setString(3, student.getGrade());
			prepareStatement.executeUpdate();
			prepareStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
