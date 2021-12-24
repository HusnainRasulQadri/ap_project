package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.JobDescription;

public class Test1 {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		JobDescription jobDesc = new JobDescription(); 
		jobDesc.setMinimumEducation("BSC");
		jobDesc.setRequiredDomainKnowledge("Java");
		jobDesc.setSkillsNeeded("Algorithms");
		Assert.assertEquals("BSC",jobDesc.getMinimumEducation());
		Assert.assertEquals("Java", jobDesc.getRequiredDomainKnowledge());
		Assert.assertEquals("Algorithms", jobDesc.getSkillsNeeded());
	}

}
