package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CandidateMainMenuHandler {
	
	private RecruitmentOffice controller;
	private Scene modifyInformationScene;
	private Scene modifyCredentialsScene;
	private Scene searchForJobScene;
	private Scene loginScreenScene;
	private ModifyInformationHandler modifyIH;
	private ModifyCredentialsHandler modifyCH;
	
	public CandidateMainMenuHandler() {}

	public void setSearchForJobScene(Scene searchForJobScene) {
		this.searchForJobScene = searchForJobScene;
	}

	public void setModifyIH(ModifyInformationHandler modifyIH) {
		this.modifyIH = modifyIH;
	}

	public void setModifyCH(ModifyCredentialsHandler modifyCH) {
		this.modifyCH = modifyCH;
	}

	public void setLoginScreenScene(Scene loginScreenScene) {
		this.loginScreenScene = loginScreenScene;
	}

	public void setModifyInformationScene(Scene modifyInformationScene) {
		this.modifyInformationScene = modifyInformationScene;
	}

	public void setModifyCredentialsScene(Scene modifyCredentialsScene) {
		this.modifyCredentialsScene = modifyCredentialsScene;
	}

	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}

	@FXML
	public void clickOnLogout(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(loginScreenScene);
	}
	
	@FXML
	public void clickOnPersonalInformation(MouseEvent actionEvent) {
		modifyIH.setStatusStore(1);
		Candidate cand = controller.getCandidate();
		modifyIH.setInformationScene(String.valueOf(cand.getID()), cand.getName(), cand.getCNIC(), cand.getContactInformation().getAddress(), cand.getContactInformation().getPhoneNumber(), cand.getContactInformation().getEmail(), cand.getGender(), cand.getDate());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyInformationScene);
	}
	
	@FXML
	public void clickOnCredentials(MouseEvent actionEvent) {
		modifyCH.setStatusStore(1);
		modifyCH.setCredentialsScene(controller.getCandidate().getCredentials().getUsername());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyCredentialsScene);
	}
	
	@FXML
	public void clickOnSearchApplyJob(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(searchForJobScene);
	}
	
}
