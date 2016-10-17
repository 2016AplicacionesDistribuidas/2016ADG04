package com.ADG04.Servidor.rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ADG04.Negocio.GestionAdministracion;
import com.ADG04.Negocio.GestionCliente;
import com.ADG04.Negocio.GestionControlViajes;
import com.ADG04.Negocio.GestionEncomienda;
import com.ADG04.Repositorio.Interfaces.InterfazRemotaDistribucionPaquetes;
import com.ADG04.Servidor.dao.CoordenadaDao;
import com.ADG04.Servidor.dao.SucursalDao;
import com.ADG04.Servidor.model.Coordenada;
import com.ADG04.Servidor.model.Encomienda;
import com.ADG04.Servidor.model.Envio;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Administracion.DTO_Usuario;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Coordenada;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_EnvioPropio;
import com.ADG04.bean.Encomienda.DTO_Remito;
import com.ADG04.bean.Proveedor.DTO_Carrier;
import com.ADG04.bean.Proveedor.DTO_Seguro;
import com.ADG04.bean.Proveedor.DTO_ServicioSeguridad;
import com.ADG04.bean.Proveedor.DTO_TallerMecanico;

public class DistribucionPaquetesRMI  extends UnicastRemoteObject implements InterfazRemotaDistribucionPaquetes {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DistribucionPaquetesRMI() throws RemoteException {
		super();
	}

