/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import com.thrs.controllers.formularios.FormularioCenso2020PanelController;
import com.thrs.controllers.formularios.FormularioEntidadesPanelController;
import com.thrs.controllers.formularios.FormularioLocalidadesPanelController;
import com.thrs.controllers.formularios.FormularioMunicipiosPanelController;
import com.thrs.controllers.formularios.FormularioPoblacionEdadPanelController;
import com.thrs.controllers.tabla.TablaCenso2020PanelController;
import com.thrs.controllers.tabla.TablaEntidadesPanelController;
import com.thrs.controllers.tabla.TablaLocalidadesPanelController;
import com.thrs.controllers.tabla.TablaMunicipiosPanelController;
import com.thrs.controllers.tabla.TablaPoblacionEdadPanelController;
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
    private TablaMunicipiosPanelController tablaMunicipiosPanelController;
    private TablaLocalidadesPanelController tablaLocalidadesPanelController;
    private TablaCenso2020PanelController tablaCenso2020PanelController;
    private TablaPoblacionEdadPanelController tablaPoblacionEdadPanelController;
    
    private BotonesPanelController botonesPanelController;
    
    private FormularioEntidadesPanelController formularioEntidadesPanelController;
    private FormularioMunicipiosPanelController formularioMunicipiosPanelController;
    private FormularioLocalidadesPanelController formularioLocalidadesPanelController;
    private FormularioCenso2020PanelController formularioCenso2020PanelController;
    private FormularioPoblacionEdadPanelController formularioPoblacionEdadPanelController;
    
    private GridBagConstraints gbc;
    private ObjGraficosService sObjGraficos;

    private CatalogoEnum comando;

    public PrincipalController(MenuController menuController) {
        this.menuController = menuController;
    }

    private void crearObjetos() {
        this.tituloPanelController = new TituloPanelController(this, this.comando);
        
        revisarCatalogo();
        
        this.botonesPanelController = new BotonesPanelController(this, this.comando);
        this.sObjGraficos = ObjGraficosService.getService();

        this.gbc = new GridBagConstraints();
        this.principalTemplate = new PrincipalTemplate(this);
    }
    
    private void revisarCatalogo(){
        switch(this.comando){
            case ENTIDAD:
                this.tablaEntidadesPanelController = new TablaEntidadesPanelController(this);
                this.formularioEntidadesPanelController = new FormularioEntidadesPanelController(this);
                break;
            case MUNICIPIO:
                this.tablaMunicipiosPanelController = new TablaMunicipiosPanelController(this);
                this.formularioMunicipiosPanelController = new FormularioMunicipiosPanelController(this);
                break;
            case LOCALIDAD:
                this.tablaLocalidadesPanelController = new TablaLocalidadesPanelController(this);
                this.formularioLocalidadesPanelController = new FormularioLocalidadesPanelController(this);
                break;
            case CENSO_2020:
                this.tablaCenso2020PanelController = new TablaCenso2020PanelController(this);
                this.formularioCenso2020PanelController = new FormularioCenso2020PanelController(this);
                break;
            case POBLACION_EDAD:
                this.tablaPoblacionEdadPanelController = new TablaPoblacionEdadPanelController(this);
                this.formularioPoblacionEdadPanelController = new FormularioPoblacionEdadPanelController(this);
                break;
        }
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

                //Agregamos la Tabla
                principalTemplate.getpTabla().removeAll();
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpTabla().setLayout(new GridBagLayout());
                principalTemplate.getpTabla().add(tablaMunicipiosPanelController.getTablaMunicipiosPanelTemplate(), gbc);

                //Agregamos el formulario
                principalTemplate.getpDatos().removeAll();
                gbc.fill = GridBagConstraints.BOTH;
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpDatos().setLayout(new GridBagLayout());
                principalTemplate.getpDatos().add(formularioMunicipiosPanelController.getFormularioEntidadesPanelTemplate().getScroll(), gbc);

                break;
            case LOCALIDAD:
                
                //Agregamos la Tabla
                principalTemplate.getpTabla().removeAll();
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpTabla().setLayout(new GridBagLayout());
                principalTemplate.getpTabla().add(tablaLocalidadesPanelController.getTablaLocalidadesPanelTemplate(), gbc);


                //Agregamos el formulario
                principalTemplate.getpDatos().removeAll();
                gbc.fill = GridBagConstraints.BOTH;
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpDatos().setLayout(new GridBagLayout());
                principalTemplate.getpDatos().add(formularioLocalidadesPanelController.getFormularioLocalidadesPanelTemplate().getScroll(), gbc);

                break;
            case CENSO_2020:
                
                //Agregamos la Tabla
                principalTemplate.getpTabla().removeAll();
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpTabla().setLayout(new GridBagLayout());
                principalTemplate.getpTabla().add(tablaCenso2020PanelController.getTablaCenso2020PanelTemplate(), gbc);

                
                //Agregamos el formulario
                principalTemplate.getpDatos().removeAll();
                gbc.fill = GridBagConstraints.BOTH;
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpDatos().setLayout(new GridBagLayout());
                principalTemplate.getpDatos().add(formularioCenso2020PanelController.getFormularioCenso2020PanelTemplate().getScroll(), gbc);

                
                break;
            case POBLACION_EDAD:
                
                //Agregamos la Tabla
                principalTemplate.getpTabla().removeAll();
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpTabla().setLayout(new GridBagLayout());
                principalTemplate.getpTabla().add(tablaPoblacionEdadPanelController.getTablaPoblacionEdadPanelTemplate(), gbc);

                
                //Agregamos el formulario
                principalTemplate.getpDatos().removeAll();
                gbc.fill = GridBagConstraints.BOTH;
                gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
                principalTemplate.getpDatos().setLayout(new GridBagLayout());
                principalTemplate.getpDatos().add(formularioPoblacionEdadPanelController.getFormularioPoblacionEdadPanelTemplate().getScroll(), gbc);

                
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

    public TablaMunicipiosPanelController getTablaMunicipiosPanelController() {
        return tablaMunicipiosPanelController;
    }

    public FormularioMunicipiosPanelController getFormularioMunicipiosPanelController() {
        return formularioMunicipiosPanelController;
    }

    public FormularioLocalidadesPanelController getFormularioLocalidadesPanelController() {
        return formularioLocalidadesPanelController;
    }

    public TablaLocalidadesPanelController getTablaLocalidadesPanelController() {
        return tablaLocalidadesPanelController;
    }

    public FormularioCenso2020PanelController getFormularioCenso2020PanelController() {
        return formularioCenso2020PanelController;
    }

    public FormularioPoblacionEdadPanelController getFormularioPoblacionEdadPanelController() {
        return formularioPoblacionEdadPanelController;
    }

    public TablaCenso2020PanelController getTablaCenso2020PanelController() {
        return tablaCenso2020PanelController;
    }

    public TablaPoblacionEdadPanelController getTablaPoblacionEdadPanelController() {
        return tablaPoblacionEdadPanelController;
    }
    
    

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
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
