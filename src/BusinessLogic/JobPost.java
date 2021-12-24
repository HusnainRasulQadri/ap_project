package BusinessLogic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Services.PersistenceFactory;
import Services.PersistenceHandler;

@Entity
@Table(name = "JOB_POST")
public class JobPost {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "JOB_POST_ID")
	private int jobPostId;
	@Column(name = "VACANCIES")
	private int vacancies;
	@Column(name = "DEADLINE")
	private LocalDate deadline;
	@Column(name = "STATUS")
	private String status;
	@OneToOne
	private Job job;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "JOB_APPLICATIONS", joinColumns = @JoinColumn(name = "JOB_POST_ID"),
			   inverseJoinColumns = @JoinColumn(name = "APPLICATION_ID")
	)
	private List<Application> applications = new ArrayList<Application>();
	
	public JobPost() {
		vacancies = 0;
		deadline = null;
		status = null;
		job = new Job();
	}
	
	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getVacancies() {
		return vacancies;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public String getStatus() {
		return status;
	}
	public Job getJob() {
		return job;
	}
	public int getJobPostId() {
		return jobPostId;
	}
	
	public List<Application> getApplications() {
		List<Application> pendingApplications = new ArrayList<Application>();
		for (int i = 0; i < applications.size(); i++) {
			String status = applications.get(i).getCurrentStatus();
			if (status.equals("Pending")) {
				pendingApplications.add(applications.get(i));
			}
		}
		return pendingApplications;
	}
	
	public List<Application> getShortlistedApplications() {
		List<Application> shortlistedApplications = new ArrayList<Application>();
		for (int i = 0; i < applications.size(); i++) {
			String status = applications.get(i).getCurrentStatus();
			if (status.equals("Shortlisted")) {
				shortlistedApplications.add(applications.get(i));
			}
		}
		return shortlistedApplications;
	}
	
	public boolean populate(String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge) {
		return job.populate(title, salary, department, category, minEducation, skills, domainKnowledge);
	}
	
	public boolean populate(LocalDate deadline, int vacancies, String status) {
		setVacancies(vacancies);
		setDeadline(deadline);
		setStatus(status);
		return true;
	}
	
	public boolean addApplication(Application app) {
		return applications.add(app);
	}
	
	public boolean setShortlistStatus(Application application, String shortlistStatus) {
		return application.setStatus(shortlistStatus);
	}
	
	public String getDepartment() {
		return job.getDepartment();
	}
}
