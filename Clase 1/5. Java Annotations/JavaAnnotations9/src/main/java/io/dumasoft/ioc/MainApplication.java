package io.dumasoft.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);

		// Pedir un bean al contenedor
		HistoryBook book = context.getBean("historyBook", HistoryBook.class);

		System.out.println(book.getInfo());
		System.out.println(book.getReport());

		System.out.println(book.getRefSection());
		System.out.println(book.getCommissionedName());


		context.close();
	}

}
