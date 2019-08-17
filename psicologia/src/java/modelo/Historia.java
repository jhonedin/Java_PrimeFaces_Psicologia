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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "historia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h")
    , @NamedQuery(name = "Historia.findByIdhistoria", query = "SELECT h FROM Historia h WHERE h.idhistoria = :idhistoria")
    , @NamedQuery(name = "Historia.findByDescripcion", query = "SELECT h FROM Historia h WHERE h.descripcion = :descripcion")})
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistoria")
    private Integer idhistoria;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "historiaList")
    private List<Tratamientos> tratamientosList;
    @JoinColumn(name = "idcita", referencedColumnName = "idcita")
    @ManyToOne(optional = false)
    private Cita idcita;

    public Historia() {
    }

    public Historia(Integer idhistoria) {
        this.idhistoria = idhistoria;
    }

    public Integer getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(Integer idhistoria) {
        this.idhistoria = idhistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Tratamientos> getTratamientosList() {
        return tratamientosList;
    }

    public void setTratamientosList(List<Tratamientos> tratamientosList) {
        this.tratamientosList = tratamientosList;
    }

    public Cita getIdcita() {
        return idcita;
    }

    public void setIdcita(Cita idcita) {
        this.idcita = idcita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistoria != null ? idhistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idhistoria == null && other.idhistoria != null) || (this.idhistoria != null && !this.idhistoria.equals(other.idhistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Historia[ idhistoria=" + idhistoria + " ]";
    }
    
}
