
package main.java.edu.highdt.inversionees.magdezis.utils;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    
    public static void setScene(ActionEvent event, String fxmlFile, String title) {
        try {
          
            Parent root = FXMLLoader.load(SceneManager.class.getResource("/main/java/edu/highdt/inversionees/magdezis/resources/view/" + fxmlFile));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar la vista " + fxmlFile + ": " + e.getMessage());
        }
    }
    
}
