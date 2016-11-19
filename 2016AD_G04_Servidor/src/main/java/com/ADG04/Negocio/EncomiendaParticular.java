
package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.property.Getter;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.Exceptions.SucursalNotFoundException;
import com.ADG04.Servidor.dao.*;
import com.ADG04.Servidor.model.*;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;

public class EncomiendaParticular extends Encomienda{

	public EncomiendaParticular() {
		super();
	}

	public EncomiendaParticular(Direccion direccionDestino, Sucursal sucursalDestno,
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
			Manifiesto manifiesto,Remito remito, 
			//Factura factura, ,
			boolean internacional) {
		
		super(direccionDestino, sucursalDestno, sucursalOrigen, direccionOrigen, sucursalActual, 
				cliente, fechaCreacion, fechaEstimadaEntrega, estado, tercerizado, largo, alto, ancho, peso, volumen, 
				tratamiento, apilable, cantApilable, refrigerado, condicionTransporte, indicacionesManipulacion, 
				fragilidad, nombreReceptor, apellidoReceptor, dniReceptor, volumenGranel, unidadGranel, cargaGranel, 
				servicioSeguridad, manifiesto, remito,	internacional);
	}
	
	public EncomiendaParticular(//ItemFactura itemFactura,
			Sucursal sucursalDestino, 
			Sucursal sucursalOrigen, Cliente cliente,
			Date fechaCreacion,
			Date fechaEstimadaEntrega, String estado)//, boolean tercerizado,
			//String nombreReceptor, String apellidoReceptor, String dniReceptor) 
			
	{
		super(sucursalDestino, sucursalOrigen, cliente, fechaCreacion, fechaEstimadaEntrega, estado);
	}
	
	@Override
	public String toString() {
		return "Encomienda [cliente=" + getCliente().getIdCliente()
				+ ", fechaCreacion=" + getFechaCreacion()
				+ ", fechaEstimadaEntrega=" + getFechaEstimadaEntrega()
				+ ", estado=" + getEstado() + ", tercerizado=" + isTercerizado()
				+ ", largo=" + getLargo() + ", alto=" + getAlto() + ", ancho=" + getAncho()
				+ ", peso=" + getPeso() + ", volumen=" + getVolumen()+ ", tratamiento="
				+ getTratamiento() + ", apilable=" + getApilable() + ", cantApilable="
				+ getCantApilable() + ", refrigerado=" + getRefrigerado()
				+ ", condicionTransporte=" + getCondicionTransporte()
				+ ", indicacionesManipulacion=" + getIndicacionesManipulacion()
				+ ", fragilidad=" + getFragilidad() + ", nombreReceptor="
				+ getNombreReceptor() + ", apellidoReceptor=" + getApellidoReceptor()
				+ ", dniReceptor=" + getDniReceptor() + ", volumenGranel="
				+ volumenGranel + ", unidadGranel=" + unidadGranel
				+ ", cargaGranel=" + cargaGranel + "terciarizado= " + isTercerizado()
						+ " internacional +" + internacional + "]";
	}

	public DTO_Encomienda toDTO() {
		
		DTO_EncomiendaParticular dto = new DTO_EncomiendaParticular();
		dto.setAlto(this.getAlto());
		dto.setAncho(this.getAncho());
		dto.setApellidoReceptor(this.getApellidoReceptor());
		dto.setApilable(this.getApilable());
		dto.setCantApilable(this.getCantApilable());
		dto.setCargaGranel(this.getCargaGranel());
		dto.setCondicionTransporte(this.getCondicionTransporte());
		dto.setTipoEncomienda("P");
		if(this.getFactura()!=null)
			dto.setFactura(this.getFactura().toDTO());
		
		dto.setDniReceptor(this.getDniReceptor());
		dto.setEstado(this.getEstado());
		dto.setFechaCreacion(this.getFechaCreacion());
		dto.setFragilidad(this.getFragilidad());
		dto.setIdEncomienda(this.getIdEncomienda());
		dto.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		dto.setInternacional(this.internacional);
		dto.setLargo(this.getLargo());
		if(this.getManifiesto()!=null)
			dto.setManifiesto(this.getManifiesto().toDTO());
		
		if(this.getRemito()!=null)
			dto.setRemito(this.getRemito().toDTO());
		
		dto.setNombreReceptor(this.getNombreReceptor());
		dto.setPeso(this.getPeso());
		dto.setRefrigerado(this.refrigerado);
		dto.setSucursalActual(this.getSucursalActual().toDTO());
		dto.setSucursalDestino(this.getSucursalDestino().toDTO());
		dto.setSucursalOrigen(this.getSucursalOrigen().toDTO());
		dto.setTercerizada(this.tercerizado);
		dto.setTratamiento(this.getTratamiento());
		dto.setUnidadGranel(this.getUnidadGranel());
		dto.setVolumen(this.getVolumen());
		dto.setVolumenGranel(this.getVolumenGranel());
		dto.setCliente(this.getCliente().toDTO());
		dto.setFechaEstimadaEntrega(this.getFechaEstimadaEntrega());
		dto.setTratamiento(this.getTratamiento());
		
		//Envios
		for(Envio envio:this.getEnvios()){
			DTO_Envio e = new DTO_Envio();
			e.setId(envio.getIdEnvio());
			dto.addEnvio(e);
		}
		
		return dto;
	}

