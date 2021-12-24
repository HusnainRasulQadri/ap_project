package Services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PersistenceFactory {
	private static PersistenceFactory instance = null;
	private PersistenceHandler persistenceService = null;
	// EmailHandler
	
	private PersistenceFactory() {
	}
	
	public static synchronized PersistenceFactory getInstance() {
		if (instance == null) {
			instance = new PersistenceFactory();
		}
		return instance;
	}
	
	public PersistenceHandler createPersistenceHandler() {
		if (persistenceService == null) {
			try {
				Properties p = new Properties();
				p.load(new FileInputStream("config.txt"));
				String className = "Services." + p.getProperty("persistenceservice.name");
				persistenceService = (PersistenceHandler) Class.forName(className).getDeclaredConstructor().newInstance();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (InstantiationException e) {
				e.printStackTrace();
			}
			catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return persistenceService;
	}
	
}
