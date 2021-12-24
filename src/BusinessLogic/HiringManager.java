package BusinessLogic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HIRING_MANAGER")
@AttributeOverride(name = "name", column = @Column(name = "CAND_NAME", length = 40))
@AttributeOverride(name = "gender", column = @Column(name = "GENDER", length = 20))
@AttributeOverride(name = "dob", column = @Column(name = "DOB", columnDefinition = "DATE"))
@AttributeOverride(name = "cnic", column = @Column(name = "CNIC", length = 30))
@AttributeOverride(name = "employeeID", column = @Column(name = "EMP_ID"))
@AttributeOverride(name = "contactInformation.phoneNumber", column = @Column(name = "PHONE_NUMBER", length = 20))
@AttributeOverride(name = "contactInformation.email", column = @Column(name = "EMAIL", length = 100))
@AttributeOverride(name = "contactInformation.address", column = @Column(name = "ADDRESS", length = 200))
@AttributeOverride(name = "credentials.username", column = @Column(name = "USERNAME", length = 30))
@AttributeOverride(name = "credentials.password", column = @Column(name = "PASSWORD", length = 30))
public class HiringManager extends Employee {
	@Column(name = "DEPT")
	private String department;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MANAGER_INTERVIEWS", joinColumns = @JoinColumn(name = "EMP_ID"),
	   inverseJoinColumns = @JoinColumn(name = "INTERVIEW_ID")
	)
	private List<Interview> interviewList = new ArrayList<Interview>();
	
	public HiringManager() {
		super();
		department = null;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public List<Interview> getInterviews() {
		List<Interview> conductedInterviews = new ArrayList<Interview>();
		LocalDateTime now = LocalDateTime.now();
		for (int i = 0; i < interviewList.size(); i++) {
			if (now.isAfter(interviewList.get(i).getDate())) {
				conductedInterviews.add(interviewList.get(i));
			}
		}
		return conductedInterviews;
	}
	
	public Interview createInterview(Application application) {
		Interview newInterview = new Interview(application);
		return newInterview;
	}
	
	public boolean addDateAndMinutes(Interview interview, LocalDateTime dateTime, String minutes) {
		interview.setDate(dateTime);
		interview.setMinutes(minutes);
		return addInterview(interview);
	}
	
	public boolean addInterview(Interview interview) {
		return interviewList.add(interview);
	}
	
	public boolean setRemarks(Interview interview, String remarks) {
		interview.setRemarks(remarks);
		return true;
	}
	
	public boolean setSelectionStatus(Interview interview, String status) {
		return interview.setSelectionStatus(status);
	}
}
