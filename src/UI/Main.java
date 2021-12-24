package UI;

import BusinessLogic.RecruitmentOffice;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		RecruitmentOffice myOffice = new RecruitmentOffice();
		try {
			//Loading FXML files
			FXMLLoader applyForJobLoader = new FXMLLoader(getClass().getResource("ApplyForJob.fxml"));
			Parent applyForJob = applyForJobLoader.load();
			FXMLLoader candidateMainMenuLoader = new FXMLLoader(getClass().getResource("CandidateMainMenu.fxml"));
			Parent candidateMainMenu = candidateMainMenuLoader.load();
			FXMLLoader hiringManagerMainMenuLoader = new FXMLLoader(getClass().getResource("HiringManagerMainMenu.fxml"));
			Parent hiringManagerMainMenu = hiringManagerMainMenuLoader.load();
			FXMLLoader loginScreenLoader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
			Parent loginScreen = loginScreenLoader.load();
			FXMLLoader modifyCredentialsLoader = new FXMLLoader(getClass().getResource("ModifyCredentials.fxml"));
			Parent modifyCredentials = modifyCredentialsLoader.load();
			FXMLLoader modifyInformationLoader = new FXMLLoader(getClass().getResource("ModifyInformation.fxml"));
			Parent modifyInformation = modifyInformationLoader.load();
			FXMLLoader modifyJobLoader = new FXMLLoader(getClass().getResource("ModifyJob.fxml"));
			Parent modifyJob = modifyJobLoader.load();
			FXMLLoader postNewJobLoader = new FXMLLoader(getClass().getResource("PostNewJob.fxml"));
			Parent postNewJob = postNewJobLoader.load();
			FXMLLoader recruiterMainMenuLoader = new FXMLLoader(getClass().getResource("RecruiterMainMenu.fxml"));
			Parent recruiterMainMenu = recruiterMainMenuLoader.load();
			FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
			Parent register = registerLoader.load();
			FXMLLoader registerCredentialsLoader = new FXMLLoader(getClass().getResource("RegisterCredentials.fxml"));
			Parent registerCredentials = registerCredentialsLoader.load();
			FXMLLoader scheduleCandidateInterviewLoader = new FXMLLoader(getClass().getResource("ScheduleCandidateInterview.fxml"));
			Parent scheduleCandidateInterview = scheduleCandidateInterviewLoader.load();
			FXMLLoader searchForJobLoader = new FXMLLoader(getClass().getResource("SearchForJob.fxml"));
			Parent searchForJob = searchForJobLoader.load();
			FXMLLoader selectCandidateLoader = new FXMLLoader(getClass().getResource("SelectCandidate.fxml"));
			Parent selectCandidate = selectCandidateLoader.load();
			FXMLLoader selectedJobDetailsLoader = new FXMLLoader(getClass().getResource("SelectedJobDetails.fxml"));
			Parent selectedJobDetails = selectedJobDetailsLoader.load();
			FXMLLoader shortlistCandidatesLoader = new FXMLLoader(getClass().getResource("ShortlistCandidates.fxml"));
			Parent shortlistCandidates = shortlistCandidatesLoader.load();
			FXMLLoader jobPostsListLoader = new FXMLLoader(getClass().getResource("JobPostsList.fxml"));
			Parent jobPostsList = jobPostsListLoader.load();
			
			
			//Loading Scenes from Panes
			Scene applyForJobScene = new Scene(applyForJob,400,400);
			Scene candidateMainMenuScene = new Scene(candidateMainMenu,400,400);
			Scene hiringManagerMainMenuScene = new Scene(hiringManagerMainMenu,400,400);
			Scene loginScreenScene = new Scene(loginScreen,400,400);
			Scene modifyCredentialsScene = new Scene(modifyCredentials,400,400);
			Scene modifyInformationScene = new Scene(modifyInformation,400,400);
			Scene modifyJobScene = new Scene(modifyJob,400,400);
			Scene postNewJobScene = new Scene(postNewJob,400,400);
			Scene recruiterMainMenuScene = new Scene(recruiterMainMenu,400,400);
			Scene registerScene = new Scene(register,400,400);
			Scene registerCredentialsScene = new Scene(registerCredentials,400,400);
			Scene scheduleCandidateInterviewScene = new Scene(scheduleCandidateInterview,400,400);
			Scene searchForJobScene = new Scene(searchForJob,400,400);
			Scene selectCandidateScene = new Scene(selectCandidate,400,400);
			Scene selectedJobDetailsScene = new Scene(selectedJobDetails,400,400);
			Scene shortlistCandidatesScene = new Scene(shortlistCandidates,400,400);
			Scene jobPostsListScene = new Scene(jobPostsList,400,400);
			
			//injecting scenes into controllers
			LoginScreenHandler loginH = (LoginScreenHandler) loginScreenLoader.getController();
			loginH.setCandidateMainMenuScene(candidateMainMenuScene);
			loginH.setHiringManagerMainMenuScene(hiringManagerMainMenuScene);
			loginH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			loginH.setRegisterScene(registerScene);
			loginH.setController(myOffice);
			
			RegisterHandler registerH = (RegisterHandler) registerLoader.getController();
			registerH.setRegisterCredentials(registerCredentialsScene);
			registerH.setController(myOffice);
			
			RegisterCredentialsHandler regCreH = (RegisterCredentialsHandler) registerCredentialsLoader.getController();
			regCreH.setLoginScene(loginScreenScene);
			regCreH.setController(myOffice);
			
			CandidateMainMenuHandler candH = (CandidateMainMenuHandler) candidateMainMenuLoader.getController();
			candH.setLoginScreenScene(loginScreenScene);
			candH.setSearchForJobScene(searchForJobScene);
			candH.setModifyCredentialsScene(modifyCredentialsScene);
			candH.setModifyInformationScene(modifyInformationScene);
			candH.setController(myOffice);
			
			HiringManagerMainMenuHandler hiringMH = (HiringManagerMainMenuHandler) hiringManagerMainMenuLoader.getController();
			hiringMH.setLoginScreenScene(loginScreenScene);
			hiringMH.setModifyCredentialsScene(modifyCredentialsScene);
			hiringMH.setModifyInformationScene(modifyInformationScene);
			hiringMH.setScheduleCandidateInterviewScene(scheduleCandidateInterviewScene);
			hiringMH.setSelectCandidateScene(selectCandidateScene);
			hiringMH.setController(myOffice);
			
			ModifyCredentialsHandler modCH = (ModifyCredentialsHandler) modifyCredentialsLoader.getController();
			modCH.setCandidateMainMenuScene(candidateMainMenuScene);
			modCH.setHiringManagerMainMenuScene(hiringManagerMainMenuScene);
			modCH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			modCH.setController(myOffice);
			
			ModifyInformationHandler modIH = (ModifyInformationHandler) modifyInformationLoader.getController();
			modIH.setCandidateMainMenuScene(candidateMainMenuScene);
			modIH.setHiringManagerMainMenuScene(hiringManagerMainMenuScene);
			modIH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			modIH.setController(myOffice);
			
			PostNewJobHandler postJH = (PostNewJobHandler) postNewJobLoader.getController();
			postJH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			postJH.setController(myOffice);
			
			JobPostsListHandler jobLH = (JobPostsListHandler) jobPostsListLoader.getController();
			jobLH.setModifyJobScene(modifyJobScene);
			jobLH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			jobLH.setController(myOffice);
			
			SelectedJobDetailsHandler selectedJDH = (SelectedJobDetailsHandler) selectedJobDetailsLoader.getController();
			selectedJDH.setApplyForJobScene(applyForJobScene);
			selectedJDH.setSearchForJobScene(searchForJobScene);
			selectedJDH.setController(myOffice);
			
			SearchForJobHandler searchJH = (SearchForJobHandler) searchForJobLoader.getController();
			searchJH.setCandidateMainMenuScene(candidateMainMenuScene);
			searchJH.setSelectedJobDetailsScene(selectedJobDetailsScene);
			searchJH.setController(myOffice);
			
			ShortlistCandidatesHandler shortLCH = (ShortlistCandidatesHandler) shortlistCandidatesLoader.getController();
			shortLCH.setRecruiterMainMenuScene(recruiterMainMenuScene);
			shortLCH.setController(myOffice);
			
			RecruiterMainMenuHandler recruiterH = (RecruiterMainMenuHandler) recruiterMainMenuLoader.getController();
			recruiterH.setJobPostsListScene(jobPostsListScene);
			recruiterH.setModifyCredentialsScene(modifyCredentialsScene);
			recruiterH.setModifyInformationSCene(modifyInformationScene);
			recruiterH.setPostNewJobScene(postNewJobScene);
			recruiterH.setShortlistCandidatesScene(shortlistCandidatesScene);
			recruiterH.setLoginScreeenScene(loginScreenScene);
			recruiterH.setController(myOffice);
			
			ModifyJobPostHandler modifyJPH = (ModifyJobPostHandler) modifyJobLoader.getController();
			modifyJPH.setModifyJobPostScene(jobPostsListScene);
			modifyJPH.setController(myOffice);
			
			ApplyForJobHandler applyFJH = (ApplyForJobHandler) applyForJobLoader.getController();
			applyFJH.setSelectedJobDetailsScene(selectedJobDetailsScene);
			applyFJH.setController(myOffice);
			
			SelectCandidateHandler selectCH = (SelectCandidateHandler) selectCandidateLoader.getController();
			selectCH.setHiringManagerMainMenuScene(hiringManagerMainMenuScene);
			selectCH.setController(myOffice);
			
			ScheduleCandidateInterviewHandler scheduleCIH = (ScheduleCandidateInterviewHandler) scheduleCandidateInterviewLoader.getController();
			scheduleCIH.setHiringManagerMainMenuScene(hiringManagerMainMenuScene);
			scheduleCIH.setController(myOffice);
			
			//sending the event handler details to candidate, recruiter and hiring manager to set the details
			candH.setModifyCH(modCH);
			candH.setModifyIH(modIH);
			recruiterH.setModifyCH(modCH);
			recruiterH.setModifyIH(modIH);
			hiringMH.setModifyCH(modCH);
			hiringMH.setModifyIH(modIH);
			recruiterH.setPostNewJobHandler(postJH);
			jobLH.setModifyJobPostHandler(modifyJPH);
			
			//initial scene
        	primaryStage.setTitle("Recruitment Application");
        	primaryStage.setScene(loginScreenScene);
        	primaryStage.setResizable(false);
        	primaryStage.show();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
