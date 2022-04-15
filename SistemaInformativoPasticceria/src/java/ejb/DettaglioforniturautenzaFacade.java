/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Dettaglioforniturautenza;
import entity.Fornitura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DettaglioforniturautenzaFacade extends AbstractFacade<Dettaglioforniturautenza> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DettaglioforniturautenzaFacade() {
        super(Dettaglioforniturautenza.class);
    }

    public void modifica(Dettaglioforniturautenza d) {
        getEntityManager().merge(d);
    }

    public List dettaglioByFornitura(Fornitura f) {
                return getEntityManager().createNamedQuery("Dettaglioforniturautenza.findByFornituraId").setParameter("fornituraId", f.getId())
                .getResultList();
    }

}
