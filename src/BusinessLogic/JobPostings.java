package BusinessLogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Services.PersistenceFactory;
import Services.PersistenceHandler;

@Entity
@Table(name = "JOB_POSTINGS")
public class JobPostings {
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "POSTINGS_JOBPOST", joinColumns = @JoinColumn(name = "POSTINGS"),
	   inverseJoinColumns = @JoinColumn(name = "JOB_POST_ID")
	)
	private List<JobPost> jobPostList = new ArrayList<JobPost>();
	
	public JobPostings() {
	}
	
	public List<JobPost> getJobPosts() {
		return jobPostList;
	}
	
	public JobPost getJobPost(int index) {
		return jobPostList.get(index);
	}
	
	public boolean addApplication(Application app, JobPost jobPost) {
		return jobPost.addApplication(app);
	}
	
	public JobPost postNewJob() {
		JobPost newJobPost = new JobPost();
		PersistenceHandler dbService = PersistenceFactory.getInstance().createPersistenceHandler();
		dbService.save(newJobPost);
		return newJobPost;
	}
	
	public boolean populate(JobPost jobPost, String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge) {
		return jobPost.populate(title, salary, department, category, minEducation, skills, domainKnowledge);
	}
	
	public boolean populate(JobPost jobPost, LocalDate date, int vacancies, String status) {
		jobPost.populate(date, vacancies, status);
		jobPostList.add(jobPost);
		return true;
	}
	
	public boolean update(JobPost jobPost, String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge, LocalDate date, int vacancies, String status) {
		jobPost.populate(title, salary, department, category, minEducation, skills, domainKnowledge);
		return jobPost.populate(date, vacancies, status);
	}
	
	public List<Application> getApplications(JobPost jobPost) {
		return jobPost.getApplications();
	}
	
	public boolean setShortlistStatus(Application application, String shortlistStatus) {
		for (int i = 0; i < jobPostList.size(); i++) {
			List<Application> appList = jobPostList.get(i).getApplications();
			for (int j = 0; j < appList.size(); j++) {
				if (appList.get(j).equals(application)) {
					return jobPostList.get(i).setShortlistStatus(application, shortlistStatus);
				}
			}
		}
		return false;
	}
	
	public List<Application> getShortlistedApplications(String dept) {
		List<Application> shortlistedApplications = new ArrayList<Application>();
		for (int i = 0; i < jobPostList.size(); i++) {
			String jobDept = jobPostList.get(i).getDepartment();
			if (dept.equals(jobDept)) {
				List<Application> applicationsToAdd = jobPostList.get(i).getShortlistedApplications();
				for (int j = 0; j < applicationsToAdd.size(); j++) {
					shortlistedApplications.add(applicationsToAdd.get(j));
				}
			}
		}
		return shortlistedApplications;
	}
}
