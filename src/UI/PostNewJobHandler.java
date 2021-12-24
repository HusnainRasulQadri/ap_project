package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PostNewJobHandler {
	
	private RecruitmentOffice controller;
	private Scene recruiterMainMenuScene;
	private JobPost jobPost;
	
	@FXML private TextField title;
	@FXML private TextField salary;
	@FXML private TextField department;
	@FXML private TextField category;
	@FXML private TextField vancancies;
	@FXML private TextField status;
	@FXML private TextField minEducation;
	@FXML private TextField skills;
	@FXML private TextField domainKnowledge;
	@FXML private DatePicker deadline;
	
	
	public void setJobPost(JobPost jobPost) {
		this.jobPost = jobPost;
	}
	
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
		title.setText(null);
		salary.setText(null);
		department.setText(null);
		category.setText(null);
		vancancies.setText(null);
		status.setText(null);
		minEducation.setText(null);
		skills.setText(null);
		domainKnowledge.setText(null);
		deadline.setValue(null);
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(recruiterMainMenuScene);
	}
	
	@FXML
	public void clickOnPost(MouseEvent actionEvent) {
		boolean temp = controller.enterJobDetails(jobPost, title.getText(), Integer.parseInt(salary.getText()), department.getText(), category.getText(), minEducation.getText(), skills.getText(), domainKnowledge.getText());
		boolean temp1 = false;
		if(temp) {
			temp1 = controller.enterPostDetails(jobPost, deadline.getValue(), Integer.parseInt(vancancies.getText()), status.getText());
			
		}
		if(temp1) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(recruiterMainMenuScene);
		}
		
	}
}
