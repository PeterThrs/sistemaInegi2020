/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.localidades;

import com.thrs.controllers.formularios.*;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Localidad;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.validation.Validar;
import com.thrs.vistas.panel.formularios.FormularioLocalidadesPanelTemplate;
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
public class FormularioLocalidadesPanelControllerTransaccional implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioLocalidadesPanelTemplateTransaccional formularioLocalidadesPanelTemplateTransaccional;
    private Localidad localidad;

    public FormularioLocalidadesPanelControllerTransaccional(PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.formularioLocalidadesPanelTemplateTransaccional = new FormularioLocalidadesPanelTemplateTransaccional(this);

    }
    
    public Localidad recuperarIdEntidad()throws Exception{
        
        String idEntidad = formularioLocalidadesPanelTemplateTransaccional.gettIdEntidad().getText();
        if(!Validar.contieneInformacion(idEntidad)){
            throw new Exception("Los campos estan vacios");
        }
        if(!Validar.esNumero(idEntidad)){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        
        localidad = new Localidad();
        localidad.setIdEntidad(Integer.parseInt(idEntidad));
        return localidad; 
    }
    
    public Localidad recuperarDatos()throws Exception{
        localidad = new Localidad();
        String idEntidad = formularioLocalidadesPanelTemplateTransaccional.gettIdEntidad().getText();
        String idMunicipio = formularioLocalidadesPanelTemplateTransaccional.gettIdMunicipio().getText();
        String idLocalidad = formularioLocalidadesPanelTemplateTransaccional.gettIdLocalidad().getText();
        String nomLocalidad = formularioLocalidadesPanelTemplateTransaccional.gettNomLocalidad().getText();
        
        if(!Validar.contieneInformacion(idEntidad) || !Validar.contieneInformacion(idMunicipio) ||
                !Validar.contieneInformacion(idLocalidad) || !Validar.contieneInformacion(nomLocalidad)){
            throw new Exception("Los campos estan vacios");
        }
        
        if(!Validar.esNumero(idEntidad) || !Validar.esNumero(idMunicipio) ||
               !Validar.esNumero(idLocalidad) ){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        localidad.setIdEntidad(Integer.parseInt(idEntidad));
        localidad.setIdMunicipio(Integer.parseInt(idMunicipio));
        localidad.setIdLocalidad(Integer.parseInt(idLocalidad));
        localidad.setNomLocalidad(nomLocalidad);
        
        return localidad;
    }
    
    public void cargarDatos(Localidad localidad ){
        formularioLocalidadesPanelTemplateTransaccional.gettIdEntidad().setText(String.valueOf(localidad.getIdEntidad()));
        formularioLocalidadesPanelTemplateTransaccional.gettIdMunicipio().setText(String.valueOf(localidad.getIdMunicipio()));
        formularioLocalidadesPanelTemplateTransaccional.gettIdLocalidad().setText(String.valueOf(localidad.getIdLocalidad()));
        formularioLocalidadesPanelTemplateTransaccional.gettNomLocalidad().setText(localidad.getNomLocalidad());
    }
    
    public void restaurarValores(){
        formularioLocalidadesPanelTemplateTransaccional.gettIdEntidad().setText("Id");
        formularioLocalidadesPanelTemplateTransaccional.gettIdMunicipio().setText("Id");
        formularioLocalidadesPanelTemplateTransaccional.gettIdLocalidad().setText("Id");
        formularioLocalidadesPanelTemplateTransaccional.gettNomLocalidad().setText("Nombre");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioLocalidadesPanelTemplateTransaccional getFormularioLocalidadesPanelTemplateTransaccional() {
        return formularioLocalidadesPanelTemplateTransaccional;
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
