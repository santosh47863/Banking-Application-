package com.cg.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.bank.dto.CustomerDto;
import com.cg.bank.service.CustomerService;

@SpringBootApplication
public class SpringRestDemo1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemo1Application.class, args);
	}

	
}
