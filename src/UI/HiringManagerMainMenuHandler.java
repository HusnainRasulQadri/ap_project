package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HiringManagerMainMenuHandler {
	
	private RecruitmentOffice controller;
	private Scene loginScreenScene;
	private Scene modifyInformationScene;
	private Scene modifyCredentialsScene;
	private Scene scheduleCandidateInterviewScene;
	private Scene selectCandidateScene;
	private ModifyInformationHandler modifyIH;
	private ModifyCredentialsHandler modifyCH;
	
	
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

	public void setScheduleCandidateInterviewScene(Scene scheduleCandidateInterviewScene) {
		this.scheduleCandidateInterviewScene = scheduleCandidateInterviewScene;
	}

	public void setSelectCandidateScene(Scene selectCandidateScene) {
		this.selectCandidateScene = selectCandidateScene;
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
		modifyIH.setStatusStore(3);
		HiringManager manager = controller.getHiringManager();
		modifyIH.setInformationScene(String.valueOf(manager.getID()), manager.getName(), manager.getCNIC(), manager.getContactInformation().getAddress(), manager.getContactInformation().getPhoneNumber(),manager.getContactInformation().getEmail(), manager.getGender(), manager.getDate());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyInformationScene);
	}
	
	@FXML
	public void clickOnCredentials(MouseEvent actionEvent) {
		modifyCH.setStatusStore(3);
		modifyCH.setCredentialsScene(controller.getHiringManager().getCredentials().getUsername());
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyCredentialsScene);
	}
	
	@FXML
	public void scheduleCandidateInterview(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(scheduleCandidateInterviewScene);
	}
	
	@FXML
	public void selectCandidates(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(selectCandidateScene);
	}
}

