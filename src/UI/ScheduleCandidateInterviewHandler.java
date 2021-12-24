package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ScheduleCandidateInterviewHandler {
	
	private RecruitmentOffice controller;
	private Scene hiringManagerMainMenuScene;

	
	public void setHiringManagerMainMenuScene(Scene hiringManagerMainMenuScene) {
		this.hiringManagerMainMenuScene = hiringManagerMainMenuScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}
	
	@FXML
	public void clickOnBack(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(hiringManagerMainMenuScene);
	}
	
	@FXML
	public void clickOnSearch(MouseEvent actionEvent) {
		
	}

}
