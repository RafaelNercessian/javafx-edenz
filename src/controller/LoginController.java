package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.RegistrationApp;
import dao.LoginDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@FXML
	private TextField login;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button button;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void loginAction(ActionEvent event){
		try {
			if(LoginDao.login(login.getText(), password.getText())){
				((Node)(event.getSource())).getScene().getWindow().hide();
				new RegistrationApp().start(new Stage());
			}
			else{
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Username and Password Is Not Correct");
				alert.show();			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
