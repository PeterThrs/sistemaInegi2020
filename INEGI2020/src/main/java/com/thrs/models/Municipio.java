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
public class Municipio {
    
    private int idEntidad;
    private int idMunicipio;
    private String nomMunicipio;
    
    public Municipio(){}

    public Municipio(int idEntidad, int idMunicpio, String nomMunicipio) {
        this.idEntidad = idEntidad;
        this.idMunicipio = idMunicpio;
        this.nomMunicipio = nomMunicipio;
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

    public String getNomMunicipio() {
        return nomMunicipio;
    }

    public void setNomMunicipio(String nomMunicipio) {
        this.nomMunicipio = nomMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idEntidad;
        hash = 29 * hash + this.idMunicipio;
        hash = 29 * hash + Objects.hashCode(this.nomMunicipio);
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
        final Municipio other = (Municipio) obj;
        if (this.idEntidad != other.idEntidad) {
            return false;
        }
        if (this.idMunicipio != other.idMunicipio) {
            return false;
        }
        return Objects.equals(this.nomMunicipio, other.nomMunicipio);
    }

    @Override
    public String toString() {
        return "Municipio{" + "idEntidad=" + idEntidad + ", idMunicipio=" + idMunicipio + ", nomMunicipio=" + nomMunicipio + '}';
    }
    
    
    
    
}
