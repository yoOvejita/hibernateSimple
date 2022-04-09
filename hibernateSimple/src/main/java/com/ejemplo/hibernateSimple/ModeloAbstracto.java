package com.ejemplo.hibernateSimple;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;
import java.util.List;
public abstract class ModeloAbstracto<T> {
	private Class<T> entidad;
	protected SessionFactory sf = HibernateUtil.getSessionFactory();
	public ModeloAbstracto(Class<T> entidad) {
		super();
		this.entidad = entidad;
	}
	public T obtener(Object id) {
		T resultado = null;
		Session sesion= null;
		Transaction tx = null;
		try {
			sesion = sf.openSession();
			tx = sesion.beginTransaction();
			resultado = (T) sesion.get(entidad, (Serializable)id);
			tx.commit();
		}catch(Exception e) {
			if(tx != null)
				tx.rollback();
		}
		finally {
			sesion.close();
		}
		return resultado;
	}
	public boolean crear(T entidad) {
		boolean resultado = true;
		Session sesion= null;
		Transaction tx = null;
		try {
			sesion = sf.openSession();
			tx = sesion.beginTransaction();
			sesion.save(entidad);
			tx.commit();
		}catch(Exception e) {
			resultado = false;
			if(tx != null)
				tx.rollback();
		}
		finally {
			sesion.close();
		}
		return resultado;
	}
	public List<T> obtenerTotal() {
		List<T> resultado = null;
		Session sesion= null;
		Transaction tx = null;
		try {
			sesion = sf.openSession();
			tx = sesion.beginTransaction();
			resultado = sesion.createQuery("FROM " + entidad.getName()).list();
			tx.commit();
		}catch(Exception e) {
			if(tx != null)
				tx.rollback();
		}
		finally {
			sesion.close();
		}
		return resultado;
	}
}
