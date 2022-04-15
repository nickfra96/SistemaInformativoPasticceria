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
public class DettaglioforniturautenzaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fornitura_id")
    private int fornituraId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "utenza_codice")
    private int utenzaCodice;

    public DettaglioforniturautenzaPK() {
    }

    public DettaglioforniturautenzaPK(int fornituraId, int utenzaCodice) {
        this.fornituraId = fornituraId;
        this.utenzaCodice = utenzaCodice;
    }

    public int getFornituraId() {
        return fornituraId;
    }

    public void setFornituraId(int fornituraId) {
        this.fornituraId = fornituraId;
    }

    public int getUtenzaCodice() {
        return utenzaCodice;
    }

    public void setUtenzaCodice(int utenzaCodice) {
        this.utenzaCodice = utenzaCodice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fornituraId;
        hash += (int) utenzaCodice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DettaglioforniturautenzaPK)) {
            return false;
        }
        DettaglioforniturautenzaPK other = (DettaglioforniturautenzaPK) object;
        if (this.fornituraId != other.fornituraId) {
            return false;
        }
        if (this.utenzaCodice != other.utenzaCodice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DettaglioforniturautenzaPK[ fornituraId=" + fornituraId + ", utenzaCodice=" + utenzaCodice + " ]";
    }

}
