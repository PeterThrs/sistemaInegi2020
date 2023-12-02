/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel.tabla;

import com.thrs.TableModels.ModelPoblacionEdad;
import com.thrs.controllers.tabla.TablaPoblacionEdadPanelController;
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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Usuario
 */
public class TablaPoblacionEdadPanelTemplate extends JPanel {

    private TablaPoblacionEdadPanelController tablaPoblacionEdadPanelController;
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
    private ModelPoblacionEdad modelo;
    private String[] cabecera = {"Id Entidad", "Id Municipio", "Id Localidad",
        "tP0A2F", "tP0A2M", "tP3YMasF", "tP3YMasM", "tP5YMasF", "tP5YMasM", "tP12YMasF", "tP12YMasM", "tP15YMasF", "tP15YMasM",
        "tP18YMasF", "tP18YMasM", " tP3A5F", "tP3A5M", "tP6A11F", "tP6A11M", "tP8A14F", "tP8A14M", "tP12A14F", "tP12A14M",
        "tP15A17F", "tP15A17M", "tP18A24F", "tP18A24M", "tP15A49F", "tP60YMasF", "tP60YMasM"};

    public TablaPoblacionEdadPanelTemplate(TablaPoblacionEdadPanelController tablaPoblacionEdadPanelController) {
        this.tablaPoblacionEdadPanelController = tablaPoblacionEdadPanelController;

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

        modelo = new ModelPoblacionEdad();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        modelo.setTabla(tabla);
        tabla.addMouseListener(tablaPoblacionEdadPanelController);

        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(580, 30));

        pTabla = sObjGraficos.construirPanelBarra(
                tabla,
                10, 220, 580, 370,
                Color.WHITE,
                null
        );
        
        pTabla.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

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

        pTabla.getHorizontalScrollBar().setUI(
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
        btnAnterior.addMouseListener(tablaPoblacionEdadPanelController);
        btnAnterior.addActionListener(tablaPoblacionEdadPanelController);
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
        btnSiguiente.addMouseListener(tablaPoblacionEdadPanelController);
        btnSiguiente.addActionListener(tablaPoblacionEdadPanelController);
        gbc = sObjGraficos.getGridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 10);
        this.add(btnSiguiente, gbc);

        for (int i = 0; i < cabecera.length; i++) {
            setMinColumnWidth(i, 100, tabla); // Establece un ancho fijo de 100 para todas las columnas
        }

    }

    // Método para establecer el ancho predeterminado para todas las columnas
    public void setDefaultColumnWidth(int width, JTable miTabla) {
        if (width < 0) {
            // Evitar tamaños de columna negativos
            return;
        }

        // Obtener el TableColumnModel asociado al JTable
        TableColumnModel columnModel = miTabla.getColumnModel();

        // Iterar a través de cada columna y establecer el ancho mínimo
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setMinWidth(width);
        }
    }

    // Método para establecer el ancho mínimo de una columna específica
    public void setMinColumnWidth(int columnIndex, int minWidth, JTable miTabla) {
        if (minWidth < 0) {
            // Evitar tamaños de columna negativos
            return;
        }

        // Obtener el TableColumnModel asociado al JTable
        TableColumnModel columnModel = miTabla.getColumnModel();

        if (columnIndex >= 0 && columnIndex < columnModel.getColumnCount()) {
            TableColumn column = columnModel.getColumn(columnIndex);
            column.setMinWidth(minWidth);
        }
    }

    public TablaPoblacionEdadPanelController getTablaPoblacionEdadPanelController() {
        return tablaPoblacionEdadPanelController;
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

    public ModelPoblacionEdad getModelo() {
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
