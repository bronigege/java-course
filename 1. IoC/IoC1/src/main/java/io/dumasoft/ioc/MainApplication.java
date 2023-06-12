package io.dumasoft.ioc;

//@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		//SpringApplication.run(IoCApplication.class, args);

		// Creación de objetos de tipo NovelaBook
		// NovelBook book = new NovelBook();
		// Ahora puedo realizar la abstracción
		Book book = new PhilosophyBook();

		// TODO: PROBLEMA QUE SE PLANTEA
		// Si yo en mi aplicación necesito un objeto nuevo que aún no he construido tengo
		// que hacer cambios en la propia aplicación. En cualquiera de las clases que ya están
		// creadas o crear una clase nueva. Si quisiera prescindir de uno de los objetos porque
		// la aplicación no lo va a utilizar, por ejemplo, si mi aplicación ya no va a utilizar
		// NovelBook tendría que eliminar la clase (Cuando la app es muy compleja supone un trastorno
		// este tipo de tareas). Es ahí donde entra en juego Spring con su Inversion of Control,
		// con sus Beans y con su BeanFactory

		// Pretendemos trabajar también con objetos de tipo NovelBook y ScienceFictionBook
		// Una buena práctica es crear una abstracción de los datos, esto consiste en crear
		// una clase principal o una entidad principal que puede ser simplemente Book
		// Y llevarte esa entidad o bien a una clase abstracta de la cual hereden las demás clases
		// o crear una interfaz y que implemente todas las clases.

		// Uso de los objetos creados
		System.out.println(book.getInfo());

		// Podemos hacer la abstracción ahora
	}

}
