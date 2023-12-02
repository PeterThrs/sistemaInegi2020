/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional;

import com.thrs.transaccional.entidades.TablaEntidadesPanelControllerTransacciones;
import com.thrs.transaccional.entidades.FormularioEntidadesPanelControllerTransaccional;
import com.thrs.controllers.CambiaPanel;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.CatalogoEnum;
import com.thrs.repository.Conexion;
import com.thrs.transaccional.localidades.FormularioLocalidadesPanelControllerTransaccional;
import com.thrs.transaccional.localidades.TablaLocalidadesPanelControllerTransaccional;
import com.thrs.transaccional.municipio.FormularioMunicipiosPanelControllerTransacciones;
import com.thrs.transaccional.municipio.TablaMunicipiosPanelControllerTransacciones;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EncargadoTransacciones {

    //Objetos transaccionales
    private TablaEntidadesPanelControllerTransacciones tablaEntidadesPanelControllerTransacciones;
    private FormularioEntidadesPanelControllerTransaccional formularioEntidadesPanelControllerTransaccional;

    private TablaMunicipiosPanelControllerTransacciones tablaMunicipiosPanelControllerTransacciones;
    private FormularioMunicipiosPanelControllerTransacciones formularioMunicipiosPanelControllerTransacciones;
    
    private TablaLocalidadesPanelControllerTransaccional tablaLocalidadesPanelControllerTransaccional;
    private FormularioLocalidadesPanelControllerTransaccional formularioLocalidadesPanelControllerTransaccional;

    private BotonesPanelControllerTransaccional botonesPanelControllerTransaccional;
    private CatalogoEnum comando;
    private PrincipalController principalController;
    private Connection conexion;
    private CambiaPanel cambiaPanel;

    public EncargadoTransacciones(PrincipalController principalController) {
        this.principalController = principalController;
        this.comando = CatalogoEnum.ENTIDAD;
        cargarPaneles();
    }
    
    public void cerrarSesion(){
        try {
            principalController.cerrarSesion();
            Conexion.close(conexion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void realizarCommit() {
        if (conexion != null) {
            try {
                conexion.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void realizarRollback() {
        if (conexion != null) {
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void actulizarPaneles(CatalogoEnum comando) {
        try {
            switch (comando) {
                case ENTIDAD:
                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpDatos(),
                            formularioEntidadesPanelControllerTransaccional.getFormularioEntidadesPanelTemplateTransaccional());

                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpTabla(),
                            tablaEntidadesPanelControllerTransacciones.getTablaEntidadesPanelTemplateTransacciones());
                    break;
                case MUNICIPIO:
                    tablaMunicipiosPanelControllerTransacciones = new TablaMunicipiosPanelControllerTransacciones(this, conexion, principalController);
                    formularioMunicipiosPanelControllerTransacciones = new FormularioMunicipiosPanelControllerTransacciones(principalController);
                    
                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpDatos(),
                            formularioMunicipiosPanelControllerTransacciones.getFormularioMunicipiosPanelTemplateTransacciones().getScroll());

                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpTabla(),
                            tablaMunicipiosPanelControllerTransacciones.getTablaMunicipiosPanelTemplateTransacciones());
                    
                    break;
                case LOCALIDAD:
                    
                    tablaLocalidadesPanelControllerTransaccional = new TablaLocalidadesPanelControllerTransaccional(this, conexion, principalController);
                    formularioLocalidadesPanelControllerTransaccional = new FormularioLocalidadesPanelControllerTransaccional(principalController);
                    
                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpDatos(),
                            formularioLocalidadesPanelControllerTransaccional.getFormularioLocalidadesPanelTemplateTransaccional().getScroll());

                    cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpTabla(),
                            tablaLocalidadesPanelControllerTransaccional.getTablaLocalidadesPanelTemplateTransaccional());
                    
                    break;
            }
            //JOptionPane.showMessageDialog(null, "Ha cambiado de formulario", "Informacion", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void cargarPaneles() {
        try {

            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            tablaEntidadesPanelControllerTransacciones = new TablaEntidadesPanelControllerTransacciones(this, conexion, this.principalController);
            formularioEntidadesPanelControllerTransaccional = new FormularioEntidadesPanelControllerTransaccional(this, conexion, this.principalController);
            botonesPanelControllerTransaccional = new BotonesPanelControllerTransaccional(this, conexion, principalController, comando);

            cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpDatos(),
                    formularioEntidadesPanelControllerTransaccional.getFormularioEntidadesPanelTemplateTransaccional());

            cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpTabla(),
                    tablaEntidadesPanelControllerTransacciones.getTablaEntidadesPanelTemplateTransacciones());

            cambiaPanel = new CambiaPanel(this.principalController.getPrincipalTemplate().getpBotones(),
                    botonesPanelControllerTransaccional.getBotonesPanelTemplateTransaccional());

            //conexion.commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public TablaEntidadesPanelControllerTransacciones getTablaEntidadesPanelControllerTransacciones() {
        return tablaEntidadesPanelControllerTransacciones;
    }

    public FormularioEntidadesPanelControllerTransaccional getFormularioEntidadesPanelControllerTransaccional() {
        return formularioEntidadesPanelControllerTransaccional;
    }

    public TablaMunicipiosPanelControllerTransacciones getTablaMunicipiosPanelControllerTransacciones() {
        return tablaMunicipiosPanelControllerTransacciones;
    }

    public FormularioMunicipiosPanelControllerTransacciones getFormularioMunicipiosPanelControllerTransacciones() {
        return formularioMunicipiosPanelControllerTransacciones;
    }

    public TablaLocalidadesPanelControllerTransaccional getTablaLocalidadesPanelControllerTransaccional() {
        return tablaLocalidadesPanelControllerTransaccional;
    }

    public FormularioLocalidadesPanelControllerTransaccional getFormularioLocalidadesPanelControllerTransaccional() {
        return formularioLocalidadesPanelControllerTransaccional;
    }
    

    public CatalogoEnum getComando() {
        return comando;
    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public Connection getConexion() {
        return conexion;
    }

}
