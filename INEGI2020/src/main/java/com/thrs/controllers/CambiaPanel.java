/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import com.thrs.services.graphicServices.ObjGraficosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Usuario
 */
public class CambiaPanel {
    
    private JPanel container;
    private JPanel content;
    private JScrollPane scroll;

    public CambiaPanel(JPanel container, JPanel content) {
        ObjGraficosService obj = ObjGraficosService.getService();;
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.setBackground(Color.WHITE);
        this.container.revalidate();
        this.container.repaint();
        
        GridBagConstraints gbc = obj.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        this.container.add(this.content, gbc);
        this.container.revalidate();
        this.container.repaint();
    }
    
    public CambiaPanel(JPanel container, JScrollPane content) {
        ObjGraficosService obj = ObjGraficosService.getService();;
        this.container = container;
        this.scroll = content;
        this.container.removeAll();
        this.container.setBackground(Color.WHITE);
        this.container.revalidate();
        this.container.repaint();
        
        GridBagConstraints gbc = obj.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        this.container.add(this.scroll, gbc);
        this.container.revalidate();
        this.container.repaint();
    }
    
}
