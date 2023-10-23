/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;
import com.thrs.models.PoblacionEdad;
import com.thrs.repository.PoblacionEdadDao;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pruebaPoblacionEdad {

    public static void main(String[] args) {

        PoblacionEdadDao poblacionEdadDao = new PoblacionEdadDao();
        int registros;
        PoblacionEdad entidad = new PoblacionEdad(1,1,0, 1,2,1,2,1,2,1,  
                2,1,2,1,2,1,2,1,2,1,  
                2,1,2,1,2,1,2,1,1,2);
        PoblacionEdad entidadNueva = new PoblacionEdad(1,1,0, 2,1,2,1,2,1,  
                2,1,2,1,2,1,2,1,2,1,  
                2,1,2,1,2,1,2,1,2,2, 1);
        
        //imprimirLista(poblacionEdadDao);
        
        //insertar un municipio
//        registros = poblacionEdadDao.insert(entidad);
//        System.out.println("Total de entidades insertadas: " + registros);

        //imprimirLista(localidadDao);
        
        //modificar un dato
        
//        registros = 0;
//        registros = poblacionEdadDao.update(entidadNueva, entidad);
//        System.out.println("registros = " + registros);
        //imprimirLista(localidadDao);
        
        //eliminar un dato
        
//        registros = 0;
//        registros = poblacionEdadDao.delete(entidadNueva);
//        System.out.println("registros = " + registros);
        ///imprimirLista(localidadDao);
        
        

        //Traer un solo dato
        entidad = new PoblacionEdad();
        entidad.setIdEntidad(1);
        entidad.setIdMunicipio(1);
        entidad.setIdLocalidad(1);
        
        entidad = poblacionEdadDao.selectOne(entidad);
        System.out.println("municipio = " + entidad);
            
        
    }

    private static void imprimirLista(PoblacionEdadDao poblacionEdadDao) {
        //imprimir la lista entidades 

        List<PoblacionEdad> listaPoblacion = poblacionEdadDao.selectAll();
        System.out.println("size = " + listaPoblacion.size());

        listaPoblacion.forEach(System.out::println);
        
        System.out.println("size = " + listaPoblacion.size());
    }

}
