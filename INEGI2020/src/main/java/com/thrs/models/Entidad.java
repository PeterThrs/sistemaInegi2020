/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.models;

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
    public String toString() {
        return "Entidad{" + "idEntidad=" + idEntidad + ", nomEntidad=" + nomEntidad + '}';
    }
    
    
    
}
