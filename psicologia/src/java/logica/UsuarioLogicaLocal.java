/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author Jhon
 */
@Local
public interface UsuarioLogicaLocal {
    public Usuario ingresar(Usuario usuario) throws Exception;
    public void registarUsuario(Usuario usuario) throws Exception;
    public void modificarUsuario(Usuario usuario) throws Exception;
}
