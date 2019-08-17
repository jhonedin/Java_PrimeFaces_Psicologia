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
public class CitaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idcita")
    private int idcita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpaciente")
    private int idpaciente;

    public CitaPK() {
    }

    public CitaPK(int idcita, int idpaciente) {
        this.idcita = idcita;
        this.idpaciente = idpaciente;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcita;
        hash += (int) idpaciente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CitaPK)) {
            return false;
        }
        CitaPK other = (CitaPK) object;
        if (this.idcita != other.idcita) {
            return false;
        }
        if (this.idpaciente != other.idpaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CitaPK[ idcita=" + idcita + ", idpaciente=" + idpaciente + " ]";
    }
    
}
