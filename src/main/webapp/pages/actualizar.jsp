<%-- 
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Página JSP para actualizar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h2>Actualizar datos</h2>
            <form action="AdministrarUsuarios?action=actualizar" method="post">
                <input type='hidden' name='idusuario' value="<c:out value="${usuario.idusuario}"></c:out>"><br>
                
                    <div class="user-box">
                        <input type="text" name="nombreusuario" required="" value="<c:out value="${usuario.nombreusuario}" ></c:out>"><br>
                        <label>Nombre de usuario</label>
                    </div>
                    <div class="user-box">
                        <input type="password" name="contrasena" required="" value="<c:out value="${usuario.contraseña}"></c:out>"><br>
                        <label>Contraseña</label>
                    </div>
                    <div class="user-box">
                        <input type="text" name="nombre" required="" value="<c:out value="${usuario.nombre}"></c:out>"><br>
                        <label>Nombre completo</label>
                    </div>
                    <div class="user-box">
                        <input type="text" name="edad" required="" value="<c:out value="${usuario.edad}"></c:out>"><br>
                        <label>Edad</label>
                    </div>
                    <div class="user-box">
                        <input type="text" name="sexo" required="" value="<c:out value="${usuario.sexo}"></c:out>"><br>
                        <label>Sexo</label>
                    </div>
                
                <!--  
                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Enviar
                </a>
                -->
                <!-- 
                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Volver
                </a>
                -->
                <input type='submit' value='Guardar'>
            </form>
        </div>
    </body>
</html>
