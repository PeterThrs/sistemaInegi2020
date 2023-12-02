/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.entidades;

import com.thrs.transaccional.entidades.FormularioEntidadesPanelTemplateTransaccional;
import com.thrs.controllers.formularios.*;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.transaccional.EncargadoTransacciones;
import com.thrs.validation.Validar;
import com.thrs.vistas.panel.formularios.FormularioEntidadesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FormularioEntidadesPanelControllerTransaccional implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioEntidadesPanelTemplateTransaccional formularioEntidadesPanelTemplateTransaccional;
    private Entidad entidad;
    private EncargadoTransacciones encargado;

    public FormularioEntidadesPanelControllerTransaccional(EncargadoTransacciones encargado, Connection conexion, PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.encargado = encargado;
        this.formularioEntidadesPanelTemplateTransaccional = new FormularioEntidadesPanelTemplateTransaccional(this);

    }
    
    public Entidad recuperarIdEntidad()throws Exception{
        
        String idEntidad = formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().getText();
        if(!Validar.contieneInformacion(idEntidad)){
            throw new Exception("Los campos estan vacios");
        }
        if(!Validar.esNumero(idEntidad)){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        
        entidad = new Entidad();
        entidad.setIdEntidad(Integer.parseInt(formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().getText()));
        return entidad; 
    }
    
    public Entidad recuperarDatos()throws Exception{
        entidad = new Entidad();
        String idEntidad = formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().getText();
        String nomEntidad = formularioEntidadesPanelTemplateTransaccional.gettNomEntidad().getText();
        if(!Validar.contieneInformacion(idEntidad) || !Validar.contieneInformacion(nomEntidad) ){
            throw new Exception("Los campos estan vacios");
        }
        if(!Validar.esNumero(idEntidad)){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        entidad.setIdEntidad(Integer.parseInt(formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().getText()));
        entidad.setNomEntidad(formularioEntidadesPanelTemplateTransaccional.gettNomEntidad().getText());
        
        return entidad;
    }
    
    public void cargarDatos(Entidad entidad ){
        formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().setText(String.valueOf(entidad.getIdEntidad()));
        formularioEntidadesPanelTemplateTransaccional.gettNomEntidad().setText(entidad.getNomEntidad());
    }
    
    public void restaurarValores(){
        formularioEntidadesPanelTemplateTransaccional.gettIdEntidad().setText("Id");
        formularioEntidadesPanelTemplateTransaccional.gettNomEntidad().setText("Nombre");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioEntidadesPanelTemplateTransaccional getFormularioEntidadesPanelTemplateTransaccional() {
        return formularioEntidadesPanelTemplateTransaccional;
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
