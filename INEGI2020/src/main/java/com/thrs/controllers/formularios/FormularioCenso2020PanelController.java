/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.formularios;

import com.thrs.controllers.PrincipalController;
import com.thrs.models.Censo2020;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.validation.Validar;
import com.thrs.vistas.panel.formularios.FormularioCenso2020PanelTemplate;
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
public class FormularioCenso2020PanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioCenso2020PanelTemplate formularioCenso2020PanelTemplate;
    private Censo2020 censo2020;

    public FormularioCenso2020PanelController(PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.formularioCenso2020PanelTemplate = new FormularioCenso2020PanelTemplate(this);

    }
    
    public Censo2020 recuperarIdEntidad()throws Exception{
        
        String idEntidad = formularioCenso2020PanelTemplate.gettIdEntidad().getText();
        if(!Validar.contieneInformacion(idEntidad)){
            throw new Exception("Los campos estan vacios");
        }
        if(!Validar.esNumero(idEntidad)){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        
        censo2020 = new Censo2020();
        censo2020.setIdEntidad(Integer.parseInt(idEntidad));
        return censo2020; 
    }
    
    public Censo2020 recuperarDatos()throws Exception{
        censo2020 = new Censo2020();
        String idEntidad = formularioCenso2020PanelTemplate.gettIdEntidad().getText();
        String idMunicipio = formularioCenso2020PanelTemplate.gettIdMunicipio().getText();
        String idLocalidad = formularioCenso2020PanelTemplate.gettIdLocalidad().getText();
        
        String pobTotal = formularioCenso2020PanelTemplate.gettPobTotal().getText();
        String pobFem = formularioCenso2020PanelTemplate.gettPobFem().getText();
        String pobMas = formularioCenso2020PanelTemplate.gettPobMas().getText();
        
        if(!Validar.contieneInformacion(idEntidad) || !Validar.contieneInformacion(idMunicipio) ||
                !Validar.contieneInformacion(idLocalidad) || !Validar.contieneInformacion(pobTotal) ||
                !Validar.contieneInformacion(pobFem) || !Validar.contieneInformacion(pobMas)){
            throw new Exception("Los campos estan vacios");
        }
        
        if(!Validar.esNumero(idEntidad) || !Validar.esNumero(idMunicipio) ||
               !Validar.esNumero(idLocalidad) || !Validar.esNumero(pobTotal)||
               !Validar.esNumero(pobFem) || !Validar.esNumero(pobMas) ){
            throw new Exception("El campo IdEntidad debe ser numero");
        }
        censo2020.setIdEntidad(Integer.parseInt(idEntidad));
        censo2020.setIdMunicipio(Integer.parseInt(idMunicipio));
        censo2020.setIdLocalidad(Integer.parseInt(idLocalidad));
        
        censo2020.setPobTotal(Integer.parseInt(pobTotal));
        censo2020.setPobFemenina(Integer.parseInt(pobFem));
        censo2020.setPobMasculina(Integer.parseInt(pobMas));
        
        return censo2020;
    }
    
    public void cargarDatos(Censo2020 censo2020 ){
        formularioCenso2020PanelTemplate.gettIdEntidad().setText(String.valueOf(censo2020.getIdEntidad()));
        formularioCenso2020PanelTemplate.gettIdMunicipio().setText(String.valueOf(censo2020.getIdMunicipio()));
        formularioCenso2020PanelTemplate.gettIdLocalidad().setText(String.valueOf(censo2020.getIdLocalidad()));
        
        formularioCenso2020PanelTemplate.gettPobTotal().setText(String.valueOf(censo2020.getPobTotal()));
        formularioCenso2020PanelTemplate.gettPobFem().setText(String.valueOf(censo2020.getPobFemenina()));
        formularioCenso2020PanelTemplate.gettPobMas().setText(String.valueOf(censo2020.getPobMasculina()));
        
    }
    
    public void restaurarValores(){
        formularioCenso2020PanelTemplate.gettIdEntidad().setText("Id");
        formularioCenso2020PanelTemplate.gettIdMunicipio().setText("Id");
        formularioCenso2020PanelTemplate.gettIdLocalidad().setText("Id");
        
        formularioCenso2020PanelTemplate.gettPobTotal().setText("Cantidad");
        formularioCenso2020PanelTemplate.gettPobFem().setText("Cantidad");
        formularioCenso2020PanelTemplate.gettPobMas().setText("Cantidad");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioCenso2020PanelTemplate getFormularioCenso2020PanelTemplate() {
        return formularioCenso2020PanelTemplate;
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
        if (textField.getText().equals("Id") || textField.getText().equals("Nombre") || 
                textField.getText().equals("Cantidad")) {
            textField.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField textField = ((JTextField) e.getSource());
        textField.setBorder(null);
    }

}
