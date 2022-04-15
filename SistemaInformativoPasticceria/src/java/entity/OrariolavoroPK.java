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


@Embeddable
public class OrariolavoroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "inizio")
    private int inizio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private int quantita;

    public OrariolavoroPK() {
    }

    public OrariolavoroPK(int inizio, int quantita) {
        this.inizio = inizio;
        this.quantita = quantita;
    }

    public int getInizio() {
        return inizio;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) inizio;
        hash += (int) quantita;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrariolavoroPK)) {
            return false;
        }
        OrariolavoroPK other = (OrariolavoroPK) object;
        if (this.inizio != other.inizio) {
            return false;
        }
        if (this.quantita != other.quantita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrariolavoroPK[ inizio=" + inizio + ", quantita=" + quantita + " ]";
    }

}
