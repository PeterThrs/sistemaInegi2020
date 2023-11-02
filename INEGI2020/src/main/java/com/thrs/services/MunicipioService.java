/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.services;

import com.thrs.models.Municipio;
import com.thrs.repository.MunicipioDao;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MunicipioService {
    
    private static MunicipioService servicio;
    private MunicipioDao municipioDao;
    private List<Municipio> municipios;
    
    public MunicipioService(){
        municipioDao = new MunicipioDao();
        municipios = municipioDao.selectAll();
    }
    
    public Municipio devolverEntidad(int pos){
        try{
            return municipios.get(pos);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public int agregarMunicipio(Municipio municipio){
        return this.municipioDao.insert(municipio);
    }
    
    public int actualizarMunicipio(Municipio municipioNuevo, Municipio municipioAnterior){
        return this.municipioDao.update(municipioNuevo, municipioAnterior);
    }
    
    public int eliminarMunicipio(Municipio municipio){
        return this.municipioDao.delete(municipio);
    }
    
    public int devolverCantidadEntidad(){
        return municipios.size();
    }
    
    public void actualizarLista(){
        municipios = municipioDao.selectAll();
    }
    
    public static MunicipioService getService(){
        if(servicio == null){
            servicio = new MunicipioService();
        }
        return servicio;
    }

    public List<Municipio> getMunicipios() {
        //actualizamos la lista
        return municipioDao.selectAll();
    }
    
    
    
}
