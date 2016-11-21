package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.ProductoEncomiendaE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ProductoEncomiendaDao extends GenericDao<ProductoEncomiendaE, Integer> {
	private static ProductoEncomiendaDao instancia;


	private ProductoEncomiendaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static ProductoEncomiendaDao getInstancia(){
		if(instancia == null){	
			instancia = new ProductoEncomiendaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public List<ProductoEncomiendaE> getByEncomienda(int idEncomienda) {
		List<ProductoEncomiendaE> productos = new ArrayList<ProductoEncomiendaE>();
		try{
			productos = entityManager.createQuery("from ProductoEncomiendaE p "
																	+ " where p.encomienda.idEncomienda=:idEncomienda")
																	.setParameter("idEncomienda", idEncomienda)
																	.getResultList();
		}
		catch(Exception e){
			System.out.println("No existen productos para esa encomienda");
		}
		return productos;
	}

}
