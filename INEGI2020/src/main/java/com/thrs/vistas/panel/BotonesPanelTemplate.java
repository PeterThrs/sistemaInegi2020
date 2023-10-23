/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel;

import com.thrs.controllers.BotonesPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class BotonesPanelTemplate extends JPanel {

    private BotonesPanelController botonesPanelController;
    private JButton btnCreate, btnDelete, btnUpdate, btnClean, btnRegresar;
    private JLabel lTitulo;
    private GridBagConstraints gbc;

    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private String comando;

    public BotonesPanelTemplate(BotonesPanelController botonesPanelController, String comando) {
        this.botonesPanelController = botonesPanelController;
        this.comando = comando;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.setBackground(sRecursos.getColorGrisClaro());
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        componentes();
    }

    private void componentes() {
        crearContenidoPOpciones();
    }

    public void crearContenidoPOpciones() {
        System.out.println("Entramos al metodo de los botones: " + sRecursos == null);
        // LABEL TITULO--------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Edición de " + this.comando,
                20, 10, 200, 30,
                null, null,
                this.sRecursos.getFontTitulo(),
                null,
                sRecursos.getColorGrisOscuro(),
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 7, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(lTitulo, gbc);

        // BOTÓN INSERTAR--------------------------------------------------------------------
        btnCreate = sObjGraficos.construirJButton(
                "Insertar",
                160, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );

        btnCreate.addMouseListener(botonesPanelController);
        btnCreate.addActionListener(botonesPanelController);
        gbc = sObjGraficos.getGridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnCreate, gbc);

        // BOTÓN MODIFICAR--------------------------------------------------------------------
        btnUpdate = sObjGraficos.construirJButton(
                "Modificar",
                300, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnUpdate.addMouseListener(botonesPanelController);
        btnUpdate.addActionListener(botonesPanelController);
        gbc = sObjGraficos.getGridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnUpdate, gbc);

        // BOTÓN ELIMINAR--------------------------------------------------------------------
        btnDelete = sObjGraficos.construirJButton(
                "Eliminar",
                440, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnDelete.addMouseListener(botonesPanelController);
        btnDelete.addActionListener(botonesPanelController);
        gbc = sObjGraficos.getGridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnDelete, gbc);

        // BOTÓN LIMPIAR--------------------------------------------------------------------
        btnClean = sObjGraficos.construirJButton(
                "Limpiar",
                440, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnClean.addMouseListener(botonesPanelController);
        btnClean.addActionListener(botonesPanelController);
        gbc = sObjGraficos.getGridBagConstraints(4, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnClean, gbc);

        // BOTÓN REGRESAR--------------------------------------------------------------------
        btnRegresar = sObjGraficos.construirJButton(
                "Regresar",
                440, 145, 120, 35,
                sRecursos.getCMano(),
                null,
                sRecursos.getFontMediana(),
                sRecursos.getColorPrincipal(),
                Color.WHITE,
                null,
                "c",
                true
        );
        btnRegresar.addMouseListener(botonesPanelController);
        btnRegresar.addActionListener(botonesPanelController);
        gbc = sObjGraficos.getGridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnRegresar, gbc);

    }

    public BotonesPanelController getBotonesPanelController() {
        return botonesPanelController;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnClean() {
        return btnClean;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JLabel getlTitulo() {
        return lTitulo;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }
}