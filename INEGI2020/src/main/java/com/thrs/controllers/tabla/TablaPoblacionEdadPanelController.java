/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;

import com.thrs.TableModels.ModelPoblacionEdad;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.PoblacionEdad;
import com.thrs.services.PoblacionEdadService;
import com.thrs.vistas.panel.tabla.TablaPoblacionEdadPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class TablaPoblacionEdadPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaPoblacionEdadPanelTemplate tablaPoblacionEdadPanelTemplate;
    private PoblacionEdadService sPoblacionEdad;
    private List<PoblacionEdad> localidades;
    private PoblacionEdad poblacionEdad;
    private ModelPoblacionEdad modelo;

    public TablaPoblacionEdadPanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaPoblacionEdadPanelTemplate = new TablaPoblacionEdadPanelTemplate(this);
        this.sPoblacionEdad = sPoblacionEdad.getService();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaPoblacionEdadPanelTemplate.getModelo().limpiarDatos();
        localidades = sPoblacionEdad.getListaPoblacion();

        this.tablaPoblacionEdadPanelTemplate.getModelo().agregarData(localidades);
//        entidades.forEach(ent -> {
//            this.agregarRegistro(ent);
//        });

    }

    public int filaSeleccionada() {
        return tablaPoblacionEdadPanelTemplate.getTabla().getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaPoblacionEdadPanelTemplate getTablaPoblacionEdadPanelTemplate() {
        return tablaPoblacionEdadPanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            poblacionEdad = new PoblacionEdad();
            modelo = tablaPoblacionEdadPanelTemplate.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            int idMunicipio = (Integer) modelo.getValueAt(filaSeleccionada, 1);
            int idLocalidad = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            
            int p0A2F = (Integer) modelo.getValueAt(filaSeleccionada, 3);
            int p0A2M = (Integer) modelo.getValueAt(filaSeleccionada, 4);
            int p3YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 5);
            int p3YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 6);
            int p5YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 7);
            int p5YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 8);
            int p12YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 9);
            int p12YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 10);
            int p15YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 11);
            int p15YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 12);
            int p18YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 13);
            int p18YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 14);

            int p3A5F = (Integer) modelo.getValueAt(filaSeleccionada, 15);
            int p3A5M = (Integer) modelo.getValueAt(filaSeleccionada, 16);
            int p6A11F = (Integer) modelo.getValueAt(filaSeleccionada, 17);
            int p6A11M = (Integer) modelo.getValueAt(filaSeleccionada, 18);
            int p8A14F = (Integer) modelo.getValueAt(filaSeleccionada, 19);
            int p8A14M = (Integer) modelo.getValueAt(filaSeleccionada, 20);
            int p12A14F = (Integer) modelo.getValueAt(filaSeleccionada, 21);
            int p12A14M = (Integer) modelo.getValueAt(filaSeleccionada, 22);
            int p15A17F = (Integer) modelo.getValueAt(filaSeleccionada, 23);
            int p15A17M = (Integer) modelo.getValueAt(filaSeleccionada, 24);
            int p18A24F = (Integer) modelo.getValueAt(filaSeleccionada, 25);
            int p18A24M = (Integer) modelo.getValueAt(filaSeleccionada, 26);
            int p15A49F = (Integer) modelo.getValueAt(filaSeleccionada, 27);
            int p60YMasF = (Integer) modelo.getValueAt(filaSeleccionada, 28);
            int p60YMasM = (Integer) modelo.getValueAt(filaSeleccionada, 29);

            poblacionEdad.setIdEntidad(idEntidad);
            poblacionEdad.setIdMunicipio(idMunicipio);
            poblacionEdad.setIdLocalidad(idLocalidad);
            poblacionEdad.setP0A2F(p0A2F);
            poblacionEdad.setP0A2M(p0A2M);
            poblacionEdad.setP3YMasF(p3YMasF);
            poblacionEdad.setP3YMasM(p3YMasM);
            poblacionEdad.setP5YMasF(p5YMasF);
            poblacionEdad.setP5YMasM(p5YMasM);
            poblacionEdad.setP12YMasF(p12YMasF);
            poblacionEdad.setP12YMasM(p12YMasM);
            poblacionEdad.setP15YMasF(p15YMasF);
            poblacionEdad.setP15YMasM(p15YMasM);
            poblacionEdad.setP18YMasF(p18YMasF);
            poblacionEdad.setP18YMasM(p18YMasM);
            poblacionEdad.setP3A5F(p3A5F);
            poblacionEdad.setP3A5M(p3A5M);
            poblacionEdad.setP6A11F(p6A11F);
            poblacionEdad.setP6A11M(p6A11M);
            poblacionEdad.setP8A14F(p8A14F);
            poblacionEdad.setP8A14M(p8A14M);
            poblacionEdad.setP12A14F(p12A14F);
            poblacionEdad.setP12A14M(p12A14M);
            poblacionEdad.setP15A17F(p15A17F);
            poblacionEdad.setP15A17M(p15A17M);
            poblacionEdad.setP18A24F(p18A24F);
            poblacionEdad.setP18A24M(p18A24M);
            poblacionEdad.setP15A49F(p15A49F);
            poblacionEdad.setP60YMasF(p60YMasF);
            poblacionEdad.setP60YMasM(p60YMasM);

            principalController.getFormularioPoblacionEdadPanelController().cargarDatos(poblacionEdad);

        }

        //retroceder
        if (e.getSource() == tablaPoblacionEdadPanelTemplate.getBtnAnterior()) {
            tablaPoblacionEdadPanelTemplate.getModelo().previousPage();
            tablaPoblacionEdadPanelTemplate.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaPoblacionEdadPanelTemplate.getBtnSiguiente()) {
            modelo = this.tablaPoblacionEdadPanelTemplate.getModelo();
            modelo.nextPage();
            if ((modelo.getCurrentPage() + 1) * modelo.getPAGE_SIZE() >= localidades.size()) {
                tablaPoblacionEdadPanelTemplate.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public List<PoblacionEdad> getLocalidades() {
        return localidades;
    }

    public PoblacionEdad getPoblacionEdad() {
        return poblacionEdad;
    }

}
