package mx.relaciones.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveCliente {

	public static void main(String []args) {
		
		//Crear Factory para la lectura del archivo hibernate, junto con las clases involucradas
		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleClientes.class)
				.buildSessionFactory();
		
		//Creacion de obj de tipo Session
		Session mySession = myFactory.openSession();
		
		try {
			
//Insertar registro en Tabla cliente

			//Crear obj cliente y detalleClientes
			Cliente myCustomer = new Cliente("Paco","Gomez","Main Street #2");
			DetalleClientes details = new DetalleClientes("www.GomezPanaderia.com","7215486532","VIP.");
			
			//Asociar Objetos
			myCustomer.setDetalles(details);
			
			//Comenzar transaccion
			mySession.beginTransaction();
			
			//Guardar informacion en DB
			mySession.save(myCustomer);			
			
			//Realizar transaccion
			mySession.getTransaction().commit();
			
			System.out.println("Customer registed successfully!");
		}finally {
			//Cerrar recursos
			mySession.close();
			myFactory.close();
		}
		
	}
	
}
