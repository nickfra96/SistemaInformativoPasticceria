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
@Table(name = "magazzinouscita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Magazzinouscita.findAll", query = "SELECT m FROM Magazzinouscita m")
    , @NamedQuery(name = "Magazzinouscita.findByQuantita", query = "SELECT m FROM Magazzinouscita m WHERE m.quantita = :quantita")
    , @NamedQuery(name = "Magazzinouscita.findByProdottofinitoCodice", query = "SELECT m FROM Magazzinouscita m WHERE m.prodottofinitoCodice = :prodottofinitoCodice")})
public class Magazzinouscita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantita")
    private int quantita;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodottofinito_codice")
    private Integer prodottofinitoCodice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "magazzinouscita")
    private List<Dettaglioordine> dettaglioordineList;
    @JoinColumn(name = "prodottofinito_codice", referencedColumnName = "codice", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prodottofinito prodottofinito;

    public Magazzinouscita() {
    }

    public Magazzinouscita(Integer prodottofinitoCodice) {
        this.prodottofinitoCodice = prodottofinitoCodice;
    }

    public Magazzinouscita(Integer prodottofinitoCodice, int quantita) {
        this.prodottofinitoCodice = prodottofinitoCodice;
        this.quantita = quantita;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Integer getProdottofinitoCodice() {
        return prodottofinitoCodice;
    }

    public void setProdottofinitoCodice(Integer prodottofinitoCodice) {
        this.prodottofinitoCodice = prodottofinitoCodice;
    }

    @XmlTransient
    public List<Dettaglioordine> getDettaglioordineList() {
        return dettaglioordineList;
    }

    public void setDettaglioordineList(List<Dettaglioordine> dettaglioordineList) {
        this.dettaglioordineList = dettaglioordineList;
    }

    public Prodottofinito getProdottofinito() {
        return prodottofinito;
    }

    public void setProdottofinito(Prodottofinito prodottofinito) {
        this.prodottofinito = prodottofinito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodottofinitoCodice != null ? prodottofinitoCodice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Magazzinouscita)) {
            return false;
        }
        Magazzinouscita other = (Magazzinouscita) object;
        if ((this.prodottofinitoCodice == null && other.prodottofinitoCodice != null) || (this.prodottofinitoCodice != null && !this.prodottofinitoCodice.equals(other.prodottofinitoCodice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Magazzinouscita[ prodottofinitoCodice=" + prodottofinitoCodice + " ]";
    }

}
