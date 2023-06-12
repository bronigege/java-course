package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección de dependencia mediante setter. Pasos:
		// 1. Crear la clase e interfaz de la dependencia
		// 2. Creación de método setter en la clase para la inyección
		// 3. Configurar la inyección de dependencia en archivo XML

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book novela = contexto.getBean("libraryBooks", Book.class);
		Book scienceFiction = contexto.getBean("libraryScienceBook", Book.class);
		System.out.println(novela.getInfo());
		System.out.println(novela.getInforme());
		System.out.println(scienceFiction.getInfo());
		System.out.println(scienceFiction.getInforme());



		contexto.close();
	}

}
