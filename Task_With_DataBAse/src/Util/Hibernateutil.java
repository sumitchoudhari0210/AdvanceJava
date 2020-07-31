package Util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Hibernateutil {
	private static SessionFactory sessionf;
	private static StandardServiceRegistry registry;

	public static SessionFactory getSessionFactory() 
	    {
		if(sessionf==null) 
		{
			Map <String, Object> settings= new HashMap<>();
			settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/loginpage");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.FORMAT_SQL, "true");

			registry= new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources mds= new MetadataSources(registry);
			mds.addAnnotatedClass(com.register.Register.class);
			Metadata md= mds.getMetadataBuilder().build();
			sessionf = md.getSessionFactoryBuilder().build();
			
				
			
		}
			
			
		
		return sessionf;
		}


}
