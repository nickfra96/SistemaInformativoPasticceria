/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Magazzinoingresso;
import entity.Materiaprima;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class MagazzinoingressoFacade extends AbstractFacade<Magazzinoingresso> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MagazzinoingressoFacade() {
        super(Magazzinoingresso.class);
    }

    public Magazzinoingresso findByMateriaprimaCodice(Materiaprima m) {
        try {
            Magazzinoingresso mi = (Magazzinoingresso) getEntityManager()
                    .createNamedQuery("Magazzinoingresso.findByMateriaprimaCodice")
                    .setParameter("materiaprimaCodice", m.getCodice()).getSingleResult();
            return mi;
        } catch (NoResultException nre) {
            return null;

        }
    }

    public void modifica(Magazzinoingresso m) {
        getEntityManager().merge(m);
    }

    public void crea(Magazzinoingresso f) {
        try {
            getEntityManager().persist(f);
        } catch (PersistenceException p) {

        }
    }

}
