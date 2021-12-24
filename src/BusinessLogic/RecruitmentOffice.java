package BusinessLogic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Services.PersistenceFactory;
import Services.PersistenceHandler;

public class RecruitmentOffice {
	private List<Candidate> candList = new ArrayList<Candidate>();
	private Candidate cand;
	private HiringManager hiringManager;
	private Recruiter recruiter;
	private JobPostings postings;
	
	public RecruitmentOffice() {
		cand = null;
		hiringManager = null;
		recruiter = null;
		postings = new JobPostings();
	}
	
	public int login(String user, String password) {
		PersistenceHandler p = PersistenceFactory.getInstance().createPersistenceHandler();
		return p.login(user, password);
	}
	
	public List<Candidate> getCandidatesList() {
		return candList;
	}
	public Candidate getCandidate() {
		return cand;
	}
	public HiringManager getHiringManager() {
		return hiringManager;
	}
	public Recruiter getRecruiter() {
		return recruiter;
	}
	public JobPostings getJobPostings() {
		return postings;
	}
	
	// Register Candidate
	public boolean registerCandidate() {
		if ( (cand = new Candidate() ) != null) {
			return true;
		}
		return false;
	}
	
	public boolean enterPersonalInformation(String name, LocalDate dob, String gender, String cnic, String email, String phoneNumber, String address) {
		return cand.populate(name, dob, gender, cnic, email, phoneNumber, address);
	}
	
	public boolean enterCredentials(String username, String password) {
		if (cand.populate(username, password)) {
			candList.add(cand);
			PersistenceHandler dbService = PersistenceFactory.getInstance().createPersistenceHandler();
			dbService.save(cand);
			cand = null;
			return true;
		}
		return false;
	}
	
	// Manage Profile
	public Candidate manageProfile() {
		return cand;
	}
	
	public boolean updateDetails(String name, LocalDate date, String gender, String cnic, String email, String phoneNumber, String address, String username, String password) {
		if (cand.populate(username, date, gender, cnic, email, phoneNumber, address)) {
			return cand.populate(username, password);
		}
		return false;
	}
	
	// Search for Job
	public List<JobPost> searchForJob() {
		return postings.getJobPosts();
	}
	
	public JobPost selectJobPost(int index) { // should handle ArrayIndexOutOfBounds exception
		return postings.getJobPost(index);
	}
	
	// Apply for Job
	public Application applyForJob(JobPost jobPost) {
		return cand.createApplication(jobPost);
	}
	
	public boolean uploadResume(Application app, byte[] resume) {
		return cand.uploadResume(app, resume);
	}
	
	public boolean uploadCoverLetter(Application app, byte[] coverLetter, JobPost jobPost) {
		cand.uploadCoverLetter(app, coverLetter);
		return postings.addApplication(app, jobPost);
	}
	
	// Post new Job
	public JobPost postNewJob() {
		return postings.postNewJob();
	}
	
	public boolean enterJobDetails(JobPost jobPost, String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge) {
		return postings.populate(jobPost, title, salary, department, category, minEducation, skills, domainKnowledge);
	}
	
	public boolean enterPostDetails(JobPost jobPost, LocalDate date, int vacancies, String status) {
		return postings.populate(jobPost, date, vacancies, status);
	}
	
	// Modify Job
	public boolean modifyJob(JobPost jobPost, String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge, LocalDate date, int vacancies, String status) {
		return postings.update(jobPost, title, salary, department, category, minEducation, skills, domainKnowledge, date, vacancies, status);
	}
	
	// Shortlist Candidate
	public List<Application> shortlistCandidate(JobPost jobPost) {
		return postings.getApplications(jobPost);
	}
	
	public Candidate candidateToShortlist(Application app) {
		for (int i = 0; i < candList.size(); i++) {
			List<Application> appList = candList.get(i).getApplicationsList();
			for (int j = 0; j < appList.size(); j++) {
				if (appList.get(j).equals(app)) {
					return candList.get(i);
				}
			}
		}
		return null;
	}
	
	public boolean shortlistForInterview(Application application, String status) {
		return postings.setShortlistStatus(application, status);
	}
	
	// Schedule Interview
	public List<Application> scheduleInterview() {
		String dept = hiringManager.getDepartment();
		return postings.getShortlistedApplications(dept);
	}
	
	public Interview candidateToInterview(Application application) {
		return hiringManager.createInterview(application);
	}
	
	public boolean addDateAndMinutes(Interview interview, LocalDateTime dateTime, String minutes) {
		return hiringManager.addDateAndMinutes(interview, dateTime, minutes);
	}
	
	// Select Candidate
	public List<Interview> selectCandidate() {
		return hiringManager.getInterviews();
	}
	
	public boolean addRemarks(Interview interview, String remarks) {
		return hiringManager.setRemarks(interview, remarks);
	}
	
	public boolean confirmSelection(Interview interview, String status) {
		return hiringManager.setSelectionStatus(interview, status);
	}
}
