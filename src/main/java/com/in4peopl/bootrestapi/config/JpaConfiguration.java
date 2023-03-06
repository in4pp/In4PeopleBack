package com.in4peopl.bootrestapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.in4peopl.bootrestapi")
@EnableJpaRepositories(basePackages = "com.in4peopl.bootrestapi")
public class JpaConfiguration {
}
