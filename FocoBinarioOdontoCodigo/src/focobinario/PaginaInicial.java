package focobinario;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PaginaInicial extends Application {
    
    /**
     * Instância a Tela Principal
     */
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/focobinario/gui/FXMLVBoxLogin.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Foco Binario - Sistema Odonto");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Inicializa a Aplicação
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
