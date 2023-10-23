/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

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
public class MunicipioDao {

    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, nom_municipio FROM municipios";
    private static final String SQL_INSERT = "INSERT INTO municipios (identidad, idmunicipio, nom_municipio) values (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE municipios SET identidad = ?, idmunicipio =?,  nom_municipio = ? WHERE identidad = ? AND idmunicipio=?";
    private static final String SQL_DELETE = "DELETE FROM municipios WHERE identidad = ? AND idmunicipio = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM municipios WHERE identidad = ? AND idmunicipio = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM municipios ORDER BY identidad DESC LIMIT 1;";

    public static List<Municipio> selectAll() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Municipio municipio = null;
        List<Municipio> municipios = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                String nomMunicipio = rs.getString("nom_municipio");

                municipio = new Municipio(identidad, idmunicipio, nomMunicipio);
                municipios.add(municipio);

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

        return municipios;

    }

    public static int insert(Municipio municipio) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, municipio.getIdEntidad());
            stmt.setInt(2, municipio.getIdMunicipio());
            stmt.setString(3, municipio.getNomMunicipio());

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

    public static int update(Municipio munNuevo, Municipio munAnterior) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, munNuevo.getIdEntidad());
            stmt.setInt(2, munNuevo.getIdMunicipio());
            stmt.setString(3, munNuevo.getNomMunicipio());
            stmt.setInt(4, munAnterior.getIdEntidad());
            stmt.setInt(5, munAnterior.getIdMunicipio());

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

    public static int delete(Municipio municipio) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, municipio.getIdEntidad());
            stmt.setInt(2, municipio.getIdMunicipio());

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

    public static Municipio selectOne(Municipio municipio) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, municipio.getIdEntidad());
            stmt.setInt(2, municipio.getIdMunicipio());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                String nomMunicipio = rs.getString("nom_municipio");
                municipio.setIdEntidad(idEntidad);
                municipio.setIdMunicipio(idMunicipio);
                municipio.setNomMunicipio(nomMunicipio);
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

        return municipio;
    }

}
