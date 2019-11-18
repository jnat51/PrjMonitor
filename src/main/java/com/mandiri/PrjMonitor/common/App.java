package com.mandiri.PrjMonitor.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mandiri.PrjMonitor"})
@EntityScan(basePackages = "com.mandiri.PrjMonito.model") 
@EnableJpaRepositories("com.mandiri.PrjMonitor.repository") class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
