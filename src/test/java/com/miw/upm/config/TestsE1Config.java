package com.miw.upm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.miw.upm.injection.e1e2e4.MessageService;
import com.miw.upm.injection.e1e2e4.MessageServiceMock;

@Configuration
@ComponentScan(basePackages = "com.miw.upm.injection.e1e2e4")
public class TestsE1Config {

    @Bean
    public MessageService messageService() {
        return new MessageServiceMock();
    }
}
