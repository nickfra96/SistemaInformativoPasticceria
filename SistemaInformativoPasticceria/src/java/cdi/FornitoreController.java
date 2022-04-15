/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.DettagliofornituramateriaprimaFacade;
import ejb.DettaglioforniturautenzaFacade;
import ejb.FatturaacquistoFacade;
import ejb.FornitoreFacade;
import ejb.FornituraFacade;
import ejb.MagazzinoingressoFacade;
import ejb.MateriaprimaFacade;
import ejb.UtenzaFacade;
import entity.Dettagliofornituramateriaprima;
import entity.DettagliofornituramateriaprimaPK;
import entity.Dettaglioforniturautenza;
import entity.DettaglioforniturautenzaPK;
import entity.Fatturaacquisto;
import entity.Fornitore;
import entity.Fornitura;
import entity.Magazzinoingresso;
import entity.Materiaprima;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import org.primefaces.component.datatable.DataTable;
import util.OpzioniSelezionabili;
import java.util.Iterator;
import java.util.Locale;
import javax.persistence.Query;
import org.primefaces.event.timeline.TimelineModificationEvent;
import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;


@Named(value = "fornitoreController")
@SessionScoped
public class FornitoreController implements Serializable {

    Fornitore fornitore;
    Fornitura fornitura;
    Dettagliofornituramateriaprima dettFornMatPrima;
    Fatturaacquisto fattura;
    Magazzinoingresso elementoMagazzino;
    @EJB
    FornitoreFacade ejbFornitore;
    @EJB
    FornituraFacade ejbFornitura;
    @EJB
    DettagliofornituramateriaprimaFacade ejbDettFornMatPrima;
    @EJB
    DettaglioforniturautenzaFacade ejbDettFornUt;
    @EJB
    MateriaprimaFacade ejbMateriaprima;
    @EJB
    FatturaacquistoFacade ejbFatturaacquisto;
    @EJB
    MagazzinoingressoFacade ejbMagazzinoin;
    @EJB
    UtenzaFacade ejbUtenza;
    @EJB
    private MagazzinoingressoFacade ejbMagazzinoIn;
    private MagazzinoInController magazzinoInCdi;
    private DataTable dataTable;
    DataTable dataTableFornitori;
    List listaFornitori, listaForniture, dettaglioFornitura, listaMatPrime, listaFatture, listaFiltrata, magazzinoIn;
    Date data = new Date();
    String minDate, maxDate;
    Double quantitaPre;
    OpzioniSelezionabili selectOpt = new OpzioniSelezionabili();
    private HashMap<Object, Object> tipiFornitori;
    private Dettaglioforniturautenza dettFornUt;
    private List listaUtenze, statoFatture;
    List<Fatturaacquisto> nuova;
    List<Fatturaacquisto> lf;
    //A seguire cose di primefaces
    private TimelineModel model;
    List<TimelineEvent> listaEvent;

    private boolean selectable = true;
    private boolean zoomable = true;
    private boolean moveable = true;
    private boolean stackEvents = true;
    private String eventStyle = "box";
    private boolean axisOnTop;
    private boolean showCurrentTime = true;
    private boolean showNavigation = false;
    private List<Fornitura> listaF;

    public FornitoreController() {

    }

    @PostConstruct
    public void init() {

        tipiFornitori = new HashMap<>();
        nuova = new ArrayList<Fatturaacquisto>();
        Character[] k = {'X', 'E', 'M'};
        String[] v = {"Altro", "Utenza", "Materia Prima"};
        for (int i = 0; i < k.length; i++) {
            tipiFornitori.put(v[i], k[i]);
        }
        System.out.println(tipiFornitori);

    }

