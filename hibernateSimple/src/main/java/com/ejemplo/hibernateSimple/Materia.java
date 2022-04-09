package com.ejemplo.hibernateSimple;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="materia")
public class Materia {
	@Id
	@GenericGenerator(name="genMat", strategy="com.ejemplo.hibernateSimple.GeneradorMateria")
	@GeneratedValue(generator="genMat")
	private int id;
	private String sigla, descripcion;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="materia_cursada_2",
			catalog="abc",
			joinColumns= {
					@JoinColumn(name="id_mat", nullable=false, updatable=false)
			},
			inverseJoinColumns= {
					@JoinColumn(name="est", nullable=false, updatable=false)
			}
	)
	private Set<Estudiante> estudiantes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
}
