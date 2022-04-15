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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "manutenzione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manutenzione.findAll", query = "SELECT m FROM Manutenzione m")
    , @NamedQuery(name = "Manutenzione.findByData", query = "SELECT m FROM Manutenzione m WHERE m.data = :data")
    , @NamedQuery(name = "Manutenzione.findByDescrizione", query = "SELECT m FROM Manutenzione m WHERE m.descrizione = :descrizione")
    , @NamedQuery(name = "Manutenzione.findByTipo", query = "SELECT m FROM Manutenzione m WHERE m.tipo = :tipo")})
public class Manutenzione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "data")
    private String data;
    @Size(max = 80)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "attrezzatura_seriale", referencedColumnName = "seriale")
    @ManyToOne(optional = false)
    private Attrezzatura attrezzaturaSeriale;
    @JoinColumn(name = "dipendente_cf", referencedColumnName = "cf")
    @ManyToOne(optional = false)
    private Dipendente dipendenteCf;
    @JoinColumn(name = "fornitore_extra_piva", referencedColumnName = "piva")
    @ManyToOne(optional = false)
    private Fornitore fornitoreExtraPiva;

    public Manutenzione() {
    }

    public Manutenzione(String data) {
        this.data = data;
    }

    public Manutenzione(String data, String tipo) {
        this.data = data;
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Attrezzatura getAttrezzaturaSeriale() {
        return attrezzaturaSeriale;
    }

    public void setAttrezzaturaSeriale(Attrezzatura attrezzaturaSeriale) {
        this.attrezzaturaSeriale = attrezzaturaSeriale;
    }

    public Dipendente getDipendenteCf() {
        return dipendenteCf;
    }

    public void setDipendenteCf(Dipendente dipendenteCf) {
        this.dipendenteCf = dipendenteCf;
    }

    public Fornitore getFornitoreExtraPiva() {
        return fornitoreExtraPiva;
    }

    public void setFornitoreExtraPiva(Fornitore fornitoreExtraPiva) {
        this.fornitoreExtraPiva = fornitoreExtraPiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (data != null ? data.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manutenzione)) {
            return false;
        }
        Manutenzione other = (Manutenzione) object;
        if ((this.data == null && other.data != null) || (this.data != null && !this.data.equals(other.data))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Manutenzione[ data=" + data + " ]";
    }

}
