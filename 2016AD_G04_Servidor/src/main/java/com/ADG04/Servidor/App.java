package com.ADG04.Servidor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;

import com.ADG04.Negocio.GestionAdministracion;
import com.ADG04.Negocio.GestionCliente;
import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Negocio.GestionVehiculo;
import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.DireccionDao;
import com.ADG04.Servidor.dao.EncomiendaDao;
import com.ADG04.Servidor.dao.EnvioDao;
import com.ADG04.Servidor.dao.MapaDeRutaDao;
import com.ADG04.Servidor.dao.PaisDao;
import com.ADG04.Servidor.dao.PlanMantenimientoDao;
import com.ADG04.Servidor.dao.ProductoDao;
import com.ADG04.Servidor.dao.ProvinciaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.dao.VehiculoDao;
import com.ADG04.Servidor.model.Cliente;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Direccion;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.Servidor.model.MapaDeRuta;
import com.ADG04.Servidor.model.Pais;
import com.ADG04.Servidor.model.Provincia;
import com.ADG04.Servidor.model.Sucursal;
import com.ADG04.Servidor.model.TareaMantenimiento;
import com.ADG04.Servidor.model.TareaMantenimientoPorKm;
import com.ADG04.Servidor.model.Vehiculo;
import com.ADG04.Servidor.util.EntityManagerProvider;
import com.ADG04.Servidor.util.EnvioEstado;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_ItemRemito;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;



