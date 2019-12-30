package com.mandiri.ProjectMonitor.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.mandiri.ProjectMonitor" })
@EntityScan(basePackages = "com.mandiri.ProjectMonitor.model")
@EnableJpaRepositories("com.mandiri.ProjectMonitor.repository")
class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder  application) {
       return application.sources(App.class);
    }
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}