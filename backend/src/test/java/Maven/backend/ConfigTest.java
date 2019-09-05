package Maven.backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ksr.com.DBConfig.ConFig;

public class ConfigTest 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConFig.class);
		System.out.println("Configured...");
	}
}
