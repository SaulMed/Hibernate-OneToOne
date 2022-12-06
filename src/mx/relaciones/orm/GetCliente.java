package mx.relaciones.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCliente {
	public static void main(String[] args) {

		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleClientes.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();

		Session mySession = myFactory.openSession();

		try {

			mySession.beginTransaction();

			// Establecer detalle clientes a obtener
			// Cliente clienteToGet = mySession.get(Cliente.class, 1);
			DetalleClientes detallesToGet = mySession.get(DetalleClientes.class, 4);
			
			System.out.println(detallesToGet);
			
			System.out.println(detallesToGet.getCliente());
			
			//Eliminar informacion en CASCADA desde detalleClientes hacia Cliente
//			System.out.println("Eliminacion en cascada desde detalleClientes");
//			mySession.delete(detallesToGet);

			mySession.getTransaction().commit();

		}catch(Exception e) {
			e.printStackTrace();
		}		
		finally {
			mySession.close();
			myFactory.close();
		}

	}
}
