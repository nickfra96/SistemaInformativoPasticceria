/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Utenza;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class UtenzaFacade extends AbstractFacade<Utenza> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UtenzaFacade() {
        super(Utenza.class);
    }

    public void crea(Utenza f) {
        try {
            getEntityManager().persist(f);
        } catch (PersistenceException p) {

        }

    }

    public void modifica(Utenza m) {
        getEntityManager().merge(m);
    }
}
