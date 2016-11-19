package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
























import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.Exceptions.NoHayVehiculosDisponiblesException;
import com.ADG04.Repositorio.Exceptions.SucursalNotFoundException;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ItemFacturaDao;
import com.ADG04.Servidor.dao.ManifiestoDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.RemitoDao;
import com.ADG04.Servidor.dao.SeguroDao;
import com.ADG04.Servidor.dao.ServicioSeguridadDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.FacturaE;
import com.ADG04.Servidor.model.ItemFacturaE;
import com.ADG04.Servidor.model.ItemManifiestoE;
import com.ADG04.Servidor.model.ItemRemitoE;
import com.ADG04.Servidor.model.ManifiestoE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.ProductoE;
import com.ADG04.Servidor.model.ProveedorE;
import com.ADG04.Servidor.model.RemitoE;
import com.ADG04.Servidor.model.SeguroE;
import com.ADG04.Servidor.model.ServicioSeguridadE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.model.VehiculoE;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_Remito;


public  class Encomienda{

	protected int idEncomienda;
	protected Direccion direccionDestino;
	protected Sucursal sucursalDestino;
	protected Sucursal sucursalOrigen;
	protected Direccion direccionOrigen;
	protected Sucursal sucursalActual;
	protected Cliente cliente;

	protected Date fechaCreacion;
	protected Date fechaEstimadaEntrega;
	protected String estado;
	protected boolean tercerizado;
	protected float largo;
	protected float alto;
	protected float ancho;
	protected float peso;
	protected float volumen;
	protected String tratamiento;
	protected Boolean apilable;
	protected Short cantApilable;
	protected Boolean refrigerado;
	protected String condicionTransporte;
	protected String indicacionesManipulacion;
	protected String fragilidad;
	protected String nombreReceptor;
	protected String apellidoReceptor;
	protected String dniReceptor;
	protected float volumenGranel;
	protected String unidadGranel;
	protected String cargaGranel;

	protected ServicioSeguridad servicioSeguridad;
	protected Manifiesto manifiesto;
	protected Factura factura;
	protected Remito remito;
	protected boolean internacional;
	protected List<Envio> envios;
	
	public Encomienda() {
		this.envios = new ArrayList<Envio>();
	}

	
	
	protected Encomienda(Direccion direccionDestino, Sucursal sucursalDestno,
			Sucursal sucursalOrigen, Direccion direccionOrigen,
			Sucursal sucursalActual, Cliente cliente, Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado, boolean tercerizado,
			float largo, float alto, float ancho, float peso, float volumen,
			String tratamiento, Boolean apilable, Short cantApilable,
			Boolean refrigerado, String condicionTransporte,
			String indicacionesManipulacion, String fragilidad,
			String nombreReceptor, String apellidoReceptor, String dniReceptor,
			float volumenGranel, String unidadGranel, String cargaGranel,
			ServicioSeguridad servicioSeguridad,
			Manifiesto manifiesto, Remito remito,
			boolean internacional) {
		super();
		this.direccionDestino = direccionDestino;
		this.sucursalDestino = sucursalDestno;
		this.sucursalOrigen = sucursalOrigen;
		this.direccionOrigen = direccionOrigen;
		this.sucursalActual = sucursalActual;
		this.cliente = cliente;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		this.tercerizado = tercerizado;
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		this.peso = peso;
		this.volumen = volumen;
		this.tratamiento = tratamiento;
		this.apilable = apilable;
		this.cantApilable = cantApilable;
		this.refrigerado = refrigerado;
		this.condicionTransporte = condicionTransporte;
		this.indicacionesManipulacion = indicacionesManipulacion;
		this.fragilidad = fragilidad;
		this.nombreReceptor = nombreReceptor;
		this.apellidoReceptor = apellidoReceptor;
		this.dniReceptor = dniReceptor;
		this.volumenGranel = volumenGranel;
		this.unidadGranel = unidadGranel;
		this.cargaGranel = cargaGranel;
		this.servicioSeguridad = servicioSeguridad;
		this.manifiesto = manifiesto;
		this.factura = factura;
		this.remito = remito;
		this.internacional = internacional;
		this.envios = new ArrayList<Envio>();
	}



