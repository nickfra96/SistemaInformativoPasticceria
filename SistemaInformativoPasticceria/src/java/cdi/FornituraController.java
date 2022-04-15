/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.DettagliofornituramateriaprimaFacade;
import ejb.DettaglioforniturautenzaFacade;
import ejb.FornituraFacade;
import ejb.MagazzinoingressoFacade;
import entity.Dettagliofornituramateriaprima;
import entity.Fornitura;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;


@Named(value = "fornituraController")
@SessionScoped
public class FornituraController implements Serializable {

    Fornitura fornitura;
    Dettagliofornituramateriaprima dettFMatP;
    List listaForniture,dettaglioFornitura,magazzinoIn;
    @EJB
    DettagliofornituramateriaprimaFacade ejbDetFornMatPrima;
    @EJB
    DettaglioforniturautenzaFacade ejbDetFornUt;
    @EJB
    MagazzinoingressoFacade ejbMagazzinoIn;
    @EJB
    FornituraFacade ejbFornituraFacade;

    public FornituraController() {
    }

    public Fornitura getFornitura() {
        return fornitura;
    }

    public void setFornitura(Fornitura fornitura) {
        this.fornitura = fornitura;
    }

    public Dettagliofornituramateriaprima getDettFMatP() {
        return dettFMatP;
    }

    public void setDettFMatP(Dettagliofornituramateriaprima dettFMatP) {
        this.dettFMatP = dettFMatP;
    }

    public List getListaForniture() {
        return listaForniture;
    }

    public void setListaForniture(List listaForniture) {
        this.listaForniture = listaForniture;
    }

    public List getDettaglioFornitura() {
        return dettaglioFornitura;
    }

    public void setDettaglioFornitura(List dettaglioFornitura) {
        this.dettaglioFornitura = dettaglioFornitura;
    }

    public DettagliofornituramateriaprimaFacade getEjbDetFornMatPrima() {
        return ejbDetFornMatPrima;
    }

    public void setEjbDetFornMatPrima(DettagliofornituramateriaprimaFacade ejbDetFornMatPrima) {
        this.ejbDetFornMatPrima = ejbDetFornMatPrima;
    }

    public DettaglioforniturautenzaFacade getEjbDetFornUt() {
        return ejbDetFornUt;
    }

    public void setEjbDetFornUt(DettaglioforniturautenzaFacade ejbDetFornUt) {
        this.ejbDetFornUt = ejbDetFornUt;
    }

    public MagazzinoingressoFacade getEjbMagazzinoIn() {
        return ejbMagazzinoIn;
    }

    public void setEjbMagazzinoIn(MagazzinoingressoFacade ejbMagazzinoIn) {
        this.ejbMagazzinoIn = ejbMagazzinoIn;
    }

    public List getMagazzinoIn() {
        return magazzinoIn;
    }

    public void setMagazzinoIn(List magazzinoIn) {
        this.magazzinoIn = magazzinoIn;
    }

    public String preparaListaDettaglio(Fornitura f) {
        System.out.println("ID FORNITURA "+f.getId());
        if(f.getTipo() == 'M') {
            dettaglioFornitura = ejbDetFornMatPrima.getEntityManager()
                    .createNamedQuery("Dettagliofornituramateriaprima.findByFornituraId").setParameter("fornituraId", f.getId())
                    .getResultList();
            return "/fornitura/dettFornMatPrima";
        } else if(f.getTipo() == 'E') {
            dettaglioFornitura = ejbDetFornUt.getEntityManager().createNamedQuery("Dettaglioforniturautenza.findByFornituraId")
                    .setParameter("fornituraId", f.getId()).getResultList();
            return "fornitura/dettFornUt";
        } else {
            return "";
        }
    }

    public String preparaListaMagazzino() {

        magazzinoIn = ejbMagazzinoIn.findAll();
        return "/fornitura/magazzinoIn" ;
    }

    public List<Fornitura> getFornitureDelMese(){
      return ejbFornituraFacade.listaFornitureMeseCorrente();

   }


    public int nFornituraMese(){
           return ejbFornituraFacade.numeroFornitureMeseCorrente();

            }

}
