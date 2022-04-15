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
public class DettaglioordinePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ordine_id")
    private int ordineId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "magazzinouscita_prodottofinito_codice")
    private int magazzinouscitaProdottofinitoCodice;

    public DettaglioordinePK() {
    }

    public DettaglioordinePK(int ordineId, int magazzinouscitaProdottofinitoCodice) {
        this.ordineId = ordineId;
        this.magazzinouscitaProdottofinitoCodice = magazzinouscitaProdottofinitoCodice;
    }

    public int getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(int ordineId) {
        this.ordineId = ordineId;
    }

    public int getMagazzinouscitaProdottofinitoCodice() {
        return magazzinouscitaProdottofinitoCodice;
    }

    public void setMagazzinouscitaProdottofinitoCodice(int magazzinouscitaProdottofinitoCodice) {
        this.magazzinouscitaProdottofinitoCodice = magazzinouscitaProdottofinitoCodice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordineId;
        hash += (int) magazzinouscitaProdottofinitoCodice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DettaglioordinePK)) {
            return false;
        }
        DettaglioordinePK other = (DettaglioordinePK) object;
        if (this.ordineId != other.ordineId) {
            return false;
        }
        if (this.magazzinouscitaProdottofinitoCodice != other.magazzinouscitaProdottofinitoCodice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DettaglioordinePK[ ordineId=" + ordineId + ", magazzinouscitaProdottofinitoCodice=" + magazzinouscitaProdottofinitoCodice + " ]";
    }

}
