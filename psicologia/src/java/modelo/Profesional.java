/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "profesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p")
    , @NamedQuery(name = "Profesional.findByIdprofesional", query = "SELECT p FROM Profesional p WHERE p.idprofesional = :idprofesional")
    , @NamedQuery(name = "Profesional.findByNacionalidad", query = "SELECT p FROM Profesional p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Profesional.findByDescripcionPerfil", query = "SELECT p FROM Profesional p WHERE p.descripcionPerfil = :descripcionPerfil")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesional")
    private Integer idprofesional;
    @Size(max = 20)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 100)
    @Column(name = "descripcionPerfil")
    private String descripcionPerfil;
    @JoinTable(name = "profesionaltratamientos", joinColumns = {
        @JoinColumn(name = "idprofesional", referencedColumnName = "idprofesional")}, inverseJoinColumns = {
        @JoinColumn(name = "idtratamiento", referencedColumnName = "idtratamiento")})
    @ManyToMany
    private List<Tratamientos> tratamientosList;
    @ManyToMany(mappedBy = "profesionalList")
    private List<Especialidad> especialidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesional")
    private List<Profesionalservicios> profesionalserviciosList;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesional")
    private List<Horariodisponible> horariodisponibleList;

    public Profesional() {
    }

    public Profesional(Integer idprofesional) {
        this.idprofesional = idprofesional;
    }

    public Integer getIdprofesional() {
        return idprofesional;
    }

    public void setIdprofesional(Integer idprofesional) {
        this.idprofesional = idprofesional;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    @XmlTransient
    public List<Tratamientos> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Tratamientos> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }

    @XmlTransient
    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    @XmlTransient
    public List<Profesionalservicios> getProfesionalserviciosList() {
        return profesionalserviciosList;
    }

    public void setProfesionalserviciosList(List<Profesionalservicios> profesionalserviciosList) {
        this.profesionalserviciosList = profesionalserviciosList;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @XmlTransient
    public List<Horariodisponible> getHorariodisponibleList() {
        return horariodisponibleList;
    }

    public void setHorariodisponibleList(List<Horariodisponible> horariodisponibleList) {
        this.horariodisponibleList = horariodisponibleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofesional != null ? idprofesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.idprofesional == null && other.idprofesional != null) || (this.idprofesional != null && !this.idprofesional.equals(other.idprofesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Profesional[ idprofesional=" + idprofesional + " ]";
    }
    
}
