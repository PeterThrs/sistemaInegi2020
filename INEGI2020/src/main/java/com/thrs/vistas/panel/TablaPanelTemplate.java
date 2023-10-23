/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel;

import com.thrs.TablaPanelController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TablaPanelTemplate extends JPanel {

    private TablaPanelController tablaPanelController;

    private JPanel pCentral;
    private GridBagConstraints c;
    private JTable tabla;
    private ImageIcon imagen;
    private JButton btnEntidad, btnMunicipio, btnLocalidad, btnCenso, btnPoblacion;
    private Color colorPrincipal, colorSecundario;
    private JLabel tCatalogo;

    private String indieFlower = "Indie Flower", jet = "JetBrains Mono";
    private JScrollPane scrollPane; 
    
    
    public TablaPanelTemplate(TablaPanelController tablaPanelController) {
        this.tablaPanelController = tablaPanelController;

        this.colorPrincipal = new Color(39, 54, 77);
        this.colorSecundario = new Color(240, 235, 216);
        this.tabla = new JTable();
        c = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        componentes();
        
    }

    private void componentes() {
        paneles();
        //crearTabla();
    }

    private void paneles() {
        //Creamos el panel del izuierdo
        pCentral = new JPanel();
        pCentral.setBackground(Color.RED);
        pCentral.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        //c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH;
        pCentral.setLayout(new GridBagLayout());
        pCentral.setFocusable(true);
        this.add(pCentral, c);
    }

    private void crearTabla() {
        // Agregar la tabla a un JScrollPane para poder desplazarse por ella
        JScrollPane scrollPane = new JScrollPane(tabla);
        //cargarModeloTabla();
        //lo agregamos al panel con las ubicaciones
        DefaultTableModel dtm = new DefaultTableModel();
        String[] titulos = {"Codigo", "Descripción del Producto", "Precio Venta", "Cantidad", "Importe", "Existencia"};
        dtm.setColumnIdentifiers(titulos);
        tabla.setModel(dtm);
        c = grid(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        agregarAlPanel(this, scrollPane, c);
    }

//    public void cargarModeloTabla() {
//        if (this.tabla != null) {
//            DefaultTableModel dtm = new DefaultTableModel();
//            tabla.setModel(dtm);
////            // Configurar los titulos de las columnas
////            String[] titulos = {"Código", "Descripción del Producto", "Precio Venta", "Cantidad", "Importe", "Existencia"};
////            dtm.setColumnIdentifiers(titulos);
////            // Configurar los tamaños de las columnas
////            int[] tam = {50, 200, 50, 30, 70, 50};
////            for (int i = 0; i < titulos.length; i++) {
////                tabla.getColumnModel().getColumn(i).setPreferredWidth(tam[i]);
////            }
//
//            // Configurar algunos detalles estéticos
//            tabla.setRowHeight(30);
//            tabla.setIntercellSpacing(new Dimension(0, 0));
//            tabla.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//            tabla.getTableHeader().setForeground(Color.WHITE);
//            tabla.getTableHeader().setBackground(new Color(39, 54, 77));
//            tabla.getTableHeader().setOpaque(false);
//            tabla.setFont(new Font("Arial", Font.PLAIN, 14));
//            tabla.setSelectionBackground(new Color(194, 230, 248));
//            // Para quitar el borde de selección de las celdas de la tabla
//            tabla.setFocusable(false);
//            tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//            // Centrar el texto en las celdas de la tabla
//            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//            tabla.setDefaultRenderer(Object.class, centerRenderer);
//
//        }
//    }
    /**
     *
     * @param <T>
     * @param gridx - La posición del componente en el eje x.
     * @param gridy - La posición del componente en el eje y.
     * @param gridWidth - El número de celdas de la cuadrícula que ocupa el
     * componente en el eje x.
     * @param gridHeight - El número de celdas de la cuadrícula que ocupa el
     * componente el eje y.
     * @param weightx - La cantidad de espacio extra que se asignará a la celda
     * en el eje x si el espacio disponible en la ventana se agranda.
     * @param weighty - La cantidad de espacio extra que se asignará a la celda
     * en el y si el espacio disponible en la ventana se agranda.
     * @param fill - Determinacómo se estirará el componente para llenar la
     * celda: NONE, HORIZONTAL,VERTICAL o BOTH.
     * @param anchor - La posición del componente dentro de la celda si la celda
     * es más grande que el componente.
     * @param insets - El espacio entre el borde del componente y el borde de su
     * celda.
     * @param ipadx - La cantidad de espacio extra en píxeles que se agregará al
     * ancho preferido del componente.
     * @param ipady - La cantidad de espacio extra en píxeles que se agregará al
     * alto preferido del componente.
     */
    private <T extends JComponent> GridBagConstraints grid(int gridx, int gridy, int gridWidth, int gridHeight,
            double weightx, double weighty, int fill, int anchor, Insets insets, int ipadx, int ipady) {
        c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightx;
        c.weighty = weighty;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = insets;
        c.ipadx = ipadx;
        c.ipady = ipady;
        return c;
    }

    private <T extends JComponent> void agregarAlPanel(JPanel panel, T componente, GridBagConstraints c) {
        //Arrays.asList(componentes).forEach(e -> panel.add(e, a.iterator().next()));
        panel.add(componente, c);
    }

    public TablaPanelController getTablaPanelController() {
        return tablaPanelController;
    }

    public JPanel getpCentral() {
        return pCentral;
    }

    public GridBagConstraints getC() {
        return c;
    }

    public JTable getTabla() {
        return tabla;
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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
    
    

}