/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException
    {
    	//VehiculosTest.TestVehiculos();
    	//EncomiendasTest.TestCrearEncomiendaYAsignaleElEnvio();
    	EncomiendasTest.testControlViajes();
    	//TestTareasVencidas(20);
    	
    	//TestCrearPlanesYTareasYVehiculos();

        //TestRealizarTareas();
    	//generarVehiculoTest("Toyota", "Toyota 1", "2016", "AAA010", 10);
    	
    	//Vehiculo v = VehiculoDao.getInstancia().getById(23);
    	//TestGetPlanes();    	
    	//crearPaisesYProvincias();
    	//TestAltaCliente();
    	//testControlViajes();
    	//TestEncomienda();
        //testAsignarEnvios();
    	//TestFacturaEncomiendaParticular();
    	
    	//TestSucursal("Sucursal Origen");
    	//TestSucursal("Sucursal Destino");
    	
    	//TestPaisDao();
    	//TestUsuario();
    	
    	System.exit(0);
    }
    
	private static void crearPaisesYProvincias(){
    	DTO_Pais pais = new DTO_Pais();
    	pais.setDescripcion("Argentina");
    	GestionAdministracion.getInstancia().altaPais(pais);
    	
    	DTO_Provincia prov = new DTO_Provincia();
    	prov.setDescripcion("Mendoza");
    	prov.setPais(PaisDao.getInstancia().getById(1).toDTO());
    	GestionAdministracion.getInstancia().altaProvincia(prov);
    	
    	prov.setDescripcion("Cordoba");
    	prov.setPais(PaisDao.getInstancia().getById(1).toDTO());
    	GestionAdministracion.getInstancia().altaProvincia(prov);
    	
    	pais.setDescripcion("Peru");
    	GestionAdministracion.getInstancia().altaPais(pais);
    }
    	private static void TestAltaCliente() {  	
    	DTO_Direccion dir = new DTO_Direccion();
    	
    	Pais pais = (Pais) PaisDao.getInstancia().getById(1);
    	Provincia prov = (Provincia) ProvinciaDao.getInstancia().getById(1);
    	
    	dir.setCalle("Una calle");
    	dir.setCodigoPostal(1234);
    	dir.setLocalidad("Capital Federal");
    	dir.setNro(123);
    	dir.setPais(pais.toDTO());
    	dir.setProvincia(prov.toDTO());
    	
    	DTO_ClienteParticular cliParticular = new DTO_ClienteParticular();
    	
    	cliParticular.setApellido("Guccione");
    	cliParticular.setDni("32437264");
		cliParticular.setEmail("vguccione@gmail.com");
		cliParticular.setEstado(true);
		cliParticular.setNombre("Vanesa");
		cliParticular.setTelefono("1556932544");
		cliParticular.setDireccion(dir);
		
		GestionCliente.getInstancia().altaClienteParticular(cliParticular);
    }

	public static void TestUsuario(){
    	DTO_Usuario usuario = new DTO_Usuario();
    	usuario.setApellido("Pepe");
    	usuario.setDni("212328");
    	usuario.setFechaCreacion(new Date());
    	usuario.setNombre("pepepe");
    	usuario.setPassword("xxxxxx");
    	usuario.setUltimoAcceso(new Date());
    	usuario.setIdSucursal(1);
    	usuario.setIdRolUsuario(1);
    	
    	GestionAdministracion.getInstancia().altaUsuario(usuario);
    }
    
	public static void TestSucursal(String descripcion){
		
		DTO_Direccion dir = new DTO_Direccion();
    	DTO_Sucursal sucursal = new DTO_Sucursal();
    	Pais pais = (Pais) PaisDao.getInstancia().getById(1);
    	Provincia prov = (Provincia) ProvinciaDao.getInstancia().getById(1);
    	
    	dir.setCalle("peperulo calle");
    	dir.setCodigoPostal(1234);
    	dir.setLocalidad("Capital Federal");
    	dir.setNro(123);
    	dir.setPais(pais.toDTO());
    	dir.setProvincia(prov.toDTO());
    	
    	sucursal.setDescripcion(descripcion);
    	sucursal.setTelefono("123456");
    	sucursal.setDireccion(dir);
    	    	
    	GestionAdministracion.getInstancia().altaSucursal(sucursal);
    }
		
	public static void TestFacturaEncomiendaParticular(){
		
		System.out.println("---------------TestFacturaEncomiendaParticular--------------------");
		
		GestionEncomienda.getInstancia().facturarEncomiendaParticular(1);

		System.out.println("Id de Factura generada:");
		int idFactura = GestionEncomienda.getInstancia().getFacturaParticularByIdEncomienda(1);
		System.out.println(idFactura);
		
		System.out.println("-------------------------------------------------------------------");
	}
	
	public static void TestEncomienda(){
		
		float nro = 123;
		DTO_ClienteParticular cli = new DTO_ClienteParticular();
		cli.setId(1);
    	DTO_Sucursal sucursalOrigen = SucursalDao.getInstancia().getById(1).toDTO();
    	DTO_Sucursal sucursalDestino = SucursalDao.getInstancia().getById(2).toDTO();
    	
    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();

		encomienda.setCliente(cli);
		encomienda.setSucursalOrigen(sucursalOrigen);
		encomienda.setSucursalDestino(sucursalDestino);
		encomienda.setLargo(nro);
		encomienda.setAncho(nro);
		
		encomienda.setAlto(12.0f);
		encomienda.setPeso(430f);
		encomienda.setVolumen(44.5f);
		encomienda.setTratamiento("nada"); 
		encomienda.setApilable(true);
		encomienda.setCantApilable((short)2); 
		encomienda.setRefrigerado(false);
		encomienda.setCondicionTransporte(null); 
		encomienda.setIndicacionesManipulacion(null);
		encomienda.setFragilidad("no"); 
		encomienda.setNombreReceptor("Alfredo"); 
		encomienda.setApellidoReceptor("Receptor");
		encomienda.setDniReceptor("99876543"); 
		encomienda.setVolumenGranel(0f); 
		encomienda.setUnidadGranel(null);
		encomienda.setCargaGranel(null);	
		encomienda.setFechaEstimadaEntrega(GestionEncomienda.getInstancia().calcularFechaEstimadaDeEntrega(sucursalOrigen.getId(), sucursalDestino.getId()));
		
		DTO_Manifiesto manifiesto = new DTO_Manifiesto();
		manifiesto.setFecha(new Date());
		List<DTO_ItemManifiesto>items = new ArrayList<DTO_ItemManifiesto>();
		DTO_ItemManifiesto item = new DTO_ItemManifiesto();
		item.setCantidad(10);
		item.setDescripcion("hola que tal ");
		DTO_Producto producto = ProductoDao.getInstancia().getById(1).toDTO();
		item.setProducto(producto);
		
		items.add(item);
		manifiesto.setDetalle(items);
		encomienda.setManifiesto(manifiesto);
		
		
		DTO_Remito remito = new DTO_Remito();
		remito.setApellidoReceptor("Apellido receptor");
		remito.setNombreReceptor("Nombre receptor");
		remito.setDniReceptor("12312321");
		remito.setConformado(false);
		remito.setFecha(new Date());
		remito.setFechaEstimadaEntrega(new Date());
		remito.setCondicionTransporte(encomienda.getCondicionTransporte());
		remito.setIndicacionesManipulacion(encomienda.getIndicacionesManipulacion());
		
		List<DTO_ItemRemito>itemsr = new ArrayList<DTO_ItemRemito>();
		DTO_ItemRemito itemr = new DTO_ItemRemito();
		item.setCantidad(10);
		item.setDescripcion("hola que tal remito");
		DTO_Producto productor = ProductoDao.getInstancia().getById(1).toDTO();
		itemr.setCantidad(10);
		itemr.setProducto(productor);
		itemr.setRemito(remito);
		itemsr.add(itemr);
		remito.setDetalle(itemsr);
		
		encomienda.setRemito(remito);
		
    	GestionEncomienda.getInstancia().altaEncomiendaParticular(encomienda);
    }
    
	public static void testEncomienda1() throws IOException{
	}
	
	//vanesa
	public static void testControlViajes() throws IOException{	


		//Creo una encomienda particular
		Encomienda enc = testEncomienda(1,2,1,100,100f,430f,100f,0f,0);
		System.out.println("Press key");
		System.in.read();
		
		//Intento asignarla a un envío.
		System.out.println("-------Asignar la encomienda "+enc.getIdEncomienda()+" a un envío------------");
		Integer idEnvio = GestionEncomienda.getInstancia().asignarEnvio(enc.getIdEncomienda(), null);
		Envio envio = EnvioDao.getInstancia().getById(idEnvio);
		System.out.println("Estado Inicial del Envio: "+envio.getEstado()+". Envío " + idEnvio);
		System.in.read();
		
		/*Seguira en viaje*/
		System.out.println("---------Seguira en viaje----------");
		System.out.println("Estado del envio cuando sigue en curso");
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(envio.getIdEnvio(), CoordenadaDao.getInstancia().getById(3));
		System.out.println(envio.getEstado());
		System.out.println("----------------------------------------");
		System.in.read();
		
		/*Se indicara desviado*/
		System.out.println("---------------------------------------------------------------");
		Coordenada coordAct = new Coordenada();
		coordAct.setLatitud("54°35′59″S");
		coordAct.setLongitud("48°22′55″O﻿");
		Coordenada coord = CoordenadaDao.getInstancia().saveOrUpdate(coordAct);
		System.out.println("---------Nueva coordenada: "+coord.getIdCoordenada()+"-------------------");
		System.in.read();
		
		System.out.println("-----------------------------------------");
		System.out.println("Estado del envio cuando se pasan coordenadas fuera de su mapa de ruta:");
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(envio.getIdEnvio(), coord);
		System.out.println(envio.getEstado());	
		System.out.println("-------------------");
		System.in.read();		
		System.out.println("");
		
		/*Se indicara demorado*/
		System.out.println("-------Se indicara demorado------------");
		System.out.println("Estado del envio cuando se chequea la fecha de llegada y la actual:");
		GestionControlViajes.getInstancia().estaEnvioDemorado(envio.getIdEnvio());
		System.out.println("Envio llegando tarde: "+envio.getEstado());	
		
		System.out.println("");
		System.out.println("-------------------------------------");
		System.in.read();

		System.out.println("----------------Otra encomienda---------------------");
		Encomienda enc2 = testEncomienda(1,2,1,100,100f,430f,100f,0f,10);
		System.out.println("-------------Encomienda:"+enc2.getIdEncomienda()+"------------------------");
		System.in.read();

		System.out.println("---------------Le asigno envío----------------------");
		Integer idEnvio2 = GestionEncomienda.getInstancia().asignarEnvio(enc2.getIdEncomienda(), null);
		Envio envio2 = EnvioDao.getInstancia().getById(idEnvio2);
		System.out.println("-----------------Envío: "+idEnvio2+"--------------------");
		System.in.read();

		
		/*Se indicara concluido*/
		System.out.println("--------------Se indicara concluido-----------------------");
		System.out.println("Estado del envio y su encomienda cuando llega a destino");
		GestionControlViajes.getInstancia().concluirEnvio(envio2.getIdEnvio());
		System.out.println("Estado del envio " + envio2.getEstado());
		System.out.println("Estado de la encomienda: " + EncomiendaDao.getInstancia().getById(enc2.getIdEncomienda()).getEstado());


		System.out.println("------------------------Test finalizado!!!!-------------");
		System.in.read();

		EnvioDao.getInstancia().remove(envio);
		EnvioDao.getInstancia().remove(envio2);
		EncomiendaDao.getInstancia().remove(enc);
		EncomiendaDao.getInstancia().remove(enc2);


	}
	
	/*
	 * Test varias encomiendas y tratar de asignarlas a envios.
	 */
	public static void testAsignarEnvios() throws IOException{
		
		/*encomienda con 70% peso de posible vehiculo 1 (unico con tareas de mantenimiento realizadas) */
				
		System.out.println("encomienda con 70% peso de posible - vehiculo 1 - (unico con tareas de mantenimiento realizadas)");
		Encomienda enc = testEncomienda(1,2,1,100,100f,430f,100f,0f,10);
		System.out.println("----Nueva encomienda: "+enc.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();
		
		Envio envio = new Envio();
		Integer idEnvio = GestionEncomienda.getInstancia().asignarEnvio(enc.getIdEncomienda(), null);
		
		if(idEnvio != null) {
			System.out.println("----Asignada al envío : "+idEnvio+"----------");
			System.in.read();
			
			envio = (Envio) EnvioDao.getInstancia().getById(idEnvio);
			System.out.println("Encomienda con 70% del peso del vehiculo 1 que esta disponible");
			System.out.println("Peso del Vehiculo: " + (envio.getVehiculo().getPeso() - envio.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc.getEstado());
			System.out.println(envio.toString());
			System.out.println("------------------------------------");
			
			//EnvioDao.getInstancia().remove(envio);
			//EncomiendaDao.getInstancia().remove(enc);
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
			System.out.println("---------------------------------------------------");
		
		}
		
		System.out.println("-----------------------------------------------------------------------------");
		System.in.read();
		
		/*Encomienda con 70% volumen de posible vehiculo 1 (unico con tareas de mantenimiento realizadas) */
		System.out.println("Encomienda con 70% volumen de posible vehiculo 1 (unico con tareas de mantenimiento realizadas)");
		System.in.read();		
		Encomienda enc2 = testEncomienda(1,2,1,100,100f,100f,2264f,0f,10);
		System.out.println("----Nueva encomienda: "+enc2.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();		
		
		Envio envio2 = new Envio();
		Integer idEnvio2 = GestionEncomienda.getInstancia().asignarEnvio(enc2.getIdEncomienda(), null);
		if(idEnvio2!=null){
			System.out.println("----Asignada al envío : "+idEnvio2+"----------");
			System.in.read();
		
			envio2 = (Envio) EnvioDao.getInstancia().getById(idEnvio2);
			System.out.println("Encomienda con 70% del volumen del vehiculo 1 que esta disponible");
			System.out.println("Volumen del Vehiculo: " + envio2.getVehiculo().getVolumen());
			System.out.println("Volumen de la encomienda: " + enc2.getVolumen());
			System.out.println("Envio creado para vehiculo "+ envio2.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio2.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio2.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio2.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc2.getEstado());
			//System.out.println(envio.toString());
			
			EnvioDao.getInstancia().remove(envio2);
			EncomiendaDao.getInstancia().remove(enc2);
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
		}
		
		System.out.println("-----------------------------------------------------------------------------");
		System.in.read();		
		
		/*Varias encomiendas asignadas hasta ocupar maximo peso*/
		System.out.println("Varias encomiendas asignadas hasta ocupar maximo peso");
		Encomienda enc3 = testEncomienda(1,2,1,100,100f,100f,100f,0f,10);
		System.out.println("----Nueva encomienda: "+enc3.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();
		
		Envio envio3 = new Envio();
		Integer idEnvio3 = GestionEncomienda.getInstancia().asignarEnvio(enc3.getIdEncomienda(), null);
		
		if(idEnvio3!=null){
			System.out.println("----Asignada al envío : "+idEnvio3+"----------");
			System.in.read();

			envio3 = (Envio) EnvioDao.getInstancia().getById(idEnvio3);
			System.out.println("Encomienda con peso = 100");
			System.out.println("Peso del Vehiculo: " + (envio3.getVehiculo().getPeso() - envio3.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc3.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio3.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio3.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio3.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio3.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc3.getEstado());
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
		}
					
		System.out.println("--------------------------------------------------------------------");
		System.in.read();
		
		Encomienda enc4 = testEncomienda(1,2,1,100,100f,200f,100f,0f,10);
		System.out.println("----Nueva encomienda: "+enc4.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();

		Envio envio4 = new Envio();
		Integer idEnvio4 = GestionEncomienda.getInstancia().asignarEnvio(enc4.getIdEncomienda(), null);
		if(idEnvio4!=null){
			System.out.println("----Asignada al envío : "+idEnvio4+"----------");
			System.in.read();

			envio4 = (Envio) EnvioDao.getInstancia().getById(idEnvio4);
			System.out.println("Encomienda con peso = 200");
			System.out.println("Peso del Vehiculo: " + (envio4.getVehiculo().getPeso() - envio4.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc4.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio4.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio4.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio4.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio4.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc4.getEstado());
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
		}
		
			
		System.out.println("--------------------------------------------------------------------");
		System.in.read();		
		
		Encomienda enc5 = testEncomienda(1,2,1,100,100f,300f,100f,0f,10);
		System.out.println("----Nueva encomienda: "+enc5.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();

		Integer idEnvio5 = GestionEncomienda.getInstancia().asignarEnvio(enc5.getIdEncomienda(), null);
		Envio envio5 = new Envio();
		if(idEnvio5!=null){
			System.out.println("----Asignada al envío : "+idEnvio5+"----------");
			System.in.read();

			envio5 = (Envio) EnvioDao.getInstancia().getById(idEnvio5);
			System.out.println("Encomienda con peso = 300");
			System.out.println("Peso del Vehiculo: " + (envio5.getVehiculo().getPeso() - envio5.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc5.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio5.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio5.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio5.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio5.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc5.getEstado());
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
		}
		
		System.out.println("--------------------------------------------------------------------");
		System.in.read();		
		
		Encomienda enc6 = testEncomienda(1,2,1,100,100f,200f,100f,0f,10);
		System.out.println("----Nueva encomienda: "+enc6.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();

		Envio envio6 = new Envio();
		Integer idEnvio6 = GestionEncomienda.getInstancia().asignarEnvio(enc6.getIdEncomienda(), null);
		if(idEnvio6 != null){
			System.out.println("----Asignada al envío : "+idEnvio6+"----------");
			System.in.read();


			envio6 = (Envio) EnvioDao.getInstancia().getById(idEnvio6);
			System.out.println("Encomienda con peso = 200");
			System.out.println("Peso del Vehiculo: " + (envio6.getVehiculo().getPeso() - envio6.getVehiculo().getTara()));
			System.out.println("Peso de la encomienda: " + enc6.getPeso());
			System.out.println("Envio creado para vehiculo "+ envio6.getVehiculo().getIdVehiculo());
			System.out.println("sucursal origen:  "+ envio6.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio6.getSucursalDestino().getDescripcion());
			System.out.println("estado :  "+ envio6.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc6.getEstado());
		}
		else{
			System.out.println("Encomienda con peso = 200");
			System.out.println("No se pudo asignar la encomienda a un envio.");
			}
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.in.read();		
		/*
		EnvioDao.getInstancia().remove(envio3);
		EnvioDao.getInstancia().remove(envio6);
		EncomiendaDao.getInstancia().remove(enc3);
		EncomiendaDao.getInstancia().remove(enc4);
		EncomiendaDao.getInstancia().remove(enc5);
		EncomiendaDao.getInstancia().remove(enc6);
		*/	
		
		
		/*verificar metodo esEnvioTercerizado
		 * para encomienda con volumen granel
		 * y para encomienda que vence si no se manda ya*/
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("verificar metodo esEnvioTercerizado");
		System.out.println("para encomienda con volumen granel");
		System.out.println("y para encomienda que vence si no se manda ya");
		Encomienda enc7 = testEncomienda(1,2,1,100,100f,200f,100f,200f,10);
		System.out.println("----Nueva encomienda: "+enc7.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();
		
		Envio envio7 = new Envio();
		Integer idEnvio7 = GestionEncomienda.getInstancia().asignarEnvio(enc7.getIdEncomienda(), null);
		if(idEnvio7 != null){
			System.out.println("----Asignada al envío : "+idEnvio7+"----------");
			System.in.read();

			envio7 = (Envio) EnvioDao.getInstancia().getById(idEnvio7);
			System.out.println("Encomienda Tercerizada, con volumen granel "+ enc7.getVolumenGranel());
			System.out.println("sucursal origen:  "+ envio7.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio7.getSucursalDestino().getDescripcion());
			System.out.println("estado :  "+ envio7.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc7.getEstado());
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
		}
				
		System.out.println("-----------------------------------------------------------------------------------");
		System.in.read();		

		//EnvioDao.getInstancia().remove(envio7);
		//EncomiendaDao.getInstancia().remove(enc7);


		Encomienda enc8 = testEncomienda(1,2,1,100,100f,200f,100f,200f,1);

		System.out.println("----Nueva encomienda: "+enc8.getIdEncomienda()+". Se intentará asignar a un envío----------");
		System.in.read();
		Envio envio8 = new Envio();
		Integer idEnvio8 = GestionEncomienda.getInstancia().asignarEnvio(enc8.getIdEncomienda(), null);
		if(idEnvio8 != null){
			System.out.println("----Asignada al envío : "+idEnvio8+"----------");
			System.in.read();

			envio8 = (Envio) EnvioDao.getInstancia().getById(idEnvio8);
			System.out.println("Encomienda Tercerizada con fecha estimada de entrega: "+ enc8.getFechaEstimadaEntrega());
			System.out.println("sucursal origen:  "+ envio8.getSucursalOrigen().getDescripcion());
			System.out.println("sucursal destino:  "+ envio8.getSucursalDestino().getDescripcion());
			System.out.println("estado envio:  "+ envio8.getEstado());
			System.out.println("Encomienda tiene estado :  "+ enc8.getEstado());
		}
		else{
			System.out.println("No se pudo asignar la encomienda a un envio.");
			}
		System.out.println("-----------------------------------------------------------------------------------");
		System.in.read();		

	//	EnvioDao.getInstancia().remove(envio8);
	//	EncomiendaDao.getInstancia().remove(enc8);
		
	}
	
	
	/*
	 * Crear encomienda particular.
	 * Fecha de recepcion: hoy + días por parámtro.
	 */
	public static Encomienda testEncomienda(int idSucursalOrigen, int idSucursalDestino, int idCliente, int nmro, float alto
			,float peso, float volumen, float carga, int dias){
		
		
		
		float nro = nmro;
		DTO_ClienteParticular cli = new DTO_ClienteParticular();
		cli.setId(idCliente);
    	DTO_Sucursal sucursalOrigen = SucursalDao.getInstancia().getById(idSucursalOrigen).toDTO();
    	DTO_Sucursal sucursalDestino = SucursalDao.getInstancia().getById(idSucursalDestino).toDTO();
    	
    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();

		encomienda.setCliente(cli);
		encomienda.setSucursalActual(sucursalOrigen);
		encomienda.setSucursalOrigen(sucursalOrigen);
		encomienda.setSucursalDestino(sucursalDestino);
		encomienda.setLargo(nro);
		encomienda.setAncho(nro);
			
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
		Date fecha = calendar.getTime();
		encomienda.setFechaEstimadaEntrega(fecha);
		
		encomienda.setAlto(alto);
		encomienda.setPeso(peso);
		encomienda.setVolumen(volumen);
		encomienda.setTratamiento("nada"); 
		encomienda.setApilable(true);
		encomienda.setCantApilable((short)2); 
		encomienda.setRefrigerado(false);
		encomienda.setCondicionTransporte(null); 
		encomienda.setIndicacionesManipulacion(null);
		encomienda.setFragilidad("no"); 
		encomienda.setNombreReceptor("Alfredo"); 
		encomienda.setApellidoReceptor("Receptor");
		encomienda.setDniReceptor("99876543"); 
		encomienda.setVolumenGranel(carga); 
		encomienda.setUnidadGranel(null);
		if(carga>0)
			encomienda.setCargaGranel("Carga Granel");	
		
		Encomienda enc = GestionEncomienda.getInstancia().crearEncomiendaParticular(encomienda);
		return enc;
	}
	
	
	
}
