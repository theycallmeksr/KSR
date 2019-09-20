package projects.DBConfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import projects.CategoryClass.Authorities;
import projects.CategoryClass.BillingAddress;
import projects.CategoryClass.CartItem;
import projects.CategoryClass.Category;
import projects.CategoryClass.Customer;
import projects.CategoryClass.CustomerOrder;
import projects.CategoryClass.Product;
import projects.CategoryClass.ShippingAddress;
import projects.CategoryClass.Supplier;
import projects.CategoryClass.User;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {

	/* @Bean(name="dataSource") */
	@Bean(name="dataSource")
	public DataSource getDataSource() {

		System.out.println("Entering DataSource ");

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test7");
		dataSource.setUsername("dinesh");
		dataSource.setPassword("123");

		System.out.println("DataSource bean" + dataSource);
		return dataSource;

	}

	/* @Bean(name="sessionFactory") */
	@Bean(name="sessionFactory")
	public SessionFactory sessionFactory(DataSource datasource) {

		System.out.println("Entering SessionFactory");
		LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(datasource);
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.show_sql", "true");
		hibernateProp.put("hibernate.format_sql","true");
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.lazy","false");
		factory.addProperties(hibernateProp);
	    factory.addAnnotatedClass(Category.class);
	    factory.addAnnotatedClass(Supplier.class);
	    factory.addAnnotatedClass(Product.class);
	    factory.addAnnotatedClass(Customer.class);
	    factory.addAnnotatedClass(User.class);
	    factory.addAnnotatedClass(BillingAddress.class);
	    factory.addAnnotatedClass(ShippingAddress.class);
	    factory.addAnnotatedClass(Authorities.class);
	    factory.addAnnotatedClass(CartItem.class);
	    factory.addAnnotatedClass(CustomerOrder.class);

		//Class classes[] = new Class[] { Category.class };

		System.out.println("SessionFactory bean" + factory);
		
		return factory.buildSessionFactory();

	}

	@Bean
	public HibernateTransactionManager hibTransManagement(SessionFactory sessionFactory) {
		System.out.println("Hibernate Transaction processed");
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		System.out.println("Hibernate Setup");
		txManager.setSessionFactory(sessionFactory);
		return txManager;

	}

}