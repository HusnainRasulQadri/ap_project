package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Application;
import BusinessLogic.HiringManager;
import BusinessLogic.Interview;
import BusinessLogic.Job;
import junit.framework.Assert;

public class Test6 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Interview interview = new Interview(new Application(new JobPost()));
		interview.setDate(LocalDateTime.now());
		
		HiringManager manager = new HiringManager();
		manager.setCNIC("123456");
		manager.setDepartment("QA");
		LocalDate now2;
		manager.setDate(now2 = LocalDate.now());
		manager.setGender("Male");
		manager.setID(9211);
		manager.setRemarks(interview, "Remarks sent from Manager");
		manager.setSelectionStatus(interview, "selected");
		manager.setName("Oheed");
		manager.getContactInformation().setAddress("I-8");
		manager.getContactInformation().setEmail("Oheed@gmail.com");
		manager.getContactInformation().setPhoneNumber("9211129393");
		
		Assert.assertEquals(manager.getCNIC(), "123456");
		Assert.assertEquals(manager.getDepartment(), "QA");
		Assert.assertEquals(manager.getGender(), "Male");
		Assert.assertEquals(manager.getName(), "Oheed");
		Assert.assertEquals(manager.getContactInformation().getEmail(), "Oheed@gmail.com");
		Assert.assertEquals(manager.getContactInformation().getPhoneNumber(), "9211129393");
		Assert.assertEquals(manager.getContactInformation().getAddress(), "I-8");
		//fail("Not yet implemented");
	}

}
