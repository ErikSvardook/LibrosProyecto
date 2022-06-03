/*
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Se definen los metodos
 */
package com.libros.mx.service;

import com.libros.mx.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> obtenerRegistros();

    public void actualizarRegistro(Usuario usuario);

    public void eliminarRegistro(Usuario usuario);

    public void crearRegistro(Usuario usuario);

    public Usuario obtenerRegistro(int idusuario);
}
