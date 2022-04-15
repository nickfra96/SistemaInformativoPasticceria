/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "magazzinoingresso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magazzinoingresso.findAll", query = "SELECT m FROM Magazzinoingresso m")
    , @NamedQuery(name = "Magazzinoingresso.findByQuantita", query = "SELECT m FROM Magazzinoingresso m WHERE m.quantita = :quantita")
    , @NamedQuery(name = "Magazzinoingresso.findByMateriaprimaCodice", query = "SELECT m FROM Magazzinoingresso m WHERE m.materiaprimaCodice = :materiaprimaCodice")})
public class Magazzinoingresso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private double quantita;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "materiaprima_codice")
    private Integer materiaprimaCodice;
    @JoinColumn(name = "materiaprima_codice", referencedColumnName = "codice", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Materiaprima materiaprima;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazzinoingresso")
    private List<Ricetta> ricettaList;

    public Magazzinoingresso() {
    }

    public Magazzinoingresso(Integer materiaprimaCodice) {
        this.materiaprimaCodice = materiaprimaCodice;
    }

    public Magazzinoingresso(Integer materiaprimaCodice, double quantita) {
        this.materiaprimaCodice = materiaprimaCodice;
        this.quantita = quantita;
    }

    public double getQuantita() {
        return quantita;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public Integer getMateriaprimaCodice() {
        return materiaprimaCodice;
    }

    public void setMateriaprimaCodice(Integer materiaprimaCodice) {
        this.materiaprimaCodice = materiaprimaCodice;
    }

    public Materiaprima getMateriaprima() {
        return materiaprima;
    }

    public void setMateriaprima(Materiaprima materiaprima) {
        this.materiaprima = materiaprima;
    }

    @XmlTransient
    public List<Ricetta> getRicettaList() {
        return ricettaList;
    }

    public void setRicettaList(List<Ricetta> ricettaList) {
        this.ricettaList = ricettaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaprimaCodice != null ? materiaprimaCodice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magazzinoingresso)) {
            return false;
        }
        Magazzinoingresso other = (Magazzinoingresso) object;
        if ((this.materiaprimaCodice == null && other.materiaprimaCodice != null) || (this.materiaprimaCodice != null && !this.materiaprimaCodice.equals(other.materiaprimaCodice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Magazzinoingresso[ materiaprimaCodice=" + materiaprimaCodice + " ]";
    }

}
