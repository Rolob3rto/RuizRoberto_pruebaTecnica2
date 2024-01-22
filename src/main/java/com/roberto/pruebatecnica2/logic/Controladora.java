
package com.roberto.pruebatecnica2.logic;

import com.roberto.pruebatecnica2.persistence.ControladoraPersistencia;
import com.roberto.pruebatecnica2.persistence.exceptions.NonexistentEntityException;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia ctrlPersistencia = new ControladoraPersistencia();
    
    public void crearCiudadano(Ciudadano ciudadano){
        ctrlPersistencia.crearCiudadano(ciudadano);        
    }
    
    public void crearTruno(Turno turno){
        ctrlPersistencia.crearTurno(turno);
    }
    
    public void eliminarCiudadano(int id) throws NonexistentEntityException{
        ctrlPersistencia.eliminarCiudadano(id);
    }
    
    public  void eliminarTurno(int id) throws NonexistentEntityException{
        ctrlPersistencia.eliminarTurno(id);        
    }
    
    public void editarCiudadano(Ciudadano ciudadano) throws Exception{
        ctrlPersistencia.editarCiudadano(ciudadano);        
    }
    
    public void editarTurno(Turno turno) throws Exception{
        ctrlPersistencia.editarTurno(turno);        
    }
    
    public List<Ciudadano> listarCiudadanos(){
        return ctrlPersistencia.listadoCiudadanos();
    }
    
    public List<Turno>  listarTurnos(){
        return ctrlPersistencia.listadoTurnos();
    }
    
    public Ciudadano ciudadanoPorId(int id){
        return ctrlPersistencia.ciudadanoPorId(id);
    }
    
    public Turno turnoPorId(int id){
        return ctrlPersistencia.turnoPorId(id);
    }
    
}
