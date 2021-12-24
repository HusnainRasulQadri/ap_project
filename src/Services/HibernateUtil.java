package Services;

import java.util.Properties;

import BusinessLogic.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
				settings.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:ejazz");
				settings.put(Environment.USER, "scott");
				settings.put(Environment.PASS, "tiger");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle8iDialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Candidate.class);
				configuration.addAnnotatedClass(HiringManager.class);
				configuration.addAnnotatedClass(Recruiter.class);
				configuration.addAnnotatedClass(JobPost.class);
				configuration.addAnnotatedClass(Job.class);
				configuration.addAnnotatedClass(JobDescription.class);
				configuration.addAnnotatedClass(Application.class);
				configuration.addAnnotatedClass(Interview.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
