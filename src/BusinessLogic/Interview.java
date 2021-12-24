package BusinessLogic;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVIEW")
public class Interview {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "INTERVIEW_ID")
	private int interviewId;
	@Column(name = "DATE_TIME", columnDefinition = "TIMESTAMP")
	private LocalDateTime dateTime;
	@Column(name = "MINUTES", length = 300)
	private String minutes;
	@Column(name = "REMARKS", length = 200)
	private String remarks;
	@OneToOne(cascade = CascadeType.ALL)
	private Application app;
	
	public Interview(Application app) {
		this.app = app;
		dateTime = null;
		minutes = null;
		remarks = null;
	}
	
	public void setDate(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public LocalDateTime getDate() {
		return dateTime;
	}
	public String getMinutes() {
		return minutes;
	}
	public Application getApplication() {
		return app;
	}
	public String getRemarks() {
		return remarks;
	}
	public int getInterviewId() {
		return interviewId;
	}
	
	public boolean addDateAndMinutes(LocalDateTime dateTime, String minutes) {
		if (dateTime != null && minutes != null) {
			setDate(dateTime);
			setMinutes(minutes);
			return true;
		}
		return false;
	}
	
	public boolean setSelectionStatus(String selectionStatus) {
		return app.setStatus(selectionStatus);
	}
}
