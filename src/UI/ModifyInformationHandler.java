package UI;


import java.time.LocalDate;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyInformationHandler {
	
	private RecruitmentOffice controller;
	private Scene candidateMainMenuScene;
	private Scene recruiterMainMenuScene;
	private Scene hiringManagerMainMenuScene;
	private int statusStore;
	private String gen;

	@FXML private Label id;
	@FXML private TextField name;
	@FXML private TextField cnic;
	@FXML private TextField address;
	@FXML private TextField phoneNumber;
	@FXML private TextField email;
	@FXML private DatePicker dob;
	@FXML CheckBox male;
	@FXML CheckBox female;
	
	
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
	
	public void setInformationScene(String id, String name, String cnic, String address, String phoneNumber, String email, String gender, LocalDate date) {
		this.gen = gender;
		this.id.setText(id);
		this.name.setText(name);
		this.cnic.setText(cnic);
		this.address.setText(address);
		this.phoneNumber.setText(phoneNumber);
		this.email.setText(email);
		this.dob.setValue(date);
		if(gender.equals("male")) {
			this.male.setSelected(true);
			this.female.setSelected(false);
		}
		else {
			this.female.setSelected(true);
			this.male.setSelected(false);
		}
	}
	
	@FXML
	public void clickOnSave(MouseEvent actionEvent) {
		boolean temp = false;
		if(statusStore == 1)
			temp = controller.getCandidate().populate(name.getText(), dob.getValue(), gen, cnic.getText(), email.getText(), phoneNumber.getText(), address.getText());
		else if(statusStore == 2)
			temp = controller.getRecruiter().populate(name.getText(), dob.getValue(), gen, cnic.getText(), email.getText(), phoneNumber.getText(), address.getText());
		else if(statusStore == 3)
			temp = controller.getHiringManager().populate(name.getText(), dob.getValue(), gen, cnic.getText(), email.getText(), phoneNumber.getText(), address.getText());
		if(temp) {
			//do something later
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
	}
	
	@FXML
	public void clickOnMale(MouseEvent actionEvent) {
		if(male.isSelected()) {
			gen = "male";
			female.setSelected(false);
		}
	}
	
	@FXML
	public void clickOnFemale(MouseEvent actionEvent) {
		if(female.isSelected()) {
			gen = "female";
			male.setSelected(false);
		}
	}
}
