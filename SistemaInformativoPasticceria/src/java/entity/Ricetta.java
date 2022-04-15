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
@Table(name = "ricetta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ricetta.findAll", query = "SELECT r FROM Ricetta r")
    , @NamedQuery(name = "Ricetta.findByQuantita", query = "SELECT r FROM Ricetta r WHERE r.quantita = :quantita")
    , @NamedQuery(name = "Ricetta.findByProdottofinitoCodice", query = "SELECT r FROM Ricetta r WHERE r.ricettaPK.prodottofinitoCodice = :prodottofinitoCodice")
    , @NamedQuery(name = "Ricetta.findByMagazzinoingressoMateriaprimaCodice", query = "SELECT r FROM Ricetta r WHERE r.ricettaPK.magazzinoingressoMateriaprimaCodice = :magazzinoingressoMateriaprimaCodice")})
public class Ricetta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RicettaPK ricettaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private double quantita;
    @JoinColumn(name = "magazzinoingresso_materiaprima_codice", referencedColumnName = "materiaprima_codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Magazzinoingresso magazzinoingresso;
    @JoinColumn(name = "prodottofinito_codice", referencedColumnName = "codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prodottofinito prodottofinito;

    public Ricetta() {
    }

    public Ricetta(RicettaPK ricettaPK) {
        this.ricettaPK = ricettaPK;
    }

    public Ricetta(RicettaPK ricettaPK, double quantita) {
        this.ricettaPK = ricettaPK;
        this.quantita = quantita;
    }

    public Ricetta(int prodottofinitoCodice, int magazzinoingressoMateriaprimaCodice) {
        this.ricettaPK = new RicettaPK(prodottofinitoCodice, magazzinoingressoMateriaprimaCodice);
    }

    public RicettaPK getRicettaPK() {
        return ricettaPK;
    }

    public void setRicettaPK(RicettaPK ricettaPK) {
        this.ricettaPK = ricettaPK;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public Magazzinoingresso getMagazzinoingresso() {
        return magazzinoingresso;
    }

    public void setMagazzinoingresso(Magazzinoingresso magazzinoingresso) {
        this.magazzinoingresso = magazzinoingresso;
    }

    public Prodottofinito getProdottofinito() {
        return prodottofinito;
    }

    public void setProdottofinito(Prodottofinito prodottofinito) {
        this.prodottofinito = prodottofinito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ricettaPK != null ? ricettaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ricetta)) {
            return false;
        }
        Ricetta other = (Ricetta) object;
        if ((this.ricettaPK == null && other.ricettaPK != null) || (this.ricettaPK != null && !this.ricettaPK.equals(other.ricettaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ricetta[ ricettaPK=" + ricettaPK + " ]";
    }

}
