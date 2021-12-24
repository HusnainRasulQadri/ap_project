package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Application;
import BusinessLogic.Interview;
import BusinessLogic.Job;
import BusinessLogic.JobPost;
import junit.framework.Assert;

public class Test5 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			JobPost job = new JobPost();
			job.setDeadline(LocalDate.now());
		    Application app = new Application(job);
			job.setShortlistStatus(app, "Active");
//			System.out.println(System.getProperty("user.dir") + "\\src\\resume.txt");
//		    File resume = new File("\\src\\resume.txt");
//		    byte[] resumeByte = new byte[(int)resume.length()];
//		    FileInputStream fisresume = new FileInputStream(resume);
//		    File coverLetter = new File("\\src\\coverLetter.txt");
//		    byte[] coverLetterByte = new byte[(int)coverLetter.length()];
//		    FileInputStream fisCV = new FileInputStream(coverLetter);
//		    fisresume.read(resumeByte);
//		    fisCV.read(coverLetterByte);
//		    app.setResume(resumeByte);
//		    app.setCoverLetter(coverLetterByte);
		    
			Interview interview = new Interview(app);
			interview.setMinutes("minutes");
			interview.setSelectionStatus("Pending");
			interview.setRemarks("remarks");
			LocalDateTime now;
			interview.setDate(now = LocalDateTime.now());
			
			Assert.assertEquals(interview.getMinutes(), "minutes");
			Assert.assertEquals(interview.getRemarks(), "remarks");
			Assert.assertEquals(interview.getApplication(), app);
			Assert.assertEquals(interview.getDate(), now);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
