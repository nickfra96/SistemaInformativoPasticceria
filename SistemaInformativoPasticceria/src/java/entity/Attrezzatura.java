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
@Table(name = "attrezzatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attrezzatura.findAll", query = "SELECT a FROM Attrezzatura a")
    , @NamedQuery(name = "Attrezzatura.findBySeriale", query = "SELECT a FROM Attrezzatura a WHERE a.seriale = :seriale")
    , @NamedQuery(name = "Attrezzatura.findByDescrizione", query = "SELECT a FROM Attrezzatura a WHERE a.descrizione = :descrizione")
    , @NamedQuery(name = "Attrezzatura.findByDataAcquisto", query = "SELECT a FROM Attrezzatura a WHERE a.dataAcquisto = :dataAcquisto")
    , @NamedQuery(name = "Attrezzatura.findByPeriodicitaIntervento", query = "SELECT a FROM Attrezzatura a WHERE a.periodicitaIntervento = :periodicitaIntervento")})
public class Attrezzatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "seriale")
    private Integer seriale;
    @Size(max = 45)
    @Column(name = "descrizione")
    private String descrizione;
    @Size(max = 10)
    @Column(name = "data_acquisto")
    private String dataAcquisto;
    @Column(name = "periodicita_intervento")
    private Integer periodicitaIntervento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attrezzaturaSeriale")
    private List<Manutenzione> manutenzioneList;

    public Attrezzatura() {
    }

    public Attrezzatura(Integer seriale) {
        this.seriale = seriale;
    }

    public Integer getSeriale() {
        return seriale;
    }

    public void setSeriale(Integer seriale) {
        this.seriale = seriale;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(String dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Integer getPeriodicitaIntervento() {
        return periodicitaIntervento;
    }

    public void setPeriodicitaIntervento(Integer periodicitaIntervento) {
        this.periodicitaIntervento = periodicitaIntervento;
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
        hash += (seriale != null ? seriale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attrezzatura)) {
            return false;
        }
        Attrezzatura other = (Attrezzatura) object;
        if ((this.seriale == null && other.seriale != null) || (this.seriale != null && !this.seriale.equals(other.seriale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Attrezzatura[ seriale=" + seriale + " ]";
    }

}
