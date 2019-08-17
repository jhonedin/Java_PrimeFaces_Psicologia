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
public class ProfesionalPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idprofesional")
    private int idprofesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idusuario")
    private int idusuario;

    public ProfesionalPK() {
    }

    public ProfesionalPK(int idprofesional, int idusuario) {
        this.idprofesional = idprofesional;
        this.idusuario = idusuario;
    }

    public int getIdprofesional() {
        return idprofesional;
    }

    public void setIdprofesional(int idprofesional) {
        this.idprofesional = idprofesional;
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
        hash += (int) idprofesional;
        hash += (int) idusuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionalPK)) {
            return false;
        }
        ProfesionalPK other = (ProfesionalPK) object;
        if (this.idprofesional != other.idprofesional) {
            return false;
        }
        if (this.idusuario != other.idusuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProfesionalPK[ idprofesional=" + idprofesional + ", idusuario=" + idusuario + " ]";
    }
    
}
