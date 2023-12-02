/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel.formularios;

import com.thrs.controllers.formularios.FormularioEntidadesPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FormularioEntidadesPanelTemplate extends JPanel {

    private FormularioEntidadesPanelController formularioEntidadesPanelController;
    private JLabel lInstrucciones, lEslogan, lTitulo, lIdEntidad, lNomEntidad;
    private JTextField tIdEntidad, tNomEntidad;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private GridBagConstraints gbc;
    private Color colorPrincipal, colorSecundario;
    private Color colorGris;

    public FormularioEntidadesPanelTemplate(FormularioEntidadesPanelController formularioEntidadesPanelController) {
        this.formularioEntidadesPanelController = formularioEntidadesPanelController;

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.colorPrincipal = new Color(39, 54, 77);
        this.colorSecundario = new Color(240, 235, 216);
        this.colorGris = new Color(235, 235, 235);
        //this.setBackground(sRecursos.getColorGrisClaro());
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        componentes();
        this.setVisible(true);
    }

    private void componentes() {

        crearContenidoPDatos();
    }

    public void crearContenidoPDatos() {
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
                "Datos de la Entidad",
                20, 10, 120, 50,
                null, null,
                sRecursos.getFontTitulo(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        //gbc = grid(0, 0, 2, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(lInstrucciones, gbc);

        // LABEL ESLOGAN ----------------------------------------------------------------
        lEslogan = sObjGraficos.construirJLabel(
                "Administración de datos",
                20, 50, 180, 90,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        //gbc = grid(0, 1, 2, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(lEslogan, gbc);

        // LABEL ID ----------------------------------------------------------------
        lIdEntidad = sObjGraficos.construirJLabel(
                "Id Entidad:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(lIdEntidad, gbc);

        // TEXTFIELD ID ----------------------------------------------------------------
        tIdEntidad = sObjGraficos.construirJTextField(
                "Id",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdEntidad.addFocusListener(formularioEntidadesPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 3, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(tIdEntidad, gbc);

        // LABEL NOMBRE ----------------------------------------------------------------
        lNomEntidad = sObjGraficos.construirJLabel(
                "Nombre de la Entidad:",
                20, 180, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(lNomEntidad, gbc);

        // TEXTFIELD NOMBRE ----------------------------------------------------------------
        tNomEntidad = sObjGraficos.construirJTextField(
                "Nombre",
                30, 215, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tNomEntidad.addFocusListener(formularioEntidadesPanelController);
        //gbc = grid(1, 3, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        this.add(tNomEntidad, gbc);

    }

    public FormularioEntidadesPanelController getFormularioEntidadesPanelController() {
        return formularioEntidadesPanelController;
    }

    public JLabel getlInstrucciones() {
        return lInstrucciones;
    }

    public JLabel getlEslogan() {
        return lEslogan;
    }

    public JLabel getlTitulo() {
        return lTitulo;
    }

    public JLabel getlIdEntidad() {
        return lIdEntidad;
    }

    public JLabel getlNomEntidad() {
        return lNomEntidad;
    }

    public JTextField gettIdEntidad() {
        return tIdEntidad;
    }

    public JTextField gettNomEntidad() {
        return tNomEntidad;
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }
    
    public Color getColorGris() {
        return colorGris;
    }

}
