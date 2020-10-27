package focobinario.controllers;

import focobinario.negocio.beans.Odonto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class FXMLAnchorPaneLoginDialogController implements Initializable {

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Odonto odonto;
    @FXML
    private Label labelLoginSenha;
    @FXML
    private Label labelLoginNome;
    @FXML
    private TextField textFieldLoginNome;
    @FXML
    private PasswordField passFieldLoginSenha;
    @FXML
    private Button buttonEntrar;
    @FXML
    private Button buttonCancelar;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonEntrar.setOnAction(new EventHandler<ActionEvent>(){
            
            public void handle(ActionEvent event){
                if(textFieldLoginNome.getText().equals("admin") && 
                        passFieldLoginSenha.getText().equals("admin")){
                    Parent root = null;
                    Stage stage = new Stage();
                    try {
                        
                        
                        root = FXMLLoader.load(getClass().getResource("/focobinario/gui/FXMLVBoxMain.fxml"));
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLAnchorPaneLoginDialogController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Scene scene = new Scene(root);
        
                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("Login");
                    buttonEntrar.getScene().getWindow().hide();
                }
            }
        });
        
        buttonCancelar.setOnAction(new EventHandler<ActionEvent>(){
            
            public void handle(ActionEvent event){
                
                    
                    buttonEntrar.getScene().getWindow().hide();
                
            }
        });
    }    
}
