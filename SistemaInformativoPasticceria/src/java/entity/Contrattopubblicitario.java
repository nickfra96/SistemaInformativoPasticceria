/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "contrattopubblicitario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrattopubblicitario.findAll", query = "SELECT c FROM Contrattopubblicitario c")
    , @NamedQuery(name = "Contrattopubblicitario.findByFornitoreExtraPiva", query = "SELECT c FROM Contrattopubblicitario c WHERE c.contrattopubblicitarioPK.fornitoreExtraPiva = :fornitoreExtraPiva")
    , @NamedQuery(name = "Contrattopubblicitario.findByData", query = "SELECT c FROM Contrattopubblicitario c WHERE c.contrattopubblicitarioPK.data = :data")
    , @NamedQuery(name = "Contrattopubblicitario.findByDescrizione", query = "SELECT c FROM Contrattopubblicitario c WHERE c.descrizione = :descrizione")
    , @NamedQuery(name = "Contrattopubblicitario.findByDurata", query = "SELECT c FROM Contrattopubblicitario c WHERE c.durata = :durata")})
public class Contrattopubblicitario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContrattopubblicitarioPK contrattopubblicitarioPK;
    @Size(max = 45)
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "durata")
    private Integer durata;
    @JoinColumn(name = "fornitore_extra_piva", referencedColumnName = "piva", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornitore fornitore;

    public Contrattopubblicitario() {
    }

    public Contrattopubblicitario(ContrattopubblicitarioPK contrattopubblicitarioPK) {
        this.contrattopubblicitarioPK = contrattopubblicitarioPK;
    }

    public Contrattopubblicitario(String fornitoreExtraPiva, String data) {
        this.contrattopubblicitarioPK = new ContrattopubblicitarioPK(fornitoreExtraPiva, data);
    }

    public ContrattopubblicitarioPK getContrattopubblicitarioPK() {
        return contrattopubblicitarioPK;
    }

    public void setContrattopubblicitarioPK(ContrattopubblicitarioPK contrattopubblicitarioPK) {
        this.contrattopubblicitarioPK = contrattopubblicitarioPK;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public Fornitore getFornitore() {
        return fornitore;
    }

    public void setFornitore(Fornitore fornitore) {
        this.fornitore = fornitore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contrattopubblicitarioPK != null ? contrattopubblicitarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrattopubblicitario)) {
            return false;
        }
        Contrattopubblicitario other = (Contrattopubblicitario) object;
        if ((this.contrattopubblicitarioPK == null && other.contrattopubblicitarioPK != null) || (this.contrattopubblicitarioPK != null && !this.contrattopubblicitarioPK.equals(other.contrattopubblicitarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Contrattopubblicitario[ contrattopubblicitarioPK=" + contrattopubblicitarioPK + " ]";
    }

}
