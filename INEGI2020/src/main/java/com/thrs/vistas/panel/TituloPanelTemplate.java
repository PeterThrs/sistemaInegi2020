/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel;

import com.thrs.controllers.TituloPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class TituloPanelTemplate extends JPanel{
    
    private TituloPanelController tituloPanelController;
    private String titulo;
    private JPanel pDerecho, pIzquierdo;
    private JLabel lTitulo;
    private GridBagConstraints gbc;
    private Color colorPrincipal, colorSecundario;
    private String indieFlower = "Indie Flower", jet = "JetBrains Mono";
    
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    
    public TituloPanelTemplate(TituloPanelController tituloPanelController, String titulo){
        
        this.tituloPanelController = tituloPanelController;
        this.titulo = titulo;
        this.colorPrincipal = new Color(39,54,77);
        this.colorSecundario = new Color(240,235, 216);
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        
        componentes();
        this.setVisible(true);
    }
    
    private void componentes(){
        paneles();
        jLabels();
    
    }
    
    private void paneles(){
        //Creamos el panel del izuierdo
        pIzquierdo = new JPanel();
        pIzquierdo.setBackground(colorPrincipal);
        pIzquierdo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0.6, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pIzquierdo.setLayout(new GridBagLayout());
        this.add(pIzquierdo, gbc);
        
        //Creamos el panel del derecho
        pDerecho = new JPanel();
        pDerecho.setBackground(colorSecundario);
        pDerecho.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0.4, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerecho.setLayout(new GridBagLayout());
        this.add(pDerecho, gbc);
        
    }
    
    private void jLabels(){
        lTitulo = sObjGraficos.construirJLabel(
                this.titulo,
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontCatalogo(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0.4, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pIzquierdo.add(lTitulo, gbc);
        
    }

    public String getTitulo() {
        return titulo;
    }

    public JPanel getpDerecho() {
        return pDerecho;
    }

    public JPanel getpIzquierdo() {
        return pIzquierdo;
    }

    public JLabel getlTitulo() {
        return lTitulo;
    }
    
}
