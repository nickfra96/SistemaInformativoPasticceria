/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import entity.Dettagliofornituramateriaprima;
import entity.Dettaglioforniturautenza;
import entity.Fatturaacquisto;
import entity.Fornitore;
import entity.Fornitura;
import entity.Magazzinoingresso;
import entity.Materiaprima;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.component.datatable.DataTable;


@ManagedBean(name = "dataModelCdi")
@RequestScoped
public class DataModelCdi implements Serializable {

    @ManagedProperty("#{fornitoreController}")
    private FornitoreController fornitoreCdi;
    private DataTable dataTable;
    private List fornitori, forniture, dettaglioFornitura;
    private Magazzinoingresso materiaInMagazzino;

    public DataModelCdi() {
    }

    public FornitoreController getFornitoreCdi() {
        return fornitoreCdi;
    }

    public void setFornitoreCdi(FornitoreController fornitoreCdi) {
        this.fornitoreCdi = fornitoreCdi;
    }

    public DataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public List getFornitori() {
        return fornitori;
    }

    public void setFornitori(List fornitori) {
        this.fornitori = fornitori;
    }

    public List getForniture() {
        return forniture;
    }

    public void setForniture(List forniture) {
        this.forniture = forniture;
    }

    public List getDettaglioFornitura() {
        return dettaglioFornitura;
    }

    public void setDettaglioFornitura(List dettaglioFornitura) {
        this.dettaglioFornitura = dettaglioFornitura;
    }

    @PostConstruct
    public void init() {
        fornitori = fornitoreCdi.creaListaFornitori();
        // forniture = fornitoreCdi.creaListaForniture();
    }

    public String preparaModifica() {
        fornitoreCdi.setFornitore((Fornitore) dataTable.getRowData());
        return "/fornitore/modifica";
    }

    public String eliminaEvedi() {
        Fornitore f = (Fornitore) dataTable.getRowData();
        fornitoreCdi.setFornitore(f);
        try {
            fornitoreCdi.getEjbFornitore().remove(f);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitore eliminato", f.getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            fornitoreCdi.setFornitore(new Fornitore());
            return "" + fornitoreCdi.preparaLista() /*+ "?faces-redirect=true"*/;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitore non eliminato", f.getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "" + fornitoreCdi.preparaLista() /*+ "?faces-redirect=true"*/;
        }
    }

    public String vediListaForniture() {
        Fornitore f = (Fornitore) dataTable.getRowData();
        System.out.println("vediListaForniture " + f);
        fornitoreCdi.setFornitore(f);
        forniture = fornitoreCdi.creaListaForniture();
        dataTable = new DataTable();

        return "/fornitore/listaForniture";
    }

    public String vediDettaglioFornitura() {
        Fornitura f = (Fornitura) dataTable.getRowData();
        fornitoreCdi.setFornitura(f);
        dataTable = new DataTable();
        if (f.getTipo() == 'M') {
            dettaglioFornitura = fornitoreCdi.creaDettaglioFornitura();
            return "/fornitore/dettaglioFornitura";
        } else if (f.getTipo() == 'E') {
            fornitoreCdi.setDettaglioFornitura(fornitoreCdi.creaDettaglioFornituraUt());
            return "/fornitore/dettaglioFornituraUt";
        } else {
            //DA CONTINUARE CON FORNITORE X
            return "";
        }
    }

    public String vediDettaglioFornitura(Fornitura f, FornitoreController fornitoreCdi) {
        //Fornitura f = (Fornitura) dataTable.getRowData();
        fornitoreCdi.setFornitura(f);
        dataTable = new DataTable();
        System.out.println(" TIPO "+f.getTipo());
        if (f.getTipo() == 'M') {
            dettaglioFornitura = fornitoreCdi.creaDettaglioFornitura();
            return "/GelateriaFortino/faces/fornitore/dettaglioFornitura.xhtml";
        } else if (f.getTipo() == 'E') {
            fornitoreCdi.setDettaglioFornitura(fornitoreCdi.creaDettaglioFornituraUt());
            return "/GelateriaFortino/faces/fornitore/dettaglioFornituraUt.xhtml";
        } else {
            //DA CONTINUARE CON FORNITORE X
            return "";
        }
    }

    private List<Fatturaacquisto> fatture;

    public String vediListaFatture() {

       Fornitore f = (Fornitore) dataTable.getRowData();
        System.out.println("vediListaForniture " + f);
        fornitoreCdi.setFornitore(f);

        List<Fornitura> forn = fornitoreCdi.creaListaForniture();
      dataTable = new DataTable();
         this.fatture = fornitoreCdi.creaListaFattura(forn, f.getPiva());
        System.out.println("Lista fatture" +fatture);

         return "/fornitore/listaFatture";
    }


