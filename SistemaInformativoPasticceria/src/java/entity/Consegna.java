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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "consegna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consegna.findAll", query = "SELECT c FROM Consegna c")
    , @NamedQuery(name = "Consegna.findById", query = "SELECT c FROM Consegna c WHERE c.id = :id")
    , @NamedQuery(name = "Consegna.findByData", query = "SELECT c FROM Consegna c WHERE c.data = :data")})
public class Consegna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "data")
    private String data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consegnaId")
    private List<Fatturavendita> fatturavenditaList;
    @JoinColumn(name = "addetto_consegne_cf", referencedColumnName = "cf")
    @ManyToOne(optional = false)
    private Dipendente addettoConsegneCf;

    public Consegna() {
    }

    public Consegna(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @XmlTransient
    public List<Fatturavendita> getFatturavenditaList() {
        return fatturavenditaList;
    }

    public void setFatturavenditaList(List<Fatturavendita> fatturavenditaList) {
        this.fatturavenditaList = fatturavenditaList;
    }

    public Dipendente getAddettoConsegneCf() {
        return addettoConsegneCf;
    }

    public void setAddettoConsegneCf(Dipendente addettoConsegneCf) {
        this.addettoConsegneCf = addettoConsegneCf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consegna)) {
            return false;
        }
        Consegna other = (Consegna) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Consegna[ id=" + id + " ]";
    }

}
