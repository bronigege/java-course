package io.dumasoft.ioc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {

		// Prescindimos el archivo XML
		// ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Leer de la clase de configuración
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);



		Book book = context.getBean("novelBook", Book.class);

		System.out.println(book.getInfo());
		System.out.println(book.getReport());


		context.close();
	}

}
