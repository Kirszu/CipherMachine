package javafxapplication1;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 *
 * @author marcin.kirsz
 */
public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(125);

        TextField result = new TextField();
        result.setText(message);
        result.setStyle("-fx-text-inner-color: #455A64; -fx-font-size: 16px;");
        result.setMinSize(125, 50);

        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-base: #90A4AE; -fx-text-fill: #ECEFF1; -fx-font-size: 16px;");
        closeButton.setOnAction(e -> window.close());

        VBox alertBoxLayout = new VBox(10);
        alertBoxLayout.setStyle("-fx-background-color: #455A64; -fx-base: #90A4AE;");
        alertBoxLayout.getChildren().addAll(result, closeButton);
        alertBoxLayout.setAlignment(Pos.CENTER);

        Scene alertBox = new Scene(alertBoxLayout);
        window.setScene(alertBox);
        window.setResizable(false);
        window.showAndWait();
    }
}
