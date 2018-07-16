package application;
	
import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoginApp extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Login.fxml"));
			loader.setController(new LoginController());
			Pane root = loader.load();
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
