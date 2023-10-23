package com.thrs.controllers;

import com.thrs.services.graphicServices.RecursosService;
import com.thrs.vistas.MenuTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class MenuController implements ActionListener, MouseListener, FocusListener {

    private MenuTemplate menuTemplate;
    private PrincipalController principalController;

    public MenuController() {
        this.menuTemplate = new MenuTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == menuTemplate.getBtnEntidad()) {
            entrar("Entidades");
        }
        if (e.getSource() == menuTemplate.getBtnMunicipio()) {
            entrar("Municipios");
        }
        if (e.getSource() == menuTemplate.getBtnLocalidad()) {
            entrar("Localidades");
        }
        if (e.getSource() == menuTemplate.getBtnCenso()) {
            entrar("Censo 2020");
        }
        if (e.getSource() == menuTemplate.getBtnPoblacion()) {
            entrar("Poblacion Edad");
        }
        if (e.getSource() == menuTemplate.getBtnSalir()) {
            System.exit(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorSecundarioMenuObscuro());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorSecundarioMenu());
        }
    }

    public void entrar(String comando) {

        if (principalController == null) {
            this.principalController = new PrincipalController(this);
            this.principalController.setComando(comando);
        } else {
            this.principalController.setComando(comando);
            this.principalController.getPrincipalTemplate().setVisible(true);
            
        }

        menuTemplate.setVisible(false);
    }

    public MenuTemplate getMenuTemplate() {
        return menuTemplate;
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
