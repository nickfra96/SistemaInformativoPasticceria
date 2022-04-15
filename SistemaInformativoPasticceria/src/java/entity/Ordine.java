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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "ordine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordine.findAll", query = "SELECT o FROM Ordine o")
    , @NamedQuery(name = "Ordine.findById", query = "SELECT o FROM Ordine o WHERE o.id = :id")
    , @NamedQuery(name = "Ordine.findByData", query = "SELECT o FROM Ordine o WHERE o.data = :data")
    , @NamedQuery(name = "Ordine.findByTipo", query = "SELECT o FROM Ordine o WHERE o.tipo = :tipo")})
public class Ordine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "cliente_piva", referencedColumnName = "piva")
    @ManyToOne(optional = false)
    private Cliente clientePiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordineId")
    private List<Fatturavendita> fatturavenditaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordine")
    private List<Dettaglioordine> dettaglioordineList;

    public Ordine() {
    }

    public Ordine(Integer id) {
        this.id = id;
    }

    public Ordine(Integer id, String tipo) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getClientePiva() {
        return clientePiva;
    }

    public void setClientePiva(Cliente clientePiva) {
        this.clientePiva = clientePiva;
    }

    @XmlTransient
    public List<Fatturavendita> getFatturavenditaList() {
        return fatturavenditaList;
    }

    public void setFatturavenditaList(List<Fatturavendita> fatturavenditaList) {
        this.fatturavenditaList = fatturavenditaList;
    }

    @XmlTransient
    public List<Dettaglioordine> getDettaglioordineList() {
        return dettaglioordineList;
    }

    public void setDettaglioordineList(List<Dettaglioordine> dettaglioordineList) {
        this.dettaglioordineList = dettaglioordineList;
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
        if (!(object instanceof Ordine)) {
            return false;
        }
        Ordine other = (Ordine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ordine[ id=" + id + " ]";
    }

}
