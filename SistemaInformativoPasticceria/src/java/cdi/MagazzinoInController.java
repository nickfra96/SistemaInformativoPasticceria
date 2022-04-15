/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MagazzinoingressoFacade;
import ejb.MateriaprimaFacade;
import entity.Fornitore;
import entity.Magazzinoingresso;
import entity.Materiaprima;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.spi.Context;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@Named(value = "magazzinoInController")
@SessionScoped
public class MagazzinoInController implements Serializable {

    private Magazzinoingresso elementoMagazzino;
    private Materiaprima materiaprima;
    @EJB
    private MagazzinoingressoFacade ejbMagazzinoIn;
    @EJB
    private MateriaprimaFacade ejbMateriaPrima;
    @EJB
    MateriaprimaFacade ejbMateriaprima;
    private List magazzinoIn, listaFiltrata, listaMatPrime;

    public MateriaprimaFacade getEjbMateriaprima() {
        return ejbMateriaprima;
    }

    public void setEjbMateriaprima(MateriaprimaFacade ejbMateriaprima) {
        this.ejbMateriaprima = ejbMateriaprima;
    }

    public List getListaMatPrime() {
        return listaMatPrime;
    }

    public void setListaMatPrime(List listaMatPrime) {
        this.listaMatPrime = listaMatPrime;
    }

    public MagazzinoInController() {
    }

    @PostConstruct
    public void init() {
        magazzinoIn = ejbMagazzinoIn.getEntityManager().createNamedQuery("Magazzinoingresso.findAll").getResultList();
        System.out.println("LISTA MAGAZZINO "+magazzinoIn);
    }

    public Magazzinoingresso getElementoMagazzino() {
        return elementoMagazzino;
    }

    public void setElementoMagazzino(Magazzinoingresso elementoMagazzino) {
        this.elementoMagazzino = elementoMagazzino;
    }

    public Materiaprima getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Materiaprima materiaprima) {
        this.materiaprima = materiaprima;
    }

    public MagazzinoingressoFacade getEjbMagazzinoIn() {
        return ejbMagazzinoIn;
    }

    public void setEjbMagazzinoIn(MagazzinoingressoFacade ejbMagazzinoIn) {
        this.ejbMagazzinoIn = ejbMagazzinoIn;
    }

    public MateriaprimaFacade getEjbMateriaPrima() {
        return ejbMateriaPrima;
    }

    public void setEjbMateriaPrima(MateriaprimaFacade ejbMateriaPrima) {
        this.ejbMateriaPrima = ejbMateriaPrima;
    }

    public List getMagazzinoIn() {
        System.out.println("lista mag: "+magazzinoIn);
        return magazzinoIn;
    }

    public void setMagazzinoIn(List magazzinoIn) {
        this.magazzinoIn = magazzinoIn;
    }

    public List getListaFiltrata() {
        return listaFiltrata;
    }

    public void setListaFiltrata(List listaFiltrata) {
        this.listaFiltrata = listaFiltrata;
    }

    public String preparaLista() {
        magazzinoIn = ejbMagazzinoIn.getEntityManager().createNamedQuery("Magazzinoingresso.findAll").getResultList();
        System.out.println("PREPARA LISTA");
        System.err.println(magazzinoIn);
        return "/magazzinoin/lista";
    }

    public void preparaLista2() throws IOException {
        listaMatPrime = ejbMateriaprima.getEntityManager().createNamedQuery("Materiaprima.findAll").getResultList();
        magazzinoIn = ejbMagazzinoIn.getEntityManager().createNamedQuery("Magazzinoingresso.findAll").getResultList();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/GelateriaFortino/faces/fornitore/creaDettFornMatPrima2.xhtml");
    }

    public Magazzinoingresso findByMateriaPrima(Materiaprima m) {
        return (Magazzinoingresso) ejbMagazzinoIn.getEntityManager().createNamedQuery("Magazzinoingresso.findByMateriaprimaCodice")
                .setParameter("materiaprimaCodice", m.getCodice()).getSingleResult();
    }

    public String modifica() {
        try {
            Materiaprima mat = elementoMagazzino.getMateriaprima();
            ejbMateriaPrima.modifica(mat);
            ejbMagazzinoIn.modifica(elementoMagazzino);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Merce in magazzino modificata", elementoMagazzino.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/magazzinoin/lista";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Merce in magazzino non modificato", elementoMagazzino.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/magazzinoin/lista";
        }
    }

    public String preparaCrea() {
        elementoMagazzino = new Magazzinoingresso();
        materiaprima = new Materiaprima();
        return "/magazzinoin/crea";
    }

    public String preparaCrea2() {
        elementoMagazzino = new Magazzinoingresso();
        materiaprima = new Materiaprima();
        return "/fornitore/creaElementoInMagazzino";
    }
}
