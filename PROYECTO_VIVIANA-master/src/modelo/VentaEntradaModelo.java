package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaEntradaModelo {
    private DatabaseConnection databaseConnection;

    public VentaEntradaModelo(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void agregarVentaEntrada(int eventoId, int usuarioId, int cantidad, double total) {
        String sql = "INSERT INTO ventas_entradas (evento_id, usuario_id, cantidad, total) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventoId);
            statement.setInt(2, usuarioId);
            statement.setInt(3, cantidad);
            statement.setDouble(4, total);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerVentasPorUsuario(int usuarioId) {
        List<String> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas_entradas WHERE usuario_id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String venta = "ID: " + resultSet.getInt("id") + ", Evento ID: " + resultSet.getInt("evento_id")
                        + ", Cantidad: " + resultSet.getInt("cantidad") + ", Total: " + resultSet.getDouble("total");
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public void eliminarVenta(int ventaId) {
        String sql = "DELETE FROM ventas_entradas WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ventaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaEntradaModelo {
    private DatabaseConnection databaseConnection;

    public VentaEntradaModelo(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void agregarVentaEntrada(int eventoId, int usuarioId, int cantidad, double total) {
        String sql = "INSERT INTO ventas_entradas (evento_id, usuario_id, cantidad, total) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, eventoId);
            statement.setInt(2, usuarioId);
            statement.setInt(3, cantidad);
            statement.setDouble(4, total);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerVentasPorUsuario(int usuarioId) {
        List<String> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas_entradas WHERE usuario_id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String venta = "ID: " + resultSet.getInt("id") + ", Evento ID: " + resultSet.getInt("evento_id")
                        + ", Cantidad: " + resultSet.getInt("cantidad") + ", Total: " + resultSet.getDouble("total");
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    public void eliminarVenta(int ventaId) {
        String sql = "DELETE FROM ventas_entradas WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ventaId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
