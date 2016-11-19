package com.ADG04.Repositorio.bussinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Pais;
import com.ADG04.bean.Administracion.DTO_Provincia;
import com.ADG04.bean.Administracion.DTO_Rol;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_Cliente;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioHistorico;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_EnvioTercerizado;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.bean.Encomienda.DTO_MapaDeRuta;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Proveedor.DTO_TarifasCarrier;
import com.ADG04.bean.Proveedor.DTO_Proveedor;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Vehiculo.DTO_PlanMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento;
import com.ADG04.bean.Vehiculo.DTO_TareaMantenimientoRealizada;
import com.ADG04.bean.Vehiculo.DTO_TareasPorKilometro;
import com.ADG04.bean.Vehiculo.DTO_TareasPorTiempo;
import com.ADG04.bean.Vehiculo.DTO_Vehiculo;

public class BusinessDelegate implements InterfazRemotaDistribucionPaquetes
{
 	private InterfazRemotaDistribucionPaquetes businessService;
  
	public InterfazRemotaDistribucionPaquetes getBusinessService() {
		
		return businessService;
	}

	public BusinessDelegate() throws MalformedURLException, RemoteException, NotBoundException {
		super();
		try {
			this.businessService =(InterfazRemotaDistribucionPaquetes)Naming.lookup (InterfazRemotaDistribucionPaquetes.url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException{
		return this.businessService.getClienteParticularById(idCliente);
	}
	
	public DTO_ClienteParticular getClienteParticularByDni(String dni) throws RemoteException{
		return this.businessService.getClienteParticularByDni(dni);
	}

	public DTO_Usuario getUsuario(String dni) throws RemoteException{
		return this.businessService.getUsuario(dni);
	}


	public void altaUsuario(DTO_Usuario usuario) throws RemoteException {
		this.businessService.altaUsuario(usuario);
	}


	public void modificarUsuario(DTO_Usuario usuario) throws RemoteException {
		this.businessService.modificarUsuario(usuario);
	}


	public void bajaUsuario(Integer idUsuario) throws RemoteException {
		this.businessService.bajaUsuario(idUsuario);
	}


	public DTO_Usuario getUsuario(Integer idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public DTO_Usuario login(String usuario, String password)
			throws RemoteException, BusinessException {
		return this.businessService.login(usuario, password);
	}

	public List<String> buscarRolesUsuario(int usuario) throws RemoteException{
		return this.businessService.buscarRolesUsuario(usuario);
	}

	public void altaSucursal(DTO_Sucursal sucursal) throws RemoteException {
		this.businessService.altaSucursal(sucursal);
	}


	public void modificarSucursal(DTO_Sucursal sucursal) throws RemoteException {
		this.businessService.modificarSucursal(sucursal);
		
	}


	public void bajaSucursal(Integer idSucursal) throws RemoteException {
		this.businessService.bajaSucursal(idSucursal);
		
	}


	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		return this.businessService.getSucursal(idSucursal);
	}


	public void altaSeguro(DTO_Seguro seguro) throws RemoteException {
		this.businessService.altaSeguro(seguro);
	}


	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException {
		this.businessService.modificarSeguro(seguro);
		
	}


	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad)
			throws RemoteException {
		this.businessService.altaServicioSeguridad(servicioSeguridad);
		
	}


	public void modificarServicioSeguridad(
			DTO_ServicioSeguridad servicioSeguridad) throws RemoteException {
		this.businessService.modificarServicioSeguridad(servicioSeguridad);
		
	}
	
	public void altaTarifasCarrier(DTO_TarifasCarrier tarifasCarrier)
			throws RemoteException {
		this.businessService.altaTarifasCarrier(tarifasCarrier);
		
	}


	public void modificarTarifasCarrier(DTO_TarifasCarrier tarifasCarrier) throws RemoteException {
		this.businessService.modificarTarifasCarrier(tarifasCarrier);
		
	}


	public void bajaProveedor(Integer idProveedor) throws RemoteException {
		this.businessService.bajaProveedor(idProveedor);
		
	}


	public void altaClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		this.businessService.altaClienteParticular(cliente);
		
	}


	public void modificarClienteParticular(DTO_ClienteParticular cliente)
			throws RemoteException {
		this.businessService.modificarClienteParticular(cliente);
		
	}


	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		this.businessService.altaClienteEmpresa(empresa);	
	}


	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa)
			throws RemoteException {
		this.businessService.modificarClienteEmpresa(empresa);
	}


	public void eliminarCliente(Integer idCliente) throws RemoteException {
		this.businessService.eliminarCliente(idCliente);
		
	}


	public List<DTO_ClienteEmpresa> getClientesEmpresa()
			throws RemoteException {
		return this.businessService.getClientesEmpresa();
	}


	public List<DTO_ClienteParticular> getClientesParticular()
			throws RemoteException {
		return this.businessService.getClientesParticular();
	}
	

	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
			throws RemoteException {
		return this.businessService.getClienteEmpresaById(idCliente);
	}


	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit)
			throws RemoteException {
		return this.businessService.getClienteEmpresaByCuit(cuit);
	}


	public void altaProducto(DTO_Producto producto) throws RemoteException {
		this.businessService.altaProducto(producto);
		
	}


	public void modificarProducto(DTO_Producto producto) throws RemoteException {
		this.businessService.modificarProducto(producto);
	}


	public void eliminarProducto(Integer idProducto) throws RemoteException {
		this.businessService.eliminarProducto(idProducto);
		
	}


	public void eliminarProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public DTO_Producto getProducto(Integer idProducto) throws RemoteException {
		return this.businessService.getProducto(idProducto);
	}


	public DTO_Producto getProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		return this.businessService.getProducto(idCliente, codigoProducto);
	}


	public void agregarCreditoCtaCteByCuit(String clienteCuit, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void agregarCreditoCtaCteByIdCliente(int idCliente, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void descontarCreditoCtaCteByCuit(String clienteCuit, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void descontarCreditoCtaCteByIdCliente(int idCliente, float credito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void setLimiteCreditoByCuit(String clienteCuit, float limiteCredito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void setLimiteCreditoByIdCliente(int idCliente, float limiteCredito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public DTO_Factura getFacturaClienteByCuit(String cuitCliente)
			throws RemoteException {
		return this.businessService.getFacturaClienteByCuit(cuitCliente);
	}


	public DTO_Factura getFacturaClienteByDni(String dni)
			throws RemoteException {

		return this.businessService.getFacturaClienteByDni(dni);
	}


	public void addItem(int idFactura, int cantidad, float valor,
			String descripcion) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void deleteItem(int idFactura, int idItem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public List<DTO_Factura> getFacturasPendientesByCuit(String cuit)
			throws RemoteException {
		return this.businessService.getFacturasPendientesByCuit(cuit);
	}


	public List<DTO_Factura> getFacturasPendientesByDni(String dni)
			throws RemoteException {
		return this.businessService.getFacturasPendientesByDni(dni);
	}


	public List<DTO_Factura> getFacturasByCuit(String cuit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<DTO_Factura> getFacturasByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public DTO_EnvioPropio getInfoEnvioPropio(int idEnvio) throws RemoteException{
		
		return this.businessService.getInfoEnvioPropio(idEnvio);
		
	}
	
	public Integer gestionarEnvioEncomienda(int idEncomienda) throws RemoteException, BusinessException{
		return this.businessService.gestionarEnvioEncomienda(idEncomienda);
	}
	


	public void nuevaEncomiedaEmpresa(String dniCliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String tratamiento, boolean apilable,
			short cantApilable, boolean refrigerado,
			String condiciionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor,
			String dniReceptor, Double volumenGranel, String unidadGranel,
			String cargaGranel) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void setFechaEstimadaEntrega(int idEncomienda,
			Date fechaEstimadaDeEntrega) throws RemoteException {

		this.businessService.setFechaEstimadaEntrega(idEncomienda, fechaEstimadaDeEntrega);
		
	}


	public void agregarRemito(int idEncomienda, DTO_Remito remito)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void agregarProducto(DTO_Producto producto, int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	public void eliminarProducto(int idProducto, int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void modificarCoordenadas(int idEnvio, DTO_Coordenada coordenadas)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void ingresarEncomiendaEnvio(Integer idEnvio) {
		// TODO Auto-generated method stub
		
	}

	public void egresarEncomiendaEnvio(Integer idEnvio) {
		// TODO Auto-generated method stub
		
	}

	public Integer asignarEnvio(Integer idEncomienda) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaEmpresa(List<Integer> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaParticular(Integer idFactura) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer nuevaEncomiendaEmpresa(Integer idSucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	public DTO_Usuario validarUsuario(String usuario, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer altaVehiculo(DTO_Vehiculo v) throws RemoteException {
		return this.businessService.altaVehiculo(v);
	}

	/*public void altaTareaMantenimiento(DTO_TareasPorKilometro tareaXKM, Integer idVehiculo) throws RemoteException, Exception  {
		this.businessService.altaTareaMantenimiento(tareaXKM, idVehiculo);		
	}

	public Integer altaPlanMantenimiento(DTO_PlanMantenimiento pm, Integer idVehiculo)throws RemoteException , Exception {
		return this.businessService.altaPlanMantenimiento(pm, idVehiculo);
	}

	public Integer altaTareaMantenimiento(DTO_TareasPorTiempo tareaXTiempo, Integer idVehiculo) throws RemoteException, Exception   {
		return this.businessService.altaTareaMantenimiento(tareaXTiempo, idVehiculo);
	}
*/
	public List<com.ADG04.bean.Vehiculo.DTO_TareaMantenimiento> getTareasVencidas(int idVehiculo) throws RemoteException   {
		return this.businessService.getTareasVencidas(idVehiculo);
	}

	public void altaProveedor(DTO_Proveedor prov) throws RemoteException {
		this.businessService.altaProveedor(prov);
		
	}

	public List<DTO_Seguro> getSeguros() throws RemoteException {
		return this.businessService.getSeguros();
	}

	public List<DTO_TarifasCarrier> getTarifasCarriers() throws RemoteException {
		return this.businessService.getTarifasCarriers();
	}

	public List<DTO_ServicioSeguridad> getServicioSeguridad()
			throws RemoteException {
		return this.businessService.getServicioSeguridad();
	}

	public List<DTO_Proveedor> getTalleresMecanicos()
			throws RemoteException {
		return this.businessService.getTalleresMecanicos();
	}
	
	public List<DTO_Proveedor> getAseguradoras()
			throws RemoteException {
		return this.businessService.getAseguradoras();
	}
	
	public List<DTO_Proveedor> getEmpresasServiciosSeguridad()
			throws RemoteException {
		return this.businessService.getEmpresasServiciosSeguridad();
	}

	public List<DTO_Proveedor> getCarriers()
			throws RemoteException {
		return this.businessService.getCarriers();
	}
	
	public List<DTO_Vehiculo> listarVehiculos() throws RemoteException {
		return this.businessService.listarVehiculos();
	}

	public void altaTallerMecanico(DTO_Proveedor taller) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void modificarTallerMecanico(DTO_Proveedor taller)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public List<DTO_Proveedor> getProveedores() throws RemoteException {
		// TODO Auto-generated method stub
		return this.businessService.getProveedores();
	}

	public DTO_Proveedor getProveedor(Integer idProveedor) throws RemoteException {
		return this.businessService.getProveedor(idProveedor);
		
	}


	public List<DTO_Usuario> getUsuarios() throws RemoteException {
		return this.businessService.getUsuarios();
	}

	public DTO_Usuario getUsuarioPorDni(String dni) throws RemoteException {
		return this.businessService.getUsuarioPorDni(dni);
	}

	public List<DTO_Usuario> listarEmpleados() throws RemoteException {
		return this.businessService.listarEmpleados();
	}

	public List<DTO_Rol> listarRoles() throws RemoteException {
		return this.businessService.listarRoles();
	}

	public List<DTO_Usuario> listarEmpleados(Integer idSucursal)
			throws RemoteException {
		return this.businessService.listarEmpleados();
	}

	public List<DTO_PlanMantenimiento> listarPlanesMantenimiento() throws RemoteException {
		return this.businessService.listarPlanesMantenimiento();
	}

	public List<DTO_Sucursal> listarSucursales() throws RemoteException {
		return this.businessService.listarSucursales();
	}

	public DTO_Usuario getUsuarioById(Integer idGerente) throws RemoteException {
		return this.businessService.getUsuario(idGerente);
	}

	public List<DTO_Factura> listarFacturasCliente() throws RemoteException {
		return this.businessService.listarFacturasCliente();
	}

	public List<DTO_Factura> listarFacturasClientePendientes()
			throws RemoteException {
		return this.businessService.listarFacturasClientePendientes();
	}

	public List<DTO_TareaMantenimientoRealizada> listarTareaMantenimientoRealizada() throws RemoteException {
		return this.businessService.listarTareaMantenimientoRealizada();
	}

	public DTO_TareaMantenimiento getTareaMantenimiento(
			Integer idTareaMantenimiento) throws RemoteException {
		return this.businessService.getTareaMantenimiento(idTareaMantenimiento);
	}
	

	public Integer facturarEncomiendaEmpresa(int idEncomienda)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer cobrarEncomiendaEmpresa(Integer idFactura)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DTO_Usuario getEmpleado(Integer idEmpleado) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer facturarEncomiendaParticular(DTO_EncomiendaParticular enc)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;

	}

	public List<DTO_ClienteParticular> buscarClientesByNombreApellidoDni(String filtro)
			throws RemoteException {
		return this.businessService.buscarClientesByNombreApellidoDni(filtro);
	}

	public List<DTO_Sucursal> buscarSucursalesByNombre(String filtro) throws RemoteException {
		return this.businessService.buscarSucursalesByNombre(filtro);
	}

	public List<DTO_ClienteEmpresa> buscarClientesEmpresaByRazonSocial(String filtro) throws RemoteException {
		return this.businessService.buscarClientesEmpresaByRazonSocial(filtro);
	}

	public List<DTO_Proveedor> buscarProveedorByRazonSocial(String filtro) throws RemoteException {
		
		return this.businessService.buscarProveedorByRazonSocial(filtro);
	}

	public List<DTO_Usuario> buscarUsuariosByNombreApellidoOUsuario(String filtro) throws RemoteException {
		return this.businessService.buscarUsuariosByNombreApellidoOUsuario(filtro);
	}

	public List<DTO_Vehiculo> buscarVehiculoByModeloMarcaOPatente(String filtro) throws RemoteException {
		return this.businessService.buscarVehiculoByModeloMarcaOPatente(filtro);
	}

	public DTO_Vehiculo buscarVehiculoById(Integer idVehiculo) throws RemoteException{
		return this.businessService.buscarVehiculoById(idVehiculo);
	}
	
	public List<DTO_TareaMantenimientoRealizada> buscarTareasMantenimientoRealizadasPorVehiculo(String filtro) throws RemoteException{
		return this.businessService.buscarTareasMantenimientoRealizadasPorVehiculo(filtro);
	}

	public List<DTO_Factura> buscarFacturasByDniCliente(String filtro)  throws RemoteException{
		return this.businessService.buscarFacturasByDniCliente(filtro);
	}

	public List<DTO_Seguro> buscarSegurosByProveedor(String filtro) throws RemoteException {
		return this.businessService.buscarSegurosByProveedor(filtro);
	}

	public List<DTO_ServicioSeguridad> buscarServicioSeguridadByProveedor(
			String filtro) throws RemoteException {
		return this.businessService.buscarServicioSeguridadByProveedor(filtro);
	}

	public List<DTO_TarifasCarrier> buscarTarifasCarrierByProveedor(
			String filtro) throws RemoteException {
		return this.businessService.buscarTarifasCarrierByProveedor(filtro);
	}

	public List<DTO_Factura> buscarFacturasPendientesByDniCliente(String filtro) throws RemoteException {
		return this.businessService.buscarFacturasPendientesByDniCliente(filtro);
	}

	public DTO_EncomiendaParticular getEncomiendaParticular(Integer id)throws RemoteException {
		return this.businessService.getEncomiendaParticular(id);
	}

	public DTO_EncomiendaEmpresa getEncomiendaEmpresa(Integer id)throws RemoteException {
		return this.businessService.getEncomiendaEmpresa(id);
	}

	public List<DTO_EncomiendaParticular> listarEncomiendasParticulares()throws RemoteException {
		return this.businessService.listarEncomiendasParticulares();
	}

	public List<DTO_EncomiendaEmpresa> listarEncomiendasEmpresas()
			throws RemoteException {
		return this.businessService.listarEncomiendasEmpresas();
	}

	public DTO_Coordenada getCoordenadasById(int id)throws RemoteException {
		return this.businessService.getCoordenadasById(id);
	}

	public List<DTO_EnvioPropio> listarEnviosPropios()throws RemoteException {
		return this.businessService.listarEnviosPropios();
	}

	public List<DTO_EnvioTercerizado> listarEnviosTercerizados() throws RemoteException {
		return this.businessService.listarEnviosTercerizados();
	}

	public List<DTO_EnvioTercerizado> buscarEnviosByEstado(String filtro) throws RemoteException {
		return this.businessService.buscarEnviosByEstado(filtro);
	}
	
	public List<DTO_EnvioPropio> buscarEnviosPropiosByEstado(String filtro) throws RemoteException {
		return this.businessService.buscarEnviosPropiosByEstado(filtro);
	}

	public List<DTO_Provincia> listarProvinciasByPais(String pais) throws RemoteException {
		return this.businessService.listarProvinciasByPais(pais);
	}

	public DTO_Provincia buscarProvinciaByNombre(String prov) throws RemoteException {
		return this.businessService.buscarProvinciaByNombre(prov);
	}

	public DTO_PlanMantenimiento getPlanMantenimiento(Integer id) throws RemoteException{
		return this.businessService.getPlanMantenimiento(id);
	}

	public List<DTO_Pais> listarPaises() throws RemoteException{
		return this.businessService.listarPaises();
	}

	public DTO_Pais getPaisByNombre(String pais) throws RemoteException{
		return this.businessService.getPaisByNombre(pais);
	}

	public DTO_Provincia getProvByNombre(String prov) throws RemoteException{
		return this.businessService.getProvByNombre(prov);
	}


	public Integer nuevaEncomiedaParticular(
			DTO_EncomiendaParticular encomiendaParticular)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	public void altaTareaMantenimientoRealizada(
			DTO_TareaMantenimientoRealizada tmr) throws RemoteException{
		this.businessService.altaTareaMantenimientoRealizada(tmr);	
	}

	public DTO_Vehiculo buscarVehiculo(String patente) throws RemoteException{
		return this.businessService.buscarVehiculoByPatente(patente);
	}

	public List<DTO_TareaMantenimiento> getTareasMantenimiento(Integer idPlan) throws RemoteException{
		return this.businessService.getTareaMantenimientoByPlan(idPlan);
	}
	
	public void altaPlanMantenimiento(DTO_PlanMantenimiento pm) throws RemoteException{
		this.businessService.altaPlanMantenimiento(pm);
	}

	public void altaTareaMantenimiento(DTO_TareasPorKilometro tpk) throws RemoteException{
		this.businessService.altaTareaMantenimiento(tpk);
	}

	public void altaTareaMantenimiento(DTO_TareasPorTiempo tpt) throws RemoteException{
		this.businessService.altaTareaMantenimiento(tpt);	
	}


	public DTO_Vehiculo buscarVehiculoByPatente(String patente) throws RemoteException{
		return this.businessService.buscarVehiculoByPatente(patente);
	}

	public List<DTO_TareaMantenimiento> getTareaMantenimientoByPlan(Integer idPlan) throws RemoteException{
		return this.businessService.getTareaMantenimientoByPlan(idPlan);
	}

	public boolean cambiarPassword(String usuario, String oldPassword,String newPassword) throws RemoteException {
		return this.businessService.cambiarPassword(usuario,oldPassword,newPassword);
	}

	public DTO_Usuario existeUsuario(String usuario) throws RemoteException{
		return this.businessService.existeUsuario(usuario);
	}

	public DTO_Proveedor buscarProveedorByCuit(String cuit) throws RemoteException{
		return this.businessService.buscarProveedorByCuit(cuit);
	}

	public List<DTO_Direccion> listarDestinoNacional(Integer id) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<DTO_Direccion> listarDestinoInternacional(Integer id) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public void modificarVehiculo(DTO_Vehiculo v) throws RemoteException{
		this.businessService.modificarVehiculo(v);
		
	}

	public void bajaPlanMantenimiento(Integer id) throws RemoteException{
		this.businessService.bajaPlanMantenimiento(id);
	}

	
	public void bajaServicioSeguridad(Integer id) throws RemoteException{
		this.businessService.bajaServicioSeguridad(id);
	}

	public void bajaMapaDeRuta(Integer id) throws RemoteException{
		this.businessService.bajaMapaDeRuta(id);		
	}

	public void bajaSeguro(Integer id) throws RemoteException{
		this.businessService.bajaSeguro(id);	
	}

	public void bajaTarifasCarrier(Integer id) throws RemoteException{
		this.businessService.bajaTarifasCarrier(id);		
	}

	public DTO_ServicioSeguridad getServicioSeguridad(Integer id) throws RemoteException{
		return this.businessService.getServicioSeguridad(id);
	}

	public DTO_TarifasCarrier getTarifasCarrier(Integer id) throws RemoteException{
		return this.businessService.getTarifasCarrier(id);
	}

	public DTO_Seguro getSeguro(Integer id) throws RemoteException{
		return this.businessService.getSeguro(id);
	}

	public boolean estaProductoAsociado(Integer id) throws RemoteException{
		return this.businessService.estaProductoAsociado(id);
	}

	public boolean clienteTieneEncomiendas(Integer id) throws RemoteException{
		return this.businessService.clienteTieneEncomiendas(id);
	}

	public boolean sucursalTieneEncomiendas(Integer id) throws RemoteException{
		return this.businessService.sucursalTieneEncomiendas(id);
	}

	public boolean vehiculoAsociadoAEnvio(Integer id) throws RemoteException{
		return this.businessService.vehiculoAsociadoAEnvio(id);
	}

	public void bajaVehiculo(Integer id) throws RemoteException{
		this.businessService.bajaVehiculo(id);
	}

	public boolean tareaEstaRealizada(Integer id) throws RemoteException{
		return this.businessService.tareaEstaRealizada(id);
	}

	public void bajaTareaMantenimiento(Integer id) throws RemoteException{
		this.businessService.bajaTareaMantenimiento(id);
	}

	public void modificarProveedor(DTO_Proveedor prov) throws RemoteException{
		this.businessService.modificarProveedor(prov);
		
	}

	public Integer nuevaEncomiedaEmpresa(DTO_EncomiendaEmpresa encomiendaEmpresa)
			throws RemoteException, BusinessException {
		return this.nuevaEncomiedaEmpresa(encomiendaEmpresa);
	}

	public void altaMapaDeRuta(DTO_MapaDeRuta mapa) throws RemoteException, BusinessException {
		 this.businessService.altaMapaDeRuta(mapa);
	}

	public void modificarMapaDeRuta(DTO_MapaDeRuta mapa) throws RemoteException, BusinessException {
		 this.businessService.modificarMapaDeRuta(mapa);
	}
	public DTO_MapaDeRuta getMapaDeRuta(Integer id) throws RemoteException{
		return this.businessService.getMapaDeRuta(id);
	}

	public DTO_Manifiesto getManifiesto(Integer id) throws RemoteException{
		return this.businessService.getManifiesto(id);
	}

	public DTO_Remito getRemito(Integer id)  throws RemoteException{
		return this.businessService.getRemito(id);
	}

	public List<DTO_Producto> buscarProductosByRazonSocialCliente(String razonSocial) throws RemoteException{
		return this.businessService.buscarProductosByRazonSocialCliente(razonSocial);
	}

	public List<DTO_Producto> listarProductos() throws RemoteException{
		return this.businessService.listarProductos();
	}

	public List<DTO_Manifiesto> listarManifiestos() throws RemoteException{
		return this.businessService.listarManifiestos();
	}

	public List<DTO_Remito> listarRemitos() throws RemoteException {
		return this.businessService.listarRemitos();
	}

	public void actualizarEstadoEnvios(String dir)  throws RemoteException {
		this.businessService.actualizarEstadoEnvios(dir);
	}

	public DTO_Envio getEnvio(Integer id) throws RemoteException {
		return this.businessService.getEnvio(id);
	}

	public List<DTO_EnvioHistorico> getHistorico(Integer id) throws RemoteException {
		return this.businessService.getHistorico(id);
	}

	public DTO_EnvioPropio getEnvioPropio(Integer id) throws RemoteException {
		return this.businessService.getEnvioPropio(id);
	}

	public boolean existeMapaDeRuta(Integer idSucOrigen, Integer idSucDestino) throws RemoteException{
		return this.businessService.existeMapaDeRuta(idSucOrigen, idSucDestino);
	}

	public List<DTO_MapaDeRuta> listarMapasDeRuta() throws RemoteException {
		return this.businessService.listarMapasDeRuta();
	}

	public List<DTO_Encomienda> listarEncomiendasBySucursal(int idSucursal)
			throws RemoteException {
		return this.businessService.listarEncomiendasBySucursal(idSucursal);
	}

	public DTO_Factura getFacturaById(Integer id) throws RemoteException {
		return this.businessService.getFacturaById(id);
	}

	public List<DTO_Encomienda> listarEncomiendasBySucursalPendientes(
			int idSucursal) throws RemoteException {
		return this.businessService.listarEncomiendasBySucursalPendientes(idSucursal);
	}

	public boolean estaEncomiendaAsignada(int idEncomienda)
			throws RemoteException {
		return this.businessService.estaEncomiendaAsignada(idEncomienda);
	}

	public void actualizarEstadoEnvio(Integer idEnvio, String estado)
			throws RemoteException {
		this.businessService.actualizarEstadoEnvio(idEnvio, estado);
	}

	public List<DTO_Encomienda> listarEncomiendasByEnvio(int idEnvio)
			throws RemoteException {
		return this.businessService.listarEncomiendasByEnvio(idEnvio);
	}

	public List<DTO_Envio> listarEnviosPendientesBySucursalDestino(
			int idSucursalDestino) throws RemoteException {
		return this.businessService.listarEnviosPendientesBySucursalDestino(idSucursalDestino);
	}
}
