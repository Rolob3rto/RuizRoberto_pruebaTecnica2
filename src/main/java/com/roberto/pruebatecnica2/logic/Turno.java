
package com.roberto.pruebatecnica2.logic;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate fecha;
    private int numero;
    private String descripcion;        
    private Boolean estado;
    
    @ManyToOne
    @JoinColumn(name = "ciudadano_id", referencedColumnName = "id")    
    private Ciudadano ciudadano;

    public Turno() {
    }

    public Turno(LocalDate fecha, int numero, String descripcion, Boolean estado, Ciudadano ciudadano) {
        this.fecha = fecha;
        this.numero = numero;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return "Turno{" + "id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", descripcion=" + descripcion + ", estado=" + estado + ", ciudadano=" + ciudadano + '}';
    }
    
    
}
