package it.realt.projectgiacomofilm.test;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@AutoConfigureDataJpa
@EnableConfigurationProperties
@EnableJpaRepositories(value={"it.realt.projectgiacomofilm.repositories"})
@EntityScan("it.realt.projectgiacomofilm.domain")
@ComponentScan("it.realt.projectgiacomofilm.services")
public class ServicesAndRepositoriesConfig {
}
