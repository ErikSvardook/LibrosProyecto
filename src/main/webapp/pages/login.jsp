<%-- 
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Página JSP para crear usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style rel="stylesheet" >
        <%@include file="../resources/css/login.css" %>
        </style>
    </head>
    <body>

        <div class="login-box">
        <form action="AdministrarUsuarios?action=crear" method="post">
        <input type='hidden' name='idusuario' ><br> 

        <form>
            <h2>REGISTRATE</h2>
            
                <div class="user-box">
                    <input type="text" name="nombreusuario" required="">
                    <label>Nombre de usuario</label>
                </div>
                <div class="user-box">
                    <input type="password" name="contrasena" required="">
                    <label>Contraseña</label>
                </div>
                <div class="user-box">
                    <input type="text" name="nombre" required="">
                    <label>Nombre completo</label>
                </div>
                <div class="user-box">
                    <input type="text" name="edad" required="" onkeypress="return event.charCode >= 48 && event.charCode <= 57">
                    <label>Edad</label>
                </div>
                <div class="user-box">
                    <input type="text" name="sexo" required="">
                    <label>Sexo</label>
                </div>
                
            
            <button type='submit' >
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Enviar
            </button>
            
            <a href="/LibrosProyecto/pages/index.html">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                Volver
            </a>
                
        </form>
        </div>
    </body>
</html>
