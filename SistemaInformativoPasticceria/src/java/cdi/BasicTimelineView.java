/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.FornitoreFacade;
import entity.Fatturaacquisto;
import entity.Fornitura;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.timeline.TimelineSelectEvent;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

@ManagedBean(name="basicTimelineView")
@ViewScoped
public class BasicTimelineView implements Serializable {  
    
    @EJB
    FornitoreFacade ejbFornitore;
    private TimelineModel model; 
    List<Fatturaacquisto> nuova;
    List<Fatturaacquisto> lf;
    private List<Fornitura> listaF;
   
    private boolean selectable = true;  
    private boolean zoomable = true;  
    private boolean moveable = true;  
    private boolean stackEvents = true;  
    private String eventStyle = "box";  
    private boolean axisOnTop;  
    private boolean showCurrentTime = true;  
    private boolean showNavigation = false;  
   
    @PostConstruct 
    protected void initialize() {  
        model = new TimelineModel();  
   
        Calendar cal = Calendar.getInstance();                   
        cal.set(2014, Calendar.JUNE, 12, 0, 0, 0);  
        model.add(new TimelineEvent("PrimeUI 1.1", cal.getTime()));  
           
          
    }  
    
    public void riempiTimeline() {
        Calendar cal = Calendar.getInstance();
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY",Locale.ITALY);
        listaF = ejbFornitore.getEntityManager().createNamedQuery("Fornitura.findAll").getResultList();
        if(listaF.isEmpty()) {
            System.err.println("IS EMPTY");
        }
        for (Fornitura f : listaF) {
            try {
                f.getData().toString();
                d = sdf.parse(f.getData());
                System.out.println("Stampo la data "+d);
                cal.setTime(d);
                cal.toString();
                System.out.println("cal ");
                model.add(new TimelineEvent("Fornitura N°"+f.getId()+" Tipo "+f.getTipo(),cal.getTime()));
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
          
        }

    }
   
    public void onSelect(TimelineSelectEvent e) {  
        TimelineEvent timelineEvent = e.getTimelineEvent();  
   
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected event:", timelineEvent.getData().toString());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
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
}
