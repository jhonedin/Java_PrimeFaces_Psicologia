/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CRISTHIAN
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByIdcita", query = "SELECT c FROM Cita c WHERE c.idcita = :idcita")
    , @NamedQuery(name = "Cita.findByFechacita", query = "SELECT c FROM Cita c WHERE c.fechacita = :fechacita")
    , @NamedQuery(name = "Cita.findByHorainicio", query = "SELECT c FROM Cita c WHERE c.horainicio = :horainicio")
    , @NamedQuery(name = "Cita.findByHorafinal", query = "SELECT c FROM Cita c WHERE c.horafinal = :horafinal")
    , @NamedQuery(name = "Cita.findByDescripcion", query = "SELECT c FROM Cita c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Cita.findByEstadocita", query = "SELECT c FROM Cita c WHERE c.estadocita = :estadocita")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcita")
    private Integer idcita;
    @Column(name = "fechacita")
    @Temporal(TemporalType.DATE)
    private Date fechacita;
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Column(name = "horafinal")
    @Temporal(TemporalType.TIME)
    private Date horafinal;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 20)
    @Column(name = "estadocita")
    private String estadocita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcita")
    private List<Historia> historiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcita")
    private List<Pagos> pagosList;
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
    @ManyToOne(optional = false)
    private Paciente idpaciente;
    @JoinColumn(name = "idprofesionalservicios", referencedColumnName = "idprofesionalservicios")
    @ManyToOne(optional = false)
    private Profesionalservicios idprofesionalservicios;

    public Cita() {
    }

    public Cita(Integer idcita) {
        this.idcita = idcita;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadocita() {
        return estadocita;
    }

    public void setEstadocita(String estadocita) {
        this.estadocita = estadocita;
    }

    @XmlTransient
    public List<Historia> getHistoriaList() {
        return historiaList;
    }

    public void setHistoriaList(List<Historia> historiaList) {
        this.historiaList = historiaList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Profesionalservicios getIdprofesionalservicios() {
        return idprofesionalservicios;
    }

    public void setIdprofesionalservicios(Profesionalservicios idprofesionalservicios) {
        this.idprofesionalservicios = idprofesionalservicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cita[ idcita=" + idcita + " ]";
    }
    
}
