/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.UtenzaFacade;
import entity.Utenza;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "utenzaController")
@SessionScoped
public class UtenzaController implements Serializable {

    private Utenza utenza;
    @EJB
    private UtenzaFacade ejbUtenza;
    private List listaUtenze, listaFiltrata;

    public UtenzaController() {
    }

    @PostConstruct
    public void init() {
        listaUtenze = ejbUtenza.getEntityManager().createNamedQuery("Utenza.findAll").getResultList();
    }

    public Utenza getUtenza() {
        System.out.println("UTENZA in controller "+utenza);
        return utenza;
    }

    public void setUtenza(Utenza utenza) {
        this.utenza = utenza;
        System.out.println("LISTA UTENZA SETTATA "+utenza.getCodice());
    }

    public UtenzaFacade getEjbUtenza() {
        return ejbUtenza;
    }

    public void setEjbUtenza(UtenzaFacade ejbUtenza) {
        this.ejbUtenza = ejbUtenza;
    }

    public List getListaUtenze() {
        System.out.println("Lista utenze>>>>>" + listaUtenze);
        return listaUtenze;
    }

    public void setListaUtenze(List listaUtenze) {
        this.listaUtenze = listaUtenze;
    }

    public List getListaFiltrata() {
        System.out.println("LISTA UTENZE FILTRATA>>>>>>>>>><" + listaFiltrata);
        return listaFiltrata;
    }

    public void setListaFiltrata(List listaFiltrata) {
        this.listaFiltrata = listaFiltrata;
    }


    public String preparaLista() {
        listaUtenze = ejbUtenza.getEntityManager().createNamedQuery("Utenza.findAll").getResultList();
        return "/utenza/lista";
    }

    public String preparaLista2() {
        listaUtenze = ejbUtenza.getEntityManager().createNamedQuery("Utenza.findAll").getResultList();
        return "/fornitore/creaDettFornUt2";
    }

    public String modifica() {
        try {
            ejbUtenza.modifica(utenza);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza modificata", utenza.getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/utenza/lista";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Merce in magazzino non modificato", utenza.getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/magazzinoin/lista";
        }
    }

    public String preparaCrea() {
        utenza = new Utenza();
        return "/utenza/crea";
    }

    public String preparaCrea2() {
        System.out.println("sono qui");
        utenza = new Utenza();
        return "/fornitore/creaNewUtenza";
    }

}
