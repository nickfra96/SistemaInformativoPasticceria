/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "orariolavoro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orariolavoro.findAll", query = "SELECT o FROM Orariolavoro o")
    , @NamedQuery(name = "Orariolavoro.findByInizio", query = "SELECT o FROM Orariolavoro o WHERE o.orariolavoroPK.inizio = :inizio")
    , @NamedQuery(name = "Orariolavoro.findByQuantita", query = "SELECT o FROM Orariolavoro o WHERE o.orariolavoroPK.quantita = :quantita")})
public class Orariolavoro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrariolavoroPK orariolavoroPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orariolavoro")
    private List<Turnolavoro> turnolavoroList;

    public Orariolavoro() {
    }

    public Orariolavoro(OrariolavoroPK orariolavoroPK) {
        this.orariolavoroPK = orariolavoroPK;
    }

    public Orariolavoro(int inizio, int quantita) {
        this.orariolavoroPK = new OrariolavoroPK(inizio, quantita);
    }

    public OrariolavoroPK getOrariolavoroPK() {
        return orariolavoroPK;
    }

    public void setOrariolavoroPK(OrariolavoroPK orariolavoroPK) {
        this.orariolavoroPK = orariolavoroPK;
    }

    @XmlTransient
    public List<Turnolavoro> getTurnolavoroList() {
        return turnolavoroList;
    }

    public void setTurnolavoroList(List<Turnolavoro> turnolavoroList) {
        this.turnolavoroList = turnolavoroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orariolavoroPK != null ? orariolavoroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orariolavoro)) {
            return false;
        }
        Orariolavoro other = (Orariolavoro) object;
        if ((this.orariolavoroPK == null && other.orariolavoroPK != null) || (this.orariolavoroPK != null && !this.orariolavoroPK.equals(other.orariolavoroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orariolavoro[ orariolavoroPK=" + orariolavoroPK + " ]";
    }

}
