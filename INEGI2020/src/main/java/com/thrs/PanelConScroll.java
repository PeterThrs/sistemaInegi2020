/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Usuario
 */
public class PanelConScroll extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de panel con scroll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Creamos un panel con un layout (en este caso, GridLayout)
        JPanel panel = new JPanel(new GridLayout(0, 1)); // Se puede usar cualquier layout

        // Simulación de un contenido largo dentro del panel
        for (int i = 0; i < 20; i++) {
            panel.add(new JLabel("Contenido " + i));
        }

        // Creamos un JScrollPane y le asignamos el panel
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Desactivamos las barras de desplazamiento
        scrollPane.getVerticalScrollBar().setEnabled(false);
        scrollPane.getVerticalScrollBar().setVisible(false);
        scrollPane.getHorizontalScrollBar().setEnabled(false);

        // Agregamos el JScrollPane al marco (frame)
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}