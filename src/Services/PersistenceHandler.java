package Services;

import BusinessLogic.JobDescription;
import BusinessLogic.Job;
import BusinessLogic.Candidate;
import BusinessLogic.Recruiter;
import BusinessLogic.HiringManager;

import java.util.List;

import BusinessLogic.Application;
import BusinessLogic.Interview;
import BusinessLogic.JobPost;

public abstract class PersistenceHandler {
	public PersistenceHandler() {
	}
	
	public abstract void save(JobDescription jobDescription);
	public abstract void save(Job job);
	public abstract void save(Candidate candidate);
	public abstract void save(Recruiter recruiter);
	public abstract void save(HiringManager hiringManager);
	public abstract void save(Application application);
	public abstract void save(Interview interview);
	public abstract void save(JobPost jobPost);
	
	public abstract List<JobDescription> loadJobDescriptions();
	public abstract List<Job> loadJobs();
	public abstract List<Candidate> loadCandidates();
	public abstract List<Recruiter> loadRecruiters();
	public abstract List<HiringManager> loadHiringManagers();
	public abstract List<Application> loadApplications();
	public abstract List<Interview> loadInterviews();
	public abstract List<JobPost> loadJobPosts();
	
	public abstract int login(String username, String password);
}
