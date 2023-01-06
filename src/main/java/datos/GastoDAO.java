package datos;

import static datos.Conexion.*;
import domain.Gasto;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GastoDAO {

    private static final String SQL_SELECT = "SELECT id_gasto,tipo_gasto,detalle,valor,fecha FROM mis_gastos";
    private static final String SQL_INSERT = "INSERT INTO mis_gastos(tipo_gasto,detalle,valor,fecha) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE mis_gastos SET valor= ? WHERE id_gasto=?";
    private static final String SQL_DELETE = "DELETE FROM mis_gastos WHERE id_gasto=?";

    public List<Gasto> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rst = null;
        Gasto gasto = null;
        List<Gasto> gastos = new ArrayList<>();
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rst = stmt.executeQuery();
            while (rst.next()) {
                int idGasto = rst.getInt("id_gasto");
                String tipoGasto = rst.getString("tipo_gasto");
                String detalle = rst.getString("detalle");
                int valor = rst.getInt("valor");
                String fecha = rst.getString("fecha");
                gasto = new Gasto(idGasto, tipoGasto, detalle, valor, fecha);
                gastos.add(gasto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rst);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return gastos;
    }

    public int insertar(Gasto gasto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, gasto.getTipoGasto());
            stmt.setString(2, gasto.getDetalle());
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFecha());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int modificar(Gasto gasto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, gasto.getTipoGasto());
            stmt.setString(2, gasto.getDetalle());
            stmt.setDouble(3, gasto.getValor());
            stmt.setString(4, gasto.getFecha());
            stmt.setInt(5, gasto.getIdGasto());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
        public int eliminar(Gasto gasto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, gasto.getIdGasto());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
