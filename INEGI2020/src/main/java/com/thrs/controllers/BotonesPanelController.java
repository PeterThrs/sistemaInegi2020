/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers;

import static com.thrs.Mensaje.*;
import com.thrs.models.CatalogoEnum;
import static com.thrs.models.CatalogoEnum.*;
import com.thrs.models.Censo2020;
import com.thrs.models.Entidad;
import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import com.thrs.models.PoblacionEdad;
import com.thrs.services.Censo2020Service;
import com.thrs.services.EntidadService;
import com.thrs.services.LocalidadService;
import com.thrs.services.MunicipioService;
import com.thrs.services.PoblacionEdadService;
import com.thrs.services.graphicServices.RecursosService;
import static com.thrs.validation.Validar.*;
import com.thrs.vistas.panel.BotonesPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Usuario
 */
public class BotonesPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private BotonesPanelTemplate botonesPanelTemplate;

    private Entidad entidadRecuperada, entidadAnterior;
    private Municipio municipioRecuperado, municipioAnterior;
    private Localidad localidadRecuperada, localidadAnterior;
    private Censo2020 censoRecuperado, censoAnterior;
    private PoblacionEdad pobRecuperada, pobAnterior;

    private CatalogoEnum comando;

    private EntidadService sEntidad;
    private MunicipioService sMunicipio;
    private LocalidadService sLocalidad;
    private Censo2020Service sCenso2020;
    private PoblacionEdadService sPoblacionEdad;

    private List<Entidad> entidades;
    private List<Municipio> municipios;
    private List<Localidad> localidades;
    private List<Censo2020> listaCenso;
    private List<PoblacionEdad> listaPoblacion;

    public BotonesPanelController(PrincipalController principalController, CatalogoEnum comando) {
        this.principalController = principalController;
        this.comando = comando;
        this.botonesPanelTemplate = new BotonesPanelTemplate(this, this.comando.getValor());

        this.sEntidad = sEntidad.getService();
        this.sMunicipio = sMunicipio.getService();
        this.sLocalidad = sLocalidad.getService();
        this.sCenso2020 = sCenso2020.getService();
        this.sPoblacionEdad = sPoblacionEdad.getService();
    }

    private int filaSeleccionada() {
        switch (comando) {
            case ENTIDAD:
                return principalController.getTablaEntidadesPanelController().filaSeleccionada();
            case MUNICIPIO:
                return principalController.getTablaMunicipiosPanelController().filaSeleccionada();
            case LOCALIDAD:
                return principalController.getTablaLocalidadesPanelController().filaSeleccionada();
            case CENSO_2020:
                return principalController.getTablaCenso2020PanelController().filaSeleccionada();
            case POBLACION_EDAD:
                return principalController.getTablaPoblacionEdadPanelController().filaSeleccionada();
        }
        return -1;
    }

    private void cargarListas() {

        switch (this.comando) {
            case ENTIDAD:
                this.entidades = sEntidad.getEntidades();
                break;
            case MUNICIPIO:
                this.entidades = sEntidad.getEntidades();
                this.municipios = sMunicipio.getMunicipios();
                break;
            case LOCALIDAD:
                this.municipios = sMunicipio.getMunicipios();
                this.localidades = sLocalidad.getLocalidades();
                break;
            case CENSO_2020:
                this.localidades = sLocalidad.getLocalidades();
                this.listaCenso = sCenso2020.getListaCenso();
                break;
            case POBLACION_EDAD:
                this.localidades = sLocalidad.getLocalidades();
                this.listaPoblacion = sPoblacionEdad.getListaPoblacion();
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int filaSeleccionada = filaSeleccionada();

        //insertar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnCreate()) {
            cargarListas();
            insert();
        }

        //actualizar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnUpdate()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            cargarListas();
            update();

        }

        //eliminar un elemento
        if (e.getSource() == botonesPanelTemplate.getBtnDelete()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            delete();
        }

        //limpiar el formulario 
        if (e.getSource() == botonesPanelTemplate.getBtnClean()) {
            limpiar();
        }

        //regresar a la ventana anterior
        if (e.getSource() == botonesPanelTemplate.getBtnRegresar()) {
            this.principalController.cerrarSesion();
        }

    }

    private void insert() {
        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadRecuperada = this.principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    if (compararIdEntidad(this.entidades, entidadRecuperada)) {
                        mensajeError("Ya existe el ID de entidad");
                        return;
                    }
                    this.sEntidad.agregarEntidad(entidadRecuperada);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad Insertada correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.principalController.getFormularioMunicipiosPanelController().recuperarDatos();
                    if (!existeIdEntidad(entidades, municipioRecuperado)) {
                        mensajeError("No existe el Id de Entidad");
                        return;
                    }

                    if (compararMunicipios(municipios, municipioRecuperado)) {
                        mensajeError("Ya existe el id de Entidad y Municipio");
                        return;
                    }

                    this.sMunicipio.agregarMunicipio(municipioRecuperado);
                    this.principalController.getTablaMunicipiosPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioMunicipiosPanelController().restaurarValores();
                    mensajeInformativo("Municipio insertado correctamente");

                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.principalController.getFormularioLocalidadesPanelController().recuperarDatos();

                    if (!existeMunicipio(municipios, localidadRecuperada)) {
                        mensajeError("No existe el Municipio");
                        return;
                    }

                    if (compararLocalidades(localidades, localidadRecuperada)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y localidad");
                        return;
                    }

                    this.sLocalidad.agregarLocalidad(localidadRecuperada);
                    this.principalController.getTablaLocalidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioLocalidadesPanelController().restaurarValores();
                    mensajeInformativo("Localidad insertada correctamente");

                    break;
                case CENSO_2020:

                    this.censoRecuperado = this.principalController.getFormularioCenso2020PanelController().recuperarDatos();
                    
                    //comprobar is existe la localidad
                    if (!existeLocalidad(localidades, censoRecuperado)) {
                        mensajeError("No existe la localidad");
                        return;
                    }
                    
                    if (compararCenso2020(listaCenso, censoRecuperado)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y Localiadad");
                        return;
                    }

                    this.sCenso2020.agregarCenso(censoRecuperado);
                    this.principalController.getTablaCenso2020PanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioCenso2020PanelController().restaurarValores();
                    mensajeInformativo("Censo2020 insertado correctamente");

                    break;
                case POBLACION_EDAD:
                    this.pobRecuperada = this.principalController.getFormularioPoblacionEdadPanelController().recuperarDatos();
                    
                    System.out.println("pobRecuperada = " + pobRecuperada);
                    
                    //comprobar is existe la localidad
                    if (!existeLocalidad(localidades, pobRecuperada)) {
                        mensajeError("No existe la localidad");
                        return;
                    }
                    
                    if (compararPoblacion(listaPoblacion, pobRecuperada)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y Localiadad");
                        return;
                    }

                    this.sPoblacionEdad.agregarPoblacion(pobRecuperada);
                    this.principalController.getTablaPoblacionEdadPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioPoblacionEdadPanelController().restaurarValores();
                    mensajeInformativo("Registro de poblacion insertado correctamente");
                    
                    break;
            }

        } catch (Exception ex) {
            mensajeError(ex.getMessage());
            ex.printStackTrace();
        }

    }

    private void update() {

        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadRecuperada = principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    this.entidadAnterior = principalController.getTablaEntidadesPanelController().getEntidad();
                    if (existeElemento(entidades, entidadRecuperada)) {
                        mensajeError("No ha modificado el registro");
                        return;
                    }
                    if (compararIdEntidad(this.entidades, entidadRecuperada, entidadAnterior)) {
                        mensajeError("Ya existe el ID de entidad al que quiere actualizar");
                        return;
                    }
                    sEntidad.actualizarEntidad(entidadRecuperada, entidadAnterior);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad modificada correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.principalController.getFormularioMunicipiosPanelController().recuperarDatos();
                    this.municipioAnterior = principalController.getTablaMunicipiosPanelController().getMunicipio();
                    
                    System.out.println("municipioAnterior = " + municipioAnterior);
                    System.out.println("municipioRecuperado = " + municipioRecuperado);
                    
                    
                    if (existeElemento(municipios, municipioRecuperado)) {
                        mensajeError("No ha modificado el registro");
                        return;
                    }

                    if (!existeIdEntidad(entidades, municipioRecuperado)) {
                        mensajeError("No existe la Entidad");
                        return;
                    }
                    
                    if (compararMunicipios(municipios, municipioRecuperado, municipioAnterior)) {
                        mensajeError("Ya existe el id de Entidad y Municipio");
                        return;
                    }

                    this.sMunicipio.actualizarMunicipio(municipioRecuperado, municipioAnterior);
                    this.principalController.getTablaMunicipiosPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioMunicipiosPanelController().restaurarValores();
                    mensajeInformativo("Municipio modificado correctamente");

                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.principalController.getFormularioLocalidadesPanelController().recuperarDatos();
                    this.localidadAnterior = this.principalController.getTablaLocalidadesPanelController().getLocalidad();
                    
                    System.out.println("localidadRecuperada = " + localidadRecuperada);
                    System.out.println("localidadAnterior = " + localidadAnterior);

                    if (existeElemento(localidades, localidadRecuperada)) {
                        mensajeError("No ha modificado el registro");
                        return;
                    }

                    if (!existeMunicipio(municipios, localidadRecuperada)) {
                        mensajeError("No existe el Municipio");
                        return;
                    }

                    if (compararLocalidades(localidades, localidadRecuperada, localidadAnterior)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y Localiadad");
                        return;
                    }

                    this.sLocalidad.actualizarLocalidad(localidadRecuperada, localidadAnterior);
                    this.principalController.getTablaLocalidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioLocalidadesPanelController().restaurarValores();
                    mensajeInformativo("Localidad actualizada correctamente");

                    break;
                case CENSO_2020:
                    
                    this.censoRecuperado = this.principalController.getFormularioCenso2020PanelController().recuperarDatos();
                    this.censoAnterior = this.principalController.getTablaCenso2020PanelController().getCenso2020();
                    System.out.println("censoAnterior = " + censoAnterior);
                    System.out.println("censoRecuperado = " + censoRecuperado);

                    //comprobar si existe el Censo de esa localidad
                    if (existeElemento(listaCenso, censoRecuperado)) {
                        mensajeError("No has modificado el registro");
                        return;
                    }
                    //comprobar is existe la localidad
                    if (!existeLocalidad(localidades, censoRecuperado)) {
                        mensajeError("No existe la localidad");
                        return;
                    }
                    
                    if (compararCenso2020(listaCenso, censoRecuperado, censoAnterior)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y Localiadad");
                        return;
                    }
                    
                    this.sCenso2020.actualizarCenso(censoRecuperado, censoAnterior);
                    this.principalController.getTablaCenso2020PanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioCenso2020PanelController().restaurarValores();
                    mensajeInformativo("Censo2020 actualizado correctamente");
                    
                    break;
                case POBLACION_EDAD:
                    
                    this.pobRecuperada = this.principalController.getFormularioPoblacionEdadPanelController().recuperarDatos();
                    this.pobAnterior = this.principalController.getTablaPoblacionEdadPanelController().getPoblacionEdad();
                    System.out.println("pobAnterior = " + pobAnterior);
                    System.out.println("pobRecuperada = " + pobRecuperada);

                    //comprobar si existe el Censo de esa localidad
                    if (existeElemento(listaPoblacion, pobRecuperada)) {
                        mensajeError("No has modificado el registro");
                        return;
                    }
                    //comprobar is existe la localidad
                    if (!existeLocalidad(localidades, pobRecuperada)) {
                        mensajeError("No existe la localidad");
                        return;
                    }
                    
                    if (compararPoblacion(listaPoblacion, pobRecuperada, pobAnterior)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y Localiadad");
                        return;
                    }
                    
                    this.sPoblacionEdad.actualizarPoblacion(pobRecuperada, pobAnterior);
                    this.principalController.getTablaPoblacionEdadPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioPoblacionEdadPanelController().restaurarValores();
                    mensajeInformativo("Registro de poblacion actualizado correctamente");
                    
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    private void delete() {

        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadAnterior = principalController.getTablaEntidadesPanelController().getEntidad();
                    this.entidadRecuperada = this.principalController.getFormularioEntidadesPanelController().recuperarDatos();
                    if (!objectosIguales(entidadAnterior, entidadRecuperada)) {
                        mensajeError("No debe modificar el registro");
                        return;
                    }
                    sEntidad.eliminarEntidad(entidadRecuperada);
                    this.principalController.getTablaEntidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    mensajeInformativo("Entidad Elimina correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.principalController.getFormularioMunicipiosPanelController().recuperarDatos();
                    this.municipioAnterior = principalController.getTablaMunicipiosPanelController().getMunicipio();
                    if (!objectosIguales(municipioAnterior, municipioRecuperado)) {
                        mensajeError("No debe modificar el campo");
                        return;
                    }
                    sMunicipio.eliminarMunicipio(municipioRecuperado);
                    this.principalController.getTablaMunicipiosPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioMunicipiosPanelController().restaurarValores();
                    mensajeInformativo("Municipio eliminado correctamente");

                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.principalController.getFormularioLocalidadesPanelController().recuperarDatos();
                    this.localidadAnterior = this.principalController.getTablaLocalidadesPanelController().getLocalidad();
                    if (!objectosIguales(localidadAnterior, localidadRecuperada)) {
                        mensajeError("No debe modificar el campo");
                        return;
                    }
                    sLocalidad.eliminarLocalidad(localidadRecuperada);
                    this.principalController.getTablaLocalidadesPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioLocalidadesPanelController().restaurarValores();
                    mensajeInformativo("Localidad eliminada correctamente");

                    break;
                case CENSO_2020:
                    
                    this.censoRecuperado = this.principalController.getFormularioCenso2020PanelController().recuperarDatos();
                    this.censoAnterior = this.principalController.getTablaCenso2020PanelController().getCenso2020();

                    if (!objectosIguales(censoAnterior, censoRecuperado)) {
                        mensajeError("No debe modificar los IDS");
                        return;
                    }

                    this.sCenso2020.eliminarCenso(censoRecuperado);
                    this.principalController.getTablaCenso2020PanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioCenso2020PanelController().restaurarValores();
                    mensajeInformativo("Censo2020 eliminado correctamente");
                    break;
                case POBLACION_EDAD:
                    
                    this.pobRecuperada = this.principalController.getFormularioPoblacionEdadPanelController().recuperarDatos();
                    this.pobAnterior = this.principalController.getTablaPoblacionEdadPanelController().getPoblacionEdad();
                    
                    if (!objectosIguales(pobAnterior, pobRecuperada)) {
                        mensajeError("No debe modificar los IDS");
                        return;
                    }

                    this.sPoblacionEdad.eliminarPoblacion(pobRecuperada);
                    this.principalController.getTablaPoblacionEdadPanelController().mostrarRegistrosTabla();
                    this.principalController.getFormularioPoblacionEdadPanelController().restaurarValores();
                    mensajeInformativo("Registro de poblacion eliminado correctamente");
                    
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    private void limpiar() {

        try {
            switch (this.comando) {
                case ENTIDAD:
                    this.principalController.getFormularioEntidadesPanelController().restaurarValores();
                    break;
                case MUNICIPIO:
                    this.principalController.getFormularioMunicipiosPanelController().restaurarValores();
                    break;
                case LOCALIDAD:
                    this.principalController.getFormularioLocalidadesPanelController().restaurarValores();
                    break;
                case CENSO_2020:
                    this.principalController.getFormularioCenso2020PanelController().restaurarValores();
                    break;
                case POBLACION_EDAD:
                    this.principalController.getFormularioPoblacionEdadPanelController().restaurarValores();
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public BotonesPanelTemplate getBotonesPanelTemplate() {
        return botonesPanelTemplate;
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
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipalOscuro());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(RecursosService.getService().getColorPrincipal());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

}
