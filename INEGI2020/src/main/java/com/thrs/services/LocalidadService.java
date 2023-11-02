/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.services;

import com.thrs.models.Localidad;
import com.thrs.repository.LocalidadDao;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LocalidadService {
    
    private static LocalidadService servicio;
    private LocalidadDao localidadDao;
    private List<Localidad> localidades;
    
    public LocalidadService(){
        localidadDao = new LocalidadDao();
        localidades = localidadDao.selectAll();
    }
    
    public Localidad devolverLocalidad(int pos){
        try{
            return localidades.get(pos);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public int agregarLocalidad(Localidad localidad){
        return this.localidadDao.insert(localidad);
    }
    
    public int actualizarLocalidad(Localidad localidadNueva, Localidad localidadAnterior){
        return this.localidadDao.update(localidadNueva, localidadAnterior);
    }
    
    public int eliminarLocalidad(Localidad localidad){
        return this.localidadDao.delete(localidad);
    }
    
    public int devolverCantidadLocalidad(){
        return localidades.size();
    }
    
    public void actualizarLista(){
        localidades = localidadDao.selectAll();
    }
    
    public static LocalidadService getService(){
        if(servicio == null){
            servicio = new LocalidadService();
        }
        return servicio;
    }

    public List<Localidad> getLocalidades() {
        //actualizamos la lista
        return localidadDao.selectAll();
    }
    
}
