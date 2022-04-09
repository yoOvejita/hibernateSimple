package com.ejemplo.hibernateSimple;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Telefono {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int numero;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_est")
	private Estudiante estudiante;
	@OneToOne(fetch=FetchType.LAZY, targetEntity=TelefonoDetalles.class,
			mappedBy="telf", cascade= CascadeType.ALL)
	private TelefonoDetalles telefonoDetalles;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public TelefonoDetalles getTelefonoDetalles() {
		return telefonoDetalles;
	}
	public void setTelefonoDetalles(TelefonoDetalles telefonoDetalles) {
		this.telefonoDetalles = telefonoDetalles;
	}
	
}
