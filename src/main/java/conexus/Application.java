package conexus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	 @Autowired
		private ApplicationContext appContext;
    public static void main(String[] args) {
    	
        SpringApplication.run(Application.class, args);
        Application rr = new Application();
        System.out.println(rr.appContext.getDisplayName());
    }
    }
   