    public String tornaAListaFornitori() {
        dataTable = new DataTable();
        fornitoreCdi.setListaFiltrata(new ArrayList());
        return fornitoreCdi.preparaLista();
    }

    public String preparaCreaFornitura() {
        dataTable = new DataTable();
        List l = new ArrayList(1);
        fornitoreCdi.setDettaglioFornitura(l);
        Materiaprima m = new Materiaprima();
        Dettagliofornituramateriaprima d = new Dettagliofornituramateriaprima();
        d.setMateriaprima(m);
        Fornitura f = new Fornitura();
        f.setFornitorePiva(new Fornitore());
        d.setFornitura(f);
        fornitoreCdi.getDettaglioFornitura().add(d);
        return fornitoreCdi.preparaCreaFornitura();
    }

    public String preparaModificaFornitura() {
        fornitoreCdi.setFornitura((Fornitura) dataTable.getRowData());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fornitoreCdi.setData(format.parse(fornitoreCdi.getFornitura().getData()));
        } catch (ParseException ex) {
            Logger.getLogger(DataModelCdi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/fornitore/modificaFornitura";
    }

    public String eliminaEVediForniture() {
        Fornitura f = (Fornitura) dataTable.getRowData();
        fornitoreCdi.setFornitura(f);
        try {
            fornitoreCdi.getEjbFornitura().remove(f);
            fornitoreCdi.setFornitura(new Fornitura());
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitura eliminata", "n°" + f.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);

            return "" + fornitoreCdi.preparaListaForniture();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitura non eliminata", "n°" + f.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "" + fornitoreCdi.preparaListaForniture();
        }
    }

    public String preparaListaFatture() {
        dataTable = new DataTable();
        return fornitoreCdi.preparaListaFatture();
    }

    public String preparaModificaDetFornMatPrima() {
        Dettagliofornituramateriaprima x = (Dettagliofornituramateriaprima) dataTable.getRowData();
        fornitoreCdi.setDettFornMatPrima(x);
        fornitoreCdi.setQuantitaPre(x.getQuantita());
        return "/fornitore/modDettFornMatPrima";
    }

    public String preparaEliminaDetFornMatPrima() {
        Dettagliofornituramateriaprima x = (Dettagliofornituramateriaprima) dataTable.getRowData();
        fornitoreCdi.setDettFornMatPrima(x);
        try {
            fornitoreCdi.getEjbDettFornMatPrima().remove(x);
            fornitoreCdi.setDettFornMatPrima(new Dettagliofornituramateriaprima());
            fornitoreCdi.eliminaMagazzino(x);
            fornitoreCdi.eliminaFatturaDaModifica(x);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento eliminato", x.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Elemento non eliminato", x.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return fornitoreCdi.preparaDettaglioFornitura();

    }

    public String preparaModificaDetFornUt() {
        Dettaglioforniturautenza x = (Dettaglioforniturautenza) dataTable.getRowData();
        fornitoreCdi.setDettFornUt(x);
        fornitoreCdi.eliminaFatturaDaModifica(x);
        return "/fornitore/modDettFornUt";
    }

    public String preparaEliminaDetFornUt() {
        Dettaglioforniturautenza x = (Dettaglioforniturautenza) dataTable.getRowData();
        fornitoreCdi.setDettFornUt(x);
        try {
            fornitoreCdi.getEjbDettFornUt().remove(x);
            fornitoreCdi.setDettFornUt(new Dettaglioforniturautenza());
            fornitoreCdi.eliminaFatturaDaModificaUt(x);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento eliminato", x.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento non eliminato", x.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return fornitoreCdi.preparaDettaglioFornituraUt();

    }

    public void infoMateriaprima() {
        Dettagliofornituramateriaprima d = (Dettagliofornituramateriaprima) dataTable.getRowData();
        Magazzinoingresso m = fornitoreCdi.getEjbMagazzinoin().findByMateriaprimaCodice(d.getMateriaprima());
        fornitoreCdi.setElementoMagazzino(m);
    }

    public void trovaFattura() {
        Fornitura f = (Fornitura) dataTable.getRowData();
        Fatturaacquisto fat = fornitoreCdi.getEjbFatturaacquisto().findByNumeroFornitura(f);
        fornitoreCdi.setFattura(fat);
        fornitoreCdi.setFornitura(f);
    }

        public String crea() {
        try {
            fornitoreCdi.getEjbFornitore().crea(fornitoreCdi.getFornitore());
            dataTable = new DataTable();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitore creato", fornitoreCdi.getFornitore().getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return fornitoreCdi.preparaLista();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitore non creato", fornitoreCdi.getFornitore().getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            dataTable = new DataTable();
            return fornitoreCdi.preparaLista();
        }
    }
}
