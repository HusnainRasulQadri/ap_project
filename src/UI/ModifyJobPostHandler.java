package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyJobPostHandler {
	
	private RecruitmentOffice controller;
	private Scene modifyJobPostScene;
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
	
	public void setModifyJobPostScene(Scene modifyJobPostScene) {
		this.modifyJobPostScene = modifyJobPostScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}
	
	public void setAttributes() {
		title.setText(jobPost.getJob().getTitle());
		salary.setText(String.valueOf(jobPost.getJob().getSalary()));
		department.setText(jobPost.getDepartment());
		category.setText(jobPost.getJob().getCategory());
		vancancies.setText(String.valueOf(jobPost.getVacancies()));
		status.setText(jobPost.getStatus());
		minEducation.setText(jobPost.getJob().getJobDescription().getMinimumEducation());
		skills.setText(jobPost.getJob().getJobDescription().getSkillsNeeded());
		domainKnowledge.setText(jobPost.getJob().getJobDescription().getRequiredDomainKnowledge());
		deadline.setValue(jobPost.getDeadline());
	}

	@FXML 
	public void clickOnBack(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyJobPostScene);
	}
	
	@FXML
	public void clickOnUpdate(MouseEvent actionEvent) {
		boolean temp = controller.modifyJob(jobPost, title.getText(), Integer.parseInt(salary.getText()), department.getText(), category.getText(), minEducation.getText(), skills.getText(), domainKnowledge.getText(), deadline.getValue(), Integer.parseInt(vancancies.getText()), status.getText());
		if(temp) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(modifyJobPostScene);
		}
	}
}
