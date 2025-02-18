package com.ege.config;

import com.ege.service.ResultsProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ResultsProcessorConfig {

    @Bean
    public ResultsProcessor resultsProcessor() {
        return new ResultsProcessor();
    }
}