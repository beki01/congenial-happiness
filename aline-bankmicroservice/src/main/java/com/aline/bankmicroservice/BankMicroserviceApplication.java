package com.aline.bankmicroservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;


@SpringBootApplication
@ComponentScan(basePackages = {"com.aline.core", "com.aline.bankmicroservice"})
@EnableJpaRepositories(basePackages = {"com.aline.core.repository"})
@EntityScan(basePackages = {"com.aline.bankmicroservice.model", "com.aline.core.model"})
public class BankMicroserviceApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public HttpHeaders httpHeaders(){
        return new HttpHeaders();
    }

    public static void main(String[] args) {
        SpringApplication.run(BankMicroserviceApplication.class, args);
    }

}
