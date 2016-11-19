package com.ADG04.Negocio;
// default package
// Generated Sep 8, 2016 3:23:54 PM by Hibernate Tools 3.4.0.CR1

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;










































import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.EnvioHistoricoDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.CoordenadaE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.EnvioHistoricoE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;



public class Envio{

	
	private int idEnvio;

	private Proveedor proveedor;
	private MapaDeRuta mapaDeRuta;
	private Coordenada posicionActual;
	private Sucursal sucursalDestino;
	private Sucursal sucursalOrigen;
	private Vehiculo vehiculo;
	private String estado;
	private Date fechaYHoraLlegadaEstimada;
	private Date fechaYHoraSalida;
	private boolean propio;
	private Integer nroTracking;
	private List<Encomienda> encomiendas;
	private Date fechaActualizacion;
	

	public Envio() {
	}

	public Envio(Proveedor proveedor, MapaDeRuta mapaDeRuta,
			Coordenada posicionActual, Sucursal sucursalDestino,
			Sucursal sucursalOrigen, Vehiculo vehiculo, String estado,
			Date fechaYHoraLlegadaEstimada, Date fechaYHoraSalida,
			boolean propio, Integer nroTracking) {
		super();
		this.proveedor = proveedor;
		this.mapaDeRuta = mapaDeRuta;
		this.posicionActual = posicionActual;
		this.sucursalDestino = sucursalDestino;
		this.sucursalOrigen = sucursalOrigen;
		this.vehiculo = vehiculo;
		this.estado = estado;
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
		this.fechaYHoraSalida = fechaYHoraSalida;
		this.propio = propio;
		this.nroTracking = nroTracking;
		this.fechaActualizacion = new Date();
	}



	public int getIdEnvio() {
		return this.idEnvio;
	}

