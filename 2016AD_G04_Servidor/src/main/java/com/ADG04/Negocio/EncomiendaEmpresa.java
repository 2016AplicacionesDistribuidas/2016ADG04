package com.ADG04.Negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

























import org.hibernate.mapping.Array;
import org.hibernate.property.Getter;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.Exceptions.SucursalNotFoundException;
import com.ADG04.Servidor.dao.ClienteDao;
import com.ADG04.Servidor.dao.ClienteParticularDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.FacturaDao;
import com.ADG04.Servidor.dao.ManifiestoDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.ProductoEncomiendaDao;
import com.ADG04.Servidor.dao.ProveedorDao;
import com.ADG04.Servidor.dao.RemitoDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.model.ClienteE;
import com.ADG04.Servidor.model.ClienteEmpresaE;
import com.ADG04.Servidor.model.ClienteParticularE;
import com.ADG04.Servidor.model.EncomiendaE;
import com.ADG04.Servidor.model.EnvioE;
import com.ADG04.Servidor.model.ItemManifiestoE;
import com.ADG04.Servidor.model.ItemRemitoE;
import com.ADG04.Servidor.model.ManifiestoE;
import com.ADG04.Servidor.model.MapaDeRutaE;
import com.ADG04.Servidor.model.ProductoE;
import com.ADG04.Servidor.model.ProductoEncomiendaE;
import com.ADG04.Servidor.model.RemitoE;
import com.ADG04.Servidor.model.SucursalE;
import com.ADG04.Servidor.util.EncomiendaEstado;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;


public class EncomiendaEmpresa extends Encomienda{

	private List<ProductoEncomienda> productosEncomienda;
	
	public EncomiendaEmpresa() {
		super();
		this.productosEncomienda = new ArrayList<ProductoEncomienda>();
		
	}

	public EncomiendaEmpresa(Direccion direccionDestino, Sucursal sucursalDestno,
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
			//Factura factura, Remito remito,
			boolean internacional){
	
		super(direccionDestino, sucursalDestno, sucursalOrigen, direccionOrigen, sucursalActual, 
				cliente, fechaCreacion, fechaEstimadaEntrega, estado, tercerizado, largo, alto, ancho, peso, volumen, 
				tratamiento, apilable, cantApilable, refrigerado, condicionTransporte, indicacionesManipulacion, 
				fragilidad, nombreReceptor, apellidoReceptor, dniReceptor, volumenGranel, unidadGranel, cargaGranel, 
				servicioSeguridad, manifiesto, remito,
				//factura, remito, 
				internacional);
		
		this.productosEncomienda  = new ArrayList<ProductoEncomienda>();
	}

	
	public List<ProductoEncomienda> getProductoEncomiendas() {
		return productosEncomienda;
	}

	public void setProductoEncomiendas(List<ProductoEncomienda> productoEncomiendas) {
		this.productosEncomienda = productoEncomiendas;
	}

	public void addProducto(ProductoEncomienda producto){
		this.productosEncomienda.add(producto);
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
				+ ", cargaGranel=" + cargaGranel + ", productoEncomiendas="
				+ productosEncomienda + ", terciarizado=" + isTercerizado() +""
						+ " internacional +" + internacional + "]";
	}

