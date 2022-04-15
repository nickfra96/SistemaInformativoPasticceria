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
public class TurnolavoroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "dipendente_cf")
    private String dipendenteCf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orariolavoro_inizio")
    private int orariolavoroInizio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orariolavoro_quantita")
    private int orariolavoroQuantita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "giorno")
    private String giorno;

    public TurnolavoroPK() {
    }

    public TurnolavoroPK(String dipendenteCf, int orariolavoroInizio, int orariolavoroQuantita, String giorno) {
        this.dipendenteCf = dipendenteCf;
        this.orariolavoroInizio = orariolavoroInizio;
        this.orariolavoroQuantita = orariolavoroQuantita;
        this.giorno = giorno;
    }

    public String getDipendenteCf() {
        return dipendenteCf;
    }

    public void setDipendenteCf(String dipendenteCf) {
        this.dipendenteCf = dipendenteCf;
    }

    public int getOrariolavoroInizio() {
        return orariolavoroInizio;
    }

    public void setOrariolavoroInizio(int orariolavoroInizio) {
        this.orariolavoroInizio = orariolavoroInizio;
    }

    public int getOrariolavoroQuantita() {
        return orariolavoroQuantita;
    }

    public void setOrariolavoroQuantita(int orariolavoroQuantita) {
        this.orariolavoroQuantita = orariolavoroQuantita;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dipendenteCf != null ? dipendenteCf.hashCode() : 0);
        hash += (int) orariolavoroInizio;
        hash += (int) orariolavoroQuantita;
        hash += (giorno != null ? giorno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnolavoroPK)) {
            return false;
        }
        TurnolavoroPK other = (TurnolavoroPK) object;
        if ((this.dipendenteCf == null && other.dipendenteCf != null) || (this.dipendenteCf != null && !this.dipendenteCf.equals(other.dipendenteCf))) {
            return false;
        }
        if (this.orariolavoroInizio != other.orariolavoroInizio) {
            return false;
        }
        if (this.orariolavoroQuantita != other.orariolavoroQuantita) {
            return false;
        }
        if ((this.giorno == null && other.giorno != null) || (this.giorno != null && !this.giorno.equals(other.giorno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TurnolavoroPK[ dipendenteCf=" + dipendenteCf + ", orariolavoroInizio=" + orariolavoroInizio + ", orariolavoroQuantita=" + orariolavoroQuantita + ", giorno=" + giorno + " ]";
    }

}
