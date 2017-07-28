package co.com.emidata.confg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.com.emidata")
public class EmidataApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmidataApplication.class, args);
    }
}
