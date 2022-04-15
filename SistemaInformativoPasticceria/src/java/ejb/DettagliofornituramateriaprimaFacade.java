/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Dettagliofornituramateriaprima;
import entity.Fornitura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DettagliofornituramateriaprimaFacade extends AbstractFacade<Dettagliofornituramateriaprima> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DettagliofornituramateriaprimaFacade() {
        super(Dettagliofornituramateriaprima.class);
    }

    public void modifica(Dettagliofornituramateriaprima d) {
        getEntityManager().merge(d);
    }

    public List findDettaglioByFornitura(Fornitura f) {
        return getEntityManager().createNamedQuery("Dettagliofornituramateriaprima.findByFornituraId").setParameter("fornituraId", f.getId())
                .getResultList();
    }

}
