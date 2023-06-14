package io.dumasoft.library.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//        //registry.addResourceHandler("/upload/**").addResourceLocations("file:/Users/brunogomezgarcia/upload/"); // Fuera del proyecto
//
//        // CONFIGURAMOS PARA QUE CARGUE EL DIRECTORIO DENTRO DEL PROYECTO EN LA RAÍZ
//        String resourcePath = Paths.get("upload").toAbsolutePath().toUri().toString();
//        registry.addResourceHandler("/upload/**").addResourceLocations(resourcePath);
//    }
}
