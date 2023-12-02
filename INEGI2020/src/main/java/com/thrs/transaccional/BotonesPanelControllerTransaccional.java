/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional;

import com.thrs.controllers.*;
import static com.thrs.Mensaje.*;
import com.thrs.models.CatalogoEnum;
import static com.thrs.models.CatalogoEnum.*;
import com.thrs.models.Censo2020;
import com.thrs.models.Entidad;
import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import com.thrs.models.PoblacionEdad;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.transaccional.conexion.EntidadDaoTransaccional;
import com.thrs.transaccional.conexion.LocalidadDaoTransaccional;
import com.thrs.transaccional.conexion.MunicipioDaoTransaccional;
import static com.thrs.validation.Validar.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author Usuario
 */
public class BotonesPanelControllerTransaccional implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private BotonesPanelTemplateTransaccional botonesPanelTemplateTransaccional;

    private Entidad entidadRecuperada, entidadAnterior;
    private Municipio municipioRecuperado, municipioAnterior;
    private Localidad localidadRecuperada, localidadAnterior;
    private Censo2020 censoRecuperado, censoAnterior;
    private PoblacionEdad pobRecuperada, pobAnterior;
    private EncargadoTransacciones encargado;

    private CatalogoEnum comando;

    private EntidadDaoTransaccional entidadDao;
    private MunicipioDaoTransaccional municipioDao;
    private LocalidadDaoTransaccional localidadDao;

    private List<Entidad> entidades;
    private List<Municipio> municipios;
    private List<Localidad> localidades;
    private List<Censo2020> listaCenso;
    private List<PoblacionEdad> listaPoblacion;

    private JComboBox<String> cbVentanas;

    public BotonesPanelControllerTransaccional(EncargadoTransacciones encargado, Connection conexion, PrincipalController principalController, CatalogoEnum comando) {
        this.principalController = principalController;
        this.comando = comando;
        this.encargado = encargado;
        this.botonesPanelTemplateTransaccional = new BotonesPanelTemplateTransaccional(this, this.comando.getValor());

        this.entidadDao = new EntidadDaoTransaccional(conexion);
        this.municipioDao = new MunicipioDaoTransaccional(conexion);
        this.localidadDao = new LocalidadDaoTransaccional(conexion);

        cargarOpcionesCombo();
    }

    private void cargarOpcionesCombo() {
        cbVentanas = botonesPanelTemplateTransaccional.getCbVentanas();
        cbVentanas.removeAllItems();

        cbVentanas.addItem(ENTIDAD.getValor());
        cbVentanas.addItem(MUNICIPIO.getValor());
        cbVentanas.addItem(LOCALIDAD.getValor());
    }

    private int filaSeleccionada() {
        switch (comando) {
            case ENTIDAD:
                return encargado.getTablaEntidadesPanelControllerTransacciones().filaSeleccionada();
            case MUNICIPIO:
                return encargado.getTablaMunicipiosPanelControllerTransacciones().filaSeleccionada();
            case LOCALIDAD:
                return encargado.getTablaLocalidadesPanelControllerTransaccional().filaSeleccionada();
        }
        return -1;
    }

    private void cargarListas() {
        try {
            switch (this.comando) {
                case ENTIDAD:
                    this.entidades = entidadDao.selectAll();
                    break;
                case MUNICIPIO:
                    this.entidades = entidadDao.selectAll();
                    this.municipios = municipioDao.selectAll();
                    break;
                case LOCALIDAD:
                    this.municipios = municipioDao.selectAll();
                    this.localidades = localidadDao.selectAll();
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int filaSeleccionada = filaSeleccionada();

        //revisar el combo box
        if (e.getSource() == botonesPanelTemplateTransaccional.getCbVentanas()) {
            String opcionSeleccionada = ((String) botonesPanelTemplateTransaccional.getCbVentanas().getSelectedItem());
            if (opcionSeleccionada == null) {
                return;
            }

            if (opcionSeleccionada.equals(ENTIDAD.getValor())) {
                encargado.actulizarPaneles(ENTIDAD);
                this.comando = ENTIDAD;
            }

            if (opcionSeleccionada.equals(MUNICIPIO.getValor())) {
                encargado.actulizarPaneles(MUNICIPIO);
                this.comando = MUNICIPIO;
            }

            if (opcionSeleccionada.equals(LOCALIDAD.getValor())) {
                encargado.actulizarPaneles(LOCALIDAD);
                this.comando = LOCALIDAD;
            }

        }

        //insertar un elemento
        if (e.getSource() == botonesPanelTemplateTransaccional.getBtnCreate()) {
            cargarListas();
            insert();
        }

        //actualizar un elemento
        if (e.getSource() == botonesPanelTemplateTransaccional.getBtnUpdate()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            cargarListas();
            update();

        }

        //eliminar un elemento
        if (e.getSource() == botonesPanelTemplateTransaccional.getBtnDelete()) {
            if (filaSeleccionada == -1) {
                mensajeAdvertencia("Debes seleccionar un campo de la tabla");
                return;
            }
            delete();
        }

        //limpiar el formulario 
        if (e.getSource() == botonesPanelTemplateTransaccional.getBtnClean()) {
            limpiar();
        }
        try {
            if (e.getSource() == botonesPanelTemplateTransaccional.getBtnRollback()) {
                encargado.realizarRollback();
                refrescarDatos();
            }

            if (e.getSource() == botonesPanelTemplateTransaccional.getBtnCommit()) {
                encargado.realizarCommit();
                refrescarDatos();
            }

        } catch (Exception ex) {
            mensajeError(ex.getMessage());
            ex.printStackTrace();
        }

        //regresar a la ventana anterior
        if (e.getSource() == botonesPanelTemplateTransaccional.getBtnRegresar()) {
            this.encargado.cerrarSesion();
        }

    }

    private void refrescarDatos() {
        try {

            this.encargado.getTablaEntidadesPanelControllerTransacciones().mostrarRegistrosTabla();
            this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();

            this.encargado.getTablaMunicipiosPanelControllerTransacciones().mostrarRegistrosTabla();
            this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();

            this.encargado.getTablaLocalidadesPanelControllerTransaccional().mostrarRegistrosTabla();
            this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
//            switch (comando) {
//                case ENTIDAD:
//                    this.encargado.getTablaEntidadesPanelControllerTransacciones().mostrarRegistrosTabla();
//                    this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();
//                    break;
//                case MUNICIPIO:
//                    this.encargado.getTablaMunicipiosPanelControllerTransacciones().mostrarRegistrosTabla();
//                    this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();
//                    break;
//                case LOCALIDAD:
//                    this.encargado.getTablaLocalidadesPanelControllerTransaccional().mostrarRegistrosTabla();
//                    this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
//                    break;
//            }

        } catch (Exception ex) {
            mensajeError(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void insert() {
        try {
            switch (this.comando) {
                case ENTIDAD:

                    this.entidadRecuperada = this.encargado.getFormularioEntidadesPanelControllerTransaccional().recuperarDatos();
                    if (compararIdEntidad(this.entidades, entidadRecuperada)) {
                        mensajeError("Ya existe el ID de entidad");
                        return;
                    }
                    this.entidadDao.insert(entidadRecuperada);
                    this.encargado.getTablaEntidadesPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Entidad Insertada correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.encargado.getFormularioMunicipiosPanelControllerTransacciones().recuperarDatos();
                    if (!existeIdEntidad(entidades, municipioRecuperado)) {
                        mensajeError("No existe el Id de Entidad");
                        return;
                    }

                    if (compararMunicipios(municipios, municipioRecuperado)) {
                        mensajeError("Ya existe el id de Entidad y Municipio");
                        return;
                    }

                    this.municipioDao.insert(municipioRecuperado);
                    this.encargado.getTablaMunicipiosPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();
                    mensajeInformativo("Municipio insertado correctamente");
                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.encargado.getFormularioLocalidadesPanelControllerTransaccional().recuperarDatos();

                    if (!existeMunicipio(municipios, localidadRecuperada)) {
                        mensajeError("No existe el Municipio");
                        return;
                    }

                    if (compararLocalidades(localidades, localidadRecuperada)) {
                        mensajeError("Ya existe el id de Entidad, Municipio y localidad");
                        return;
                    }

                    this.localidadDao.insert(localidadRecuperada);
                    this.encargado.getTablaLocalidadesPanelControllerTransaccional().mostrarRegistrosTabla();
                    this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Localidad insertada correctamente");
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

                    this.entidadRecuperada = encargado.getFormularioEntidadesPanelControllerTransaccional().recuperarDatos();
                    this.entidadAnterior = encargado.getTablaEntidadesPanelControllerTransacciones().getEntidad();
                    if (existeElemento(entidades, entidadRecuperada)) {
                        mensajeError("No ha modificado el registro");
                        return;
                    }
                    if (compararIdEntidad(this.entidades, entidadRecuperada, entidadAnterior)) {
                        mensajeError("Ya existe el ID de entidad al que quiere actualizar");
                        return;
                    }
                    entidadDao.update(entidadRecuperada, entidadAnterior);
                    this.encargado.getTablaEntidadesPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Entidad modificada correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.encargado.getFormularioMunicipiosPanelControllerTransacciones().recuperarDatos();
                    this.municipioAnterior = encargado.getTablaMunicipiosPanelControllerTransacciones().getMunicipio();

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

                    this.municipioDao.update(municipioRecuperado, municipioAnterior);
                    this.encargado.getTablaMunicipiosPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();
                    mensajeInformativo("Municipio modificado correctamente");
                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.encargado.getFormularioLocalidadesPanelControllerTransaccional().recuperarDatos();
                    this.localidadAnterior = this.encargado.getTablaLocalidadesPanelControllerTransaccional().getLocalidad();

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

                    this.localidadDao.update(localidadRecuperada, localidadAnterior);
                    this.encargado.getTablaLocalidadesPanelControllerTransaccional().mostrarRegistrosTabla();
                    this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Localidad actualizada correctamente");
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

                    this.entidadAnterior = encargado.getTablaEntidadesPanelControllerTransacciones().getEntidad();
                    this.entidadRecuperada = this.encargado.getFormularioEntidadesPanelControllerTransaccional().recuperarDatos();
                    if (!objectosIguales(entidadAnterior, entidadRecuperada)) {
                        mensajeError("No debe modificar el registro");
                        return;
                    }
                    entidadDao.delete(entidadRecuperada);
                    this.encargado.getTablaEntidadesPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Entidad Elimina correctamente");

                    break;
                case MUNICIPIO:

                    this.municipioRecuperado = this.encargado.getFormularioMunicipiosPanelControllerTransacciones().recuperarDatos();
                    this.municipioAnterior = encargado.getTablaMunicipiosPanelControllerTransacciones().getMunicipio();
                    if (!objectosIguales(municipioAnterior, municipioRecuperado)) {
                        mensajeError("No debe modificar el campo");
                        return;
                    }
                    municipioDao.delete(municipioRecuperado);
                    this.encargado.getTablaMunicipiosPanelControllerTransacciones().mostrarRegistrosTabla();
                    this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();
                    mensajeInformativo("Municipio eliminado correctamente");
                    break;
                case LOCALIDAD:

                    this.localidadRecuperada = this.encargado.getFormularioLocalidadesPanelControllerTransaccional().recuperarDatos();
                    this.localidadAnterior = this.encargado.getTablaLocalidadesPanelControllerTransaccional().getLocalidad();
                    if (!objectosIguales(localidadAnterior, localidadRecuperada)) {
                        mensajeError("No debe modificar el campo");
                        return;
                    }
                    localidadDao.delete(localidadRecuperada);
                    this.encargado.getTablaLocalidadesPanelControllerTransaccional().mostrarRegistrosTabla();
                    this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
                    mensajeInformativo("Localidad eliminada correctamente");
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
                    this.encargado.getFormularioEntidadesPanelControllerTransaccional().restaurarValores();
                    break;
                case MUNICIPIO:
                    this.encargado.getFormularioMunicipiosPanelControllerTransacciones().restaurarValores();
                    break;
                case LOCALIDAD:
                    this.encargado.getFormularioLocalidadesPanelControllerTransaccional().restaurarValores();
                    break;
            }
        } catch (Exception ex) {
            mensajeError(ex.getMessage());
        }

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public BotonesPanelTemplateTransaccional getBotonesPanelTemplateTransaccional() {
        return botonesPanelTemplateTransaccional;
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
