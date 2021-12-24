package BusinessLogic;

import java.time.LocalDate;
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
@Table(name = "CANDIDATE")
@AttributeOverride(name = "name", column = @Column(name = "CANDIDATE_NAME", length = 40))
@AttributeOverride(name = "gender", column = @Column(name = "GENDER", length = 20))
@AttributeOverride(name = "dob", column = @Column(name = "DOB", columnDefinition = "DATE"))
@AttributeOverride(name = "cnic", column = @Column(name = "CNIC", length = 30))
public class Candidate extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CANDIDATE_ID")
	private int candidateID;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CANDIDATE_APPLICATIONS", joinColumns = @JoinColumn(name = "CANDIDATE_ID"),
	   inverseJoinColumns = @JoinColumn(name = "APPLICATION_ID")
	)
	private List<Application> appList = new ArrayList<Application>();
	
	public Candidate() {
		super();
	}
	
	public void setID(int candidateID) {
		this.candidateID = candidateID;
	}
	
	public int getID() {
		return candidateID;
	}
	public List<Application> getApplicationsList() {
		return appList;
	}
	
	public boolean populate(String name, LocalDate dob, String gender, String cnic, String email, String phoneNumber, String address) {
		setName(name);
		setDate(dob);
		setGender(gender);
		setCNIC(cnic);
		return contactInformation.populate(email, phoneNumber, address);
	}
	
	public boolean populate(String username, String password) {
		return credentials.populate(username, password);
	}
	
	public Application createApplication(JobPost jobPost) {
		Application newApplication = new Application(jobPost);
		return newApplication;
	}
	
	public boolean uploadResume(Application app, byte[] resume) {
		return app.uploadResume(resume);
	}
	
	public boolean uploadCoverLetter(Application app, byte[] coverLetter) {
		app.uploadCoverLetter(coverLetter);
		return appList.add(app);
	}
}
