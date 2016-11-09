<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Ver Encomienda</title>
 
 <script src="jquery/jquery-2.1.1.js" type="text/javascript"></script>
 <script type="text/javascript" src="js/mainmenu.js"></script>
<script src="jquery/jquery-ui.js" type="text/javascript"></script>
 <script type="text/javascript" src="jquery/jquery.timepicker.js"></script>
 <!-- Hojas de estilo -->
 <link href="css/style.css" rel="stylesheet" type="text/css" />
 <link href="jquery/jquery-ui.css" rel="stylesheet" type="text/css" />
 <link href="css/jquery.timepicker.css" rel="stylesheet" type="text/css">
 <!-- Fonts -->
 <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
 <link href="css/font-awesome.css" rel="stylesheet" type="text/css" >
 
</head>
<!-- Fin Cabecera -->
<!-- Declaraciones -->
<%
	String usuario;
    String sucursal;
    String encomienda;
    String destinos;
    String estado;
    String sucursalNombre;
	
	usuario = "";
	sucursal = "0";
	encomienda = "0";
	destinos = "";
	sucursalNombre = "";
	
	HttpSession sesionIntento = request.getSession();
	if(sesionIntento.getAttribute("usuario") != null){
		usuario = (String)sesionIntento.getAttribute("usuario");
		sucursal = (String)sesionIntento.getAttribute("sucursal");
	}   
	//encomienda = (String)request.getAttribute("idEncomienda");

	//sucursalNombre = (String)request.getAttribute("sucursalNombre");

%>
<input id="iInt_Logueado" type="hidden" value =""/>
<input id="iStr_User"     type="hidden" value =""/>
<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">

$(document).ready(function() {	
	  
	  	  var usuario = <%= '"' + usuario + '"'%>
	  	  var sucursal = <%= '"' + sucursal + '"'%>
	  	  var sucursalNombre = <%= '"' + sucursalNombre + '"'%>
	  	  var encomienda = <%= '"' + encomienda + '"'%>
	  	  var estado = <%= '"' + estado + '"'%>
	
		  if(usuario == "")	
		  {	  
	  		$("#nombreUsuario").text("");
	 		$("#divLogin").load("login.jsp");
	 		$("#lCerrarSesion").text("");
	 		
		  }
		  else
		  {
	  		$("#nombreUsuario").text("Hola " + usuario);
	  		$("#lCerrarSesion").text("Cerrar Sesi�n");
	  		$("#cerrarSesion").load("logout.jsp");

	  		

	  		$("#menu_nuevo_cliente").on("click",function(){
	  			$("#divTodo").load("altaCliente.jsp");
	  		});
	  		
	  		$("#menu_new_encom_particular").on("click",function(){
	  			$("#divTodo").load("altaEncomiendaParticular.jsp");
	  		});
	  		
	   	  }

		  $("#diasEntrega").datepicker();
		  $("#fechaRecepcion").datepicker();
		  $("#fechaMaxima" ).datepicker();
		  $("#fechaRetiro" ).datepicker();
		  $("#fechaEstimada" ).datepicker();
		  $("#fechaRetiropartic" ).datepicker();

		
		  var idEncomienda = (String)request.getAttribute("idEncomienda");
		  
	/*	 	$('.cla_cliente').magnificPopup({
		 		type: 'inline',
		 		preloader: false,
		 		focus: '#name',

		 		// When elemened is focused, some mobile browsers in some cases zoom in
		 		// It looks not nice, so we disable it:
		 		callbacks: {
		 			beforeOpen: function() {
		 				if($(window).width() < 700) {
		 					this.st.focus = false;
		 				} else {
		 					this.st.focus = '#name';
		 				}
		 			}
		 		}
		 	});
*/
	   
}); //document ready



</script>
<!-- Timepicker -->
<script>
</script>
 
