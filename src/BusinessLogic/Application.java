package BusinessLogic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPLICATION")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "APPLICATION_ID")
	private int applicationId;
	@Lob
	@Column(name = "RESUME")
	private byte[] resume;
	@Lob
	@Column(name = "COVER_LETTER")
	private byte[] coverLetter;
	@OneToOne(cascade = CascadeType.ALL)
	private JobPost jobPost;
	@Column(name = "STATUS", length = 20)
	private String status;
	
	public Application(JobPost jobPost) {
		this.jobPost = jobPost;
		resume = null;
		coverLetter = null;
		status = "Pending";
	}
	
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public void setCoverLetter(byte[] coverLetter) {
		this.coverLetter = coverLetter;
	}
	public void setJob(JobPost jobPost) {
		this.jobPost = jobPost;
	}
	public void setCurrentStatus(String shortlistStatus) {
		this.status = shortlistStatus;
	}
	
	public byte[] getResumeByte() {
		return resume;
	}
	public byte[] getCoverLetterByte() {
		return coverLetter;
	}
	public JobPost getJobPost() {
		return jobPost;
	}
	public String getCurrentStatus() {
		return status;
	}
	public int getApplicationId() {
		return applicationId;
	}
	
	public boolean uploadResume(byte[] resume) {
		setResume(resume);
		return true;
	}
	
	public boolean uploadCoverLetter(byte[] coverLetter) {
		setCoverLetter(coverLetter);
		return true;
	}
	
	public boolean setStatus(String status) {
		setCurrentStatus(status);
		return true;
	}
}
