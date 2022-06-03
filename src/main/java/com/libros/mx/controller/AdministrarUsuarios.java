/*
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Controller para controlar los movimientos de la página
 */

package com.libros.mx.controller;

import com.libros.mx.entity.Usuario;
import com.libros.mx.service.IUsuarioService;
import com.libros.mx.service.UsuarioServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdministrarUsuarios extends HttpServlet {

    IUsuarioService service;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action:" + action);
        switch (action) {
            case "listar":
                System.out.println("Listando...");
                Listar(request, response);
                break;
            case "crearForm":
                System.out.println("Creando...");
                crearFormulario(request, response);
                break;
            case "crear":
                System.out.println("Creando...");
                crear(request, response);
                break;
            case "actualizarForm":
                System.out.println("Creando...");
                actualizarForm(request, response);
                break;
            case "actualizar":
                System.out.println("Creando...");
                actualizar(request, response);
                break;
            case "eliminar":
                System.out.println("Creando...");
                Eliminar(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("");
        doGet(request, response);
    }

    private void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listar.jsp");
        this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }

    private void crearFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
        dispatcher.forward(request, response);
    }

    private void actualizarForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = this.service.obtenerRegistro(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/actualizar.jsp");
        dispatcher.forward(request, response);
    }

    private void crear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNombreusuario(request.getParameter("nombreusuario"));
        usuario.setContraseña(request.getParameter("contrasena"));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        usuario.setSexo(request.getParameter("sexo"));
        service = new UsuarioServiceImpl();
        service.crearRegistro(usuario);
        System.out.println("INGRESADO: " + usuario.getNombre());

        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/login.jsp");
        dispatcher.forward(request, response);
        this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("id"));
        Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("idusuario")));
        usuario.setNombreusuario(request.getParameter("nombreusuario"));
        usuario.setContraseña(request.getParameter("contrasena"));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        usuario.setSexo(request.getParameter("sexo"));
        service = new UsuarioServiceImpl();
        service.actualizarRegistro(usuario);
        System.out.println("INGRESADO: " + usuario.getNombre());

        RequestDispatcher dispatcher = request.getRequestDispatcher("AdministrarUsuarios?action=listar");
        dispatcher.forward(request, response);
        this.service = new UsuarioServiceImpl();
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }

    private void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/listar.jsp");
        this.service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario = this.service.obtenerRegistro(Integer.parseInt(request.getParameter("id")));
        service.eliminarRegistro(usuario);
        System.out.println("eliminando");
        List<Usuario> ListaUsuario = this.service.obtenerRegistros();
        request.setAttribute("ListaUsuario", ListaUsuario);
        dispatcher.forward(request, response);
    }

}
