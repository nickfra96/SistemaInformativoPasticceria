/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MateriaprimaFacade;
import entity.Materiaprima;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;


@Named(value = "materiaprimaController")
@SessionScoped
public class MateriaprimaController implements Serializable {

    private Materiaprima materiaprima;
    @EJB
    private MateriaprimaFacade ejbMateriaPrima;
    private List listaMaterieprime;

    public MateriaprimaController() {
    }

    public Materiaprima getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Materiaprima materiaprima) {
        this.materiaprima = materiaprima;
    }

    public MateriaprimaFacade getEjbMateriaPrima() {
        return ejbMateriaPrima;
    }

    public void setEjbMateriaPrima(MateriaprimaFacade ejbMateriaPrima) {
        this.ejbMateriaPrima = ejbMateriaPrima;
    }

    public List getListaMaterieprime() {
        return listaMaterieprime;
    }

    public void setListaMaterieprime(List listaMaterieprime) {
        this.listaMaterieprime = listaMaterieprime;
    }

    @PostConstruct
    public void init() {
        listaMaterieprime = ejbMateriaPrima.getEntityManager().createNamedQuery("Materiaprima.findAll").getResultList();
        System.out.println(listaMaterieprime);
    }

}
