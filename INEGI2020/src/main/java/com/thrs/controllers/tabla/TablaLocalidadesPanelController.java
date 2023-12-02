/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;


import com.thrs.TableModels.ModelLocalidad;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Localidad;
import com.thrs.repository.LocalidadDao;
import com.thrs.services.LocalidadService;
import com.thrs.vistas.panel.tabla.TablaLocalidadesPanelTemplate;
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
public class TablaLocalidadesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaLocalidadesPanelTemplate tablaLocalidadesPanelTemplate;
    private LocalidadDao localidadDao;
    private List<Localidad> localidades;
    private Localidad localidad;
    private ModelLocalidad modelo;

    public TablaLocalidadesPanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaLocalidadesPanelTemplate = new TablaLocalidadesPanelTemplate(this);
        this.localidadDao = new LocalidadDao();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaLocalidadesPanelTemplate.getModelo().limpiarDatos();
        localidades = localidadDao.selectAll();
        
        this.tablaLocalidadesPanelTemplate.getModelo().agregarData(localidades);
//        entidades.forEach(ent -> {
//            this.agregarRegistro(ent);
//        });

    }

    public int filaSeleccionada() {
        return tablaLocalidadesPanelTemplate.getTabla().getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaLocalidadesPanelTemplate getTablaLocalidadesPanelTemplate() {
        return tablaLocalidadesPanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            localidad = new Localidad();
            modelo = tablaLocalidadesPanelTemplate.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            int idMunicipio = (Integer) modelo.getValueAt(filaSeleccionada, 1);
            int idLocalidad = (Integer) modelo.getValueAt(filaSeleccionada, 2);
            String nomLocalidad = (String) modelo.getValueAt(filaSeleccionada, 3);

            localidad.setIdEntidad(idEntidad);
            localidad.setIdMunicipio(idMunicipio);
            localidad.setIdLocalidad(idLocalidad);
            localidad.setNomLocalidad(nomLocalidad);

            principalController.getFormularioLocalidadesPanelController().cargarDatos(localidad);

        }
        
        //retroceder
        if (e.getSource() == tablaLocalidadesPanelTemplate.getBtnAnterior()) {
            tablaLocalidadesPanelTemplate.getModelo().previousPage();
            tablaLocalidadesPanelTemplate.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaLocalidadesPanelTemplate.getBtnSiguiente()) {
            modelo = this.tablaLocalidadesPanelTemplate.getModelo();
            modelo.nextPage();
            if ((modelo.getCurrentPage() + 1) * modelo.getPAGE_SIZE() >= localidades.size()) {
                tablaLocalidadesPanelTemplate.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
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

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

}
