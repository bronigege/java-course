package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección de dependencia mediante constructor. Pasos:
		// 1. Crear la clase e interfaz de la dependencia
		// 2. Creación de constructor en la clase para la inyección de la dependencia
		// 3. Configurar la inyección de dependencia en archivo XML

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book novela = contexto.getBean("libraryBooks", Book.class);
		System.out.println(novela.getInfo());
		System.out.println(novela.getInforme());

		// Un alumno podrá pensar que es una complicación hacer una inyección de dependencia. La ventaja de esto
		// es que ahora si en vez de un NovelBook es un PhilosophyBook el que necesita crear un informe simplemente
		// lo cambiamos en el xml


		contexto.close();
	}

}
