<%@page import="com.ADG04.web.controller.WebBusinessDelegate"%>
<%@page import="com.ADG04.bean.Encomienda.DTO_ItemManifiesto"%>
<%@page import="com.ADG04.bean.Encomienda.DTO_ItemRemito"%>
<%@page import="com.ADG04.bean.Cliente.DTO_ItemFactura"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>

<!-- Declaraciones -->
<%
    String encomienda;
    String destinos;
    String estado;
	
	encomienda = "0";
	destinos = "";
	encomienda = (String)request.getAttribute("idEncomienda");
//	sucursalNombre = (String)request.getAttribute("sucursalNombre");
	estado = (String)request.getAttribute("estado");
%>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	
	//divAsignarEnvio
    $('#btnAsignarEnvio').on("click",function(){
    
         $.get('servletAsignarEnvio?action=asignarEnvio&idEncomienda='+$("#nroEncomienda").val(), {
        		//idEncomienda : $("#nroEncomienda").val() 
        	}, 
        	function(responseText) {
        		
    			$("#idEnvioAsignado").val(responseText);
    			$("#divAsignarEnvio").css("display", "block");
    			$("#btnAsignarEnvio").css("display", "none");
        	})
    });

	
  	  var encomienda = <%= '"' + encomienda + '"'%>
  	  var estado = <%= '"' + estado + '"'%>

	  $("#diasEntrega").datepicker();
	  $("#fechaRecepcion").datepicker();
	  $("#fechaMaxima" ).datepicker();
	  $("#fechaRetiro" ).datepicker();
	  $("#fechaEstimada" ).datepicker();
	  $("#fechaRetiropartic" ).datepicker();
	   
}); //document ready


function showFactura(){
	$("#btnVerFactura").css("display", "none");
	$("#divFactura").css("display", "block");
}

function hideFactura(){
	$("#btnVerFactura").css("display", "block");
	$("#divFactura").css("display", "none");
}

function showManifiesto(){
	$("#btnVerManifiesto").css("display", "none");
	$("#divManifiesto").css("display", "block");
}

function hideManifiesto(){
	$("#btnVerManifiesto").css("display", "block");
	$("#divManifiesto").css("display", "none");
}



function hideRemito(){
	$("#btnVerRemito").css("display", "block");
	$("#divRemito").css("display", "none");
}

function showRemito(){
	$("#btnVerRemito").css("display", "none");
	$("#divRemito").css("display", "block");
}


</script>
<!-- Timepicker -->
<script>

$(document).ready(function() {

});

	$(function() {
    	$('#horaMinima').timepicker();
		$('#horaMaxima').timepicker();
	 	$("#horaMinimaPartic" ).datepicker();
	 	$("#horaMaximaPartic" ).datepicker();
	});
</script>
 
<!-- Cuerpo -->
<body>
<div class="container" style="background-color: #E6E6E6;">
<div class="content" style="height:1300px">

