package mx.relaciones.orm;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.*;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name="fecha")
	private GregorianCalendar fecha;
	
	@Column(name = "forma_pago")
	private String formaPago;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="cliente_id")
	private Cliente clientePedido;

	public Pedido() {
		
	}
	
	public Pedido(GregorianCalendar fecha) {
		super();
		this.fecha = fecha;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getCliente() {
		return clientePedido;
	}

	public void setCliente(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + "]";
	}
	
	
	
}
