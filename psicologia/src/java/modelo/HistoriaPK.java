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
public class HistoriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idhistoria")
    private int idhistoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcita")
    private int idcita;

    public HistoriaPK() {
    }

    public HistoriaPK(int idhistoria, int idcita) {
        this.idhistoria = idhistoria;
        this.idcita = idcita;
    }

    public int getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(int idhistoria) {
        this.idhistoria = idhistoria;
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
        hash += (int) idhistoria;
        hash += (int) idcita;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaPK)) {
            return false;
        }
        HistoriaPK other = (HistoriaPK) object;
        if (this.idhistoria != other.idhistoria) {
            return false;
        }
        if (this.idcita != other.idcita) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HistoriaPK[ idhistoria=" + idhistoria + ", idcita=" + idcita + " ]";
    }
    
}
