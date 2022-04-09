package com.ejemplo.hibernateSimple;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MAteriaModel mm = new MAteriaModel();
        Materia mat = new Materia();
        mat.setSigla("A1");
        mat.setDescripcion("Est una materia facil y divertida");
        mm.crear(mat);
        
    }

	private static Materia obtenerMat(Session sesion, int i) {
		Query consulta = sesion.createQuery("FROM Materia WHERE id = :id");
		consulta.setParameter("id", i);
		return (Materia)consulta.uniqueResult();
	}
	private static Estudiante obtenerEst(Session sesion, int i) {
		Query consulta = sesion.createQuery("FROM Estudiante WHERE id = :id");
		consulta.setParameter("id", i);
		return (Estudiante)consulta.uniqueResult();
	}
}


/*
 * DELIMITER $$
 * CREATE PROCEDURE intervalo(menor INTEGER, mayor INTEGER)
 * BEGIN
 * SELECT * FROM estudiante WHERE id BETWEEN menor AND mayor;
 * END $$
 * DELIMITER ;
 * 
 * 
 * CALL intervalo(10,20);
 * */







