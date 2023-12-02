/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.entidades;

import com.thrs.vistas.panel.tabla.*;
import com.thrs.TableModels.ModelEntidad;
import com.thrs.controllers.tabla.TablaEntidadesPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Usuario
 */
public class TablaEntidadesPanelTemplateTransacciones extends JPanel {

    private TablaEntidadesPanelControllerTransacciones tablaEntidadesPanelControllerTransacciones;
    private GridBagConstraints gbc;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    //Declaracion objetos para JTable
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private JButton btnAnterior, btnSiguiente;
    //private DefaultTableModel modelo;
    private ModelEntidad modelo;
    private String[] cabecera = {"Id Entidad", "Nombre de Entidad"};

    public TablaEntidadesPanelTemplateTransacciones(TablaEntidadesPanelControllerTransacciones tablaEntidadesPanelControllerTransacciones) {
        this.tablaEntidadesPanelControllerTransacciones = tablaEntidadesPanelControllerTransacciones;

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.tabla = new JTable();
        this.gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        componentes();
        this.setVisible(true);
    }

    private void componentes() {
        this.setBackground(null);
        crearJTable();
    }

    public void crearJTable() {

        modelo = new ModelEntidad();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(tablaEntidadesPanelControllerTransacciones);

        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(580, 30));

        pTabla = sObjGraficos.construirPanelBarra(
                tabla,
                10, 220, 580, 370,
                Color.WHITE,
                null
        );

        header.setDefaultRenderer(
                sGraficosAvanzados.devolverTablaPersonalizada(
                        sRecursos.getColorPrincipal(),
                        null, null,
                        Color.WHITE,
                        sRecursos.getFontLigera())
        );

        tabla.setDefaultRenderer(
                Object.class,
                sGraficosAvanzados.devolverTablaPersonalizada(
                        Color.WHITE, 
                        sRecursos.getColorGrisClaro(), 
                        sRecursos.getColorPrincipalOscuro(), 
                        sRecursos.getColorGrisOscuro(), 
                        sRecursos.getFontLigera())
        );

        pTabla.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10,
                        Color.WHITE,
                        Color.GRAY,
                        sRecursos.getColorGrisOscuro()
                )
        );

        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorPrincipal());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);
        this.add(pTabla);

        gbc = sObjGraficos.getGridBagConstraints(0, 0, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        this.add(pTabla, gbc);
        
        //Creamos los botones de control 
        
        // BOTÓN ANTERIOR--------------------------------------------------------------------
        btnAnterior = sObjGraficos.construirJButton(
                "Anterior",
                300, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnAnterior.addMouseListener(tablaEntidadesPanelControllerTransacciones);
        btnAnterior.addActionListener(tablaEntidadesPanelControllerTransacciones);
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 10);
        this.add(btnAnterior, gbc);

        // BOTÓN SIGUIENTE--------------------------------------------------------------------
        btnSiguiente = sObjGraficos.construirJButton(
                "Siguiente",
                440, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnSiguiente.addMouseListener(tablaEntidadesPanelControllerTransacciones);
        btnSiguiente.addActionListener(tablaEntidadesPanelControllerTransacciones);
        gbc = sObjGraficos.getGridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 10);
        this.add(btnSiguiente, gbc);

    }

    public TablaEntidadesPanelControllerTransacciones getTablaEntidadesPanelControllerTransacciones() {
        return tablaEntidadesPanelControllerTransacciones;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public JPanel getpCorner() {
        return pCorner;
    }

    public JTable getTabla() {
        return tabla;
    }

    public JTableHeader getHeader() {
        return header;
    }

    public ModelEntidad getModelo() {
        return modelo;
    }

    public String[] getCabecera() {
        return cabecera;
    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }
    
    

}
