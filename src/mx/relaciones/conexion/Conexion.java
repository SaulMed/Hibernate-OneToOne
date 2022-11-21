package mx.relaciones.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	public static void main(String []args) {
		
		String URL = "jdbc:mysql://localhost:3306/relacionesHibernate";
		String user = "root";
		String pw = "admin123";
		
		
		try {
			System.out.println("Intentando acceder a " + URL);
			Connection miConexion = DriverManager.getConnection(URL,user,pw);
			System.out.println("Connected to Database: " + miConexion.getCatalog());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
