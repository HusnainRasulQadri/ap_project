package UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class JobPostsListHandler {

	private RecruitmentOffice controller;
	private Scene recruiterMainMenuScene;
	private Scene modifyJobScene;
	private ModifyJobPostHandler modifyJob;
	
	@FXML private TableView<JobPost> tableView;
    @FXML private TableColumn<JobPost, String> title;
    @FXML private TableColumn<JobPost, String> salary;
    @FXML private TableColumn<JobPost, String> vacancies;
    @FXML private TableColumn<JobPost, String> deadline;

	
	public void setModifyJobPostHandler(ModifyJobPostHandler modifyJob) {
		this.modifyJob = modifyJob;
	}
	
	public RecruitmentOffice getController() {
		return controller;
	}
	
	public void setController(RecruitmentOffice controller) {
		this.controller = controller;
	}
	
	public void setRecruiterMainMenuScene(Scene recruiterMainMenuScene) {
		this.recruiterMainMenuScene = recruiterMainMenuScene;
	}
	
	public void setModifyJobScene(Scene modifyJobScene) {
		this.modifyJobScene = modifyJobScene;
	}
	
	@FXML
    public void clickOnSearch(MouseEvent actionEvent) {
        title.setCellValueFactory(new PropertyValueFactory("title"));
        salary.setCellValueFactory(new PropertyValueFactory("salary"));
        vacancies.setCellValueFactory(new PropertyValueFactory("vacancies"));
        deadline.setCellValueFactory(new PropertyValueFactory("deadline"));
        
        tableView.setItems(getJobPosts());
    }
	
	public ObservableList<JobPost> getJobPosts() {
        ObservableList<JobPost> jobPosts = FXCollections.observableArrayList();
        JobPost j = new JobPost();
        j.populate(LocalDate.now(), 2, "Active");
        j.populate("Plumber", 20000, "Services", "Maintenance", "BS or School, IDK", "Just plumb?", "Can you plumb?");
        
        jobPosts.add(j);
        return jobPosts;
    }
    
	/*@FXML
	public void clickOnSearch(MouseEvent actionEvent) {
		//List<JobPost> jobPostings = controller.getJobPostings().getJobPosts();
		List<JobPost> tempPost = new ArrayList<JobPost>();
		JobPost j = new JobPost();
		j.populate(LocalDate.now(), 2, "Active");
		j.populate("Plumber", 20000, "Services", "Maintenance", "BS or School, IDK", "Just plumb?", "Can you plumb?");
		tempPost.add(j);
		list.addAll(tempPost);
		SortedList<JobPost> sortedJobPostings = new SortedList<>(list);
		sortedJobPostings.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sortedJobPostings);
	}*/
	
	@FXML
	public void clickOnBack(MouseEvent actionEvent) {
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(recruiterMainMenuScene);
	}
	
	@FXML
	public void cickOnListElements(MouseEvent actionEvent) {
		//By clicking the elements we get the jobPost and then send that attribute for modification
		//modifyJob.setJobPost(null);
		//send attributes of the jobPost for initial display
		
		Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
		primaryStage.setScene(modifyJobScene);
	}
	
}
