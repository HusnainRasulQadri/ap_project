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

public class LoginScreenHandler {
	
	private RecruitmentOffice controller;
	private Scene candidateMainMenuScene;
	private Scene hiringManagerMainMenuScene;
	private Scene recruiterMainMenuScene;
	private Scene registerScene;
	
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Label error;
	
	public void setRegisterScene(Scene registerScene) {
		this.registerScene = registerScene;
	}

	public void setHiringManagerMainMenuScene(Scene hiringManagerMainMenuScene) {
		this.hiringManagerMainMenuScene = hiringManagerMainMenuScene;
	}

	public void setRecruiterMainMenuScene(Scene recruiterMainMenuScene) {
		this.recruiterMainMenuScene = recruiterMainMenuScene;
	}

	public void setCandidateMainMenuScene(Scene candidateMainMenuScene) {
		this.candidateMainMenuScene = candidateMainMenuScene;
	}

	public void setUsername(TextField username) {
		this.username = username;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public void setError(Label error) {
		this.error = error;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}

	
	@FXML
	public void clickOnRegister(MouseEvent actionEvent) {
		if(controller.registerCandidate()) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(registerScene);
		}
		else {
			error.setText("Unable to Register!");
		}
	}
	
	@FXML
	public void clickOnSignIn(MouseEvent actionEvent) {
		int id = controller.login(username.getText(), password.getText());
		username.setText(null);
		password.setText(null);
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		if (id == 1)
			primaryStage.setScene(candidateMainMenuScene);
		else if (id == 2)
			primaryStage.setScene(recruiterMainMenuScene);
		else if (id == 3)
			primaryStage.setScene(hiringManagerMainMenuScene);
		else {
			// throw error
		}
	}
}
