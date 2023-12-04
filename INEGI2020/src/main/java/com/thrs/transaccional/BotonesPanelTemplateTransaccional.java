/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional;

import com.thrs.vistas.panel.*;
import com.thrs.controllers.BotonesPanelController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class BotonesPanelTemplateTransaccional extends JPanel {

    private BotonesPanelControllerTransaccional botonesPanelControllerTransaccional;
    private JButton btnCreate, btnDelete, btnUpdate, btnClean, btnRegresar, btnRollback, btnCommit;
    private JLabel lTitulo;
    private GridBagConstraints gbc;

    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private String comando;
    private JComboBox<String> cbVentanas;
    private ImageIcon iFondo, iLogo, iAbajo, iPunto1, iPunto2, iDimAux;
    private JButton bComboBox;
    private JPanel pArriba, pAbajo;

    public BotonesPanelTemplateTransaccional(BotonesPanelControllerTransaccional botonesPanelControllerTransaccional, String comando) {
        this.botonesPanelControllerTransaccional = botonesPanelControllerTransaccional;
        this.comando = comando;
        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();
        this.setBackground(sRecursos.getColorGrisClaro());
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        componentes();
        this.setVisible(true);
    }

    private void componentes() {
        crearContenidoPOpciones();
        crearCombo();
    }
    
    public void crearCombo(){
    //getClass().getResource("/img/abajo.png")
        iAbajo = new ImageIcon(getClass().getResource("/img/abajo.png"));

        cbVentanas = sObjGraficos.construirJComboBox(
                "Opciones a Elegir",
                500 / 2, 210, 220, 100,
                sRecursos.getFontLigera(),
                Color.WHITE,
                Color.WHITE,
                "c"
        );
        ImageIcon iDimAux = new ImageIcon(
                iAbajo.getImage()
                        .getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING)
        );
        bComboBox = ObjGraficosService.getService().construirJButton(
                null,
                0, 100, 0, 0,
                sRecursos.getCMano(),
                iDimAux,
                null, null, null,
                sRecursos.getBLateralAzul(),
                "c",
                true
        );
        cbVentanas.setUI(
                GraficosAvanzadosService.getService()
                        .devolverJComboBoxPersonalizado(
                                bComboBox,
                                null,
                                sRecursos.getColorPrincipal(),
                                sRecursos.getColorPrincipal(),
                                sRecursos.getColorPrincipal(),
                                true
                        )
        );
        cbVentanas.addActionListener(botonesPanelControllerTransaccional);
        this.add(cbVentanas);

        cbVentanas.setForeground(Color.WHITE);

        gbc = sObjGraficos.getGridBagConstraints(3, 2, 3, 1, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(5, 10, 5, 10), 40, 10);
        this.add(cbVentanas, gbc);
    }

    public void crearContenidoPOpciones() {
        System.out.println("Entramos al metodo de los botones: " + sRecursos == null);
        // LABEL TITULO--------------------------------------------------------------------
//        lTitulo = sObjGraficos.construirJLabel(
//                "Edición de " + this.comando,
//                20, 10, 200, 30,
//                null, null,
//                this.sRecursos.getFontTitulo(),
//                null,
//                sRecursos.getColorGrisOscuro(),
//                null,
//                "c"
//        );
//        gbc = sObjGraficos.getGridBagConstraints(0, 0, 7, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
//        this.add(lTitulo, gbc);

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

        btnCreate.addMouseListener(botonesPanelControllerTransaccional);
        btnCreate.addActionListener(botonesPanelControllerTransaccional);
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
        btnUpdate.addMouseListener(botonesPanelControllerTransaccional);
        btnUpdate.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
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
        btnDelete.addMouseListener(botonesPanelControllerTransaccional);
        btnDelete.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
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
        btnClean.addMouseListener(botonesPanelControllerTransaccional);
        btnClean.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnClean, gbc);
        
        // BOTÓN ROLLBACK--------------------------------------------------------------------
        btnRollback = sObjGraficos.construirJButton(
                "Rollback",
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
        btnRollback.addMouseListener(botonesPanelControllerTransaccional);
        btnRollback.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(3, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnRollback, gbc);
        
        // BOTÓN COMIT--------------------------------------------------------------------
        btnCommit = sObjGraficos.construirJButton(
                "Commit",
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
        btnCommit.addMouseListener(botonesPanelControllerTransaccional);
        btnCommit.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(4, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnCommit, gbc);

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
        btnRegresar.addMouseListener(botonesPanelControllerTransaccional);
        btnRegresar.addActionListener(botonesPanelControllerTransaccional);
        gbc = sObjGraficos.getGridBagConstraints(5, 1, 1, 1, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10), 40, 10);
        this.add(btnRegresar, gbc);

    }

    public BotonesPanelControllerTransaccional getBotonesPanelControllerTrasaccional() {
        return botonesPanelControllerTransaccional;
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

    public JButton getBtnRollback() {
        return btnRollback;
    }

    public JButton getBtnCommit() {
        return btnCommit;
    }

    public JComboBox<String> getCbVentanas() {
        return cbVentanas;
    }
    
    
}