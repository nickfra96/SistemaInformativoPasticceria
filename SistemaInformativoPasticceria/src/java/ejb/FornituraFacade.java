/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Fatturaacquisto;
import entity.Fornitore;
import entity.Fornitura;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class FornituraFacade extends AbstractFacade<Fornitura> {

    @PersistenceContext(unitName = "GelateriaFortinoPU")
    private EntityManager em;

    @EJB
    DettagliofornituramateriaprimaFacade ejbDettFornMatPr;

    public DettagliofornituramateriaprimaFacade getEjbDettFornMatPr() {
        return ejbDettFornMatPr;
    }

    public void setEjbDettFornMatPr(DettagliofornituramateriaprimaFacade ejbDettFornMatPr) {
        this.ejbDettFornMatPr = ejbDettFornMatPr;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FornituraFacade() {
        super(Fornitura.class);
    }

    public List dettaglioFornitura(Fornitura f) {
        return ejbDettFornMatPr.getEntityManager().createNamedQuery("Dettagliofornituramateriaprima.findByFornituraId")
                .setParameter("fornituraId", f.getId()).getResultList();
    }

    public void modifica(Fornitura f) {
        getEntityManager().merge(f);
    }

    public List findByFornitore(Fornitore f) {
        return getEntityManager().createQuery("SELECT fo FROM Fornitura fo WHERE FO.fornitorePiva = :forn").setParameter("forn", f).getResultList();
    }

    public Fatturaacquisto findFattura(int fornid) {
        Fatturaacquisto fa = new Fatturaacquisto();
        try {
            fa = (Fatturaacquisto) getEntityManager().createQuery("SELECT fa FROM Fatturaacquisto fa WHERE FA.fornituraId = :fid").setParameter("fid", fornid).getSingleResult();
        } catch (Exception nre) {

        }
        System.out.println("Valori fattura----------->"+fa);
        return fa;
    }

    public List<Fornitura> listaFornitureMeseCorrente(){


            Date d;
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
            List<Fornitura> lf = getEntityManager().createQuery("SELECT f FROM Fornitura f").getResultList();
           for (Fornitura f : lf){
            try{
            d =sdf.parse(f.getData());
            Date date = new Date();
            if(d.getMonth()!=date.getMonth() || d.getYear()!=date.getYear()){
                    lf.remove(f);
                    System.out.println(""+ f.getData());}
                    }catch (ParseException pe){
                pe.printStackTrace();
            }
                    }


            return lf;


        }


 public int numeroFornitureMeseCorrente(){
            int x=0;
            Date d;
            SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
            List<Fornitura> lf = getEntityManager().createQuery("SELECT f FROM Fornitura f").getResultList();
           for (Fornitura f : lf){
            try{
            d =sdf.parse(f.getData());
            Date date = new Date();
            if(d.getMonth()==date.getMonth() && d.getYear()==date.getYear()){
                    x++;
                System.out.println("" + f.getData());}
                    }catch (ParseException pe){
                pe.printStackTrace();
            }
                    }


            return x;
        }



}
