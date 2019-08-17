/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Profesional.findByIdprofesional", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.idprofesional = :idprofesional")
    , @NamedQuery(name = "Profesional.findByIdusuario", query = "SELECT p FROM Profesional p WHERE p.profesionalPK.idusuario = :idusuario")
    , @NamedQuery(name = "Profesional.findByNacionalidad", query = "SELECT p FROM Profesional p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Profesional.findByDescripcionPerfil", query = "SELECT p FROM Profesional p WHERE p.descripcionPerfil = :descripcionPerfil")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfesionalPK profesionalPK;
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
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesional")
    private List<Horariodisponible> horariodisponibleList;

    public Profesional() {
    }

    public Profesional(ProfesionalPK profesionalPK) {
        this.profesionalPK = profesionalPK;
    }

    public Profesional(int idprofesional, int idusuario) {
        this.profesionalPK = new ProfesionalPK(idprofesional, idusuario);
    }

    public ProfesionalPK getProfesionalPK() {
        return profesionalPK;
    }

    public void setProfesionalPK(ProfesionalPK profesionalPK) {
        this.profesionalPK = profesionalPK;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (profesionalPK != null ? profesionalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.profesionalPK == null && other.profesionalPK != null) || (this.profesionalPK != null && !this.profesionalPK.equals(other.profesionalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Profesional[ profesionalPK=" + profesionalPK + " ]";
    }
    
}
