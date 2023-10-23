/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Entidad;
import com.thrs.repository.EntidadDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pruebaEntidades {

    public static void main(String[] args) {

        EntidadDao entidadDao = new EntidadDao();
        int registros;
        Entidad entidad = new Entidad(0, "Nueva entidad");
        Entidad entidadNueva = new Entidad(99, "Modificando la entidad");
        
//        //insertar un dato entidades
//        registros = entidadDao.insert(entidad);
//        System.out.println("Total de entidades insertadas: " + registros);
//
//        imprimirLista(entidadDao);
        
        //modificar un dato
        
//        registros = 0;
//        registros = entidadDao.update(entidadNueva, entidad);
//        imprimirLista(entidadDao);
        
        //eliminar un dato
        
//        registros = 0;
//        registros = entidadDao.delete(entidadNueva);
//        System.out.println("registros = " + registros);
//        imprimirLista(entidadDao);
        

        //Traer un solo dato
        entidad = new Entidad();
        entidad.setIdEntidad(30);
        
        entidad = entidadDao.selectOne(entidad);
        System.out.println("entidad = " + entidad);
            
        
    }

    private static void imprimirLista(EntidadDao entidadDao) {
        //imprimir la lista entidades 

        List<Entidad> entidades = entidadDao.selectAll();

        entidades.forEach(System.out::println);
    }

}
