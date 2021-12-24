package Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import BusinessLogic.Application;
import BusinessLogic.Candidate;
import BusinessLogic.Credentials;
import BusinessLogic.HiringManager;
import BusinessLogic.Interview;
import BusinessLogic.Job;
import BusinessLogic.JobDescription;
import BusinessLogic.JobPost;
import BusinessLogic.Recruiter;

public class HibernatePersistenceHandler extends PersistenceHandler {

	public HibernatePersistenceHandler() {
		super();
	}
	
	@Override
	public void save(JobDescription jobDescription) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the jobDescription object
			session.save(jobDescription);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(Job job) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			save(job.getJobDescription());
			// save the job object
			session.save(job);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(Candidate candidate) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the candidate object
			session.save(candidate);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(Recruiter recruiter) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the recruiter object
			session.save(recruiter);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(HiringManager hiringManager) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the hiringManager object
			session.save(hiringManager);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(Application application) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the application object
			session.save(application);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(Interview interview) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the interview object
			session.save(interview);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(JobPost jobPost) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			save(jobPost.getJob());
			// save the jobPost object
			session.save(jobPost);
			session.flush();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<JobDescription> loadJobDescriptions() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List jobDescriptions = session.createQuery("FROM JobDescription").list();;
			for (Iterator i = jobDescriptions.iterator(); i.hasNext();) {
				JobDescription j = (JobDescription) i.next();
				System.out.println("Vacancies: " + j.getMinimumEducation());
			}
			return jobDescriptions;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Job> loadJobs() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobDescriptions();
			List jobs = session.createQuery("FROM Job").list();;
			for (Iterator i = jobs.iterator(); i.hasNext();) {
				Job j = (Job) i.next();
				System.out.println("Vacancies: " + j.getTitle());
			}
			return jobs;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Candidate> loadCandidates() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List candidates = session.createQuery("FROM Candidate").list();
			return candidates;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Recruiter> loadRecruiters() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List recruiters= session.createQuery("FROM Recruiter").list();
			return recruiters;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<HiringManager> loadHiringManagers() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List hiringManagers = session.createQuery("FROM HiringManager").list();
			return hiringManagers;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Application> loadApplications() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List applications = session.createQuery("FROM Application").list();
			return applications;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Interview> loadInterviews() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List interviews = session.createQuery("FROM Interview").list();
			return interviews;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<JobPost> loadJobPosts() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			loadJobs();
			List jobPosts = session.createQuery("FROM JobPost").list();
			return jobPosts;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int login(String username, String password) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List credentials = session.createQuery("FROM Credentials where username = " + username + " and password = " + password).list();
			for (Iterator i = credentials.iterator(); i.hasNext();) {
				Credentials c = (Credentials) i.next();
				List candidates = session.createQuery("FROM Candidate where username = " + c.getUsername() + " and password = " + c.getPassword()).list();
				if (candidates.size() > 0)
					return 1; // Candidate login
				List recruiters = session.createQuery("FROM Recruiter where username = " + c.getUsername() + " and password = " + c.getPassword()).list();
				if (recruiters.size() > 0)
					return 2; // Recruiter login
				List hiring = session.createQuery("FROM HiringManager where username = " + c.getUsername() + " and password = " + c.getPassword()).list();
				if (hiring.size() > 0)
					return 3; // Hiring Manager login
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return 0;
	}

	
}
