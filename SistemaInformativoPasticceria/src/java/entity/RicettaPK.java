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
public class RicettaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "prodottofinito_codice")
    private int prodottofinitoCodice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "magazzinoingresso_materiaprima_codice")
    private int magazzinoingressoMateriaprimaCodice;

    public RicettaPK() {
    }

    public RicettaPK(int prodottofinitoCodice, int magazzinoingressoMateriaprimaCodice) {
        this.prodottofinitoCodice = prodottofinitoCodice;
        this.magazzinoingressoMateriaprimaCodice = magazzinoingressoMateriaprimaCodice;
    }

    public int getProdottofinitoCodice() {
        return prodottofinitoCodice;
    }

    public void setProdottofinitoCodice(int prodottofinitoCodice) {
        this.prodottofinitoCodice = prodottofinitoCodice;
    }

    public int getMagazzinoingressoMateriaprimaCodice() {
        return magazzinoingressoMateriaprimaCodice;
    }

    public void setMagazzinoingressoMateriaprimaCodice(int magazzinoingressoMateriaprimaCodice) {
        this.magazzinoingressoMateriaprimaCodice = magazzinoingressoMateriaprimaCodice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prodottofinitoCodice;
        hash += (int) magazzinoingressoMateriaprimaCodice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RicettaPK)) {
            return false;
        }
        RicettaPK other = (RicettaPK) object;
        if (this.prodottofinitoCodice != other.prodottofinitoCodice) {
            return false;
        }
        if (this.magazzinoingressoMateriaprimaCodice != other.magazzinoingressoMateriaprimaCodice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RicettaPK[ prodottofinitoCodice=" + prodottofinitoCodice + ", magazzinoingressoMateriaprimaCodice=" + magazzinoingressoMateriaprimaCodice + " ]";
    }

}
