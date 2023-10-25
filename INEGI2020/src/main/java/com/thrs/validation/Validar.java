/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.validation;

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
            ex.printStackTrace();
        }
        return false;
    }
}
