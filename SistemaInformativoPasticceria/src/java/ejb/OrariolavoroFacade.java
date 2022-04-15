/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Orariolavoro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class OrariolavoroFacade extends AbstractFacade<Orariolavoro> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrariolavoroFacade() {
        super(Orariolavoro.class);
    }

}
