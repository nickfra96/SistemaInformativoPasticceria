/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.DettagliofornituramateriaprimaFacade;
import ejb.FornitoreFacade;
import ejb.FornituraFacade;
import entity.Fatturaacquisto;
import entity.Fornitura;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.Query;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;


@ManagedBean(name="timelineView")
@ViewScoped
public class TimelineView implements Serializable {

    private TimelineModel model;

    private TimelineModel lazyEventModel;

    private TimelineEvent event;

    @EJB
    private FornituraFacade ejbFornitura;

    @EJB
    private DettagliofornituramateriaprimaFacade ejbDettFornMatPrima;

    @EJB
    private FornitoreFacade ejbFornitore;

    @Inject
    FornitoreController fornitoreController;

    public FornitoreController getFornitoreController() {
        return fornitoreController;
    }

    public void setFornitoreController(FornitoreController fornitoreController) {
        this.fornitoreController = fornitoreController;
    }
    private List listaForniture, dettaglioFornitura, nuova;
    private List<Fornitura> listaF;
    private Fornitura fornitura;
    private HashMap<Object, Object> tipiFornitori;
    List<TimelineEvent> listaEvent;

    private boolean selectable = true;
    private boolean zoomable = true;
    private boolean moveable = true;
    private boolean stackEvents = true;
    private String eventStyle = "box";
    private boolean axisOnTop;
    private boolean showCurrentTime = true;
    private boolean showNavigation = false;

    public TimelineView() {
        this.event = new TimelineEvent();
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
        //primefaces
        model = new TimelineModel();
        listaEvent = new ArrayList<TimelineEvent>();
        riempiTimeline();
    }

    public void riempiTimeline() {
        Calendar cal = Calendar.getInstance();
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ITALY);
        listaF = ejbFornitore.getEntityManager().createNamedQuery("Fornitura.findAll").getResultList();
        if(listaF.isEmpty()) {
            System.err.println("IS EMPTY");
        }
        for (Fornitura f : listaF) {
            try {
                System.out.println("getData " +f.getData());
                d = sdf.parse(f.getData());
                System.out.println("Stampo la data "+d);
                cal.setTime(d);
                cal.toString();
                System.out.println("cal ");
                TimelineEvent e = new TimelineEvent(d.getTime(), d);
                listaEvent.add(e);
                model.add(new TimelineEvent("Fornitura N°"+f.getId()+" Tipo "+f.getTipo(),cal.getTime()));
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
    }

    public void onSelect(TimelineSelectEvent e) throws IOException {
        TimelineEvent timelineEvent = e.getTimelineEvent();
        DataModelCdi dmc = new DataModelCdi();
        String s =timelineEvent.getData().toString();
        int start = s.indexOf("°")+1;
        int end = s.indexOf("T")-1;
        int id = Integer.parseInt(s.substring(start,end));

        Query query = ejbFornitore.getEntityManager().createNamedQuery("Fornitura.findById");
        query.setParameter("id", id);
        Fornitura f = (Fornitura) query.getSingleResult();
        String dettfronlink = dmc.vediDettaglioFornitura(f,fornitoreController);
        System.out.println("fornitura "+f);
        model.updateAll(listaEvent);
        FacesContext.getCurrentInstance().getExternalContext().redirect(dettfronlink);
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (TimelineEvent) selectEvent.getObject();
        String tmp = event.getGroup();
        Integer num = Integer.parseInt(tmp.substring(tmp.indexOf('°') + 1, tmp.length()));
        fornitura = (Fornitura)ejbFornitura.getEntityManager().createNamedQuery("Fornitura.findById").setParameter("id", num)
                .getSingleResult();

    }

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

    public List listaForniture() {
        listaForniture = ejbFornitura.getEntityManager().createNamedQuery("Fornitura.findAll").getResultList();
        return listaForniture;
    }
}
