
package main.java.edu.highdt.inversionees.magdezis.controller;

import main.java.edu.highdt.inversionees.magdezis.repository.UsuarioRepository;
import main.java.edu.highdt.inversionees.magdezis.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    @FXML
    private void handleLogin(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Por favor llena todos los campos");
            return;
        }

        // Consultamos el rol (Admin / Empleado) desde el repositorio
        String rol = usuarioRepository.obtenerRol(usuario, password);

        if (rol != null) {
            lblMensaje.setStyle("-fx-text-fill: green;");
            lblMensaje.setText("¡Bienvenido! Rol: " + rol.toUpperCase());
        } else {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Usuario o contraseña incorrectos");
        }
    }

    @FXML
    private void handleIrARegistro(ActionEvent event) {
        SceneManager.setScene(event, "registro.fxml", "Crear Nuevo Usuario");
    }
    
}
