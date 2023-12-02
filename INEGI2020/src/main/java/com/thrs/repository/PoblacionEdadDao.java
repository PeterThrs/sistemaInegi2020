/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import com.thrs.models.Censo2020;
import com.thrs.models.PoblacionEdad;
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
public class PoblacionEdadDao {

    private static final String SQL_SELECT = "SELECT * FROM poblacion_edad";
    private static final String SQL_INSERT = "INSERT INTO poblacion_edad values (?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE poblacion_edad SET identidad = ?, idmunicipio =?, idlocalidad = ?,"
            + "P_0A2_F = ?,P_0A2_M = ?,P_3YMAS_F = ?,P_3YMAS_M = ?,P_5YMAS_F = ?,P_5YMAS_M = ?,"
            + "P_12YMAS_F = ?,P_12YMAS_M = ?,P_15YMAS_F = ?,P_15YMAS_M = ?,P_18YMAS_F = ?,P_18YMAS_M = ?, "
            + "P_3A5_F = ?,P_3A5_M = ?,P_6A11_F = ?,P_6A11_M = ?,P_8A14_F = ?,P_8A14_M = ?,"
            + "P_12A14_F = ?,P_12A14_M = ?,P_15A17_F = ?,P_15A17_M = ?,P_18A24_F = ?,P_18A24_M = ?,"
            + "P_15A49_F = ?,P_60YMAS_F = ?,P_60YMAS_M = ?"
            + " WHERE identidad = ? AND idmunicipio=? AND idlocalidad = ?";

    private static final String SQL_DELETE = "DELETE FROM poblacion_edad WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM poblacion_edad WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";

    public static List<PoblacionEdad> selectAll() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PoblacionEdad poblacionEdad = null;
        List<PoblacionEdad> listaPoblacionEdad = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idLocalidad");
                
                int p0A2F = rs.getInt("P_0A2_F");
                int p0A2M = rs.getInt("P_0A2_M");
                int p3YMasF = rs.getInt("P_3YMAS_F");
                int p3YMasM = rs.getInt("P_3YMAS_M");
                int p5YMasF = rs.getInt("P_5YMAS_F");
                int p5YMasM = rs.getInt("P_5YMAS_M");
                int p12YMasF = rs.getInt("P_12YMAS_F");
                int p12YMasM = rs.getInt("P_12YMAS_M");
                int p15YMasF = rs.getInt("P_15YMAS_F");
                int p15YMasM = rs.getInt("P_15YMAS_M");
                int p18YMasF = rs.getInt("P_18YMAS_F");
                int p18YMasM = rs.getInt("P_18YMAS_M");

                int p3A5F = rs.getInt("P_3A5_F");
                int p3A5M = rs.getInt("P_3A5_M");
                int p6A11F = rs.getInt("P_6A11_F");
                int p6A11M = rs.getInt("P_6A11_M");
                int p8A14F = rs.getInt("P_8A14_F");
                int p8A14M = rs.getInt("P_8A14_M");
                int p12A14F = rs.getInt("P_12A14_F");
                int p12A14M = rs.getInt("P_12A14_M");
                int p15A17F = rs.getInt("P_15A17_F");
                int p15A17M = rs.getInt("P_15A17_M");
                int p18A24F = rs.getInt("P_18A24_F");
                int p18A24M = rs.getInt("P_18A24_M");
                int p15A49F = rs.getInt("P_15A49_F");
                int p60YMasF = rs.getInt("P_60YMAS_F");
                int p60YMasM = rs.getInt("P_60YMAS_M");

                poblacionEdad = new PoblacionEdad(idEntidad, idMunicipio, idLocalidad);
                
                poblacionEdad.setP0A2F(p0A2F);
                poblacionEdad.setP0A2M(p0A2M);
                poblacionEdad.setP3YMasF(p3YMasF);
                poblacionEdad.setP3YMasM(p3YMasM);
                poblacionEdad.setP5YMasF(p5YMasF);
                poblacionEdad.setP5YMasM(p5YMasM);
                poblacionEdad.setP12YMasF(p12YMasF);
                poblacionEdad.setP12YMasM(p12YMasM);
                poblacionEdad.setP15YMasF(p15YMasF);
                poblacionEdad.setP15YMasM(p15YMasM);
                poblacionEdad.setP18YMasF(p18YMasF);
                poblacionEdad.setP18YMasM(p18YMasM);
                
