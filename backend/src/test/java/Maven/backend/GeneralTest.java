package Maven.backend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralTest 
{
  public static void main(String args[])
  {
	  
	AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext();
   context.scan("ksr.com");
	  context.refresh();
  }
	  
}

