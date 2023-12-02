/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.tabla;


import com.thrs.TableModels.ModelMunicipio;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Municipio;
import com.thrs.repository.MunicipioDao;
import com.thrs.services.MunicipioService;
import com.thrs.vistas.panel.tabla.TablaMunicipiosPanelTemplate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class TablaMunicipiosPanelController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private TablaMunicipiosPanelTemplate tablaMunicipiosPanelTemplate;
    private MunicipioDao municipioDao;
    private List<Municipio> municipios;
    private Municipio municipio;
    private ModelMunicipio modelo;

    public TablaMunicipiosPanelController(PrincipalController principalController) {
        this.principalController = principalController;
        this.tablaMunicipiosPanelTemplate = new TablaMunicipiosPanelTemplate(this);
        this.municipioDao = new MunicipioDao();

        mostrarRegistrosTabla();

    }

    public void mostrarRegistrosTabla() {
        this.tablaMunicipiosPanelTemplate.getModelo().limpiarDatos();
        municipios = municipioDao.selectAll();
        
        this.tablaMunicipiosPanelTemplate.getModelo().agregarData(municipios);
//        entidades.forEach(ent -> {
//            this.agregarRegistro(ent);
//        });

    }
    
    public void deseleccionarElemento(){
    }

    public int filaSeleccionada() {
        return tablaMunicipiosPanelTemplate.getTabla().getSelectedRow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public PrincipalController getPrincipalController() {
        return principalController;
    }

    public TablaMunicipiosPanelTemplate getTablaMunicipiosPanelTemplate() {
        return tablaMunicipiosPanelTemplate;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            int filaSeleccionada = filaSeleccionada();

            municipio = new Municipio();
            modelo = this.tablaMunicipiosPanelTemplate.getModelo();

            int idEntidad = (Integer) modelo.getValueAt(filaSeleccionada, 0);
            int idMunicipio = (Integer) modelo.getValueAt(filaSeleccionada, 1);
            String nomMunicipio = (String) modelo.getValueAt(filaSeleccionada, 2);

            municipio.setIdEntidad(idEntidad);
            municipio.setIdMunicipio(idMunicipio);
            municipio.setNomMunicipio(nomMunicipio);

            principalController.getFormularioMunicipiosPanelController().cargarDatos(municipio);

        }
        
        //retroceder
        if (e.getSource() == tablaMunicipiosPanelTemplate.getBtnAnterior()) {
            tablaMunicipiosPanelTemplate.getModelo().previousPage();
            tablaMunicipiosPanelTemplate.getBtnSiguiente().setEnabled(true); // Al retroceder, habilita el botón de "Siguiente"
        }

        //actualizar un elemento
        if (e.getSource() == tablaMunicipiosPanelTemplate.getBtnSiguiente()) {
            modelo = tablaMunicipiosPanelTemplate.getModelo();
            modelo.nextPage();
            if ((modelo.getCurrentPage() + 1) * modelo.getPAGE_SIZE() >= municipios.size()) {
                tablaMunicipiosPanelTemplate.getBtnSiguiente().setEnabled(false); // Si estás en la última página, deshabilita el botón "Siguiente"
            }

        }

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

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public List<Municipio> getEntidades() {
        return municipios;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

}
