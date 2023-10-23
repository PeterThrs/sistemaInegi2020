/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import com.thrs.models.Localidad;
import com.thrs.models.Municipio;
import static com.thrs.repository.Conexion.close;
import static com.thrs.repository.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class LocalidadDao {
    
    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, idlocalidad, nom_localidad FROM localidades";
    private static final String SQL_INSERT = "INSERT INTO localidades (identidad, idmunicipio,idlocalidad, nom_localidad) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE localidades SET identidad = ?, idmunicipio =?, idlocalidad = ?,  nom_localidad = ? WHERE identidad = ? AND idmunicipio=? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM municipios ORDER BY identidad DESC LIMIT 1;";

    public static List<Localidad> selectAll() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Localidad localidad = null;
        List<Localidad> localidades = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idLocalidad");
                String nomLocalidad = rs.getString("nom_localidad");

                localidad = new Localidad(idEntidad, idMunicipio, idLocalidad, nomLocalidad);
                localidades.add(localidad);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(coon);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return localidades;

    }

    public static int insert(Localidad localidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, localidad.getIdEntidad());
            stmt.setInt(2, localidad.getIdMunicipio());
            stmt.setInt(3,localidad.getIdLocalidad());
            stmt.setString(4, localidad.getNomLocalidad());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(coon);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return registros;

    }

    public static int update(Localidad locNueva, Localidad locAnterior) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, locNueva.getIdEntidad());
            stmt.setInt(2, locNueva.getIdMunicipio());
            stmt.setInt(3, locNueva.getIdLocalidad());
            stmt.setString(4, locNueva.getNomLocalidad());
            stmt.setInt(5, locAnterior.getIdEntidad());
            stmt.setInt(6, locAnterior.getIdMunicipio());
            stmt.setInt(7, locAnterior.getIdLocalidad());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;

    }

    public static int delete(Localidad localidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, localidad.getIdEntidad());
            stmt.setInt(2, localidad.getIdMunicipio());
            stmt.setInt(3, localidad.getIdLocalidad());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;

    }

    public static Localidad selectOne(Localidad localidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, localidad.getIdEntidad());
            stmt.setInt(2, localidad.getIdMunicipio());
            stmt.setInt(3, localidad.getIdLocalidad());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idlocalidad");
                String nomLocalidad = rs.getString("nom_localidad");
                localidad.setIdEntidad(idEntidad);
                localidad.setIdMunicipio(idMunicipio);
                localidad.setIdMunicipio(idLocalidad);
                localidad.setNomLocalidad(nomLocalidad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(coon);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return localidad;
    }
    
}
