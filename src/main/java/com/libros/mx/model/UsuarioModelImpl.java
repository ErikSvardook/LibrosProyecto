/*
    Autor: Erik Jarquin Sanchez
    Fecha de creación: 25 de abril del 2022
    Fecha de modificación: 8 de mayo del 2022
    Descripción: Se implementan los metodos
 */
package com.libros.mx.model;

import com.libros.mx.entity.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UsuarioModelImpl implements IUsuarioModel {
    
    private SessionFactory sf;
    private Session s;
    
    @Override
    public List<Usuario> obtenerRegistros() {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            List<Usuario> lista = s.createCriteria(Usuario.class).list();
            s.close();

            sf.close();
            return lista;
        } catch (HibernateException e) {
            System.out.println("Error al recuperar los registros:" + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
            s.update(usuario);
            s.getTransaction().commit();
            s.close();
            sf.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar el registro:" + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
            s.delete(usuario);
            s.getTransaction().commit();
            s.close();
            sf.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el registro:" + e.getMessage());
        }
    }

    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
            s.save(usuario);
            s.getTransaction().commit();
            s.close();
            sf.close();

        } catch (HibernateException e) {
            System.out.println("Error al crear el registro:" + e.getMessage());
        }
    }

    @Override
    public Usuario obtenerRegistro(int id) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            Usuario usuario = (Usuario) s.get(Usuario.class, id);
            s.close();
            sf.close();
            return usuario;
        } catch (Exception e) {
            System.out.println("Error al recuperar el registro:" + e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
    IUsuarioModel c =new UsuarioModelImpl();
    Usuario u=new Usuario();
    
    
    u.setNombreusuario("Erik");
    u.setContraseña("123");
    u.setNombre("ErikJarq");
    u.setEdad(10);
    u.setSexo("Hombre");
    u.setIdusuario(30);
    c.crearRegistro(u);
    }
}
