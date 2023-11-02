/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.TableModels;

import com.thrs.models.Censo2020;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModelCenso2020 extends AbstractTableModel {

    private static final int PAGE_SIZE = 20;
    private List<Censo2020> listaCenso;
    private String[] columnNames;
    private int currentPage;

    public ModelCenso2020() {
        this.currentPage = 0;
    }

    public void setColumnIdentifiers(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void agregarData(List<Censo2020> listaCenso) {
        this.listaCenso = listaCenso;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage * PAGE_SIZE >= listaCenso.size()) {
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
        return Math.min(listaCenso.size() - start, PAGE_SIZE);
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
        if (actualIndex < listaCenso.size()) {
            Censo2020 censo = listaCenso.get(actualIndex);
            switch (columnIndex) {
                case 0:
                    return censo.getIdEntidad();
                case 1:
                    return censo.getIdMunicipio();
                case 2: 
                    return censo.getIdLocalidad();
                case 3: 
                    return censo.getPobTotal();
                case 4: 
                    return censo.getPobFemenina();
                case 5: 
                    return censo.getPobMasculina();
                default:
                    return ""; // En caso de tener más columnas, manejar aquí
            }
        }
        return null;
    }

    public void limpiarDatos() {
        if (listaCenso != null) {
            listaCenso.clear();
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
