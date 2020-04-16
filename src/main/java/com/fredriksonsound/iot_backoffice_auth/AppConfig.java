package com.fredriksonsound.iot_backoffice_auth;

import Controller.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserService userController() {
        return new UserService();
    }
}
