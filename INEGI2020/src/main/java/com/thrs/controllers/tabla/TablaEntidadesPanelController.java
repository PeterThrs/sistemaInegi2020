/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;

import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.services.EntidadService;
import com.thrs.vistas.panel.tabla.TablaEntidadesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TablaEntidadesPanelController implements ActionListener, MouseListener, FocusListener{

    private PrincipalController principalController;
    private TablaEntidadesPanelTemplate tablaEntidadesPanelTemplate;
    private EntidadService sEntidad;
    private List<Entidad> entidades;
    private Entidad entidad;

    public TablaEntidadesPanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaEntidadesPanelTemplate = new TablaEntidadesPanelTemplate(this);
        this.sEntidad = sEntidad.getService();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaEntidadesPanelTemplate.getModelo().setRowCount(0);
        entidades = sEntidad.getEntidades();
        entidades.forEach(ent -> {
            this.agregarRegistro(ent);
        });
        //this.tablaEntidadesPanelTemplate.getTabla().setRowHeight(25);
//        principalController.getFormularioEntidadesPanelController()
//                .getFormularioEntidadesPanelTemplate().getlIdEntidad()
//                .setText(sEntidad.devolverCantidadEntidad() + "");
        

    }

    public void agregarRegistro(Entidad entidad) {
        this.tablaEntidadesPanelTemplate.getModelo().addRow(
                new Object[]{entidad.getIdEntidad(), entidad.getNomEntidad()}
        );
    }
    
    public int filaSeleccionada(){
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
            int filaSeleccionada = principalController.getTablaEntidadesPanelController().filaSeleccionada();
            
            entidad = new Entidad();
            DefaultTableModel modelo = principalController.getTablaEntidadesPanelController()
                    .getTablaEntidadesPanelTemplate().getModelo();
            
            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            System.out.println("idEntidad = " + idEntidad);
            String nomEntidad = (String) modelo.getValueAt(filaSeleccionada, 1);
            System.out.println("nomEntidad = " + nomEntidad);
            
            entidad.setIdEntidad(idEntidad);
            entidad.setNomEntidad(nomEntidad);
            
            principalController.getFormularioEntidadesPanelController().cargarDatos(entidad);
            
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
