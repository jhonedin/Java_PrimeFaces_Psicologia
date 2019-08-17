/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Horariodisponible;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface HorariodisponibleFacadeLocal {

    void create(Horariodisponible horariodisponible);

    void edit(Horariodisponible horariodisponible);

    void remove(Horariodisponible horariodisponible);

    Horariodisponible find(Object id);

    List<Horariodisponible> findAll();

    List<Horariodisponible> findRange(int[] range);

    int count();
    
}
