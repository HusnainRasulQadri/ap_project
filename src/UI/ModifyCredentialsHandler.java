package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyCredentialsHandler {
	
	private RecruitmentOffice controller;
	private Scene candidateMainMenuScene;
	private Scene recruiterMainMenuScene;
	private Scene hiringManagerMainMenuScene;
	private int statusStore;

	@FXML private Label username;
	@FXML private PasswordField currPassword;
	@FXML private PasswordField newPassword;
	@FXML private PasswordField confirmPassword;
	@FXML private Label error;
	
	public void setStatusStore(int statusStore) {
		this.statusStore = statusStore;
	}
	
	public void setCandidateMainMenuScene(Scene candidateMainMenuScene) {
		this.candidateMainMenuScene = candidateMainMenuScene;
	}

	public void setRecruiterMainMenuScene(Scene recruiterMainMenuScene) {
		this.recruiterMainMenuScene = recruiterMainMenuScene;
	}

	public void setHiringManagerMainMenuScene(Scene hiringManagerMainMenuScene) {
		this.hiringManagerMainMenuScene = hiringManagerMainMenuScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}
	
	public void setCredentialsScene(String username) {
		this.username.setText(username);
	}
	
	
	@FXML
	public void clickOnSave(MouseEvent actionEvent) {
		if(!newPassword.getText().equals(confirmPassword.getText())) {
			error.setText("Invalid Password!");
		}
		else {
			boolean temp = false;
			if (statusStore == 1)
				temp = controller.getCandidate().populate(username.getText(), newPassword.getText());
			else if(statusStore == 2)
				temp = controller.getRecruiter().populate(username.getText(), newPassword.getText());
			else if(statusStore == 3) {
				temp = controller.getHiringManager().populate(username.getText(), newPassword.getText());
			}
			if(temp) {
				error.setText("Password Updated Successfully!");
			}
		}
	}
	
	@FXML
	public void clickOnBack(MouseEvent actionEvent) {
		if(statusStore == 1) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(candidateMainMenuScene);
		}
		else if(statusStore == 2) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(recruiterMainMenuScene);
		}
		else if(statusStore == 3) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(hiringManagerMainMenuScene);
		}
		error.setText(null);
		currPassword.setText(null);
		newPassword.setText(null);
		confirmPassword.setText(null);
	}
	
}
