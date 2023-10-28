/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.models;

import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Entidad {
    
    private int idEntidad;
    private String nomEntidad;
    
    public Entidad(){}
    
    public Entidad(int idEntidad, String nomEntidad){
        this.idEntidad = idEntidad;
        this.nomEntidad = nomEntidad;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNomEntidad() {
        return nomEntidad;
    }

    public void setNomEntidad(String nomEntidad) {
        this.nomEntidad = nomEntidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idEntidad;
        hash = 41 * hash + Objects.hashCode(this.nomEntidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entidad other = (Entidad) obj;
        if (this.idEntidad != other.idEntidad) {
            return false;
        }
        return Objects.equals(this.nomEntidad, other.nomEntidad);
    }
    

    @Override
    public String toString() {
        return "Entidad{" + "idEntidad=" + idEntidad + ", nomEntidad=" + nomEntidad + '}';
    }
    
    
    
}
