/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import com.thrs.vistas.panel.TituloPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Usuario
 */
public class TituloPanelController extends MouseAdapter implements ActionListener {
    
    private PrincipalController principalController;
    private TituloPanelTemplate tituloPanelTemplate;
    
    public TituloPanelController(PrincipalController principalController, String titulo){
        this.principalController = principalController;
        this.tituloPanelTemplate = new TituloPanelTemplate(this, titulo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TituloPanelTemplate getTituloPanelTemplate() {
        return tituloPanelTemplate;
    }
    
    
    
}
