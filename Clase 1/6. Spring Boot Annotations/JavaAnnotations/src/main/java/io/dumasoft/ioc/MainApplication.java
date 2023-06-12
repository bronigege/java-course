package io.dumasoft.ioc;

import io.dumasoft.ioc.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
// CommandLineRunner es una interfaz que se usa para indicar que una tarea
// debe ejecutarse justo después de que la aplicación Spring Boot haya iniciado
public class MainApplication implements CommandLineRunner {
	private Book book;

	// Al no indicar que dependencia que implementa book inyectamos
	// Nos mostrará un error. Hay que usar @Qualifier
	// Si preparo un archivo de configuración no me hace falta usar @Qualifier
	// Si lo pongo tiene preferencia al qualifier
	public MainApplication(@Qualifier("scienceBook") Book book) {
		this.book = book;
	}

	// Lógica proyecto:
	// 1. El controller recibe la petición del usuario. Este se comunica con service.
	// 2. En Service está la lógica de negocio que se comunica con repository
	// 3. En repository se realizan las operaciones con la base de datos
	// 4. Repository le devuelve la respuesta a service.
	// 5. Service opera con los datos y el resultado se lo devuelve al controller

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args); //PUERTO POR DEFECTO 8080

		// Si queremos cambiarle el puerto podemos hacerlo desde el archivo de properties
		// o programáticamente. Ejemplo:
		// SpringApplication app = new SpringApplication(MainApplication.class);
		// app.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
		// app.run(args);

		// Anotaciones más comunes:
		// @Component. Anotación muy genérica
		// @Controller. Para indicar que esta será la clase que gestionará las peticiones del usuario
		// por get, post, put, patch o delete
		// @Service: Con esta notación especificamos que en esta clase se encontrará toda nuestra lógica
		// negocio, cálculos o llamadas a otras API externas
		// @Repository: Se usa pra las clases o interfaces que funcionarán con el acceso a la base de
		// de datos.

		// Si nuestra clase o interfaz no tiene una especificación clara como @Service, @Repository o
		// @Controller, simplemente recurriremos a @Component y le indicamos que sencillamente es un
		// Componente

		// No es estrictamente necesario que cumplas con colocar una notación específica, pero es una
		// buena práctica.

	}

	@Override
	// Se utiliza para ejecutar tareas de inicialización
	// como cargar datos en la base de datos, etc
	public void run(String... args) throws Exception {
		System.out.println(book.getInfo());
		System.out.println(book.getReport());
	}
}