<!-- Cuerpo -->
<body>
<div class="container">
    <div class="content">
        <div id="wrap">
        	<header>
        		<div class="inner relative">
                      <ul style="width:227px;">
        				<li style="width:230px;"><a class="logo" href="main.jsp"><img src="images/logo_web_dgv_02.jpg" alt="Der grobe Verteiler" border="0"></a></li>
                     	<li class="logueado" style="width:227px; margin-top:10px;font-size:18px; line-height:25px; color:#f0af1e;">
                         <span id="nombreUsuario"> </span>               
                        </li>
                        <div id="cerrarSesion" style="width:227px;color:#fff; font-size:14px;" > </div>           	
         			    </ul>
                    <a id="menu-toggle" class="button dark" href="#"></a>
        			<nav id="navigation">
        				<ul id="main-menu">
        					<li class="current-menu-item"><a href="">HOME</a></li>
        					<li class="parent">
        						<a class="parent" href="#"> ENCOMIENDA</a>
        							<ul class="sub-menu">
        									<li><a id="menu_new_encom_particular">Nueva Encomienda Particular</a></li>
        									<li><a id="menu_new_encom_empresa">Nueva Encomienda Empresa</a></li>
        							</ul>
        					</li>
        					<li class="parent">
        						<a class="parent" href="#"> ENV&Iacute;OS</a>
        							<ul class="sub-menu">
        									<li><a href=" "> Recepci&oacute;n</a></li>
        									<li><a href=" ">Env&iacute;os propios</a></li>
        									<li><a href=" ">Env&iacute;os tercerizados</a></li>
        							</ul>
        					</li>
        					<li class="parent">
                            	<a href=" ">CLIENTES</a>
                                <ul class="sub-menu">
                                    <li><a id="menu_nuevo_cliente">Nuevo Clientes</a></li>
        							<li><a id="mClientes">Buscar Clientes</a></li>
        							<li><a href=" ">Cuentas corrientes</a></li>
                                </ul></li>   
        					<li class="parent">
        						<a href=" ">VIAJES</a>
        						<ul class="sub-menu">
        							<li><a href=" ">Control de viajes</a></li>
        							<li><a href=" ">Contrataci&oacute;n de viajes</a></li>
        						</ul>
        					</li>
                            <li class="parent" style="text-align:left;display: inline-block;">
        						<a href=" ">COBROS/PAGOS</a>
        						<ul class="sub-menu">
        							<li><a id="menu_pagar_fact_particular">Pagar Factura Particular</a></li>
                                	<li><a id="menu_pagar_fact_empresa">Pagar Factura Empresa</a></li>
                                </ul>
                            </li>
                            <li class="parent">
        						<a class="parent" href="#">VEH&Iacute;CULOS</a>
        							<ul class="sub-menu">
                                    	<li><a href=" ">Veh&iacute;culos propios</a></li>
        								<li><a href=" ">Mantenimiento</a></li>
        								<li><a href=" ">Veh&iacute;culos contratados</a></li>
                                    </ul>
                             </li>
                             <li class="parent">
        						<a class="parent" href="#">ADMINISTRACI&Oacute;N</a>
        							<ul class="sub-menu">
                                    	<li><a href=" "> Empleados</a></li>
        								<li><a href=" "> Veh&iacute;culos</a></li>
        								<li><a href=" "> Proveedores</a></li>
                                        <li><a href=" "> Precios transportes y carriers</a></li>
        								<li><a href=" "> Seguros</a></li>
                                        <li><a href=" "> Maps de rutas</a></li>
                                    </ul>
                             </li>
                             <li class="parent">
        						<a class="parent" href="#">SUCURSALES</a>
        							<ul class="sub-menu">
                                    	<li><a href=" "> Sucursales</a></li>
        								<li><a href=" "> Novedades de caminos</a></li>    
                                 </ul>    
                             </li>       
                        </ul>            
        		    </nav>
        			<div class="clear"></div>
          		</div>
        	</header>
        </div>	
     <div class="amarillo"></div>
  	<div class="page" style="background: #FFF; padding: 25px 50px;">
      <div id="divLogin">
