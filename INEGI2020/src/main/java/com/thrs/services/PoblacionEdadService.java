/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.services;

import com.thrs.models.PoblacionEdad;
import com.thrs.repository.PoblacionEdadDao;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PoblacionEdadService {
    
    private static PoblacionEdadService servicio;
    private PoblacionEdadDao poblacionEdadDao;
    private List<PoblacionEdad> listaPoblacion;
    
    public PoblacionEdadService(){
        poblacionEdadDao = new PoblacionEdadDao();
        listaPoblacion = poblacionEdadDao.selectAll();
    }
    
    public PoblacionEdad devolverPoblacion(int pos){
        try{
            return listaPoblacion.get(pos);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public int agregarPoblacion(PoblacionEdad poblacionEdad){
        return this.poblacionEdadDao.insert(poblacionEdad);
    }
    
    public int actualizarPoblacion(PoblacionEdad poblacionEdadNueva, PoblacionEdad poblacionEdadAnterior){
        return this.poblacionEdadDao.update(poblacionEdadNueva, poblacionEdadAnterior);
    }
    
    public int eliminarPoblacion(PoblacionEdad poblacionEdad){
        return this.poblacionEdadDao.delete(poblacionEdad);
    }
    
    public int devolverCantidadPoblacion(){
        return listaPoblacion.size();
    }
    
    public void actualizarLista(){
        listaPoblacion = poblacionEdadDao.selectAll();
    }
    
    public static PoblacionEdadService getService(){
        if(servicio == null){
            servicio = new PoblacionEdadService();
        }
        return servicio;
    }

    public List<PoblacionEdad> getListaPoblacion() {
        //actualizamos la lista
        return poblacionEdadDao.selectAll();
    }
    
}
