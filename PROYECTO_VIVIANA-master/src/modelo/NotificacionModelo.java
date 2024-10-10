package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificacionModelo {
    private DatabaseConnection databaseConnection;

    public NotificacionModelo(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Método para agregar una nueva notificación
    public void agregarNotificacion(String mensaje, int usuarioId, String fechaEnvio) {
        String query = "INSERT INTO notificaciones (mensaje, usuario_id, fecha_envio) VALUES (?, ?, ?)";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, mensaje);
            stmt.setInt(2, usuarioId);
            stmt.setString(3, fechaEnvio);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar notificación: " + e.getMessage());
        }
    }

    // Método para obtener todas las notificaciones de un usuario específico
    public List<String> obtenerNotificacionesPorUsuario(int usuarioId) {
        List<String> notificaciones = new ArrayList<>();
        String query = "SELECT mensaje FROM notificaciones WHERE usuario_id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                notificaciones.add(rs.getString("mensaje"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener notificaciones: " + e.getMessage());
        }

        return notificaciones;
    }

    // Método para eliminar una notificación
    public void eliminarNotificacion(int notificacionId) {
        String query = "DELETE FROM notificaciones WHERE id = ?";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, notificacionId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar notificación: " + e.getMessage());
        }
    }

    // Método para obtener todas las notificaciones
    public List<String> obtenerTodasLasNotificaciones() {
        List<String> notificaciones = new ArrayList<>();
        String query = "SELECT mensaje FROM notificaciones";

        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                notificaciones.add(rs.getString("mensaje"));
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener todas las notificaciones: " + e.getMessage());
        }

        return notificaciones;
    }
}
