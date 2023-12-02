/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.vistas;

import com.thrs.models.consultas.Estado;
import com.thrs.services.graphicServices.GraficosAvanzadosService;
import com.thrs.services.graphicServices.ObjGraficosService;
import com.thrs.services.graphicServices.RecursosService;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Usuario
 */
public class Grafico extends JPanel {

    private GridBagConstraints gbc;
    private ObjGraficosService sObjGraficos;
    private GraficosAvanzadosService sGraficosAvanzados;
    private RecursosService sRecursos;
    private Estado estado;

    public Grafico(Estado estado) {
        this.estado = estado;
        this.setLayout(new GridBagLayout());
        this.sObjGraficos = ObjGraficosService.getService();

        cargarGrafica();
    }

    public void cargarGrafica() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        datos.setValue(estado.getPobTotal(), "Población total", "General");
        datos.setValue(estado.getTotalMujeres(), "Población mujeres", "General");
        datos.setValue(estado.getTotalHombres(), "Población hombres", "General");

        datos.setValue(estado.getPob0A14Total(), "Población total", "0 - 14 años");
        datos.setValue(estado.getPob0A14Mujeres(), "Población mujeres", "0 - 14 años");
        datos.setValue(estado.getPob0A14Hombres(), "Población hombres", "0 - 14 años");

        datos.setValue(estado.getPob15A49Total(), "Población total", "15 - 49 años");
        datos.setValue(estado.getPob15A49Mujeres(), "Población mujeres", "15 - 49 años");
        datos.setValue(estado.getPob15A49Hombres(), "Población hombres", "15 - 49 años");

        datos.setValue(estado.getPob60YMasTotal(), "Población total", "60 y más");
        datos.setValue(estado.getPob60YMasMujeres(), "Población mujeres", "60 y más");
        datos.setValue(estado.getPob60YMasHombres(), "Población hombres", "60 y más");

        JFreeChart grafico_barras = ChartFactory.createBarChart3D(
                "Población Entidad",
                null,
                "Población",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        );

        grafico_barras.setBackgroundPaint(Color.WHITE);//Dar color al fondo del panel
        grafico_barras.getTitle().setPaint(Color.BLACK);//Dar color al titulo 

        CategoryPlot plot = grafico_barras.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);//Color del fondo del gr�fico

        plot.setDomainGridlinesVisible(true);//Lineas divisorias
        plot.setRangeGridlinePaint(Color.BLACK);//Color de lineas divisorias

        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Cambia el tamaño y tipo de fuente

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10)); // Cambia el tamaño y tipo de fuente

        gbc = sObjGraficos.getGridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 10, 10);
        this.add(panel, gbc);

//        panelPoblacionComponent.getInterfazCatalogoComponent().getInterfazCatalogoTemplate().pack();
//        panelPoblacionComponent.getInterfazCatalogoComponent().getInterfazCatalogoTemplate().repaint();
//        panelPoblacionComponent.getInterfazCatalogoComponent().getInterfazCatalogoTemplate().setExtendedState(MAXIMIZED_BOTH);
    }

}
