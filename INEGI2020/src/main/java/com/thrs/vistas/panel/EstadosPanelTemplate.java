/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas.panel;

import com.thrs.controllers.formularios.EstadosController;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class EstadosPanelTemplate extends JPanel {

    private JComboBox<String> estados;
    private JLabel lPobTotal, lPobTotalF, lPobTotalM,
            lPob0A14Total, lPob0A14F, lPob0A14M,
            lPob15A49Total, lPob15A49F, lPob15A49M,
            lPob60YMasTotal, lPob60YMasF, lPob60YMasM;
    private JLabel lValorPobTotal, lValorPobTotalF, lValorPobTotalM,
            lValorPob0A14Total, lValorPob0A14F, lValorPob0A14M,
            lValorPob15A49Total, lValorPob15A49F, lValorPob15A49M,
            lValorPob60YMasTotal, lValorPob60YMasF, lValorPob60YMasM;
    private JTextField tIdEntidad, tNomEntidad;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private GridBagConstraints gbc;
    private EstadosController estadosController;
    private JComboBox<String> cbEstados;
    private ImageIcon iFondo, iLogo, iAbajo, iPunto1, iPunto2, iDimAux;
    private JButton bComboBox;
    private JPanel pArriba, pAbajo;
    private JScrollPane scroll;

    public EstadosPanelTemplate(EstadosController estadosController) {
        this.estadosController = estadosController;

        this.sObjGraficos = ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
        this.sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        this.setBackground(sRecursos.getColorPrincipalClaro());
        this.gbc = new GridBagConstraints();

        componentes();
        this.setVisible(true);

    }

    public void componentes() {
        paneles();
        crearJComboBoxes();
        cargarBarra();
        etiquetas();

    }

    public void paneles() {

        //Creamos el panel izquierdo y lo agregamos a la ventana
        pArriba = new JPanel();
        pArriba.setBackground(Color.WHITE);
        pArriba.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 0.1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pArriba.setLayout(new GridBagLayout());
        this.add(pArriba, gbc);

        //Creamos el panel izquierdo y lo agregamos a la ventana
        pAbajo = new JPanel();
        pAbajo.setBackground(Color.WHITE);
        pAbajo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 0.9, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        pAbajo.setLayout(new GridBagLayout());
        //this.add(pAbajo, gbc);

    }

    public void cargarBarra() {
        this.scroll = sObjGraficos.construirPanelBarra(
                this.pAbajo,
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
        gbc = sObjGraficos.getGridBagConstraints(0, 1, 1, 1, 1, 0.9, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 0, 0);
        this.add(scroll, gbc);

    }

    public void crearJComboBoxes() {
        //getClass().getResource("/img/abajo.png")
        iAbajo = new ImageIcon(getClass().getResource("/img/abajo.png"));

        // Nombres de los estados en el orden deseado
        String[] estados = {
            "Nacional", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Coahuila de Zaragoza",
            "Colima", "Chiapas", "Chihuahua", "Ciudad de México", "Durango", "Guanajuato", "Guerrero",
            "Hidalgo", "Jalisco", "México", "Michoacán de Ocampo", "Morelos", "Nayarit", "Nuevo León",
            "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora",
            "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatán", "Zacatecas"
        };

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(estados);

        // Crear un modelo de lista con los estados
        cbEstados = sObjGraficos.construirJComboBox(
                "Selecciona una entidad",
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
        cbEstados.setUI(
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
        cbEstados.addActionListener(estadosController);
        this.add(cbEstados);

        cbEstados.setForeground(Color.WHITE);
        cbEstados.setModel(model);

        gbc = sObjGraficos.getGridBagConstraints(0, 1, 2, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(5, 0, 10, 0), 0, 0);
        this.pArriba.add(cbEstados, gbc);
    }

    private void etiquetas() {

        //Pob total =============================================================================================================================================================================
        lPobTotal = sObjGraficos.construirJLabel(
                "Poblacion Total: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 20), 0, 0);
        this.pAbajo.add(lPobTotal, gbc);

        lValorPobTotal = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 20), 0, 0);
        this.pAbajo.add(lValorPobTotal, gbc);

        //Pob total femenina =============================================================================================================================================================================
        lPobTotalF = sObjGraficos.construirJLabel(
                "Total Mujeres: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "c"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 20), 0, 0);
        this.pAbajo.add(lPobTotalF, gbc);

        lValorPobTotalF = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 20), 0, 0);
        this.pAbajo.add(lValorPobTotalF, gbc);

        //Pob total masculina =============================================================================================================================================================================
        lPobTotalM = sObjGraficos.construirJLabel(
                "Total Hombres: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 20), 0, 0);
        this.pAbajo.add(lPobTotalM, gbc);

        lValorPobTotalM = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPobTotalM, gbc);

        //Pob 0-14 total =============================================================================================================================================================================
        lPob0A14Total = sObjGraficos.construirJLabel(
                "Poblacion Total 0-14 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob0A14Total, gbc);

        lValorPob0A14Total = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob0A14Total, gbc);

        //Pob 0-14 femenino =============================================================================================================================================================================
        lPob0A14F = sObjGraficos.construirJLabel(
                "Total Mujeres 0-14 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob0A14F, gbc);

        lValorPob0A14F = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob0A14F, gbc);

        //Pob 0-14 masculino =============================================================================================================================================================================
        lPob0A14M = sObjGraficos.construirJLabel(
                "Total Hombres 0-14 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob0A14M, gbc);

        lValorPob0A14M = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob0A14M, gbc);

        //Pob 15 A 49 total =============================================================================================================================================================================
        lPob15A49Total = sObjGraficos.construirJLabel(
                "Poblacion Total 15-49 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob15A49Total, gbc);

        lValorPob15A49Total = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob15A49Total, gbc);

        //Pob 15 A 49 femenina =============================================================================================================================================================================
        lPob15A49F = sObjGraficos.construirJLabel(
                "Total Mujeres 15-49 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob15A49F, gbc);

        lValorPob15A49F = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob15A49F, gbc);

        //Pob 15 A 49 masculina =============================================================================================================================================================================
        lPob15A49M = sObjGraficos.construirJLabel(
                "Total Hombres 15-49 años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob15A49M, gbc);

        lValorPob15A49M = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob15A49M, gbc);

        //Pob 60 Y MAS total =============================================================================================================================================================================
        lPob60YMasTotal = sObjGraficos.construirJLabel(
                "Poblacion Total 60 y + años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob60YMasTotal, gbc);

        lValorPob60YMasTotal = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob60YMasTotal, gbc);

        //Pob 60 Y MAS total =============================================================================================================================================================================
        lPob60YMasF = sObjGraficos.construirJLabel(
                "Total Mujeres 60 y + años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 10), 0, 0);
        this.pAbajo.add(lPob60YMasF, gbc);

        lValorPob60YMasF = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 0), 0, 0);
        this.pAbajo.add(lValorPob60YMasF, gbc);

        //Pob 60 Y MAS total =============================================================================================================================================================================
        lPob60YMasM = sObjGraficos.construirJLabel(
                "Total Hombres 60 y + años: ",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(0, 13, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 40), 0, 0);
        this.pAbajo.add(lPob60YMasM, gbc);

        lValorPob60YMasM = sObjGraficos.construirJLabel(
                "00",
                20, 10, 200, 30,
                null, null,
                sRecursos.getFontLigera(),
                null,
                sRecursos.getColorPrincipalOscuro(),
                null,
                "r"
        );
        gbc = sObjGraficos.getGridBagConstraints(1, 13, 1, 1, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST, new Insets(15, 0, 0, 60), 0, 0);
        this.pAbajo.add(lValorPob60YMasM, gbc);

    }

    public JComboBox<String> getEstados() {
        return estados;
    }

    public void setEstados(JComboBox<String> estados) {
        this.estados = estados;
    }

    public JLabel getlPobTotal() {
        return lPobTotal;
    }

    public void setlPobTotal(JLabel lPobTotal) {
        this.lPobTotal = lPobTotal;
    }

    public JLabel getlPobTotalF() {
        return lPobTotalF;
    }

    public void setlPobTotalF(JLabel lPobTotalF) {
        this.lPobTotalF = lPobTotalF;
    }

    public JLabel getlPobTotalM() {
        return lPobTotalM;
    }

    public void setlPobTotalM(JLabel lPobTotalM) {
        this.lPobTotalM = lPobTotalM;
    }

    public JLabel getlPob0A14Total() {
        return lPob0A14Total;
    }

    public void setlPob0A14Total(JLabel lPob0A14Total) {
        this.lPob0A14Total = lPob0A14Total;
    }

    public JLabel getlPob0A14F() {
        return lPob0A14F;
    }

    public void setlPob0A14F(JLabel lPob0A14F) {
        this.lPob0A14F = lPob0A14F;
    }

    public JLabel getlPob0A14M() {
        return lPob0A14M;
    }

    public void setlPob0A14M(JLabel lPob0A14M) {
        this.lPob0A14M = lPob0A14M;
    }

    public JLabel getlPob15A49Total() {
        return lPob15A49Total;
    }

    public void setlPob15A49Total(JLabel lPob15A49Total) {
        this.lPob15A49Total = lPob15A49Total;
    }

    public JLabel getlPob15A49F() {
        return lPob15A49F;
    }

    public void setlPob15A49F(JLabel lPob15A49F) {
        this.lPob15A49F = lPob15A49F;
    }

    public JLabel getlPob15A49M() {
        return lPob15A49M;
    }

    public void setlPob15A49M(JLabel lPob15A49M) {
        this.lPob15A49M = lPob15A49M;
    }

    public JLabel getlPob60YMasTotal() {
        return lPob60YMasTotal;
    }

    public void setlPob60YMasTotal(JLabel lPob60YMasTotal) {
        this.lPob60YMasTotal = lPob60YMasTotal;
    }

    public JLabel getlPob60YMasF() {
        return lPob60YMasF;
    }

    public void setlPob60YMasF(JLabel lPob60YMasF) {
        this.lPob60YMasF = lPob60YMasF;
    }

    public JLabel getlPob60YMasM() {
        return lPob60YMasM;
    }

    public void setlPob60YMasM(JLabel lPob60YMasM) {
        this.lPob60YMasM = lPob60YMasM;
    }

    public JLabel getlValorPobTotal() {
        return lValorPobTotal;
    }

    public void setlValorPobTotal(JLabel lValorPobTotal) {
        this.lValorPobTotal = lValorPobTotal;
    }

    public JLabel getlValorPobTotalF() {
        return lValorPobTotalF;
    }

    public void setlValorPobTotalF(JLabel lValorPobTotalF) {
        this.lValorPobTotalF = lValorPobTotalF;
    }

    public JLabel getlValorPobTotalM() {
        return lValorPobTotalM;
    }

    public void setlValorPobTotalM(JLabel lValorPobTotalM) {
        this.lValorPobTotalM = lValorPobTotalM;
    }

    public JLabel getlValorPob0A14Total() {
        return lValorPob0A14Total;
    }

    public void setlValorPob0A14Total(JLabel lValorPob0A14Total) {
        this.lValorPob0A14Total = lValorPob0A14Total;
    }

    public JLabel getlValorPob0A14F() {
        return lValorPob0A14F;
    }

    public void setlValorPob0A14F(JLabel lValorPob0A14F) {
        this.lValorPob0A14F = lValorPob0A14F;
    }

    public JLabel getlValorPob0A14M() {
        return lValorPob0A14M;
    }

    public void setlValorPob0A14M(JLabel lValorPob0A14M) {
        this.lValorPob0A14M = lValorPob0A14M;
    }

    public JLabel getlValorPob15A49Total() {
        return lValorPob15A49Total;
    }

    public void setlValorPob15A49Total(JLabel lValorPob15A49Total) {
        this.lValorPob15A49Total = lValorPob15A49Total;
    }

    public JLabel getlValorPob15A49F() {
        return lValorPob15A49F;
    }

    public void setlValorPob15A49F(JLabel lValorPob15A49F) {
        this.lValorPob15A49F = lValorPob15A49F;
    }

    public JLabel getlValorPob15A49M() {
        return lValorPob15A49M;
    }

    public void setlValorPob15A49M(JLabel lValorPob15A49M) {
        this.lValorPob15A49M = lValorPob15A49M;
    }

    public JLabel getlValorPob60YMasTotal() {
        return lValorPob60YMasTotal;
    }

    public void setlValorPob60YMasTotal(JLabel lValorPob60YMasTotal) {
        this.lValorPob60YMasTotal = lValorPob60YMasTotal;
    }

    public JLabel getlValorPob60YMasF() {
        return lValorPob60YMasF;
    }

    public void setlValorPob60YMasF(JLabel lValorPob60YMasF) {
        this.lValorPob60YMasF = lValorPob60YMasF;
    }

    public JLabel getlValorPob60YMasM() {
        return lValorPob60YMasM;
    }

    public void setlValorPob60YMasM(JLabel lValorPob60YMasM) {
        this.lValorPob60YMasM = lValorPob60YMasM;
    }

    public JTextField gettIdEntidad() {
        return tIdEntidad;
    }

    public void settIdEntidad(JTextField tIdEntidad) {
        this.tIdEntidad = tIdEntidad;
    }

    public JTextField gettNomEntidad() {
        return tNomEntidad;
    }

    public void settNomEntidad(JTextField tNomEntidad) {
        this.tNomEntidad = tNomEntidad;
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public void setsObjGraficos(ObjGraficosService sObjGraficos) {
        this.sObjGraficos = sObjGraficos;
    }

    public GraficosAvanzadosService getsGraficosAvanzados() {
        return sGraficosAvanzados;
    }

    public void setsGraficosAvanzados(GraficosAvanzadosService sGraficosAvanzados) {
        this.sGraficosAvanzados = sGraficosAvanzados;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public void setsRecursos(RecursosService sRecursos) {
        this.sRecursos = sRecursos;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public EstadosController getEstadosController() {
        return estadosController;
    }

    public void setEstadosController(EstadosController estadosController) {
        this.estadosController = estadosController;
    }

    public JComboBox<String> getCbEstados() {
        return cbEstados;
    }

    public void setCbEstados(JComboBox<String> cbEstados) {
        this.cbEstados = cbEstados;
    }

    public ImageIcon getiFondo() {
        return iFondo;
    }

    public void setiFondo(ImageIcon iFondo) {
        this.iFondo = iFondo;
    }

    public ImageIcon getiLogo() {
        return iLogo;
    }

    public void setiLogo(ImageIcon iLogo) {
        this.iLogo = iLogo;
    }

    public ImageIcon getiAbajo() {
        return iAbajo;
    }

    public void setiAbajo(ImageIcon iAbajo) {
        this.iAbajo = iAbajo;
    }

    public ImageIcon getiPunto1() {
        return iPunto1;
    }

    public void setiPunto1(ImageIcon iPunto1) {
        this.iPunto1 = iPunto1;
    }

    public ImageIcon getiPunto2() {
        return iPunto2;
    }

    public void setiPunto2(ImageIcon iPunto2) {
        this.iPunto2 = iPunto2;
    }

    public ImageIcon getiDimAux() {
        return iDimAux;
    }

    public void setiDimAux(ImageIcon iDimAux) {
        this.iDimAux = iDimAux;
    }

    public JButton getbComboBox() {
        return bComboBox;
    }

    public void setbComboBox(JButton bComboBox) {
        this.bComboBox = bComboBox;
    }

    public JPanel getpArriba() {
        return pArriba;
    }

    public void setpArriba(JPanel pArriba) {
        this.pArriba = pArriba;
    }

    public JPanel getpAbajo() {
        return pAbajo;
    }

    public void setpAbajo(JPanel pAbajo) {
        this.pAbajo = pAbajo;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

}
