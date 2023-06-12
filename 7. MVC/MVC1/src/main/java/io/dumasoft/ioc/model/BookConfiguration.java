package io.dumasoft.ioc.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {
    @Bean
    public Book book() {
        return new NovelBook();
    }
}
