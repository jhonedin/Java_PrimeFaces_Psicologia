/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Historia.findByIdhistoria", query = "SELECT h FROM Historia h WHERE h.historiaPK.idhistoria = :idhistoria")
    , @NamedQuery(name = "Historia.findByIdcita", query = "SELECT h FROM Historia h WHERE h.historiaPK.idcita = :idcita")
    , @NamedQuery(name = "Historia.findByDescripcion", query = "SELECT h FROM Historia h WHERE h.descripcion = :descripcion")})
public class Historia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoriaPK historiaPK;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "historiaList")
    private List<Tratamientos> tratamientosList;
    @JoinColumn(name = "idcita", referencedColumnName = "idcita", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cita cita;

    public Historia() {
    }

    public Historia(HistoriaPK historiaPK) {
        this.historiaPK = historiaPK;
    }

    public Historia(int idhistoria, int idcita) {
        this.historiaPK = new HistoriaPK(idhistoria, idcita);
    }

    public HistoriaPK getHistoriaPK() {
        return historiaPK;
    }

    public void setHistoriaPK(HistoriaPK historiaPK) {
        this.historiaPK = historiaPK;
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

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historiaPK != null ? historiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.historiaPK == null && other.historiaPK != null) || (this.historiaPK != null && !this.historiaPK.equals(other.historiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Historia[ historiaPK=" + historiaPK + " ]";
    }
    
}
