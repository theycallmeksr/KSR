package ksr.com.DBConfig;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ksr.com.Category.category;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
	@Bean
	public DataSource getH2DataSource() 
	{
		System.out.println("ENTERING DATA SOURCE");
		BasicDataSource dataSource = new BasicDataSource();  
		dataSource.setDriverClassName("org.h2.Driver");
		System.out.println("driver successs");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/santhosh");
		dataSource.setUsername("KSR");
		dataSource.setPassword("ksr");
		System.out.println("JDBC SUCCESSFUL");
		System.out.println("H2 SUCCESS");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory(DataSource datasource) 
	{
		System.out.println("SESSION STARTED");
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(datasource);
		System.out.println("H2 DIALECT SUCCESSFUL");
		Properties hibernateproperties = new Properties(); 
		hibernateproperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");    
		hibernateproperties.put("hibernate.show_sql", "true");    
		hibernateproperties.put("hibernate.format_sql", "true");    
		hibernateproperties.put("hibernate.hbm2ddl.auto", "update");    
		hibernateproperties.put("hibernate.lazy", "false");   
		factory.addProperties(hibernateproperties);
		factory.addAnnotatedClass(category.class);
		System.out.println("SESSIONFACTORY CREATED SUCCESSFULLY: " + factory);
		return factory.buildSessionFactory();
	}

	@Bean    
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) 
	{    
		System.out.println("OBJECT FOR HIBERNATE TRANSACTION MANAGER CREATED" );
		HibernateTransactionManager txManager = new HibernateTransactionManager();  
		System.out.println("OBJECT FOR HIBERNATE TRANSACTION MANAGER CREATED");
		txManager.setSessionFactory(sessionFactory);    
		return txManager;    
    }	
}