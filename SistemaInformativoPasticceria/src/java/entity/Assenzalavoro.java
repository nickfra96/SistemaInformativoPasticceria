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
@Table(name = "assenzalavoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assenzalavoro.findAll", query = "SELECT a FROM Assenzalavoro a")
    , @NamedQuery(name = "Assenzalavoro.findByDipendenteCf", query = "SELECT a FROM Assenzalavoro a WHERE a.assenzalavoroPK.dipendenteCf = :dipendenteCf")
    , @NamedQuery(name = "Assenzalavoro.findByGiornoInizio", query = "SELECT a FROM Assenzalavoro a WHERE a.assenzalavoroPK.giornoInizio = :giornoInizio")
    , @NamedQuery(name = "Assenzalavoro.findByGiorniTotali", query = "SELECT a FROM Assenzalavoro a WHERE a.giorniTotali = :giorniTotali")})
public class Assenzalavoro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AssenzalavoroPK assenzalavoroPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giorni_totali")
    private int giorniTotali;
    @JoinColumn(name = "dipendente_cf", referencedColumnName = "cf", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dipendente dipendente;

    public Assenzalavoro() {
    }

    public Assenzalavoro(AssenzalavoroPK assenzalavoroPK) {
        this.assenzalavoroPK = assenzalavoroPK;
    }

    public Assenzalavoro(AssenzalavoroPK assenzalavoroPK, int giorniTotali) {
        this.assenzalavoroPK = assenzalavoroPK;
        this.giorniTotali = giorniTotali;
    }

    public Assenzalavoro(String dipendenteCf, String giornoInizio) {
        this.assenzalavoroPK = new AssenzalavoroPK(dipendenteCf, giornoInizio);
    }

    public AssenzalavoroPK getAssenzalavoroPK() {
        return assenzalavoroPK;
    }

    public void setAssenzalavoroPK(AssenzalavoroPK assenzalavoroPK) {
        this.assenzalavoroPK = assenzalavoroPK;
    }

    public int getGiorniTotali() {
        return giorniTotali;
    }

    public void setGiorniTotali(int giorniTotali) {
        this.giorniTotali = giorniTotali;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assenzalavoroPK != null ? assenzalavoroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assenzalavoro)) {
            return false;
        }
        Assenzalavoro other = (Assenzalavoro) object;
        if ((this.assenzalavoroPK == null && other.assenzalavoroPK != null) || (this.assenzalavoroPK != null && !this.assenzalavoroPK.equals(other.assenzalavoroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Assenzalavoro[ assenzalavoroPK=" + assenzalavoroPK + " ]";
    }

}