	public Integer saveOrUpdate() throws BusinessException {
		
		SucursalE actual = SucursalDao.getInstancia().getById(this.getSucursalActual().getIdSucursal());
		SucursalE origen = SucursalDao.getInstancia().getById(this.getSucursalOrigen().getIdSucursal());
		SucursalE destino = SucursalDao.getInstancia().getById(this.getSucursalDestino().getIdSucursal());
		ClienteEmpresaE cli = (ClienteEmpresaE)ClienteDao.getInstancia().getById(this.getCliente().getIdCliente());
		
		if(actual == null)
			throw new SucursalNotFoundException(this.getSucursalActual().getIdSucursal());
		if(origen == null)
			throw new SucursalNotFoundException(this.getSucursalOrigen().getIdSucursal());
		if(destino == null)
			throw new SucursalNotFoundException(this.getSucursalDestino().getIdSucursal());
		if(cli == null)
			throw new ClientNotFoundException();
				
		EncomiendaE encomiendaEntity = new EncomiendaE();
		encomiendaEntity.setCliente(cli);
		encomiendaEntity.setSucursalOrigen(origen);
		encomiendaEntity.setSucursalActual(actual);
		encomiendaEntity.setSucursalDestino(destino);
		encomiendaEntity.setLargo(this.getLargo());
		encomiendaEntity.setAncho(this.getAncho());
		encomiendaEntity.setInternacional(this.isInternacional());
		encomiendaEntity.setAlto(this.getAlto());
		encomiendaEntity.setPeso(this.getPeso());
		encomiendaEntity.setVolumen(this.getVolumen());
		encomiendaEntity.setTratamiento(this.getTratamiento()); 
		encomiendaEntity.setApilable(this.getApilable());
		encomiendaEntity.setCantApilable(this.getCantApilable()); 
		encomiendaEntity.setRefrigerado(this.getRefrigerado());
		encomiendaEntity.setCondicionTransporte(this.getCondicionTransporte()); 
		encomiendaEntity.setIndicacionesManipulacion(this.getIndicacionesManipulacion());
		encomiendaEntity.setFragilidad(this.getFragilidad()); 
		encomiendaEntity.setNombreReceptor(this.getNombreReceptor()); 
		encomiendaEntity.setApellidoReceptor(this.getApellidoReceptor());
		encomiendaEntity.setDniReceptor(this.getDniReceptor()); 
		encomiendaEntity.setVolumenGranel(this.getVolumenGranel()); 
		encomiendaEntity.setUnidadGranel(this.getUnidadGranel());
		encomiendaEntity.setCargaGranel(this.getCargaGranel());		
		encomiendaEntity.setTipoEncomienda("E");	//OJO, encomienda empresa!!!!!!!1
		
		encomiendaEntity.setTercerizado(this.isTercerizado());
		encomiendaEntity.setEstado(EncomiendaEstado.Ingresada.toString());
		encomiendaEntity.setFechaCreacion(new Date());
		
		//El Mapa de Ruta es el encargado de calcular la fecha de entrega, porque la calculamos en base a 
		//la distancia
		System.out.println("MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino");
		MapaDeRutaE m = MapaDeRutaDao.getInstancia().getBySucursalOrigenyDestino(this.getSucursalOrigen().getIdSucursal(), this.getSucursalDestino().getIdSucursal());
		System.out.println(this.getSucursalOrigen().getIdSucursal());
		System.out.println(this.getSucursalDestino().getIdSucursal());
		System.out.println(m.getIdMapaDeRuta());
		MapaDeRuta mapa = new MapaDeRuta();
		mapa.setIdMapaDeRuta(m.getIdMapaDeRuta());
		encomiendaEntity.setFechaEstimadaEntrega(mapa.calcularFechaEstimadaDeEntrega());
					
	//	EntityManager em = getEntityFactoryInstace();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();	
		
		Manifiesto dtoM = this.getManifiesto();

		ManifiestoE manifiestoE = new ManifiestoE();
		manifiestoE.setEncomienda(encomiendaEntity);
		manifiestoE.setFecha(new Date());		
		manifiestoE.setEncomienda(encomiendaEntity);
	
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
		
		encomiendaEntity.setManifiesto(manifiestoE);
		
		/*Deberia persistir en cascada*/
		if(this.productosEncomienda == null || this.productosEncomienda.size() == 0)
			throw new BusinessException("La encomienda no tiene productos asignados");
				
		try{
			
			encomiendaEntity = EncomiendaDao.getInstancia().saveOrUpdate(encomiendaEntity);
			
			//TODO: revisar. habria que guardar esto en transaccion
			//Si es encomienda de empresa, tiene productos asociados
			if(this.productosEncomienda.size()>0){
				for(ProductoEncomienda pe: this.productosEncomienda){
					
					ProductoE pEntity = ProductoDao.getInstancia().getById(pe.getProducto().getIdProducto()); 
					
					ProductoEncomiendaE productoEncomiendaEntity = new ProductoEncomiendaE(encomiendaEntity, pEntity, pe.getCantidad());
					ProductoEncomiendaDao.getInstancia().saveOrUpdate(productoEncomiendaEntity);
				}
			}

			Remito dtoR = this.getRemito();
			if(dtoR != null){
				RemitoE remitoEntity = new RemitoE();
				remitoEntity.setApellidoReceptor(dtoR.getApellidoReceptor());
				remitoEntity.setConformado(dtoR.isConformado());
				remitoEntity.setDniReceptor(dtoR.getDniReceptor());
				remitoEntity.setFechaConformado(dtoR.getFechaConformado());
				remitoEntity.setNombreReceptor(dtoR.getNombreReceptor());
				remitoEntity.setFechaEstimadaEntrega(dtoR.getFechaEstimadaEntrega());
				remitoEntity.setCondicionTransporte(dtoR.getCondicionTransporte());
				remitoEntity.setIndicacionesManipulacion(dtoR.getIndicacionesManipulacion());
				
				List<ItemRemitoE> itemsRemitoEntity = new ArrayList<ItemRemitoE>();
				for(ItemRemito item:dtoR.getItemsRemito()){
					ItemRemitoE ir = new ItemRemitoE();
					ir.setCantidad(item.getCantidad());
					ir.setDescripcion(item.getDescripcion());
					ProductoE prodEntity = ProductoDao.getInstancia().getById(item.getProducto().getIdProducto());
					ir.setProducto(prodEntity);
					ir.setRemito(remitoEntity);
					itemsRemitoEntity.add(ir);
				}

				remitoEntity.setItemsRemito(itemsRemitoEntity);
				
				remitoEntity.setItemsRemito(itemsRemitoEntity);
				remitoEntity.setEncomienda(encomiendaEntity);
				remitoEntity = RemitoDao.getInstancia().saveOrUpdate(remitoEntity);
				encomiendaEntity.setRemito(remitoEntity);
				
				this.remito = new Remito(remitoEntity.getNombreReceptor(), remitoEntity.getApellidoReceptor(), remitoEntity.getDniReceptor(), remitoEntity.isConformado(), remitoEntity.getFechaConformado());
				this.remito.setIdRemito(remitoEntity.getIdRemito());
				List<ItemRemito> myItems = new ArrayList<ItemRemito>();
				for(ItemRemitoE i:remitoEntity.getItemsRemito()){
					myItems.add(new ItemRemito(i.getIdItemRemito(), i.getDescripcion(), i.getCantidad()));
				}
				this.remito.setItemsRemito(myItems);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw e;
		}
//		tx.commit();
		this.manifiesto.setIdManifiesto(manifiestoE.getIdManifiesto());
		this.idEncomienda = encomiendaEntity.getIdEncomienda();
		return encomiendaEntity.getIdEncomienda();
	}

	
	public DTO_Encomienda toDTO() {
		
		DTO_EncomiendaEmpresa encomienda = new DTO_EncomiendaEmpresa();
		encomienda.setIdEncomienda(this.getIdEncomienda());
		encomienda.setCliente(this.getCliente().toDTO());
		encomienda.setTipoEncomienda("E");
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

		if(this.productosEncomienda.size()>0){
			for(ProductoEncomienda pe: this.productosEncomienda){	
				DTO_ProductoEncomienda pdto = pe.toDTO();
				encomienda.addProducto(pdto);
			}
		}
		
		return encomienda;
	}

	public Encomienda fromEntity(EncomiendaE ence) {
		
		EncomiendaEmpresa enc = new EncomiendaEmpresa();
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
		
		//enc = (EncomiendaEmpresa)super.fromEntity(ence);
		
		if(ence.getProductoEncomiendas() != null){
			System.out.println("productos: " + ence.getProductoEncomiendas().size());
			List<ProductoEncomienda> productos =new  ArrayList<ProductoEncomienda>();
			for(ProductoEncomiendaE pe: ence.getProductoEncomiendas()){
				
				ProductoEncomienda prod = new ProductoEncomienda().fromEntity(pe);
				productos.add(prod);
			}
			if(productos.size()>0)
				enc.setProductoEncomiendas(productos);;
		}
		
		//Envios
		if(ence.getEnvios()!=null){
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
	

	
}
