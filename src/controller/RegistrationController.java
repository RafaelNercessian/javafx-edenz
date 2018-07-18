package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import dao.ConnectionManager;
import dao.StudentDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;

public class RegistrationController implements Initializable {

	@FXML
	private TextField studentName;

	@FXML
	private TextField subject;

	@FXML
	private TextField grade;

	@FXML
	private Button registerButton;

	@FXML
	private TableView<Student> table;

	@FXML
	private TableColumn<Student, String> tableColumnStudent;

	@FXML
	private TableColumn<Student, String> tableColumnSubject;

	@FXML
	private TableColumn<Student, String> tableColumnGrade;

	private ObservableList<Student> data = FXCollections.observableArrayList();;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Connection connection = ConnectionManager.getConnection();
			String sql = "SELECT * from student";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				data.add(new Student(rs.getString("name"), rs.getString("subject"), rs.getString("grade")));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		tableColumnStudent.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
		tableColumnGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
		table.setItems(data);
	}

	@FXML
	public void register(ActionEvent event) {
		Student student = new Student(studentName.getText(), subject.getText(), grade.getText());
		StudentDao.register(student);
		table.refresh();
		data.add(student);
		table.setItems(data);
	}

}
