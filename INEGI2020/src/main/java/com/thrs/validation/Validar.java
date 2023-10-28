/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.validation;

import com.thrs.models.Entidad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Validar {
    
    public static boolean contieneInformacion(String cadena){
        return !cadena.isBlank();
    }
    
    public static boolean esNumero(String cadena){
        try{
            int numero = Integer.parseInt(cadena);
            return true;
        } catch (Exception ex){
            //ex.printStackTrace();
        }
        return false;
    }
    
    public static <T, N>boolean objectosIguales(T t, N n){
        return t.equals(n);
    }
    
    public static <T,E>boolean existeElemento(List<T> t, E e){
        return t.contains(e);
    }
    
    public static boolean compararIdEntidad(List<Entidad> entidades, Entidad entidad){
        boolean bandera = false;
        for(Entidad e: entidades){
            if(e.getIdEntidad() == entidad.getIdEntidad()){
                bandera = true;
                break;
            }
        }
        return bandera;
        
    }
    
}
