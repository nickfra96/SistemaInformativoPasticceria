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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "fornitura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornitura.findAll", query = "SELECT f FROM Fornitura f")
    , @NamedQuery(name = "Fornitura.findById", query = "SELECT f FROM Fornitura f WHERE f.id = :id")
    , @NamedQuery(name = "Fornitura.findByData", query = "SELECT f FROM Fornitura f WHERE f.data = :data")
    , @NamedQuery(name = "Fornitura.findByTipo", query = "SELECT f FROM Fornitura f WHERE f.tipo = :tipo")})
public class Fornitura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornitura")
    private List<Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList;
    @JoinColumn(name = "fornitore_piva", referencedColumnName = "piva")
    @ManyToOne(optional = false)
    private Fornitore fornitorePiva;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fornitura")
    private Fatturaacquisto fatturaacquisto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornitura")
    private List<Dettaglioforniturautenza> dettaglioforniturautenzaList;

    public Fornitura() {
    }

    public Fornitura(Integer id) {
        this.id = id;
    }

    public Fornitura(Integer id, String data, Character tipo) {
        this.id = id;
        this.data = data;
        this.tipo = tipo;
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

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Dettagliofornituramateriaprima> getDettagliofornituramateriaprimaList() {
        return dettagliofornituramateriaprimaList;
    }

    public void setDettagliofornituramateriaprimaList(List<Dettagliofornituramateriaprima> dettagliofornituramateriaprimaList) {
        this.dettagliofornituramateriaprimaList = dettagliofornituramateriaprimaList;
    }

    public Fornitore getFornitorePiva() {
        return fornitorePiva;
    }

    public void setFornitorePiva(Fornitore fornitorePiva) {
        this.fornitorePiva = fornitorePiva;
    }

    public Fatturaacquisto getFatturaacquisto() {
        return fatturaacquisto;
    }

    public void setFatturaacquisto(Fatturaacquisto fatturaacquisto) {
        this.fatturaacquisto = fatturaacquisto;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornitura)) {
            return false;
        }
        Fornitura other = (Fornitura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornitura n°" + id;
    }

}
