/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.services;

import com.thrs.models.Censo2020;
import com.thrs.repository.Censo2020Dao;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Censo2020Service {
    
    private static Censo2020Service servicio;
    private Censo2020Dao censo2020Dao;
    private List<Censo2020> listaCenso;
    
    public Censo2020Service(){
        censo2020Dao = new Censo2020Dao();
        listaCenso = censo2020Dao.selectAll();
    }
    
    public Censo2020 devolverCenso(int pos){
        try{
            return listaCenso.get(pos);
        }catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        return null;
    }
    
    public int agregarCenso(Censo2020 censo2020){
        return this.censo2020Dao.insert(censo2020);
    }
    
    public int actualizarCenso(Censo2020 censoNuevo, Censo2020 censoAnterior){
        return this.censo2020Dao.update(censoNuevo, censoAnterior);
    }
    
    public int eliminarCenso(Censo2020 censo){
        return this.censo2020Dao.delete(censo);
    }
    
    public int devolverCantidadCenso(){
        return listaCenso.size();
    }
    
    public void actualizarLista(){
        listaCenso = censo2020Dao.selectAll();
    }
    
    public static Censo2020Service getService(){
        if(servicio == null){
            servicio = new Censo2020Service();
        }
        return servicio;
    }

    public List<Censo2020> getListaCenso() {
        //actualizamos la lista
        return censo2020Dao.selectAll();
    }
    
}
