package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección de dependencia mediante campos.

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Hasta ahora siempre que hemos pedido un bean a Spring lo hemos hecho utilizando la interfaz Book
		// esa interfaz era implementada por todas las clases. Si abrimos la interfaz Book vemos que solo tiene dos
		// métodos. Ahora debemos cambiar como le pedimos a Spring ese Bean
		// Book novela = contexto.getBean("libraryNovelBook", Book.class);

		NovelBook novela = contexto.getBean("libraryNovelBook", NovelBook.class);
		System.out.println(novela.getInfo());
		System.out.println(novela.getInforme());
		System.out.println(novela.getRefSection());
		System.out.println(novela.getCommissionedName());

		contexto.close();
	}

}
