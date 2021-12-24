package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SelectedJobDetailsHandler {
	
	private RecruitmentOffice controller;
	private Scene applyForJobScene;
	private Scene searchForJobScene;
	private ApplyForJobHandler applyFJH;
	private JobPost job;
	
	@FXML private TextField title;
	@FXML private TextField salary;
	@FXML private TextField vacancies;
	@FXML private TextField department;
	@FXML private TextField category;
	@FXML private TextField minEducation;
	@FXML private TextField reqSkills;
	@FXML private TextField reqKnowledge;
	
	public void setApplyForJobHandler(ApplyForJobHandler applyFJH) {
		this.applyFJH = applyFJH;
	}
	
	public void setApplyForJobScene(Scene applyForJobScene) {
		this.applyForJobScene = applyForJobScene;
	}

	public void setSearchForJobScene(Scene searchForJobScene) {
		this.searchForJobScene = searchForJobScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}
	
	public void setAttributes(JobPost selectedJob) {
		this.job = selectedJob;
		title.setText(selectedJob.getJob().getTitle());
		salary.setText(String.valueOf(selectedJob.getJob().getSalary()));
		vacancies.setText(String.valueOf(selectedJob.getVacancies()));
		department.setText(selectedJob.getDepartment());
		category.setText(selectedJob.getJob().getCategory());
		minEducation.setText(selectedJob.getJob().getJobDescription().getMinimumEducation());
		reqSkills.setText(selectedJob.getJob().getJobDescription().getSkillsNeeded());
		reqKnowledge.setText(selectedJob.getJob().getJobDescription().getRequiredDomainKnowledge());
		
	}

	@FXML
	public void clickOnBack(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(searchForJobScene);	
	}
	
	@FXML 
	public void clickOnApply(MouseEvent actionEvent) {
		Application app = controller.applyForJob(job);
		applyFJH.setApplication(app);
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(applyForJobScene);
	}
}
