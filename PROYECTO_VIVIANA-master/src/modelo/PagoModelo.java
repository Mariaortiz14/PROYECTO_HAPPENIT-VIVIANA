package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoModelo {
    private DatabaseConnection databaseConnection;

    public PagoModelo(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void agregarPago(int usuarioId, double monto, String metodo, String fecha) {
        String sql = "INSERT INTO pagos (usuario_id, monto, metodo, fecha) VALUES (?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            statement.setDouble(2, monto);
            statement.setString(3, metodo);
            statement.setString(4, fecha);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerPagosPorUsuario(int usuarioId) {
        List<String> pagos = new ArrayList<>();
        String sql = "SELECT * FROM pagos WHERE usuario_id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String pago = "ID: " + resultSet.getInt("id") + ", Monto: " + resultSet.getDouble("monto")
                        + ", Método: " + resultSet.getString("metodo") + ", Fecha: " + resultSet.getString("fecha");
                pagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }

    public void eliminarPago(int pagoId) {
        String sql = "DELETE FROM pagos WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pagoId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
