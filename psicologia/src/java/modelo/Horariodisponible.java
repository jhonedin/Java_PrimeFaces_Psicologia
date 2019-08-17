/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "horariodisponible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horariodisponible.findAll", query = "SELECT h FROM Horariodisponible h")
    , @NamedQuery(name = "Horariodisponible.findByIdhorariodisponible", query = "SELECT h FROM Horariodisponible h WHERE h.idhorariodisponible = :idhorariodisponible")
    , @NamedQuery(name = "Horariodisponible.findByDia", query = "SELECT h FROM Horariodisponible h WHERE h.dia = :dia")
    , @NamedQuery(name = "Horariodisponible.findByHorainicio", query = "SELECT h FROM Horariodisponible h WHERE h.horainicio = :horainicio")
    , @NamedQuery(name = "Horariodisponible.findByHorafinal", query = "SELECT h FROM Horariodisponible h WHERE h.horafinal = :horafinal")
    , @NamedQuery(name = "Horariodisponible.findByEstado", query = "SELECT h FROM Horariodisponible h WHERE h.estado = :estado")})
public class Horariodisponible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhorariodisponible")
    private Integer idhorariodisponible;
    @Size(max = 10)
    @Column(name = "dia")
    private String dia;
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Column(name = "horafinal")
    @Temporal(TemporalType.TIME)
    private Date horafinal;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idprofesional", referencedColumnName = "idprofesional")
    @ManyToOne(optional = false)
    private Profesional idprofesional;

    public Horariodisponible() {
    }

    public Horariodisponible(Integer idhorariodisponible) {
        this.idhorariodisponible = idhorariodisponible;
    }

    public Integer getIdhorariodisponible() {
        return idhorariodisponible;
    }

    public void setIdhorariodisponible(Integer idhorariodisponible) {
        this.idhorariodisponible = idhorariodisponible;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Date horafinal) {
        this.horafinal = horafinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Profesional getIdprofesional() {
        return idprofesional;
    }

    public void setIdprofesional(Profesional idprofesional) {
        this.idprofesional = idprofesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorariodisponible != null ? idhorariodisponible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horariodisponible)) {
            return false;
        }
        Horariodisponible other = (Horariodisponible) object;
        if ((this.idhorariodisponible == null && other.idhorariodisponible != null) || (this.idhorariodisponible != null && !this.idhorariodisponible.equals(other.idhorariodisponible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Horariodisponible[ idhorariodisponible=" + idhorariodisponible + " ]";
    }
    
}
