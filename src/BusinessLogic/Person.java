package BusinessLogic;

import java.time.LocalDate;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@MappedSuperclass
@AttributeOverride(name = "contactInformation.phoneNumber", column = @Column(name = "PHONE_NUMBER", length = 20))
@AttributeOverride(name = "contactInformation.email", column = @Column(name = "EMAIL", length = 100))
@AttributeOverride(name = "contactInformation.address", column = @Column(name = "ADDRESS", length = 200))
@AttributeOverride(name = "credentials.username", column = @Column(name = "USERNAME", length = 30))
@AttributeOverride(name = "credentials.password", column = @Column(name = "PASSWORD", length = 30))
public class Person {
	protected String name;
	protected String gender;
	protected LocalDate dob;
	protected String cnic;
	@Transient
	@OneToOne(cascade = CascadeType.ALL)
	protected Credentials credentials;
	@Transient
	@OneToOne(cascade = CascadeType.ALL)
	protected ContactInformation contactInformation;
	
	public Person() {
		name = null;
		gender = null;
		dob = null;
		cnic = null;
		credentials = new Credentials();
		contactInformation = new ContactInformation();
	}
	
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public LocalDate getDate() {
		return dob;
	}
	public String getCNIC() {
		return cnic;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public ContactInformation getContactInformation() {
		return contactInformation;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDate(LocalDate dob) {
		this.dob = dob;
	}
	public void setCNIC(String cnic) {
		this.cnic = cnic;
	}
}