<h2>Encomienda Particular:</h2>

	<li><label>Nro de encomienda: </label><input class="input-field" name="nroEncomienda" type="text" id="nroEncomienda" readonly="readonly" value='<%=request.getAttribute("nroEncomienda")%>' /></li><br/>

  <label>Datos del Cliente</label>
	<!--Sólo se ve si es Particular --> 
    
    <ul>
	<li><label>Dni: </label><input class="input-field" name="dniParticular" type="text" id="dniParticular" readonly="readonly" value='<%=request.getAttribute("dniCliente")%>' /></li><br/>
	
    <li><label>Código Sucursal de origen: </label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value='<%=request.getAttribute("idSucursalOrigen")%>'/></li><br/>
    <li><label>Código Sucursal actual: </label><input name="idSucursalActual" type="text" readonly="readonly" class="input-field" id="idSucursalActual" value='<%=request.getAttribute("idSucursalActual")%>'/></li><br/>
	<li><label>Código Sucursal de destino: </label><input name="idSucursalDestino" type="text" readonly="readonly" class="input-field" id="idSucursalDestino" value='<%=request.getAttribute("idSucursalDestino")%>' /></li><br/>

	<li><label>Estado: </label><input name="estadoEncomienda" type="text" readonly="readonly" class="input-field" id="estadoEncomienda" value='<%=request.getAttribute("estadoEncomienda")%>' /></li><br/>

 	<br/>
 	
	<li><label>Fecha de recepci&oacute;n: </label><input type="text" id="fechaRecepcion" class="input-field" readonly="readonly" value='<%=request.getAttribute("fechaCreacion")%>' ></li><br/>
 	<li><label>Ancho (cm): </label><input class="input-field" name="largo" type="text" id="largo" size="18" readonly="readonly" value='<%=request.getAttribute("largo")%>' /></li><br/>
    <li><label>Alto (cm): </label><input class="input-field" name="alto" type="text" id="alto" size="18" readonly="readonly" value='<%=request.getAttribute("alto")%>' /></li><br/>
    <li><label>Profundidad (cm): </label><input class="input-field" name="ancho" type="text" id="ancho" size="18" readonly="readonly" value='<%=request.getAttribute("ancho")%>' /></li><br/>
 	<li><label>Peso (kg): </label><input class="input-field" name="peso" type="text" id="peso" size="18" readonly="readonly" value='<%=request.getAttribute("peso")%>' /></li><br/>
    <li><label>Tratamiento: </label><input class="input-field" name="tratamiento" type="text" id="tratamiento" value="" maxlength="50" readonly="readonly" value='<%=request.getAttribute("tratamiento")%>' /></li><br/>
 	<li><label>Apilable:</label> <input class="input-field" name="apilable" type="text" id="apilable" value="" maxlength="50" readonly="readonly" value='<%=request.getAttribute("apilable")%>' /></li><br/>
    <br/><li><label>Cantidad Apilable: </label><input class="input-field" name="cantApilable" type="text" id="cantApilable" size="10" readonly="readonly" value='<%=request.getAttribute("cantApilable")%>' /></li>
 	<br/><li><label>Refrigerado: </label><input class="input-field" name="refrigerado" type="text" id="cantApilable" size="10" readonly="readonly" value='<%=request.getAttribute("refrigerado")%>' />
	<br/><li><label>Condición de transporte </label><input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" readonly="readonly" value='<%=request.getAttribute("condicionTransporte")%>'  /></li>
<br/>	<li><label>Indicaciones de manipulaci&oacute;n: </label><input class="input-field" name="" type="text" id="indicacionesManipulacion" maxlength="400" readonly="readonly" value='<%=request.getAttribute("indicacionesManipulacion")%>' /></li>      
	<br/><li><label>Fragilidad: </label><input class="input-field" name="" type="text" id="fragilidad" maxlength="20" readonly="readonly" value='<%=request.getAttribute("fragilidad")%>' /></li>
	<br/><li><label>Tercerizado: </label><input class="input-field" name="" type="text" id="tercerizado" maxlength="20" readonly="readonly" value='<%=request.getAttribute("tercerizado")%>' /></li>    
</ul>
<br/><br/>
<label>Datos del Receptor</label>
<!--Sólo se ve si es Particular --> 
    <fieldset><ul>
		<li><label>DNI: </label><input class="input-field" name="dniReceptor" type="text" id="dniReceptor" maxlength="10" readonly="readonly" value='<%=request.getAttribute("dniReceptor")%>' /></li>
		<li><label>Nombre: </label><input class="input-field" name="nombreReceptor" type="text" id="nombreReceptor" maxlength="50" readonly="readonly" value='<%=request.getAttribute("nombreReceptor")%>' /></li>
		<li><label>Apellido: </label><input class="input-field" name="apellidoReceptor" type="text" id="apellidoReceptor" maxlength="50" readonly="readonly" value='<%=request.getAttribute("apellidoReceptor")%>' /></li>
    </ul></fieldset>
    
    <table>
	<% 
		List<String> listaEnvios = (List<String>)request.getAttribute("listaEnvios");
		for (int i = 0; i < listaEnvios.size(); i++) { %> 
			<tr> <td> <%= listaEnvios.get(i) %> </td> </tr>
		<%}
        
   	%>
   	</table>
	
  <br />

  <br /> 
  <% 
  String es = (String)request.getAttribute("estado");
  boolean show=false;
  if("ingresada".equals(estado.toLowerCase()) || "enesperaasignacion".equals(estado.toLowerCase())){
	  show = true;
  }
  if(!show){ %>	 <br /><input type="button" value="asignarEnvio" id="btnAsignarEnvio" /><%}  %> />

   
    <div style="display: none;" id="divAsignarEnvio"> 
    <input class="input-field" name="idEnvioAsignado" type="text" id="idEnvioAsignado" readonly="readonly" style="width: 300px;"/> 
    </div>
   
	<br /><br />
	<input id="btnVerFactura" type="button" onclick="showFactura();" value="Ver Factura ">
	
	<div id="divFactura" style="display: none;">
	<input id="btnHideFactura" type="button" onclick="hideFactura();" value="Ocultar Factura "> <br />
	<u> <label>Factura:</label> </u>
	<label>Vencida:<%= request.getAttribute("facturaVencida")%></label>
	<label>Pagada:<%= request.getAttribute("pagado")%></label>
	<table style="border-color: black !important; border-style: solid !important; border-width: thin !important;">
		<thead>
			<tr style="border-color: black !important; border-style: solid !important; border-width: thin !important;"> 
	            <td style="width: 100px;">Descripcion</td>
	            <td style="width: 10px;">Cantidad</td>
	            <td style="width: 10x;">Precio</td>
			</tr>
			<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10x;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DTO_ItemFactura> rows = (List<DTO_ItemFactura>)request.getAttribute("itemsFactura");
				for (int i = 0; i < rows.size(); i++) { 
					DTO_ItemFactura rowObj = rows.get(i);
	        %>
	        <tr>
	
	            <% 
	               String cantidad = ((Integer)rowObj.getCantidad()).toString(); 
	               String desc = rowObj.getDescripcion();
	               String valor = ((Float)rowObj.getValor()).toString();
	            %>
	            <td style="width: 150px;"><%=desc%></td>
	            <td style="width: 10px;"><%=cantidad%></td>
	            <td style="width: 10x;"><%=valor%></td>
	        </tr>
	        <% } %>
	    </tbody>
	    <tfoot>
	    	<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10x;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
	    	<tr style="padding-top:10px;">
	    		<td style="width: 150px;">Total:</td>
	            <td style="width: 10px;"></td>
	            <td style="width: 10x;"><%=request.getAttribute("totalFactura")%></td>
	    	</tr>
	    </tfoot>    
	</table>
