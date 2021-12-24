package UI;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RegisterHandler {	
	
	private String gen = "";
	private RecruitmentOffice controller;
	private Scene registerCredentials;

	@FXML private TextField name;
	@FXML private TextField cnic;
	@FXML private TextField address;
	@FXML private TextField phoneNumber;
	@FXML private TextField email;
	@FXML private DatePicker dob;
	@FXML private CheckBox male;
	@FXML private CheckBox female;	
	
	
	public void setRegisterCredentials(Scene registerCredentials) {
		this.registerCredentials = registerCredentials;
	}
	
	public RecruitmentOffice getController() {
		return controller;
	}

	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}

	@FXML
	public void maleChecked(MouseEvent actionEvent) {
		//if male checked is true change to false & viceversa
		if(male.isSelected()) {
			gen = "male";
			female.setSelected(false);
		}
	}
	
	@FXML 
	public void femaleChecked(MouseEvent  actionEvent) {
		//if female checked is true change to false & viceversa
		if(female.isSelected()) {
			gen = "female";
			male.setSelected(false);
		}
	}
	
	@FXML
	public void clickOnNext(MouseEvent actionEvent) {
		boolean status = controller.enterPersonalInformation(name.getText(), dob.getValue(), gen, cnic.getText(), email.getText(), phoneNumber.getText(), address.getText());
		if(status) {
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(registerCredentials);
			name.setText(null);
			dob.setValue(null);
			male.setSelected(false);
			female.setSelected(false);
			cnic.setText(null);
			email.setText(null);
			phoneNumber.setText(null);
			address.setText(null);
		}
	}
}
