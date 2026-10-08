
package edu.highdt.inversionees.magdezis.controller;

import edu.highdt.inversionees.magdezis.repository.UsuarioRepository;
import edu.highdt.inversionees.magdezis.utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroController {
    
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    @FXML
    private void handleRegistrar(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();

        if (usuario.isEmpty() || password.isEmpty()) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Completa todos los campos");
            return;
        }

        if (usuarioRepository.registrar(usuario, password)) {
            lblMensaje.setStyle("-fx-text-fill: green;");
            lblMensaje.setText("¡Usuario registrado con éxito!");
            txtUsuario.clear();
            txtPassword.clear();
        } else {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Error al registrar (usuario ya existe)");
        }
    }

    @FXML
    private void handleVolver(ActionEvent event) {
        SceneManager.setScene(event, "login.fxml", "Iniciar Sesión");
    }
    
}
