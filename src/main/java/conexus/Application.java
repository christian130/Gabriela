package conexus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;



@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	 @Autowired
		private ApplicationContext appContext;
    public static void main(String[] args) {
    	ApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
    	
    	//context.getBean("dataSource", Singleton.class);
        //SpringApplication.run(Application.class, args);
        
        System.out.println("sss"+ context.getBeanDefinitionNames());
    }
    }
   

