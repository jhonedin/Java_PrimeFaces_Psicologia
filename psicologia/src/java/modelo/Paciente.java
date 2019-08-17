/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.pacientePK.idpaciente = :idpaciente")
    , @NamedQuery(name = "Paciente.findByIdusuario", query = "SELECT p FROM Paciente p WHERE p.pacientePK.idusuario = :idusuario")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacientePK pacientePK;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<Cita> citaList;

    public Paciente() {
    }

    public Paciente(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Paciente(int idpaciente, int idusuario) {
        this.pacientePK = new PacientePK(idpaciente, idusuario);
    }

    public PacientePK getPacientePK() {
        return pacientePK;
    }

    public void setPacientePK(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacientePK != null ? pacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacientePK == null && other.pacientePK != null) || (this.pacientePK != null && !this.pacientePK.equals(other.pacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Paciente[ pacientePK=" + pacientePK + " ]";
    }
    
}
