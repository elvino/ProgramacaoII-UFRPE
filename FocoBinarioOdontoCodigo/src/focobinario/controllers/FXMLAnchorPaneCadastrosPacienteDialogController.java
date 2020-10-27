package focobinario.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import focobinario.negocio.beans.Paciente;

public class FXMLAnchorPaneCadastrosPacienteDialogController implements Initializable {

    @FXML
    private Label labelPacienteNome;
    @FXML
    private Label labelPacienteRG;
    @FXML
    private Label labelPacienteEndereco;
    @FXML
    private Label labelPacienteIdade;
    @FXML
    private TextField textFieldPacienteNome;
    @FXML
    private TextField textFieldPacienteRG;
    @FXML
    private TextField textFieldPacienteEndereco;
    @FXML
    private TextField textFieldPacienteIdade;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Paciente paciente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.textFieldPacienteNome.setText(paciente.getNomePaciente());
        this.textFieldPacienteRG.setText(paciente.getRgPaciente());
        this.textFieldPacienteEndereco.setText(paciente.getEnderecoPaciente());
        this.textFieldPacienteIdade.setText(paciente.getIdadePaciente());
    }

    @FXML
    public void handleButtonConfirmar() {

        if (validarEntradaDeDados()) {

            paciente.setNomePaciente(textFieldPacienteNome.getText());
            paciente.setRgPaciente(textFieldPacienteRG.getText());
            paciente.setEnderecoPaciente(textFieldPacienteEndereco.getText());
            paciente.setIdadePaciente(textFieldPacienteIdade.getText());

            buttonConfirmarClicked = true;
            dialogStage.close();
        }

    }

    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldPacienteNome.getText() == null || textFieldPacienteNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldPacienteRG.getText() == null || textFieldPacienteRG.getText().length() == 0) {
            errorMessage += "RG inválido!\n";
        }
        if (textFieldPacienteEndereco.getText() == null || textFieldPacienteEndereco.getText().length() == 0) {
            errorMessage += "Endereco inválido!\n";
        }
        if (textFieldPacienteIdade.getText() == null || textFieldPacienteIdade.getText().length() == 0) {
            errorMessage += "Idade inválido!\n";
        }
        

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
}