	public Encomienda(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
			Sucursal sucursalOrigen, Cliente cliente,
			Date fechaCreacion, Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			{
	//	this.itemFactura = itemFactura;
		this.sucursalDestino = sucursalDestino;
		//this.envio = envio;
		this.sucursalOrigen = sucursalOrigen;
		this.cliente = cliente;
		this.fechaCreacion = fechaCreacion;
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
		this.estado = estado;
		//this.tercerizado = tercerizado;
		//this.nombreReceptor = nombreReceptor;
	//	this.apellidoReceptor = apellidoReceptor;
	//	this.dniReceptor = dniReceptor;
	}
	

	public int getIdEncomienda() {
		return this.idEncomienda;
	}

	public void setIdEncomienda(int idEncomienda) {
		this.idEncomienda = idEncomienda;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Direccion getDireccionDestino() {
		return this.direccionDestino;
	}

	public void setDireccionDestino(
			Direccion direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public Sucursal getSucursalDestino() {
		return this.sucursalDestino;
	}

	public void setSucursalDestino(
			Sucursal sucursalDestino) {
		this.sucursalDestino = sucursalDestino;
	}

	public Sucursal getSucursalOrigen() {
		return this.sucursalOrigen;
	}

	public void setSucursalOrigen(
			Sucursal sucursalOrigen) {
		this.sucursalOrigen = sucursalOrigen;
	}

	public Direccion getDireccionOrigen() {
		return this.direccionOrigen;
	}

	public void setDireccionOrigen(
			Direccion direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}


	public Sucursal getSucursalActual() {
		return this.sucursalActual;
	}

	public void setSucursalActual(Sucursal sucursalActual) {
		this.sucursalActual = sucursalActual;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEstimadaEntrega() {
		return this.fechaEstimadaEntrega;
	}

	public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) {
		this.fechaEstimadaEntrega = fechaEstimadaEntrega;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isTercerizado() {
		return this.tercerizado;
	}

	public void setTercerizado(boolean tercerizado) {
		this.tercerizado = tercerizado;
	}

	public float getLargo() {
		return this.largo;
	}

	public void setLargo(float largo) {
		this.largo = largo;
	}

	public float getAlto() {
		return this.alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public float getAncho() {
		return this.ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getPeso() {
		return this.peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getVolumen() {
		return this.volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	public String getTratamiento() {
		return this.tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Boolean getApilable() {
		return this.apilable;
	}

	public void setApilable(Boolean apilable) {
		this.apilable = apilable;
	}

	public Short getCantApilable() {
		return this.cantApilable;
	}

	public void setCantApilable(Short cantApilable) {
		this.cantApilable = cantApilable;
	}

	public Boolean getRefrigerado() {
		return this.refrigerado;
	}

	public void setRefrigerado(Boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public String getCondicionTransporte() {
		return this.condicionTransporte;
	}

	public void setCondicionTransporte(String condicionTransporte) {
		this.condicionTransporte = condicionTransporte;
	}

	public String getIndicacionesManipulacion() {
		return this.indicacionesManipulacion;
	}

	public void setIndicacionesManipulacion(String indicacionesManipulacion) {
		this.indicacionesManipulacion = indicacionesManipulacion;
	}

	public String getFragilidad() {
		return this.fragilidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public String getNombreReceptor() {
		return this.nombreReceptor;
	}

	public void setNombreReceptor(String nombreReceptor) {
		this.nombreReceptor = nombreReceptor;
	}

	public String getApellidoReceptor() {
		return this.apellidoReceptor;
	}

	public void setApellidoReceptor(String apellidoReceptor) {
		this.apellidoReceptor = apellidoReceptor;
	}

	public String getDniReceptor() {
		return this.dniReceptor;
	}

	public void setDniReceptor(String dniReceptor) {
		this.dniReceptor = dniReceptor;
	}

	public float getVolumenGranel() {
		return this.volumenGranel;
	}

	public void setVolumenGranel(float volumenGranel) {
		this.volumenGranel = volumenGranel;
	}

	public String getUnidadGranel() {
		return this.unidadGranel;
	}

	public void setUnidadGranel(String unidadGranel) {
		this.unidadGranel = unidadGranel;
	}

	public String getCargaGranel() {
		return this.cargaGranel;
	}

	public void setCargaGranel(String cargaGranel) {
		this.cargaGranel = cargaGranel;
	}

	
	public ServicioSeguridad getServicioSeguridad() {
		return servicioSeguridad;
	}

	public void setServicioSeguridad(ServicioSeguridad servicioSeguridad) {
		this.servicioSeguridad = servicioSeguridad;
	}

	public Manifiesto getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(Manifiesto manifiesto) {
		this.manifiesto = manifiesto;
	}

	public Remito getRemito() {
		return remito;
	}

	public void setRemito(Remito remito) {
		this.remito = remito;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}
	
	public boolean isTerciarizado() {
		return tercerizado;
	}

	public void setTerciarizado(boolean terciarizado) {
		this.tercerizado = terciarizado;
	}
	
	public Integer asignarEnvio(Integer idCarrier) throws BusinessException {
		
		/*antes de asignar busco encomiendas por vencer asi ya las pongo en viaje 
		 * y asi marco esos envios y vehiculos como no disponibles*/
		ponerEnViajeEncomiendasPorVencer();
		
		EncomiendaE e = EncomiendaDao.getInstancia().getById(idEncomienda);
		System.out.println(e.toString());
		Integer idEnvio = null;
		if(e != null){
			if(esEnvioTercerizado()){ 
				EnvioE envioTercerizado = new EnvioE();
				if(e.isInternacional()){
					ProveedorE prov = ProveedorDao.getInstancia().getById(idCarrier);
					envioTercerizado.setProveedor(prov);
				}
				MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalActual().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
				envioTercerizado.setNroTracking(2000);
				envioTercerizado.setSucursalOrigen(e.getSucursalOrigen());
				envioTercerizado.setSucursalDestino(e.getSucursalDestino());
				envioTercerizado.setFechaYHoraSalida(new Date());
				envioTercerizado.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
				envioTercerizado.setMapaDeRuta(mr);
				envioTercerizado.setPropio(false);
				envioTercerizado.setFechaActualizacion(new Date());
				List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
				lista.add(e);
				envioTercerizado.setEncomiendas(lista);
				e.setEstado(EncomiendaEstado.Colocada.toString());
				
				EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioTercerizado);;
				EncomiendaDao.getInstancia().saveOrUpdate(e);
				
				Envio env = new Envio().fromEntity(envio);
				env.actualizarHistorico();
				
				idEnvio = envio.getIdEnvio();
			} else {
				//Busco si ya hay algun envio que vaya a la misma ciudad y pendientes
				boolean nuevoEnvio = true;
				List<EnvioE> envios = EnvioDao.getInstancia().listarEnviosPorSucursalDestino(e.getSucursalDestino().getIdSucursal(), e.getFechaEstimadaEntrega());
				boolean pesoOK = false;
				boolean volumenOK = false;
				for(EnvioE envProp: envios){
					if(!pesoOK || !volumenOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
						//Sumo los pesos y los volumenes
						float peso = 0;
						float volumen = 0;
						float pesoTotal = envProp.getVehiculo().getPeso() - envProp.getVehiculo().getTara();
						float volumenTotal = envProp.getVehiculo().getVolumen();
						for(EncomiendaE enc: envProp.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
						
						//Verifico si entra el nuevo pedido
						if(pesoTotal >= peso + e.getPeso()){
							pesoOK = true;
						}
						if(volumenTotal >= volumen + e.getVolumen()){
							volumenOK = true;
						}
	
						if(pesoOK && volumenOK){ //lo asigno a este envio
							
							List<EncomiendaE> encomiendas = envProp.getEncomiendas();
							encomiendas.add(e);
							envProp.setEncomiendas(encomiendas);
							envProp.setPropio(true);
							envProp.setFechaActualizacion(new Date());
					
							float volumen70 = (float)(volumen + e.getVolumen()/volumenTotal);
							float peso70 = (float)(peso + e.getPeso()/pesoTotal);
							
							if(peso70 > 0.7 || volumen70 > 0.7){
								envProp.setEstado("Listo");
							}
						
							e.setEstado(EncomiendaEstado.Colocada.toString());
							
							EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envProp);
							EncomiendaDao.getInstancia().saveOrUpdate(e);
							nuevoEnvio = false;
							
							Envio env = new Envio().fromEntity(envio);
							env.actualizarHistorico();
							
							idEnvio =  envio.getIdEnvio();
						} 
					}
				}//End loop
				
				//Es un nuevo envio por que no se encontro camion disponible
				if (nuevoEnvio){
					//Buscar Vehiculo para asignar que no pertezca a un envio en curso (<>Pendiente)
					List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(e.getSucursalActual().getIdSucursal(),  e.getVolumen(), e.getPeso());
					boolean pesoNuevoOK = false;
					boolean volumenNuevoOK = false;
					
					if(vehiculosDisponibles.size() == 0) {
						//System.out.println("No hay vehículos disponibles para generar el envío");
						throw new NoHayVehiculosDisponiblesException(this.getSucursalOrigen().getIdSucursal());
					} else {
						for(VehiculoE v: vehiculosDisponibles){
							//Sumo los pesos y los volumenes
							if(!pesoNuevoOK || !volumenNuevoOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
								float pesoTotal = v.getPeso() - v.getTara();
								float volumenTotal = v.getVolumen();
								
								
								//Verifico si entra el nuevo pedido
								if(pesoTotal >= e.getPeso()){
									pesoNuevoOK = true;
								}
								if(volumenTotal >= e.getVolumen()){
									volumenNuevoOK = true;
								}
								if(pesoNuevoOK && volumenNuevoOK){ //lo asigno a este envio
									//Genero el envio
									
									MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalActual().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
									
									EnvioE envioPropio = new EnvioE();
									envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									envioPropio.setFechaYHoraSalida(new Date());
									
									envioPropio.setPosicionActual(e.getSucursalActual().getCoordenadas());
									envioPropio.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
									envioPropio.setVehiculo(v);
									envioPropio.setPropio(true);
									envioPropio.setFechaActualizacion(new Date());
								
									envioPropio.setSucursalOrigen(e.getSucursalActual());
									envioPropio.setSucursalDestino(e.getSucursalDestino());
									envioPropio.setMapaDeRuta(mr);
									List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
									lista.add(e);
									envioPropio.setEncomiendas(lista);
									float volumen70 = (float)(e.getVolumen()/volumenTotal);
									float peso70 = (float)(e.getPeso()/pesoTotal);
									
									if(peso70 > 0.7 || volumen70 > 0.7){
										e.setEstado(EncomiendaEstado.Colocada.toString());
										envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									}
									
									EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioPropio);
									EncomiendaDao.getInstancia().saveOrUpdate(e);
									
									Envio env = new Envio().fromEntity(envio);
									env.actualizarHistorico();
									
									idEnvio =  envio.getIdEnvio();
								}
							}
						}//End for
					}
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
		

		/*Coloco las encomiendas en viaje y envio en viaje si hay encomiendas por vencer*/
		ponerEnViajeEncomiendasPorVencer();
		
		return idEnvio;
	}
	
	public void ponerEnViajeEncomiendasPorVencer(){
		List<EncomiendaE> encomiendasColocadasPorVencer = EncomiendaDao.getInstancia().obtenerEncomiendasColocadasPorVencerHoy();
		for(EncomiendaE enc : encomiendasColocadasPorVencer){
		      enc.setEstado(EncomiendaEstado.EnViaje.toString());
		      EnvioE envio = EnvioDao.getInstancia().getByEncomiendaColocada(enc.getIdEncomienda());
		      if(envio!=null){
			      envio.setEstado(EnvioEstado.EnViaje.toString());
			      
				  EncomiendaDao.getInstancia().saveOrUpdate(enc);
				  EnvioDao.getInstancia().saveOrUpdate(envio);
		      }
		}
	}
	
	
	
	/*Asignar envio manualmente indicando sucursal de destino */
	public Integer asignarEnvio(Integer idCarrier, int idSucursalDest) throws BusinessException {
		
		/*antes de asignar busco encomiendas por vencer asi ya las pongo en viaje 
		 * y asi marco esos envios y vehiculos como no disponibles*/
		ponerEnViajeEncomiendasPorVencer();
		
		EncomiendaE e = EncomiendaDao.getInstancia().getById(idEncomienda);
		System.out.println(e.toString());
		Integer idEnvio = null;
		if(e != null){
			if(esEnvioTercerizado()){ 
				EnvioE envioTercerizado = new EnvioE();
				if(e.isInternacional()){
					ProveedorE prov = ProveedorDao.getInstancia().getById(idCarrier);
					envioTercerizado.setProveedor(prov);
				}
				MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalActual().getIdSucursal(), e.getSucursalDestino().getIdSucursal());
				envioTercerizado.setEstado(EnvioEstado.Pendiente.toString());
				envioTercerizado.setPosicionActual(e.getSucursalActual().getCoordenadas());
				envioTercerizado.setNroTracking(2000);
				envioTercerizado.setSucursalOrigen(e.getSucursalOrigen());
				envioTercerizado.setSucursalDestino(e.getSucursalDestino());
				envioTercerizado.setFechaYHoraSalida(new Date());
				envioTercerizado.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
				envioTercerizado.setMapaDeRuta(mr);
				envioTercerizado.setPropio(false);
				envioTercerizado.setFechaActualizacion(new Date());
				List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
				lista.add(e);
				envioTercerizado.setEncomiendas(lista);
				e.setEstado(EncomiendaEstado.Colocada.toString());
				
				EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioTercerizado);;
				EncomiendaDao.getInstancia().saveOrUpdate(e);
				
				Envio env = new Envio().fromEntity(envio);
				env.actualizarHistorico();
				
				idEnvio = envio.getIdEnvio();
			} else {
				//Busco si ya hay algun envio que vaya a la misma ciudad y pendientes
				boolean nuevoEnvio = true;
				List<EnvioE> envios = EnvioDao.getInstancia().listarEnviosPorSucursalDestino(idSucursalDest, e.getFechaEstimadaEntrega());
				boolean pesoOK = false;
				boolean volumenOK = false;
				for(EnvioE envProp: envios){
					if(!pesoOK || !volumenOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
						//Sumo los pesos y los volumenes
						float peso = 0;
						float volumen = 0;
						float pesoTotal = envProp.getVehiculo().getPeso() - envProp.getVehiculo().getTara();
						float volumenTotal = envProp.getVehiculo().getVolumen();
						for(EncomiendaE enc: envProp.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
						
						//Verifico si entra el nuevo pedido
						if(pesoTotal >= peso + e.getPeso()){
							pesoOK = true;
						}
						if(volumenTotal >= volumen + e.getVolumen()){
							volumenOK = true;
						}
	
						if(pesoOK && volumenOK){ //lo asigno a este envio
							
							List<EncomiendaE> encomiendas = envProp.getEncomiendas();
							encomiendas.add(e);
							envProp.setEncomiendas(encomiendas);
							envProp.setPropio(true);
							envProp.setFechaActualizacion(new Date());
					
							float volumen70 = (float)(volumen + e.getVolumen()/volumenTotal);
							float peso70 = (float)(peso + e.getPeso()/pesoTotal);
							
							if(peso70 > 0.7 || volumen70 > 0.7){
								envProp.setEstado("Listo");
							}
						
							e.setEstado(EncomiendaEstado.Colocada.toString());
							
							EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envProp);
							EncomiendaDao.getInstancia().saveOrUpdate(e);
							nuevoEnvio = false;
							
							Envio env = new Envio().fromEntity(envio);
							env.actualizarHistorico();
							
							idEnvio =  envProp.getIdEnvio();
						} 
					}
				}//End loop
				
				//Es un nuevo envio por que no se encontro camion disponible
				if (nuevoEnvio){
					//Buscar Vehiculo para asignar que no pertezca a un envio en curso (<>Pendiente)
					List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(e.getSucursalActual().getIdSucursal(),  e.getVolumen(), e.getPeso());
					boolean pesoNuevoOK = false;
					boolean volumenNuevoOK = false;
					
					if(vehiculosDisponibles.size() == 0) {
						throw new NoHayVehiculosDisponiblesException(this.getSucursalDestino().getIdSucursal());
					} else {
						for(VehiculoE v: vehiculosDisponibles){
							//Sumo los pesos y los volumenes
							if(!pesoNuevoOK || !volumenNuevoOK){ //si peso y volumen dan ok, significa que ya fue asignada la encomienda al envio
								float pesoTotal = v.getPeso() - v.getTara();
								float volumenTotal = v.getVolumen();
								
								
								//Verifico si entra el nuevo pedido
								if(pesoTotal >= e.getPeso()){
									pesoNuevoOK = true;
								}
								if(volumenTotal >= e.getVolumen()){
									volumenNuevoOK = true;
								}
								if(pesoNuevoOK && volumenNuevoOK){ //lo asigno a este envio
									//Genero el envio
									
									MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(e.getSucursalActual().getIdSucursal(), idSucursalDest);
									
									EnvioE envioPropio = new EnvioE();
									envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									envioPropio.setFechaYHoraSalida(new Date());
									
									envioPropio.setPosicionActual(e.getSucursalActual().getCoordenadas());
									envioPropio.setFechaYHoraLlegadaEstimada(e.getFechaEstimadaEntrega());
									envioPropio.setVehiculo(v);
									envioPropio.setPropio(true);
									envioPropio.setFechaActualizacion(new Date());
								
									envioPropio.setSucursalOrigen(e.getSucursalActual());
									envioPropio.setSucursalDestino(SucursalDao.getInstancia().getById(idSucursalDest));
									envioPropio.setMapaDeRuta(mr);
									List<EncomiendaE> lista = new ArrayList<EncomiendaE>();
									lista.add(e);
									envioPropio.setEncomiendas(lista);
									float volumen70 = (float)(e.getVolumen()/volumenTotal);
									float peso70 = (float)(e.getPeso()/pesoTotal);
									
									if(peso70 > 0.7 || volumen70 > 0.7){
										e.setEstado(EncomiendaEstado.Colocada.toString());
										envioPropio.setEstado(EnvioEstado.Pendiente.toString());
									}
									
									EnvioE envio = EnvioDao.getInstancia().saveOrUpdate(envioPropio);
									EncomiendaDao.getInstancia().saveOrUpdate(e);
									
									Envio env = new Envio().fromEntity(envio);
									env.actualizarHistorico();
									
									idEnvio =  envio.getIdEnvio();
								}
							}
						}//End for
					}
				}//End Nuevo Envio
			}//End if else envio propio/tercerizado
		}//End if no encontro encomienda
			/*Coloco las encomiendas en viaje y envio en viaje si hay encomiendas por vencer*/
		ponerEnViajeEncomiendasPorVencer();
		
		return idEnvio;
	}
	
	/* En base al envio indicado calcula el tiempo total de viaje a la sucursal destino
	 * original de la encomienda y avisa si habra demora o no. 
	 * Asume que desde el nuevo destino indicado por el envio se mandara luego directamente
	 * a la sucursal destino original de la encomienda y compara la nueva fecha de llegada
	 * con la fecha estimada original  de la encomienda.*/
	public boolean existeDemoraEntrega(int idEnvio){
		EnvioE envio = EnvioDao.getInstancia().getById(idEnvio);
		MapaDeRutaE mr = envio.getMapaDeRuta();
		MapaDeRuta mapaEnvio = new MapaDeRuta().fromEntity(mr);
		Date fechaLLegadaEnvio = mapaEnvio.calcularFechaEstimadaDeEntrega();
		
		//Si el envio no lleva directamente la encomienda a la sucursal destino
		if(mr.getSucursalDestino().getIdSucursal()!=this.getSucursalDestino().getIdSucursal()){
			MapaDeRutaE mr2 = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(mr.getSucursalDestino().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
			MapaDeRuta mapaASucursalDestinoEncomienda = new MapaDeRuta().fromEntity(mr2);
			
			Date fechaLlegadaADestino =mapaASucursalDestinoEncomienda.calcularFechaEstimadaDeEntrega(fechaLLegadaEnvio);
			System.out.println(fechaLlegadaADestino);
			if(fechaLlegadaADestino.after(this.getFechaEstimadaEntrega()))
				return true;
		
		}
		return false;
	}
	
	

	public Seguro getSeguro() {
		Seguro p = new Seguro();
		p.setTarifa(123.0F);
		p.setTarifaPorKm(456.0F);
		//TODO: revisar
		//p.setProveedor(ProveedorDao.getInstancia().getById(1));
		p.setProveedor(new Proveedor(1));
		return p;
	}

	

	@Override
	public String toString() {
		return "Encomienda [cliente=" + cliente.getIdCliente()
				+ ", fechaCreacion=" + fechaCreacion
				+ ", fechaEstimadaEntrega=" + fechaEstimadaEntrega
				+ ", estado=" + estado + ", tercerizado=" + tercerizado
				+ ", largo=" + largo + ", alto=" + alto + ", ancho=" + ancho
				+ ", peso=" + peso + ", volumen=" + volumen + ", tratamiento="
				+ tratamiento + ", apilable=" + apilable + ", cantApilable="
				+ cantApilable + ", refrigerado=" + refrigerado
				+ ", condicionTransporte=" + condicionTransporte
				+ ", indicacionesManipulacion=" + indicacionesManipulacion
				+ ", fragilidad=" + fragilidad + ", nombreReceptor="
				+ nombreReceptor + ", apellidoReceptor=" + apellidoReceptor
				+ ", dniReceptor=" + dniReceptor + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel + ", terciarizado=" + tercerizado +""
						+ " internacional +" + internacional + "]";
	}

	public boolean esEnvioTercerizado(){
		
		if(this.getVolumenGranel()!=0){
			return true;
		}
		if(this.isInternacional()){
			return true;
		}
		MapaDeRutaE mr = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(this.getSucursalOrigen().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
		if(mr!=null){
			Date hoy = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(hoy);
			calendar.add(Calendar.HOUR, (int) mr.getDuracion());
			
			
			System.out.println("this.getFechaEstimadaEntrega(): " + this.getFechaEstimadaEntrega());
			System.out.println(calendar.getTime().toString());
			//Si tengo que enviarlo si o si hoy para que llegue y no hay vehiculos disponibles
			if(this.getFechaEstimadaEntrega() != null &&
					(this.getFechaEstimadaEntrega().compareTo(calendar.getTime())<=0) ){
				if(!hayVehiculosDisponibles()){
					System.out.println("esEnvioTercerizado-------------");
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}


	public boolean hayVehiculosDisponibles(){
		
		List<VehiculoE> vehiculosDisponibles = this.listarVehiculosDisponibles(this.getSucursalActual().getIdSucursal(),  
				this.getVolumen(), this.getPeso());
		boolean pesoOK = false;
		boolean volumenOK = false;
		
		for(VehiculoE v: vehiculosDisponibles){
			//Sumo los pesos y los volumenes
			if(!pesoOK || !volumenOK){ //si aun no se  encontro ya vehiculo
				float pesoTotal = v.getPeso() - v.getTara();
				float volumenTotal = v.getVolumen();
				float peso = 0;
				float volumen = 0;
				
				EnvioE envio = (EnvioE) EnvioDao.getInstancia().getByVehiculo(v.getIdVehiculo());
				if(envio!=null){
					if(envio.getEstado()==EnvioEstado.Pendiente.toString()){
						for(EncomiendaE enc: envio.getEncomiendas()){
							peso = (float) (peso + enc.getPeso());
							volumen = (float) (volumen + enc.getVolumen());
						}
					}
				}		
				//Verifico si entra el  pedido
				if(pesoTotal >= peso + this.getPeso()){
					pesoOK = true;
				}
				if(volumenTotal >= volumen + this.getVolumen()){
					volumenOK = true;
				}

				if(pesoOK && volumenOK){ 
					return true;
				}
			}
		}
		System.out.println("No hay vehiculos disponibles che");
		return false;
	}

	public List<EncomiendaE> getEncomiendasPendientesBySucursal(int idSucursal){
		//TODO: hacer
		return EncomiendaDao.getInstancia().getEncomiendasPendientesBySucursal(idSucursal);
	}
	
	public void facturar() throws BusinessException {
		
		//Calculo la primer linea de la factura - El valor del transporte lo define la cantidad de km y el costo
		//que se obtiene del mapa de ruta. 
		float kilometros = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCantKm();
		float costo = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(sucursalOrigen.getIdSucursal(), sucursalDestino.getIdSucursal()).getCosto();

		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 30); // Adding 30 days
		
		FacturaE facturaEntity = new FacturaE();//("A", new Date(), false, c.getTime(), this);
		facturaEntity.setFecha(new Date());
		facturaEntity.setEncomienda(this.toEntity());
		System.out.println("FechaVencimiento: ");
		System.out.println(c.getTime().toString());
		facturaEntity.setFechaVencimiento(c.getTime());
		facturaEntity.setPagada(false);
		facturaEntity.setTipoFactura("A");
		
		/*EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();*/
		
		//Guardo la factura
		facturaEntity = FacturaDao.getInstancia().saveOrUpdate(facturaEntity);

		//Costo por Km
		ItemFacturaE itemTransporte = new ItemFacturaE();
		itemTransporte.setDescripcion("Transporte: " + this.cliente.getIdCliente() + "-" + this.sucursalOrigen.getIdSucursal() + "-" + this.sucursalDestino.getIdSucursal());
		itemTransporte.setCantidad(1);
		itemTransporte.setValor(costo);
		itemTransporte.setFactura(facturaEntity);
		ItemFacturaDao.getInstancia().saveOrUpdate(itemTransporte);
		facturaEntity.addItemFactura(itemTransporte);
					
		
		//Segunda Linea Seguros
		SeguroE pSeguro = SeguroDao.getInstancia().getById(this.getSeguro().getIdSeguro());
		if(pSeguro != null){
			ItemFacturaE itemSeguro = new ItemFacturaE();
			itemSeguro.setDescripcion("Seguro: " + this.cliente.getIdCliente() + "-" + this.sucursalOrigen.getIdSucursal() + "-" + this.sucursalDestino.getIdSucursal());
			itemSeguro.setCantidad(1);
			itemSeguro.setValor((float)(pSeguro.getTarifa() + (pSeguro.getTarifaPorKm() * kilometros)));
			itemSeguro.setFactura(facturaEntity);
			ItemFacturaDao.getInstancia().saveOrUpdate(itemSeguro);
			facturaEntity.addItemFactura(itemSeguro);
		}
				
		//Tercer Linea Servicio Seguridad
		ServicioSeguridadE ss = ServicioSeguridadDao.getInstancia().getById(this.getServicioSeguridad().getIdServicioSeguridad());
		if(ss != null){
			ItemFacturaE itemSeguridad = new ItemFacturaE();
			itemSeguridad.setDescripcion("Servicio de Seguridad: " + ss.getDescripcion());
			itemSeguridad.setCantidad(1);
			itemSeguridad.setValor((float)(ss.getTarifa()));
			itemSeguridad.setFactura(facturaEntity);
			ItemFacturaDao.getInstancia().saveOrUpdate(itemSeguridad);
			facturaEntity.addItemFactura(itemSeguridad);
		}
	
		//Cuarta Linea Impueestos
		ItemFacturaE itemImpuesto = new ItemFacturaE();
		itemImpuesto.setDescripcion("IVA 21%");
		itemImpuesto.setCantidad(1);
		float costoTotal = (float) (calcularIVA(facturaEntity.getItemsFactura()) * 0.21);
		itemImpuesto.setValor(costoTotal);
		itemImpuesto.setFactura(facturaEntity);
		ItemFacturaDao.getInstancia().saveOrUpdate(itemImpuesto);
		facturaEntity.addItemFactura(itemImpuesto);
				
		//actualizo la encomienda
		EncomiendaE encomiendaEntity = this.toEntity();
		encomiendaEntity.setFactura(facturaEntity);
		EncomiendaDao.getInstancia().saveOrUpdate(encomiendaEntity);
		
		//Actualizo los datos de factura en el objeto this
	/*	this.factura = new Factura().fromEntity(facturaEntity);
		this.factura.setIdFactura(facturaEntity.getIdFactura());
		for(ItemFactura item:this.getFactura().getItemsFactura()){
			this.factura.addItem(item);
		}
		*/
		//tx.commit();

		
	}

	public EncomiendaE toEntity() throws BusinessException {
	
		SucursalE actual = SucursalDao.getInstancia().getById(this.getSucursalActual().getIdSucursal());
		SucursalE origen = SucursalDao.getInstancia().getById(this.getSucursalOrigen().getIdSucursal());
		SucursalE destino = SucursalDao.getInstancia().getById(this.getSucursalDestino().getIdSucursal());
		ClienteE cli = ClienteDao.getInstancia().getById(this.getCliente().getIdCliente());
		
		if(actual == null)
			throw new SucursalNotFoundException(this.getSucursalActual().getIdSucursal());
		if(origen == null)
			throw new SucursalNotFoundException(this.getSucursalOrigen().getIdSucursal());
		if(destino == null)
			throw new SucursalNotFoundException(this.getSucursalDestino().getIdSucursal());
		if(cli == null)
			throw new ClientNotFoundException();
				
		EncomiendaE encomienda = new EncomiendaE();
		if(this.idEncomienda != 0)
			encomienda.setIdEncomienda(this.idEncomienda);
		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(origen);
		encomienda.setSucursalActual(actual);
		encomienda.setSucursalDestino(destino);
		encomienda.setLargo(this.getLargo());
		encomienda.setAncho(this.getAncho());
		encomienda.setInternacional(this.isInternacional());
		encomienda.setAlto(this.getAlto());
		encomienda.setPeso(this.getPeso());
		encomienda.setVolumen(this.getVolumen());
		encomienda.setTratamiento(this.getTratamiento()); 
		encomienda.setApilable(this.getApilable());
		encomienda.setCantApilable(this.getCantApilable()); 
		encomienda.setRefrigerado(this.getRefrigerado());
		encomienda.setCondicionTransporte(this.getCondicionTransporte()); 
		encomienda.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		encomienda.setFragilidad(this.getFragilidad()); 
		encomienda.setNombreReceptor(this.getNombreReceptor()); 
		encomienda.setApellidoReceptor(this.getApellidoReceptor());
		encomienda.setDniReceptor(this.getDniReceptor()); 
		encomienda.setVolumenGranel(this.getVolumenGranel()); 
		encomienda.setUnidadGranel(this.getUnidadGranel());
		encomienda.setCargaGranel(this.getCargaGranel());		
		//encomienda.setTipoEncomienda("P");	//OJO, encomienda empresa!!!!!!!1
		
		encomienda.setTercerizado(this.isTercerizado());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
		encomienda.setFechaEstimadaEntrega(this.fechaEstimadaEntrega);		
		
		//El Mapa de Ruta es el encargado de calcular la fecha de entrega, porque la calculamos en base a 
		//la distancia
		System.out.println("MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino");
		MapaDeRutaE m = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(this.getSucursalOrigen().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
		System.out.println(this.getSucursalOrigen().getIdSucursal());
		System.out.println(this.getSucursalDestino().getIdSucursal());
		System.out.println(m.getIdMapaDeRuta());
		MapaDeRuta mapa = new MapaDeRuta();
		mapa.setIdMapaDeRuta(m.getIdMapaDeRuta());
		encomienda.setFechaEstimadaEntrega(mapa.calcularFechaEstimadaDeEntrega());
		
		Manifiesto dtoM = this.getManifiesto();
	
		ManifiestoE manifiestoE = new ManifiestoE();
		manifiestoE.setEncomienda(encomienda);
		manifiestoE.setFecha(new Date());		
		manifiestoE.setEncomienda(encomienda);
	
		List<ItemManifiestoE> itemsManifiesto = new ArrayList<ItemManifiestoE>();
		for(ItemManifiesto item:dtoM.getItemsManifiesto()){
			if(item!=null){
				ItemManifiestoE im = new ItemManifiestoE();
				im.setCantidad(item.getCantidad());
				im.setDescripcion(item.getDescripcion());
				
				//TODO: tiene que tener productos??????? No es para las empresas los productos
				if(item.getProducto() != null) {	
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getIdProducto());
					im.setProducto(prod);
				}
				
				im.setManifiesto(manifiestoE);
				itemsManifiesto.add(im);
			}
		}
		manifiestoE.setItemsManifiesto(itemsManifiesto);
		
		encomienda.setManifiesto(manifiestoE);
	
		
		Remito dtoR = this.getRemito();
		if(dtoR != null){
			RemitoE remito = new RemitoE();
			remito.setApellidoReceptor(this.getApellidoReceptor());
			remito.setConformado(true);
			remito.setDniReceptor(this.getDniReceptor());
			remito.setFechaConformado(this.getFechaCreacion());
			remito.setNombreReceptor(this.getNombreReceptor());
			remito.setFechaEstimadaEntrega(this.getFechaEstimadaEntrega());
			remito.setCondicionTransporte(this.getCondicionTransporte());
			remito.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
			
			List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
			for(ItemRemito item:dtoR.getItemsRemito()){
				ItemRemitoE ir = new ItemRemitoE();
				ir.setCantidad(item.getCantidad());
				ir.setDescripcion(item.getDescripcion());
				if(item.getProducto()!=null){
					ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getIdProducto());
					ir.setProducto(prod);
				}
				ir.setRemito(remito);
				itemsRemito.add(ir);
			}
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}
		
		return encomienda;
	}

	private double calcularIVA(List<ItemFacturaE> items) {
	
		float costoTotal=0;
	
		for(ItemFacturaE item: items){
			costoTotal =+ item.getValor();
		}
		
		return costoTotal;
	}
	//TODO: esto tiene que ir en Sucursal??????
	private List<VehiculoE> listarVehiculosDisponibles(int idSucursalOrigen, float volumen, float peso){

		List<VehiculoE> vehiculos = VehiculoDao.getInstancia().getPorVolumenPesoSucursalTareasRealizadas(idSucursalOrigen, peso, volumen);
		List<VehiculoE> vehiculosDisponibles = new ArrayList<VehiculoE>();
		
		for(VehiculoE vehiculo: vehiculos){
			//_GestionVehiculo gVehiculo = new _GestionVehiculo(vehiculo);
			Vehiculo gVehiculo = new Vehiculo().fromEntity(vehiculo);
			
			if(gVehiculo.estaUtilizable() && !gVehiculo.estaAsignado() && !gVehiculo.tieneTareasVencidas()){
				vehiculosDisponibles.add(vehiculo);
			}
		}
		
		return vehiculosDisponibles;
		
	}

	public void addEnvio(Envio e) {
		this.envios.add(e);		
	}
	
	public Encomienda fromEntity(EncomiendaE ence) {
	
		Encomienda enc = new Encomienda();
		enc.setAlto(ence.getAlto());
		enc.setAncho(ence.getAncho());
		enc.setApellidoReceptor(ence.getApellidoReceptor());
		enc.setApilable(ence.getApilable());
		enc.setCantApilable(ence.getCantApilable());
		enc.setCargaGranel(ence.getCargaGranel());
		enc.setCondicionTransporte(ence.getCondicionTransporte());
		
		if(ence.getFactura()!=null)
			enc.setFactura(new Factura().fromEntity(FacturaDao.getInstancia().getById(ence.getFactura().getIdFactura())));
		
		enc.setDniReceptor(ence.getDniReceptor());
		enc.setEstado(ence.getEstado());
		enc.setFechaCreacion(ence.getFechaCreacion());
		enc.setFragilidad(ence.getFragilidad());
		enc.setIdEncomienda(ence.getIdEncomienda());
		enc.setIndicacionesManipulacion(ence.getIndicacionesManipulacion());
		enc.setInternacional(ence.isInternacional());
		enc.setLargo(ence.getLargo());
		if(ence.getManifiesto()!=null)
			enc.setManifiesto(new Manifiesto().fromEntity(ence.getManifiesto()));
		
		if(ence.getRemito()!=null)
			enc.setRemito(new Remito().fromEntity(ence.getRemito()));
		
		enc.setNombreReceptor(ence.getNombreReceptor());
		enc.setPeso(ence.getPeso());
		enc.setRefrigerado(ence.getRefrigerado());
		enc.setSucursalActual(new Sucursal().fromEntity(ence.getSucursalActual()));
		enc.setSucursalDestino(new Sucursal().fromEntity(ence.getSucursalDestino()));
		enc.setSucursalOrigen(new Sucursal().fromEntity(ence.getSucursalOrigen()));
		enc.setTercerizado(ence.isTercerizado());
		enc.setTratamiento(ence.getTratamiento());
		enc.setUnidadGranel(ence.getUnidadGranel());
		enc.setVolumen(ence.getVolumen());
		enc.setVolumenGranel(ence.getVolumenGranel());
		enc.setCliente(new Cliente().fromEntity(ClienteDao.getInstancia().getById(ence.getCliente().getIdCliente())));
		enc.setFechaEstimadaEntrega(ence.getFechaEstimadaEntrega());
		
		//Envios
		if(ence.getEnvios() != null){
			List<Envio> envios = new ArrayList<Envio>();
			for(EnvioE envioE:ence.getEnvios()){
				Envio e = this.parseEnvioFromEntity(envioE);
				envios.add(e);
			}
			enc.setEnvios(envios);
		}
		
		return enc;
	}

	/**
	 * Parse Envio from Entity, sin las encomiendas 
	 *  **/
	private Envio parseEnvioFromEntity(EnvioE e){
		
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
		
		return env;
	}
	
	
	public DTO_Encomienda toDTO() {
			
		DTO_Encomienda encomienda = new DTO_Encomienda();
		encomienda.setIdEncomienda(this.getIdEncomienda());
		encomienda.setCliente(this.getCliente().toDTO());

		encomienda.setSucursalOrigen(this.getSucursalOrigen().toDTO());
		encomienda.setSucursalActual(this.getSucursalActual().toDTO());
		encomienda.setSucursalDestino(this.getSucursalDestino().toDTO());
		
		encomienda.setLargo(this.getLargo());
		encomienda.setAncho(this.getAncho());
		encomienda.setInternacional(this.isInternacional());
		encomienda.setAlto(this.getAlto());
		encomienda.setPeso(this.getPeso());
		encomienda.setVolumen(this.getVolumen());
		encomienda.setTratamiento(this.getTratamiento()); 
		encomienda.setApilable(this.getApilable());
		encomienda.setCantApilable(this.getCantApilable()); 
		encomienda.setRefrigerado(this.getRefrigerado());
		encomienda.setCondicionTransporte(this.getCondicionTransporte()); 
		encomienda.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		encomienda.setFragilidad(this.getFragilidad()); 
		encomienda.setNombreReceptor(this.getNombreReceptor()); 
		encomienda.setApellidoReceptor(this.getApellidoReceptor());
		encomienda.setDniReceptor(this.getDniReceptor()); 
		encomienda.setVolumenGranel(this.getVolumenGranel()); 
		encomienda.setUnidadGranel(this.getUnidadGranel());
		encomienda.setCargaGranel(this.getCargaGranel());		
		
		encomienda.setTercerizada(this.isTercerizado());
		encomienda.setEstado(this.getEstado());
		encomienda.setFechaCreacion(this.getFechaEstimadaEntrega());
		encomienda.setFechaEstimadaEntrega(this.getFechaEstimadaEntrega());
		
		if(this.getManifiesto()!=null)
			encomienda.setManifiesto(this.getManifiesto().toDTO());
		
		if(this.getRemito()!=null)
			encomienda.setRemito(this.getRemito().toDTO());
		
		if(this.factura != null)
			encomienda.setFactura(this.factura.toDTO());

		//Envios
		for(Envio envio:this.getEnvios()){
			encomienda.addEnvio(envio.toDTO());
		}
				
		return encomienda;
	}
	
	
	public boolean estaAsignada(){
		if(this.getEnvios()!=null){
			for(Envio e : this.getEnvios()){
				if(!e.getEstado().contains(EnvioEstado.Concluido.toString()))
					return true;
			}
		}
		
		return false;
	}
	
}
