package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages ={"company","person","customer","supplier"})
@EnableJpaRepositories(basePackages = {"company","person","customer","supplier"})
@ComponentScan({"company","person","customer","supplier"})
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