<h2>Encomienda Particular:</h2>
<form action="serveletEncomiendaParticular?action=altaEncomiendaParticular" method="post" name="frm_idEncomienda" class="form-style-2">
<ul>


  <label>Datos del Cliente</label>
	<!--S�lo se ve si es Particular --> 
    <fieldset>
    <ul>
		<li><label>Dni:</label><input class="input-field" name="dniParticular" type="text" id="dniParticular" maxlength="10" /></li>
		<!-- <button id="btnBuscarCliente" onclick="findClient()">Buscar Cliente</button>
        				<div id="divBuscarCliente"></div> -->
		<!-- <li><label>Nombre del particular:</label><input class="input-field" name="nombreParticular" type="text" id="nombreParticular" maxlength="50" /></li>
		<li><label>Apellido del particular:</label><input class="input-field" name="apellidoParticular" type="text" id="apellidoParticular" maxlength="50" /></li>-->
    </ul></fieldset>
	

	<li><label>C�digo Sucursal de origen:</label><input name="idSucursalOrigen" type="text" readonly="readonly" class="input-field" id="idSucursalOrigen" value="<%=sucursal%>"/></li>
	<li><label>C�digo Sucursal de destino:</label><input name="idSucursalDestino" type="text" class="input-field" id="idSucursalDestino" /></li>
	
 	<br/>
 	
	<li><label>Fecha de recepci&oacute;n:</label><input type="date" id="fechaRecepcion" class="datepicker"></li>
 	<li><label>Fecha de m&aacute;xima:</label><input type="date" id="fechaMaxima" class="datepicker"></li>
 	<li>
 	  <label>Ancho (cm):</label><input class="input-field" name="largo" type="text" id="largo" size="18" /> 
      <label>Alto (cm):</label><input class="input-field" name="alto" type="text" id="alto" size="18" />
      <label>Profundidad (cm):</label><input class="input-field" name="ancho" type="text" id="ancho" size="18" /></li>
 	<li><label>Peso (kg):</label><input class="input-field" name="peso" type="text" id="peso" size="18" />
    	
        <label>Tratamiento:</label><input class="input-field" name="" type="text" id="tratamiento" value="" maxlength="50" />
 	</li>
 	<li><label>Apilable:</label>
     			<label class="input-radio-field"><input type="radio" name="Apilable" value="true" id="Apilable" />S�</label>
       			<label class="input-radio-field"><input type="radio" name="Apilable" value="false" id="Apilable" />No</label></li>
 	<li><label>Cantidad Apilable:</label><input class="input-field" name="cantApilable" type="text" id="cantApilable" size="10" /></li>
 	<li><label>Refrigerado:</label>
    			<label class="input-radio-field"><input type="radio" name="Refrigerado" value="true" id="Refrigerado" />S�</label>
           		<label class="input-radio-field"><input type="radio" name="Refrigerado" value="false" id="Refrigerado" />No</label></li>
	<li><label>Condici�n de transporte</label><input class="input-field" name="condicionTransporte" type="text" id="condicionTransporte" maxlength="50" /></li>
	<li><label>Indicaciones de manipulaci&oacute;n:</label><input class="input-field" name="" type="text" id="indicacionesManipulacion" maxlength="400" /></li>      
	<li><label>Fragilidad:</label><input class="input-field" name="" type="text" id="fragilidad" maxlength="20" /></li>
	<li><label>Tercerizado:</label>
				<label class="input-radio-field"><input type="radio" name="tercerizado" value="true" id="tercerizado" />S�</label>
       			<label class="input-radio-field"><input type="radio" name="tercerizado" value="false" id="tercerizado" />No</label></li>
    
</ul>

<label>Datos del Receptor</label>
<!--S�lo se ve si es Particular --> 
    <fieldset><ul>
		<li><label>DNI:</label><input class="input-field" name="dniReceptor" type="text" id="dniReceptor" maxlength="10" /></li>
		<li><label>Nombre:</label><input class="input-field" name="nombreReceptor" type="text" id="nombreReceptor" maxlength="50" /></li>
		<li><label>Apellido:</label><input class="input-field" name="apellidoReceptor" type="text" id="apellidoReceptor" maxlength="50" /></li>
    </ul></fieldset>


      <div class="btn_centrado"><input name="Ingresar" type="submit" id="btn_encomienda" value="Enviar" /></div>
      </form>

  </div>
  </div>
      </div>
    <br />
     <!-- end .content --></div>
  <!-- end .container --></div>
</body>
</html>
