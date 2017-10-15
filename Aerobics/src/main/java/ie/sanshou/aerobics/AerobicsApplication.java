package ie.sanshou.aerobics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @desc The starting point of the war web application.      
 */
@SpringBootApplication
public class AerobicsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AerobicsApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationBuilder.class, args);
    }

}

/**
 * @desc The starting point of the jar application.           
 */
//@SpringBootApplication
//public class AerobicsApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(AerobicsApplication.class, args);
//    }
//
//} 