	public Integer saveOrUpdate() throws BusinessException {
		
		SucursalE actual = SucursalDao.getInstancia().getById(this.getSucursalActual().getIdSucursal());
		SucursalE origen = SucursalDao.getInstancia().getById(this.getSucursalOrigen().getIdSucursal());
		SucursalE destino = SucursalDao.getInstancia().getById(this.getSucursalDestino().getIdSucursal());
		ClienteE cli = ClienteParticularDao.getInstancia().getById(this.getCliente().getIdCliente());
		
		if(actual == null)
			throw new SucursalNotFoundException(this.getSucursalActual().getIdSucursal());
		if(origen == null)
			throw new SucursalNotFoundException(this.getSucursalOrigen().getIdSucursal());
		if(destino == null)
			throw new SucursalNotFoundException(this.getSucursalDestino().getIdSucursal());
		if(cli == null)
			throw new ClientNotFoundException();
		
		
		EncomiendaE encomienda = new EncomiendaE();
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
		encomienda.setTipoEncomienda("P");
		
		encomienda.setTercerizado(this.isTercerizado());
		encomienda.setEstado(EncomiendaEstado.Ingresada.toString());
		encomienda.setFechaCreacion(new Date());
		
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
					
	//	EntityManager em = getEntityFactoryInstace();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();	
		
		
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
		
		Remito r = this.getRemito();
		
		RemitoE remito = new RemitoE();
		remito.setApellidoReceptor(this.getApellidoReceptor());
		remito.setConformado(true);
		remito.setDniReceptor(this.getDniReceptor());
		remito.setFechaConformado(this.getFechaCreacion());
		remito.setNombreReceptor(this.getNombreReceptor());
		remito.setFechaEstimadaEntrega(this.getFechaEstimadaEntrega());
		remito.setCondicionTransporte(this.getCondicionTransporte());
		remito.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		remito.setEncomienda(encomienda);
		List<ItemRemitoE> itemsRemito = new ArrayList<ItemRemitoE>();
		for(ItemRemito item:r.getItemsRemito()){
			ItemRemitoE ir = new ItemRemitoE();
			ir.setCantidad(item.getCantidad());
			ir.setDescripcion(item.getDescripcion());
			
			if(item.getProducto()!=null){
				ProductoE prod = ProductoDao.getInstancia().getById(item.getProducto().getIdProducto());
				ir.setProducto(prod);
			}
			ir.setRemito(remito);
			itemsRemito.add(ir);
			
			
			remito.setItemsRemito(itemsRemito);
			remito.setEncomienda(encomienda);
			encomienda.setRemito(remito);
		}

		/*Deberia persistir en cascada*/

		try{
		EncomiendaDao.getInstancia().persist(encomienda);
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
//		tx.commit();
		this.manifiesto.setIdManifiesto(manifiestoE.getIdManifiesto());
		this.idEncomienda = encomienda.getIdEncomienda();
		return encomienda.getIdEncomienda();
	}

	public Encomienda fromEntity(EncomiendaE ence){
		
		EncomiendaParticular enc = new EncomiendaParticular();
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
		
		if(ence.getEnvios()!=null){
			//Envios
			for(EnvioE envioE:ence.getEnvios()){
				enc.addEnvio(envioFromEntity(envioE));
			}
		}
		
		return enc;
	}

	/**
	 * Envio from Entity, sin pasar por la encomienda
	 * **/
	private Envio envioFromEntity(EnvioE e){
		
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
	

	private EntityManager getEntityFactoryInstace() {
		return EntityManagerProvider.getInstance().getEntityManagerFactory().createEntityManager();
	}

	

	private float calcularPrecioTotal() {
		
		float costoTotal=0;
		
		for(ItemFactura item: this.factura.getItemsFactura()){
			costoTotal =+ item.getValor();
		}

		return costoTotal;
	}

		
}
