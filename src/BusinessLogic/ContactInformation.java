package BusinessLogic;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "CONTACT_INFO")
public class ContactInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int contactId;
	protected String phoneNumber;
	protected String email;
	protected String address;
	
	public ContactInformation() {
		phoneNumber = null;
		email = null;
		address = null;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public int getContactId() {
		return contactId;
	}
	
	public boolean populate(String email, String phoneNumber, String address) {
		if (email != null && phoneNumber != null && address != null) {
			setPhoneNumber(phoneNumber);
			setEmail(email);
			setAddress(address);
			return true;
		}
		return false;
	}
}
