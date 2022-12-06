package mx.relaciones.orm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetPedidosCliente {

	public static void main(String[] args) {

		SessionFactory myFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Pedido.class)
				.addAnnotatedClass(DetalleClientes.class)
				.buildSessionFactory();
		
		Session mySession = myFactory.openSession();
		
		try {
			
			mySession.beginTransaction();
			
			//Seleccionar cliente
//			Cliente cliente = mySession.get(Cliente.class, 5);
			Query<Cliente> query =mySession.createQuery("SELECT CL FROM Cliente CL JOIN FETCH CL.pedidos WHERE CL.id=:idCliente",Cliente.class); 
			query.setParameter("idCliente", 5);
			
			Cliente cliente = query.getSingleResult(); //Cargar en memoria toda la data del cliente definido
			
			//Obtener pedidos del cliente
			System.out.println("Cliente: " + cliente);
			
			mySession.getTransaction().commit();
			mySession.close();
			System.out.println("Pedidos: " + cliente.getPedidos()); //Permite acceder a la data despues de cerrar la session al cargar previamente la info en memoria con HQL
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			myFactory.close();
		}

	}

}
