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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "dettaglioordine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dettaglioordine.findAll", query = "SELECT d FROM Dettaglioordine d")
    , @NamedQuery(name = "Dettaglioordine.findByQuantita", query = "SELECT d FROM Dettaglioordine d WHERE d.quantita = :quantita")
    , @NamedQuery(name = "Dettaglioordine.findByOrdineId", query = "SELECT d FROM Dettaglioordine d WHERE d.dettaglioordinePK.ordineId = :ordineId")
    , @NamedQuery(name = "Dettaglioordine.findByMagazzinouscitaProdottofinitoCodice", query = "SELECT d FROM Dettaglioordine d WHERE d.dettaglioordinePK.magazzinouscitaProdottofinitoCodice = :magazzinouscitaProdottofinitoCodice")})
public class Dettaglioordine implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DettaglioordinePK dettaglioordinePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private int quantita;
    @JoinColumn(name = "magazzinouscita_prodottofinito_codice", referencedColumnName = "prodottofinito_codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Magazzinouscita magazzinouscita;
    @JoinColumn(name = "ordine_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordine ordine;

    public Dettaglioordine() {
    }

    public Dettaglioordine(DettaglioordinePK dettaglioordinePK) {
        this.dettaglioordinePK = dettaglioordinePK;
    }

    public Dettaglioordine(DettaglioordinePK dettaglioordinePK, int quantita) {
        this.dettaglioordinePK = dettaglioordinePK;
        this.quantita = quantita;
    }

    public Dettaglioordine(int ordineId, int magazzinouscitaProdottofinitoCodice) {
        this.dettaglioordinePK = new DettaglioordinePK(ordineId, magazzinouscitaProdottofinitoCodice);
    }

    public DettaglioordinePK getDettaglioordinePK() {
        return dettaglioordinePK;
    }

    public void setDettaglioordinePK(DettaglioordinePK dettaglioordinePK) {
        this.dettaglioordinePK = dettaglioordinePK;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Magazzinouscita getMagazzinouscita() {
        return magazzinouscita;
    }

    public void setMagazzinouscita(Magazzinouscita magazzinouscita) {
        this.magazzinouscita = magazzinouscita;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dettaglioordinePK != null ? dettaglioordinePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dettaglioordine)) {
            return false;
        }
        Dettaglioordine other = (Dettaglioordine) object;
        if ((this.dettaglioordinePK == null && other.dettaglioordinePK != null) || (this.dettaglioordinePK != null && !this.dettaglioordinePK.equals(other.dettaglioordinePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dettaglioordine[ dettaglioordinePK=" + dettaglioordinePK + " ]";
    }

}
