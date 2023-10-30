/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import com.thrs.controllers.formularios.FormularioEntidadesPanelController;
import com.thrs.controllers.tabla.TablaEntidadesPanelController;
import com.thrs.models.CatalogoEnum;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.vistas.PrincipalTemplate;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import static com.thrs.models.CatalogoEnum.*;

/**
 *
 * @author Usuario
 */
public class PrincipalController {

    private PrincipalTemplate principalTemplate;
    private MenuController menuController;
    private TituloPanelController tituloPanelController;
    private TablaEntidadesPanelController tablaEntidadesPanelController;
    private BotonesPanelController botonesPanelController;
    private FormularioEntidadesPanelController formularioEntidadesPanelController;
    private GridBagConstraints gbc;
    private ObjGraficosService sObjGraficos;

    private CatalogoEnum comando;

    public PrincipalController(MenuController menuController) {
        this.menuController = menuController;
    }

    private void crearObjetos() {
        
        this.tituloPanelController = new TituloPanelController(this, this.comando);
        this.tablaEntidadesPanelController = new TablaEntidadesPanelController(this);
        this.formularioEntidadesPanelController = new FormularioEntidadesPanelController(this);
        this.botonesPanelController = new BotonesPanelController(this, this.comando);
        this.sObjGraficos = ObjGraficosService.getService();
        
        this.gbc = new GridBagConstraints();
        this.principalTemplate = new PrincipalTemplate(this);
    }

    public void cerrarSesion() {
        this.menuController.getMenuTemplate().setVisible(true);
        this.principalTemplate.setVisible(false);
    }

    public void mostrarContenido() {
        //Agregamos el titulo
        principalTemplate.getpTitulo().removeAll();
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        principalTemplate.getpTitulo()
                .add(tituloPanelController.getTituloPanelTemplate(), gbc);

        switch (this.comando) {
            case ENTIDAD:
                //Agregamos la Tabla
                principalTemplate.getpTabla().removeAll();
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpTabla().setLayout(new GridBagLayout());
                principalTemplate.getpTabla().add(tablaEntidadesPanelController.getTablaEntidadesPanelTemplate(), gbc);

                //Agregamos el formulario
                principalTemplate.getpDatos().removeAll();
                gbc.fill = GridBagConstraints.BOTH;
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpDatos().setLayout(new GridBagLayout());
                principalTemplate.getpDatos().add(formularioEntidadesPanelController.getFormularioEntidadesPanelTemplate(), gbc);

                break;
            case MUNICIPIO:
                break;
            case LOCALIDAD:
                break;
            case CENSO_2020:
                break;
            case POBLACION_EDAD:
                break;
        }

        //cargamos la barra de botones
        principalTemplate.getpBotones().removeAll();
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        principalTemplate.getpBotones()
                .add(botonesPanelController.getBotonesPanelTemplate(), gbc);

        principalTemplate.setEstado(true);
        principalTemplate.repaint();
    }

    public PrincipalTemplate getPrincipalTemplate() {
        return principalTemplate;
    }

    public MenuController getMenuController() {
        return menuController;
    }

    public TituloPanelController getTituloPanelController() {
        return tituloPanelController;
    }

    public TablaEntidadesPanelController getTablaEntidadesPanelController() {
        return tablaEntidadesPanelController;
    }

    public BotonesPanelController getBotonesPanelController() {
        return botonesPanelController;
    }

    public FormularioEntidadesPanelController getFormularioEntidadesPanelController() {
        return formularioEntidadesPanelController;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public CatalogoEnum getComando() {
        return comando;
    }

    public void setComando(CatalogoEnum comando) {
        this.comando = comando;
        crearObjetos();
        mostrarContenido();
    }

}