    //sempre primefaces
    public TimelineModel getModel() {
        return model;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isZoomable() {
        return zoomable;
    }

    public void setZoomable(boolean zoomable) {
        this.zoomable = zoomable;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    public boolean isStackEvents() {
        return stackEvents;
    }

    public void setStackEvents(boolean stackEvents) {
        this.stackEvents = stackEvents;
    }

    public String getEventStyle() {
        return eventStyle;
    }

    public void setEventStyle(String eventStyle) {
        this.eventStyle = eventStyle;
    }

    public boolean isAxisOnTop() {
        return axisOnTop;
    }

    public void setAxisOnTop(boolean axisOnTop) {
        this.axisOnTop = axisOnTop;
    }

    public boolean isShowCurrentTime() {
        return showCurrentTime;
    }

    public void setShowCurrentTime(boolean showCurrentTime) {
        this.showCurrentTime = showCurrentTime;
    }

    public boolean isShowNavigation() {
        return showNavigation;
    }

    public void setShowNavigation(boolean showNavigation) {
        this.showNavigation = showNavigation;
    }
    //fine primefaces

    public List<Fatturaacquisto> getNuova() {
        return nuova;
    }

    public void setNuova(List<Fatturaacquisto> nuova) {
        this.nuova = nuova;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    public HashMap<Object, Object> getTipiFornitori() {
        return tipiFornitori;
    }

    public void setTipiFornitori(HashMap<Object, Object> tipiFornitori) {
        this.tipiFornitori = tipiFornitori;
    }

    public Magazzinoingresso getElementoMagazzino() {
        return elementoMagazzino;
    }

    public void setElementoMagazzino(Magazzinoingresso elementoMagazzino) {
        this.elementoMagazzino = elementoMagazzino;
    }

    public Double getQuantitaPre() {
        return quantitaPre;
    }

    public void setQuantitaPre(Double quantitaPre) {
        this.quantitaPre = quantitaPre;
    }

    public OpzioniSelezionabili getSelectOpt() {
        return selectOpt;
    }

    public void setSelectOpt(OpzioniSelezionabili selectOpt) {
        this.selectOpt = selectOpt;
    }

    public List getListaFiltrata() {
        System.out.println("LISTA FILTRATA>>>>>>>>>><" + listaFiltrata);
        return listaFiltrata;
    }

    public void setListaFiltrata(List listaFiltrata) {
        this.listaFiltrata = listaFiltrata;
    }

    public Fornitura getFornitura() {
        return fornitura;
    }

    public void setFornitura(Fornitura fornitura) {
        this.fornitura = fornitura;
    }

    public FornitoreFacade getEjbFornitore() {
        return ejbFornitore;
    }

    public void setEjbFornitore(FornitoreFacade ejbFornitore) {
        this.ejbFornitore = ejbFornitore;
    }

    public DataTable getDataTableFornitori() {
        return dataTableFornitori;
    }

    public void setDataTableFornitori(DataTable dataTableFornitori) {
        this.dataTableFornitori = dataTableFornitori;
    }

    public FornituraFacade getEjbFornitura() {
        return ejbFornitura;
    }

    public void setEjbFornitura(FornituraFacade ejbFornitura) {
        this.ejbFornitura = ejbFornitura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List getListaFornitori() {
        System.out.println("Lista Fornitori>>>>>" + listaFornitori);
        return listaFornitori;
    }

    public void setListaFornitori(List listaFornitori) {
        this.listaFornitori = listaFornitori;
    }

    public FatturaacquistoFacade getEjbFatturaacquisto() {
        return ejbFatturaacquisto;
    }

    public void setEjbFatturaacquisto(FatturaacquistoFacade ejbFatturaacquisto) {
        this.ejbFatturaacquisto = ejbFatturaacquisto;
    }

    public MagazzinoingressoFacade getEjbMagazzinoin() {
        return ejbMagazzinoin;
    }

    public void setEjbMagazzinoin(MagazzinoingressoFacade ejbMagazzinoin) {
        this.ejbMagazzinoin = ejbMagazzinoin;
    }

    public List getListaFatture() {
        return listaFatture;
    }

    public void setListaFatture(List listaFatture) {
        this.listaFatture = listaFatture;
    }

    public List getListaForniture() {
        return listaForniture;
    }

    public void setListaForniture(List listaForniture) {
        this.listaForniture = listaForniture;
    }

    public Fatturaacquisto getFattura() {
        return fattura;
    }

    public void setFattura(Fatturaacquisto fattura) {
        this.fattura = fattura;
    }

    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(String minDate) {
        this.minDate = minDate;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public List getDettaglioFornitura() {
        return dettaglioFornitura;
    }

    public void setDettaglioFornitura(List dettaglioFornitura) {
        this.dettaglioFornitura = dettaglioFornitura;
    }

    public DettaglioforniturautenzaFacade getEjbDettFornUt() {
        return ejbDettFornUt;
    }

    public void setEjbDettFornUt(DettaglioforniturautenzaFacade ejbDettFornUt) {
        this.ejbDettFornUt = ejbDettFornUt;
    }

    public Dettaglioforniturautenza getDettFornUt() {
        return dettFornUt;
    }

    public void setDettFornUt(Dettaglioforniturautenza dettFornUt) {
        this.dettFornUt = dettFornUt;
    }

    public UtenzaFacade getEjbUtenza() {
        return ejbUtenza;
    }

    public void setEjbUtenza(UtenzaFacade ejbUtenza) {
        this.ejbUtenza = ejbUtenza;
    }

    public List getListaUtenze() {
        return listaUtenze;
    }

    public void setListaUtenze(List listaUtenze) {
        this.listaUtenze = listaUtenze;
    }

    public Dettagliofornituramateriaprima getDettFornMatPrima() {
        return dettFornMatPrima;
    }

    public void setDettFornMatPrima(Dettagliofornituramateriaprima dettFornMatPrima) {
        this.dettFornMatPrima = dettFornMatPrima;
    }

    public List getStatoFatture() {
        return statoFatture;
    }

    public void setStatoFatture(List statoFatture) {
        this.statoFatture = statoFatture;
    }

    public DettagliofornituramateriaprimaFacade getEjbDettFornMatPrima() {
        return ejbDettFornMatPrima;
    }

    public void setEjbDettFornMatPrima(DettagliofornituramateriaprimaFacade ejbDettFornMatPrima) {
        this.ejbDettFornMatPrima = ejbDettFornMatPrima;
    }

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

    public List creaListaFornitori() {
        return ejbFornitore.getEntityManager().createNamedQuery("Fornitore.findAll").getResultList();
    }

    public String preparaLista() {
        listaFornitori = creaListaFornitori();
        return "/fornitore/lista";
    }

    public String preparaListaForniture() {
        listaForniture = creaListaForniture();
        System.out.println(listaForniture);
        return "/fornitore/listaForniture";
    }

    public String preparaListaDettFornMatPrima() {
        dettaglioFornitura = ejbDettFornMatPrima.getEntityManager()
                .createQuery("SELECT d FROM Dettagliofornituramateriaprima d WHERE d.fornitura = :f")
                .setParameter("f", fornitura).getResultList();
        return "/fornitore/dettaglioFornitura";
    }

    public String modifica() {
        try {
            ejbFornitore.modifica(fornitore);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitore modificato", fornitore.getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/lista";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitore non modificato", fornitore.getNome());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/lista";
        }
    }

    public String preparaCrea() {
        fornitore = new Fornitore();
        return "/fornitore/crea";
    }

    public List creaListaForniture() {
        listaForniture = ejbFornitura.getEntityManager()
                .createQuery("SELECT fo FROM Fornitura FO WHERE FO.fornitorePiva = :f").setParameter("f", fornitore)
                .getResultList();
        return listaForniture;
    }

    public List creaDettaglioFornitura() {
        dettaglioFornitura = ejbDettFornMatPrima.getEntityManager()
                .createNamedQuery("Dettagliofornituramateriaprima.findByFornituraId")
                .setParameter("fornituraId", fornitura.getId()).getResultList();
        return dettaglioFornitura;
    }

    public List creaDettaglioFornituraUt() {
        dettaglioFornitura = ejbDettFornUt.getEntityManager()
                .createNamedQuery("Dettaglioforniturautenza.findByFornituraId")
                .setParameter("fornituraId", fornitura.getId()).getResultList();
        return dettaglioFornitura;
    }

    public String preparaCreaFornitura() {
        fornitura = new Fornitura();
        fornitura.setTipo(fornitore.getTipo());
        fornitura.setFornitorePiva(fornitore);
        return "/fornitore/creaFornitura";
    }

    public String creaFornitura() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            fornitura.setData(format.format(data));
            data = new Date();
            ejbFornitura.create(fornitura);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitura creata", "n° " + fornitura.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaListaForniture();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitura non creata", fornitura.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaListaForniture();
        }
    }

    public List<Fatturaacquisto> creaListaFattura(List<Fornitura> fornitureN, String pIva) {
        System.out.println("forniture " + fornitureN);
        lf = ejbDettFornMatPrima.getEntityManager().createNamedQuery("Fatturaacquisto.findAll", Fatturaacquisto.class).getResultList();
        System.out.println("fatture" + lf);

        Iterator<Fornitura> iterf = fornitureN.iterator();
        Iterator<Fatturaacquisto> ifor = lf.iterator();
        nuova.clear();

        for (Fatturaacquisto facq : lf) {
            for (Fornitura fornitu : fornitureN) {

                if (facq.getFornituraId().intValue() == fornitu.getId().intValue() && fornitu.getFornitorePiva().getPiva().equals(pIva)) {
                    if (!nuova.contains(facq)) {
                        nuova.add(facq);
                        System.out.println("ho aggiunto " + facq + "da nuova");
                    }
                }
            }

        }
        System.out.println("nuova " + nuova);
        return nuova;
    }

    public String modificaFornitura() {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            fornitura.setData(format.format(data));
            ejbFornitura.modifica(fornitura);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fornitura modificata", "n° " + fornitura.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/listaForniture";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitura non modificata", "n° " + fornitura.getId());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/listaForniture";
        }
    }

    public String preparaCreaDettFornMatPrima() {
        System.out.println("SONO QUA");
        dettFornMatPrima = new Dettagliofornituramateriaprima();
        System.out.println("ID fornitura" + fornitura.getId());
        dettFornMatPrima.setFornitura(fornitura);
        listaMatPrime = ejbMateriaprima.getEntityManager().createNamedQuery("Materiaprima.findAll").getResultList();
        System.out.println("dettagliofornitura " + dettFornMatPrima.getFornitura());
        return "/fornitore/creaDettFornMatPrima";
    }

    public String creaDettFornMatPrima() {
        System.out.println("SONO QUA");
        System.out.println("Mi chiamo DettFormMatPrima: " + dettFornMatPrima.getFornitura().getId());
        try {
            DettagliofornituramateriaprimaPK x = new DettagliofornituramateriaprimaPK();
            x.setFornituraId(dettFornMatPrima.getFornitura().getId());
            x.setMateriaprimaCodice(dettFornMatPrima.getMateriaprima().getCodice());
            System.out.println("id " + x.getFornituraId() + " codice " + x.getMateriaprimaCodice());
            dettFornMatPrima.setDettagliofornituramateriaprimaPK(x);
            System.out.println("Mi chiamo DettFormMatPrima2: " + dettFornMatPrima.getFornitura().getId());
            ejbDettFornMatPrima.create(dettFornMatPrima);
            aggiornaMagazzino(dettFornMatPrima);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiunto elemento " + dettFornMatPrima.getMateriaprima().getDescrizione(), dettFornMatPrima.getFornitura().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaDettaglioFornitura();
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento " + dettFornMatPrima.getMateriaprima().getDescrizione() + " non aggiunto", dettFornMatPrima.getFornitura().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaDettaglioFornitura();
        }
    }

    public String preparaDettaglioFornitura() {
        dettaglioFornitura = creaDettaglioFornitura();
        return "/fornitore/dettaglioFornitura";
    }

    public String preparaDettaglioFornituraUt() {
        dettaglioFornitura = creaDettaglioFornituraUt();
        return "/fornitore/dettaglioFornituraUt";
    }

    private void aggiornaMagazzino(Dettagliofornituramateriaprima d) {
        Magazzinoingresso m = ejbMagazzinoin.findByMateriaprimaCodice(d.getMateriaprima());
        if (m == null) {
            m = new Magazzinoingresso();
            m.setMateriaprima(d.getMateriaprima());
            m.setMateriaprimaCodice(d.getDettagliofornituramateriaprimaPK().getMateriaprimaCodice());
            m.setQuantita(d.getQuantita());
            ejbMagazzinoin.create(m);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiunta materia prima in magazzino ", m.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            double qta = m.getQuantita();
            System.out.println("Quantità in magazzino----------------->" + qta);
            System.out.println("Quantità da aggiungere------------->" + d.getQuantita());
            qta += d.getQuantita();
            m.setQuantita(qta);
            System.out.println("Quantità totale---------------------->" + qta);
            ejbMagazzinoin.modifica(m);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiornata materia prima in magazzino ", m.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String preparaCreaFattura() {
        System.out.println("ID fornitura--------->" + fornitura.getId());
        if (ejbFatturaacquisto.findByNumeroFornitura(fornitura) == null) {
            System.out.println("ramo TRUE");
            fattura = new Fatturaacquisto();
            fattura.setFornituraId(fornitura.getId());
            System.out.println("Fornitura ID---------------->" + fornitura.getId());
            fattura.setTipo(fornitura.getTipo().toString());
            fattura.setData(fornitura.getData());
            System.out.println("data presa dalla fornitura-------------> " + fornitura.getData());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                data = format.parse(fattura.getData());
            } catch (ParseException ex) {

            }
            SimpleDateFormat farmat = new SimpleDateFormat("dd/MM/yy");
            GregorianCalendar min = new GregorianCalendar();
            min.setTime(data);
            System.out.println("stampa la data settata------------->" + data);
            min.add(Calendar.DATE, -1);
            GregorianCalendar max = new GregorianCalendar();
            max.setTime(data);
            max.add(Calendar.DATE, +10);
            minDate = farmat.format(min.getTime());
            System.out.println("data antecedente------------> " + minDate);
            maxDate = farmat.format(max.getTime());
            System.out.println("data successiva alla fornitura--------> " + maxDate);
            fattura.setAnno(min.get(Calendar.YEAR));
            /*List<Dettagliofornituramateriaprima> l = ejbDettFornMatPrima.getEntityManager().createNamedQuery("Dettaglioforniturautenza.findByFornituraId")
                .setParameter("fornituraId", fornitura.getId()).getResultList();*/
            double importo = 0;
            for (Object x : dettaglioFornitura) {
                Dettagliofornituramateriaprima d = (Dettagliofornituramateriaprima) x;
                double daAgg = d.getQuantita() * d.getPrezzoUnitario();
                System.out.println("Importo da aggiungere------------------->" + daAgg);
                importo += daAgg;
                System.out.println("Importo aggiornato---------------->" + importo);
            }
            BigDecimal bd = new BigDecimal(importo).setScale(2, BigDecimal.ROUND_UP);
            fattura.setImporto(bd.doubleValue());
            return "/fornitore/creaFattura";
        } else {
            System.out.println("ramo FALSE");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fattura già registrata per la fornitura ", fornitura.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/dettaglioFornitura";
        }
    }

    public String mioPreparaCreaFattura(){
        System.out.println("Sono in mioPreparaCreaFattura");
        int id  = fornitura.getId();
        System.out.println("STAMPA DELL'ID: "+id);
        List<Dettagliofornituramateriaprima> listadfmp = ejbDettFornMatPrima.getEntityManager().createNamedQuery("Dettagliofornituramateriaprima.findByFornituraId",Dettagliofornituramateriaprima.class).setParameter("fornituraId", id).getResultList();
        for(Dettagliofornituramateriaprima d : listadfmp){
            if(d.getFornitura().getFornitorePiva().getPiva() != fornitura.getFornitorePiva().getPiva())
                            listadfmp.remove(d);
                }

        if (ejbFatturaacquisto.findByNumeroFornitura(fornitura) == null) {
            fattura = new Fatturaacquisto();
            fattura.setFornituraId(fornitura.getId());
            fattura.setTipo(fornitura.getTipo().toString());
            fattura.setData(fornitura.getData());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                data = format.parse(fattura.getData());
            } catch (ParseException ex) {}
                SimpleDateFormat farmat = new SimpleDateFormat("dd/MM/yy");
            GregorianCalendar min = new GregorianCalendar();
            min.setTime(data);
            min.add(Calendar.DATE, -1);
            GregorianCalendar max = new GregorianCalendar();
            max.setTime(data);
            max.add(Calendar.DATE, +10);
            minDate = farmat.format(min.getTime());
            maxDate = farmat.format(max.getTime());
            fattura.setAnno(min.get(Calendar.YEAR));
            double importo = 0;
            for(Dettagliofornituramateriaprima dm : listadfmp ){
                importo += dm.getPrezzoUnitario() * dm.getQuantita();
           }
            fattura.setImporto(importo);
            return "/fornitore/creaFattura";
            }
         else {
            System.out.println("ramo FALSE");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fattura già registrata per la fornitura ", fornitura.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/dettaglioFornitura";
        }
    }

    public String preparaListaFatture() {
        ejbFatturaacquisto.create(fattura);
        List<Fornitura> x = ejbFornitura.findByFornitore(fornitore);
        System.out.println(x);
        List l = new ArrayList();
        for (Fornitura f : x) {
            l.add(f.getId());
        }
        listaFatture = ejbFatturaacquisto.getEntityManager()
                .createQuery("SELECT FA FROM Fatturaacquisto FA WHERE FA.fornituraId IN :list")
                .setParameter("list", l).getResultList();
        System.out.println(listaFatture);
        return "/fornitore/listaForniture";
    }

    public String modificaDetFornMatPrima() {
        try {
            ejbDettFornMatPrima.modifica(dettFornMatPrima);
            modificaMagazzino(dettFornMatPrima);
            eliminaFatturaDaModifica(dettFornMatPrima);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dati fornitura modificati", dettFornMatPrima.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dati fornitura non modificati", dettFornMatPrima.getMateriaprima().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "/fornitore/dettaglioFornitura";
    }

    private void modificaMagazzino(Dettagliofornituramateriaprima d) {
        Magazzinoingresso m = ejbMagazzinoin.findByMateriaprimaCodice(d.getMateriaprima());
        m.setQuantita(m.getQuantita() + (d.getQuantita() - quantitaPre));
        ejbMagazzinoin.modifica(m);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiornata materia prima in magazzino ", m.getMateriaprima().getDescrizione());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    protected void eliminaFatturaDaModifica(Dettagliofornituramateriaprima d) {
        Fatturaacquisto f = ejbFatturaacquisto.findByNumeroFornitura(d.getFornitura());
        if (f != null) {
            ejbFatturaacquisto.remove(f);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminata Fattura", f.getFornituraId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    protected void eliminaFatturaDaModifica(Dettaglioforniturautenza d) {
        Fatturaacquisto f = ejbFatturaacquisto.findByNumeroFornitura(d.getFornitura());
        if (f != null) {
            ejbFatturaacquisto.remove(f);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminata Fattura", f.getFornituraId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    protected void eliminaFatturaDaModificaUt(Dettaglioforniturautenza d) {
        Fatturaacquisto f = ejbFatturaacquisto.findByNumeroFornitura(d.getFornitura());
        if (f != null) {
            ejbFatturaacquisto.remove(f);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminata Fattura", f.getFornituraId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    protected void eliminaMagazzino(Dettagliofornituramateriaprima d) {
        Magazzinoingresso m = ejbMagazzinoin.findByMateriaprimaCodice(d.getMateriaprima());
        m.setQuantita(m.getQuantita() - d.getQuantita());
        ejbMagazzinoin.modifica(m);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiornata materia prima in magazzino ", m.getMateriaprima().getDescrizione());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String preparaCreaDettFornUt() {
        dettFornUt = new Dettaglioforniturautenza();
        dettFornUt.setFornitura(fornitura);
        listaUtenze = ejbUtenza.getEntityManager().createNamedQuery("Utenza.findAll").getResultList();
        return "/fornitore/creaDettFornUt";
    }

    public String creaDettFornUt() {
        try {
            DettaglioforniturautenzaPK x = new DettaglioforniturautenzaPK();
            x.setFornituraId(dettFornUt.getFornitura().getId());
            x.setUtenzaCodice(dettFornUt.getUtenza().getCodice());
            dettFornUt.setDettaglioforniturautenzaPK(x);
            ejbDettFornUt.create(dettFornUt);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aggiunto utenza " + dettFornUt.getUtenza().getDescrizione(), dettFornUt.getFornitura().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaDettaglioFornituraUt();
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Utenza " + dettFornUt.getUtenza().getDescrizione() + " non aggiunto", dettFornUt.getFornitura().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return preparaDettaglioFornituraUt();
        }
    }

    public String modificaDettFornUt() {
        try {
            ejbDettFornUt.modifica(dettFornUt);
            eliminaFatturaDaModifica(dettFornMatPrima);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dati fornitura modificati", dettFornUt.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dati fornitura non modificati", dettFornUt.getUtenza().getDescrizione());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "/fornitore/dettaglioFornituraUt";
    }

    public String preparaCreaFatturaUt() {
        if (ejbFatturaacquisto.findByNumeroFornitura(fornitura) == null) {
            fattura = new Fatturaacquisto();
            fattura.setFornituraId(fornitura.getId());
            System.out.println("Fornitura ID---------------->" + fornitura.getId());
            fattura.setTipo(fornitura.getTipo().toString());
            fattura.setData(fornitura.getData());
            System.out.println("data presa dalla fornitura-------------> " + fornitura.getData());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                data = format.parse(fattura.getData());
            } catch (ParseException ex) {

            }
            SimpleDateFormat farmat = new SimpleDateFormat("dd/MM/yy");
            GregorianCalendar min = new GregorianCalendar();
            min.setTime(data);
            System.out.println("stampa la data settata------------->" + data);
            min.add(Calendar.DATE, -1);
            GregorianCalendar max = new GregorianCalendar();
            max.setTime(data);
            max.add(Calendar.DATE, +10);
            minDate = farmat.format(min.getTime());
            System.out.println("data antecedente------------> " + minDate);
            maxDate = farmat.format(max.getTime());
            System.out.println("data successiva alla fornitura--------> " + maxDate);
            fattura.setAnno(min.get(Calendar.YEAR));
            /*List<Dettagliofornituramateriaprima> l = ejbDettFornMatPrima.getEntityManager().createNamedQuery("Dettaglioforniturautenza.findByFornituraId")
                .setParameter("fornituraId", fornitura.getId()).getResultList();*/
            double importo = 0;
            for (Object x : dettaglioFornitura) {
                Dettaglioforniturautenza d = (Dettaglioforniturautenza) x;
                double daAgg = d.getQuantita() * d.getPrezzoUnitario();
                System.out.println("Importo da aggiungere------------------->" + daAgg);
                importo += daAgg;
                System.out.println("Importo aggiornato---------------->" + importo);
            }
            BigDecimal bd = new BigDecimal(importo).setScale(2, BigDecimal.ROUND_UP);
            fattura.setImporto(bd.doubleValue());
            return "/fornitore/creaFattura";
        } else {
            System.out.println("ramo FALSE");
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fattura già registrata per la fornitura ", fornitura.getId().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "/fornitore/dettaglioFornituraUt";
        }
    }

    public boolean esisteFattura(Fornitura f) {
        return getEjbFatturaacquisto().findByNumeroFornitura(f) != null;
    }

    public String preparaCreaFatturaDaListaForniture() {
        fattura = new Fatturaacquisto();
        fattura.setFornituraId(fornitura.getId());
        System.out.println("Fornitura ID---------------->" + fornitura.getId());
        fattura.setTipo(fornitura.getTipo().toString());
        fattura.setData(fornitura.getData());
        System.out.println("data presa dalla fornitura-------------> " + fornitura.getData());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = format.parse(fattura.getData());
        } catch (ParseException ex) {

        }
        SimpleDateFormat farmat = new SimpleDateFormat("dd/MM/yy");
        GregorianCalendar min = new GregorianCalendar();
        min.setTime(data);
        System.out.println("stampa la data settata------------->" + data);
        min.add(Calendar.DATE, -1);
        GregorianCalendar max = new GregorianCalendar();
        max.setTime(data);
        max.add(Calendar.DATE, +10);
        minDate = farmat.format(min.getTime());
        System.out.println("data antecedente------------> " + minDate);
        maxDate = farmat.format(max.getTime());
        System.out.println("data successiva alla fornitura--------> " + maxDate);
        fattura.setAnno(min.get(Calendar.YEAR));
        if (fornitura.getTipo() == 'M') {
            dettaglioFornitura = ejbDettFornMatPrima.findDettaglioByFornitura(fornitura);
            if (dettaglioFornitura.isEmpty()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitura n°" + fornitura.getId() + " vuota", "Aggiungere prima qualche elemento");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/fornitore/listaForniture";
            }
            double importo = 0;
            for (Object x : dettaglioFornitura) {
                Dettagliofornituramateriaprima d = (Dettagliofornituramateriaprima) x;
                double daAgg = d.getQuantita() * d.getPrezzoUnitario();
                System.out.println("Importo da aggiungere------------------->" + daAgg);
                importo += daAgg;
                System.out.println("Importo aggiornato---------------->" + importo);
            }
            BigDecimal bd = new BigDecimal(importo).setScale(2, BigDecimal.ROUND_UP);
            fattura.setImporto(bd.doubleValue());
            return "/fornitore/creaFattura";
        } else if (fornitura.getTipo() == 'E') {
            dettaglioFornitura = ejbDettFornUt.dettaglioByFornitura(fornitura);
            if (dettaglioFornitura.isEmpty()) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fornitura n°" + fornitura.getId() + " vuota", "Aggiungere prima qualche elemento");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/fornitore/listaForniture";
            }
            double importo = 0;
            for (Object x : dettaglioFornitura) {
                Dettaglioforniturautenza d = (Dettaglioforniturautenza) x;
                double daAgg = d.getQuantita() * d.getPrezzoUnitario();
                System.out.println("Importo da aggiungere------------------->" + daAgg);
                importo += daAgg;
                System.out.println("Importo aggiornato---------------->" + importo);
            }
            BigDecimal bd = new BigDecimal(importo).setScale(2, BigDecimal.ROUND_UP);
            fattura.setImporto(bd.doubleValue());
            return "/fornitore/creaFattura";
        } else {
            //Parte per fornitore x
            return "";
        }
    }


}
