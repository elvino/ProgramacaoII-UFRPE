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
import focobinario.negocio.beans.Paciente;

public class FXMLAnchorPaneCadastrosPacienteController implements Initializable {

    @FXML
    private TableView<Paciente> tableViewPaciente;
    @FXML
    private TableColumn<Paciente, String> tableColumnPacienteNome;
    @FXML
    private TableColumn<Paciente, String> tableColumnPacienteRG;
    @FXML
    private TableColumn<Paciente, String> tableColumnPacienteIdade;
    @FXML
    private TableColumn<Paciente, String> tableColumnPacienteEndereco;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelPacienteNome;
    @FXML
    private Label labelPacienteRG;
    @FXML
    private Label labelPacienteEndereco;
    @FXML
    private Label labelPacienteIdade;

    private List<Paciente> listPaciente;
    private ObservableList<Paciente> observableListPaciente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //fachada
        carregarTableViewPaciente();

        tableViewPaciente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewPaciente(newValue));
    }

    public void carregarTableViewPaciente() {
        tableColumnPacienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPacienteRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        tableColumnPacienteIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tableColumnPacienteEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        listPaciente = null;//listar() listar pacientes;

        ///observableListPaciente = FXCollections.observableArrayList(listPaciente);
        ///tableViewPaciente.setItems(observableListPaciente);
    }
    
    public void selecionarItemTableViewPaciente(Paciente paciente){
        if (paciente != null) {
            labelPacienteNome.setText(String.valueOf(paciente.getNomePaciente()));
            labelPacienteRG.setText(paciente.getRgPaciente());
            labelPacienteEndereco.setText(paciente.getEnderecoPaciente());
            labelPacienteIdade.setText(paciente.getIdadePaciente());
            
        } else {
            labelPacienteNome.setText("");
            labelPacienteRG.setText("");
            labelPacienteEndereco.setText("");
            labelPacienteIdade.setText("");
        }
    }
    
    @FXML
    public void handleButtonInserir() throws IOException {
        Paciente paciente = new Paciente();
        boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosPacienteDialog(paciente);
        if (buttonConfirmarClicked) {
            //repository.inserir(paciente);
            carregarTableViewPaciente();
        }
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        Paciente paciente = tableViewPaciente.getSelectionModel().getSelectedItem();
        if (paciente != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosPacienteDialog(paciente);
            if (buttonConfirmarClicked) {
                //repository.editar(paciente);
                carregarTableViewPaciente();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Paciente na Tabela!");
            alert.show();
        }
    }

    @FXML
    public void handleButtonRemover() throws IOException {
        Paciente paciente = tableViewPaciente.getSelectionModel().getSelectedItem();
        if (paciente != null) {
            //repository.remover(paciente);
            carregarTableViewPaciente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Paciente na Tabela!");
            alert.show();
        }
    }
    
    public boolean showFXMLAnchorPaneCadastrosPacienteDialog(Paciente paciente) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastrosPacienteDialogController.class.getResource("/focobinario/gui/FXMLAnchorPaneCadastrosPacienteDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de Paciente");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        FXMLAnchorPaneCadastrosPacienteDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPaciente(paciente);

        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }
}
