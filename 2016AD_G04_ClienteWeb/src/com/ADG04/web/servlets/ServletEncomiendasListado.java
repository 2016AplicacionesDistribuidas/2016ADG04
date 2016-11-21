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
import com.ADG04.bean.Encomienda.DTO_Encomienda;
import com.ADG04.bean.Encomienda.DTO_EncomiendaEmpresa;
import com.ADG04.bean.Encomienda.DTO_EncomiendaParticular;
import com.ADG04.bean.Encomienda.DTO_ItemManifiesto;
import com.ADG04.bean.Encomienda.DTO_Manifiesto;
import com.ADG04.web.controller.WebBusinessDelegate;

//import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(asyncSupported = true, urlPatterns = { "/servletEncomiendasListado" })
public class ServletEncomiendasListado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendasListado() {
        super();
    }
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		listarEncomiendasParticulares(request, response);
	}


	private void listarEncomiendasParticulares(HttpServletRequest request,
			HttpServletResponse response) {
		try{
			List<EncomiendaWeb> encomiendas = new ArrayList<EncomiendaWeb>();
				 
			int totalNumberOfPages = 1;
			int currentPageNumber = 1;
				 
			List<DTO_EncomiendaParticular> encomiendasP = WebBusinessDelegate.getInstancia().listarEncomiendasParticulares();
			int totalNumberOfRecords = encomiendasP.size(); 
			JqGridData<EncomiendaWeb> gridData = new JqGridData<EncomiendaWeb>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, encomiendas);		
			
			boolean noasignados=false;
			
			if(request.getParameter("noasignados")!=null){
				System.out.println(request.getParameter("noasignados"));
				if("1".equals(request.getParameter("noasignados").toString())){
					noasignados=true;
					System.out.println("DALE");
				}
			}
			
			
			for(DTO_EncomiendaParticular encP:encomiendasP){
				
				boolean envioAsignado = WebBusinessDelegate.getInstancia().estaEncomiendaAsignada(encP.getIdEncomienda());
				EncomiendaWeb enc = null;
				if(noasignados==true){
					if(envioAsignado==false){
						enc = new EncomiendaWeb(encP.getIdEncomienda(), encP.getCliente().getId(),encP.getEstado(), envioAsignado);
						enc.setTipo("P");
						gridData.addItem(enc);
					}
				}
				else{
					enc = new EncomiendaWeb(encP.getIdEncomienda(), encP.getCliente().getId(),encP.getEstado(), envioAsignado);
					enc.setTipo("P");
					gridData.addItem(enc);
				}
				
				
			}
			
			System.out.println("Grid Data: " + gridData.getJsonString());
			response.getWriter().write(gridData.getJsonString());
		}
		catch(BusinessException cEx){
			//jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", cEx.getMessage());	
		}
		catch (Exception e) {
			e.printStackTrace();
			//jspPage = "mostrarMensaje.jsp";
			request.setAttribute("mensaje", "Ha ocurrido un error");
		}
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
