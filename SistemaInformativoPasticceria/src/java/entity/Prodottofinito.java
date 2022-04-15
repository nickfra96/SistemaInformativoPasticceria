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
@Table(name = "prodottofinito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodottofinito.findAll", query = "SELECT p FROM Prodottofinito p")
    , @NamedQuery(name = "Prodottofinito.findByCodice", query = "SELECT p FROM Prodottofinito p WHERE p.codice = :codice")
    , @NamedQuery(name = "Prodottofinito.findByDescrizione", query = "SELECT p FROM Prodottofinito p WHERE p.descrizione = :descrizione")
    , @NamedQuery(name = "Prodottofinito.findByDurataFreschezza", query = "SELECT p FROM Prodottofinito p WHERE p.durataFreschezza = :durataFreschezza")
    , @NamedQuery(name = "Prodottofinito.findByTipo", query = "SELECT p FROM Prodottofinito p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Prodottofinito.findByPrezzoUnitario", query = "SELECT p FROM Prodottofinito p WHERE p.prezzoUnitario = :prezzoUnitario")})
public class Prodottofinito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codice")
    private Integer codice;
    @Size(max = 45)
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "durata_freschezza")
    private Integer durataFreschezza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prezzo_unitario")
    private Double prezzoUnitario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodottofinitoCodice")
    private List<Produzione> produzioneList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prodottofinito")
    private Magazzinouscita magazzinouscita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodottofinito")
    private List<Ricetta> ricettaList;

    public Prodottofinito() {
    }

    public Prodottofinito(Integer codice) {
        this.codice = codice;
    }

    public Prodottofinito(Integer codice, String tipo) {
        this.codice = codice;
        this.tipo = tipo;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getDurataFreschezza() {
        return durataFreschezza;
    }

    public void setDurataFreschezza(Integer durataFreschezza) {
        this.durataFreschezza = durataFreschezza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @XmlTransient
    public List<Produzione> getProduzioneList() {
        return produzioneList;
    }

    public void setProduzioneList(List<Produzione> produzioneList) {
        this.produzioneList = produzioneList;
    }

    public Magazzinouscita getMagazzinouscita() {
        return magazzinouscita;
    }

    public void setMagazzinouscita(Magazzinouscita magazzinouscita) {
        this.magazzinouscita = magazzinouscita;
    }

    @XmlTransient
    public List<Ricetta> getRicettaList() {
        return ricettaList;
    }

    public void setRicettaList(List<Ricetta> ricettaList) {
        this.ricettaList = ricettaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodottofinito)) {
            return false;
        }
        Prodottofinito other = (Prodottofinito) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prodottofinito[ codice=" + codice + " ]";
    }

}
