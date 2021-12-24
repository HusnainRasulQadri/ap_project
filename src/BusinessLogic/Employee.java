package BusinessLogic;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Employee extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int employeeID;
	
	public Employee() {
		super();
		employeeID = 0;
	}
	
	public void setID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public int getID() {
		return employeeID;
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
}
