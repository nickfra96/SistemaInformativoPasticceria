/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Fatturaacquisto;
import entity.Fornitura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class FatturaacquistoFacade extends AbstractFacade<Fatturaacquisto> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FatturaacquistoFacade() {
        super(Fatturaacquisto.class);
    }

    public Fatturaacquisto findByNumeroFornitura(Fornitura fo) {
        try {
            return (Fatturaacquisto) getEntityManager().createQuery("SELECT f FROM Fatturaacquisto f WHERE F.fornituraId = :id")
                    .setParameter("id", fo.getId()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
