/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    , @NamedQuery(name = "Pagos.findByIdpago", query = "SELECT p FROM Pagos p WHERE p.pagosPK.idpago = :idpago")
    , @NamedQuery(name = "Pagos.findByIdcita", query = "SELECT p FROM Pagos p WHERE p.pagosPK.idcita = :idcita")
    , @NamedQuery(name = "Pagos.findByEstadopago", query = "SELECT p FROM Pagos p WHERE p.estadopago = :estadopago")
    , @NamedQuery(name = "Pagos.findByFechapago", query = "SELECT p FROM Pagos p WHERE p.fechapago = :fechapago")
    , @NamedQuery(name = "Pagos.findByMediodepago", query = "SELECT p FROM Pagos p WHERE p.mediodepago = :mediodepago")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagosPK pagosPK;
    @Size(max = 20)
    @Column(name = "estadopago")
    private String estadopago;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Size(max = 20)
    @Column(name = "mediodepago")
    private String mediodepago;
    @JoinColumn(name = "idcita", referencedColumnName = "idcita", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cita cita;

    public Pagos() {
    }

    public Pagos(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
    }

    public Pagos(int idpago, int idcita) {
        this.pagosPK = new PagosPK(idpago, idcita);
    }

    public PagosPK getPagosPK() {
        return pagosPK;
    }

    public void setPagosPK(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
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

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagosPK != null ? pagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.pagosPK == null && other.pagosPK != null) || (this.pagosPK != null && !this.pagosPK.equals(other.pagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pagos[ pagosPK=" + pagosPK + " ]";
    }
    
}
