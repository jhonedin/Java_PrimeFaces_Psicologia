/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Historia;

/**
 *
 * @author CRISTHIAN
 */
@Stateless
public class HistoriaFacade extends AbstractFacade<Historia> implements HistoriaFacadeLocal {

    @PersistenceContext(unitName = "psicologiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistoriaFacade() {
        super(Historia.class);
    }
    
}
