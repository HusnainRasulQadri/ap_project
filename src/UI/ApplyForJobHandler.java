package UI;

import java.io.File;
import java.io.FileInputStream;

import BusinessLogic.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ApplyForJobHandler {
	
	private RecruitmentOffice controller;
	private File resume = null;
	private File coverLetter = null;
	private Scene selectedJobDetailsScene;
	private Application app;
	
	@FXML private Label cover;
	@FXML private Label res;
	
	public ApplyForJobHandler() {}
	
	public void setApplication(Application app) {
		this.app = app;
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
	public void clickOnCoverLetterUpload(MouseEvent actionEvent) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF File (Cover Letter)", "*.pdf"));
		File selectedFile = fc.showOpenDialog(null);
		if (selectedFile != null) {
			coverLetter = selectedFile;
			cover.setText(coverLetter.getName());
		} else {
			// throw error
		}
	}
	
	@FXML 
	public void clickOnResumeUpload(MouseEvent actionEvent){
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF File (Resume)", "*.pdf"));
		File selectedFile = fc.showOpenDialog(null);
		if (selectedFile != null) {
			resume = selectedFile;
			res.setText(resume.getName());
		} else {
			 // throw error
		}
	}
	
	@FXML
	public void clickOnApply(MouseEvent actionEvent) {
		if (resume != null && coverLetter != null) {
			byte[] resumeBytes = new byte[(int)resume.length()];
			byte[] coverLetterBytes = new byte[(int)coverLetter.length()];
			try {
				FileInputStream fisResume = new FileInputStream(resume);
				fisResume.read(resumeBytes);
				fisResume.close();
				FileInputStream fisCoverLetter = new FileInputStream(coverLetter);
				fisCoverLetter.read(coverLetterBytes);
				fisCoverLetter.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			app.setResume(resumeBytes);
			app.setCoverLetter(coverLetterBytes);
			Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
			primaryStage.setScene(selectedJobDetailsScene);
			// Set Application's resume and coverLetter attributes to the newly constructed ones
			// application.setResume(resumeBytes)
			// application.setCoverLetter(coverLetterBytes);
		}
	}
	
	@FXML
	public void clickOnBack(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(selectedJobDetailsScene);
	}	
	
}