package com.ADG04.web.servlets;

import java.io.IOException;
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
import com.ADG04.bean.Cliente.DTO_ClienteParticular;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/serveletEncomiendaParticular" })
public class ServletEncomiendaParticular extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendaParticular() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String jspPage = "mostrarMensaje.jsp";
		
		try { 	
				
			if ((action==null) || (action.length() < 1) )
			{
				action = "default";
			}
			else
			{
				if ("altaEncomiendaParticular".equals(action)) {

					Integer idSucursal;
					String sucursalNombre;
					Integer idEncomienda;
					//idEncomienda = 0;
					String destinos = "";
					String destinoOtp = "";
					String estado = "";
					
					HttpSession sesionIntento = request.getSession();
					if(sesionIntento.getAttribute("sucursal") != null){
						
						idSucursal = Integer.parseInt((String)sesionIntento.getAttribute("sucursal"));
						sucursalNombre = WebBusinessDelegate.getInstancia().getSucursal(idSucursal).getDescripcion();
				
						DTO_EncomiendaParticular e = new DTO_EncomiendaParticular();

						DTO_Manifiesto m = new DTO_Manifiesto();
						m.addItem(new DTO_ItemManifiesto((String)request.getParameter("manifiesto")));
						e.setManifiesto(m);				
												
						DTO_Sucursal sucOrigen= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
						DTO_Sucursal sucActual= new DTO_Sucursal(Integer.parseInt((String)request.getParameter("idSucursalOrigen")));
						
						int idSucDestino = 0;
						if(request.getParameter("idSucursalDestino")!=null && !request.getParameter("idSucursalDestino").toString().isEmpty()){
							idSucDestino=Integer.parseInt((String)request.getParameter("idSucursalDestino"));
						}
						else{
							idSucDestino=Integer.parseInt((String)request.getParameter("idSucursalOrigen"));
						}
							
						DTO_Sucursal sucDestino= new DTO_Sucursal(idSucDestino);

						//e.setId(Integer.parseInt((String)request.getParameter("idEncomienda")));
						e.setSucursalOrigen(sucOrigen);
						e.setSucursalActual(sucOrigen);
						e.setSucursalDestino(sucDestino);
						//e.setDestino(Integer.parseInt((String)request.getParameter("idDestino")));
						e.setSucursalActual(sucActual);
						e.setFechaCreacion(new Date());
						//e.setFecha(new Date());
						e.setLargo((float)Float.parseFloat((String)request.getParameter("largo")));
						e.setAlto((float)Float.parseFloat((String)request.getParameter("alto")));
						e.setAncho((float)Float.parseFloat((String)request.getParameter("ancho")));
						e.setPeso((float)Float.parseFloat((String)request.getParameter("peso")));
						e.setVolumen((float)Float.parseFloat((String)request.getParameter("ancho"))/100 * (float)Float.parseFloat((String)request.getParameter("largo"))/100 * (float)Float.parseFloat((String)request.getParameter("alto"))/100);
						e.setTratamiento((String)request.getParameter("tratamiento"));
						if(request.getParameter("Apilable").equals("true")){
							e.setApilable(true);
							e.setCantApilable(Short.parseShort((String)request.getParameter("cantApilable")));
						}
						else{
							e.setApilable(false);
						}
						
						
						if(request.getParameter("Refrigerado").equals("true"))
							e.setRefrigerado(true);
						else
							e.setRefrigerado(false);

						e.setCondicionTransporte((String)request.getParameter("condicionTransporte"));
						e.setIndicacionesManipulacion((String)request.getParameter("indicacionesManipulacion"));
						e.setFragilidad((String)request.getParameter("fragilidad"));
												
						
						if(request.getParameter("internacional").equals("true")){
							
							e.setInternacional(true);
							
							//Si es internacional, es tercerizada.
							e.setTercerizada(true);
						}
						else{
							if(request.getParameter("tercerizado").equals("true"))
								e.setTercerizada(true);
							else
								e.setTercerizada(false);
							
							e.setInternacional(false);
						}
						
						DTO_ClienteParticular cliente = WebBusinessDelegate.getInstancia().getClienteParticularByDni((String)request.getParameter("dniParticular"));
			
						//cliente.setNombre((String)request.getParameter("nombreParticular"));
						//cliente.setApellido((String)request.getParameter("apellidoParticular"));
						//cliente.setDni((String)request.getParameter("dniParticular"));
							
						e.setCliente(cliente);
						
						e.setDniReceptor((String)request.getParameter("dniReceptor"));
						e.setNombreReceptor((String)request.getParameter("nombreReceptor"));
						e.setApellidoReceptor((String)request.getParameter("apellidoReceptor"));
						
						Integer idencomienda = WebBusinessDelegate.getInstancia().nuevaEncomiedaParticular(e);

						jspPage = "mostrarMensaje.jsp";
						request.setAttribute("mensaje", "La encomienda se ha generado correctamente y se le asign� con el numero: " + Integer.toString(idencomienda));	
		
					}
					else
					{
						jspPage = "mostrarMensaje.jsp";
						request.setAttribute("mensaje", "Ha ocurrido un error");	
					}
				}
			}
	
		
		}
		catch(BusinessException cEx){
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
	
	
	protected void dispatch(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(jsp != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			rd.forward(request, response);
		}
	}
	
}
