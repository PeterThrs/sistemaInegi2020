/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import com.thrs.models.Entidad;
import com.thrs.services.EntidadService;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.vistas.panel.BotonesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BotonesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private BotonesPanelTemplate botonesPanelTemplate;
    private Entidad entidad;
    private EntidadService sEntidad;
    private String comando;

    public BotonesPanelController(PrincipalController principalController, String comando) {
        this.principalController = principalController;
        this.comando = comando;
        this.botonesPanelTemplate = new BotonesPanelTemplate(this, this.comando);
        this.sEntidad = sEntidad.getService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (comando) {
            case "Entidades":
                if (e.getSource() == botonesPanelTemplate.getBtnCreate()) {
                    entidad = this.principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    System.out.println("entidad = " + entidad);
                    sEntidad.agregarEntidad(entidad);
                    //this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getTablaEntidadesPanelController().agregarRegistro(entidad);
                    
                }
                if (e.getSource() == botonesPanelTemplate.getBtnUpdate()) {
                    int filaSeleccionada = principalController.getTablaEntidadesPanelController().filaSeleccionada();
                    if (filaSeleccionada != -1) {
                        Entidad entidadNueva = principalController.getFormularioEntidadesPanelController().recuperarDatos();
                        Entidad entidadAnterior = principalController.getTablaEntidadesPanelController().getEntidad();

                        sEntidad.actualizarEntidad(entidadNueva, entidadAnterior);
                        //this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                        this.principalController.getTablaEntidadesPanelController().modificarRegistroTabla(entidadNueva);
                        this.principalController.getFormularioEntidadesPanelController().restaurarValores();

                    } else {
                        JOptionPane.showMessageDialog(null, "Debes selecionar una fila");
                    }

                }
                if (e.getSource() == botonesPanelTemplate.getBtnDelete()) {
                    Entidad entidadNueva = principalController.getFormularioEntidadesPanelController().recuperarIdEntidad();

                    sEntidad.eliminarEntidad(entidadNueva);
                    //this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getTablaEntidadesPanelController().eliminarRegistroTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();

                }

                break;

        }

        if (e.getSource() == botonesPanelTemplate.getBtnClean()) {
            this.principalController.getFormularioEntidadesPanelController().restaurarValores();
        }
        if (e.getSource() == botonesPanelTemplate.getBtnRegresar()) {
            this.principalController.cerrarSesion();
            return;
        }

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public BotonesPanelTemplate getBotonesPanelTemplate() {
        return botonesPanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipal());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
