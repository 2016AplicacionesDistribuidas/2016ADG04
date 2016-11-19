package com.ADG04.Repositorio.Interfaces;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.bean.Administracion.DTO_Direccion;
import com.ADG04.bean.Administracion.DTO_Sucursal;
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
import com.ADG04.bean.Encomienda.DTO_Remito;

public interface IEncomiendaRemote {

	public void actualizarEstadoEnvio(Integer idEnvio, String estado) throws RemoteException;
	
	public Integer asignarEnvio(Integer idEncomienda)throws RemoteException, BusinessException;
	
	public void modificarCoordenadas(int idEnvio, DTO_Coordenada coordenadas) throws RemoteException;
	
	public Integer gestionarEnvioEncomienda(int idEncomienda) throws RemoteException, BusinessException;

	public Integer nuevaEncomiedaEmpresa(DTO_EncomiendaEmpresa encomiendaEmpresa)  throws RemoteException, BusinessException;
	
	public Integer nuevaEncomiedaParticular(DTO_EncomiendaParticular encomiendaParticular) throws RemoteException, BusinessException;
	
	public void setFechaEstimadaEntrega(int idEncomienda, Date fechaEstimadaDeEntrega) throws RemoteException;
	
	public void agregarRemito(int idEncomienda, DTO_Remito remito) throws RemoteException;
	
	public void agregarProducto(DTO_Producto producto, int idEncomienda) throws RemoteException;
	public void eliminarProducto(int idProducto, int idEncomienda) throws RemoteException;

	public 	DTO_EnvioPropio getInfoEnvioPropio(int idEnvio)  throws RemoteException;

	public DTO_EncomiendaParticular getEncomiendaParticular(Integer id)throws RemoteException;
	public DTO_EncomiendaEmpresa getEncomiendaEmpresa(Integer idEncomienda)throws RemoteException;
	public List<DTO_EncomiendaParticular> listarEncomiendasParticulares()throws RemoteException;
	public List<DTO_EncomiendaEmpresa> listarEncomiendasEmpresas()throws RemoteException;
	public List<DTO_Encomienda> listarEncomiendasBySucursal(int idSucursal) throws RemoteException;
	public List<DTO_Encomienda> listarEncomiendasBySucursalPendientes(int idSucursal) throws RemoteException;
	public DTO_Coordenada getCoordenadasById(int id)throws RemoteException;
	public List<DTO_EnvioPropio> listarEnviosPropios()throws RemoteException;
	public List<DTO_EnvioTercerizado> listarEnviosTercerizados()throws RemoteException;
	public List<DTO_EnvioTercerizado> buscarEnviosByEstado(String filtro) throws RemoteException;
	public List<DTO_EnvioPropio> buscarEnviosPropiosByEstado(String filtro) throws RemoteException;
	public DTO_Manifiesto getManifiesto(Integer id) throws RemoteException;
	public DTO_Remito getRemito(Integer id)  throws RemoteException;
	public List<DTO_Manifiesto> listarManifiestos() throws RemoteException;
	public List<DTO_Remito> listarRemitos() throws RemoteException;
	public void actualizarEstadoEnvios(String dir)  throws RemoteException;
	public DTO_Envio getEnvio(Integer id) throws RemoteException;
	public List<DTO_EnvioHistorico> getHistorico(Integer id) throws RemoteException;
	public DTO_EnvioPropio getEnvioPropio(Integer id) throws RemoteException;
	public boolean estaEncomiendaAsignada(int idEncomienda) throws RemoteException;
	public List<DTO_Encomienda> listarEncomiendasByEnvio(int idEnvio) throws RemoteException;	

	/***
	 * Envios que tienen la sucursal de destino indicada, y no están en estado concluído.
	 ****/
	public List<DTO_Envio> listarEnviosPendientesBySucursalDestino(int idSucursalDestino) throws RemoteException;
}
