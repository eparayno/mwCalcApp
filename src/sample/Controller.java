package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class Controller {
    @FXML private TextField userMoleculeField;
    @FXML private TextArea totalMassOutputField;
    @FXML
    private void buttonPressed () throws FileNotFoundException {
        String value = userMoleculeField.getText();
        Calculator runCalculator = new Calculator(value);
        String totalMass = "" + runCalculator.totalMass;
        totalMassOutputField.setText("Your molecule's total mass is: " + totalMass + " g/mol");

    }

}
