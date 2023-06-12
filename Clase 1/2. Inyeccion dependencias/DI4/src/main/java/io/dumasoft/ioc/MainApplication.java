package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección de dependencia mediante campos. Usando el archivo de propiedades

		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");



		NovelBook novela = contexto.getBean("libraryNovelBook", NovelBook.class);
		System.out.println(novela.getInfo());
		System.out.println(novela.getInforme());
		System.out.println(novela.getRefSection());
		System.out.println(novela.getCommissionedName());

		contexto.close();
	}

}
