/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Fatturavendita;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FatturavenditaFacade extends AbstractFacade<Fatturavendita> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FatturavenditaFacade() {
        super(Fatturavendita.class);
    }

}
