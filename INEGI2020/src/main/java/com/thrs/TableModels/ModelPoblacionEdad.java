/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.TableModels;

import com.thrs.models.PoblacionEdad;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Usuario
 */
public class ModelPoblacionEdad extends AbstractTableModel {

    private static final int PAGE_SIZE = 20;
    private List<PoblacionEdad> listaPoblacion;
    private String[] columnNames;
    private int currentPage;
    private JTable miTabla;

    public ModelPoblacionEdad() {
        this.currentPage = 0;
    }

    public void setTabla(JTable miTabla) {
        this.miTabla = miTabla;
    }

    public void setColumnIdentifiers(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void agregarData(List<PoblacionEdad> listaPoblacion) {
        this.listaPoblacion = listaPoblacion;
    }

    public void nextPage() {
        currentPage++;
        if (currentPage * PAGE_SIZE >= listaPoblacion.size()) {
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
        return Math.min(listaPoblacion.size() - start, PAGE_SIZE);
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
        if (actualIndex < listaPoblacion.size()) {
            PoblacionEdad poblacionEdad = listaPoblacion.get(actualIndex);
            switch (columnIndex) {
                case 0:
                    return poblacionEdad.getIdEntidad();
                case 1:
                    return poblacionEdad.getIdMunicipio();
                case 2:
                    return poblacionEdad.getIdLocalidad();
                case 3:
                    return poblacionEdad.getP0A2F();
                case 4:
                    return poblacionEdad.getP0A2M();
                case 5:
                    return poblacionEdad.getP3YMasF();
                case 6:
                    return poblacionEdad.getP3YMasM();
                case 7:
                    return poblacionEdad.getP5YMasF();
                case 8:
                    return poblacionEdad.getP5YMasM();
                case 9:
                    return poblacionEdad.getP12YMasF();
                case 10:
                    return poblacionEdad.getP12YMasM();
                case 11:
                    return poblacionEdad.getP15YMasF();
                case 12:
                    return poblacionEdad.getP15YMasM();
                case 13:
                    return poblacionEdad.getP18YMasF();
                case 14:
                    return poblacionEdad.getP18YMasM();
                case 15:
                    return poblacionEdad.getP3A5F();
                case 16:
                    return poblacionEdad.getP3A5M();
                case 17:
                    return poblacionEdad.getP6A11F();
                case 18:
                    return poblacionEdad.getP6A11M();
                case 19:
                    return poblacionEdad.getP8A14F();
                case 20:
                    return poblacionEdad.getP8A14M();
                case 21:
                    return poblacionEdad.getP12A14F();
                case 22:
                    return poblacionEdad.getP12A14M();
                case 23:
                    return poblacionEdad.getP15A17F();
                case 24:
                    return poblacionEdad.getP15A17M();
                case 25:
                    return poblacionEdad.getP18A24F();
                case 26:
                    return poblacionEdad.getP18A24M();
                case 27:
                    return poblacionEdad.getP15A49F();
                case 28:
                    return poblacionEdad.getP60YMasF();
                case 29:
                    return poblacionEdad.getP60YMasM();

                default:
                    return ""; // En caso de tener más columnas, manejar aquí
            }
        }
        return null;
    }

    public void limpiarDatos() {
        if (listaPoblacion != null) {
            listaPoblacion.clear();
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
