package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages ={"customer","party","enterprise","membership","person","supplier"})
@EnableJpaRepositories(basePackages = {"customer","party","enterprise","membership","person","supplier"})
@ComponentScan({"customer","party","enterprise","membership","person","supplier"})
public class Party_Main extends SpringBootServletInitializer  
{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Party_Main.class);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Party_Main.class, args);
	}
}