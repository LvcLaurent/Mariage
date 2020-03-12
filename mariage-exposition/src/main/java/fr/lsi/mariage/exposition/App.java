package fr.lsi.mariage.exposition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Laurent SION
 *
 */
@Configuration
@ComponentScan("fr.lsi.mariage")
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@EntityScan("fr.lsi.mariage")
public class App{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
