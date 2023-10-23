/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.formularios;

import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.vistas.panel.formularios.FormularioEntidadesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FormularioEntidadesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioEntidadesPanelTemplate formularioEntidadesPanelTemplate;
    private Entidad entidad;

    public FormularioEntidadesPanelController(PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.formularioEntidadesPanelTemplate = new FormularioEntidadesPanelTemplate(this);

    }
    
    public Entidad recuperarIdEntidad(){
        entidad = new Entidad();
        entidad.setIdEntidad(Integer.parseInt(formularioEntidadesPanelTemplate.gettIdEntidad().getText()));
        return entidad; 
    }
    
    public Entidad recuperarDatos(){
        entidad = new Entidad();
        entidad.setIdEntidad(Integer.parseInt(formularioEntidadesPanelTemplate.gettIdEntidad().getText()));
        entidad.setNomEntidad(formularioEntidadesPanelTemplate.gettNomEntidad().getText());
        
        return entidad;
    }
    
    public void cargarDatos(Entidad entidad ){
        formularioEntidadesPanelTemplate.gettIdEntidad().setText(String.valueOf(entidad.getIdEntidad()));
        formularioEntidadesPanelTemplate.gettNomEntidad().setText(entidad.getNomEntidad());
    }
    
    public void restaurarValores(){
        formularioEntidadesPanelTemplate.gettIdEntidad().setText("Id");
        formularioEntidadesPanelTemplate.gettNomEntidad().setText("Nombre");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioEntidadesPanelTemplate getFormularioEntidadesPanelTemplate() {
        return formularioEntidadesPanelTemplate;
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
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(RecursosService.getService().getBAzul());
        if (textField.getText().equals("Id") || textField.getText().equals("Nombre")) {
            textField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(null);
    }

}
