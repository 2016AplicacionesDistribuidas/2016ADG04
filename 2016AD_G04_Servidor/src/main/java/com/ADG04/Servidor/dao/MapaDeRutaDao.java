package com.ADG04.Servidor.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.util.EntityManagerProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MapaDeRutaDao extends GenericDao<MapaDeRutaE, Integer> {

	
	private static MapaDeRutaDao instancia;


	private MapaDeRutaDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public static MapaDeRutaDao getInstancia(){
		if(instancia == null){	
			instancia = new MapaDeRutaDao(EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager());
		} 
		return instancia;
	}

	public MapaDeRutaE getBySucursalOrigenyDestino(int idSucursalOrigen, int idSucursalDestino) {
		try{
			MapaDeRutaE mapa= (MapaDeRutaE) entityManager.createQuery("from MapaDeRutaE mr where mr.sucursalOrigen.idSucursal=:idSucursalOrigen"
				+ " and mr.sucursalDestino.idSucursal=:idSucursalDestino")
				.setParameter("idSucursalOrigen", idSucursalOrigen)
				.setParameter("idSucursalDestino", idSucursalDestino).getSingleResult();
			return mapa;
		}
		catch(Exception e){
			return null;
		}
	}

}
