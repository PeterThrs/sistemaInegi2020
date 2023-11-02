/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;

import com.thrs.TableModels.ModelCenso2020;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Censo2020;
import com.thrs.services.Censo2020Service;
import com.thrs.vistas.panel.tabla.TablaCenso2020PanelTemplate;
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
public class TablaCenso2020PanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaCenso2020PanelTemplate tablaCenso2020PanelTemplate;
    private Censo2020Service sCenso2020;
    private List<Censo2020> listaCenso;
    private Censo2020 censo2020;
    private ModelCenso2020 modelo;

    public TablaCenso2020PanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaCenso2020PanelTemplate = new TablaCenso2020PanelTemplate(this);
        this.sCenso2020 = sCenso2020.getService();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaCenso2020PanelTemplate.getModelo().limpiarDatos();
        listaCenso = sCenso2020.getListaCenso();
        
        this.tablaCenso2020PanelTemplate.getModelo().agregarData(listaCenso);
//        entidades.forEach(ent -> {
//            this.agregarRegistro(ent);
//        });

    }

    public int filaSeleccionada() {
        return tablaCenso2020PanelTemplate.getTabla().getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaCenso2020PanelTemplate getTablaCenso2020PanelTemplate() {
        return tablaCenso2020PanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            censo2020 = new Censo2020();
            modelo = tablaCenso2020PanelTemplate.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            int idMunicipio = (Integer) modelo.getValueAt(filaSeleccionada, 1);
            int idLocalidad = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            
            int pobTotal = (Integer) modelo.getValueAt(filaSeleccionada, 3);
            int pobFem = (Integer) modelo.getValueAt(filaSeleccionada, 4);
            int pobMas = (Integer) modelo.getValueAt(filaSeleccionada, 5);
            

            censo2020.setIdEntidad(idEntidad);
            censo2020.setIdMunicipio(idMunicipio);
            censo2020.setIdLocalidad(idLocalidad);
            censo2020.setPobTotal(pobTotal);
            censo2020.setPobFemenina(pobFem);
            censo2020.setPobMasculina(pobMas);

            principalController.getFormularioCenso2020PanelController().cargarDatos(censo2020);

        }
        
        //retroceder
        if (e.getSource() == tablaCenso2020PanelTemplate.getBtnAnterior()) {
            tablaCenso2020PanelTemplate.getModelo().previousPage();
            tablaCenso2020PanelTemplate.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaCenso2020PanelTemplate.getBtnSiguiente()) {
            modelo = this.tablaCenso2020PanelTemplate.getModelo();
            modelo.nextPage();
            if ((modelo.getCurrentPage() + 1) * modelo.getPAGE_SIZE() >= listaCenso.size()) {
                tablaCenso2020PanelTemplate.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
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

    public List<Censo2020> getListaCenso() {
        return listaCenso;
    }

    public Censo2020 getCenso2020() {
        return censo2020;
    }

}
