package com.stackroute.diagnosticserver.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class will be used to configure the security for the application
@Configuration
public class FilterConfig {

    // Method for jwtFilter
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/v1/user/restricted");

        return registrationBean;
    }
}
