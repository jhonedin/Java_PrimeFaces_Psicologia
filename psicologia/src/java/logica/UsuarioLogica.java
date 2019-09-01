/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author Jhon
 */
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {

    @EJB
    private UsuarioFacadeLocal usuarioDAO;
    
    @Override
    public Usuario ingresar(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Usuario sin datos");
        }
        if(usuario.getCorreo().equals("")){
            throw new Exception("Correo Obligatorio");
        }
        if(usuario.getContrasena().equals("")){
            throw new Exception("Clave obligatoria");
        }
        Usuario objUsuario = usuarioDAO.findxCorreo(usuario.getCorreo());
        if(objUsuario == null){
            throw new Exception("Usuario incorrecto");
        }
        return objUsuario;
    }

    @Override
    public void registarUsuario(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Usuario sin datos");
        }
        if(usuario.getCorreo().equals("")){
            throw new Exception("Correo Obligatorio");
        }
        if(usuario.getContrasena().equals("")){
            throw new Exception("Clave obligatoria");
        }
        Usuario objUsuario = usuarioDAO.findxCorreo(usuario.getCorreo());
        if(objUsuario != null){
            throw new Exception("El contratista ya existe");
        }
        usuarioDAO.create(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Usuario sin datos");
        }
        if(usuario.getCorreo().equals("")){
            throw new Exception("Correo Obligatorio");
        }
        if(usuario.getContrasena().equals("")){
            throw new Exception("Clave obligatoria");
        }
        Usuario objUsuario = usuarioDAO.findxCorreo(usuario.getCorreo());
        if(objUsuario == null){
            throw new Exception("El Usuario NO existe");
        }
    }

    
}
