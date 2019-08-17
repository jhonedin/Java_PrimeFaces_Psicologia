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
public class PacientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idpaciente")
    private int idpaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public PacientePK() {
    }

    public PacientePK(int idpaciente, int idusuario) {
        this.idpaciente = idpaciente;
        this.idusuario = idusuario;
    }

    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idpaciente;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacientePK)) {
            return false;
        }
        PacientePK other = (PacientePK) object;
        if (this.idpaciente != other.idpaciente) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PacientePK[ idpaciente=" + idpaciente + ", idusuario=" + idusuario + " ]";
    }
    
}
