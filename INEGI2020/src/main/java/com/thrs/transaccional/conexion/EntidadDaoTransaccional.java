/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.conexion;

import static com.thrs.repository.Conexion.*;
import com.thrs.models.Entidad;
import com.thrs.repository.Conexion;
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
public class EntidadDaoTransaccional {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT identidad, nom_entidad FROM entidades";
    private static final String SQL_INSERT = "INSERT INTO entidades (identidad, nom_entidad) values (?,?)";
    private static final String SQL_UPDATE = "UPDATE entidades SET identidad = ?, nom_entidad = ? WHERE identidad=?";
    private static final String SQL_DELETE = "DELETE FROM entidades WHERE identidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM entidades WHERE identidad = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM entidades ORDER BY identidad DESC LIMIT 1;";

    public EntidadDaoTransaccional() {

    }

    public EntidadDaoTransaccional(Connection conexionTransaccinal) {
        this.conexionTransaccional = conexionTransaccinal;
    }

    public List<Entidad> selectAll() throws SQLException {
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Entidad entidad = null;
        List<Entidad> entidades = new ArrayList<>();

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int identidad = rs.getInt("identidad");
                String nomEntidad = rs.getString("nom_entidad");

                entidad = new Entidad(identidad, nomEntidad);
                entidades.add(entidad);

            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return entidades;

    }

    public int insert(Entidad entidad) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, entidad.getIdEntidad());
            stmt.setString(2, entidad.getNomEntidad());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int update(Entidad entidadNueva, Entidad entidadAnterior) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, entidadNueva.getIdEntidad());
            stmt.setString(2, entidadNueva.getNomEntidad());
            stmt.setInt(3, entidadAnterior.getIdEntidad());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int delete(Entidad entidad) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, entidad.getIdEntidad());

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
