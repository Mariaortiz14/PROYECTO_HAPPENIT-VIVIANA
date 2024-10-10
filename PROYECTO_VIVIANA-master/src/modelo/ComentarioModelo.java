package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComentarioModelo {
    private Connection connection;

    public ComentarioModelo(DatabaseConnection databaseConnection) {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean crearComentario(int idEvento, int idUsuario, String comentario) {
        String sql = "INSERT INTO comentarios (id_evento, id_usuario, comentario) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idEvento);
            statement.setInt(2, idUsuario);
            statement.setString(3, comentario);
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
