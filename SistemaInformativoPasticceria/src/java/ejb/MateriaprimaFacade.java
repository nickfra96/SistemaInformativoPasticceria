/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Materiaprima;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
public class MateriaprimaFacade extends AbstractFacade<Materiaprima> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MateriaprimaFacade() {
        super(Materiaprima.class);
    }

    public Materiaprima findByCodice(int m) {
        return (Materiaprima) getEntityManager().createNamedQuery("Materiaprima.findByCodice").setParameter("codice", m).getSingleResult();
    }

    public void modifica(Materiaprima m) {
        getEntityManager().merge(m);
    }

    public void crea(Materiaprima f) {
        try {
            getEntityManager().persist(f);
        } catch (PersistenceException p) {

        }
    }

}
