/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Entidad;
import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class ModeloTablaPrueba extends JFrame {
//    public static void main(String[] args) {
//        List<Entidad> listaUsuarios = new ArrayList<>();
//        for (int i = 1; i <= 1000; i++) {
//            listaUsuarios.add(new Entidad(i, "Usuario " + i));
//        }
//        List<String> titulos = new ArrayList<>();
//        titulos.add("id");
//        titulos.add("entidad");
//        ModeloTablaEntidades modelo = new ModeloTablaEntidades(listaUsuarios,titulos, 20); // Vista para 20 filas
//
//        JTable tabla = new JTable(modelo);
//        JScrollPane scrollPane = new JScrollPane(tabla);
//
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new BorderLayout());
//        frame.add(scrollPane, BorderLayout.CENTER);
//        frame.setSize(400, 300);
//        frame.setVisible(true);
//        
//        // Agregar AdjustmentListener al JScrollPane
//        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                int scrollValue = e.getValue();
//                int visibleAmount = e.getAdjustable().getVisibleAmount();
//                int maximum = e.getAdjustable().getMaximum();
//                int extent = e.getAdjustable().getMaximum() - e.getAdjustable().getVisibleAmount();
//                if (scrollValue + visibleAmount >= maximum - extent) { // Si el scroll está cerca del final
//                    modelo.loadMoreData(0, modelo.getRowCount() - 1);
//                }
//            }
//        });
//        
//    }

    public static void main(String[] args) {
        List<Entidad> entidades = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            entidades.add(new Entidad(i, "Entidad: " + i));
        }

        String[] columnNames = {"Id", "Valor"};

        ModelEntidad model = new ModelEntidad(entidades, columnNames);
        JTable table = new JTable(model);

        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Siguiente");

//        prevButton.addActionListener(e -> model.previousPage());
//        nextButton.addActionListener(e -> model.nextPage());
        prevButton.addActionListener(e -> {
            model.previousPage();
            nextButton.setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        });

        nextButton.addActionListener(e -> {
            model.nextPage();
            if ((model.getCurrentPage() + 1) * model.getPAGE_SIZE() >= entidades.size()) {
                nextButton.setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}
