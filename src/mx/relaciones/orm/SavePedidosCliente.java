package mx.relaciones.orm;

import java.util.Date;
import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SavePedidosCliente {

	public static void main(String []args) {
		
		//Crear Factory para la lectura del archivo hibernate, junto con las clases involucradas
		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(DetalleClientes.class)
				.addAnnotatedClass(Pedido.class)
				.buildSessionFactory();
		
		//Creacion de obj de tipo Session
		Session mySession = myFactory.openSession();
		
		try {
			
			//Comenzar transaccion
			mySession.beginTransaction();
			
			//Obtener cliente
			Cliente customer = mySession.get(Cliente.class, 5);
			
			//Crear pedidos del cliente seleccionado
			Pedido order = new Pedido(new GregorianCalendar(2022,5,5));
			Pedido order2 = new Pedido(new GregorianCalendar(2022,5,10));
			Pedido order3 = new Pedido(new GregorianCalendar(2022,5,15));
			
			//Agregar pedidos al cliente seleccionado
			customer.AgregarPedido(order);
			customer.AgregarPedido(order2);
//			customer.AgregarPedido(order3);	
			
			//Registrar pedidos dentro de su respectiva tabla en la BBDD
			mySession.save(order);
			mySession.save(order2);
//			mySession.save(order3);
			
			//Realizar transaccion
			mySession.getTransaction().commit();
			
			System.out.println("Orders registed successfully!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//Cerrar recursos
			mySession.close();
			myFactory.close();
		}
		
	}
	
}
