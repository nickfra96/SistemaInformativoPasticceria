/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.UtenzaFacade;
import entity.Utenza;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;


@Named(value = "dataModelUtenza")
@RequestScoped
public class DataModelUtenza {

    @ManagedProperty("#{utenzaController}")
    private UtenzaController utenzaCdi;
    private DataTable dataTable;

    /**
     * Creates a new instance of DataModelMagazzinoIn
     */
    public DataModelUtenza() {
    }

    public UtenzaController getUtenzaCdi() {
        return utenzaCdi;
    }

    public void setUtenzaCdi(UtenzaController utenzaCdi) {
        this.utenzaCdi = utenzaCdi;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public String preparaLista() {
        dataTable = new DataTable();
        return utenzaCdi.preparaLista();
    }

    public String preparaModifica(UtenzaController uc) {
        this.utenzaCdi=uc;
        utenzaCdi.setUtenza((Utenza) dataTable.getRowData());
        return "/utenza/modifica";
    }

    public String eliminaEvedi(UtenzaController uc) {
        this.utenzaCdi=uc;
        Utenza f = (Utenza) dataTable.getRowData();
        utenzaCdi.setUtenza(f);
        try {
            utenzaCdi.getEjbUtenza().remove(f);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza eliminata", f.getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            utenzaCdi.setUtenza(new Utenza());
            return "" + utenzaCdi.preparaLista();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza non eliminata", f.getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "" + utenzaCdi.preparaLista();
        }
    }

    public String crea(UtenzaController uc) {
        try {
            this.utenzaCdi=uc;
            Utenza utenza =utenzaCdi.getUtenza();
            utenzaCdi.getEjbUtenza().crea(utenza);
            dataTable = new DataTable();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza creata",
                    utenzaCdi.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return utenzaCdi.preparaLista();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Utenza non creata",
                    utenzaCdi.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            dataTable = new DataTable();
            return utenzaCdi.preparaLista();
        }
    }

    public String creaNuovaUtenza(UtenzaController uc) {
        try {
            this.utenzaCdi=uc;
            Utenza utenza =utenzaCdi.getUtenza();
            utenzaCdi.getEjbUtenza().crea(utenza);
            dataTable = new DataTable();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza creata",
                    utenzaCdi.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return utenzaCdi.preparaLista2();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Utenza non creata",
                    utenzaCdi.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            dataTable = new DataTable();
            return utenzaCdi.preparaLista2();
        }
    }
}
