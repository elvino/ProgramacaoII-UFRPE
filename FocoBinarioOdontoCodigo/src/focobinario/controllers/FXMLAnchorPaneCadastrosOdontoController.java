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
import focobinario.negocio.beans.Odonto;

public class FXMLAnchorPaneCadastrosOdontoController implements Initializable {

    @FXML
    private TableView<Odonto> tableViewOdonto;
    @FXML
    private TableColumn<Odonto, String> tableColumnOdontoCRO;
    @FXML
    private TableColumn<Odonto, String> tableColumnOdontoNome;
    @FXML
    private TableColumn<Odonto, String> tableColumnOdontoEspec;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelOdontoCRO;
    @FXML
    private Label labelOdontoNome;
    @FXML
    private Label labelOdontoEspec;

    private List<Odonto> listOdonto;
    private ObservableList<Odonto> observableListOdonto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //fachada;
        carregarTableViewOdonto();

        tableViewOdonto.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewOdonto(newValue));
    }

    public void carregarTableViewOdonto() {
        tableColumnOdontoCRO.setCellValueFactory(new PropertyValueFactory<>("cro"));
        tableColumnOdontoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnOdontoEspec.setCellValueFactory(new PropertyValueFactory<>("espec"));

        listOdonto = null;//listar() listar odontos;

        //observableListOdonto = FXCollections.observableArrayList(listOdonto);
        //tableViewOdonto.setItems(observableListOdonto);
    }
    
    public void selecionarItemTableViewOdonto(Odonto odonto){
        if (odonto != null) {
            labelOdontoCRO.setText(String.valueOf(odonto.getCroOdonto()));
            labelOdontoNome.setText(odonto.getNomeOdonto());
            labelOdontoEspec.setText(odonto.getEspecialidadeOdonto());
            
        } else {
            labelOdontoCRO.setText("");
            labelOdontoNome.setText("");
            labelOdontoEspec.setText("");
        }
    }
    
    @FXML
    public void handleButtonInserir() throws IOException {
        Odonto odonto = new Odonto(1, "AA", "BB", "CC");
        boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosOdontoDialog(odonto);
        if (buttonConfirmarClicked) {
            //repository.inserir(odonto);
            carregarTableViewOdonto();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Odonto odonto = tableViewOdonto.getSelectionModel().getSelectedItem();
        if (odonto != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosOdontoDialog(odonto);
            if (buttonConfirmarClicked) {
                //repository.editar(odonto);
                carregarTableViewOdonto();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Odonto na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Odonto odonto = tableViewOdonto.getSelectionModel().getSelectedItem();
        if (odonto != null) {
            //repository.remover(odonto);
            carregarTableViewOdonto();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Odonto na Tabela!");
            alert.show();
        }
    }
    
    public boolean showFXMLAnchorPaneCadastrosOdontoDialog(Odonto odonto) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastrosOdontoDialogController.class.getResource("/focobinario/gui/FXMLAnchorPaneCadastrosOdontoDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Odonto");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        FXMLAnchorPaneCadastrosOdontoDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setOdonto(odonto);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
}
