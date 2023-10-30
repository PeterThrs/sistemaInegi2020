/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import static com.thrs.Mensaje.*;
import com.thrs.models.CatalogoEnum;
import static com.thrs.models.CatalogoEnum.*;
import com.thrs.models.Entidad;
import com.thrs.services.EntidadService;
import com.thrs.services.graphicServices.RecursosService;
import static com.thrs.validation.Validar.*;
import com.thrs.vistas.panel.BotonesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class BotonesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private BotonesPanelTemplate botonesPanelTemplate;
    private Entidad entidadRecuperada;
    private Entidad entidadAnterior;
    private EntidadService sEntidad;
    private CatalogoEnum comando;
    private List<Entidad> entidades;

    public BotonesPanelController(PrincipalController principalController, CatalogoEnum comando) {
        this.principalController = principalController;
        this.comando = comando;
        this.botonesPanelTemplate = new BotonesPanelTemplate(this, this.comando.getValor());
        this.sEntidad = sEntidad.getService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int filaSeleccionada = principalController.getTablaEntidadesPanelController().filaSeleccionada();
        entidades = sEntidad.getEntidades();

        //insertar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnCreate()) {
            insert();
        }

        //actualizar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnUpdate()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            update();

        }

        //eliminar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnDelete()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            delete();
        }

        //limpiar el formulario 
        if (e.getSource() == botonesPanelTemplate.getBtnClean()) {
            this.principalController.getFormularioEntidadesPanelController().restaurarValores();
        }

        //regresar a la ventana anterior
        if (e.getSource() == botonesPanelTemplate.getBtnRegresar()) {
            this.principalController.cerrarSesion();
        }

    }

    private void insert() {
        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadRecuperada = this.principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    if (compararIdEntidad(this.entidades, entidadRecuperada) || existeElemento(entidades, entidadRecuperada)) {
                        mensajeError("Ya existe el ID de entidad");
                        return;
                    }
                    this.sEntidad.agregarEntidad(entidadRecuperada);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad Insertada correctamente");

                    break;
                case MUNICIPIO:
                    break;
                case LOCALIDAD:
                    break;
                case CENSO_2020:
                    break;
                case POBLACION_EDAD:
                    break;
            }

        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    private void update() {

        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadRecuperada = principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    this.entidadAnterior = principalController.getTablaEntidadesPanelController().getEntidad();
                    if (existeElemento(entidades, entidadRecuperada)) {
                        mensajeError("Ya existe el ID de entidad");
                        return;
                    }
                    if (compararIdEntidad(this.entidades, entidadRecuperada) || existeElemento(entidades, entidadRecuperada)) {
                        mensajeError("Ya existe el ID de entidad al que quiere actualizar");
                        return;
                    }
                    sEntidad.actualizarEntidad(entidadRecuperada, entidadAnterior);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad modificada correctamente");

                    break;
                case MUNICIPIO:
                    break;
                case LOCALIDAD:
                    break;
                case CENSO_2020:
                    break;
                case POBLACION_EDAD:
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    private void delete() {

        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadAnterior = principalController.getTablaEntidadesPanelController().getEntidad();
                    this.entidadRecuperada = this.principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    if (!objectosIguales(entidadAnterior, entidadRecuperada)) {
                        mensajeError("No debe modificar el campo");
                        return;
                    }
                    sEntidad.eliminarEntidad(entidadRecuperada);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad Elimina correctamente");

                    break;
                case MUNICIPIO:
                    break;
                case LOCALIDAD:
                    break;
                case CENSO_2020:
                    break;
                case POBLACION_EDAD:
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

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
