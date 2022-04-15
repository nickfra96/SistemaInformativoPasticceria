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
@Table(name = "dipendente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dipendente.findAll", query = "SELECT d FROM Dipendente d")
    , @NamedQuery(name = "Dipendente.findByCf", query = "SELECT d FROM Dipendente d WHERE d.cf = :cf")
    , @NamedQuery(name = "Dipendente.findByNome", query = "SELECT d FROM Dipendente d WHERE d.nome = :nome")
    , @NamedQuery(name = "Dipendente.findByCognome", query = "SELECT d FROM Dipendente d WHERE d.cognome = :cognome")
    , @NamedQuery(name = "Dipendente.findByTelefono", query = "SELECT d FROM Dipendente d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Dipendente.findByTipo", query = "SELECT d FROM Dipendente d WHERE d.tipo = :tipo")})
public class Dipendente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "cf")
    private String cf;
    @Size(max = 45)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "cognome")
    private String cognome;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dipendente")
    private List<Assenzalavoro> assenzalavoroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dipendente")
    private List<Turnolavoro> turnolavoroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capoproduzioneCf")
    private List<Produzione> produzioneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dipendenteCf")
    private List<Produzione> produzioneList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addettoConsegneCf")
    private List<Consegna> consegnaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dipendenteCf")
    private List<Manutenzione> manutenzioneList;

    public Dipendente() {
    }

    public Dipendente(String cf) {
        this.cf = cf;
    }

    public Dipendente(String cf, String tipo) {
        this.cf = cf;
        this.tipo = tipo;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Assenzalavoro> getAssenzalavoroList() {
        return assenzalavoroList;
    }

    public void setAssenzalavoroList(List<Assenzalavoro> assenzalavoroList) {
        this.assenzalavoroList = assenzalavoroList;
    }

    @XmlTransient
    public List<Turnolavoro> getTurnolavoroList() {
        return turnolavoroList;
    }

    public void setTurnolavoroList(List<Turnolavoro> turnolavoroList) {
        this.turnolavoroList = turnolavoroList;
    }

    @XmlTransient
    public List<Produzione> getProduzioneList() {
        return produzioneList;
    }

    public void setProduzioneList(List<Produzione> produzioneList) {
        this.produzioneList = produzioneList;
    }

    @XmlTransient
    public List<Produzione> getProduzioneList1() {
        return produzioneList1;
    }

    public void setProduzioneList1(List<Produzione> produzioneList1) {
        this.produzioneList1 = produzioneList1;
    }

    @XmlTransient
    public List<Consegna> getConsegnaList() {
        return consegnaList;
    }

    public void setConsegnaList(List<Consegna> consegnaList) {
        this.consegnaList = consegnaList;
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
        hash += (cf != null ? cf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dipendente)) {
            return false;
        }
        Dipendente other = (Dipendente) object;
        if ((this.cf == null && other.cf != null) || (this.cf != null && !this.cf.equals(other.cf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Dipendente[ cf=" + cf + " ]";
    }

}
