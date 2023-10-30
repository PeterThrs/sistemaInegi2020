/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Entidad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ModeloTablaEntidades extends ModeloTablaAbstract<Entidad> {

    public ModeloTablaEntidades(List<Entidad> allData, List<String> columnas, int visibleRows) {
        super(allData, columnas, visibleRows);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return visibleData.get(rowIndex).getIdEntidad();
            case 1:
                return visibleData.get(rowIndex).getNomEntidad();
            default:
                return null;
        }
    }

    @Override
    protected void loadVisibleData(int startIndex) {
        super.loadVisibleData(startIndex);
    }

    @Override
    protected void loadMoreData(int firstRowIndex, int lastRowIndex) {
        super.loadMoreData(firstRowIndex, lastRowIndex);
    }

}
