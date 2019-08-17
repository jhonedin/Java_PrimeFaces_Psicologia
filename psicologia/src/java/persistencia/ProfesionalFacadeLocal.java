/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Profesional;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface ProfesionalFacadeLocal {

    void create(Profesional profesional);

    void edit(Profesional profesional);

    void remove(Profesional profesional);

    Profesional find(Object id);

    List<Profesional> findAll();

    List<Profesional> findRange(int[] range);

    int count();
    
}
