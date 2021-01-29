package com.amit.blueribbon;

import com.amit.blueribbon.cache.InMemoryCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlueribbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueribbonApplication.class, args);
    }

    @Bean
    public InMemoryCache inMemoryCache() {
        return new InMemoryCache();
    }


}
