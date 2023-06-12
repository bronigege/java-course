package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		Book book = contexto.getBean("libraryScienceBook", Book.class);

		System.out.println(book.getInforme());

		contexto.close();
	}

}
