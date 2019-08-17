/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Tratamientos;

/**
 *
 * @author CRISTHIAN
 */
@Stateless
public class TratamientosFacade extends AbstractFacade<Tratamientos> implements TratamientosFacadeLocal {

    @PersistenceContext(unitName = "psicologiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TratamientosFacade() {
        super(Tratamientos.class);
    }
    
}