</div> <!-- divFactura -->

	<br /><br />
	<input id="btnVerManifiesto" type="button" onclick="showManifiesto();" value="Ver Manifiesto ">
	<div id="divManifiesto" style="display: none;">
	<input id="btnHideManifiesto" type="button" onclick="hideManifiesto();" value="Ocultar Manifiesto "> <br />
	<u> <label>Manifiesto:</label> </u>
	<table style="border-color: black !important; border-style: solid !important; border-width: thin !important;">
		<thead>
			<tr style="border-color: black !important; border-style: solid !important; border-width: thin !important;"> 
	            <td style="width: 300px;">Descripcion</td>
	            <td style="width: 10px;">Cantidad</td>
			</tr>
			<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DTO_ItemManifiesto> ims = (List<DTO_ItemManifiesto>)request.getAttribute("itemsManifiesto");
				for (int i = 0; i < ims.size(); i++) { 
					DTO_ItemManifiesto item = ims.get(i);
	        %>
	        <tr>
	
	            <% 
	               String cantidad = ((Integer)item.getCantidad()).toString(); 
	               String desc = item.getDescripcion();
	            %>
	            <td style="width: 300px;"><%=desc%></td>
	            <td style="width: 10px;"><%=cantidad%></td>
	        </tr>
	        <% } %>
	    </tbody>
	</table>
	
	</div> <!-- divManifiesto -->
	<br /><br /><%
	if(request.getAttribute("itemsRemito")!=null){
	%>
	<input id="btnVerRemito" type="button" onclick="showRemito();" value="Ver Remito ">
	<div id="divRemito" style="display: none;">
	<input id="btnHideRemito" type="button" onclick="hideRemito();" value="Ocultar Remito "> <br />
	<u> <label>Manifiesto:</label> </u>
	<table style="border-color: black !important; border-style: solid !important; border-width: thin !important;">
		<thead>
			<tr style="border-color: black !important; border-style: solid !important; border-width: thin !important;"> 
	            <td style="width: 300px;">Descripcion</td>
	            <td style="width: 10px;">Cantidad</td>
			</tr>
			<tr> 
	            <td style="width: 100px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	            <td style="width: 10px;">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</thead>
		<tbody>
			<% 
				List<DTO_ItemRemito> irs = (List<DTO_ItemRemito>)request.getAttribute("itemsRemito");
				for (int i = 0; i < irs.size(); i++) { 
					DTO_ItemRemito item = irs.get(i);
	        %>
	        <tr>
	
	            <% 
	               String cantidad = ((Integer)item.getCantidad()).toString(); 
	               String desc = item.getDescripcion();
	            %>
	            <td style="width: 300px;"><%=desc%></td>
	            <td style="width: 10px;"><%=cantidad%></td>
	        </tr>
	        <% } %>
	    </tbody>
	</table>
	
	</div> <!-- divRemito --><%
	}%>
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
