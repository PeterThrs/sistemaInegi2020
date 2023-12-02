/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs;

import com.thrs.models.Censo2020;
import com.thrs.models.Entidad;
import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import com.thrs.models.consultas.Estado;
import com.thrs.repository.Censo2020Dao;
import com.thrs.repository.ConsultasBD;
import com.thrs.repository.EntidadDao;
import com.thrs.repository.LocalidadDao;
import com.thrs.repository.MunicipioDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class pruebaCenso2020 {

    public static void main(String[] args) {
        
        ConsultasBD consultas = new ConsultasBD();
        
//        List<Estado> lista = consultas.obtenerPobEstado();
//        
//        System.out.println("\nImprimiendo desde el main \n");
//        
//        lista.forEach(e -> System.out.println(e ));

            Estado estado = consultas.obtenerPobNacional();
            
            System.out.println("estado = " + estado);
        

//        Censo2020Dao censo2020Dao = new Censo2020Dao();
//        int registros;
//        Censo2020 entidad = new Censo2020(1,1,0, 13, 13, 100);
//        Censo2020 entidadNueva = new Censo2020(1,1,0, 100, 100, 13);
//        
//        //imprimirLista(censo2020Dao);
//        
//        //insertar un municipio
//        registros = censo2020Dao.insert(entidad);
//        System.out.println("Total de entidades insertadas: " + registros);

        //imprimirLista(localidadDao);
        
        //modificar un dato
        
//        registros = 0;
//        registros = censo2020Dao.update(entidadNueva, entidad);
//        System.out.println("registros = " + registros);
        //imprimirLista(localidadDao);
        
        //eliminar un dato
        
//        registros = 0;
//        registros = censo2020Dao.delete(entidadNueva);
//        System.out.println("registros = " + registros);
        ///imprimirLista(localidadDao);
        
        

        //Traer un solo dato
//        entidad = new Censo2020();
//        entidad.setIdEntidad(1);
//        entidad.setIdMunicipio(1);
//        entidad.setIdLocalidad(1);
//        
//        entidad = censo2020Dao.selectOne(entidad);
//        System.out.println("municipio = " + entidad);
            
        
    }

    private static void imprimirLista(Censo2020Dao censo2020Dao) {
        //imprimir la lista entidades 

        List<Censo2020> listaCenso = censo2020Dao.selectAll();
        System.out.println("size = " + listaCenso.size());

        listaCenso.forEach(System.out::println);
        
        System.out.println("size = " + listaCenso.size());
    }

}
