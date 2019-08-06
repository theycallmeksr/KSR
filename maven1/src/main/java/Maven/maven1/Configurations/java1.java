package Maven.maven1.Configurations;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@ComponentScan("Maven.maven1")
public class java1 
{
	//Creating the dataSource Bean
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ksr");
		dataSource.setUsername("KSR");
		dataSource.setPassword("335288");
		System.out.println("Data Source has been created");
		return dataSource;
	}
	//Creating a SessionFactory Bean
	@Bean(name="sessionFactory")
	public SessionFactory setSessionFactory()
	{
		Properties hibernateProperties=new Properties();
		hibernateProperties.put("hibernate.hbm2ddl.auto","update");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(this.getH2DataSource());
		factory.addProperties(hibernateProperties);
		
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("SessionFactory object has been created");
		return sessionFactory;
	}
	//Creating a hibernateTransactionManager Bean
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("HibernateTransactionManager object created");
		return new HibernateTransactionManager(sessionFactory);
	}
}