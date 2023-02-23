package com.In4peopl.bootrestapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.In4peopl.bootrestapi")
@EnableJpaRepositories(basePackages = "com.In4peopl.bootrestapi")
public class JpaConfiguration {
}
