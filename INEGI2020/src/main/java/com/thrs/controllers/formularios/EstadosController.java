/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.controllers.formularios;

import com.sun.security.auth.PrincipalComparator;
import com.thrs.controllers.PrincipalController;
import com.thrs.models.Entidad;
import com.thrs.models.consultas.Estado;
import com.thrs.repository.ConsultasBD;
import com.thrs.services.EntidadService;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import com.thrs.vistas.Grafico;
import com.thrs.vistas.panel.EstadosPanelTemplate;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Usuario
 */
public class EstadosController implements ActionListener, MouseListener, FocusListener {

    private PrincipalController principalController;
    private EstadosPanelTemplate estadosPanelTemplate;
    private EntidadService sEntidad;
    private JComboBox<String> combo;
    private ConsultasBD consulta;
    private HashMap<String, Estado> estados;
    private Estado estadoNacional;
    private String nacional = "Nacional";
    private Grafico grafico;
    private RecursosService sRecursos;
    private GridBagConstraints gbc;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;

    public EstadosController(PrincipalController principalController) {
        this.principalController = principalController;
        this.estadosPanelTemplate = new EstadosPanelTemplate(this);

        this.sEntidad = EntidadService.getService();
        this.consulta = new ConsultasBD();
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        
        this.estados = consulta.obtenerPobEstado();
        this.estadoNacional = consulta.obtenerPobNacional();

        cargarJComboBox();

    }

    public void cargarJComboBox() {

        combo = estadosPanelTemplate.getCbEstados();
        combo.removeAllItems();

        List<Entidad> entidades = sEntidad.getEntidades();

        combo.addItem(this.nacional);
        for (Entidad e : entidades) {
            combo.addItem(e.getNomEntidad().trim());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == estadosPanelTemplate.getCbEstados()) {
            String opcionSeleccionada = ((String) estadosPanelTemplate.getCbEstados().getSelectedItem());
            if (opcionSeleccionada != null) {
                actulizarInfo(opcionSeleccionada);
            }
            
            if(opcionSeleccionada == nacional){
                actualizarInfoNacional();
            }
        }

    }

    public void actulizarInfo(String opcionSeleccionada) {

        if (opcionSeleccionada == null) {
            return;
        }
        Estado estado = estados.get(opcionSeleccionada);
        
        if(estado == null) return;
        
        System.out.println("estado = " + estado);
        
        
        estadosPanelTemplate.getlValorPobTotal().setText("" + estado.getPobTotal());
        estadosPanelTemplate.getlValorPobTotalF().setText("" + estado.getTotalMujeres());
        estadosPanelTemplate.getlValorPobTotalM().setText("" + estado.getTotalHombres());
        
        estadosPanelTemplate.getlValorPob0A14Total().setText("" + estado.getPob0A14Total());
        estadosPanelTemplate.getlValorPob0A14F().setText("" + estado.getPob0A14Mujeres());
        estadosPanelTemplate.getlValorPob0A14M().setText("" + estado.getPob0A14Hombres());
        
        estadosPanelTemplate.getlValorPob15A49Total().setText("" + estado.getPob15A49Total());
        estadosPanelTemplate.getlValorPob15A49F().setText("" + estado.getPob15A49Mujeres());
        estadosPanelTemplate.getlValorPob15A49M().setText("" + estado.getPob15A49Hombres());
        
        estadosPanelTemplate.getlValorPob15A49Total().setText("" + estado.getPob15A49Total());
        estadosPanelTemplate.getlValorPob15A49F().setText("" + estado.getPob15A49Mujeres());
        estadosPanelTemplate.getlValorPob15A49M().setText("" + estado.getPob15A49Hombres());
        
        estadosPanelTemplate.getlValorPob60YMasTotal().setText("" + estado.getPob60YMasTotal());
        estadosPanelTemplate.getlValorPob60YMasF().setText("" + estado.getPob60YMasMujeres());
        estadosPanelTemplate.getlValorPob60YMasM().setText("" + estado.getPob60YMasHombres());
        
        grafico = new Grafico(estado);
        
        this.principalController.cargarGrafico(grafico);
    }
    
    public void actualizarInfoNacional(){
        
        estadosPanelTemplate.getlValorPobTotal().setText("" + this.estadoNacional.getPobTotal());
        estadosPanelTemplate.getlValorPobTotalF().setText("" + this.estadoNacional.getTotalMujeres());
        estadosPanelTemplate.getlValorPobTotalM().setText("" + this.estadoNacional.getTotalHombres());
        
        estadosPanelTemplate.getlValorPob0A14Total().setText("" + this.estadoNacional.getPob0A14Total());
        estadosPanelTemplate.getlValorPob0A14F().setText("" + this.estadoNacional.getPob0A14Mujeres());
        estadosPanelTemplate.getlValorPob0A14M().setText("" + this.estadoNacional.getPob0A14Hombres());
        
        estadosPanelTemplate.getlValorPob15A49Total().setText("" + this.estadoNacional.getPob15A49Total());
        estadosPanelTemplate.getlValorPob15A49F().setText("" + this.estadoNacional.getPob15A49Mujeres());
        estadosPanelTemplate.getlValorPob15A49M().setText("" + this.estadoNacional.getPob15A49Hombres());
        
        estadosPanelTemplate.getlValorPob15A49Total().setText("" + this.estadoNacional.getPob15A49Total());
        estadosPanelTemplate.getlValorPob15A49F().setText("" + this.estadoNacional.getPob15A49Mujeres());
        estadosPanelTemplate.getlValorPob15A49M().setText("" + this.estadoNacional.getPob15A49Hombres());
        
        estadosPanelTemplate.getlValorPob60YMasTotal().setText("" + this.estadoNacional.getPob60YMasTotal());
        estadosPanelTemplate.getlValorPob60YMasF().setText("" + this.estadoNacional.getPob60YMasMujeres());
        estadosPanelTemplate.getlValorPob60YMasM().setText("" + this.estadoNacional.getPob60YMasHombres());
        
        grafico = new Grafico(this.estadoNacional);
        
        this.principalController.cargarGrafico(grafico);
        
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
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    public EstadosPanelTemplate getEstadosPanelTemplate() {
        return estadosPanelTemplate;
    }

}
