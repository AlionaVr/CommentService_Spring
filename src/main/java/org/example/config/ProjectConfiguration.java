package org.example.config;

import org.example.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
public class ProjectConfiguration {
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
