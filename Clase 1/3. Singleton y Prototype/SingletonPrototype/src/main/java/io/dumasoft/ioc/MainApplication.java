package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		Book dune = contexto.getBean("libraryScienceBook", Book.class);
		Book clockworkOrange = contexto.getBean("libraryScienceBook", Book.class);


		String result = (dune.equals(clockworkOrange)) ? "Son el mismo objeto" : "No son el mismo objeto";
		System.out.println(result);

		contexto.close();
	}

}
