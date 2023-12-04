/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.repository;

import com.thrs.models.Censo2020;
import com.thrs.models.PoblacionEdad;
import com.thrs.models.consultas.Estado;
import static com.thrs.repository.Conexion.close;
import static com.thrs.repository.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConsultasBD {

    ///NACIONAL ===================================================================================================
    private static final String SQL_SELECT_POB_TOTAL_NACIONAL = "SELECT SUM(pob_total) as pob_total,\n"
            + "SUM(pob_femenina) as pob_femenina,\n"
            + "SUM(pob_masculina) as pob_masculina\n"
            + "FROM censo2020";
    private static final String SQL_SELECT_POB0A14_NACIONAL = "SELECT SUM(P_0A2_F) + SUM(P_0A2_M) + SUM(P_3A5_F) + SUM(P_3A5_M) + SUM(P_6A11_F) + SUM(P_6A11_M) + SUM(P_12A14_F) + SUM(P_12A14_M) as pob_total_0A14,\n"
            + "SUM(P_0A2_F) + SUM(P_3A5_F) + SUM(P_6A11_F) + SUM(P_12A14_F) as total_mujeres_0A14,\n"
            + "SUM(P_0A2_M) + SUM(P_3A5_M) + SUM(P_6A11_M) + SUM(P_12A14_M) as total_hombres_0A14\n"
            + "FROM poblacion_edad;";
    private static final String SQL_SELECT_POB15A49_NACIONAL = "SELECT SUM(P_15A49_F) + SUM(P_15A17_M+P_18A24_M)  as pob_total_15A49,\n"
            + "SUM(P_15A49_F) as total_mujeres_15A49,\n"
            + "SUM(P_15A17_M+P_18A24_M) as total_hombres_15A49\n"
            + "FROM poblacion_edad;";
    private static final String SQL_SELECT_POB60YMAS_NACIONAL = "SELECT SUM(P_60YMAS_F) + SUM(P_60YMAS_M) as pob_total_60YMAS,\n"
            + "SUM(P_60YMAS_F) as total_mujeres_60YMAS,\n"
            + "SUM(P_60YMAS_M) as total_hombres_60YMAS\n"
            + "FROM poblacion_edad;";

    //ENTIDADES ==================================================================================================
    
    private static final String SQL_SELECT_POB_TOTAL = "SELECT entidades.identidad, entidades.nom_entidad, SUM(pob_total) as pob_total,\n"
            + "SUM(pob_femenina) as pob_femenina,\n"
            + "SUM(pob_masculina) as pob_masculina\n"
            + "FROM censo2020\n"
            + "INNER JOIN entidades ON censo2020.identidad = entidades.identidad \n"
            + "WHERE entidades.identidad = ? "
            + "GROUP BY censo2020.identidad";

    private static final String SQL_SELECT_POB0A14 = "SELECT entidades.identidad, SUM(P_0A2_F) + SUM(P_0A2_M) + SUM(P_3A5_F) + SUM(P_3A5_M) + SUM(P_6A11_F) + SUM(P_6A11_M) + SUM(P_12A14_F) + SUM(P_12A14_M) as pob_total_0A14,\n"
            + "SUM(P_0A2_F) + SUM(P_3A5_F) + SUM(P_6A11_F) + SUM(P_12A14_F) as total_mujeres_0A14,\n"
            + "SUM(P_0A2_M) + SUM(P_3A5_M) + SUM(P_6A11_M) + SUM(P_12A14_M) as total_hombres_0A14\n"
            + "FROM poblacion_edad\n"
            + "INNER JOIN entidades ON poblacion_edad.identidad = entidades.identidad \n"
            + "WHERE entidades.identidad = ? "
            + "GROUP BY poblacion_edad.identidad;";

    private static final String SQL_SELECT_POB15A49 = "SELECT entidades.identidad, SUM(P_15A49_F) + SUM(P_15A17_M+P_18A24_M)  as pob_total_15A49,\n"
            + "SUM(P_15A49_F) as total_mujeres_15A49,\n"
            + "SUM(P_15A17_M+P_18A24_M) as total_hombres_15A49\n"
            + "FROM poblacion_edad\n"
            + "INNER JOIN entidades ON poblacion_edad.identidad = entidades.identidad \n"
            + "WHERE entidades.identidad = ? "
            + "GROUP BY poblacion_edad.identidad";

    private static final String SQL_SELECT_POB60YMAS = "SELECT entidades.identidad, SUM(P_60YMAS_F) + SUM(P_60YMAS_M) as pob_total_60YMAS,\n"
            + "SUM(P_60YMAS_F) as total_mujeres_60YMAS,\n"
            + "SUM(P_60YMAS_M) as total_hombres_60YMAS\n"
            + "FROM poblacion_edad\n"
            + "INNER JOIN entidades ON poblacion_edad.identidad = entidades.identidad \n"
            + "WHERE entidades.identidad = ? "
            + "GROUP BY poblacion_edad.identidad";
    
    
    //METODOS PARA EL NACIONAL =============================================================================================
    
    public static Estado obtenerPobNacional() {
        Estado estado;

        Estado pobTotal = obtenerPobTotalNacional();
        Estado pob0A14 = obtenerPob0A14Nacional();
        Estado pob15A49 = obtenerPob15A49Nacional();
        Estado pob60Ymas = obtenerPob60YMasNacional();

            estado = new Estado();

            estado.setPobTotal(pobTotal.getPobTotal());
            estado.setTotalMujeres(pobTotal.getTotalMujeres());
            estado.setTotalHombres(pobTotal.getTotalHombres());

            estado.setPob0A14Total(pob0A14.getPob0A14Total());
            estado.setPob0A14Mujeres(pob0A14.getPob0A14Mujeres());
            estado.setPob0A14Hombres(pob0A14.getPob0A14Hombres());

            estado.setPob15A49Total(pob15A49.getPob15A49Total());
            estado.setPob15A49Mujeres(pob15A49.getPob15A49Mujeres());
            estado.setPob15A49Hombres(pob15A49.getPob15A49Hombres());

            estado.setPob60YMasTotal(pob60Ymas.getPob60YMasTotal());
            estado.setPob60YMasMujeres(pob60Ymas.getPob60YMasMujeres());
            estado.setPob60YMasHombres(pob60Ymas.getPob60YMasHombres());

        return estado;
    }
    
    public static Estado obtenerPobTotalNacional() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB_TOTAL_NACIONAL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int pobTotal = rs.getInt("pob_total");
                int pobFemenina = rs.getInt("pob_femenina");
                int pobMasculina = rs.getInt("pob_masculina");

                estado = new Estado();
                estado.setPobTotal(pobTotal);
                estado.setTotalMujeres(pobFemenina);
                estado.setTotalHombres(pobMasculina);

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

        return estado;

    }

    public static Estado obtenerPob0A14Nacional() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB0A14_NACIONAL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int pobTotal = rs.getInt("pob_total_0A14");
                int pobFemenina = rs.getInt("total_mujeres_0A14");
                int pobMasculina = rs.getInt("total_hombres_0A14");

                estado = new Estado();
                estado.setPob0A14Total(pobTotal);
                estado.setPob0A14Mujeres(pobFemenina);
                estado.setPob0A14Hombres(pobMasculina);

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

        return estado;

    }

    public static Estado obtenerPob15A49Nacional() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB15A49_NACIONAL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int pobTotal = rs.getInt("pob_total_15A49");
                int pobFemenina = rs.getInt("total_mujeres_15A49");
                int pobMasculina = rs.getInt("total_hombres_15A49");

                estado = new Estado();
                estado.setPob15A49Total(pobTotal);
                estado.setPob15A49Mujeres(pobFemenina);
                estado.setPob15A49Hombres(pobMasculina);
                
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

        return estado;

    }

    public static Estado obtenerPob60YMasNacional() {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB60YMAS_NACIONAL);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int pobTotal = rs.getInt("pob_total_60YMAS");
                int pobFemenina = rs.getInt("total_mujeres_60YMAS");
                int pobMasculina = rs.getInt("total_hombres_60YMAS");

                estado = new Estado();
                estado.setPob60YMasTotal(pobTotal);
                estado.setPob60YMasMujeres(pobFemenina);
                estado.setPob60YMasHombres(pobMasculina);

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

        return estado;

    }

    
    
    // METODOS PARA LAS ENTIDADES ===============================================================================================

    public static Estado obtenerPobEstado(int id) {
        HashMap<String, Estado> mapa = new HashMap<>();
        Estado estado;

        Estado pobTotal = obtenerPobTotal(id);
        Estado pob0A14 = obtenerPob0A14(id);
        Estado pob15A49 = obtenerPob15A49(id);
        Estado pob60Ymas = obtenerPob60YMas(id);
            estado = new Estado();
            
            if(pobTotal == null || pob0A14 == null || pob15A49 == null || pob60Ymas == null){
                return estado;
            }

            estado.setIdEntidad(pobTotal.getIdEntidad());
            estado.setEstado(pobTotal.getEstado());
            estado.setPobTotal(pobTotal.getPobTotal());
            estado.setTotalMujeres(pobTotal.getTotalMujeres());
            estado.setTotalHombres(pobTotal.getTotalHombres());

            estado.setPob0A14Total(pob0A14.getPob0A14Total());
            estado.setPob0A14Mujeres(pob0A14.getPob0A14Mujeres());
            estado.setPob0A14Hombres(pob0A14.getPob0A14Hombres());

            estado.setPob15A49Total(pob15A49.getPob15A49Total());
            estado.setPob15A49Mujeres(pob15A49.getPob15A49Mujeres());
            estado.setPob15A49Hombres(pob15A49.getPob15A49Hombres());

            estado.setPob60YMasTotal(pob60Ymas.getPob60YMasTotal());
            estado.setPob60YMasMujeres(pob60Ymas.getPob60YMasMujeres());
            estado.setPob60YMasHombres(pob60Ymas.getPob60YMasHombres());
            
        return estado;
    }

    public static Estado obtenerPobTotal(int id) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;
        //List<Estado> listaEstados = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB_TOTAL);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                String nombreEntidad = rs.getString("nom_entidad");
                int pobTotal = rs.getInt("pob_total");
                int pobFemenina = rs.getInt("pob_femenina");
                int pobMasculina = rs.getInt("pob_masculina");

                estado = new Estado();
                estado.setIdEntidad(idEntidad);
                estado.setEstado(nombreEntidad);
                estado.setPobTotal(pobTotal);
                estado.setTotalMujeres(pobFemenina);
                estado.setTotalHombres(pobMasculina);

                //listaEstados.add(estado);

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

        return estado;

    }

    public static Estado obtenerPob0A14(int id) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;
        //List<Estado> listaEstados = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB0A14);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int pobTotal = rs.getInt("pob_total_0A14");
                int pobFemenina = rs.getInt("total_mujeres_0A14");
                int pobMasculina = rs.getInt("total_hombres_0A14");

                estado = new Estado();
                estado.setIdEntidad(idEntidad);
                estado.setPob0A14Total(pobTotal);
                estado.setPob0A14Mujeres(pobFemenina);
                estado.setPob0A14Hombres(pobMasculina);

                //listaEstados.add(estado);

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

        return estado;

    }

    public static Estado obtenerPob15A49(int id) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;
        //List<Estado> listaEstados = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB15A49);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int pobTotal = rs.getInt("pob_total_15A49");
                int pobFemenina = rs.getInt("total_mujeres_15A49");
                int pobHombres = rs.getInt("total_hombres_15A49");

                estado = new Estado();
                estado.setIdEntidad(idEntidad);
                estado.setPob15A49Total(pobTotal);
                estado.setPob15A49Mujeres(pobFemenina);
                estado.setPob15A49Hombres(pobHombres);

                //listaEstados.add(estado);

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

        return estado;

    }

    public static Estado obtenerPob60YMas(int id) {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado estado = null;
        //List<Estado> listaEstados = new ArrayList<>();

        try {
            coon = getConnection();
            stmt = coon.prepareStatement(SQL_SELECT_POB60YMAS);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEntidad = rs.getInt("identidad");
                int pobTotal = rs.getInt("pob_total_60YMAS");
                int pobFemenina = rs.getInt("total_mujeres_60YMAS");
                int pobMasculina = rs.getInt("total_hombres_60YMAS");

                estado = new Estado();
                estado.setIdEntidad(idEntidad);
                estado.setPob60YMasTotal(pobTotal);
                estado.setPob60YMasMujeres(pobFemenina);
                estado.setPob60YMasHombres(pobMasculina);

                //listaEstados.add(estado);

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

        return estado;

    }

}
