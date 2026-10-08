
package edu.highdt.inversionees.magdezis.controller;

import edu.highdt.inversionees.magdezis.repository.UsuarioRepository;
import edu.highdt.inversionees.magdezis.utils.SceneManager;
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

        if (usuarioRepository.autenticar(usuario, password)) {
            lblMensaje.setStyle("-fx-text-fill: green;");
            lblMensaje.setText("¡Inicio de sesión exitoso!");
           
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
