package io.dumasoft.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// Un programa java a medida que necesita objetos
		// los va solicitando a un contenedor Spring que
		// le proporciona estos objetos. Trataremos que
		// nuestro programa dependiendo del objeto que necesite
		// el contenedor se los vaya proporcionando.
		// Nuestro contenedor necesita un archivo de configuración.
		// Lo podemos crear como:
		// * Archivo de configuración xml
		// * Java Source Code
		// * Java Annotations

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Book novel = context.getBean("libraryBooks", Book.class);
		System.out.println(novel.getInfo());
		context.close();

		// ¿Dónde está la utilidad? Si yo necesito objetos de otro tipo, no tengo que crearme un objeto de otro tipo,
		// una instancia. Lo único que hay que hacer es ir al archivo xml y decirle que el motor, el generador de beans
		// me tiene que devolver un objeto de otro tipo.

		// Para obtener objetos de diferente tipo no hemos modificado el código de nuestra app. Lo único que hemos
		// modificado para obtener objetos de distinto tipo es modificando el archivo de configuración xml
	}

}
