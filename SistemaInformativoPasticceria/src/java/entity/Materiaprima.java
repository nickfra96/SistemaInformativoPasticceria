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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "materiaprima")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiaprima.findAll", query = "SELECT m FROM Materiaprima m")
    , @NamedQuery(name = "Materiaprima.findByCodice", query = "SELECT m FROM Materiaprima m WHERE m.codice = :codice")
    , @NamedQuery(name = "Materiaprima.findByDescrizione", query = "SELECT m FROM Materiaprima m WHERE m.descrizione = :descrizione")})
public class Materiaprima implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codice")
    private Integer codice;
    @Size(max = 45)
    @Column(name = "descrizione")
    private String descrizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiaprima")
    private List<Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "materiaprima")
    private Magazzinoingresso magazzinoingresso;

    public Materiaprima() {
    }

    public Materiaprima(Integer codice) {
        this.codice = codice;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    public List<Dettagliofornituramateriaprima> getDettagliofornituramateriaprimaList() {
        return dettagliofornituramateriaprimaList;
    }

    public void setDettagliofornituramateriaprimaList(List<Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList) {
        this.dettagliofornituramateriaprimaList = dettagliofornituramateriaprimaList;
    }

    public Magazzinoingresso getMagazzinoingresso() {
        return magazzinoingresso;
    }

    public void setMagazzinoingresso(Magazzinoingresso magazzinoingresso) {
        this.magazzinoingresso = magazzinoingresso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiaprima)) {
            return false;
        }
        Materiaprima other = (Materiaprima) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Materiaprima[ codice=" + codice + "+ descrizione: " + descrizione + " ]";
    }

}
