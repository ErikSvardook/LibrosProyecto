/*
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Se implementan los metodos
 */
package com.libros.mx.service;

import com.libros.mx.entity.Usuario;
import com.libros.mx.model.IUsuarioModel;
import com.libros.mx.model.UsuarioModelImpl;
import java.util.List;


public class UsuarioServiceImpl implements IUsuarioService {
    IUsuarioModel model = new UsuarioModelImpl();

    @Override
    public List<Usuario> obtenerRegistros() {
        return model.obtenerRegistros();
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        model.actualizarRegistro(usuario);
    }

    @Override
    public void eliminarRegistro(Usuario usuario) {
        model.eliminarRegistro(usuario);
    }

    @Override
    public void crearRegistro(Usuario usuario) {
        model.crearRegistro(usuario);
    }

    @Override
    public Usuario obtenerRegistro(int idusuario) {
        return model.obtenerRegistro(idusuario);
    }

}
