/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel.tabla;


import com.thrs.TableModels.ModelCenso2020;
import com.thrs.controllers.tabla.TablaCenso2020PanelController;
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
import javax.swing.table.JTableHeader;

/**
 *
 * @author Usuario
 */
public class TablaCenso2020PanelTemplate extends JPanel {

    private TablaCenso2020PanelController tablaCenso2020PanelController;
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
    private ModelCenso2020 modelo;
    private String[] cabecera = {"Id Entidad","Id Municipio","Id Localidad", "Pob Total", "Pob Femenina", "Pob Masculina"};

    public TablaCenso2020PanelTemplate(TablaCenso2020PanelController tablaCenso2020PanelController) {
        this.tablaCenso2020PanelController = tablaCenso2020PanelController;

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.tabla = new JTable();
        this.gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        componentes();
    }

    private void componentes() {
        this.setBackground(null);
        crearJTable();
    }

    public void crearJTable() {

        modelo = new ModelCenso2020();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(tablaCenso2020PanelController);

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
        btnAnterior.addMouseListener(tablaCenso2020PanelController);
        btnAnterior.addActionListener(tablaCenso2020PanelController);
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
        btnSiguiente.addMouseListener(tablaCenso2020PanelController);
        btnSiguiente.addActionListener(tablaCenso2020PanelController);
        gbc = sObjGraficos.getGridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 10);
        this.add(btnSiguiente, gbc);

    }

    public TablaCenso2020PanelController getTablaCenso2020PanelController() {
        return tablaCenso2020PanelController;
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

    public ModelCenso2020 getModelo() {
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
