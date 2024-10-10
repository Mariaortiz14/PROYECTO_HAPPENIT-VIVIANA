package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventoModelo {
    private Connection connection;

    public EventoModelo(DatabaseConnection databaseConnection) {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean crearEvento(String nombre, String fecha, String ubicacion, String descripcion) {
        String sql = "INSERT INTO eventos (nombre, fecha, ubicacion, descripcion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, fecha);
            statement.setString(3, ubicacion);
            statement.setString(4, descripcion);
            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Evento obtenerEventoPorId(int id) {
        String sql = "SELECT * FROM eventos WHERE id = ?";
        Evento evento = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                evento = new Evento(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("fecha"),
                        resultSet.getString("ubicacion"),
                        resultSet.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evento;
    }

    public void cerrarConexion() {
        DatabaseConnection.closeConnection(connection);
    }
}
