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
@Table(name = "produzione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produzione.findAll", query = "SELECT p FROM Produzione p")
    , @NamedQuery(name = "Produzione.findByNumLotto", query = "SELECT p FROM Produzione p WHERE p.numLotto = :numLotto")
    , @NamedQuery(name = "Produzione.findByData", query = "SELECT p FROM Produzione p WHERE p.data = :data")
    , @NamedQuery(name = "Produzione.findByQuantita", query = "SELECT p FROM Produzione p WHERE p.quantita = :quantita")
    , @NamedQuery(name = "Produzione.findByTipo", query = "SELECT p FROM Produzione p WHERE p.tipo = :tipo")})
public class Produzione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_lotto")
    private Integer numLotto;
    @Size(max = 10)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "quantita")
    private String quantita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "capoproduzione_cf", referencedColumnName = "cf")
    @ManyToOne(optional = false)
    private Dipendente capoproduzioneCf;
    @JoinColumn(name = "dipendente_cf", referencedColumnName = "cf")
    @ManyToOne(optional = false)
    private Dipendente dipendenteCf;
    @JoinColumn(name = "prodottofinito_codice", referencedColumnName = "codice")
    @ManyToOne(optional = false)
    private Prodottofinito prodottofinitoCodice;

    public Produzione() {
    }

    public Produzione(Integer numLotto) {
        this.numLotto = numLotto;
    }

    public Produzione(Integer numLotto, String quantita, String tipo) {
        this.numLotto = numLotto;
        this.quantita = quantita;
        this.tipo = tipo;
    }

    public Integer getNumLotto() {
        return numLotto;
    }

    public void setNumLotto(Integer numLotto) {
        this.numLotto = numLotto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getQuantita() {
        return quantita;
    }

    public void setQuantita(String quantita) {
        this.quantita = quantita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Dipendente getCapoproduzioneCf() {
        return capoproduzioneCf;
    }

    public void setCapoproduzioneCf(Dipendente capoproduzioneCf) {
        this.capoproduzioneCf = capoproduzioneCf;
    }

    public Dipendente getDipendenteCf() {
        return dipendenteCf;
    }

    public void setDipendenteCf(Dipendente dipendenteCf) {
        this.dipendenteCf = dipendenteCf;
    }

    public Prodottofinito getProdottofinitoCodice() {
        return prodottofinitoCodice;
    }

    public void setProdottofinitoCodice(Prodottofinito prodottofinitoCodice) {
        this.prodottofinitoCodice = prodottofinitoCodice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLotto != null ? numLotto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produzione)) {
            return false;
        }
        Produzione other = (Produzione) object;
        if ((this.numLotto == null && other.numLotto != null) || (this.numLotto != null && !this.numLotto.equals(other.numLotto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produzione[ numLotto=" + numLotto + " ]";
    }

}
