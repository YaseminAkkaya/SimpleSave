package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SecondPageController {
    @FXML
    private DatePicker todaysDatePicker;
    @FXML
    private DatePicker endDatePicker;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private LocalDate today;
    private LocalDate endDate;

    public void enterDates(ActionEvent event) throws IOException {
        today = todaysDatePicker.getValue();
        endDate = endDatePicker.getValue();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultPage.fxml"));
        root = loader.load();

        ResultPageController rpc = loader.getController();
        rpc.displayResults(today, endDate);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
