/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.TableModels;

import com.thrs.models.Localidad;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModelLocalidad extends AbstractTableModel {

    private static final int PAGE_SIZE = 20;
    private List<Localidad> localidades;
    private String[] columnNames;
    private int currentPage;

    public ModelLocalidad() {
        this.currentPage = 0;
    }

    public void setColumnIdentifiers(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void agregarData(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage * PAGE_SIZE >= localidades.size()) {
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
        return Math.min(localidades.size() - start, PAGE_SIZE);
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
        if (actualIndex < localidades.size()) {
            Localidad localidad = localidades.get(actualIndex);
            switch (columnIndex) {
                case 0:
                    return localidad.getIdEntidad();
                case 1:
                    return localidad.getIdMunicipio();
                case 2: 
                    return localidad.getIdLocalidad();
                case 3: 
                    return localidad.getNomLocalidad();
                default:
                    return ""; // En caso de tener más columnas, manejar aquí
            }
        }
        return null;
    }

    public void limpiarDatos() {
        if (localidades != null) {
            localidades.clear();
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
