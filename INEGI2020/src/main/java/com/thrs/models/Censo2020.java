/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.models;

/**
 *
 * @author Usuario
 */
public class Censo2020 {
    
    private int idEntidad;
    private int idMunicipio;
    private int idLocalidad;
    private int pobTotal;
    private int pobFemenina;
    private int pobMasculina;
    
    public Censo2020(){
        
    }

    public Censo2020(int idEntidad, int idMunicpio, int idLocalidad, int pobTotal, int pobFemenina, int pobMasculina) {
        this.idEntidad = idEntidad;
        this.idMunicipio = idMunicpio;
        this.idLocalidad = idLocalidad;
        this.pobTotal = pobTotal;
        this.pobFemenina = pobFemenina;
        this.pobMasculina = pobMasculina;
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

    public int getPobTotal() {
        return pobTotal;
    }

    public void setPobTotal(int pobTotal) {
        this.pobTotal = pobTotal;
    }

    public int getPobFemenina() {
        return pobFemenina;
    }

    public void setPobFemenina(int pobFemenina) {
        this.pobFemenina = pobFemenina;
    }

    public int getPobMasculina() {
        return pobMasculina;
    }

    public void setPobMasculina(int pobMasculina) {
        this.pobMasculina = pobMasculina;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idEntidad;
        hash = 79 * hash + this.idMunicipio;
        hash = 79 * hash + this.idLocalidad;
        hash = 79 * hash + this.pobTotal;
        hash = 79 * hash + this.pobFemenina;
        hash = 79 * hash + this.pobMasculina;
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
        final Censo2020 other = (Censo2020) obj;
        if (this.idEntidad != other.idEntidad) {
            return false;
        }
        if (this.idMunicipio != other.idMunicipio) {
            return false;
        }
        if (this.idLocalidad != other.idLocalidad) {
            return false;
        }
        if (this.pobTotal != other.pobTotal) {
            return false;
        }
        if (this.pobFemenina != other.pobFemenina) {
            return false;
        }
        return this.pobMasculina == other.pobMasculina;
    }

    

    @Override
    public String toString() {
        return "Censo2020{" + "idEntidad=" + idEntidad + ", idMunicpio=" + idMunicipio + ", idLocalidad=" + idLocalidad + ", pobTotal=" + pobTotal + ", pobFemenina=" + pobFemenina + ", pobMasculina=" + pobMasculina + '}';
    }
    
    
    
    
}
