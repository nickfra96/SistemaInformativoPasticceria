/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Fornitore;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class FornitoreFacade extends AbstractFacade<Fornitore> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FornitoreFacade() {
        super(Fornitore.class);
    }

     public void modifica(Fornitore f) {
        getEntityManager().merge(f);
    }

    public void crea(Fornitore f) {
        try {
            getEntityManager().persist(f);
        } catch (PersistenceException p) {

        }
    }

}
