/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Entidad;
import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import com.thrs.repository.EntidadDao;
import com.thrs.repository.LocalidadDao;
import com.thrs.repository.MunicipioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pruebaLocalidades {

    public static void main(String[] args) {

        LocalidadDao localidadDao = new LocalidadDao();
        int registros;
        Localidad entidad = new Localidad(1,1,0, "Nueva Localidad");
        Localidad entidadNueva = new Localidad(1,1,0, "Modificando la  localidad por una nueva");
        
        //imprimirLista(localidadDao);
        
        //insertar un municipio
        registros = localidadDao.insert(entidad);
        System.out.println("Total de entidades insertadas: " + registros);
        

        //imprimirLista(localidadDao);
        
        //modificar un dato
        
//        registros = 0;
//        registros = localidadDao.update(entidadNueva, entidad);
//        System.out.println("registros = " + registros);
        //imprimirLista(localidadDao);
        
        //eliminar un dato
        
//        registros = 0;
//        registros = localidadDao.delete(entidadNueva);
//        System.out.println("registros = " + registros);
        ///imprimirLista(localidadDao);
        
        

        //Traer un solo dato
//        entidad = new Localidad();
//        entidad.setIdEntidad(1);
//        entidad.setIdMunicipio(1);
//        entidad.setIdLocalidad(150);
//        
//        entidad = localidadDao.selectOne(entidad);
//        System.out.println("municipio = " + entidad);
            
        
    }

    private static void imprimirLista(LocalidadDao localidadDao) {
        //imprimir la lista entidades 

        List<Localidad> localidades = localidadDao.selectAll();
        System.out.println("size = " + localidades.size());

        localidades.forEach(System.out::println);
        
        System.out.println("size = " + localidades.size());
    }

}
