/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Entidad;
import com.thrs.models.Municipio;
import com.thrs.repository.EntidadDao;
import com.thrs.repository.MunicipioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pruebaMunicipios {

    public static void main(String[] args) {

        MunicipioDao municipioDao = new MunicipioDao();
        int registros;
        Municipio entidad = new Municipio(0,0, "Nueva municipio");
        Municipio entidadNueva = new Municipio(1,0, "Modificando el municipio");
        
        //imprimirLista(municipioDao);
        
        //insertar un municipio
//        registros = municipioDao.insert(entidad);
//        System.out.println("Total de entidades insertadas: " + registros);
//
//        imprimirLista(municipioDao);
        
        //modificar un dato
        
//        registros = 0;
//        registros = municipioDao.update(entidadNueva, entidad);
//        imprimirLista(municipioDao);
        
        //eliminar un dato
        
//        registros = 0;
//        registros = municipioDao.delete(entidadNueva);
//        System.out.println("registros = " + registros);
//        imprimirLista(municipioDao);
        
        

        //Traer un solo dato
//        entidad = new Municipio();
//        entidad.setIdEntidad(1);
//        entidad.setIdMunicipio(1);
//        
//        entidad = municipioDao.selectOne(entidad);
//        System.out.println("municipio = " + entidad);
            
        
    }

    private static void imprimirLista(MunicipioDao municipioDao) {
        //imprimir la lista entidades 

        List<Municipio> entidades = municipioDao.selectAll();
        System.out.println("size = " + entidades.size());

        entidades.forEach(System.out::println);
        
        System.out.println("size = " + entidades.size());
    }

}
