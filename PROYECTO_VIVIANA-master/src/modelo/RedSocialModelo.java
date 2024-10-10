package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RedSocialModelo {
    private DatabaseConnection databaseConnection;

    public RedSocialModelo(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void agregarRedSocial(String nombre, String enlace) {
        String sql = "INSERT INTO redes_sociales (nombre, enlace) VALUES (?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, enlace);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerRedesSociales() {
        List<String> redes = new ArrayList<>();
        String sql = "SELECT * FROM redes_sociales";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String red = "ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre")
                        + ", Enlace: " + resultSet.getString("enlace");
                redes.add(red);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return redes;
    }

    public void eliminarRedSocial(int redId) {
        String sql = "DELETE FROM redes_sociales WHERE id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, redId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
