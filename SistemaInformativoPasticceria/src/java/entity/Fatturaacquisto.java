/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "fatturaacquisto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatturaacquisto.findAll", query = "SELECT f FROM Fatturaacquisto f")
    , @NamedQuery(name = "Fatturaacquisto.findByNumero", query = "SELECT f FROM Fatturaacquisto f WHERE f.numero = :numero")
    , @NamedQuery(name = "Fatturaacquisto.findByAnno", query = "SELECT f FROM Fatturaacquisto f WHERE f.anno = :anno")
    , @NamedQuery(name = "Fatturaacquisto.findByData", query = "SELECT f FROM Fatturaacquisto f WHERE f.data = :data")
    , @NamedQuery(name = "Fatturaacquisto.findByImporto", query = "SELECT f FROM Fatturaacquisto f WHERE f.importo = :importo")
    , @NamedQuery(name = "Fatturaacquisto.findByFornituraId", query = "SELECT f FROM Fatturaacquisto f WHERE f.fornituraId = :fornituraId")
    , @NamedQuery(name = "Fatturaacquisto.findByTipo", query = "SELECT f FROM Fatturaacquisto f WHERE f.tipo = :tipo")})
public class Fatturaacquisto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "anno")
    private Integer anno;
    @Size(max = 10)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importo")
    private double importo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fornitura_id")
    private Integer fornituraId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "fornitura_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Fornitura fornitura;

    public Fatturaacquisto() {
    }

    public Fatturaacquisto(Integer fornituraId) {
        this.fornituraId = fornituraId;
    }

    public Fatturaacquisto(Integer fornituraId, double importo, String tipo) {
        this.fornituraId = fornituraId;
        this.importo = importo;
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Integer getFornituraId() {
        return fornituraId;
    }

    public void setFornituraId(Integer fornituraId) {
        this.fornituraId = fornituraId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Fornitura getFornitura() {
        return fornitura;
    }

    public void setFornitura(Fornitura fornitura) {
        this.fornitura = fornitura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornituraId != null ? fornituraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatturaacquisto)) {
            return false;
        }
        Fatturaacquisto other = (Fatturaacquisto) object;
        if ((this.fornituraId == null && other.fornituraId != null) || (this.fornituraId != null && !this.fornituraId.equals(other.fornituraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "La fattura n°["+ numero +"]relativa alla fornitura n° ["+ fornituraId + "]";
    }

}
