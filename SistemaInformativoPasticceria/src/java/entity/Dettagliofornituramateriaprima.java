/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "dettagliofornituramateriaprima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dettagliofornituramateriaprima.findAll", query = "SELECT d FROM Dettagliofornituramateriaprima d")
    , @NamedQuery(name = "Dettagliofornituramateriaprima.findByQuantita", query = "SELECT d FROM Dettagliofornituramateriaprima d WHERE d.quantita = :quantita")
    , @NamedQuery(name = "Dettagliofornituramateriaprima.findByFornituraId", query = "SELECT d FROM Dettagliofornituramateriaprima d WHERE d.dettagliofornituramateriaprimaPK.fornituraId = :fornituraId")
    , @NamedQuery(name = "Dettagliofornituramateriaprima.findByMateriaprimaCodice", query = "SELECT d FROM Dettagliofornituramateriaprima d WHERE d.dettagliofornituramateriaprimaPK.materiaprimaCodice = :materiaprimaCodice")
    , @NamedQuery(name = "Dettagliofornituramateriaprima.findByPrezzoUnitario", query = "SELECT d FROM Dettagliofornituramateriaprima d WHERE d.prezzoUnitario = :prezzoUnitario")
    //, @NamedQuery(name = "Dettagliofornituramateriaprima.findByUnitaMisura", query = "SELECT d FROM Dettagliofornituramateriaprima d WHERE d.unitaMisura = :unitaMisura")
})
public class Dettagliofornituramateriaprima implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DettagliofornituramateriaprimaPK dettagliofornituramateriaprimaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private double quantita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prezzo_unitario")
    private double prezzoUnitario;
    //@Size(max = 7)
    //@Column(name = "unita_misura")
    //private String unitaMisura;
    @JoinColumn(name = "fornitura_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornitura fornitura;
    @JoinColumn(name = "materiaprima_codice", referencedColumnName = "codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materiaprima materiaprima;

    public Dettagliofornituramateriaprima() {
    }

    public Dettagliofornituramateriaprima(DettagliofornituramateriaprimaPK dettagliofornituramateriaprimaPK) {
        this.dettagliofornituramateriaprimaPK = dettagliofornituramateriaprimaPK;
    }

    public Dettagliofornituramateriaprima(DettagliofornituramateriaprimaPK dettagliofornituramateriaprimaPK, double quantita, double prezzoUnitario) {
        this.dettagliofornituramateriaprimaPK = dettagliofornituramateriaprimaPK;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public Dettagliofornituramateriaprima(int fornituraId, int materiaprimaCodice) {
        this.dettagliofornituramateriaprimaPK = new DettagliofornituramateriaprimaPK(fornituraId, materiaprimaCodice);
    }

    public DettagliofornituramateriaprimaPK getDettagliofornituramateriaprimaPK() {
        return dettagliofornituramateriaprimaPK;
    }

    public void setDettagliofornituramateriaprimaPK(DettagliofornituramateriaprimaPK dettagliofornituramateriaprimaPK) {
        this.dettagliofornituramateriaprimaPK = dettagliofornituramateriaprimaPK;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    /*public String getUnitaMisura() {
        return unitaMisura;
    }

    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }
    */

    public Fornitura getFornitura() {
        return fornitura;
    }

    public void setFornitura(Fornitura fornitura) {
        this.fornitura = fornitura;
    }

    public Materiaprima getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Materiaprima materiaprima) {
        this.materiaprima = materiaprima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dettagliofornituramateriaprimaPK != null ? dettagliofornituramateriaprimaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dettagliofornituramateriaprima)) {
            return false;
        }
        Dettagliofornituramateriaprima other = (Dettagliofornituramateriaprima) object;
        if ((this.dettagliofornituramateriaprimaPK == null && other.dettagliofornituramateriaprimaPK != null) || (this.dettagliofornituramateriaprimaPK != null && !this.dettagliofornituramateriaprimaPK.equals(other.dettagliofornituramateriaprimaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dettagliofornituramateriaprima[ dettagliofornituramateriaprimaPK=" + dettagliofornituramateriaprimaPK + " ]";
    }

}
