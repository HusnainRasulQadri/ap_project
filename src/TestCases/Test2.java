package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Job;

public class Test2 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Job job = new Job();
		job.setTitle("Software Engineer");
		job.setSalary(20000);
		job.setDepartment("QA");
		job.setCategory("Senior Developer");
		assertEquals(job.getTitle(), "Software Engineer");
		assertEquals(job.getSalary(),20000);
		assertEquals(job.getDepartment(),"QA");
		assertEquals(job.getCategory(),"Software Engineer");
	}

}
