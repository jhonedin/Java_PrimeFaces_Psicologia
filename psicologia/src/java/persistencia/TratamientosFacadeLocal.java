/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Tratamientos;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface TratamientosFacadeLocal {

    void create(Tratamientos tratamientos);

    void edit(Tratamientos tratamientos);

    void remove(Tratamientos tratamientos);

    Tratamientos find(Object id);

    List<Tratamientos> findAll();

    List<Tratamientos> findRange(int[] range);

    int count();
    
}
