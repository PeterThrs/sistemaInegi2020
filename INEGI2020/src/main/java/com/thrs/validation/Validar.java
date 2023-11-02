/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.validation;

import com.thrs.models.Censo2020;
import com.thrs.models.Entidad;
import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import com.thrs.models.PoblacionEdad;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Validar {

    /**
     * Descripcion: Indica si la cadena no esta vacia
     *
     * @param cadena (String): dato
     * @throws
     */
    public static boolean contieneInformacion(String cadena) {
        return !cadena.isBlank();
    }

    /**
     * Descripcion: comprueba si el dato String contiene un valor numerico
     *
     * @param cadena (String): dato
     * @throws
     */
    public static boolean esNumero(String cadena) {
        try {
            int numero = Integer.parseInt(cadena);
            return true;
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return false;
    }

    /**
     * Descripcion: Compara dos objetos si son iguales por el metodo equals.
     *
     * @param cadena (String): dato
     * @throws
     */
    public static <T, N> boolean objectosIguales(T t, N n) {
        return t.equals(n);
    }

    /**
     * Descripcion: Existe el elemento el la lista mediante contains (usa el
     * metodo equals).
     *
     * @param cadena (String): dato
     * @throws
     */
    public static <T, E> boolean existeElemento(List<T> t, E e) {
        return t.contains(e);
    }

    public static boolean compararIdEntidad(List<Entidad> entidades, Entidad entidadNueva, Entidad entidadAnterior) {
        for (Entidad e : entidades) {
            if (e.getIdEntidad() == entidadNueva.getIdEntidad() && entidadNueva.getIdEntidad() != entidadAnterior.getIdEntidad()) {
                return true;
            }
        }
        return false;

    }

    public static boolean compararIdEntidad(List<Entidad> entidades, Entidad entidadNueva) {
        for (Entidad e : entidades) {
            if (e.getIdEntidad() == entidadNueva.getIdEntidad()) {
                return true;
            }
        }
        return false;

    }

    public static boolean existeIdEntidad(List<Entidad> entidades, Municipio municipio) {
        for (Entidad e : entidades) {
            if (e.getIdEntidad() == municipio.getIdEntidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeEntidad(List<Entidad> entidades, Localidad localidad) {
        for (Entidad e : entidades) {
            if (e.getIdEntidad() == localidad.getIdEntidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeMunicipio(List<Municipio> municipios, Localidad localidad) {
        for (Municipio m : municipios) {
            if (m.getIdEntidad() == localidad.getIdEntidad() && m.getIdMunicipio() == localidad.getIdMunicipio()) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeLocalidad(List<Localidad> localidades, Censo2020 censo2020) {
        for (Localidad l : localidades) {
            if (l.getIdEntidad() == censo2020.getIdEntidad() && l.getIdMunicipio() == censo2020.getIdMunicipio()
                    && l.getIdLocalidad() == censo2020.getIdLocalidad()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeLocalidad(List<Localidad> localidades, PoblacionEdad pobEdad) {
        for (Localidad l : localidades) {
            if (l.getIdEntidad() == pobEdad.getIdEntidad() && l.getIdMunicipio() == pobEdad.getIdMunicipio()
                    && l.getIdLocalidad() == pobEdad.getIdLocalidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean compararMunicipios(List<Municipio> municipios, Municipio municipio) {
        for (Municipio m : municipios) {
            if (m.getIdMunicipio() == municipio.getIdMunicipio() && m.getIdEntidad() == municipio.getIdEntidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean compararMunicipios(List<Municipio> municipios, Municipio mNuevo, Municipio mAnterior) {
        for (Municipio m : municipios) {
            if (m.getIdMunicipio() == mNuevo.getIdMunicipio() && m.getIdEntidad() == mNuevo.getIdEntidad()) {
                return (m.getIdMunicipio() != mAnterior.getIdMunicipio()
                        || m.getIdEntidad() != mAnterior.getIdEntidad());
            }
        }
        return false;
    }

    public static boolean compararLocalidades(List<Localidad> localidades, Localidad localidad) {
        for (Localidad l : localidades) {
            if (l.getIdMunicipio() == localidad.getIdMunicipio() && l.getIdEntidad() == localidad.getIdEntidad()
                    && l.getIdLocalidad() == localidad.getIdLocalidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean compararLocalidades(List<Localidad> localidades, Localidad lNueva, Localidad lAnterior) {
        for (Localidad l : localidades) {
            if (l.getIdMunicipio() == lNueva.getIdMunicipio() && l.getIdEntidad() == lNueva.getIdEntidad()
                    && l.getIdLocalidad() == lNueva.getIdLocalidad()) {
                return (l.getIdMunicipio() != lAnterior.getIdMunicipio()
                        || l.getIdEntidad() != lAnterior.getIdEntidad()
                        || l.getIdLocalidad() != lAnterior.getIdLocalidad());
            }
        }
        return false;
    }

    public static boolean compararCenso2020(List<Censo2020> listaCenso, Censo2020 censo) {
        for (Censo2020 c : listaCenso) {
            if (c.getIdMunicipio() == censo.getIdMunicipio() && c.getIdEntidad() == censo.getIdEntidad()
                    && c.getIdLocalidad() == censo.getIdLocalidad()) {
                return true;
            }
        }
        return false;
    }

    public static boolean compararCenso2020(List<Censo2020> listaCenso, Censo2020 cNuevo, Censo2020 cAnterior) {
        for (Censo2020 c : listaCenso) {
            if (c.getIdMunicipio() == cNuevo.getIdMunicipio() && c.getIdEntidad() == cNuevo.getIdEntidad()
                    && c.getIdLocalidad() == cNuevo.getIdLocalidad()) {
                return (c.getIdMunicipio() != cAnterior.getIdMunicipio()
                    || c.getIdEntidad() != cAnterior.getIdEntidad()
                    || c.getIdLocalidad() != cAnterior.getIdLocalidad());
            }
        }
        return false;
    }
    
    public static boolean compararPoblacion(List<PoblacionEdad> listaPoblacion, PoblacionEdad pob) {
        for (PoblacionEdad p : listaPoblacion) {
            if (p.getIdMunicipio() == pob.getIdMunicipio() && p.getIdEntidad() == pob.getIdEntidad()
                    && p.getIdLocalidad() == pob.getIdLocalidad()) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean compararPoblacion(List<PoblacionEdad> listaPoblacion, PoblacionEdad pobNueva, PoblacionEdad pobAnterior) {
        for (PoblacionEdad p : listaPoblacion) {
            if (p.getIdMunicipio() == pobNueva.getIdMunicipio() && p.getIdEntidad() == pobNueva.getIdEntidad()
                    && p.getIdLocalidad() == pobNueva.getIdLocalidad()) {
                return (p.getIdMunicipio() != pobAnterior.getIdMunicipio()
                    || p.getIdEntidad() != pobAnterior.getIdEntidad()
                    || p.getIdLocalidad() != pobAnterior.getIdLocalidad());
            }
        }
        return false;
    }

}
