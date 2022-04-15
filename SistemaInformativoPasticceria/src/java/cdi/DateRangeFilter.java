/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;


@Named(value = "dateRangeFilter")
@SessionScoped
public class DateRangeFilter implements Serializable {

    private static final Logger LOG = Logger.getLogger(DateRangeFilter.class.getName());

    public boolean filterByDate(Object value, Object filter, Locale locale) {

        System.out.println("Entra con valori:\nvalue= " + value + "\nfilter= " + filter);

        String filterText = (filter == null) ? null : filter.toString().trim();
        System.out.println("filterText= " + filterText);
        if (filterText == null || filterText.isEmpty()) {
            System.out.println("ramo true");
            return true;
        }
        if (value == null) {
            System.out.println("ramo false");
            return false;
        }

        DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date filterDate = null;
        System.out.println("Lunghezza value= " + ((String) value).length());
        String s = ((String) value).trim();
        System.out.println("Lunghezza s= " + s.length());
        try {
            filterDate = sdf.parse(s);
        } catch (ParseException ex) {
            Logger.getLogger(DateRangeFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dateFrom;
        Date dateTo;
        try {
            String fromPart = filterText.substring(0, filterText.indexOf("-") - 1);
            String toPart = filterText.substring(filterText.indexOf("-") + 1);
            dateFrom = fromPart.isEmpty() ? null : sdf.parse(fromPart);
            if (toPart.isEmpty()) {
                dateTo = null;
            } else {
                dateTo = sdf.parse(toPart);
                dateTo = toPart.isEmpty() ? null : (sdf.parse(toPart));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(dateTo);
                gc.add(Calendar.DAY_OF_MONTH, 1);
                dateTo = gc.getTime();
            }
        } catch (ParseException pe) {
            LOG.log(Level.SEVERE, "unable to parse date: " + filterText, pe);
            return false;
        }

        return (dateFrom == null || filterDate.after(dateFrom)) && (dateTo == null || filterDate.before(dateTo));
    }
}
