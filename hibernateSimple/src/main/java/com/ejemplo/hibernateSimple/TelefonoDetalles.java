package com.ejemplo.hibernateSimple;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="telf_detalles")
public class TelefonoDetalles {
	@Id
	@Column(name="id_t_det", unique=true, nullable=false)
	@GenericGenerator(name="miGen", strategy="foreign",
	parameters = @Parameter(name="property", value="telf"))
	@GeneratedValue(generator="miGen")
	private int id;
	private String proveedor, tipo, propietario;
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Telefono telf;
	public TelefonoDetalles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TelefonoDetalles(int id, String proveedor, String tipo, String propietario, Telefono telf) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.tipo = tipo;
		this.propietario = propietario;
		this.telf = telf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public Telefono getTelf() {
		return telf;
	}
	public void setTelf(Telefono telf) {
		this.telf = telf;
	}
	
}
