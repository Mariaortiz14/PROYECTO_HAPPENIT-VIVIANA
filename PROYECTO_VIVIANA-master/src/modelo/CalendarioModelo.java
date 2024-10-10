package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalendarioModelo {
    private Connection connection;

    public CalendarioModelo(DatabaseConnection databaseConnection) {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean agregarEventoAlCalendario(int idUsuario, int idEvento, String fecha) {
        String sql = "INSERT INTO calendario (id_usuario, id_evento, fecha) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, idEvento);
            statement.setString(3, fecha);
            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void cerrarConexion() {
        DatabaseConnection.closeConnection(connection);
    }
}
