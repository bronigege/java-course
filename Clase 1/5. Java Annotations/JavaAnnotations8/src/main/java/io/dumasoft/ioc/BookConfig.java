package io.dumasoft.ioc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Este va a ser nuestro archivo de configuración con @Configuration
@Configuration
@ComponentScan("io.dumasoft.ioc") // Indica donde buscar los Beans
public class BookConfig {
    // Definir el bean para HistoryLibraryInventary
    @Bean
    public Inventary historyLibraryInventary() {
        return new HistoryLibraryInventary();
    }

    // Definir el bean Book en el que inyectamos la dependencia
    @Bean
    public Book historyBook() {
        return new HistoryBook(historyLibraryInventary());
    }
}
