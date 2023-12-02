/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;

import com.thrs.TableModels.ModelEntidad;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.repository.EntidadDao;
import com.thrs.services.EntidadService;
import com.thrs.vistas.panel.tabla.TablaEntidadesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class TablaEntidadesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaEntidadesPanelTemplate tablaEntidadesPanelTemplate;
    private EntidadDao entidadDao;
    private List<Entidad> entidades;
    private Entidad entidad;

    public TablaEntidadesPanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaEntidadesPanelTemplate = new TablaEntidadesPanelTemplate(this);
        this.entidadDao = new EntidadDao();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaEntidadesPanelTemplate.getModelo().limpiarDatos();
        entidades = entidadDao.selectAll();
        
        this.tablaEntidadesPanelTemplate.getModelo().agregarData(entidades);
//        entidades.forEach(ent -> {
//            this.agregarRegistro(ent);
//        });

    }

    public void agregarRegistro(Entidad entidad) {
//        this.tablaEntidadesPanelTemplate.getModelo().addRow(
//                new Object[]{entidad.getIdEntidad(), entidad.getNomEntidad()}
//        );
    }

    public void modificarRegistroTabla(Entidad entidad) {
        int fSeleccionada = tablaEntidadesPanelTemplate.getTabla().getSelectedRow();
        if (fSeleccionada != -1) {
            tablaEntidadesPanelTemplate.getModelo()
                    .setValueAt(entidad.getIdEntidad(), fSeleccionada, 0);
            tablaEntidadesPanelTemplate.getModelo()
                    .setValueAt(entidad.getNomEntidad(), fSeleccionada, 1);
            
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "seleccione una fila",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void deseleccionarElemento(){
    }

    public int filaSeleccionada() {
        return tablaEntidadesPanelTemplate.getTabla().getSelectedRow();
    }

    public void componentes() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaEntidadesPanelTemplate getTablaEntidadesPanelTemplate() {
        return tablaEntidadesPanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            entidad = new Entidad();
            ModelEntidad modelo = tablaEntidadesPanelTemplate.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String nomEntidad = (String) modelo.getValueAt(filaSeleccionada, 1);

            entidad.setIdEntidad(idEntidad);
            entidad.setNomEntidad(nomEntidad);

            principalController.getFormularioEntidadesPanelController().cargarDatos(entidad);

        }
        
        //retroceder
        if (e.getSource() == tablaEntidadesPanelTemplate.getBtnAnterior()) {
            tablaEntidadesPanelTemplate.getModelo().previousPage();
            tablaEntidadesPanelTemplate.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaEntidadesPanelTemplate.getBtnSiguiente()) {
            ModelEntidad model = tablaEntidadesPanelTemplate.getModelo();
            model.nextPage();
            if ((model.getCurrentPage() + 1) * model.getPAGE_SIZE() >= entidades.size()) {
                tablaEntidadesPanelTemplate.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
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

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public Entidad getEntidad() {
        return entidad;
    }

}
