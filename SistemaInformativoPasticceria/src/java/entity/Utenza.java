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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "utenza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utenza.findAll", query = "SELECT u FROM Utenza u")
    , @NamedQuery(name = "Utenza.findByCodice", query = "SELECT u FROM Utenza u WHERE u.codice = :codice")
    , @NamedQuery(name = "Utenza.findByDescrizione", query = "SELECT u FROM Utenza u WHERE u.descrizione = :descrizione")})
public class Utenza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codice")
    private Integer codice;
    @Size(max = 45)
    @Column(name = "descrizione")
    private String descrizione;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utenza")
    private List<Dettaglioforniturautenza> dettaglioforniturautenzaList;

    public Utenza() {
    }

    public Utenza(Integer codice) {
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
        System.out.println("sto settando la descrixione dell'utnezav "+this.descrizione);
    }

    @XmlTransient
    public List<Dettaglioforniturautenza> getDettaglioforniturautenzaList() {
        return dettaglioforniturautenzaList;
    }

    public void setDettaglioforniturautenzaList(List<Dettaglioforniturautenza> dettaglioforniturautenzaList) {
        this.dettaglioforniturautenzaList = dettaglioforniturautenzaList;
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
        if (!(object instanceof Utenza)) {
            return false;
        }
        Utenza other = (Utenza) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Utenza[ codice=" + codice + " +descrizione "+descrizione+"]";
    }

}
