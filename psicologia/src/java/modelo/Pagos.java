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
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")
    , @NamedQuery(name = "Pagos.findByIdpago", query = "SELECT p FROM Pagos p WHERE p.idpago = :idpago")
    , @NamedQuery(name = "Pagos.findByEstadopago", query = "SELECT p FROM Pagos p WHERE p.estadopago = :estadopago")
    , @NamedQuery(name = "Pagos.findByFechapago", query = "SELECT p FROM Pagos p WHERE p.fechapago = :fechapago")
    , @NamedQuery(name = "Pagos.findByMediodepago", query = "SELECT p FROM Pagos p WHERE p.mediodepago = :mediodepago")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    @Size(max = 20)
    @Column(name = "estadopago")
    private String estadopago;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Size(max = 20)
    @Column(name = "mediodepago")
    private String mediodepago;
    @JoinColumn(name = "idcita", referencedColumnName = "idcita")
    @ManyToOne(optional = false)
    private Cita idcita;

    public Pagos() {
    }

    public Pagos(Integer idpago) {
        this.idpago = idpago;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getMediodepago() {
        return mediodepago;
    }

    public void setMediodepago(String mediodepago) {
        this.mediodepago = mediodepago;
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
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pagos[ idpago=" + idpago + " ]";
    }
    
}
