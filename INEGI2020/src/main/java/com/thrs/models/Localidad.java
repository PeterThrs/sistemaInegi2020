/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.models;

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
    public String toString() {
        return "Localidad{" + "idEntidad=" + idEntidad + ", idMunicpio=" + idMunicipio + ", idLocalidad=" + idLocalidad + ", nomLocalidad=" + nomLocalidad + '}';
    }
    
    
    
}
