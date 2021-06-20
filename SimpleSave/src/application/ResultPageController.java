package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ResultPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label dailyDisplay;

    @FXML
    Label weeklyDisplay;

    @FXML
    Label monthlyDisplay;

    public void displayResults(LocalDate t, LocalDate e){
        long numOfDays = ChronoUnit.DAYS.between(t, e);
        System.out.println(numOfDays);

        DecimalFormat formatter = new DecimalFormat("#0.00");

        int moneyAmt = FirstPageController.moneyAmt;
        System.out.println(moneyAmt);

        double dailyAmt = (double)moneyAmt / (double)numOfDays;
        dailyDisplay.setText("$" + formatter.format(dailyAmt));

        double weeklyAmt = (double)moneyAmt/ (numOfDays/7);
        if(numOfDays >= 7) {
            weeklyDisplay.setText("$" + formatter.format(weeklyAmt));
        }

        double monthlyAmt = (double)moneyAmt/ (numOfDays/30);
        if(numOfDays >= 30) {
            monthlyDisplay.setText("$" + formatter.format(monthlyAmt));
        }

    }

    public void restart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartPage.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
