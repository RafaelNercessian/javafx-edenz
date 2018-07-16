package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.StudentDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void register(ActionEvent event){
		Student student = new Student(studentName.getText(), subject.getText(), grade.getText());
		StudentDao.register(student);
	}

}