	public void altaUsuario(DTO_Usuario Usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void modificarUsuario(DTO_Usuario Usuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void bajaUsuario(Integer idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public DTO_Usuario getUsuario(Integer idUsuario) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaSucursal(DTO_Sucursal sucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void modificarSucursal(DTO_Sucursal sucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void bajaSucursal(Integer idSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public DTO_Sucursal getSucursal(Integer idSucursal) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void altaClienteParticular(DTO_ClienteParticular cliente) throws RemoteException {
		
		GestionCliente gCliente = GestionCliente.getInstancia();
		gCliente.altaClienteParticular(cliente);
		
	}

	
	public void modificarClienteParticular(DTO_ClienteParticular cliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	public void bajaCliente(Integer idCliente) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	
	public DTO_ClienteParticular getClienteParticular(String dni) throws RemoteException {

		DTO_ClienteParticular cdto = new DTO_ClienteParticular();
		//ClienteDao dao = new ClienteDao(EntityManagerProvider.getInstance().getEntityManager());
		//Cliente cliente = dao.getCliente(cuit);
		
		cdto.setDni("12345678");
		cdto.setNombre("Peperulo");
		cdto.setApellido("Perez");
		
		return cdto;
	}

	
	public List<DTO_ClienteParticular> getClientesEmpresa() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_ClienteParticular> getClientesParticular() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_Factura getFacturaClienteByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<DTO_Factura> getFacturasPendientesByDni(String dni)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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

	
	public DTO_Usuario getUsuario(String dni) throws RemoteException {

		//UsuarioDao dao = new UsuarioDao(entityManager);
		DTO_Usuario usuario = new DTO_Usuario();
		
		usuario.setNombre("Vanesa");
		usuario.setApellido("Guccione");
		usuario.setDni("32437264");
		
		return usuario;
	}

	
	public DTO_ClienteParticular getClienteParticular(Integer idCliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaById(Integer idCliente)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_ClienteEmpresa getClienteEmpresaByCuit(String cuit)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	
	public DTO_Producto getProducto(Integer idCliente, String codigoProducto)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public int nuevaEncomiedaParticular(String dniCliente,
			int idDireccionOrigen, int idDireccionDestino, int idSucursalOrigen, int idSucursalDestino,
			float largo, float ancho, float alto, float peso, float volumen, String tratamiento, boolean apilable,
			short cantApilable, boolean refrigerado, String condiciionTransporte, String indicacionesManipulacion,
			String fragilidad, String nombreReceptor, String apellidoReceptor, String dniReceptor, float volumenGranel, 
			String unidadGranel) throws RemoteException {
		
		int idCliente = GestionAdministracion.getInstancia().getClienteByDni(dniCliente).getIdCliente();
		
		DTO_ClienteParticular cli = new DTO_ClienteParticular();
		cli.setId(idCliente);
    	DTO_Sucursal sucursalOrigen = SucursalDao.getInstancia().getById(idSucursalOrigen).toDTO();
    	DTO_Sucursal sucursalDestino = SucursalDao.getInstancia().getById(idSucursalDestino).toDTO();
    	
    	DTO_EncomiendaParticular encomienda = new DTO_EncomiendaParticular();

		encomienda.setCliente(cli);
		encomienda.setSucursalActual(sucursalOrigen);
		encomienda.setSucursalOrigen(sucursalOrigen);
		encomienda.setSucursalDestino(sucursalDestino);
		encomienda.setLargo(largo);
		encomienda.setAncho(ancho);
			
		//Calendar calendar = Calendar.getInstance();
		//calendar.setTime(new Date()); // Configuramos la fecha que se recibe
		//calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
		//Date fecha = calendar.getTime();
		
		//encomienda.setFechaEstimadaEntrega(new Date());
		
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
		encomienda.setInternacional(false);
		encomienda.setVolumenGranel(volumenGranel); 
		
		if(volumenGranel > 0){
			encomienda.setCargaGranel("Carga Granel");
			encomienda.setUnidadGranel(unidadGranel);
		}
		
		Encomienda enc = GestionEncomienda.getInstancia().crearEncomiendaParticular(encomienda);
		/*DTO_EncomiendaParticular encDTO = new DTO_EncomiendaParticular();
		encDTO.setAlto(enc.getAlto());
		encDTO.setAncho(enc.getAncho());
		encDTO.setLargo(enc.getLargo());
		encDTO.setPeso(enc.getPeso());
		encDTO.setVolumen(enc.getVolumen());
		encDTO.setVolumenGranel(enc.getVolumenGranel());
		encDTO.setCantApilable(enc.getCantApilable());
		encDTO.setAlto(enc.getIdEncomienda());
		encDTO.setAlto(enc.getApellidoReceptor());
		encDTO.setAlto(enc.getApilable());
		encDTO.setAlto(enc.getCargaGranel());
		encDTO.setAlto(enc.getCliente());
		encDTO.setAlto(enc.getCondicionTransporte());
		encDTO.setAlto(enc.getDireccionDestino());
		encDTO.setAlto(enc.getDireccionOrigen());
		encDTO.setAlto(enc.getDniReceptor());
		encDTO.setAlto(enc.getEstado());
		encDTO.setAlto(enc.getFechaEstimadaEntrega());
		encDTO.setAlto(enc.getFragilidad());
		encDTO.setAlto(enc.getIndicacionesManipulacion() );
		encDTO.setAlto(enc.getManifiesto());
		encDTO.setAlto(enc.getNombreReceptor());
		encDTO.setAlto(enc.getRefrigerado());
		encDTO.setAlto(enc.getSucursalDestino());
		encDTO.setAlto(enc.getSucursalOrigen());
		encDTO.setAlto(enc.getTratamiento());
		encDTO.setAlto(enc.getUnidadGranel());
		
		*/
		System.out.println("--------------EncomienencDTO.setAlto(enc.getApellidoReceptor());da: " + enc.getIdEncomienda() + "----------------------");
		
		return enc.getIdEncomienda();
	}
	
	
	public void nuevaEncomiedaParticular(DTO_EncomiendaParticular encomiendaParticular) {
		
		GestionEncomienda gEnc = GestionEncomienda.getInstancia();
		
		gEnc.altaEncomiendaParticular(encomiendaParticular);
	}
			
	
	public void nuevaEncomiedaParticular(
			String dniCliente, 
			DTO_Sucursal sucursalOrigen,
			DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso, double volumen,
			String nombreReceptor, String apellidoReceptor,String dniReceptor){
	
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
		// TODO Auto-generated method stub
		
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

	public void nuevaEncomiedaParticular(String dniCliente,
			DTO_Direccion direccionOrigen, DTO_Direccion direccionDestino,
			DTO_Sucursal sucursalOrigen, DTO_Sucursal sucursalDestino,
			double largo, double ancho, double alto, double peso,
			double volumen, String nombreReceptor, String apellidoReceptor,
			String dniReceptor) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public DTO_ClienteParticular getClienteParticularByDni(String dni)throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DTO_ClienteParticular getClienteParticularById(Integer idCliente) throws RemoteException {
		return null;
	}
	
	public void eliminarCliente(Integer idCliente) throws RemoteException {
		
	}

	public void altaClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException{
		
	}
	public void modificarClienteEmpresa(DTO_ClienteEmpresa empresa) throws RemoteException{
		
	}
	
	public void altaSeguro(DTO_Seguro seguro) throws RemoteException {
		
	}
	public void modificarSeguro(DTO_Seguro seguro) throws RemoteException{
		
	}
	public void altaServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad) throws RemoteException{
		
	}
	public void modificarServicioSeguridad(DTO_ServicioSeguridad servicioSeguridad) throws RemoteException{
		
	}
	public void altaTallerMecanico(DTO_TallerMecanico taller) throws RemoteException{
		
	}
	public void modificarTallerMecanico(DTO_TallerMecanico taller) throws RemoteException{
		
	}
	public void altaCarrier(DTO_Carrier carrier) throws RemoteException{
		
	}
	public void modificarCarrier(DTO_Carrier carrier) throws RemoteException{
		
	}
	public void bajaProveedor(Integer idProveedor) throws RemoteException{
		
	}
	
	public DTO_Usuario login(String usuario, String password) throws RemoteException{
		return null;
	}
	
	public Integer gestionarEnvioEncomienda(int idEncomienda){
		
		return GestionEncomienda.getInstancia().asignarEnvio(idEncomienda, null);		
	}
	
	public DTO_EnvioPropio getInfoEnvioPropio(int idEnvio){
		
		DTO_EnvioPropio envio = new DTO_EnvioPropio();
		Envio env = GestionEncomienda.getInstancia().getInfoEnvio(idEnvio);
		
		envio.setEstado(env.getEstado());
		envio.setId(env.getIdEnvio());
		envio.setPosicionActual(new DTO_Coordenada(env.getPosicionActual().getIdCoordenada(),env.getPosicionActual().getLongitud(), env.getPosicionActual().getLatitud()));
		envio.setFechaYHoraLlegada(env.getFechaYHoraLlegadaEstimada());
		envio.setFechaYHoraSalida(env.getFechaYHoraSalida());
		envio.setIdDestino(env.getSucursalDestino().getIdSucursal());
		envio.setIdHojaDeRuta(env.getMapaDeRuta().getIdMapaDeRuta());
		envio.setIdVehiculo(env.getVehiculo().getIdVehiculo());
		
		return envio;
	}

	public void modificarCoordenadas(int idEnvio, DTO_Coordenada coordenadas) {
		
		Coordenada coor = CoordenadaDao.getInstancia().getById(coordenadas.getId());
		GestionControlViajes.getInstancia().actualizarEstadoVehiculo(idEnvio, coor);
		
	}

	public void marcarEnvioDemorado(int idEnvio) {

		GestionControlViajes.getInstancia().estaEnvioDemorado(idEnvio);
		
	}

	@Override
	public void nuevaEncomiedaParticular(String arg0, DTO_Direccion arg1,
			DTO_Direccion arg2, DTO_Sucursal arg3, DTO_Sucursal arg4,
			double arg5, double arg6, double arg7, double arg8, double arg9,
			String arg10, boolean arg11, short arg12, boolean arg13,
			String arg14, String arg15, String arg16, String arg17,
			String arg18, String arg19, Double arg20, String arg21, String arg22)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
