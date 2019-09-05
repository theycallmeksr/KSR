package ksr.com.DBConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ksr.com.Category.category;



@Configuration
@EnableTransactionManagement

public class ConFig {
	// creating data source
	// @Bean(name="DataSourcee")
	@Bean
	public DataSource getH2DataSource() {
		
		System.out.println("data source entering");
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//DriverManagerDataSource dataSource=new DriverManagerDataSource();   
		dataSource.setDriverClassName("org.h2.Driver");
		System.out.println("driver successs");

		dataSource.setUrl("jdbc:h2:tcp://localhost/~/santhosh");
		
		dataSource.setUsername("KSR");
		dataSource.setPassword("ksr");
		System.out.println("sucesss jdbc");

		
		/*
		 * DriverManagerDataSource dataSource=new DriverManagerDataSource();
		 * dataSource.setDriverClassName(JDBC_DRIVER_CLASS); // org.h2.Driver
		 * dataSource.setUrl(JDBC_URL); //jdbc:h2:tcp://localhost/~/test
		 * dataSource.setUsername(JDBC_USERNAME); //sa
		 * dataSource.setPassword(JDBC_PASSWORD); //abc
		 */	
		
		
		//Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/server~/dbname","username","password");
		
		
		
		
		
		System.out.println("h2 sucessssssssssssssssssssssssssss");

		return dataSource;

	}

	@Bean
	public SessionFactory sessionFactory(DataSource datasource) {

		System.out.println("session start");
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(datasource);

		System.out.println("h2 dialect sucess");

//		Properties hibernateProperties = new Properties();
//
//		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update"); // sql properties
//
//		hibernateProperties.setProperty("hibernate.show_sql", "true");
//		System.out.println(" property adding sucessfuly ");

		
		Properties hibernateproperties = new Properties(); 
		hibernateproperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");    
		hibernateproperties.put("hibernate.show_sql", "true");    
		hibernateproperties.put("hibernate.format_sql", "true");    
		hibernateproperties.put("hibernate.hbm2ddl.auto", "update");    
		hibernateproperties.put("hibernate.lazy", "false");   
		factory.addProperties(hibernateproperties);
		
		//factory.addProperties(hibernateProperties);

		 factory.addAnnotatedClass(category.class);

		// map all entites
		//Class classes[] = new Class[] { Category.class };
		System.out.println("session factory created  sucessfully: " + factory);
  //return factory.addAnnotatedClasses(classes).buildSessionFactory();

		//int sNum = Integer.parseInt(request.getParameter("sNum"));
		
		//return (SessionFactory) factory;
		return factory.buildSessionFactory();
	}

	// create a hibernate transacattion manager bean

	// @Bean(name="txManager")
	
	/*
	 * @Bean public HibernateTransactionManager hibTransManagement() {
	 * 
	 * System.out.println("=====hibernate tranasation manager object created======"
	 * ); return new HibernateTransactionManager(sessionFactory(getH2DataSource()));
	 * 
	 * }
	 */
	
	@Bean    
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {    
		System.out.println("=====hibernate tranasation manager object created======" );
		HibernateTransactionManager txManager = new HibernateTransactionManager();  
		System.out.println("=====hibernate tranasation manager object created======");
    txManager.setSessionFactory(sessionFactory);    
    
    return txManager;    
    }
	
	
	
}