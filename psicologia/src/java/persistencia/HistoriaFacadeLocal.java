/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Historia;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface HistoriaFacadeLocal {

    void create(Historia historia);

    void edit(Historia historia);

    void remove(Historia historia);

    Historia find(Object id);

    List<Historia> findAll();

    List<Historia> findRange(int[] range);

    int count();
    
}
