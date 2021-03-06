package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1


import java.util.Calendar;
import java.util.Date;
import java.util.List;






















import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.UsuarioDao;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.DireccionE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Encomienda.DTO_Coordenada;


public class Sucursal{

	private int idSucursal;
	private String descripcion;
	private String telefono;
	private Usuario gerente;
	private Direccion direccion;
	private List<Envio> enviosSucursalDestino;
	private List<Envio> enviosSucursalOrigen;
	private List<Encomienda> encomiendasSucursalDestino;
	private List<Encomienda> encomiendasSucursalOrigen;
	private List<Encomienda> encomiendasSucursalActual;
	private List<Usuario> usuarios; 
	private List<Vehiculo> vehiculos;
	private Coordenada coordenadas;

	public Sucursal() {
	}
	
	public Sucursal(String descripcion, String telefono) {
		super();
		this.descripcion = descripcion;
		this.telefono = telefono;
	}

	
	public Sucursal(String descripcion, String telefono,
			Usuario gerente, Direccion direccion) {
		super();
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.gerente = gerente;
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Sucursal [descripcion=" + descripcion + ", telefono="
				+ telefono + ", gerente=" + gerente + ", direccion="
				+ direccion + "]";
	}

	public int getIdSucursal() {
		return this.idSucursal;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Envio> getEnviosSucursalDestino() {
		return enviosSucursalDestino;
	}

	public void setEnviosSucursalDestino(List<Envio> enviosSucursalDestino) {
		this.enviosSucursalDestino = enviosSucursalDestino;
	}

	public List<Envio> getEnviosSucursalOrigen() {
		return enviosSucursalOrigen;
	}

	public void setEnviosSucursalOrigen(List<Envio> enviosSucursalOrigen) {
		this.enviosSucursalOrigen = enviosSucursalOrigen;
	}

	public Usuario getGerente() {
		return gerente;
	}

	public void setGerente(Usuario gerente) {
		this.gerente = gerente;
	}

	public List<Encomienda> getEncomiendasSucursalDestino() {
		return encomiendasSucursalDestino;
	}

	public void setEncomiendasSucursalDestino(
			List<Encomienda> encomiendasSucursalDestino) {
		this.encomiendasSucursalDestino = encomiendasSucursalDestino;
	}

	public List<Encomienda> getEncomiendasSucursalOrigen() {
		return encomiendasSucursalOrigen;
	}

	public void setEncomiendasSucursalOrigen(
			List<Encomienda> encomiendasSucursalOrigen) {
		this.encomiendasSucursalOrigen = encomiendasSucursalOrigen;
	}

	public List<Encomienda> getEncomiendasSucursalActual() {
		return encomiendasSucursalActual;
	}

	public void setEncomiendasSucursalActual(
			List<Encomienda> encomiendasSucursalActual) {
		this.encomiendasSucursalActual = encomiendasSucursalActual;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	
	

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}

	public DTO_Sucursal toDTO(){
		DTO_Sucursal s = new DTO_Sucursal();
		s.setId(this.idSucursal);
		s.setDescripcion(this.descripcion);
		s.setTelefono(this.telefono);
		s.setDireccion(this.getDireccion().toDTO());
		
		DTO_Coordenada coord = new DTO_Coordenada();
		if(this.getCoordenadas()!=null){
			coord.setLatitud(this.getCoordenadas().getLatitud());
			coord.setLongitud(this.getCoordenadas().getLongitud());
			s.setPosicionActual(coord);
		}
		if(this.getGerente()!=null)
			s.setIdGerente(this.getGerente().getIdUsuario());
		return s;
	}
	
	public SucursalE toEntity(){
		SucursalE suc = new SucursalE(this.idSucursal, this.descripcion, this.telefono);
		suc.setGerente(this.gerente.toEntity());
		DireccionE dir = new DireccionE(this.getDireccion().getPais().toEntity(), this.getDireccion().getProvincia().toEntity(), 
				this.getDireccion().getCalle(),this.getDireccion().getNro(), this.getDireccion().getLocalidad(),
				this.getDireccion().getCodigoPostal());
		suc.setDireccion(dir);
		
		CoordenadaE coord = new CoordenadaE();
		coord.setLatitud(this.getCoordenadas().getLatitud());
		coord.setLongitud(this.getCoordenadas().getLongitud());
		suc.setCoordenadas(coord);
		
		suc.setIdSucursal(this.getIdSucursal());
		return suc;
	}
	
	
	
	public void guardar() {	
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		SucursalDao.getInstancia().persist(this.toEntity());
		em.getTransaction().commit();
	}

	public void modificar() {
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();;
		em.getTransaction().begin();
		SucursalDao.getInstancia().saveOrUpdate(this.toEntity());
		em.getTransaction().commit();
	}

	public Sucursal fromDTO(DTO_Sucursal dto) {
		if(dto!=null){
			Sucursal suc = new Sucursal();
			if(dto.getId()!=null)
				suc.setIdSucursal(dto.getId());
			suc.setDescripcion(dto.getDescripcion());
			suc.setDireccion(new Direccion().fromDTO(dto.getDireccion()));
			
			Coordenada coord = new Coordenada();
			coord.setIdCoordenada(dto.getPosicionActual().getId());
			coord.setLatitud(dto.getPosicionActual().getLatitud());
			coord.setLongitud(dto.getPosicionActual().getLongitud());
			suc.setCoordenadas(coord);
			
			if(dto.getIdGerente()!=null){
				suc.setGerente(new Usuario().fromEntity(UsuarioDao.getInstancia().getById(dto.getIdGerente())));
			}
			suc.setTelefono(dto.getTelefono());
			return suc;
		}
		else
			return null;
	}

	public Sucursal fromEntity(SucursalE suc) {
		if(suc!=null){
			Sucursal sucursal = new Sucursal();
			sucursal.setDescripcion(suc.getDescripcion());
			sucursal.setDireccion(new Direccion().fromEntity(suc.getDireccion()));
			
			CoordenadaE coord = suc.getCoordenadas();
			if(coord!=null)
				sucursal.setCoordenadas(new Coordenada(coord.getLatitud(), coord.getLongitud()));
			
			if(suc.getGerente()!=null){
				sucursal.setGerente(new Usuario().fromEntity(UsuarioDao.getInstancia().getById(suc.getGerente().getIdUsuario())));
			}
			sucursal.setTelefono(suc.getTelefono());
			sucursal.setIdSucursal(suc.getIdSucursal());
			return sucursal;
		}
		else
			return null;
	}

}
