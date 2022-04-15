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
public class ContrattopubblicitarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "fornitore_extra_piva")
    private String fornitoreExtraPiva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "data")
    private String data;

    public ContrattopubblicitarioPK() {
    }

    public ContrattopubblicitarioPK(String fornitoreExtraPiva, String data) {
        this.fornitoreExtraPiva = fornitoreExtraPiva;
        this.data = data;
    }

    public String getFornitoreExtraPiva() {
        return fornitoreExtraPiva;
    }

    public void setFornitoreExtraPiva(String fornitoreExtraPiva) {
        this.fornitoreExtraPiva = fornitoreExtraPiva;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornitoreExtraPiva != null ? fornitoreExtraPiva.hashCode() : 0);
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContrattopubblicitarioPK)) {
            return false;
        }
        ContrattopubblicitarioPK other = (ContrattopubblicitarioPK) object;
        if ((this.fornitoreExtraPiva == null && other.fornitoreExtraPiva != null) || (this.fornitoreExtraPiva != null && !this.fornitoreExtraPiva.equals(other.fornitoreExtraPiva))) {
            return false;
        }
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContrattopubblicitarioPK[ fornitoreExtraPiva=" + fornitoreExtraPiva + ", data=" + data + " ]";
    }

}
