package TestCases;
import BusinessLogic.*;

import static org.junit.Assert.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Application;
import BusinessLogic.Job;
import junit.framework.Assert;

public class Test3 {

	@Test
	public void test() {
		JobPost jobPost = new JobPost();
	    Application app = new Application(jobPost);
	    app.setStatus("Pending");
		jobPost.setShortlistStatus(new Application(jobPost), "Pending");
		jobPost.setDeadline(LocalDate.now());
		jobPost.setStatus("Active");
		jobPost.setVacancies(7);
		
	    Assert.assertEquals(app.getCurrentStatus(),"Pending");
	    Assert.assertEquals(app.getJobPost(),jobPost);
	   }
}