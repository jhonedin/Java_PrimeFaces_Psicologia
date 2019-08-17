/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CRISTHIAN
 */
@Embeddable
public class PagosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idpago")
    private int idpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcita")
    private int idcita;

    public PagosPK() {
    }

    public PagosPK(int idpago, int idcita) {
        this.idpago = idpago;
        this.idcita = idcita;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpago;
        hash += (int) idcita;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosPK)) {
            return false;
        }
        PagosPK other = (PagosPK) object;
        if (this.idpago != other.idpago) {
            return false;
        }
        if (this.idcita != other.idcita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PagosPK[ idpago=" + idpago + ", idcita=" + idcita + " ]";
    }
    
}
