/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "fatturavendita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatturavendita.findAll", query = "SELECT f FROM Fatturavendita f")
    , @NamedQuery(name = "Fatturavendita.findByNumero", query = "SELECT f FROM Fatturavendita f WHERE f.fatturavenditaPK.numero = :numero")
    , @NamedQuery(name = "Fatturavendita.findByAnno", query = "SELECT f FROM Fatturavendita f WHERE f.fatturavenditaPK.anno = :anno")
    , @NamedQuery(name = "Fatturavendita.findByData", query = "SELECT f FROM Fatturavendita f WHERE f.data = :data")
    , @NamedQuery(name = "Fatturavendita.findByImporto", query = "SELECT f FROM Fatturavendita f WHERE f.importo = :importo")})
public class Fatturavendita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FatturavenditaPK fatturavenditaPK;
    @Size(max = 10)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importo")
    private double importo;
    @JoinColumn(name = "consegna_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Consegna consegnaId;
    @JoinColumn(name = "ordine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ordine ordineId;

    public Fatturavendita() {
    }

    public Fatturavendita(FatturavenditaPK fatturavenditaPK) {
        this.fatturavenditaPK = fatturavenditaPK;
    }

    public Fatturavendita(FatturavenditaPK fatturavenditaPK, double importo) {
        this.fatturavenditaPK = fatturavenditaPK;
        this.importo = importo;
    }

    public Fatturavendita(int numero, int anno) {
        this.fatturavenditaPK = new FatturavenditaPK(numero, anno);
    }

    public FatturavenditaPK getFatturavenditaPK() {
        return fatturavenditaPK;
    }

    public void setFatturavenditaPK(FatturavenditaPK fatturavenditaPK) {
        this.fatturavenditaPK = fatturavenditaPK;
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

    public Consegna getConsegnaId() {
        return consegnaId;
    }

    public void setConsegnaId(Consegna consegnaId) {
        this.consegnaId = consegnaId;
    }

    public Ordine getOrdineId() {
        return ordineId;
    }

    public void setOrdineId(Ordine ordineId) {
        this.ordineId = ordineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fatturavenditaPK != null ? fatturavenditaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatturavendita)) {
            return false;
        }
        Fatturavendita other = (Fatturavendita) object;
        if ((this.fatturavenditaPK == null && other.fatturavenditaPK != null) || (this.fatturavenditaPK != null && !this.fatturavenditaPK.equals(other.fatturavenditaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fatturavendita[ fatturavenditaPK=" + fatturavenditaPK + " ]";
    }

}
