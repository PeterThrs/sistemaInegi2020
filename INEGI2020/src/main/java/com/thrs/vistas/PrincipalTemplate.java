/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas;

import com.thrs.controllers.PrincipalController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PrincipalTemplate extends JFrame{
    
    private PrincipalController principalController;
    
    private JPanel pTitulo, pIntermedio, pTabla, pDatos, pBotones;
    private GridBagConstraints gbc;
    private ImageIcon imagen;
    private JButton btnEntidad, btnMunicipio, btnLocalidad, btnCenso, btnPoblacion;
    private Color colorPrincipal, colorSecundario;
    private JLabel tCatalogo;
    
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    
    private String indieFlower = "Indie Flower", jet = "JetBrains Mono";
    
    
    public PrincipalTemplate(PrincipalController principalController){
        
        this.principalController = principalController;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        
        this.colorPrincipal = new Color(39,54,77);
        this.colorSecundario = new Color(240,235, 216);
        this.btnEntidad = new JButton("Entidades");
        this.btnMunicipio = new JButton("Municipio");
        this.btnLocalidad = new JButton("Localidad");
        this.btnCenso = new JButton("Censo 2020");
        this.btnPoblacion = new JButton("Poblacion Edad");
        
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        
        //configuracion ventana al 100%
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        this.setResizable(false);
        this.setUndecorated(true);
        this.setBounds(bounds);
        
        this.setLayout(new GridBagLayout());
        
        componentes();
        
        this.setVisible(true);
    }
    
    private void componentes(){
        paneles();
    }
    
    private void paneles(){
        gbc = new GridBagConstraints();
        
        //Creamos el panel del titulo
        pTitulo = new JPanel();
        pTitulo.setBackground(colorPrincipal);
        pTitulo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 0.1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pTitulo.setLayout(new GridBagLayout());
        this.add(pTitulo, gbc);
        
        //Creamos el panel intermedio
        pIntermedio = new JPanel();
        pIntermedio.setBackground(sRecursos.getColorGrisClaro());
        pIntermedio.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 0.8, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pIntermedio.setLayout(new GridBagLayout());
        this.add(pIntermedio, gbc);
        
        //Creamos el panel de los datos
        pDatos = new JPanel();
        pDatos.setBackground(Color.YELLOW);
        pDatos.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0.3, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDatos.setLayout(new GridBagLayout());
        pIntermedio.add(pDatos, gbc);
        
        //Creamos el panel de la tabla
        pTabla = new JPanel();
        pTabla.setBackground(Color.cyan);
        pTabla.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(1, 0, 1, 1, 0.7, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pTabla.setLayout(new GridBagLayout());
        pIntermedio.add(pTabla, gbc);
        
        //Creamos el panel de los botones
        pBotones = new JPanel();
        pBotones.setBackground(Color.GRAY);
        pBotones.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gbc = sObjGraficos.getGridBagConstraints(0, 3, 1, 1, 1, 0.1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pBotones.setLayout(new GridBagLayout());
        this.add(pBotones, gbc);
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public JPanel getpTitulo() {
        return pTitulo;
    }

    public JPanel getpTabla() {
        return pTabla;
    }

    public JPanel getpDatos() {
        return pDatos;
    }

    public JPanel getpBotones() {
        return pBotones;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public JButton getBtnEntidad() {
        return btnEntidad;
    }

    public JButton getBtnMunicipio() {
        return btnMunicipio;
    }

    public JButton getBtnLocalidad() {
        return btnLocalidad;
    }

    public JButton getBtnCenso() {
        return btnCenso;
    }

    public JButton getBtnPoblacion() {
        return btnPoblacion;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public JLabel gettCatalogo() {
        return tCatalogo;
    }

    public String getIndieFlower() {
        return indieFlower;
    }

    public String getJet() {
        return jet;
    }
    
    
    
}
