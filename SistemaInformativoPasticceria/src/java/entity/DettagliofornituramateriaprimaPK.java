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
public class DettagliofornituramateriaprimaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fornitura_id")
    private int fornituraId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materiaprima_codice")
    private int materiaprimaCodice;

    public DettagliofornituramateriaprimaPK() {
    }

    public DettagliofornituramateriaprimaPK(int fornituraId, int materiaprimaCodice) {
        this.fornituraId = fornituraId;
        this.materiaprimaCodice = materiaprimaCodice;
    }

    public int getFornituraId() {
        return fornituraId;
    }

    public void setFornituraId(int fornituraId) {
        this.fornituraId = fornituraId;
    }

    public int getMateriaprimaCodice() {
        return materiaprimaCodice;
    }

    public void setMateriaprimaCodice(int materiaprimaCodice) {
        this.materiaprimaCodice = materiaprimaCodice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fornituraId;
        hash += (int) materiaprimaCodice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DettagliofornituramateriaprimaPK)) {
            return false;
        }
        DettagliofornituramateriaprimaPK other = (DettagliofornituramateriaprimaPK) object;
        if (this.fornituraId != other.fornituraId) {
            return false;
        }
        if (this.materiaprimaCodice != other.materiaprimaCodice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DettagliofornituramateriaprimaPK[ fornituraId=" + fornituraId + ", materiaprimaCodice=" + materiaprimaCodice + " ]";
    }

}
