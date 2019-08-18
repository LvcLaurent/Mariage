package fr.lsi.mariage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Laurent SION
 *
 */
@Configuration
@ComponentScan("fr.lsi.mariage")
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("fr.lsi.mariage")
public class App{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
