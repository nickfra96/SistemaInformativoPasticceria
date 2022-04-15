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
@Table(name = "dettaglioforniturautenza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dettaglioforniturautenza.findAll", query = "SELECT d FROM Dettaglioforniturautenza d")
    , @NamedQuery(name = "Dettaglioforniturautenza.findByFornituraId", query = "SELECT d FROM Dettaglioforniturautenza d WHERE d.dettaglioforniturautenzaPK.fornituraId = :fornituraId")
    , @NamedQuery(name = "Dettaglioforniturautenza.findByUtenzaCodice", query = "SELECT d FROM Dettaglioforniturautenza d WHERE d.dettaglioforniturautenzaPK.utenzaCodice = :utenzaCodice")
    , @NamedQuery(name = "Dettaglioforniturautenza.findByQuantita", query = "SELECT d FROM Dettaglioforniturautenza d WHERE d.quantita = :quantita")
    , @NamedQuery(name = "Dettaglioforniturautenza.findByPrezzoUnitario", query = "SELECT d FROM Dettaglioforniturautenza d WHERE d.prezzoUnitario = :prezzoUnitario")})
    //, @NamedQuery(name = "Dettaglioforniturautenza.findByUnitaMisura", query = "SELECT d FROM Dettaglioforniturautenza d WHERE d.unitaMisura = :unitaMisura")})
public class Dettaglioforniturautenza implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DettaglioforniturautenzaPK dettaglioforniturautenzaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private double quantita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prezzo_unitario")
    private double prezzoUnitario;
    /*@Size(max = 7)
    @Column(name = "unita_misura")
    private String unitaMisura;
    */
    @JoinColumn(name = "fornitura_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornitura fornitura;
    @JoinColumn(name = "utenza_codice", referencedColumnName = "codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utenza utenza;

    public Dettaglioforniturautenza() {
    }

    public Dettaglioforniturautenza(DettaglioforniturautenzaPK dettaglioforniturautenzaPK) {
        this.dettaglioforniturautenzaPK = dettaglioforniturautenzaPK;
    }

    public Dettaglioforniturautenza(DettaglioforniturautenzaPK dettaglioforniturautenzaPK, double quantita, double prezzoUnitario) {
        this.dettaglioforniturautenzaPK = dettaglioforniturautenzaPK;
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public Dettaglioforniturautenza(int fornituraId, int utenzaCodice) {
        this.dettaglioforniturautenzaPK = new DettaglioforniturautenzaPK(fornituraId, utenzaCodice);
    }

    public DettaglioforniturautenzaPK getDettaglioforniturautenzaPK() {
        return dettaglioforniturautenzaPK;
    }

    public void setDettaglioforniturautenzaPK(DettaglioforniturautenzaPK dettaglioforniturautenzaPK) {
        this.dettaglioforniturautenzaPK = dettaglioforniturautenzaPK;
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
    /*
    public String getUnitaMisura() {
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

    public Utenza getUtenza() {
        return utenza;
    }

    public void setUtenza(Utenza utenza) {
        this.utenza = utenza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dettaglioforniturautenzaPK != null ? dettaglioforniturautenzaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dettaglioforniturautenza)) {
            return false;
        }
        Dettaglioforniturautenza other = (Dettaglioforniturautenza) object;
        if ((this.dettaglioforniturautenzaPK == null && other.dettaglioforniturautenzaPK != null) || (this.dettaglioforniturautenzaPK != null && !this.dettaglioforniturautenzaPK.equals(other.dettaglioforniturautenzaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dettaglioforniturautenza[ dettaglioforniturautenzaPK=" + dettaglioforniturautenzaPK + " ]";
    }

}
