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
import focobinario.negocio.beans.Odonto;

public class FXMLAnchorPaneCadastrosOdontoDialogController implements Initializable {

    @FXML
    private Label labelOdontoCRO;
    @FXML
    private Label labelOdontoNome;
    @FXML
    private Label labelOdontoEspec;
    @FXML
    private TextField textFieldOdontoCRO;
    @FXML
    private TextField textFieldOdontoNome;
    @FXML
    private TextField textFieldOdontoEspec;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Odonto odonto;

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

    public Odonto getOdonto() {
        return odonto;
    }

    public void setOdonto(Odonto odonto) {
        this.odonto = odonto;
        this.textFieldOdontoCRO.setText(odonto.getCroOdonto());
        this.textFieldOdontoNome.setText(odonto.getNomeOdonto());
        this.textFieldOdontoEspec.setText(odonto.getEspecialidadeOdonto());
    }

    @FXML
    public void handleButtonConfirmar() {

        if (validarEntradaDeDados()) {

            odonto.setCroOdonto(textFieldOdontoCRO.getText());
            odonto.setNomeOdonto(textFieldOdontoNome.getText());
            odonto.setEspecialidadeOdonto(textFieldOdontoEspec.getText());

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

        if (textFieldOdontoCRO.getText() == null || textFieldOdontoCRO.getText().length() == 0) {
            errorMessage += "CRO inválido!\n";
        }
        if (textFieldOdontoNome.getText() == null || textFieldOdontoNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (textFieldOdontoEspec.getText() == null || textFieldOdontoEspec.getText().length() == 0) {
            errorMessage += "Especialidade inválido!\n";
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
