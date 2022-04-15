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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "fornitore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornitore.findAll", query = "SELECT f FROM Fornitore f")
    , @NamedQuery(name = "Fornitore.findByPiva", query = "SELECT f FROM Fornitore f WHERE f.piva = :piva")
    , @NamedQuery(name = "Fornitore.findByNome", query = "SELECT f FROM Fornitore f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fornitore.findByTelefono", query = "SELECT f FROM Fornitore f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Fornitore.findBySede", query = "SELECT f FROM Fornitore f WHERE f.sede = :sede")
    , @NamedQuery(name = "Fornitore.findByTipo", query = "SELECT f FROM Fornitore f WHERE f.tipo = :tipo")})
public class Fornitore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "piva")
    private String piva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nome")
    private String nome;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "sede")
    private String sede;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private Character tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornitore")
    private List<Contrattopubblicitario> contrattopubblicitarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornitorePiva")
    private List<Fornitura> fornituraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornitoreExtraPiva")
    private List<Manutenzione> manutenzioneList;

    public Fornitore() {
    }

    public Fornitore(String piva) {
        this.piva = piva;
    }

    public Fornitore(String piva, String nome, Character tipo) {
        this.piva = piva;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Contrattopubblicitario> getContrattopubblicitarioList() {
        return contrattopubblicitarioList;
    }

    public void setContrattopubblicitarioList(List<Contrattopubblicitario> contrattopubblicitarioList) {
        this.contrattopubblicitarioList = contrattopubblicitarioList;
    }

    @XmlTransient
    public List<Fornitura> getFornituraList() {
        return fornituraList;
    }

    public void setFornituraList(List<Fornitura> fornituraList) {
        this.fornituraList = fornituraList;
    }

    @XmlTransient
    public List<Manutenzione> getManutenzioneList() {
        return manutenzioneList;
    }

    public void setManutenzioneList(List<Manutenzione> manutenzioneList) {
        this.manutenzioneList = manutenzioneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (piva != null ? piva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornitore)) {
            return false;
        }
        Fornitore other = (Fornitore) object;
        if ((this.piva == null && other.piva != null) || (this.piva != null && !this.piva.equals(other.piva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return piva + " / " + nome;
    }

}
