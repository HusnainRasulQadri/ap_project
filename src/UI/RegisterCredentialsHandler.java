package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterCredentialsHandler {
	
	private RecruitmentOffice controller;
	private Scene loginScene;
	

	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField conPassword;
	@FXML private Label error;
	
	
		
	public void setLoginScene(Scene loginScene) {
		this.loginScene = loginScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}



	@FXML
	public void clickOnFinish(MouseEvent actionEvent) {
		if(!password.getText().equals(conPassword.getText())) {
			error.setText("Invalid Username/Password!");
		}
		else {
			if(controller.enterCredentials(username.getText(), password.getText())) {
				Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
				primaryStage.setScene(loginScene);
				username.setText("");
				password.setText("");
				conPassword.setText("");
				error.setText("");
			}
		}
	}
		
}
