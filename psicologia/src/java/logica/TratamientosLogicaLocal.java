/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Tratamientos;

/**
 *
 * @author CRISTHIAN
 */
@Local
public interface TratamientosLogicaLocal {
    
    public void registarTratamiento(Tratamientos tratamiento) throws Exception;
    public void modificarTratamiento(Tratamientos tratamiento) throws Exception;
    public void eliminarTratamiento(Tratamientos tratamiento) throws Exception;
    public void importarTratamiento(Tratamientos tratamiento) throws Exception;
    public List<Tratamientos> ConsultarTratamientos() throws Exception;
    
}
