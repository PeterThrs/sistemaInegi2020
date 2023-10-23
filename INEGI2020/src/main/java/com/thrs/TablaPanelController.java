/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.services.EntidadService;
import com.thrs.vistas.panel.TablaPanelTemplate;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TablaPanelController extends MouseAdapter implements ActionListener{

    private PrincipalController principalController;
    private TablaPanelTemplate tablaPanelTemplate;
    private EntidadService sEntidad;
    private List<Entidad> entidades;
    
    public TablaPanelController(PrincipalController principalController){
        this.principalController = principalController;
        this.tablaPanelTemplate = new TablaPanelTemplate(this);
        this.sEntidad = sEntidad.getService();
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaPanelTemplate getTablaPanelTemplate() {
        return tablaPanelTemplate;
    }
    
    
    
    
}
