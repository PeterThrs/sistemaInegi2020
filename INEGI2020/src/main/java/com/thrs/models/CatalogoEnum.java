/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.models;

/**
 *
 * @author Usuario
 */
public enum CatalogoEnum {
    ENTIDAD("Entidades"),
    MUNICIPIO("Municipios"),
    LOCALIDAD("Localidades"),
    CENSO_2020("Censo 2020"),
    POBLACION_EDAD("Poblacion Edad");
    
    private final String valor;
    
    CatalogoEnum(String valor){
        this.valor = valor;
    }
    
    public String getValor(){
        return this.valor;
    }
    
}
