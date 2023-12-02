/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel.formularios;

import com.thrs.controllers.formularios.FormularioMunicipiosPanelController;
import com.thrs.controllers.formularios.FormularioPoblacionEdadPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class FormularioPoblacionEdadPanelTemplate extends JPanel {

    private FormularioPoblacionEdadPanelController formularioPoblacionEdadPanelController;
    private JLabel lInstrucciones, lEslogan, lTitulo, lIdEntidad,lIdMunicipio, lIdLocalidad;
    private JLabel lP0A2F,lP0A2M,lP3YMasF,lP3YMasM,lP5YMasF,lP5YMasM,lP12YMasF,lP12YMasM,lP15YMasF,lP15YMasM,
                    lP18YMasF,lP18YMasM, lP3A5F,lP3A5M,lP6A11F,lP6A11M,lP8A14F,lP8A14M,lP12A14F,lP12A14M,
                    lP15A17F,lP15A17M,lP18A24F,lP18A24M,lP15A49F,lP60YMasF,lP60YMasM;
    
    private JTextField tIdEntidad,tIdMunicipio, tIdLocalidad;
    private JTextField tP0A2F,tP0A2M,tP3YMasF,tP3YMasM,tP5YMasF,tP5YMasM,tP12YMasF,tP12YMasM,tP15YMasF,tP15YMasM,
                    tP18YMasF,tP18YMasM, tP3A5F,tP3A5M,tP6A11F,tP6A11M,tP8A14F,tP8A14M,tP12A14F,tP12A14M,
                    tP15A17F,tP15A17M,tP18A24F,tP18A24M,tP15A49F,tP60YMasF,tP60YMasM;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private GridBagConstraints gbc;
    private Color colorPrincipal, colorSecundario;
    private Color colorGris;
    private JScrollPane scroll;

    public FormularioPoblacionEdadPanelTemplate(FormularioPoblacionEdadPanelController formularioPoblacionEdadPanelController) {
        this.formularioPoblacionEdadPanelController = formularioPoblacionEdadPanelController;

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
        cargarBarra();
    }
    
    public void cargarBarra(){
        this.scroll = sObjGraficos.construirPanelBarra(
                this,
                10, 220, 580, 370,
                Color.WHITE,
                null
        );
        
        scroll.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10,
                        Color.WHITE,
                        Color.GRAY,
                        sRecursos.getColorGrisOscuro()
                )
        );
        
        scroll.getHorizontalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10,
                        Color.WHITE,
                        Color.GRAY,
                        sRecursos.getColorGrisOscuro()
                )
        );
        
    }

    public void crearContenidoPDatos() {
        // LABEL INSTRUCCIONES ----------------------------------------------------------------
        lInstrucciones = sObjGraficos.construirJLabel(
                "Datos Poblacion Edad",
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
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER,new Insets(10, 0, 10, 0), 0, 0);
        this.add(lEslogan, gbc);

        // LABEL ID ENTIDAD----------------------------------------------------------------
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
        gbc = sObjGraficos.getGridBagConstraints(1, 2, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lIdEntidad, gbc);

        // TEXTFIELD ID ENTIDAD----------------------------------------------------------------
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
        tIdEntidad.addFocusListener(formularioPoblacionEdadPanelController);
        //tIdEntidad.setEnabled(false);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 3, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tIdEntidad, gbc);
        
        // LABEL ID MUNICIPIO ----------------------------------------------------------------
        lIdMunicipio = sObjGraficos.construirJLabel(
                "Id Municipio:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 4, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lIdMunicipio, gbc);

        // TEXTFIELD ID MUNICIPIO ----------------------------------------------------------------
        tIdMunicipio = sObjGraficos.construirJTextField(
                "Id",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdMunicipio.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 5, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tIdMunicipio, gbc);

        // LABEL ID LOCALIDAD ----------------------------------------------------------------
        lIdLocalidad = sObjGraficos.construirJLabel(
                "Id Localidad:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 6, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lIdLocalidad, gbc);

        // TEXTFIELD ID LOCALIDAD ----------------------------------------------------------------
        tIdLocalidad = sObjGraficos.construirJTextField(
                "Id",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tIdLocalidad.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 7, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tIdLocalidad, gbc);
        
        //===============================================================DEMAS CAMPOS ===============================================================
        
        // LABEL ID lP0A2F ----------------------------------------------------------------
        lP0A2F = sObjGraficos.construirJLabel(
                "P0A2F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 8, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP0A2F, gbc);

        // TEXTFIELD tP0A2F ----------------------------------------------------------------
        tP0A2F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP0A2F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 9, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP0A2F, gbc);
        
        // LABEL ID lP0A2M ----------------------------------------------------------------
        lP0A2M = sObjGraficos.construirJLabel(
                "P0A2M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 10, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP0A2M, gbc);

        // TEXTFIELD tP0A2M ----------------------------------------------------------------
        tP0A2M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP0A2M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,11, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP0A2M, gbc);
        
        // LABEL ID lP3YMasF ----------------------------------------------------------------
        lP3YMasF = sObjGraficos.construirJLabel(
                "P3YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 12, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP3YMasF, gbc);

        // TEXTFIELD tP3YMasF ----------------------------------------------------------------
        tP3YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP3YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,13, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP3YMasF, gbc);
        
        // LABEL ID lP3YMasM ----------------------------------------------------------------
        lP3YMasM = sObjGraficos.construirJLabel(
                "P3YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 14, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP3YMasM, gbc);

        // TEXTFIELD tP3YMasM ----------------------------------------------------------------
        tP3YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP3YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,15, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP3YMasM, gbc);
        
        // LABEL ID lP5YMasF ----------------------------------------------------------------
        lP5YMasF = sObjGraficos.construirJLabel(
                "P5YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 16, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP5YMasF, gbc);

        // TEXTFIELD tP5YMasF ----------------------------------------------------------------
        tP5YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP5YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,17, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP5YMasF, gbc);
        
        // LABEL ID lP5YMasM ----------------------------------------------------------------
        lP5YMasM = sObjGraficos.construirJLabel(
                "P5YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 18, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP5YMasM, gbc);

        // TEXTFIELD tP5YMasM ----------------------------------------------------------------
        tP5YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP5YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,19, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP5YMasM, gbc);
        
        // LABEL ID lP12YMasF ----------------------------------------------------------------
        lP12YMasF = sObjGraficos.construirJLabel(
                "P12YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 20, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP12YMasF, gbc);

        // TEXTFIELD tP5YMasM ----------------------------------------------------------------
        tP12YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP12YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,21, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP12YMasF, gbc);
        
        // LABEL ID lP12YMasM ----------------------------------------------------------------
        lP12YMasM = sObjGraficos.construirJLabel(
                "P12YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 22, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP12YMasM, gbc);

        // TEXTFIELD tP5YMasM ----------------------------------------------------------------
        tP12YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP12YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,23, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP12YMasM, gbc);
        
        // LABEL ID lP15YMasF ----------------------------------------------------------------
        lP15YMasF = sObjGraficos.construirJLabel(
                "P15YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 24, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP15YMasF, gbc);

        // TEXTFIELD tP5YMasM ----------------------------------------------------------------
        tP15YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP15YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,25, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP15YMasF, gbc);
        
        // LABEL ID lP15YMasM ----------------------------------------------------------------
        lP15YMasM = sObjGraficos.construirJLabel(
                "P15YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 26, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP15YMasM, gbc);

        // TEXTFIELD tP5YMasM ----------------------------------------------------------------
        tP15YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP15YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,27, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP15YMasM, gbc);
        
        // LABEL ID lP18YMasF ----------------------------------------------------------------
        lP18YMasF = sObjGraficos.construirJLabel(
                "P18YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 28, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP18YMasF, gbc);

        // TEXTFIELD tP18YMasF ----------------------------------------------------------------
        tP18YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP18YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,29, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP18YMasF, gbc);
        
        // LABEL ID lP18YMasM ----------------------------------------------------------------
        lP18YMasM = sObjGraficos.construirJLabel(
                "P18YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 30, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP18YMasM, gbc);

        // TEXTFIELD tP18YMasM ----------------------------------------------------------------
        tP18YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP18YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,31, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP18YMasM, gbc);
        
        // LABEL ID lP3A5F ----------------------------------------------------------------
        lP3A5F = sObjGraficos.construirJLabel(
                "P3A5F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 32, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP3A5F, gbc);

        // TEXTFIELD tP3A5F ----------------------------------------------------------------
        tP3A5F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP3A5F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,33, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP3A5F, gbc);
        
        // LABEL ID lP3A5M ----------------------------------------------------------------
        lP3A5M = sObjGraficos.construirJLabel(
                "P3A5M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 34, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP3A5M, gbc);

        // TEXTFIELD tP3A5F ----------------------------------------------------------------
        tP3A5M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP3A5M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,35, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP3A5M, gbc);
        
        // LABEL ID lP6A11F ----------------------------------------------------------------
        lP6A11F = sObjGraficos.construirJLabel(
                "P6A11F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 36, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP6A11F, gbc);

        // TEXTFIELD tP6A11F ----------------------------------------------------------------
        tP6A11F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP6A11F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,37, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP6A11F, gbc);
        
        // LABEL ID lP6A11M ----------------------------------------------------------------
        lP6A11M = sObjGraficos.construirJLabel(
                "P6A11M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 38, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP6A11M, gbc);

        // TEXTFIELD tP6A11M ----------------------------------------------------------------
        tP6A11M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP6A11M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,39, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP6A11M, gbc);
        
        // LABEL ID lP8A14F ----------------------------------------------------------------
        lP8A14F = sObjGraficos.construirJLabel(
                "P8A14F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 40, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP8A14F, gbc);

        // TEXTFIELD tP8A14F ----------------------------------------------------------------
        tP8A14F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP8A14F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,41, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP8A14F, gbc);
        
        // LABEL ID lP8A14M ----------------------------------------------------------------
        lP8A14M = sObjGraficos.construirJLabel(
                "P8A14M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 42, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP8A14M, gbc);

        // TEXTFIELD tP8A14M ----------------------------------------------------------------
        tP8A14M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP8A14M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,43, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP8A14M, gbc);
        
        // LABEL ID lP12A14F ----------------------------------------------------------------
        lP12A14F = sObjGraficos.construirJLabel(
                "P12A14F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 44, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP12A14F, gbc);

        // TEXTFIELD tP12A14F ----------------------------------------------------------------
        tP12A14F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP12A14F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,45, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP12A14F, gbc);
        
        // LABEL ID lP12A14M ----------------------------------------------------------------
        lP12A14M = sObjGraficos.construirJLabel(
                "P12A14M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 46, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP12A14M, gbc);

        // TEXTFIELD tP12A14M ----------------------------------------------------------------
        tP12A14M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP12A14M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,47, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP12A14M, gbc);
        
        // LABEL ID lP15A17F ----------------------------------------------------------------
        lP15A17F = sObjGraficos.construirJLabel(
                "P15A17F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 48, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP15A17F, gbc);

        // TEXTFIELD tP15A17F ----------------------------------------------------------------
        tP15A17F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP15A17F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,49, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP15A17F, gbc);
        
        // LABEL ID lP15A17M ----------------------------------------------------------------
        lP15A17M = sObjGraficos.construirJLabel(
                "P15A17M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 50, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP15A17M, gbc);

        // TEXTFIELD tP15A17M ----------------------------------------------------------------
        tP15A17M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP15A17M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,51, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP15A17M, gbc);
        
        // LABEL ID lP18A24F ----------------------------------------------------------------
        lP18A24F = sObjGraficos.construirJLabel(
                "P18A24F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 52, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP18A24F, gbc);

        // TEXTFIELD tP18A24F ----------------------------------------------------------------
        tP18A24F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP18A24F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,53, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP18A24F, gbc);
        
        // LABEL ID lP18A24M ----------------------------------------------------------------
        lP18A24M = sObjGraficos.construirJLabel(
                "P18A24M:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 54, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP18A24M, gbc);

        // TEXTFIELD tP18A24M ----------------------------------------------------------------
        tP18A24M = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP18A24M.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,55, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP18A24M, gbc);
        
        // LABEL ID lP15A49F ----------------------------------------------------------------
        lP15A49F = sObjGraficos.construirJLabel(
                "P15A49F:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 56, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP15A49F, gbc);

        // TEXTFIELD tP15A49F ----------------------------------------------------------------
        tP15A49F = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP15A49F.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,57, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP15A49F, gbc);
        
        // LABEL ID lP60YMasF ----------------------------------------------------------------
        lP60YMasF = sObjGraficos.construirJLabel(
                "P60YMasF:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 58, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP60YMasF, gbc);

        // TEXTFIELD tP60YMasF ----------------------------------------------------------------
        tP60YMasF = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP60YMasF.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,59, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP60YMasF, gbc);
        
        
        // LABEL ID lP60YMasF ----------------------------------------------------------------
        lP60YMasM = sObjGraficos.construirJLabel(
                "P60YMasM:",
                20, 140, 160, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "l"
        );
        //gbc = grid(0, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1, 60, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(lP60YMasM, gbc);

        // TEXTFIELD tP60YMasF ----------------------------------------------------------------
        tP60YMasM = sObjGraficos.construirJTextField(
                "Cantidad",
                30, 300, 180, 30,
                sRecursos.getFontLigera(),
                colorGris,
                sRecursos.getColorGrisOscuro(),
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        tP60YMasM.addFocusListener(formularioPoblacionEdadPanelController);
        //gbc = grid(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 0, 0);
        gbc = sObjGraficos.getGridBagConstraints(1,61, 3, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 0, 10, 0), 0, 0);
        this.add(tP60YMasM, gbc);
        
    }

    public FormularioPoblacionEdadPanelController getFormularioPoblacionEdadPanelController() {
        return formularioPoblacionEdadPanelController;
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

    public JLabel getlIdLocalidad() {
        return lIdLocalidad;
    }

    public JTextField gettIdEntidad() {
        return tIdEntidad;
    }

    public JTextField gettIdLocalidad() {
        return tIdLocalidad;
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

    public JLabel getlIdMunicipio() {
        return lIdMunicipio;
    }

    public JTextField gettIdMunicipio() {
        return tIdMunicipio;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public JLabel getlP0A2F() {
        return lP0A2F;
    }

    public void setlP0A2F(JLabel lP0A2F) {
        this.lP0A2F = lP0A2F;
    }

    public JLabel getlP0A2M() {
        return lP0A2M;
    }

    public void setlP0A2M(JLabel lP0A2M) {
        this.lP0A2M = lP0A2M;
    }

    public JLabel getlP3YMasF() {
        return lP3YMasF;
    }

    public void setlP3YMasF(JLabel lP3YMasF) {
        this.lP3YMasF = lP3YMasF;
    }

    public JLabel getlP3YMasM() {
        return lP3YMasM;
    }

    public void setlP3YMasM(JLabel lP3YMasM) {
        this.lP3YMasM = lP3YMasM;
    }

    public JLabel getlP5YMasF() {
        return lP5YMasF;
    }

    public void setlP5YMasF(JLabel lP5YMasF) {
        this.lP5YMasF = lP5YMasF;
    }

    public JLabel getlP5YMasM() {
        return lP5YMasM;
    }

    public void setlP5YMasM(JLabel lP5YMasM) {
        this.lP5YMasM = lP5YMasM;
    }

    public JLabel getlP12YMasF() {
        return lP12YMasF;
    }

    public void setlP12YMasF(JLabel lP12YMasF) {
        this.lP12YMasF = lP12YMasF;
    }

    public JLabel getlP12YMasM() {
        return lP12YMasM;
    }

    public void setlP12YMasM(JLabel lP12YMasM) {
        this.lP12YMasM = lP12YMasM;
    }

    public JLabel getlP15YMasF() {
        return lP15YMasF;
    }

    public void setlP15YMasF(JLabel lP15YMasF) {
        this.lP15YMasF = lP15YMasF;
    }

    public JLabel getlP15YMasM() {
        return lP15YMasM;
    }

    public void setlP15YMasM(JLabel lP15YMasM) {
        this.lP15YMasM = lP15YMasM;
    }

    public JLabel getlP18YMasF() {
        return lP18YMasF;
    }

    public void setlP18YMasF(JLabel lP18YMasF) {
        this.lP18YMasF = lP18YMasF;
    }

    public JLabel getlP18YMasM() {
        return lP18YMasM;
    }

    public void setlP18YMasM(JLabel lP18YMasM) {
        this.lP18YMasM = lP18YMasM;
    }

    public JLabel getlP3A5F() {
        return lP3A5F;
    }

    public void setlP3A5F(JLabel lP3A5F) {
        this.lP3A5F = lP3A5F;
    }

    public JLabel getlP3A5M() {
        return lP3A5M;
    }

    public void setlP3A5M(JLabel lP3A5M) {
        this.lP3A5M = lP3A5M;
    }

    public JLabel getlP6A11F() {
        return lP6A11F;
    }

    public void setlP6A11F(JLabel lP6A11F) {
        this.lP6A11F = lP6A11F;
    }

    public JLabel getlP6A11M() {
        return lP6A11M;
    }

    public void setlP6A11M(JLabel lP6A11M) {
        this.lP6A11M = lP6A11M;
    }

    public JLabel getlP8A14F() {
        return lP8A14F;
    }

    public void setlP8A14F(JLabel lP8A14F) {
        this.lP8A14F = lP8A14F;
    }

    public JLabel getlP8A14M() {
        return lP8A14M;
    }

    public void setlP8A14M(JLabel lP8A14M) {
        this.lP8A14M = lP8A14M;
    }

    public JLabel getlP12A14F() {
        return lP12A14F;
    }

    public void setlP12A14F(JLabel lP12A14F) {
        this.lP12A14F = lP12A14F;
    }

    public JLabel getlP12A14M() {
        return lP12A14M;
    }

    public void setlP12A14M(JLabel lP12A14M) {
        this.lP12A14M = lP12A14M;
    }

    public JLabel getlP15A17F() {
        return lP15A17F;
    }

    public void setlP15A17F(JLabel lP15A17F) {
        this.lP15A17F = lP15A17F;
    }

    public JLabel getlP15A17M() {
        return lP15A17M;
    }

    public void setlP15A17M(JLabel lP15A17M) {
        this.lP15A17M = lP15A17M;
    }

    public JLabel getlP18A24F() {
        return lP18A24F;
    }

    public void setlP18A24F(JLabel lP18A24F) {
        this.lP18A24F = lP18A24F;
    }

    public JLabel getlP18A24M() {
        return lP18A24M;
    }

    public void setlP18A24M(JLabel lP18A24M) {
        this.lP18A24M = lP18A24M;
    }

    public JLabel getlP15A49F() {
        return lP15A49F;
    }

    public void setlP15A49F(JLabel lP15A49F) {
        this.lP15A49F = lP15A49F;
    }

    public JLabel getlP60YMasF() {
        return lP60YMasF;
    }

    public void setlP60YMasF(JLabel lP60YMasF) {
        this.lP60YMasF = lP60YMasF;
    }

    public JLabel getlP60YMasM() {
        return lP60YMasM;
    }

    public void setlP60YMasM(JLabel lP60YMasM) {
        this.lP60YMasM = lP60YMasM;
    }

    public JTextField gettP0A2F() {
        return tP0A2F;
    }

    public void settP0A2F(JTextField tP0A2F) {
        this.tP0A2F = tP0A2F;
    }

    public JTextField gettP0A2M() {
        return tP0A2M;
    }

    public void settP0A2M(JTextField tP0A2M) {
        this.tP0A2M = tP0A2M;
    }

    public JTextField gettP3YMasF() {
        return tP3YMasF;
    }

    public void settP3YMasF(JTextField tP3YMasF) {
        this.tP3YMasF = tP3YMasF;
    }

    public JTextField gettP3YMasM() {
        return tP3YMasM;
    }

    public void settP3YMasM(JTextField tP3YMasM) {
        this.tP3YMasM = tP3YMasM;
    }

    public JTextField gettP5YMasF() {
        return tP5YMasF;
    }

    public void settP5YMasF(JTextField tP5YMasF) {
        this.tP5YMasF = tP5YMasF;
    }

    public JTextField gettP5YMasM() {
        return tP5YMasM;
    }

    public void settP5YMasM(JTextField tP5YMasM) {
        this.tP5YMasM = tP5YMasM;
    }

    public JTextField gettP12YMasF() {
        return tP12YMasF;
    }

    public void settP12YMasF(JTextField tP12YMasF) {
        this.tP12YMasF = tP12YMasF;
    }

    public JTextField gettP12YMasM() {
        return tP12YMasM;
    }

    public void settP12YMasM(JTextField tP12YMasM) {
        this.tP12YMasM = tP12YMasM;
    }

    public JTextField gettP15YMasF() {
        return tP15YMasF;
    }

    public void settP15YMasF(JTextField tP15YMasF) {
        this.tP15YMasF = tP15YMasF;
    }

    public JTextField gettP15YMasM() {
        return tP15YMasM;
    }

    public void settP15YMasM(JTextField tP15YMasM) {
        this.tP15YMasM = tP15YMasM;
    }

    public JTextField gettP18YMasF() {
        return tP18YMasF;
    }

    public void settP18YMasF(JTextField tP18YMasF) {
        this.tP18YMasF = tP18YMasF;
    }

    public JTextField gettP18YMasM() {
        return tP18YMasM;
    }

    public void settP18YMasM(JTextField tP18YMasM) {
        this.tP18YMasM = tP18YMasM;
    }

    public JTextField gettP3A5F() {
        return tP3A5F;
    }

    public void settP3A5F(JTextField tP3A5F) {
        this.tP3A5F = tP3A5F;
    }

    public JTextField gettP3A5M() {
        return tP3A5M;
    }

    public void settP3A5M(JTextField tP3A5M) {
        this.tP3A5M = tP3A5M;
    }

    public JTextField gettP6A11F() {
        return tP6A11F;
    }

    public void settP6A11F(JTextField tP6A11F) {
        this.tP6A11F = tP6A11F;
    }

    public JTextField gettP6A11M() {
        return tP6A11M;
    }

    public void settP6A11M(JTextField tP6A11M) {
        this.tP6A11M = tP6A11M;
    }

    public JTextField gettP8A14F() {
        return tP8A14F;
    }

    public void settP8A14F(JTextField tP8A14F) {
        this.tP8A14F = tP8A14F;
    }

    public JTextField gettP8A14M() {
        return tP8A14M;
    }

    public void settP8A14M(JTextField tP8A14M) {
        this.tP8A14M = tP8A14M;
    }

    public JTextField gettP12A14F() {
        return tP12A14F;
    }

    public void settP12A14F(JTextField tP12A14F) {
        this.tP12A14F = tP12A14F;
    }

    public JTextField gettP12A14M() {
        return tP12A14M;
    }

    public void settP12A14M(JTextField tP12A14M) {
        this.tP12A14M = tP12A14M;
    }

    public JTextField gettP15A17F() {
        return tP15A17F;
    }

    public void settP15A17F(JTextField tP15A17F) {
        this.tP15A17F = tP15A17F;
    }

    public JTextField gettP15A17M() {
        return tP15A17M;
    }

    public void settP15A17M(JTextField tP15A17M) {
        this.tP15A17M = tP15A17M;
    }

    public JTextField gettP18A24F() {
        return tP18A24F;
    }

    public void settP18A24F(JTextField tP18A24F) {
        this.tP18A24F = tP18A24F;
    }

    public JTextField gettP18A24M() {
        return tP18A24M;
    }

    public void settP18A24M(JTextField tP18A24M) {
        this.tP18A24M = tP18A24M;
    }

    public JTextField gettP15A49F() {
        return tP15A49F;
    }

    public void settP15A49F(JTextField tP15A49F) {
        this.tP15A49F = tP15A49F;
    }

    public JTextField gettP60YMasF() {
        return tP60YMasF;
    }

    public void settP60YMasF(JTextField tP60YMasF) {
        this.tP60YMasF = tP60YMasF;
    }

    public JTextField gettP60YMasM() {
        return tP60YMasM;
    }

    public void settP60YMasM(JTextField tP60YMasM) {
        this.tP60YMasM = tP60YMasM;
    }

    public GraficosAvanzadosService getsGraficosAvanzados() {
        return sGraficosAvanzados;
    }

    public void setsGraficosAvanzados(GraficosAvanzadosService sGraficosAvanzados) {
        this.sGraficosAvanzados = sGraficosAvanzados;
    }
    
    

}
