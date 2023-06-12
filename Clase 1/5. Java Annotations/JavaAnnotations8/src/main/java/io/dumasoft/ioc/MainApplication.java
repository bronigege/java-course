package io.dumasoft.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);

		// Pedir un bean al contenedor
		Book book = context.getBean("historyBook", Book.class);

		System.out.println(book.getInfo());
		System.out.println(book.getReport());


		context.close();
	}

}
