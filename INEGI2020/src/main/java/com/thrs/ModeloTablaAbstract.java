/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 * @param <T>
 */
public abstract class ModeloTablaAbstract <T> extends AbstractTableModel {
    
    protected List<T> allData; // Lista con todos los datos
    protected List<T> visibleData; // Lista para almacenar los datos visibles actualmente
    protected int visibleRows; // Número de filas visibles en la tabla
    protected int lastVisibleRowIndex; // Último índice de fila visible cargado
    protected List<String> columnas;

    public ModeloTablaAbstract(List<T> allData, List<String> columnas, int visibleRows) {
        this.allData = allData;
        this.columnas = columnas;
        this.visibleRows = visibleRows;
        this.visibleData = new ArrayList<>();
        loadVisibleData(0); // Cargar los primeros datos visibles
    }

    protected void loadVisibleData(int startIndex){
        int endIndex = Math.min(startIndex + visibleRows, allData.size());
        visibleData = allData.subList(startIndex, endIndex);
        lastVisibleRowIndex = endIndex - 1;
    }

    protected void loadMoreData(int firstRowIndex, int lastRowIndex){
        int visibleRowsCount = lastRowIndex - firstRowIndex + 1;

        // Cargar más datos hacia adelante (scroll hacia abajo)
        if (lastRowIndex >= lastVisibleRowIndex) {
            loadVisibleData(lastVisibleRowIndex + 1);
            fireTableRowsInserted(lastVisibleRowIndex + 1, lastVisibleRowIndex + visibleRowsCount);
        }
        // Cargar más datos hacia atrás (scroll hacia arriba)
        else if (firstRowIndex <= 0 && lastRowIndex == 0) {
            int startIndex = Math.max(lastVisibleRowIndex - visibleRows, 0);
            loadVisibleData(startIndex);
            fireTableDataChanged(); // Notificar cambio en todos los datos
        }
    }

    @Override
    public int getRowCount() {
        return visibleData.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }
    
    @Override
    public String getColumnName(int column){
        return columnas.get(column);
    }
    
}
