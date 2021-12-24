package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ShortlistCandidatesHandler {
	
	private RecruitmentOffice controller;
	private Scene recruiterMainMenuScene;
	
	
	public void setRecruiterMainMenuScene(Scene recruiterMainMenuScene) {
		this.recruiterMainMenuScene = recruiterMainMenuScene;
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
		primaryStage.setScene(recruiterMainMenuScene);
	}
	
	@FXML
	public void clickOnSearch(MouseEvent actionEvent) {
		
	}

}
