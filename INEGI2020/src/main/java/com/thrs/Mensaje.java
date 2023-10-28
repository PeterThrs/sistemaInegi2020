/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Mensaje {
    
    public static void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(null,
                mensaje, 
                "Alerta", 
                JOptionPane.ERROR_MESSAGE
        );
    }
    
    public static void mensajeAdvertencia(String mensaje){
        JOptionPane.showMessageDialog(null,
                mensaje, 
                "Alerta", 
                JOptionPane.WARNING_MESSAGE
        );
    }
    
    public static void mensajeInformativo(String mensaje){
        JOptionPane.showMessageDialog(null,
                mensaje, 
                "Alerta", 
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
}
