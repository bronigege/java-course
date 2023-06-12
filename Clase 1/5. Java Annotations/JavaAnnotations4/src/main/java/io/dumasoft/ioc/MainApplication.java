package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección dependencia mediante setter, con método normal y con campo de clase

		// Leer el xml de la configuración
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		// pedir un bean al contenedor
		Book book = contexto.getBean("novelBook", Book.class);

		// usar un bean
		System.out.println(book.getInfo());
		System.out.println(book.getReport());

		// cerrar el contexto
		contexto.close();
	}

}
