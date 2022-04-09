package com.ejemplo.hibernateSimple;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
	@Id
	private int id;
	private String nombre;
	private String apellido;
	@OneToMany(fetch= FetchType.LAZY, mappedBy="estudiante", targetEntity=Telefono.class)
	private Set telefonos;
	@OneToMany(fetch= FetchType.LAZY, mappedBy="estudiante", targetEntity=MateriaCursada.class)
	private Set<MateriaCursada> materiasCursadas;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="materia_cursada_2",
			catalog="abc",
			joinColumns= {
					@JoinColumn(name="est", nullable=false, updatable=false)
			},
			inverseJoinColumns= {
					@JoinColumn(name="id_mat", nullable=false, updatable=false)
			}
	)
	private Set<Materia> materias;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Set getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set telefonos) {
		this.telefonos = telefonos;
	}
	public Set<MateriaCursada> getMateriasCursadas() {
		return materiasCursadas;
	}
	public void setMateriasCursadas(Set<MateriaCursada> materiasCursadas) {
		this.materiasCursadas = materiasCursadas;
	}
	public Set<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}
	
}
