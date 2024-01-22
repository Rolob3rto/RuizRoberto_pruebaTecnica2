
package com.roberto.pruebatecnica2.persistence;

import com.roberto.pruebatecnica2.logic.Ciudadano;
import com.roberto.pruebatecnica2.logic.Turno;
import com.roberto.pruebatecnica2.persistence.exceptions.NonexistentEntityException;
import java.util.List;

public class ControladoraPersistencia {
    
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    
    public void crearCiudadano(Ciudadano ciudadano){
        ciudadanoJPA.create(ciudadano);
    }
    
    public void crearTurno(Turno turno){
        turnoJPA.create(turno);        
    }
    
    public void eliminarCiudadano(int id) throws NonexistentEntityException{
        ciudadanoJPA.destroy(id);
    }
    
    public void eliminarTurno(int id) throws NonexistentEntityException {
        turnoJPA.destroy(id);        
    }
    
    public void editarCiudadano(Ciudadano ciudadano) throws Exception{
        ciudadanoJPA.edit(ciudadano);
    }
    
    public void editarTurno(Turno turno) throws Exception{
        turnoJPA.edit(turno);
    }
    
    public List<Ciudadano> listadoCiudadanos(){
        return ciudadanoJPA.findCiudadanoEntities();
    }
    
    public List<Turno> listadoTurnos(){
        return turnoJPA.findTurnoEntities();
    }
    
    public Turno turnoPorId(int id){
        return turnoJPA.findTurno(id);
    }      
    
    public Ciudadano ciudadanoPorId(int id){
        return ciudadanoJPA.findCiudadano(id);
    }       
}
