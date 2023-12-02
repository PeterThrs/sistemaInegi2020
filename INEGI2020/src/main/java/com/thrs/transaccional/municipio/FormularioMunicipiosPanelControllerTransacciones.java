/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.municipio;

import com.thrs.controllers.formularios.*;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Municipio;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.validation.Validar;
import com.thrs.vistas.panel.formularios.FormularioMunicipiosPanelTemplate;
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
public class FormularioMunicipiosPanelControllerTransacciones implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioMunicipiosPanelTemplateTransacciones formularioMunicipiosPanelTemplateTransacciones;
    private Municipio municipio;

    public FormularioMunicipiosPanelControllerTransacciones(PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.formularioMunicipiosPanelTemplateTransacciones = new FormularioMunicipiosPanelTemplateTransacciones(this);

    }
    
    public Municipio recuperarIdEntidad()throws Exception{
        
        String idEntidad = formularioMunicipiosPanelTemplateTransacciones.gettIdEntidad().getText();
        if(!Validar.contieneInformacion(idEntidad)){
            throw new Exception("Los campos estan vacios");
        }
        if(!Validar.esNumero(idEntidad)){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        
        municipio = new Municipio();
        municipio.setIdEntidad(Integer.parseInt(idEntidad));
        return municipio; 
    }
    
    public Municipio recuperarDatos()throws Exception{
        municipio = new Municipio();
        String idEntidad = formularioMunicipiosPanelTemplateTransacciones.gettIdEntidad().getText();
        String idMunicipio = formularioMunicipiosPanelTemplateTransacciones.gettIdMunicipio().getText();
        String nomEntidad = formularioMunicipiosPanelTemplateTransacciones.gettNomEntidad().getText();
        
        if(!Validar.contieneInformacion(idEntidad) || !Validar.contieneInformacion(idMunicipio) ||
                !Validar.contieneInformacion(nomEntidad)){
            throw new Exception("Los campos estan vacios");
        }
        
        if(!Validar.esNumero(idEntidad) || !Validar.esNumero(idMunicipio)  ){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        municipio.setIdEntidad(Integer.parseInt(idEntidad));
        municipio.setIdMunicipio(Integer.parseInt(idMunicipio));
        municipio.setNomMunicipio(nomEntidad);
        
        return municipio;
    }
    
    public void cargarDatos(Municipio municipio ){
        formularioMunicipiosPanelTemplateTransacciones.gettIdEntidad().setText(String.valueOf(municipio.getIdEntidad()));
        formularioMunicipiosPanelTemplateTransacciones.gettIdMunicipio().setText(String.valueOf(municipio.getIdMunicipio()));
        formularioMunicipiosPanelTemplateTransacciones.gettNomEntidad().setText(municipio.getNomMunicipio());
    }
    
    public void restaurarValores(){
        formularioMunicipiosPanelTemplateTransacciones.gettIdEntidad().setText("Id");
        formularioMunicipiosPanelTemplateTransacciones.gettIdMunicipio().setText("Id");
        formularioMunicipiosPanelTemplateTransacciones.gettNomEntidad().setText("Nombre");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioMunicipiosPanelTemplateTransacciones getFormularioMunicipiosPanelTemplateTransacciones() {
        return formularioMunicipiosPanelTemplateTransacciones;
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
