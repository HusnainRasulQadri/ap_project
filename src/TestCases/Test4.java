package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Application;
import BusinessLogic.Candidate;
import BusinessLogic.Job;
import junit.framework.Assert;

public class Test4 {

	@Test
	public void test() {
		JobPost jobPost = new JobPost();
		jobPost.setDeadline(LocalDate.now());
		jobPost.setShortlistStatus(new Application(jobPost), "Pending");
		jobPost.setStatus("Submitted");
		jobPost.setVacancies(4);
		
		Candidate cand = new Candidate();
		cand.setID(9211);
		cand.setCNIC("123456");
		cand.setName("Faizan");
		LocalDate now;
		cand.setDate(now = LocalDate.now());
		cand.setGender("Male");
		Application app = cand.createApplication(jobPost);
		cand.uploadCoverLetter(app, null);
		
		Assert.assertEquals(cand.getCNIC(), "123456");
		Assert.assertEquals(cand.getGender(), "Male");
		Assert.assertEquals(cand.getID(), 9211);
		Assert.assertEquals(cand.getName(), "Faizan");
		Assert.assertEquals(cand.getApplicationsList().get(0), app);
		Assert.assertEquals(cand.getDate(), now);
	}

}
