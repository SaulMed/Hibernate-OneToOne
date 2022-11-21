package mx.relaciones.orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_clientes")
public class DetalleClientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// Referenciar el campo que contiene la relacion de detalleClientes. 
	// Permitiendo una comunicacion Bidireccional
	@OneToOne(mappedBy = "detalles", cascade = CascadeType.ALL)
	private Cliente cliente;

	@Column(name = "web")
	private String web;

	@Override
	public String toString() {
		return "DetalleClientes [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ "]";
	}

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "comentarios")
	private String comentarios;

	public DetalleClientes() {
		super();
	}

	public DetalleClientes(String web, String telefono, String comentarios) {
		super();
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

}
