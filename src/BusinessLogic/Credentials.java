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
@Table(name = "CREDENTIALS")
public class Credentials {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int credentialsId;
	private String username;
	private String password;
	
	public Credentials() {
		username = null;
		password = null;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getCredentialsId() {
		return credentialsId;
	}
	
	public boolean populate(String username, String password) {
		if (username != null && password != null) {
			setUsername(username);
			setPassword(password);
			return true;
		}
		return false;
	}
}
