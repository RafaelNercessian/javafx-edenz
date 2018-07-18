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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
	private TextField search;

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
		
		
		 FilteredList<Student> filteredData = new FilteredList<>(data, p -> true);
		 
		 search.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(student -> {
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                String lowerCaseFilter = newValue.toLowerCase();
	                System.out.println(lowerCaseFilter);

	                if (student.getName().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } else if (student.getName().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }
	                return false; // Does not match.
	            });
	        });
		 
		 // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<Student> sortedData = new SortedList<>(filteredData);

	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(table.comparatorProperty());
	        
	        table.setItems(sortedData);
	}

	@FXML
	public void register(ActionEvent event) {
		Student student = new Student(studentName.getText(), subject.getText(), grade.getText());
		StudentDao.register(student);
		studentName.setText("");
		subject.setText("");
		grade.setText("");
		table.refresh();
		data.add(student);
		table.setItems(data);
	}
	
}
