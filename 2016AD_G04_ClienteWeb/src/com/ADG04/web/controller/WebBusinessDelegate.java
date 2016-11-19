package com.ADG04.web.controller;
import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.Repositorio.Interfaces.*;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.*;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebBusinessDelegate {//implements InterfazRemotaDistribucionPaquetes {
	
	InterfazRemotaDistribucionPaquetes objetoRemoto;
	private static WebBusinessDelegate instancia;
	
	private WebBusinessDelegate() throws Exception{
		getStub();
	}
	
	public static WebBusinessDelegate getInstancia() throws Exception{
		if(instancia==null)
			instancia = new WebBusinessDelegate();
		return instancia;
	}
	
	public boolean getStub() throws Exception{
		
		try {
			this.objetoRemoto =(InterfazRemotaDistribucionPaquetes)Naming.lookup (InterfazRemotaDistribucionPaquetes.url);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	//Usuarios-----------------------------------------------------------------
	
	// TODO Completar el metodo validarUsuario
	public DTO_Usuario validarUsuario(String usuario, String contrasena) throws BusinessException{		
		try {
			DTO_Usuario usu = objetoRemoto.login(usuario,contrasena);
			return usu;			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	//@SuppressWarnings("null")
	public Integer pagarFacturaClientePaticular(Integer idFactura){
		//
		try {
			return  objetoRemoto.cobrarEncomiendaParticular(idFactura);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//@SuppressWarnings("null")
		public Integer pagarFacturaClienteEmpresa(Integer idFactura){
			//
			try {
				return  objetoRemoto.cobrarEncomiendaEmpresa(idFactura);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
	
	
	

	//@SuppressWarnings("null")
	public Integer obtenerSucursalEmpleado(Integer idEmpleado){
		//
		try {
			return  objetoRemoto.getEmpleado(idEmpleado).getIdSucursal();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
		
/*
	public Integer confirmarEncomiendaEmpresa(DTO_EncomiendaEmpresa enc){
		
		try {
			objetoRemoto.confirmarEncomiendaEmpresa(enc);
			return objetoRemoto.facturarEncomiendaEmpresa(enc.getIdEncomienda());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
*/
	/*
	public Integer ingresarEncomiendaParticularAStock(DTO_EncomiendaEnStock es){
		
		try {
			return objetoRemoto.ingresarEncomiendaParticularAStock(es);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
	
	public Integer ingresarEncomiendaEmpresaAStock(DTO_EncomiendaEnStock es){
		
		try {
			return objetoRemoto.ingresarEncomiendaEmpresaAStock(es);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
		
	public Integer egresarEncomiendaParticularDeStock(Integer idStock, Integer idEncomienda){
		
		try {
			return objetoRemoto.egresarEncomiendaParticularDeStock(idStock,idEncomienda);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
		
	
	public Integer egresarEncomiendaEmpresaDeStock(Integer idStock, Integer idEncomienda){
		
		try {
			return objetoRemoto.egresarEncomiendaEmpresaDeStock(idStock,idEncomienda);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}		
	*/
	
	public String getSucursalNombre(Integer id){
		
		try {
			DTO_Sucursal suc = objetoRemoto.getSucursal(id);
			return suc.getDescripcion();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	/*
	public List<DTO_Destino> listarDestinoNacional(Integer id){
		
		List<DTO_Destino> destinos = null; 
		
		try {
			destinos = objetoRemoto.listarDestinoNacional(id);
			return destinos;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinos;
	}	
	
	*/
	public Integer altaManifiesto(DTO_Manifiesto m){
		
		Integer idManifiesto;
		//TODO: no hace nada.
		//llamo por RMI a una funcion que crea el manifiesto y me da el id
		//idManifiesto = altaManifiesto(m);
		
		idManifiesto = 70;
		
		return idManifiesto;
	}		
	/*
	public boolean ingresarEncomiendaStockEnvio(Integer idEnvio, Integer idStock){
		try {
			objetoRemoto.ingresarEncomiendaEnvio(idEnvio, idStock);
			return true;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean egresarEncomiendaStockEnvio(Integer idEnvio, Integer idStock){
		try {
			objetoRemoto.egresarEncomiendaEnvio(idEnvio, idStock);
			return true;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
*/


	public void altaTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarServicioSeguridad(
			DTO_ServicioSeguridad servicioSeguridad) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void bajaProveedor(Integer idProveedor) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public DTO_Proveedor getProveedor(Integer idProveedor)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Seguro> getSeguros() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_TarifasCarrier> getTarifasCarriers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_ServicioSeguridad> getServicioSeguridad()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Proveedor> getTalleresMecanicos() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Proveedor> getAseguradoras() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Proveedor> getEmpresasServiciosSeguridad()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Proveedor> getCarriers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Proveedor> getProveedores() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_ClienteParticular getClienteParticularById(Integer idCliente)
			throws RemoteException {
		return this.objetoRemoto.getClienteParticularById(idCliente);
	}

	
	public DTO_ClienteParticular getClienteParticularByDni(String dni)
			throws RemoteException {
		return objetoRemoto.getClienteParticularByDni(dni);
	}

	
	public List<DTO_ClienteEmpresa> getClientesEmpresa() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_ClienteParticular> getClientesParticular()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
			throws RemoteException {
		return this.objetoRemoto.getClienteEmpresaById(idCliente);
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit)
			throws RemoteException {
		return this.objetoRemoto.getClienteEmpresaByCuit(cuit);
	}

	
	public void altaProducto(DTO_Producto producto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarProducto(DTO_Producto producto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void eliminarProducto(Integer idProducto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void eliminarProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_Producto getProducto(Integer idProducto) throws RemoteException {
		return this.objetoRemoto.getProducto(idProducto);
	}

	public Integer nuevaEncomiedaParticular(DTO_EncomiendaParticular encomiendaParticular) throws RemoteException, BusinessException {
		Integer idencomienda = objetoRemoto.nuevaEncomiedaParticular(encomiendaParticular);
		
		return idencomienda;
	}

	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		return objetoRemoto.getSucursal(idSucursal);
	}

	public Integer nuevaEncomiedaEmpresa(DTO_EncomiendaEmpresa encomiendaEmpresa) throws RemoteException, BusinessException {
		return objetoRemoto.nuevaEncomiedaEmpresa(encomiendaEmpresa);		
	}

	public List<DTO_EncomiendaParticular> listarEncomiendasParticulares() throws RemoteException {
		return objetoRemoto.listarEncomiendasParticulares();
	}

	public List<DTO_EncomiendaEmpresa> listarEncomiendasEmpresa() throws RemoteException {
		return this.objetoRemoto.listarEncomiendasEmpresas();
	}

	public DTO_EncomiendaParticular getEncomiendaParticular(int idEncomienda) throws RemoteException {
		return objetoRemoto.getEncomiendaParticular(idEncomienda);
	}

	public DTO_Factura getFacturaById(Integer id) throws RemoteException {
		return objetoRemoto.getFacturaById(id);
	}

	public Integer asignarEnvio(Integer idEncomienda) throws RemoteException, BusinessException {
		return objetoRemoto.asignarEnvio(idEncomienda);
	}

	public DTO_Envio getEnvio(Integer idEnvio)throws RemoteException {
		return objetoRemoto.getEnvio(idEnvio);
	}
	
	public boolean estaEncomiendaAsignada(int idEncomienda)throws RemoteException{
		return objetoRemoto.estaEncomiendaAsignada(idEncomienda);
	}

	public void actualizarEstadoEnvio(Integer idEnvio, String estado) throws RemoteException {
		this.objetoRemoto.actualizarEstadoEnvio(idEnvio, estado);
	}

	public List<DTO_Encomienda> listarEncomiendasByEnvio(int idEnvio) throws RemoteException {
		return this.objetoRemoto.listarEncomiendasByEnvio(idEnvio);
	}

	public List<DTO_Envio> listarEnviosPendientesBySucursalDestino(int idSucursalDestino) throws RemoteException {
		return this.objetoRemoto.listarEnviosPendientesBySucursalDestino(idSucursalDestino);
	}

	public DTO_EncomiendaEmpresa getEncomiendaEmpresa(int idEncomienda) throws RemoteException {
		return this.objetoRemoto.getEncomiendaEmpresa(idEncomienda);
	}
		
}
