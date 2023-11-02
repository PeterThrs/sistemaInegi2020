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
public class Localidad {
    
    private int idEntidad;
    private int idMunicipio;
    private int idLocalidad;
    private String nomLocalidad;
    
    public Localidad(){}

    public Localidad(int idEntidad, int idMunicpio, int idLocalidad, String nomLocalidad) {
        this.idEntidad = idEntidad;
        this.idMunicipio = idMunicpio;
        this.idLocalidad = idLocalidad;
        this.nomLocalidad = nomLocalidad;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public String getNomLocalidad() {
        return nomLocalidad;
    }

    public void setNomLocalidad(String nomLocalidad) {
        this.nomLocalidad = nomLocalidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idEntidad;
        hash = 41 * hash + this.idMunicipio;
        hash = 41 * hash + this.idLocalidad;
        hash = 41 * hash + Objects.hashCode(this.nomLocalidad);
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
        final Localidad other = (Localidad) obj;
        if (this.idEntidad != other.idEntidad) {
            return false;
        }
        if (this.idMunicipio != other.idMunicipio) {
            return false;
        }
        if (this.idLocalidad != other.idLocalidad) {
            return false;
        }
        return Objects.equals(this.nomLocalidad, other.nomLocalidad);
    }
    
    
    

    @Override
    public String toString() {
        return "Localidad{" + "idEntidad=" + idEntidad + ", idMunicpio=" + idMunicipio + ", idLocalidad=" + idLocalidad + ", nomLocalidad=" + nomLocalidad + '}';
    }
    
    
    
}
