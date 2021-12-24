package BusinessLogic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import Services.PersistenceFactory;
import Services.PersistenceHandler;

@Entity
@Table(name = "JOB_TABLE")
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "JOB_ID")
	private int jobId;
	@Column(name = "TITLE", length = 30)
	private String title;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "DEPARTMENT", length = 30)
	private String department;
	@Column(name = "CATEGORY", length = 30)
	private String category;
	@OneToOne(cascade = CascadeType.ALL) // Mapping will be automatically done
	private JobDescription jobDesc;
	
	public Job() {
		title = null;
		salary = 0;
		department = null;
		category = null;
		jobDesc = new JobDescription();
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setJobDescription(JobDescription jobDesc) {
		this.jobDesc = jobDesc;
	}
	
	public String getTitle() {
		return title;
	}
	public int getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	public String getCategory() {
		return category;
	}
	public JobDescription getJobDescription() {
		return jobDesc;
	}
	public int getJobId() {
		return jobId;
	}
	
	public boolean populate(String title, int salary, String department, String category, String minEducation, String skills, String domainKnowledge) {
		setTitle(title);
		setSalary(salary);
		setDepartment(department);
		setCategory(category);
		return jobDesc.populate(minEducation, skills, domainKnowledge);
	}
}
