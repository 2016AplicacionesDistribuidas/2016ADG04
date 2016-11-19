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


@WebServlet(asyncSupported = true, urlPatterns = { "/servletEncomiendasListadoEmpresa" })
public class ServletEncomiendasListadoEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletEncomiendasListadoEmpresa() {
        super();
    }
 

	private void listarEncomiendasEmpresa(HttpServletRequest request, HttpServletResponse response) {
		
		try{
			List<EncomiendaEmpresaWeb> encomiendas = new ArrayList<EncomiendaEmpresaWeb>();
				 
			int totalNumberOfPages = 1;
			int currentPageNumber = 1;
				 
			List<DTO_EncomiendaEmpresa> encomiendasP = WebBusinessDelegate.getInstancia().listarEncomiendasEmpresa();
			int totalNumberOfRecords = encomiendasP.size(); 
			JqGridData<EncomiendaEmpresaWeb> gridData = new JqGridData<EncomiendaEmpresaWeb>(totalNumberOfPages, currentPageNumber, totalNumberOfRecords, encomiendas);		
			
			for(DTO_EncomiendaEmpresa encP:encomiendasP){

				boolean envioAsignado = WebBusinessDelegate.getInstancia().estaEncomiendaAsignada(encP.getIdEncomienda());
				gridData.addItem(new EncomiendaEmpresaWeb(encP.getIdEncomienda(), encP.getCliente().getId(),encP.getEstado(), envioAsignado));
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



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarEncomiendasEmpresa(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listarEncomiendasEmpresa(request, response);
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
