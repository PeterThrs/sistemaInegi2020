/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas;

import com.thrs.controllers.MenuController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
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
public class MenuTemplate extends JFrame {

    private MenuController menuController;

    private JPanel pDerecho, pIzquierdo, pDerCentrado, pTitulo;
    private GridBagConstraints gbc;
    private ImageIcon imagen;
    private JButton btnEntidad, btnMunicipio, btnLocalidad, btnCenso, btnPoblacion, btnSalir,
                    btnPobEstado, btnTransaccion;
    private Color colorPrincipal, colorSecundario;
    private JLabel lCatalogo, l1, l2, l3, l4, l5, l6, l7, l8, l9;

    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;

    private String indieFlower = "Indie Flower", jet = "JetBrains Mono";
    private Image image;

    public MenuTemplate(MenuController menuController) {

        this.menuController = menuController;
        
        image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/imgRobot.png"));
        this.setTitle("INEGI2020");
        this.setIconImage(image);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        this.colorPrincipal = new Color(39, 54, 77);
        this.colorSecundario = new Color(240, 235, 216);
        this.btnEntidad = new JButton("Entidades");
        this.btnMunicipio = new JButton("Municipio");
        this.btnLocalidad = new JButton("Localidad");
        this.btnCenso = new JButton("Censo 2020");
        this.btnPoblacion = new JButton("Poblacion Edad");

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.setResizable(false);
        this.setUndecorated(true);

        this.setLayout(new GridBagLayout());

        componentes();

        this.setVisible(true);
    }

    private void componentes() {
        paneles();
        addButtons();
        addLabels();
    }

    private void paneles() {
        gbc = new GridBagConstraints();

        //Creamos el panel izquierdo y lo agregamos a la ventana
        pIzquierdo = new JPanel();
        pIzquierdo.setBackground(colorPrincipal);
        pIzquierdo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0.40, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pIzquierdo.setLayout(new GridBagLayout());
        this.add(pIzquierdo, gbc);

        //Creamos el panel derecho y lo agregamos a la ventana
        pDerecho = new JPanel();
        pDerecho.setBackground(Color.WHITE);
        pDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gbc = sObjGraficos.getGridBagConstraints(1, 0, 1, 1, 0.60, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerecho.setLayout(new GridBagLayout());
        this.add(pDerecho, gbc);

        //Creamos el panel ptitulo
        pTitulo = new JPanel();
        pTitulo.setBackground(Color.GRAY);
        pTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 0.3, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pTitulo.setLayout(new GridBagLayout());
        pDerecho.add(pTitulo, gbc);

        //Creamos el panel pIzqCentrado
        pDerCentrado = new JPanel();
        //pIzqCentrado.setBackground(new Color(112,155, 188));
        pDerCentrado.setBackground(colorSecundario);
        pDerCentrado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 0.7, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.setLayout(new GridBagLayout());
        pDerecho.add(pDerCentrado, gbc);

    }

    private void addLabels() {
        lCatalogo = sObjGraficos.construirJLabel(
                "CATALOGOS",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontCatalogo(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        pTitulo.add(lCatalogo, gbc);
        
        //NOMBRE DE LA APLICACION =============================================================================================================================================================================
        
        l1 = sObjGraficos.construirJLabel(
                "I",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l1, gbc);
        
        
        l2 = sObjGraficos.construirJLabel(
                "N",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l2, gbc);
        
        l3 = sObjGraficos.construirJLabel(
                "E",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l3, gbc);
        
        l4 = sObjGraficos.construirJLabel(
                "G",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l4, gbc);
        
        l5 = sObjGraficos.construirJLabel(
                "I",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 2, 10), 0, 0);
        pIzquierdo.add(l5, gbc);
        
        l6 = sObjGraficos.construirJLabel(
                "2",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(2, 10, 0, 10), 0, 0);
        pIzquierdo.add(l6, gbc);
        
        l7 = sObjGraficos.construirJLabel(
                "0",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l7, gbc);
        
        
        l8 = sObjGraficos.construirJLabel(
                "2",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l8, gbc);
        
        l9 = sObjGraficos.construirJLabel(
                "0",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontConcertOne(),
                null,
                Color.WHITE,
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(0, 10, 0, 10), 0, 0);
        pIzquierdo.add(l9, gbc);
        
        
    }

    private void addButtons() {
        //Btn Entidades
        btnEntidad = sObjGraficos.construirJButton(
                "Entidades",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnEntidad.addMouseListener(menuController);
        btnEntidad.addActionListener(menuController);

        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnEntidad, gbc);

        //Btn Municipios
        btnMunicipio = sObjGraficos.construirJButton(
                "Municipio",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnMunicipio.addMouseListener(menuController);
        btnMunicipio.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER,new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnMunicipio, gbc);

        //Btn localidades
        btnLocalidad = sObjGraficos.construirJButton(
                "Localidad",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnLocalidad.addMouseListener(menuController);
        btnLocalidad.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnLocalidad, gbc);

        //Btn Censo 2020
        btnCenso = sObjGraficos.construirJButton(
                "Censo 2020",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnCenso.addMouseListener(menuController);
        btnCenso.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnCenso, gbc);

        //Btn Poblacion Edad
        btnPoblacion = sObjGraficos.construirJButton(
                "Poblacion Edad",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnPoblacion.addMouseListener(menuController);
        btnPoblacion.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnPoblacion, gbc);
        
        //Btn poblacion por estado
         btnPobEstado = sObjGraficos.construirJButton(
                "Poblacion por Estado",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnPobEstado.addMouseListener(menuController);
        btnPobEstado.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnPobEstado, gbc);
        
        //Btn para las trasacciones
         btnTransaccion = sObjGraficos.construirJButton(
                "Transaccion",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnTransaccion.addMouseListener(menuController);
        btnTransaccion.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnTransaccion, gbc);
        
        //Btn Poblacion Edad
        btnSalir = sObjGraficos.construirJButton(
                "Cerrar Sesion",
                430, 65, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontPrincipalMenu(),
                null,
                colorPrincipal,
                null,
                "c",
                true
        );
        btnSalir.addMouseListener(menuController);
        btnSalir.addActionListener(menuController);
        this.repaint();
        gbc = sObjGraficos.getGridBagConstraints(0, 7, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pDerCentrado.add(btnSalir, gbc);
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public JPanel getpDerecho() {
        return pDerecho;
    }

    public JPanel getpIzquierdo() {
        return pIzquierdo;
    }

    public JPanel getpDerCentrado() {
        return pDerCentrado;
    }

    public JPanel getpTitulo() {
        return pTitulo;
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

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnPobEstado() {
        return btnPobEstado;
    }

    public JButton getBtnTransaccion() {
        return btnTransaccion;
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
        return lCatalogo;
    }

    
}
