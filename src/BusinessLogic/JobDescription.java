package BusinessLogic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_DESCRIPTION")
public class JobDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "JOB_DESCRIPTION_ID")
	private int jobDescId;
	@Column(name = "MINIMUM_EDUCATION", length = 100)
	private String minimumEducation;
	@Column(name = "SKILLS_NEEDED", length = 100)
	private String skillsNeeded;
	@Column(name = "DOMAIN_KNOWLEDGE", length = 100)
	private String requiredDomainKnowledge;
	
	public JobDescription() {
		minimumEducation = null;
		skillsNeeded = null;
		requiredDomainKnowledge = null;
	}
	
	public void setMinimumEducation(String minimumEducation) {
		this.minimumEducation = minimumEducation;
	}
	public void setSkillsNeeded(String skillsNeeded) {
		this.skillsNeeded = skillsNeeded;
	}
	public void setRequiredDomainKnowledge(String requiredDomainKnowledge) {
		this.requiredDomainKnowledge = requiredDomainKnowledge;
	}
	
	public String getMinimumEducation() {
		return minimumEducation;
	}
	public String getSkillsNeeded() {
		return skillsNeeded;
	}
	public String getRequiredDomainKnowledge() {
		return requiredDomainKnowledge;
	}
	public int getJobDescriptionId() {
		return jobDescId;
	}

	public boolean populate(String minEducation, String skills, String domainKnowledge) {
		setMinimumEducation(minEducation);
		setSkillsNeeded(skills);
		setRequiredDomainKnowledge(domainKnowledge);
		return true;
	}
}
