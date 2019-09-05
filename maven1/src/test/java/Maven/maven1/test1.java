package Maven.maven1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Maven.maven1.Configurations.java1;
public class test1 
{
	public static void main(String ar[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(java1.class);
		System.out.println("Configured...");
	}
}