	public void setIdEnvio(int idEnvio) {
		this.idEnvio = idEnvio;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Coordenada getPosicionActual() {
		return posicionActual;
	}

	public void setPosicionActual(Coordenada posicionActual) {
		this.posicionActual = posicionActual;
	}

	public void setPosicionActual(String latitud, String longitud){
		
		//Busco si hay una coordenada que coincide con esta latitud y longitud. Si esta, la uso. si no, la creo
		CoordenadaE coord = CoordenadaDao.getInstancia().getByLatitudLongitud(latitud, longitud);
		
		if(coord == null){
			coord = new CoordenadaE(latitud, longitud);
			CoordenadaDao.getInstancia().persist(coord);
		}
				
		this.posicionActual = new Coordenada(latitud, longitud);
		this.posicionActual.setIdCoordenada(coord.getIdCoordenada());
	}
	
	public MapaDeRuta getMapaDeRuta() {
		return mapaDeRuta;
	}

	public void setMapaDeRuta(MapaDeRuta mapaDeRuta) {
		this.mapaDeRuta = mapaDeRuta;
	}

	public Sucursal getSucursalDestino() {
		return sucursalDestino;
	}

	public void setSucursalDestino(Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return sucursalOrigen;
	}

	public void setSucursalOrigen(Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaYHoraLlegadaEstimada() {
		return fechaYHoraLlegadaEstimada;
	}


	public void setFechaYHoraLlegadaEstimada(Date fechaYHoraLlegadaEstimada) {
		this.fechaYHoraLlegadaEstimada = fechaYHoraLlegadaEstimada;
	}


	public Date getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(Date fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}


	public boolean isPropio() {
		return this.propio;
	}

	public void setPropio(boolean propio) {
		this.propio = propio;
	}

	public Integer getNroTracking() {
		return this.nroTracking;
	}

	public void setNroTracking(Integer nroTracking) {
		this.nroTracking = nroTracking;
	}

	public List<Encomienda> getEncomiendas() {
		return encomiendas;
	}

	public void setEncomiendas(List<Encomienda> encomiendas) {
		this.encomiendas = encomiendas;
	}
	
	

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Override
	public String toString() {
		return "Envio [idEnvio=" + idEnvio 
				+ ", posicionActual=" + posicionActual + ", sucursalDestino="
				+ sucursalDestino.getIdSucursal() + ", sucursalOrigen=" + sucursalOrigen.getIdSucursal()
				+ ", vehiculo=" + vehiculo.getIdVehiculo() + ", estado=" + estado
				+ ", fechaYHoraLlegadaEstimada=" + fechaYHoraLlegadaEstimada
				+ ", fechaYHoraSalida=" + fechaYHoraSalida + ", propio="
				+ propio + ", nroTracking=" + nroTracking + "]";
	}
	
	public DTO_Envio toDTO(){
		if(this.propio){
			DTO_EnvioPropio dto = new DTO_EnvioPropio();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			dto.setFechaYHoraLlegada(this.getFechaYHoraLlegadaEstimada());
			dto.setFechaYHoraSalida(this.getFechaYHoraSalida());
			dto.setIdHojaDeRuta(this.getMapaDeRuta().getIdMapaDeRuta());
			dto.setIdVehiculo(this.getVehiculo().getIdVehiculo());
			dto.setFechaActualizacion(fechaActualizacion);
			dto.setSucursalDestino(this.sucursalDestino.toDTO());
			dto.setSucursalOrigen(this.sucursalOrigen.toDTO());
			
			if(this.getEncomiendas() != null){
				List<DTO_Encomienda>lista = new ArrayList<DTO_Encomienda>();
				for(Encomienda enc : this.getEncomiendas()){
					lista.add(encomiendaToDTO(enc));
				}
				dto.setEncomiendas(lista);
			}
			
			dto.setIdSucursalDestino(this.sucursalDestino.getIdSucursal());
			dto.setIdSucursalOrigen(this.sucursalOrigen.getIdSucursal());
			
			return dto;
		}
		else{
			DTO_EnvioTercerizado dto = new DTO_EnvioTercerizado();
			dto.setId(this.getIdEnvio());
			dto.setEstado(this.getEstado());
			dto.setPosicionActual(this.getPosicionActual().toDTO());
			if(this.getProveedor()!=null)
				dto.setIdProveedor(this.getProveedor().getIdProveedor());
			dto.setNumeroTracking(String.valueOf(this.getNroTracking()));
			dto.setFechaActualizacion(fechaActualizacion);
			
			if(this.getEncomiendas() != null){
				List<DTO_Encomienda>lista = new ArrayList<DTO_Encomienda>();
				for(Encomienda enc : this.getEncomiendas()){
					lista.add(encomiendaToDTO(enc));
				}
				dto.setEncomiendas(lista);
			}
			
			dto.setIdSucursalDestino(this.sucursalDestino.getIdSucursal());
			dto.setIdSucursalOrigen(this.sucursalOrigen.getIdSucursal());
						
			return dto;
		}
	}
		
	/** 
	 * Ecomienda.toDTO sin agregarle loo envios.
	 * **/
	public DTO_Encomienda encomiendaToDTO(Encomienda enc) {
		
		DTO_Encomienda encomienda = new DTO_Encomienda();
		encomienda.setIdEncomienda(enc.getIdEncomienda());
		encomienda.setCliente(enc.getCliente().toDTO());

		encomienda.setSucursalOrigen(enc.getSucursalOrigen().toDTO());
		encomienda.setSucursalActual(enc.getSucursalActual().toDTO());
		encomienda.setSucursalDestino(enc.getSucursalDestino().toDTO());
		
		encomienda.setLargo(enc.getLargo());
		encomienda.setAncho(enc.getAncho());
		encomienda.setInternacional(enc.isInternacional());
		encomienda.setAlto(enc.getAlto());
		encomienda.setPeso(enc.getPeso());
		encomienda.setVolumen(enc.getVolumen());
		encomienda.setTratamiento(enc.getTratamiento()); 
		encomienda.setApilable(enc.getApilable());
		encomienda.setCantApilable(enc.getCantApilable()); 
		encomienda.setRefrigerado(enc.getRefrigerado());
		encomienda.setCondicionTransporte(enc.getCondicionTransporte()); 
		encomienda.setIndicacionesManipulacion(enc.getIndicacionesManipulacion());
		encomienda.setFragilidad(enc.getFragilidad()); 
		encomienda.setNombreReceptor(enc.getNombreReceptor()); 
		encomienda.setApellidoReceptor(enc.getApellidoReceptor());
		encomienda.setDniReceptor(enc.getDniReceptor()); 
		encomienda.setVolumenGranel(enc.getVolumenGranel()); 
		encomienda.setUnidadGranel(enc.getUnidadGranel());
		encomienda.setCargaGranel(enc.getCargaGranel());		
		
		encomienda.setTercerizada(enc.isTercerizado());
		encomienda.setEstado(enc.getEstado());
		encomienda.setFechaCreacion(enc.getFechaEstimadaEntrega());
		encomienda.setFechaEstimadaEntrega(enc.getFechaEstimadaEntrega());
		if(enc.getManifiesto()!=null)
			encomienda.setManifiesto(enc.getManifiesto().toDTO());
		
		if(enc.getRemito()!=null)
			encomienda.setRemito(enc.getRemito().toDTO());
		
		if(enc.factura != null)
			encomienda.setFactura(enc.factura.toDTO());

		return encomienda;
	}
	
	/*Actualiza la posicion con latitud y longitud, y actualiza el estado: 
	*   Pendiente,	//por salir en viaje
	* 	VehiculoCompleto, //se lleno la capacidad del vehiculo
	* 	EnViaje,	//esta en viaje
	* 	Desviado,   //el vehiculo asignado al envio no esta siguiendo la ruta acordada
	* 	Alerta,     //el vehiculo asignado hace 10 minutos que esta en otra ruta
	* 	Demorado,   //el envio llego mas tarde de lo pautado
	* 	Concluido   //llego a destino
	* La idea es llamar este metodo cada 5 minutos desde la web para actualizar el estado del envio. 
	* La coordenadaActual sera obtenida del XML provisto por los vehiculos.
	*/
	public void actualizarEstadoVehiculo(String latitud, String longitud) {
			
		this.setPosicionActual(latitud, longitud);
		
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		MapaDeRutaE mr = e.getMapaDeRuta();
		
		if(mr!=null){
			List<CoordenadaE> lista = mr.getCoordenadas();
			Boolean encontrado = false;
			
			for(CoordenadaE coord: mr.getCoordenadas()){
				if(posicionActual.getLatitud().equals(coord.getLatitud()) && posicionActual.getLongitud().equals(coord.getLongitud())){
					encontrado=true;
				}
			}
			
			if(!encontrado){
				if(e.getEstado().equals(EnvioEstado.EnViaje.toString())){
					e.setEstado(EnvioEstado.Desviado.toString());
					actualizarHistorico();
				}
				else {
					if(e.getEstado().equals(EnvioEstado.Desviado.toString())){
						e.setEstado(EnvioEstado.Alerta.toString());
						actualizarHistorico();
					}
				}
			}
			else{ //Si no esta desviado y estaba antes desviado, se volvera a poner en viaje
				if(e.getEstado().equals(EnvioEstado.Desviado.toString())){
					e.setEstado(EnvioEstado.EnViaje.toString());
					actualizarHistorico();
				}
			}
			CoordenadaE coorE = CoordenadaDao.getInstancia().getById(posicionActual.getIdCoordenada());
			e.setPosicionActual(coorE);
			e.setFechaActualizacion(new Date());
			EnvioDao.getInstancia().persist(e);
		}
	}
	
	public void estaEnvioDemorado(){
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		Date hoy = new Date();
		if(e.getFechaYHoraLlegadaEstimada().compareTo(hoy)<0){
			if(!e.getEstado().equals("Demorado")){
				e.setEstado(EnvioEstado.Demorado.toString());
				e.setFechaActualizacion(new Date());
				EnvioDao.getInstancia().saveOrUpdate(e);
				actualizarHistorico();
			}
		}
	}

	public void actualizarEstado(String estado){
		/*
		Pendiente,	//por salir en viaje
		VehiculoCompleto, //se lleno la capacidad del vehiculo
		EnViaje,	//esta en viaje
		Desviado,   //el vehiculo asignado al envio no esta siguiendo la ruta acordada
		Alerta,     //el vehiculo asignado hace 10 minutos que esta en otra ruta
		Demorado,   //el envio llego mas tarde de lo pautado
		Concluido   //llego a destino*/
				
		if(estado.equals(EnvioEstado.Concluido.toString()))
			concluirEnvio();
		
		EnvioE envioE = EnvioDao.getInstancia().getById(this.idEnvio);
		envioE.setEstado(estado);
		EnvioDao.getInstancia().saveOrUpdate(envioE);
		actualizarHistorico();
	}
	
	public void concluirEnvio() {
		
		EnvioE e = EnvioDao.getInstancia().getById(idEnvio);
		//EncomiendaE enc = EncomiendaDao.getInstancia().getByEnvio(idEnvio);
		List<EncomiendaE> encomiendasEntities = e.getEncomiendas();
		
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//Pongo como concluídas las encomiendas que están en este envío.
		for(EncomiendaE enc:encomiendasEntities)
		{
			try{
				enc.setSucursalActual(e.getSucursalDestino());
				
				//Si la encomienda llego a su destino final (sucursalDestino)
				//se indica como EnSucursalDestino
				if(e.getSucursalDestino()==enc.getSucursalDestino())
					enc.setEstado(EncomiendaEstado.EnSucursalDestino.toString());
				else //Espera nueva asignacion
					enc.setEstado(EncomiendaEstado.EnEsperaAsignacion.toString());
				
				EncomiendaDao.getInstancia().saveOrUpdate(enc);
				e.setEstado(EnvioEstado.Concluido.toString());
				e.setFechaActualizacion(new Date());
				EnvioDao.getInstancia().saveOrUpdate(e);
				/*actualizo posicion del vehiculo al llegar a sucursal destino*/
				VehiculoE veh = e.getVehiculo();
				veh.setSucursal(e.getSucursalDestino());
				VehiculoDao.getInstancia().saveOrUpdate(veh);
			}
			catch(Exception exc){
				System.out.println("Error al concluir envio");
				exc.printStackTrace();
			}
			
		}
		
		tx.commit();
		actualizarHistorico();
	}
	
	public void actualizarHistorico(){
		EnvioHistoricoE eh = new EnvioHistoricoE(this.getEstado(),new Date(),this.toEntity());
		
		EntityManager em = EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		EnvioHistoricoDao.getInstancia().persist(eh);
		tx.commit();
	}

	public EnvioE toEntity(){
		EnvioE  env = new EnvioE();
		env.setIdEnvio(this.idEnvio);
		env.setEstado(estado);
		env.setFechaYHoraLlegadaEstimada(fechaYHoraLlegadaEstimada);
		env.setFechaYHoraSalida(fechaYHoraSalida);
		env.setIdEnvio(idEnvio);
		env.setNroTracking(nroTracking);
		env.setPropio(propio);
		env.setMapaDeRuta(MapaDeRutaDao.getInstancia().getById(this.mapaDeRuta.getIdMapaDeRuta()));
		if(proveedor!=null)
			env.setProveedor(ProveedorDao.getInstancia().getById(this.proveedor.getIdProveedor()));
		if(vehiculo!=null)
			env.setVehiculo(VehiculoDao.getInstancia().getById(this.vehiculo.getIdVehiculo()));
		env.setPosicionActual(CoordenadaDao.getInstancia().getById(this.posicionActual.getIdCoordenada()));
		env.setSucursalDestino(SucursalDao.getInstancia().getById(this.getSucursalDestino().getIdSucursal()));
		env.setSucursalOrigen(SucursalDao.getInstancia().getById(this.getSucursalOrigen().getIdSucursal()));
		env.setFechaActualizacion(fechaActualizacion);
		
		return env;
	}
	
	public Envio fromEntity(EnvioE e){
		
		Envio  env = new Envio();
		env.setEstado(e.getEstado());
		env.setFechaYHoraLlegadaEstimada(e.getFechaYHoraLlegadaEstimada());
		env.setFechaYHoraSalida(e.getFechaYHoraSalida());
		env.setIdEnvio(e.getIdEnvio());
		env.setNroTracking(e.getNroTracking());
		env.setPropio(e.isPropio());
		env.setFechaActualizacion(e.getFechaActualizacion());
		
		MapaDeRuta mapa = null;
		if(e.getMapaDeRuta()==null){
			MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalOrigen().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
			mapa = new MapaDeRuta().fromEntity(mr);
		}
		else{
			mapa = new MapaDeRuta().fromEntity(e.getMapaDeRuta());
		}
		
		if(mapa!=null)
			env.setMapaDeRuta(mapa);	
		
		env.setProveedor(new Proveedor().fromEntity(e.getProveedor()));
		
		if(e.getVehiculo() != null)
			env.setVehiculo(new Vehiculo().fromEntity(e.getVehiculo()));
		
		env.setPosicionActual(new Coordenada().fromEntity(e.getPosicionActual()));
		env.setSucursalDestino(new Sucursal().fromEntity(e.getSucursalDestino()));
		env.setSucursalOrigen(new Sucursal().fromEntity(e.getSucursalOrigen()));
		
		if(e.getEncomiendas()!=null){
			List<Encomienda> lista = new ArrayList<Encomienda>();
			for(EncomiendaE enc : e.getEncomiendas()){
				Encomienda en = new Encomienda().fromEntity(enc);
				lista.add(en);
			}
			env.setEncomiendas(lista);
		}
		return env;
	}
	
}
