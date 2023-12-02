/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.conexion;

import com.thrs.repository.*;
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
public class MunicipioDaoTransaccional {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, nom_municipio FROM municipios";
    private static final String SQL_INSERT = "INSERT INTO municipios (identidad, idmunicipio, nom_municipio) values (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE municipios SET identidad = ?, idmunicipio =?,  nom_municipio = ? WHERE identidad = ? AND idmunicipio=?";
    private static final String SQL_DELETE = "DELETE FROM municipios WHERE identidad = ? AND idmunicipio = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM municipios WHERE identidad = ? AND idmunicipio = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM municipios ORDER BY identidad DESC LIMIT 1;";

    public MunicipioDaoTransaccional() {

    }

    public MunicipioDaoTransaccional(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Municipio> selectAll() throws SQLException {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Municipio municipio = null;
        List<Municipio> municipios = new ArrayList<>();

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                String nomMunicipio = rs.getString("nom_municipio");

                municipio = new Municipio(identidad, idmunicipio, nomMunicipio);
                municipios.add(municipio);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return municipios;

    }

    public int insert(Municipio municipio) throws SQLException {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, municipio.getIdEntidad());
            stmt.setInt(2, municipio.getIdMunicipio());
            stmt.setString(3, municipio.getNomMunicipio());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int update(Municipio munNuevo, Municipio munAnterior) throws SQLException {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, munNuevo.getIdEntidad());
            stmt.setInt(2, munNuevo.getIdMunicipio());
            stmt.setString(3, munNuevo.getNomMunicipio());
            stmt.setInt(4, munAnterior.getIdEntidad());
            stmt.setInt(5, munAnterior.getIdMunicipio());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int delete(Municipio municipio) throws SQLException {
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, municipio.getIdEntidad());
            stmt.setInt(2, municipio.getIdMunicipio());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

}
