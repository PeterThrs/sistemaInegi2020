/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thrs.transaccional.conexion;

import com.thrs.repository.*;
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
public class LocalidadDaoTransaccional {
    
    private Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, idlocalidad, nom_localidad FROM localidades";
    private static final String SQL_INSERT = "INSERT INTO localidades (identidad, idmunicipio,idlocalidad, nom_localidad) values (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE localidades SET identidad = ?, idmunicipio =?, idlocalidad = ?,  nom_localidad = ? WHERE identidad = ? AND idmunicipio=? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_SELECT_WHERE = "SELECT * FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    //private static final String SQL_SELECT_LAST = "SELECT * FROM municipios ORDER BY identidad DESC LIMIT 1;";

    public LocalidadDaoTransaccional() {

    }

    public LocalidadDaoTransaccional(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Localidad> selectAll() throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Localidad localidad = null;
        List<Localidad> localidades = new ArrayList<>();

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
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
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return localidades;

    }

    public int insert(Localidad localidad) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_INSERT);
            stmt.setInt(1, localidad.getIdEntidad());
            stmt.setInt(2, localidad.getIdMunicipio());
            stmt.setInt(3,localidad.getIdLocalidad());
            stmt.setString(4, localidad.getNomLocalidad());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int update(Localidad locNueva, Localidad locAnterior) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, locNueva.getIdEntidad());
            stmt.setInt(2, locNueva.getIdMunicipio());
            stmt.setInt(3, locNueva.getIdLocalidad());
            stmt.setString(4, locNueva.getNomLocalidad());
            stmt.setInt(5, locAnterior.getIdEntidad());
            stmt.setInt(6, locAnterior.getIdMunicipio());
            stmt.setInt(7, locAnterior.getIdLocalidad());

            registros = stmt.executeUpdate();

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(coon);
            }
        }

        return registros;

    }

    public int delete(Localidad localidad) throws SQLException{
        Connection coon = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            coon = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = coon.prepareStatement(SQL_DELETE);
            stmt.setInt(1, localidad.getIdEntidad());
            stmt.setInt(2, localidad.getIdMunicipio());
            stmt.setInt(3, localidad.getIdLocalidad());

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
