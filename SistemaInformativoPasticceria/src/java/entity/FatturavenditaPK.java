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
public class FatturavenditaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    private int anno;

    public FatturavenditaPK() {
    }

    public FatturavenditaPK(int numero, int anno) {
        this.numero = numero;
        this.anno = anno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numero;
        hash += (int) anno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FatturavenditaPK)) {
            return false;
        }
        FatturavenditaPK other = (FatturavenditaPK) object;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.anno != other.anno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FatturavenditaPK[ numero=" + numero + ", anno=" + anno + " ]";
    }

}
