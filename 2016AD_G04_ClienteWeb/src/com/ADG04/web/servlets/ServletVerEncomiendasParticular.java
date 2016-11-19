package com.ADG04.web.servlets;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ADG04.Repositorio.Exceptions.BusinessException;
import com.ADG04.Repositorio.Exceptions.ClientNotFoundException;
import com.ADG04.bean.Administracion.DTO_Sucursal;
import com.ADG04.bean.Cliente.DTO_ClienteEmpresa;
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Cliente.DTO_Factura;
import com.ADG04.bean.Cliente.DTO_ItemFactura;
import com.ADG04.bean.Cliente.DTO_Producto;
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_Envio;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;

import com.ADG04.bean.Encomienda.DTO_Remito;

import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;

import com.ADG04.bean.Encomienda.DTO_ProductoEncomienda;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/ServletVerEncomiendasParticular" })
public class ServletVerEncomiendasParticular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletVerEncomiendasParticular() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action").toString();
		String jspPage = "main.jsp";
		
		if ((action==null) || (action.length() < 1) )
		{
			action = "getEncomienda";
		}
		
		
		try {
			if(action.equals("getEncomienda")) {
				getEncomienda(request);
				jspPage = "verEncomiendaParticular.jsp";
			}
			else if(action.equals("getEncomiendaEmpresa")) {
				getEncomiendaEmpresa(request);
				jspPage = "verEncomiendaEmpresa.jsp";
			}
		}
		catch(BusinessException cEx){
			cEx.printStackTrace();
			jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", cEx.getMessage());	
		}
		catch (Exception e) {
			e.printStackTrace();
			jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", "Ha ocurrido un error");
		}
		finally{
			dispatch(jspPage, request, response);
		}
	}


	private void getEncomiendaEmpresa(HttpServletRequest request) throws RemoteException, Exception {

		int idEncomienda = Integer.parseInt(request.getParameter("idEncomienda"));
		DTO_EncomiendaEmpresa e = WebBusinessDelegate.getInstancia().getEncomiendaEmpresa(idEncomienda);
		
		request.setAttribute("nroEncomienda", idEncomienda );
		request.setAttribute("estadoEncomienda", e.getEstado());
		List<String> envios = new ArrayList<String>();
		for(DTO_Envio envio:e.getEnvios()){
			System.out.println(envio.getId());
			DTO_Envio env = WebBusinessDelegate.getInstancia().getEnvio(envio.getId());
			String envMsg = "Envio nro: (Entre Sucursales "+env.getIdSucursalOrigen().toString()  +" y "+env.getIdSucursalDestino().toString() +") " + env.getId() + " - Estado: "+env.getEstado()+" <a href='ServletVerEnvio?idEnvio'"+envio.getId()+">Ver estado</a>";
			envios.add(envMsg);
		}
		request.setAttribute("listaEnvios", envios);
		DTO_ClienteEmpresa cli = WebBusinessDelegate.getInstancia().getClienteEmpresaById(e.getCliente().getId());
		
		request.setAttribute("dniCliente", cli.getCuit() );
		request.setAttribute("idSucursalOrigen",e.getSucursalOrigen().getId().toString());
		request.setAttribute("idSucursalDestino",e.getSucursalDestino().getId().toString());
		request.setAttribute("idSucursalActual", "");
		if(e.getSucursalActual() != null)
			request.setAttribute("idSucursalActual", e.getSucursalActual().getId().toString());
		request.setAttribute("fechaCreacion",e.getFechaEstimadaEntrega().toString());
		request.setAttribute("largo",((Float)e.getLargo()).toString());
		request.setAttribute("alto",((Float)e.getAlto()).toString());
		request.setAttribute("ancho",((Float)e.getAncho()).toString());
		request.setAttribute("peso",((Float)e.getPeso()).toString());
		request.setAttribute("tratamiento",e.getTratamiento());
		
		if(e.getApilable()) 
			request.setAttribute("apilable","Si");
		else
			request.setAttribute("apilable","No");
		
		if(e.getCantApilable() != null)
			request.setAttribute("cantApilable",((Short)e.getCantApilable()).toString());
		else
			request.setAttribute("cantApilable",0);
		
		
		if(e.getApilable()) 
			request.setAttribute("refrigerado","Si");
		else
			request.setAttribute("refrigerado","No");
		
		request.setAttribute("condicionTransporte",e.getCondicionTransporte());
		request.setAttribute("indicacionesManipulacion",e.getIndicacionesManipulacion());      
		request.setAttribute("fragilidad",e.getFragilidad());

		if(e.getApilable()) 
			request.setAttribute("tercerizado","Si");
		else
			request.setAttribute("tercerizado","No");
		    
		request.setAttribute("dniReceptor",e.getDniReceptor());
		request.setAttribute("nombreReceptor",e.getNombreReceptor());
		request.setAttribute("apellidoReceptor",e.getApellidoReceptor());
/*
		if(envioAsignado){
			request.setAttribute("tieneEnvio", true);
			request.setAttribute("envioAsignado","Si");
			request.setAttribute("idEnvio",e.getEnvio().getId());
		}
		else{
			request.setAttribute("tieneEnvio", false);
			request.setAttribute("envioAsignado","No");
			request.setAttribute("idEnvio",0);
		}*/
		
		//Manifiesto
		 e.getManifiesto().getId();
		DTO_Manifiesto manifiesto = e.getManifiesto();
		if(manifiesto != null){
			request.setAttribute("itemsManifiesto", manifiesto.getDetalle());
		}
		
		//Ver factura
		DTO_Factura factura = WebBusinessDelegate.getInstancia().getFacturaById(e.getFactura().getId());
		if(factura != null){
			request.setAttribute("idFactura",factura.getId().toString());
			if(factura.estaVencida())
				request.setAttribute("facturaVencida","Si");
			else
				request.setAttribute("facturaVencida","No");
			
			if(factura.isPagado())
				request.setAttribute("pagado","Si");
			else
				request.setAttribute("pagado","No");
			
			
			request.setAttribute("facturaVencida",factura.getFecha().toString());
			request.setAttribute("fechaVencimiento",factura.getFechaVencimiento().toString());
			
			Float total = getTotal(factura.getItems());
			request.setAttribute("facturaVencida",total.toString());
			
			if(factura.getItems() != null){
				request.setAttribute("itemsFactura",factura.getItems());
			}
			else{
				request.setAttribute("itemsFactura",new ArrayList<DTO_ItemFactura>());
			}
			
			request.setAttribute("totalFactura", total.toString());

			List<DTO_ProductoEncomienda> ps = new ArrayList<DTO_ProductoEncomienda>();
			System.out.println("eeeeeeeeeeeeee");
			if(e.getProductos() != null){
				
				for(DTO_ProductoEncomienda pe:e.getProductos()){
					System.out.println(pe.getIdProductoCliente());
					DTO_Producto p = WebBusinessDelegate.getInstancia().getProducto(pe.getIdProductoCliente());
					DTO_ProductoEncomienda pe2 = pe;
					pe2.setDescProducto(p.getDescripcion());
					ps.add(pe2);
				}
				request.setAttribute("productos", ps);
			}
		}

		
	}


	private void getEncomienda(HttpServletRequest request)
			throws RemoteException, Exception {
		
		List<EncomiendaParticularWeb> encomiendas = new ArrayList<EncomiendaParticularWeb>();
		//TODO: tomar de par�metro
		int idEncomienda = Integer.parseInt(request.getParameter("idEncomienda"));
		DTO_EncomiendaParticular e = WebBusinessDelegate.getInstancia().getEncomiendaParticular(idEncomienda);
		
		request.setAttribute("nroEncomienda", idEncomienda );
		request.setAttribute("estadoEncomienda", e.getEstado());
		List<String> envios = new ArrayList<String>();
		for(DTO_Envio envio:e.getEnvios()){
			System.out.println(envio.getId());
			DTO_Envio env = WebBusinessDelegate.getInstancia().getEnvio(envio.getId());
			String envMsg = "Envio nro: (Entre Sucursales "+env.getIdSucursalOrigen().toString()  +" y "+env.getIdSucursalDestino().toString() +") " + env.getId() + " - Estado: "+env.getEstado()+" <a href='ServletVerEnvio?idEnvio="+envio.getId()+"'>Ver estado</a>";
			envios.add(envMsg);
		}
		request.setAttribute("listaEnvios", envios);
		DTO_ClienteParticular cli = WebBusinessDelegate.getInstancia().getClienteParticularById(e.getCliente().getId());
		
		request.setAttribute("dniCliente", cli.getDni() );
		request.setAttribute("idSucursalOrigen",e.getSucursalOrigen().getId().toString());
		request.setAttribute("idSucursalDestino",e.getSucursalDestino().getId().toString());
		request.setAttribute("idSucursalActual", "");
		if(e.getSucursalActual() != null)
			request.setAttribute("idSucursalActual", e.getSucursalActual().getId().toString());
		request.setAttribute("fechaCreacion",e.getFechaEstimadaEntrega().toString());
		request.setAttribute("largo",((Float)e.getLargo()).toString());
		request.setAttribute("alto",((Float)e.getAlto()).toString());
		request.setAttribute("ancho",((Float)e.getAncho()).toString());
		request.setAttribute("peso",((Float)e.getPeso()).toString());
		request.setAttribute("tratamiento",e.getTratamiento());
		request.setAttribute("estado", (String) e.getEstado());
		
		if(e.getApilable()) 
			request.setAttribute("apilable","Si");
		else
			request.setAttribute("apilable","No");
		
		if(e.getCantApilable() != null)
			request.setAttribute("cantApilable",((Short)e.getCantApilable()).toString());
		else
			request.setAttribute("cantApilable",0);
		
		
		if(e.getApilable()) 
			request.setAttribute("refrigerado","Si");
		else
			request.setAttribute("refrigerado","No");
		
		request.setAttribute("condicionTransporte",e.getCondicionTransporte());
		request.setAttribute("indicacionesManipulacion",e.getIndicacionesManipulacion());      
		request.setAttribute("fragilidad",e.getFragilidad());

		if(e.getApilable()) 
			request.setAttribute("tercerizado","Si");
		else
			request.setAttribute("tercerizado","No");
		    
		request.setAttribute("dniReceptor",e.getDniReceptor());
		request.setAttribute("nombreReceptor",e.getNombreReceptor());
		request.setAttribute("apellidoReceptor",e.getApellidoReceptor());
/*
		if(envioAsignado){
			request.setAttribute("tieneEnvio", true);
			request.setAttribute("envioAsignado","Si");
			request.setAttribute("idEnvio",e.getEnvio().getId());
		}
		else{
			request.setAttribute("tieneEnvio", false);
			request.setAttribute("envioAsignado","No");
			request.setAttribute("idEnvio",0);
		}*/
		
		//Manifiesto
		 e.getManifiesto().getId();
		DTO_Manifiesto manifiesto = e.getManifiesto();
		if(manifiesto != null){
			request.setAttribute("itemsManifiesto", manifiesto.getDetalle());
		}
		
		//Remito
		if(e.getRemito()!=null){
			e.getRemito().getId();
			DTO_Remito remito = e.getRemito();
			if(remito != null){
				request.setAttribute("itemsRemito", remito.getDetalle());
			}
		}
		
		//Ver factura
		DTO_Factura factura = WebBusinessDelegate.getInstancia().getFacturaById(e.getFactura().getId());
		if(factura != null){
			request.setAttribute("idFactura",factura.getId().toString());
			if(factura.estaVencida())
				request.setAttribute("facturaVencida","Si");
			else
				request.setAttribute("facturaVencida","No");
			
			if(factura.isPagado())
				request.setAttribute("pagado","Si");
			else
				request.setAttribute("pagado","No");
			
			
			request.setAttribute("facturaVencida",factura.getFecha().toString());
			request.setAttribute("fechaVencimiento",factura.getFechaVencimiento().toString());
			
			Float total = getTotal(factura.getItems());
			request.setAttribute("facturaVencida",total.toString());
			
			if(factura.getItems() != null){
				request.setAttribute("itemsFactura",factura.getItems());
			}
			else{
				request.setAttribute("itemsFactura",new ArrayList<DTO_ItemFactura>());
			}
			
			request.setAttribute("totalFactura", total.toString());
		}
	}


	private Float getTotal(List<DTO_ItemFactura> items) {
		
		Float total = 0f;
		if(items != null){
			for(DTO_ItemFactura item:items){
				total += item.getValor()* ((Integer)item.getCantidad()).floatValue();
			}
		}
		
		return total;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(jsp != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
}
