package mx.relaciones.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCliente {

	public static void main(String[] args) {
		// Creacion de Factory para la lectura del archivo hibernate, junto con las
		// clases involucradas
		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleClientes.class).buildSessionFactory();

		// Creacion del Obj Session
		Session mySession = myFactory.openSession();

		try {

			// Preparar transaccion
			mySession.beginTransaction();

			// Definir cliente a eliminar
			Cliente clienteToDelete = mySession.get(Cliente.class, 2);
			
			//Validar existencia de ese registro en BD
			if(clienteToDelete != null) {
				System.out.println("Deleting customer: "+ clienteToDelete.getNombre());
				mySession.delete(clienteToDelete);				
			}

			// Realizar transaccion
			mySession.getTransaction().commit();

			if(clienteToDelete != null)	System.out.println("customer deleted successfully!");
			else System.out.println("Customer not found.");
		} finally {
			// Finalizar recursos
			mySession.close();
			myFactory.close();
		}
	}

}
