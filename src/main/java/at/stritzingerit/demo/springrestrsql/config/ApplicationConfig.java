package at.stritzingerit.demo.springrestrsql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("at.stritzingerit.*")
@EntityScan("at.stritzingerit.demo.springrestrsql.entity")
@EnableJpaRepositories("")
public class ApplicationConfig {
}
