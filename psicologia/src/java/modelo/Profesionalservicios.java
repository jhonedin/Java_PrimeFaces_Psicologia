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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "profesionalservicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesionalservicios.findAll", query = "SELECT p FROM Profesionalservicios p")
    , @NamedQuery(name = "Profesionalservicios.findByIdprofesionalservicios", query = "SELECT p FROM Profesionalservicios p WHERE p.idprofesionalservicios = :idprofesionalservicios")
    , @NamedQuery(name = "Profesionalservicios.findByDescripcionPerfil", query = "SELECT p FROM Profesionalservicios p WHERE p.descripcionPerfil = :descripcionPerfil")
    , @NamedQuery(name = "Profesionalservicios.findByPrecio", query = "SELECT p FROM Profesionalservicios p WHERE p.precio = :precio")
    , @NamedQuery(name = "Profesionalservicios.findByDuracion", query = "SELECT p FROM Profesionalservicios p WHERE p.duracion = :duracion")})
public class Profesionalservicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesionalservicios")
    private Integer idprofesionalservicios;
    @Size(max = 200)
    @Column(name = "descripcionPerfil")
    private String descripcionPerfil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne(optional = false)
    private Servicios idservicio;
    @JoinColumn(name = "idprofesional", referencedColumnName = "idprofesional")
    @ManyToOne(optional = false)
    private Profesional idprofesional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesionalservicios")
    private List<Cita> citaList;

    public Profesionalservicios() {
    }

    public Profesionalservicios(Integer idprofesionalservicios) {
        this.idprofesionalservicios = idprofesionalservicios;
    }

    public Profesionalservicios(Integer idprofesionalservicios, int precio, int duracion) {
        this.idprofesionalservicios = idprofesionalservicios;
        this.precio = precio;
        this.duracion = duracion;
    }

    public Integer getIdprofesionalservicios() {
        return idprofesionalservicios;
    }

    public void setIdprofesionalservicios(Integer idprofesionalservicios) {
        this.idprofesionalservicios = idprofesionalservicios;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Servicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicios idservicio) {
        this.idservicio = idservicio;
    }

    public Profesional getIdprofesional() {
        return idprofesional;
    }

    public void setIdprofesional(Profesional idprofesional) {
        this.idprofesional = idprofesional;
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
        hash += (idprofesionalservicios != null ? idprofesionalservicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesionalservicios)) {
            return false;
        }
        Profesionalservicios other = (Profesionalservicios) object;
        if ((this.idprofesionalservicios == null && other.idprofesionalservicios != null) || (this.idprofesionalservicios != null && !this.idprofesionalservicios.equals(other.idprofesionalservicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Profesionalservicios[ idprofesionalservicios=" + idprofesionalservicios + " ]";
    }
    
}
