/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class AssenzalavoroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "dipendente_cf")
    private String dipendenteCf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "giorno_inizio")
    private String giornoInizio;

    public AssenzalavoroPK() {
    }

    public AssenzalavoroPK(String dipendenteCf, String giornoInizio) {
        this.dipendenteCf = dipendenteCf;
        this.giornoInizio = giornoInizio;
    }

    public String getDipendenteCf() {
        return dipendenteCf;
    }

    public void setDipendenteCf(String dipendenteCf) {
        this.dipendenteCf = dipendenteCf;
    }

    public String getGiornoInizio() {
        return giornoInizio;
    }

    public void setGiornoInizio(String giornoInizio) {
        this.giornoInizio = giornoInizio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dipendenteCf != null ? dipendenteCf.hashCode() : 0);
        hash += (giornoInizio != null ? giornoInizio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssenzalavoroPK)) {
            return false;
        }
        AssenzalavoroPK other = (AssenzalavoroPK) object;
        if ((this.dipendenteCf == null && other.dipendenteCf != null) || (this.dipendenteCf != null && !this.dipendenteCf.equals(other.dipendenteCf))) {
            return false;
        }
        if ((this.giornoInizio == null && other.giornoInizio != null) || (this.giornoInizio != null && !this.giornoInizio.equals(other.giornoInizio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AssenzalavoroPK[ dipendenteCf=" + dipendenteCf + ", giornoInizio=" + giornoInizio + " ]";
    }

}
