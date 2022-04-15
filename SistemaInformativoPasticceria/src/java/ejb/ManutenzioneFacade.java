/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Manutenzione;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ManutenzioneFacade extends AbstractFacade<Manutenzione> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManutenzioneFacade() {
        super(Manutenzione.class);
    }

}