                poblacionEdad.setP3A5F(p3A5F);
                poblacionEdad.setP3A5M(p3A5M);
                poblacionEdad.setP6A11F(p6A11F);
                poblacionEdad.setP6A11M(p6A11M);
                poblacionEdad.setP8A14F(p8A14F);
                poblacionEdad.setP8A14M(p8A14M);
                poblacionEdad.setP12A14F(p12A14F);
                poblacionEdad.setP12A14M(p12A14M);
                poblacionEdad.setP15A17F(p15A17F);
                poblacionEdad.setP15A17M(p15A17M);
                poblacionEdad.setP18A24F(p18A24F);
                poblacionEdad.setP18A24M(p18A24M);
                poblacionEdad.setP15A49F(p15A49F);
                poblacionEdad.setP60YMasF(p60YMasF);
                poblacionEdad.setP60YMasM(p60YMasM);
                

                listaPoblacionEdad.add(poblacionEdad);

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

        return listaPoblacionEdad;

    }

    public static int insert(PoblacionEdad poblacionEdad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, poblacionEdad.getIdEntidad());
            stmt.setInt(2, poblacionEdad.getIdMunicipio());
            stmt.setInt(3, poblacionEdad.getIdLocalidad());
            
            stmt.setInt(4, poblacionEdad.getP0A2F());
            stmt.setInt(5, poblacionEdad.getP0A2M());
            stmt.setInt(6, poblacionEdad.getP3YMasF());
            stmt.setInt(7, poblacionEdad.getP3YMasM());
            stmt.setInt(8, poblacionEdad.getP5YMasF());
            stmt.setInt(9, poblacionEdad.getP5YMasM());
            stmt.setInt(10, poblacionEdad.getP12YMasF());
            stmt.setInt(11, poblacionEdad.getP12YMasM());
            stmt.setInt(12, poblacionEdad.getP15YMasF());
            stmt.setInt(13, poblacionEdad.getP15YMasM());
            stmt.setInt(14, poblacionEdad.getP18YMasF());
            stmt.setInt(15, poblacionEdad.getP18YMasM());
            
            stmt.setInt(16, poblacionEdad.getP3A5F());
            stmt.setInt(17, poblacionEdad.getP3A5M());
            stmt.setInt(18, poblacionEdad.getP6A11F());
            stmt.setInt(19, poblacionEdad.getP6A11M());
            stmt.setInt(20, poblacionEdad.getP8A14F());
            stmt.setInt(21, poblacionEdad.getP8A14M());
            stmt.setInt(22, poblacionEdad.getP12A14F());
            stmt.setInt(23, poblacionEdad.getP12A14M());
            stmt.setInt(24, poblacionEdad.getP15A17F());
            stmt.setInt(25, poblacionEdad.getP15A17M());
            stmt.setInt(26, poblacionEdad.getP18A24F());
            stmt.setInt(27, poblacionEdad.getP18A24M());
            stmt.setInt(28, poblacionEdad.getP15A49F());
            stmt.setInt(29, poblacionEdad.getP60YMasF());
            stmt.setInt(30, poblacionEdad.getP60YMasM());
            

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

    public static int update(PoblacionEdad pobNueva, PoblacionEdad pobAnterior) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, pobNueva.getIdEntidad());
            stmt.setInt(2, pobNueva.getIdMunicipio());
            stmt.setInt(3, pobNueva.getIdLocalidad());
            
            stmt.setInt(4, pobNueva.getP0A2F());
            stmt.setInt(5, pobNueva.getP0A2M());
            stmt.setInt(6, pobNueva.getP3YMasF());
            stmt.setInt(7, pobNueva.getP3YMasM());
            stmt.setInt(8, pobNueva.getP5YMasF());
            stmt.setInt(9, pobNueva.getP5YMasM());
            stmt.setInt(10, pobNueva.getP12YMasF());
            stmt.setInt(11, pobNueva.getP12YMasM());
            stmt.setInt(12, pobNueva.getP15YMasF());
            stmt.setInt(13, pobNueva.getP15YMasM());
            stmt.setInt(14, pobNueva.getP18YMasF());
            stmt.setInt(15, pobNueva.getP18YMasM());
            
            stmt.setInt(16, pobNueva.getP3A5F());
            stmt.setInt(17, pobNueva.getP3A5M());
            stmt.setInt(18, pobNueva.getP6A11F());
            stmt.setInt(19, pobNueva.getP6A11M());
            stmt.setInt(20, pobNueva.getP8A14F());
            stmt.setInt(21, pobNueva.getP8A14M());
            stmt.setInt(22, pobNueva.getP12A14F());
            stmt.setInt(23, pobNueva.getP12A14M());
            stmt.setInt(24, pobNueva.getP15A17F());
            stmt.setInt(25, pobNueva.getP15A17M());
            stmt.setInt(26, pobNueva.getP18A24F());
            stmt.setInt(27, pobNueva.getP18A24M());
            stmt.setInt(28, pobNueva.getP15A49F());
            stmt.setInt(29, pobNueva.getP60YMasF());
            stmt.setInt(30, pobNueva.getP60YMasM());
            
            
            stmt.setInt(31, pobAnterior.getIdEntidad());
            stmt.setInt(32, pobAnterior.getIdMunicipio());
            stmt.setInt(33, pobAnterior.getIdLocalidad());

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

    public static int delete(PoblacionEdad poblacionEdad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, poblacionEdad.getIdEntidad());
            stmt.setInt(2, poblacionEdad.getIdMunicipio());
            stmt.setInt(3, poblacionEdad.getIdLocalidad());

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

    public static PoblacionEdad selectOne(PoblacionEdad poblacionEdad) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_WHERE);
            stmt.setInt(1, poblacionEdad.getIdEntidad());
            stmt.setInt(2, poblacionEdad.getIdMunicipio());
            stmt.setInt(3, poblacionEdad.getIdLocalidad());
            rs = stmt.executeQuery();

            if (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int idMunicipio = rs.getInt("idmunicipio");
                int idLocalidad = rs.getInt("idlocalidad");
                
                int p0A2F = rs.getInt("P_0A2_F");
                int p0A2M = rs.getInt("P_0A2_M");
                int p3YMasF = rs.getInt("P_3YMAS_F");
                int p3YMasM = rs.getInt("P_3YMAS_M");
                int p5YMasF = rs.getInt("P_5YMAS_F");
                int p5YMasM = rs.getInt("P_5YMAS_M");
                int p12YMasF = rs.getInt("P_12YMAS_F");
                int p12YMasM = rs.getInt("P_12YMAS_M");
                int p15YMasF = rs.getInt("P_15YMAS_F");
                int p15YMasM = rs.getInt("P_15YMAS_M");
                int p18YMasF = rs.getInt("P_18YMAS_F");
                int p18YMasM = rs.getInt("P_18YMAS_M");

                int p3A5F = rs.getInt("P_3A5_F");
                int p3A5M = rs.getInt("P_3A5_M");
                int p6A11F = rs.getInt("P_6A11_F");
                int p6A11M = rs.getInt("P_6A11_M");
                int p8A14F = rs.getInt("P_8A14_F");
                int p8A14M = rs.getInt("P_8A14_M");
                int p12A14F = rs.getInt("P_12A14_F");
                int p12A14M = rs.getInt("P_12A14_M");
                int p15A17F = rs.getInt("P_15A17_F");
                int p15A17M = rs.getInt("P_15A17_M");
                int p18A24F = rs.getInt("P_18A24_F");
                int p18A24M = rs.getInt("P_18A24_M");
                int p15A49F = rs.getInt("P_15A49_F");
                int p60YMasF = rs.getInt("P_60YMAS_F");
                int p60YMasM = rs.getInt("P_60YMAS_M");

                poblacionEdad = new PoblacionEdad(idEntidad, idMunicipio, idLocalidad);
                
                poblacionEdad.setP0A2F(p0A2F);
                poblacionEdad.setP0A2M(p0A2M);
                poblacionEdad.setP3YMasF(p3YMasF);
                poblacionEdad.setP3YMasM(p3YMasM);
                poblacionEdad.setP5YMasF(p5YMasF);
                poblacionEdad.setP5YMasM(p5YMasM);
                poblacionEdad.setP12YMasF(p12YMasF);
                poblacionEdad.setP12YMasM(p12YMasM);
                poblacionEdad.setP15YMasF(p15YMasF);
                poblacionEdad.setP15YMasM(p15YMasM);
                poblacionEdad.setP18YMasF(p18YMasF);
                poblacionEdad.setP18YMasM(p18YMasM);
                
                poblacionEdad.setP3A5F(p3A5F);
                poblacionEdad.setP3A5M(p3A5M);
                poblacionEdad.setP6A11F(p6A11F);
                poblacionEdad.setP6A11M(p6A11M);
                poblacionEdad.setP8A14F(p8A14F);
                poblacionEdad.setP8A14M(p8A14M);
                poblacionEdad.setP12A14F(p12A14F);
                poblacionEdad.setP12A14M(p12A14M);
                poblacionEdad.setP15A17F(p15A17F);
                poblacionEdad.setP15A17M(p15A17M);
                poblacionEdad.setP18A24F(p18A24F);
                poblacionEdad.setP18A24M(p18A24M);
                poblacionEdad.setP15A49F(p15A49F);
                poblacionEdad.setP60YMasF(p60YMasF);
                poblacionEdad.setP60YMasM(p60YMasM);
                
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

        return poblacionEdad;
    }

}
