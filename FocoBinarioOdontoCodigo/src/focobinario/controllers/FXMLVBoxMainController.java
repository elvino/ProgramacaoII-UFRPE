
package focobinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


public class FXMLVBoxMainController implements Initializable {

    @FXML
    private MenuItem menuItemCadastrosOdonto;
    @FXML
    private MenuItem menuItemCadastrosPaciente;
    @FXML
    private MenuItem menuItemCadastrosUsuario;
    @FXML
    private AnchorPane anchorPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void handleMenuItemCadastrosOdonto() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/focobinario/gui/FXMLAnchorPaneCadastrosOdonto.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemCadastrosPaciente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/focobinario/gui/FXMLAnchorPaneCadastrosPaciente.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemCadastrosUsuario() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/focobinario/gui/FXMLAnchorPaneCadastrosUsuario.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    
}
