package BusinessLogic;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RECRUITER")
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
public class Recruiter extends Employee {
	
	public Recruiter() {
		super();
	}
}
