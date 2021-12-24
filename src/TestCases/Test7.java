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

public class Test7 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		JobPost job = new JobPost();
		job.setDeadline(LocalDate.now());
		job.setStatus("Active");
		job.setVacancies(4);
		
	    Application app = new Application(job);
		job.setShortlistStatus(app, "Pending");
	    
		Interview interview = new Interview(app);
		interview.setMinutes("minutes");
		interview.setSelectionStatus("Pending");
		interview.setRemarks("remarks");
		LocalDateTime now;
		interview.setDate(now = LocalDateTime.now());
		
		Recruiter recruiter = new Recruiter();
		recruiter.setCNIC("123456");
		LocalDate now2;
		recruiter.setDate(now2 = LocalDate.now());
		recruiter.setGender("Male");
		recruiter.setID(9211);
		recruiter.setName("Oheed");
		
		Assert.assertEquals(recruiter.getCNIC(), "123456");
		Assert.assertEquals(recruiter.getGender(), "Male");
		Assert.assertEquals(recruiter.getName(), "Oheed");
		
		//		fail("Not yet implemented");
	}

}
