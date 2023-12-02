/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.entidades;

import com.thrs.transaccional.entidades.TablaEntidadesPanelTemplateTransacciones;
import com.thrs.TableModels.ModelEntidad;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.transaccional.EncargadoTransacciones;
import com.thrs.transaccional.conexion.EntidadDaoTransaccional;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class TablaEntidadesPanelControllerTransacciones implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaEntidadesPanelTemplateTransacciones tablaEntidadesPanelTemplateTransacciones;
    private EntidadDaoTransaccional entidadDao;
    private List<Entidad> entidades;
    private Entidad entidad;
    private EncargadoTransacciones encargado;

    public TablaEntidadesPanelControllerTransacciones(EncargadoTransacciones encargado, Connection conexion, PrincipalController principalController) throws Exception{
        this.principalController = principalController;
        this.encargado = encargado;
        this.tablaEntidadesPanelTemplateTransacciones = new TablaEntidadesPanelTemplateTransacciones(this);
        entidadDao = new EntidadDaoTransaccional(conexion);

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() throws Exception{
        this.tablaEntidadesPanelTemplateTransacciones.getModelo().limpiarDatos();
        entidades = entidadDao.selectAll();
        
        this.tablaEntidadesPanelTemplateTransacciones.getModelo().agregarData(entidades);
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
        int fSeleccionada = tablaEntidadesPanelTemplateTransacciones.getTabla().getSelectedRow();
        if (fSeleccionada != -1) {
            tablaEntidadesPanelTemplateTransacciones.getModelo()
                    .setValueAt(entidad.getIdEntidad(), fSeleccionada, 0);
            tablaEntidadesPanelTemplateTransacciones.getModelo()
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

    public void eliminarRegistroTabla() {
//        int fSeleccionada = tablaEntidadesPanelTemplate.getTabla().getSelectedRow();
//        if (fSeleccionada != -1) {
//            tablaEntidadesPanelTemplate.getModelo().removeRow(fSeleccionada);
//        } else {
//            JOptionPane.showMessageDialog(
//                    null,
//                    "seleccione una fila",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE
//            );
//        }
    }
    
    public void deseleccionarElemento(){
    }

    public int filaSeleccionada() {
        return tablaEntidadesPanelTemplateTransacciones.getTabla().getSelectedRow();
    }

    public void componentes() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaEntidadesPanelTemplateTransacciones getTablaEntidadesPanelTemplateTransacciones() {
        return tablaEntidadesPanelTemplateTransacciones;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            entidad = new Entidad();
            ModelEntidad modelo = tablaEntidadesPanelTemplateTransacciones.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            String nomEntidad = (String) modelo.getValueAt(filaSeleccionada, 1);

            entidad.setIdEntidad(idEntidad);
            entidad.setNomEntidad(nomEntidad);

            encargado.getFormularioEntidadesPanelControllerTransaccional().cargarDatos(entidad);

        }
        
        //retroceder
        if (e.getSource() == tablaEntidadesPanelTemplateTransacciones.getBtnAnterior()) {
            tablaEntidadesPanelTemplateTransacciones.getModelo().previousPage();
            tablaEntidadesPanelTemplateTransacciones.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaEntidadesPanelTemplateTransacciones.getBtnSiguiente()) {
            ModelEntidad model = tablaEntidadesPanelTemplateTransacciones.getModelo();
            model.nextPage();
            if ((model.getCurrentPage() + 1) * model.getPAGE_SIZE() >= entidades.size()) {
                tablaEntidadesPanelTemplateTransacciones.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
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
