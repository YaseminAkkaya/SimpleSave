package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {
    @FXML
    private TextField amountTextField;
    @FXML
    private Button nextButton;
    @FXML
    private Label amountTitle;

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int moneyAmt;

    public void enterAmt(ActionEvent event){

        try {
            moneyAmt = Integer.parseInt(amountTextField.getText());
            System.out.println(moneyAmt);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondPage.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(NumberFormatException e){
            nextButton.setText("Enter an Integer!");
        }
        catch(Exception e){
            amountTitle.setText("Error");
        }
    }

    public int moneyAmt() {
        return moneyAmt;
    }
}
