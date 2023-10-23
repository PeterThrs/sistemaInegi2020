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
    public String toString() {
        return "Censo2020{" + "idEntidad=" + idEntidad + ", idMunicpio=" + idMunicipio + ", idLocalidad=" + idLocalidad + ", pobTotal=" + pobTotal + ", pobFemenina=" + pobFemenina + ", pobMasculina=" + pobMasculina + '}';
    }
    
    
    
    
}
