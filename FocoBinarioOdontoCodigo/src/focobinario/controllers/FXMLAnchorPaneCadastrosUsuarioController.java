package focobinario.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import focobinario.negocio.beans.Usuario;

public class FXMLAnchorPaneCadastrosUsuarioController implements Initializable {

    @FXML
    private TableView<Usuario> tableViewUsuario;
    @FXML
    private TableColumn<Usuario, String> tableColumnUsuarioNome;
    @FXML
    private TableColumn<Usuario, String> tableColumnUsuarioTipo;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelUsuarioNome;
    @FXML
    private Label labelUsuarioTipo;

    private List<Usuario> listUsuario;
    private ObservableList<Usuario> observableListUsuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //fachada;
        carregarTableViewUsuario();

        tableViewUsuario.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewUsuario(newValue));
    }

    public void carregarTableViewUsuario() {
        tableColumnUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnUsuarioTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        listUsuario = null;//listar() listar usuarios;

        //observableListUsuario = FXCollections.observableArrayList(listUsuario);
        //tableViewUsuario.setItems(observableListUsuario);
    }
    
    public void selecionarItemTableViewUsuario(Usuario usuario){
        if (usuario != null) {
            labelUsuarioNome.setText(String.valueOf(usuario.getNomeUsuario()));
            labelUsuarioTipo.setText(usuario.getTipoUsuario());
            
        } else {
            labelUsuarioNome.setText("");
            labelUsuarioTipo.setText("");
        }
    }
    
    @FXML
    public void handleButtonInserir() throws IOException {
        Usuario usuario = new Usuario();
        boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosUsuarioDialog(usuario);
        if (buttonConfirmarClicked) {
            //repository.inserir(usuario);
            carregarTableViewUsuario();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Usuario usuario = tableViewUsuario.getSelectionModel().getSelectedItem();
        if (usuario != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosUsuarioDialog(usuario);
            if (buttonConfirmarClicked) {
                //repository.editar(usuario);
                carregarTableViewUsuario();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Usuario na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Usuario usuario = tableViewUsuario.getSelectionModel().getSelectedItem();
        if (usuario != null) {
            //repository.remover(usuario);
            carregarTableViewUsuario();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Usuario na Tabela!");
            alert.show();
        }
    }
    
    public boolean showFXMLAnchorPaneCadastrosUsuarioDialog(Usuario usuario) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastrosUsuarioDialogController.class.getResource("/focobinario/gui/FXMLAnchorPaneCadastrosUsuarioDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Usuario");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        FXMLAnchorPaneCadastrosUsuarioDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setUsuario(usuario);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
}
