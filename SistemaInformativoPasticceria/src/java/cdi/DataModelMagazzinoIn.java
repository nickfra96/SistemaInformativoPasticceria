/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import entity.Magazzinoingresso;
import entity.Materiaprima;
import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;


@ManagedBean(name = "dataTableMagCdi")
@RequestScoped
public class DataModelMagazzinoIn {

    @ManagedProperty("#{magazzinoInController}")
    private MagazzinoInController magazzinoInCdi;
    private FornitoreController fornitoreController;
    private DataTable dataTable;

    /**
     * Creates a new instance of DataModelMagazzinoIn
     */

    public FornitoreController getFornitoreController(){
        return fornitoreController;
    }

    public void setFornitoreController(FornitoreController f) {
        this.fornitoreController = fornitoreController = f;
    }
    public DataModelMagazzinoIn() {
    }

    public MagazzinoInController getMagazzinoInCdi() {
        return magazzinoInCdi;
    }

    public void setMagazzinoInCdi(MagazzinoInController magazzinoInCdi) {
        this.magazzinoInCdi = magazzinoInCdi;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public String preparaLista() {
        dataTable = new DataTable();
        return magazzinoInCdi.preparaLista();
    }

    public String preparaModifica() {
        magazzinoInCdi.setElementoMagazzino((Magazzinoingresso) dataTable.getRowData());
        return "/magazzinoin/modifica";
    }

    public String eliminaEvedi() {
        Magazzinoingresso f = (Magazzinoingresso) dataTable.getRowData();
        try{
        magazzinoInCdi.setElementoMagazzino(f);
        //try {
            magazzinoInCdi.getEjbMagazzinoIn().remove(f);
            Materiaprima entity = f.getMateriaprima();
            magazzinoInCdi.getEjbMateriaPrima().remove(entity);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento magazzino eliminato", f.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            magazzinoInCdi.setElementoMagazzino(new Magazzinoingresso());
            return "" + magazzinoInCdi.preparaLista();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento magazzino non eliminato", f.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "" + magazzinoInCdi.preparaLista();
        }
    }

    public String crea() {
        try {
            System.out.println("maagzzinoincdi "+magazzinoInCdi);
            Materiaprima m = magazzinoInCdi.getMateriaprima();
            magazzinoInCdi.getEjbMateriaPrima().crea(m);
            magazzinoInCdi.getElementoMagazzino().setMateriaprima(m);
            magazzinoInCdi.getElementoMagazzino().setMateriaprimaCodice(m.getCodice());
            Magazzinoingresso mi=magazzinoInCdi.getElementoMagazzino();
            magazzinoInCdi.getEjbMagazzinoIn().crea(mi);
            dataTable = new DataTable();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento magazzino creato",
                    magazzinoInCdi.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return magazzinoInCdi.preparaLista();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Elemento magazzino non creato",
                    magazzinoInCdi.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            dataTable = new DataTable();
            return magazzinoInCdi.preparaLista();
        }
    }
    public void creaNuovoElemento() throws IOException {
        try {
            System.out.println("maagzzinoincdi "+magazzinoInCdi);
            Materiaprima m = magazzinoInCdi.getMateriaprima();
            magazzinoInCdi.getEjbMateriaPrima().crea(m);
            magazzinoInCdi.getElementoMagazzino().setMateriaprima(m);
            magazzinoInCdi.getElementoMagazzino().setMateriaprimaCodice(m.getCodice());
            Magazzinoingresso mi=magazzinoInCdi.getElementoMagazzino();
            magazzinoInCdi.getEjbMagazzinoIn().crea(mi);
            dataTable = new DataTable();
            magazzinoInCdi.preparaLista2();
        } catch (Exception e) {
            dataTable = new DataTable();
            magazzinoInCdi.preparaLista2();
        }
    }



}
