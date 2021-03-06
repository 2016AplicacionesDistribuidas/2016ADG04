package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.List;
import java.util.Set;














import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.model.ProvinciaE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;


public class Provincia{

	private int idProvincia;
	private String descripcion;
	private List<Direccion> direcciones;
	private Pais pais;

	public Provincia() {
	}

	public Provincia(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public DTO_Provincia toDTO(){
		DTO_Provincia p = new DTO_Provincia();
		p.setDescripcion(this.descripcion);
	    p.setId(this.idProvincia);
	    p.setPais(this.getPais().toDTO());
		return p;
	}

	public ProvinciaE toEntity() {
		ProvinciaE p = new ProvinciaE();
		p.setDescripcion(this.descripcion);
	    p.setIdProvincia(this.idProvincia);
	    p.setPais(this.getPais().toEntity());
		return p;
	}

	public Provincia fromDTO(DTO_Provincia prove) {
		Provincia p  = new Provincia();
		p.setDescripcion(prove.getDescripcion());
		p.setIdProvincia(prove.getId());
		p.setPais(new Pais().fromDTO(prove.getPais()));
		return p;
	}
	
	public void guardar(){
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProvinciaDao.getInstancia().persist(this.toEntity());
		tx.commit();
	}

	public Provincia fromEntity(ProvinciaE prove) {
		Provincia p  = new Provincia();
		p.setDescripcion(prove.getDescripcion());
		p.setIdProvincia(prove.getIdProvincia());
		p.setPais(new Pais().fromEntity(prove.getPais()));
		return p;
	}
}
