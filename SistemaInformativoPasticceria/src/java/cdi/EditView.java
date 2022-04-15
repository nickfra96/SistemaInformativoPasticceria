/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import entity.Dettagliofornituramateriaprima;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import entity.Fornitore;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "dtEditView")
@RequestScoped
public class EditView implements Serializable {

    @ManagedProperty("#{fornitoreController}")
    private FornitoreController fornitoreCdi;
    private List dettaglioFornitura;

    public FornitoreController getFornitoreCdi() {
        return fornitoreCdi;
    }

    public void setFornitoreCdi(FornitoreController fornitoreCdi) {
        this.fornitoreCdi = fornitoreCdi;
    }

    public List getListaFornitori() {
        return dettaglioFornitura;
    }

    public void setListaFornitori(List listaFornitori) {
        this.dettaglioFornitura = listaFornitori;
    }

    public List getDettaglioFornitura() {
        return dettaglioFornitura;
    }

    public void setDettaglioFornitura(List dettaglioFornitura) {
        this.dettaglioFornitura = dettaglioFornitura;
    }

    @PostConstruct
    public void init() {
        dettaglioFornitura = fornitoreCdi.getEjbFornitura().dettaglioFornitura(fornitoreCdi.getFornitura());
        dettaglioFornitura.add(new Dettagliofornituramateriaprima());
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println("newValue---------------->" + newValue);
        
       /* if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            fornitoreCdi.setDettFornMatPrima(dettFornMatPrima);
            System.out.println("Fornitore.piva----->" + fornitoreCdi.getFornitore().getPiva());
            System.out.println("Fornitore.nome----->" + fornitoreCdi.getFornitore().getNome());
            System.out.println("Fornitore.telefono----->" + fornitoreCdi.getFornitore().getTelefono());
            System.out.println("Fornitore.sede----->" + fornitoreCdi.getFornitore().getSede());
            System.out.println("Fornitore.tipo----->" + fornitoreCdi.getFornitore().getTipo());
            switch (event.getColumn().getHeaderText()) {
                case "Partita IVA":
                    fornitoreCdi.getFornitore().setPiva((String) newValue);
                    break;
                case "Nome":
                    fornitoreCdi.getFornitore().setNome((String) newValue);
                    break;
                case "Telefono":
                    fornitoreCdi.getFornitore().setTelefono((String) newValue);
                    break;
                case "Sede":
                    fornitoreCdi.getFornitore().setSede((String) newValue);
                    break;
                case "Tipo":
                    fornitoreCdi.getFornitore().setTipo((Character) newValue);
                    break;
                default:
                    break;
            }
            System.out.println("Fornitore.piva----->" + fornitoreCdi.getFornitore().getPiva());
            System.out.println("Fornitore.nome----->" + fornitoreCdi.getFornitore().getNome());
            System.out.println("Fornitore.telefono----->" + fornitoreCdi.getFornitore().getTelefono());
            System.out.println("Fornitore.sede----->" + fornitoreCdi.getFornitore().getSede());
            System.out.println("Fornitore.tipo----->" + fornitoreCdi.getFornitore().getTipo());
            fornitoreCdi.performUpdate();
            //listaFornitori = creaLista();
        }*/
    }
    
}
