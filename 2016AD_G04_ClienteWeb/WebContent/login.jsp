<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
   <form action="Sistema?action=iniciarSesion" method="post" id="frmLogin" class="form-style-2">
         <div><h2>Login</h2></div>
          <div><label>Usuario</label><input name="txtUsuario" type="text" class="input-field" /></div>
          <div><label>Password</label><input name="txtPassword" type="password" class="input-field" /></div>
     <div style="width:100%; text-align:center;"><input type="submit" value="Iniciar Sesion"/></div>
   </form>
</div>
</body> 	 
</html> 
