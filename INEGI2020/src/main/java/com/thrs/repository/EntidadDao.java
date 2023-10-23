/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import static com.thrs.repository.Conexion.*;
import com.thrs.models.Entidad;
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
public class EntidadDao {

    private static final String SQL_SELECT = "SELECT identidad, nom_entidad FROM entidades";
    private static final String SQL_INSERT = "INSERT INTO entidades (identidad, nom_entidad) values (?,?)";
    private static final String SQL_UPDATE = "UPDATE entidades SET identidad = ?, nom_entidad = ? WHERE identidad=?";
    private static final String SQL_DELETE = "DELETE FROM entidades WHERE identidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM entidades WHERE identidad = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM entidades ORDER BY identidad DESC LIMIT 1;";

    public static List<Entidad> selectAll() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Entidad entidad = null;
        List<Entidad> entidades = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int identidad = rs.getInt("identidad");
                String nomEntidad = rs.getString("nom_entidad");

                entidad = new Entidad(identidad, nomEntidad);
                entidades.add(entidad);

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

        return entidades;

    }

    public static int insert(Entidad entidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, entidad.getIdEntidad());
            stmt.setString(2, entidad.getNomEntidad());

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

    public static int update(Entidad entidadNueva, Entidad entidadAnterior) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, entidadNueva.getIdEntidad());
            stmt.setString(2, entidadNueva.getNomEntidad());
            stmt.setInt(3, entidadAnterior.getIdEntidad());
            
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

    public static int delete(Entidad entidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, entidad.getIdEntidad());
            
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

    public static Entidad selectOne(Entidad entidad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, entidad.getIdEntidad());
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                String nomEntidad = rs.getString("nom_entidad");
                entidad.setIdEntidad(idEntidad);
                entidad.setNomEntidad(nomEntidad);
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

        return entidad;
    }

}
