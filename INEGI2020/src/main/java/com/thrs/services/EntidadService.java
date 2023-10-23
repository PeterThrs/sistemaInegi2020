/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.services;

import com.thrs.models.Entidad;
import com.thrs.repository.EntidadDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EntidadService {
    
    private static EntidadService servicio;
    private EntidadDao entidadDao;
    private List<Entidad> entidades;
    
    public EntidadService(){
        entidadDao = new EntidadDao();
        entidades = entidadDao.selectAll();
    }
    
    public Entidad devolverEntidad(int pos){
        try{
            return entidades.get(pos);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public int agregarEntidad(Entidad entidad){
        return this.entidadDao.insert(entidad);
    }
    
    public int actualizarEntidad(Entidad entidadNueva, Entidad entidadAnterior){
        return this.entidadDao.update(entidadNueva, entidadAnterior);
    }
    
    public int eliminarEntidad(Entidad entidad){
        return this.entidadDao.delete(entidad);
    }
    
    public int devolverCantidadEntidad(){
        return entidades.size();
    }
    
    public void actualizarLista(){
        entidades = entidadDao.selectAll();
    }
    
    public static EntidadService getService(){
        if(servicio == null){
            servicio = new EntidadService();
        }
        return servicio;
    }

    public List<Entidad> getEntidades() {
        //actualizamos la lista
        return entidadDao.selectAll();
    }
    
    
    
}
