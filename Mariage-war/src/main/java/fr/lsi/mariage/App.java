package fr.lsi.mariage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Laurent SION
 *
 */
@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class App{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}