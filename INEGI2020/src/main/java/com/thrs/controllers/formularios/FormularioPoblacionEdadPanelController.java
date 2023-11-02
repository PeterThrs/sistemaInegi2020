/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.formularios;

import com.thrs.controllers.PrincipalController;
import com.thrs.models.PoblacionEdad;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.validation.Validar;
import com.thrs.vistas.panel.formularios.FormularioPoblacionEdadPanelTemplate;
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
public class FormularioPoblacionEdadPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalcontroller;
    private FormularioPoblacionEdadPanelTemplate formularioPoblacionEdadPanelTemplate;
    private PoblacionEdad poblacionEdad;

    public FormularioPoblacionEdadPanelController(PrincipalController principalController) {
        this.principalcontroller = principalController;
        this.formularioPoblacionEdadPanelTemplate = new FormularioPoblacionEdadPanelTemplate(this);

    }

    public PoblacionEdad recuperarIdEntidad() throws Exception {

        String idEntidad = formularioPoblacionEdadPanelTemplate.gettIdEntidad().getText();
        if (!Validar.contieneInformacion(idEntidad)) {
            throw new Exception("Los campos estan vacios");
        }
        if (!Validar.esNumero(idEntidad)) {
            throw new Exception("El campo IdEntidad debe ser numero");
        }

        poblacionEdad = new PoblacionEdad();
        poblacionEdad.setIdEntidad(Integer.parseInt(idEntidad));
        return poblacionEdad;
    }

    public PoblacionEdad recuperarDatos() throws Exception {
        poblacionEdad = new PoblacionEdad();
        String idEntidad = formularioPoblacionEdadPanelTemplate.gettIdEntidad().getText();
        String idMunicipio = formularioPoblacionEdadPanelTemplate.gettIdMunicipio().getText();
        String idLocalidad = formularioPoblacionEdadPanelTemplate.gettIdLocalidad().getText();

        String p0A2F = formularioPoblacionEdadPanelTemplate.gettP0A2F().getText();
        String p0A2M = formularioPoblacionEdadPanelTemplate.gettP0A2M().getText();
        String p3YMasF = formularioPoblacionEdadPanelTemplate.gettP3YMasF().getText();
        String p3YMasM = formularioPoblacionEdadPanelTemplate.gettP3YMasM().getText();
        String p5YMasF = formularioPoblacionEdadPanelTemplate.gettP5YMasF().getText();
        String p5YMasM = formularioPoblacionEdadPanelTemplate.gettP5YMasM().getText();
        String p12YMasF = formularioPoblacionEdadPanelTemplate.gettP12YMasF().getText();
        String p12YMasM = formularioPoblacionEdadPanelTemplate.gettP12YMasM().getText();
        String p15YMasF = formularioPoblacionEdadPanelTemplate.gettP15YMasF().getText();
        String p15YMasM = formularioPoblacionEdadPanelTemplate.gettP15YMasM().getText();
        String p18YMasF = formularioPoblacionEdadPanelTemplate.gettP18YMasF().getText();
        String p18YMasM = formularioPoblacionEdadPanelTemplate.gettP18YMasM().getText();

        String p3A5F = formularioPoblacionEdadPanelTemplate.gettP3A5F().getText();
        String p3A5M = formularioPoblacionEdadPanelTemplate.gettP3A5M().getText();
        String p6A11F = formularioPoblacionEdadPanelTemplate.gettP6A11F().getText();
        String p6A11M = formularioPoblacionEdadPanelTemplate.gettP6A11M().getText();
        String p8A14F = formularioPoblacionEdadPanelTemplate.gettP8A14F().getText();
        String p8A14M = formularioPoblacionEdadPanelTemplate.gettP8A14M().getText();
        String p12A14F = formularioPoblacionEdadPanelTemplate.gettP12A14F().getText();
        String p12A14M = formularioPoblacionEdadPanelTemplate.gettP12A14M().getText();
        String p15A17F = formularioPoblacionEdadPanelTemplate.gettP15A17F().getText();
        String p15A17M = formularioPoblacionEdadPanelTemplate.gettP15A17M().getText();
        String p18A24F = formularioPoblacionEdadPanelTemplate.gettP18A24F().getText();
        String p18A24M = formularioPoblacionEdadPanelTemplate.gettP18A24M().getText();
        String p15A49F = formularioPoblacionEdadPanelTemplate.gettP15A49F().getText();
        String p60YMasF = formularioPoblacionEdadPanelTemplate.gettP60YMasF().getText();
        String p60YMasM = formularioPoblacionEdadPanelTemplate.gettP60YMasM().getText();

        if (!Validar.contieneInformacion(idEntidad)
                || !Validar.contieneInformacion(idMunicipio)
                || !Validar.contieneInformacion(idLocalidad)
                || !Validar.contieneInformacion(p0A2F)
                || !Validar.contieneInformacion(p0A2M)
                || !Validar.contieneInformacion(p3YMasF)
                || !Validar.contieneInformacion(p3YMasM)
                || !Validar.contieneInformacion(p5YMasF)
                || !Validar.contieneInformacion(p5YMasM)
                || !Validar.contieneInformacion(p12YMasF)
                || !Validar.contieneInformacion(p12YMasM)
                || !Validar.contieneInformacion(p15YMasF)
                || !Validar.contieneInformacion(p15YMasM)
                || !Validar.contieneInformacion(p18YMasF)
                || !Validar.contieneInformacion(p18YMasM)
                || !Validar.contieneInformacion(p3A5F)
                || !Validar.contieneInformacion(p3A5M)
                || !Validar.contieneInformacion(p6A11F)
                || !Validar.contieneInformacion(p6A11M)
                || !Validar.contieneInformacion(p8A14F)
                || !Validar.contieneInformacion(p8A14M)
                || !Validar.contieneInformacion(p12A14F)
                || !Validar.contieneInformacion(p12A14M)
                || !Validar.contieneInformacion(p15A17F)
                || !Validar.contieneInformacion(p15A17M)
                || !Validar.contieneInformacion(p18A24F)
                || !Validar.contieneInformacion(p18A24M)
                || !Validar.contieneInformacion(p15A49F)
                || !Validar.contieneInformacion(p60YMasF)
                || !Validar.contieneInformacion(p60YMasM)) {
            throw new Exception("Los campos estan vacios");
        }

        if (!Validar.esNumero(idEntidad)
                || !Validar.esNumero(idMunicipio)
                || !Validar.esNumero(idLocalidad)
                || !Validar.esNumero(p0A2F)
                || !Validar.esNumero(p0A2M)
                || !Validar.esNumero(p3YMasF)
                || !Validar.esNumero(p3YMasM)
                || !Validar.esNumero(p5YMasF)
                || !Validar.esNumero(p5YMasM)
                || !Validar.esNumero(p12YMasF)
                || !Validar.esNumero(p12YMasM)
                || !Validar.esNumero(p15YMasF)
                || !Validar.esNumero(p15YMasM)
                || !Validar.esNumero(p18YMasF)
                || !Validar.esNumero(p18YMasM)
                || !Validar.esNumero(p3A5F)
                || !Validar.esNumero(p3A5M)
                || !Validar.esNumero(p6A11F)
                || !Validar.esNumero(p6A11M)
                || !Validar.esNumero(p8A14F)
                || !Validar.esNumero(p8A14M)
                || !Validar.esNumero(p12A14F)
                || !Validar.esNumero(p12A14M)
                || !Validar.esNumero(p15A17F)
                || !Validar.esNumero(p15A17M)
                || !Validar.esNumero(p18A24F)
                || !Validar.esNumero(p18A24M)
                || !Validar.esNumero(p15A49F)
                || !Validar.esNumero(p60YMasF)
                || !Validar.esNumero(p60YMasM)) {
            throw new Exception("Todos los campos deben ser numeros");
        }
        poblacionEdad.setIdEntidad(Integer.parseInt(idEntidad));
        poblacionEdad.setIdMunicipio(Integer.parseInt(idMunicipio));
        poblacionEdad.setIdLocalidad(Integer.parseInt(idLocalidad));

        poblacionEdad.setP0A2F(Integer.parseInt(p0A2F));
        poblacionEdad.setP0A2M(Integer.parseInt(p0A2M));
        poblacionEdad.setP3YMasF(Integer.parseInt(p3YMasF));
        poblacionEdad.setP3YMasM(Integer.parseInt(p3YMasM));
        poblacionEdad.setP5YMasF(Integer.parseInt(p5YMasF));
        poblacionEdad.setP5YMasM(Integer.parseInt(p5YMasM));
        poblacionEdad.setP12YMasF(Integer.parseInt(p12YMasF));
        poblacionEdad.setP12YMasM(Integer.parseInt(p12YMasM));
        poblacionEdad.setP15YMasF(Integer.parseInt(p15YMasF));
        poblacionEdad.setP15YMasM(Integer.parseInt(p15YMasM));
        poblacionEdad.setP18YMasF(Integer.parseInt(p18YMasF));
        poblacionEdad.setP18YMasM(Integer.parseInt(p18YMasM));
        poblacionEdad.setP3A5F(Integer.parseInt(p3A5F));
        poblacionEdad.setP3A5M(Integer.parseInt(p3A5M));
        poblacionEdad.setP6A11F(Integer.parseInt(p6A11F));
        poblacionEdad.setP6A11M(Integer.parseInt(p6A11M));
        poblacionEdad.setP8A14F(Integer.parseInt(p8A14F));
        poblacionEdad.setP8A14M(Integer.parseInt(p8A14M));
        poblacionEdad.setP12A14F(Integer.parseInt(p12A14F));
        poblacionEdad.setP12A14M(Integer.parseInt(p12A14M));
        poblacionEdad.setP15A17F(Integer.parseInt(p15A17F));
        poblacionEdad.setP15A17M(Integer.parseInt(p15A17M));
        poblacionEdad.setP18A24F(Integer.parseInt(p18A24F));
        poblacionEdad.setP18A24M(Integer.parseInt(p18A24M));
        poblacionEdad.setP15A49F(Integer.parseInt(p15A49F));
        poblacionEdad.setP60YMasF(Integer.parseInt(p60YMasF));
        poblacionEdad.setP60YMasM(Integer.parseInt(p60YMasM));

        return poblacionEdad;
    }

    public void cargarDatos(PoblacionEdad poblacionEdad) {
        formularioPoblacionEdadPanelTemplate.gettIdEntidad().setText(String.valueOf(poblacionEdad.getIdEntidad()));
        formularioPoblacionEdadPanelTemplate.gettIdMunicipio().setText(String.valueOf(poblacionEdad.getIdMunicipio()));
        formularioPoblacionEdadPanelTemplate.gettIdLocalidad().setText(String.valueOf(poblacionEdad.getIdLocalidad()));

        formularioPoblacionEdadPanelTemplate.gettP0A2F().setText(String.valueOf(poblacionEdad.getP0A2F()));
        formularioPoblacionEdadPanelTemplate.gettP0A2M().setText(String.valueOf(poblacionEdad.getP0A2M()));

        formularioPoblacionEdadPanelTemplate.gettP3YMasF().setText(String.valueOf(poblacionEdad.getP3YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP3YMasM().setText(String.valueOf(poblacionEdad.getP3YMasM()));

        formularioPoblacionEdadPanelTemplate.gettP5YMasF().setText(String.valueOf(poblacionEdad.getP5YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP5YMasM().setText(String.valueOf(poblacionEdad.getP5YMasM()));

        formularioPoblacionEdadPanelTemplate.gettP12YMasF().setText(String.valueOf(poblacionEdad.getP12YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP12YMasM().setText(String.valueOf(poblacionEdad.getP12YMasM()));

        formularioPoblacionEdadPanelTemplate.gettP15YMasF().setText(String.valueOf(poblacionEdad.getP15YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP15YMasM().setText(String.valueOf(poblacionEdad.getP15YMasM()));

        formularioPoblacionEdadPanelTemplate.gettP18YMasF().setText(String.valueOf(poblacionEdad.getP18YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP18YMasM().setText(String.valueOf(poblacionEdad.getP18YMasM()));

        formularioPoblacionEdadPanelTemplate.gettP3A5F().setText(String.valueOf(poblacionEdad.getP3A5F()));
        formularioPoblacionEdadPanelTemplate.gettP3A5M().setText(String.valueOf(poblacionEdad.getP3A5M()));

        formularioPoblacionEdadPanelTemplate.gettP6A11F().setText(String.valueOf(poblacionEdad.getP6A11F()));
        formularioPoblacionEdadPanelTemplate.gettP6A11M().setText(String.valueOf(poblacionEdad.getP6A11M()));

        formularioPoblacionEdadPanelTemplate.gettP8A14F().setText(String.valueOf(poblacionEdad.getP8A14F()));
        formularioPoblacionEdadPanelTemplate.gettP8A14M().setText(String.valueOf(poblacionEdad.getP8A14M()));

        formularioPoblacionEdadPanelTemplate.gettP12A14F().setText(String.valueOf(poblacionEdad.getP12A14F()));
        formularioPoblacionEdadPanelTemplate.gettP12A14M().setText(String.valueOf(poblacionEdad.getP12A14M()));

        formularioPoblacionEdadPanelTemplate.gettP15A17F().setText(String.valueOf(poblacionEdad.getP15A17F()));
        formularioPoblacionEdadPanelTemplate.gettP15A17M().setText(String.valueOf(poblacionEdad.getP15A17M()));

        formularioPoblacionEdadPanelTemplate.gettP18A24F().setText(String.valueOf(poblacionEdad.getP18A24F()));
        formularioPoblacionEdadPanelTemplate.gettP18A24M().setText(String.valueOf(poblacionEdad.getP18A24M()));

        formularioPoblacionEdadPanelTemplate.gettP15A49F().setText(String.valueOf(poblacionEdad.getP15A49F()));

        formularioPoblacionEdadPanelTemplate.gettP60YMasF().setText(String.valueOf(poblacionEdad.getP60YMasF()));
        formularioPoblacionEdadPanelTemplate.gettP60YMasM().setText(String.valueOf(poblacionEdad.getP60YMasM()));

    }

    public void restaurarValores() {
        formularioPoblacionEdadPanelTemplate.gettIdEntidad().setText("Id");
        formularioPoblacionEdadPanelTemplate.gettIdMunicipio().setText("Id");
        formularioPoblacionEdadPanelTemplate.gettIdLocalidad().setText("Id");

        formularioPoblacionEdadPanelTemplate.gettP0A2F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP0A2M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP3YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP3YMasM().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP5YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP5YMasM().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP12YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP12YMasM().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP15YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP15YMasM().setText("Cantidad");;

        formularioPoblacionEdadPanelTemplate.gettP18YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP18YMasM().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP3A5F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP3A5M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP6A11F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP6A11M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP8A14F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP8A14M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP12A14F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP12A14M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP15A17F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP15A17M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP18A24F().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP18A24M().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP15A49F().setText("Cantidad");

        formularioPoblacionEdadPanelTemplate.gettP60YMasF().setText("Cantidad");
        formularioPoblacionEdadPanelTemplate.gettP60YMasM().setText("Cantidad");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalcontroller() {
        return principalcontroller;
    }

    public FormularioPoblacionEdadPanelTemplate getFormularioPoblacionEdadPanelTemplate() {
        return formularioPoblacionEdadPanelTemplate;
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
