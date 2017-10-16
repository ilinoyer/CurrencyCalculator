package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        CurrencyCollection collection = new CurrencyCollection();
        ParseXML parser = new ParseXMLDocument(collection);
        parser.CreateCurrencyCollection();


        collection.AddElementToCollection(new Currency("polski złoty", 1, "PLN", 1));
        Calculations calculations = new Calculations(collection);
        GridPane root = new GridPane();

        Label title = new Label("           Kalkulator Walut"); // do zmiany
        title.setFont(new Font("Arial", 46));
        title.setMinSize(600,66);
        root.add(title,1,1,2,1);

        Label amount = new Label("\tKwota: ");
        amount.setMinSize(300,66);
        amount.setFont(new Font("Arial", 23));
        root.add(amount, 1,2);

        Label calulateFrom = new Label("\tPrzelicz z: ");
        calulateFrom.setMinSize(300,66);
        calulateFrom.setFont(new Font("Arial", 23));
        root.add(calulateFrom, 1,3);

        Label calulateTo = new Label("\tPrzelicz na: ");
        calulateTo.setMinSize(300,66);
        calulateTo.setFont(new Font("\tArial", 23));
        root.add(calulateTo, 1,4);

        Label calulateAs = new Label("\tPrzelicz wg: ");
        calulateAs.setMinSize(300,66);
        calulateAs.setFont(new Font("Arial", 23));
        root.add(calulateAs, 1,5);

        TextField amountField = new TextField();
        amountField.setMaxSize(200,33);
        root.add(amountField, 2, 2);

        ComboBox<String> calculateToBox = new ComboBox<>();
        ComboBox<String> calculateFromBox = new ComboBox<>();
        ComboBox<String> calculateAsBox = new ComboBox<>();

        calculateAsBox.setValue("Kurs średni");
        calculateAsBox.setDisable(true);
        calculateAsBox.setStyle("-fx-opacity: 1;");
        calculateFromBox.setValue("THB - bat (Tajlandia)");
        calculateToBox.setValue("THB - bat (Tajlandia)");

        Button calculate = new Button("Przelicz");
        root.add(calculate,2,6);


        for(int i = 0 ; i < collection.GetCollectionSize(); ++i)
        {
            calculateFromBox.getItems().add(collection.GetCollectionElementByPosition(i).GetCode() +  " - " + collection.GetCollectionElementByPosition(i).getCurrencyName());
            calculateToBox.getItems().add(collection.GetCollectionElementByPosition(i).GetCode() + " - " + collection.GetCollectionElementByPosition(i).getCurrencyName());
        }

        calculateFromBox.setMinSize(200,33);
        root.add(calculateFromBox, 2,3);

        calculateToBox.setMinSize(200,33);
        root.add(calculateToBox, 2,4);

        calculateAsBox.setMinSize(200,33);
        root.add(calculateAsBox, 2,5);

        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

        calculate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Double result = 0.0;
                try {
                    result = calculations.CalculateTransaction(calculateFromBox.getValue(), calculateToBox.getValue(), Double.parseDouble(amountField.getText()));

                    Alert alert = new Alert(Alert.AlertType.NONE, amountField.getText() + " " + calculateFromBox.getValue().substring(0,3) + "  =  " + result.toString() + " " +calculateToBox.getValue().substring(0,3), ButtonType.OK);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.OK) {
                        alert.close();
                    }

                }catch(Exception e)
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wprowadz poprawną kwotę. ",ButtonType.OK);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.OK) {
                        alert.close();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }

}
