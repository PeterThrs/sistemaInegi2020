/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.TableModels;

import com.thrs.models.Municipio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModelMunicipio extends AbstractTableModel {

    private static final int PAGE_SIZE = 20;
    private List<Municipio> municipios;
    private String[] columnNames;
    private int currentPage;

    public ModelMunicipio() {
        this.currentPage = 0;
    }

    public void setColumnIdentifiers(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void agregarData(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage * PAGE_SIZE >= municipios.size()) {
            currentPage--;
        }
        fireTableDataChanged();
    }

    public void previousPage() {
        currentPage--;
        if (currentPage < 0) {
            currentPage = 0;
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        int start = currentPage * PAGE_SIZE;
        return Math.min(municipios.size() - start, PAGE_SIZE);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int actualIndex = (currentPage * PAGE_SIZE) + rowIndex;
        if (actualIndex < municipios.size()) {
            Municipio municipio = municipios.get(actualIndex);
            switch (columnIndex) {
                case 0:
                    return municipio.getIdEntidad();
                case 1:
                    return municipio.getIdMunicipio();
                case 2: 
                    return municipio.getNomMunicipio();
                default:
                    return ""; // En caso de tener más columnas, manejar aquí
            }
        }
        return null;
    }

    public void limpiarDatos() {
        if (municipios != null) {
            municipios.clear();
            fireTableDataChanged();
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public static int getPAGE_SIZE() {
        return PAGE_SIZE;
    }

}
