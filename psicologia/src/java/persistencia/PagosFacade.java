/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Pagos;

/**
 *
 * @author CRISTHIAN
 */
@Stateless
public class PagosFacade extends AbstractFacade<Pagos> implements PagosFacadeLocal {

    @PersistenceContext(unitName = "psicologiaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PagosFacade() {
        super(Pagos.class);
    }
    
}
