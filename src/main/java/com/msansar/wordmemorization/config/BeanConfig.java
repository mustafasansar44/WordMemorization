package com.msansar.wordmemorization.config;

import com.msansar.wordmemorization.util.CascadingMongoEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CascadingMongoEventListener cascadingMongoEventListener(){
        return new CascadingMongoEventListener();
    }
}
