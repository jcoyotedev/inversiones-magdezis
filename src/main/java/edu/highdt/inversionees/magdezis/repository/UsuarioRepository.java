
package main.java.edu.highdt.inversionees.magdezis.repository;


import main.java.edu.highdt.inversionees.magdezis.config.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {
    
    public String obtenerRol(String usuario, String password) {
        String sql = "SELECT r.nombre FROM usuarios u " +
                     "INNER JOIN roles r ON u.rol_id = r.id " +
                     "WHERE u.usuario = ? AND u.password = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener rol del usuario: " + e.getMessage());
        }
        return null;
    }

    /**
     * Registra un nuevo usuario asociándole un rol_id específico.
     */
    public boolean registrar(String usuario, String password, int rolId) {
        String sql = "INSERT INTO usuarios (usuario, password, rol_id) VALUES (?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario);
            stmt.setString(2, password);
            stmt.setInt(3, rolId);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
    
}
