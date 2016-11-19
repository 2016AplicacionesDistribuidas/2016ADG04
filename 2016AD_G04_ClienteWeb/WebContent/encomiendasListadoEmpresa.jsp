<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import= "java.util.*"%>
<%@ page import="com.ADG04.bean.Administracion.DTO_Usuario"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cabecera -->
<%@ include file="header.jsp" %>

<!-- Fin Cabecera -->

<!-- Fin Declaraciones -->

<!-- Scripts -->
<script type="text/javascript">


$(document).ready(function() {	
	
             $("#projectTable").jqGrid({
                  url: "servletEncomiendasListadoEmpresa",
 
                  datatype: "json",
                  jsonReader: {repeatitems: false, id: "ref"},
                  colNames:['Nro Encomienda','Nro Cliente', 'Envio asignado', 'Estado','Ver Encomienda'],
                  colModel:[
                      {name:'idEncomienda',index:'idEncomienda', width:100},
                      {name:'idCliente',index:'idCliente', width:100},
                      {name:'envioAsignado',index:'envioAsignado', width:100},
 					  {name:'estado',index:'estado', width:100},
 					  {name:'verEncomienda',index:'verEncomienda', width:100}
                  ],
                  rowNum:20,
               //   rowList:[20,60,100],
                  height:200,
                  pager: "#pagingDiv",
                  viewrecords: true,
                  caption: ""
              });
               
              $("#pcSelect").change(function(){
                  var postcode = $("#pcSelect").val();
                  jQuery("#projectTable").jqGrid(
                          "setGridParam",{
                              url:"LoadJsonDataServlet?type="+ postcode,
                              page:1})
                          .trigger("reloadGrid");
              });
 
 	});

		  
			  	   
//}); //document ready

</script>

<!-- Cuerpo -->
<body>
<div class="container">
    <div class="content">
     <div class="amarillo"></div>
  	<div class="page" style="background: #ccc; padding: 25px 100px;height:500px">
	          <div style="float: left; height: 200px !important;">
	              <table id="projectTable"></table>
	              <div id="pagingDiv"></div>
	          </div>
	         </div>
		</div>
	</div>
	</div>
	<br />
	<!-- end .content --></div>
	<!-- end .container --></div>
</body>
</html>
