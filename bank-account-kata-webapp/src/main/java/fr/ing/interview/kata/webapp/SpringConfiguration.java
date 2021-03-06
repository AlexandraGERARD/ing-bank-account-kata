package fr.ing.interview.kata.webapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring configuration class
 */
@Configuration
@ComponentScan("fr")
@ImportResource("classpath*:applicationContext.xml")
public class SpringConfiguration {
}
