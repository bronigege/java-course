package io.dumasoft.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        //SpringApplication.run(LibraryApplication.class, args);

        // Lo podemos crear como:
        // * Archivo de configuración xml
        // * Java Source Code
        // * Java Annotations


        // Inyección de dependencia mediante constructor. Pasos:
        // 1. Crear la clase e interfaz de la dependencia
        // 2. Creación de constructor en la clase para la inyección de la dependencia
        // 3. Configurar la inyección de dependencia en archivo XML

        // Inyección de dependencia mediante setter. Pasos:
        // 1. Crear la clase e interfaz de la dependencia
        // 2. Creación de método setter en la clase para la inyección
        // 3. Configurar la inyección de dependencia en archivo XML


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = context.getBean("libraryBooks", Book.class);

        Book science = context.getBean("scienceBooks", Book.class);

        PhilosophyBook philosophy = context.getBean("philosophyBooks", PhilosophyBook.class);

        // Book book1 = new ScienceBook();

        // Book book = new ScienceBook();

        // System.out.println(science.getInfo());
        // System.out.println(science.getReports());
        System.out.println(philosophy.getEncargado());
        System.out.println(philosophy.getRefSection());
    }

}
