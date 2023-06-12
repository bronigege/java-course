package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Inyección dependencia mediante setter, con método normal y con campo de clase

		// Leer el xml de la configuración
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");

		// pedir un bean al contenedor
		Book dune = contexto.getBean("novelBook", Book.class);
		Book iRobot = contexto.getBean("novelBook", Book.class);

		// usar un bean
		String result = (dune.equals(iRobot)) ? "Apuntan a la misma direccón de memoria" : "No apuntan al mismo lugar en memoria";
		System.out.println(result);

		// cerrar el contexto
		contexto.close();
	}

}
