/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Profesionalservicios;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface ProfesionalserviciosFacadeLocal {

    void create(Profesionalservicios profesionalservicios);

    void edit(Profesionalservicios profesionalservicios);

    void remove(Profesionalservicios profesionalservicios);

    Profesionalservicios find(Object id);

    List<Profesionalservicios> findAll();

    List<Profesionalservicios> findRange(int[] range);

    int count();
    
}
