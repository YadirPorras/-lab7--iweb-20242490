package pe.edu.pucp.iweb.lab7.dao;

import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.edu.pucp.iweb.lab7.beans.EquipoAP;
import pe.edu.pucp.iweb.lab7.beans.EquipoRed;

public class EquipoDao extends BaseDao { // TODO 2a: debe heredar de BaseDao

    /**
     * Ejercicio 2c: retorna los equipos de la sede indicada, ordenados por sede y modelo.
     * Si idSede es 0, retorna todos los equipos.
     * <p>
     * Según la columna tipo, cree un objeto EquipoSwitch ('SWITCH') o EquipoAP ('AP').
     * Use PreparedStatement.
     */

    // TODO 2c
    public ArrayList<EquipoRed> listarPorSede(int idSede) {
        ArrayList<EquipoRed> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) { // executeQuery = SELECT
            while (rs.next()) {
                EquipoAP equipo = new EquipoAP(); // un bean por fila
                equipo.setIdEquipo(rs.getInt("equipo_id"));
                equipo.setModelo(rs.getString("equipo_modelo"));
                equipo.setTipo(rs.getString("equipo_tipo"));
                equipo.setPrecio(rs.getDouble("equipo_precio"));
                equipo.setCantidad(rs.getString("equipo_precio"))
                // Columnas con NULL: getObject(col, X.class) devuelve null real.
                // getInt devolveria 0 y se perderia la diferencia.
                lista.add();
                return lista;
            }
        }
    }
}