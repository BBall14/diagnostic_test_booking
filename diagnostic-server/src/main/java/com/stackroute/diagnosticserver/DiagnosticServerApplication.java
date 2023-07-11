package com.stackroute.diagnosticserver;

import com.stackroute.diagnosticserver.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiagnosticServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(DiagnosticServerApplication.class, args);
	}

}
