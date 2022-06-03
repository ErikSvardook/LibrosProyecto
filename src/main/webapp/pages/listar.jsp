<%-- 
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Página JSP para listar los datos
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style rel="stylesheet" >
        <%@include file="../resources/css/tabla.css" %>
        </style>
        <style rel="stylesheet" >
        <%@include file="../resources/css/principal.css" %>
        </style>
    </head>
    
    <body>
        
       
        <h1>Lista de usuarios</h1>

        <table border="1" width="100%">
            <tr>
                <td>IdUsuario</td>   
                <td>Usuario</td>  
                <td>Contraseña</td>
                <td>Nombre</td>
                <td>Sexo</td>
                <td>Edad</td>
                <td>Editar</td>
                <td>Eliminar</td>   
            </tr> 
            
            <c:forEach var="usuario" items="${ListaUsuario}">
                <tr>
                    <td><c:out value="${usuario.idusuario}"/></td> 
                    <td><c:out value="${usuario.nombreusuario}"/></td>
                    <td><c:out value="${usuario.contraseña}"/></td>
                    <td><c:out value="${usuario.nombre}"/></td>
                    <td><c:out value="${usuario.sexo}"/></td>
                    <td><c:out value="${usuario.edad}"/></td>
                    <td><a href="AdministrarUsuarios?action=actualizarForm&id=<c:out value="${usuario.idusuario}"/>">Editar</a></td>
                    <td><a href="AdministrarUsuarios?action=eliminar&id=<c:out value="${usuario.idusuario}"/>">Eliminar</a></td>
                </tr> 
            </c:forEach>
        </table> 
    </body>
</html>
