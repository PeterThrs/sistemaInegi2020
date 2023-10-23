/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import com.thrs.models.Censo2020;
import com.thrs.models.Localidad;
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
public class Censo2020Dao {
    
    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, idlocalidad, pob_total, pob_femenina, pob_masculina FROM censo2020";
    private static final String SQL_INSERT = "INSERT INTO censo2020 (identidad, idmunicipio,idlocalidad, pob_total, pob_femenina, pob_masculina) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE censo2020 SET identidad = ?, idmunicipio =?, idlocalidad = ?,  pob_total = ?, pob_femenina = ?, pob_masculina = ? WHERE identidad = ? AND idmunicipio=? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM censo2020 WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM censo2020 WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM municipios ORDER BY identidad DESC LIMIT 1;";

    public static List<Censo2020> selectAll() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Censo2020 censo2020 = null;
        List<Censo2020> listaCenso = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idLocalidad");
                int pobTotal = rs.getInt("pob_total");
                int pobFemenina = rs.getInt("pob_femenina");
                int pobMasculina = rs.getInt("pob_Masculina");

                censo2020 = new Censo2020(idEntidad, idMunicipio, idLocalidad, pobTotal, pobFemenina, pobMasculina);
                listaCenso.add(censo2020);

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

        return listaCenso;

    }

    public static int insert(Censo2020 censo2020) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, censo2020.getIdEntidad());
            stmt.setInt(2, censo2020.getIdMunicipio());
            stmt.setInt(3,censo2020.getIdLocalidad());
            stmt.setInt(4,censo2020.getPobTotal());
            stmt.setInt(5,censo2020.getPobFemenina());
            stmt.setInt(6,censo2020.getPobMasculina());

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

    public static int update(Censo2020 nuevoCenso, Censo2020 anteriorCenso) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, nuevoCenso.getIdEntidad());
            stmt.setInt(2, nuevoCenso.getIdMunicipio());
            stmt.setInt(3, nuevoCenso.getIdLocalidad());
            stmt.setInt(4, nuevoCenso.getPobTotal());
            stmt.setInt(5, nuevoCenso.getPobFemenina());
            stmt.setInt(6, nuevoCenso.getPobMasculina());
            
            stmt.setInt(7, anteriorCenso.getIdEntidad());
            stmt.setInt(8, anteriorCenso.getIdMunicipio());
            stmt.setInt(9, anteriorCenso.getIdLocalidad());

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

    public static int delete(Censo2020 censo2020) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, censo2020.getIdEntidad());
            stmt.setInt(2, censo2020.getIdMunicipio());
            stmt.setInt(3, censo2020.getIdLocalidad());

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

    public static Censo2020 selectOne(Censo2020 censo2020) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, censo2020.getIdEntidad());
            stmt.setInt(2, censo2020.getIdMunicipio());
            stmt.setInt(3, censo2020.getIdLocalidad());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idlocalidad");
                int pobTotal = rs.getInt("pob_total");
                int pobFemenina = rs.getInt("pob_femenina");
                int pobMasculina = rs.getInt("pob_masculina");
                
                censo2020.setIdEntidad(idEntidad);
                censo2020.setIdMunicipio(idMunicipio);
                censo2020.setIdMunicipio(idLocalidad);
                censo2020.setPobTotal(pobTotal);
                censo2020.setPobFemenina(pobFemenina);
                censo2020.setPobMasculina(pobMasculina);
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

        return censo2020;
    }
    
}
