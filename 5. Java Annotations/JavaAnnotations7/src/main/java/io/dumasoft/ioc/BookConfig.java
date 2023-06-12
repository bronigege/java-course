package io.dumasoft.ioc;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Este va a ser nuestro archivo de configuración con @Configuration
@Configuration
@ComponentScan("io.dumasoft.ioc") // Indica donde buscar los Beans
public class BookConfig {
}
