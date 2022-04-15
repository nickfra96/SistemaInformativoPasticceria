/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import cdi.FornitoreController;
import cdi.MateriaprimaController;
import ejb.AbstractFacade;
import ejb.MateriaprimaFacade;
import entity.Materiaprima;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "materiaprimaConverter")
public class MateriaprimaConverter implements Converter {

    @EJB
    private MateriaprimaFacade ejbMateriaprima;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        System.out.println(value);
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String dbName = "fortino?useSSL=false";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "inkoming";

            Materiaprima m = new Materiaprima();
            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url + dbName, userName, password);
                Statement st = conn.createStatement();
                String query = "SELECT * FROM materiaprima WHERE codice= " + value;
                ResultSet res = st.executeQuery(query);
                while (res.next()) {
                    m.setCodice(res.getInt("codice"));
                    m.setDescrizione(res.getString("descrizione"));
                }
                res.close();
                st.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(m);
            return m;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, value, "Non e' un codice corretto"), e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
             Object value
    ) {
        if (value == null) {
            return "";
        }
        if (value instanceof Materiaprima) {
            return String.valueOf(((Materiaprima) value).getCodice());
        } else {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, value.toString(), "Non e' un codice corretto"));
        }
    }

}
