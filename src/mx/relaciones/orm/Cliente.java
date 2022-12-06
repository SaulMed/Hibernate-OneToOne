package mx.relaciones.orm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Anotaciones para definir la DIRECCION DE LA RELACION
	@OneToOne(cascade = CascadeType.ALL) // Indicar el tipo de relacion entre tablas, CascateType.All Elimina data en
											// secuencia de ambas tablas
	@JoinColumn(name = "id") // Definir a traves de que campo se comunican las tablas
	private DetalleClientes detalles;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "direccion")
	private String direccion;

	//FetchType.LAzy = Data OnDemand
	//FetchType.EAGER = Full Data en un solo envio
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clientePedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Pedido> pedidos;

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

	public void AgregarPedido(Pedido pedido) {
		if (pedidos == null)
			pedidos = new ArrayList<>();
		pedidos.add(pedido);
		pedido.setCliente(this);
	}

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, String direccion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DetalleClientes getDetalles() {
		return detalles;
	}

	public void setDetalles(DetalleClientes detalles) {
		this.detalles = detalles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellido;
	}

	public void setApellidos(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
