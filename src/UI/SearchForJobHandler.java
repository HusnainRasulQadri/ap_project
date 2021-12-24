package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchForJobHandler {
	
	private RecruitmentOffice controller;
	private Scene candidateMainMenuScene;
	private Scene selectedJobDetailsScene;	
	private SelectedJobDetailsHandler selectedJDH;
	
	
	public void setSelectedJobDetailsHandler(SelectedJobDetailsHandler selectedJDH) {
		this.selectedJDH = selectedJDH;
	}
	
	public void setCandidateMainMenuScene(Scene candidateMainMenuScene) {
		this.candidateMainMenuScene = candidateMainMenuScene;
	}

	public void setSelectedJobDetailsScene(Scene selectedJobDetailsScene) {
		this.selectedJobDetailsScene = selectedJobDetailsScene;
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
		primaryStage.setScene(candidateMainMenuScene);
	}
	
	@FXML
	public void clickOnJob(MouseEvent actionEvent) {
		//List<JobPost> jobPostList = controller.getJobPostings();
		//send the selected jobpost details
		//selectedJDH.setAttributes(null);
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(selectedJobDetailsScene);
	}
	
}
