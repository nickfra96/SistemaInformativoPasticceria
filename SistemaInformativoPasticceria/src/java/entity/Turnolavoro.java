/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "turnolavoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turnolavoro.findAll", query = "SELECT t FROM Turnolavoro t")
    , @NamedQuery(name = "Turnolavoro.findByDipendenteCf", query = "SELECT t FROM Turnolavoro t WHERE t.turnolavoroPK.dipendenteCf = :dipendenteCf")
    , @NamedQuery(name = "Turnolavoro.findByOrariolavoroInizio", query = "SELECT t FROM Turnolavoro t WHERE t.turnolavoroPK.orariolavoroInizio = :orariolavoroInizio")
    , @NamedQuery(name = "Turnolavoro.findByOrariolavoroQuantita", query = "SELECT t FROM Turnolavoro t WHERE t.turnolavoroPK.orariolavoroQuantita = :orariolavoroQuantita")
    , @NamedQuery(name = "Turnolavoro.findByGiorno", query = "SELECT t FROM Turnolavoro t WHERE t.turnolavoroPK.giorno = :giorno")})
public class Turnolavoro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnolavoroPK turnolavoroPK;
    @JoinColumn(name = "dipendente_cf", referencedColumnName = "cf", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dipendente dipendente;
    @JoinColumns({
        @JoinColumn(name = "orariolavoro_inizio", referencedColumnName = "inizio", insertable = false, updatable = false)
        , @JoinColumn(name = "orariolavoro_quantita", referencedColumnName = "quantita", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Orariolavoro orariolavoro;

    public Turnolavoro() {
    }

    public Turnolavoro(TurnolavoroPK turnolavoroPK) {
        this.turnolavoroPK = turnolavoroPK;
    }

    public Turnolavoro(String dipendenteCf, int orariolavoroInizio, int orariolavoroQuantita, String giorno) {
        this.turnolavoroPK = new TurnolavoroPK(dipendenteCf, orariolavoroInizio, orariolavoroQuantita, giorno);
    }

    public TurnolavoroPK getTurnolavoroPK() {
        return turnolavoroPK;
    }

    public void setTurnolavoroPK(TurnolavoroPK turnolavoroPK) {
        this.turnolavoroPK = turnolavoroPK;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    public Orariolavoro getOrariolavoro() {
        return orariolavoro;
    }

    public void setOrariolavoro(Orariolavoro orariolavoro) {
        this.orariolavoro = orariolavoro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnolavoroPK != null ? turnolavoroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnolavoro)) {
            return false;
        }
        Turnolavoro other = (Turnolavoro) object;
        if ((this.turnolavoroPK == null && other.turnolavoroPK != null) || (this.turnolavoroPK != null && !this.turnolavoroPK.equals(other.turnolavoroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Turnolavoro[ turnolavoroPK=" + turnolavoroPK + " ]";
    }

}
