package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RecruiterMainMenuHandler {
	
	private RecruitmentOffice controller;
	private Scene modifyInformationSCene;
	private Scene modifyCredentialsScene;
	private Scene shortlistCandidatesScene;
	private Scene postNewJobScene;
	private Scene jobPostsListScene;
	private Scene loginScreeenScene;
	private ModifyInformationHandler modifyIH;
	private ModifyCredentialsHandler modifyCH;
	private PostNewJobHandler post;
	
	
	public void setPostNewJobHandler(PostNewJobHandler post) {
		this.post = post;
	}
	
	public void setModifyIH(ModifyInformationHandler modifyIH) {
		this.modifyIH = modifyIH;
	}

	public void setModifyCH(ModifyCredentialsHandler modifyCH) {
		this.modifyCH = modifyCH;
	}	
	
	public void setLoginScreeenScene(Scene loginScreeenScene) {
		this.loginScreeenScene = loginScreeenScene;
	}

	public void setModifyInformationSCene(Scene modifyInformationSCene) {
		this.modifyInformationSCene = modifyInformationSCene;
	}

	public void setModifyCredentialsScene(Scene modifyCredentialsScene) {
		this.modifyCredentialsScene = modifyCredentialsScene;
	}

	public void setShortlistCandidatesScene(Scene shortlistCandidatesScene) {
		this.shortlistCandidatesScene = shortlistCandidatesScene;
	}

	public void setPostNewJobScene(Scene postNewJobScene) {
		this.postNewJobScene = postNewJobScene;
	}

	public void setJobPostsListScene(Scene jobPostsListScene) {
		this.jobPostsListScene = jobPostsListScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}

	@FXML
	public void changePersonalInformation(MouseEvent actionEvent) {
		modifyIH.setStatusStore(2);
		Recruiter recruiter = controller.getRecruiter();
		modifyIH.setInformationScene(String.valueOf(recruiter.getID()), recruiter.getName(), recruiter.getCNIC(), recruiter.getContactInformation().getAddress(), recruiter.getContactInformation().getPhoneNumber(), recruiter.getContactInformation().getEmail(), recruiter.getGender(), recruiter.getDate());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyInformationSCene);
	}
	
	@FXML
	public void changeUsernamePassword(MouseEvent actionEvent) {
		modifyCH.setStatusStore(2);
		modifyCH.setCredentialsScene(controller.getCandidate().getCredentials().getUsername());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyCredentialsScene);
	}
	
	@FXML
	public void postNewJob(MouseEvent actionEvent) {
		JobPost jobPost = controller.postNewJob();
		post.setJobPost(jobPost);
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(postNewJobScene);
	}
	
	@FXML
	public void modifyJob(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(jobPostsListScene);
	}
	
	@FXML
	public void shortlistCandidate(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(shortlistCandidatesScene);
	}
	
	@FXML
	public void clickOnLogout(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(loginScreeenScene);
	}
}
