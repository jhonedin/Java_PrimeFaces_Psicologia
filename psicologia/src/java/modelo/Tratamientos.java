/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "tratamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamientos.findAll", query = "SELECT t FROM Tratamientos t")
    , @NamedQuery(name = "Tratamientos.findByIdtratamiento", query = "SELECT t FROM Tratamientos t WHERE t.idtratamiento = :idtratamiento")
    , @NamedQuery(name = "Tratamientos.findByNombretratamiento", query = "SELECT t FROM Tratamientos t WHERE t.nombretratamiento = :nombretratamiento")
    , @NamedQuery(name = "Tratamientos.findByDescripcion", query = "SELECT t FROM Tratamientos t WHERE t.descripcion = :descripcion")})
public class Tratamientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtratamiento")
    private Integer idtratamiento;
    @Size(max = 200)
    @Column(name = "nombretratamiento")
    private String nombretratamiento;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "tratamientosList")
    private List<Profesional> profesionalList;
    @JoinTable(name = "historiatratamientos", joinColumns = {
        @JoinColumn(name = "idtratamiento", referencedColumnName = "idtratamiento")}, inverseJoinColumns = {
        @JoinColumn(name = "idhistoria", referencedColumnName = "idhistoria")})
    @ManyToMany
    private List<Historia> historiaList;

    public Tratamientos() {
    }

    public Tratamientos(Integer idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    public Integer getIdtratamiento() {
        return idtratamiento;
    }

    public void setIdtratamiento(Integer idtratamiento) {
        this.idtratamiento = idtratamiento;
    }

    public String getNombretratamiento() {
        return nombretratamiento;
    }

    public void setNombretratamiento(String nombretratamiento) {
        this.nombretratamiento = nombretratamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Profesional> getProfesionalList() {
        return profesionalList;
    }

    public void setProfesionalList(List<Profesional> profesionalList) {
        this.profesionalList = profesionalList;
    }

    @XmlTransient
    public List<Historia> getHistoriaList() {
        return historiaList;
    }

    public void setHistoriaList(List<Historia> historiaList) {
        this.historiaList = historiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtratamiento != null ? idtratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientos)) {
            return false;
        }
        Tratamientos other = (Tratamientos) object;
        if ((this.idtratamiento == null && other.idtratamiento != null) || (this.idtratamiento != null && !this.idtratamiento.equals(other.idtratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tratamientos[ idtratamiento=" + idtratamiento + " ]";
    }
    
}
