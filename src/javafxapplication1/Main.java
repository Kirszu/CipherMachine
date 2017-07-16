package javafxapplication1;

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author marcin.kirsz
 */
public class Main extends Application {

    Stage window;
    Scene scene, sceneCaesar, sceneAffine, sceneVinegere;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        // Main scene
        VBox layout = new VBox(30);
        Scene scene = new Scene(layout, 320, 300);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());

        Button btnCaesar = new Button("0");
        btnCaesar.setText("Caesar Cipher");
        btnCaesar.setOnAction(e -> window.setScene(sceneCaesar));
        btnCaesar.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button btnAffine = new Button("1");
        btnAffine.setText("Affine Cipher");
        btnAffine.setOnAction(e -> window.setScene(sceneAffine));
        btnAffine.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Button btnVinegere = new Button("2");
        btnVinegere.setText("Vinegere Cipher");
        btnVinegere.setOnAction(e -> window.setScene(sceneVinegere));
        btnVinegere.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(btnCaesar, btnAffine, btnVinegere);

        // Caesar scene
        GridPane layoutCaesar = new GridPane();
        layoutCaesar.setPadding(new Insets(10, 10, 10, 10));
        layoutCaesar.setVgap(8);

        TextField caesarText = new TextField();
        GridPane.setConstraints(caesarText, 0, 1);
        caesarText.setMinSize(300, 60);
        caesarText.setPromptText("Insert your text here:");

        ChoiceBox<Integer> caesarKey = new ChoiceBox<>();
        GridPane.setConstraints(caesarKey, 0, 0);
        caesarKey.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);
        caesarKey.setValue(1);

        Button caesarReturn = new Button("Return");
        GridPane.setConstraints(caesarReturn, 0, 5);
        caesarReturn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        caesarReturn.setOnAction(e -> window.setScene(scene));

        Button caesarEncrypt = new Button("Encrypt");
        GridPane.setConstraints(caesarEncrypt, 0, 2);
        caesarEncrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        caesarEncrypt.setOnAction(e -> Caesar.caesarEncrypt(caesarText, caesarKey));

        Button caesarDecrypt = new Button("Decrypt");
        GridPane.setConstraints(caesarDecrypt, 0, 3);
        caesarDecrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        caesarDecrypt.setOnAction(e -> Caesar.caesarDecrypt(caesarText, caesarKey));

        layoutCaesar.getChildren().addAll(caesarKey, caesarText, caesarEncrypt, caesarDecrypt, caesarReturn);
        sceneCaesar = new Scene(layoutCaesar, 320, 300);
        sceneCaesar.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());

        // Affine scene
        GridPane layoutAffine = new GridPane();
        layoutAffine.setPadding(new Insets(10, 10, 10, 10));
        layoutAffine.setVgap(8);

        ChoiceBox<Integer> affineKeyA = new ChoiceBox<>();
        GridPane.setConstraints(affineKeyA, 0, 0);
        affineKeyA.getItems().addAll(1, 3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25);
        affineKeyA.setValue(1);

        ChoiceBox<Integer> affineKeyB = new ChoiceBox<>();
        GridPane.setConstraints(affineKeyB, 1, 0);
        affineKeyB.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
        affineKeyB.setValue(0);

        TextField affineText = new TextField();
        GridPane.setConstraints(affineText, 0, 2, 2, 1);
        affineText.setPromptText("Insert your text here:");
        affineText.setMinSize(300, 60);

        Button affineReturn = new Button("Return");
        GridPane.setConstraints(affineReturn, 0, 6, 2, 1);
        affineReturn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        affineReturn.setOnAction(e -> window.setScene(scene));

        Button affineEncrypt = new Button("Encrypt");
        GridPane.setConstraints(affineEncrypt, 0, 3, 2, 1);
        affineEncrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        affineEncrypt.setOnAction(e -> Affine.affineEncrypt(affineText, affineKeyA, affineKeyB));

        Button affineDecrypt = new Button("Decrypt");
        GridPane.setConstraints(affineDecrypt, 0, 4, 2, 1);
        affineDecrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        affineDecrypt.setOnAction(e -> Affine.affineDecrypt(affineText, affineKeyA, affineKeyB));

        layoutAffine.getChildren().addAll(affineKeyA, affineKeyB, affineText, affineEncrypt, affineDecrypt, affineReturn);
        sceneAffine = new Scene(layoutAffine, 320, 300);
        sceneAffine.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());

        //Vinegere scene
        GridPane layoutVinegere = new GridPane();
        layoutVinegere.setPadding(new Insets(10, 10, 10, 10));
        layoutVinegere.setVgap(8);

        TextField vinegereText = new TextField();
        vinegereText.setPromptText("Insert your text here:");
        vinegereText.setMinSize(300, 60);
        GridPane.setConstraints(vinegereText, 0, 0);

        TextField vinegereKey = new TextField();
        vinegereKey.setPromptText("Insert your keyword here:");
        vinegereKey.setMinSize(300, 60);
        GridPane.setConstraints(vinegereKey, 0, 1);

        Button vinegereReturn = new Button("Return");
        GridPane.setConstraints(vinegereReturn, 0, 5);
        vinegereReturn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vinegereReturn.setOnAction(e -> window.setScene(scene));

        Button vinegereEncrypt = new Button("Encrypt");
        GridPane.setConstraints(vinegereEncrypt, 0, 2);
        vinegereEncrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vinegereEncrypt.setOnAction(e -> Vinegere.vinegereEncrypt(vinegereText, vinegereKey));

        Button vinegereDecrypt = new Button("Decrypt");
        GridPane.setConstraints(vinegereDecrypt, 0, 3);
        vinegereDecrypt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vinegereDecrypt.setOnAction(e -> Vinegere.vinegereDecrypt(vinegereText, vinegereKey));

        layoutVinegere.getChildren().addAll(vinegereText, vinegereKey, vinegereEncrypt, vinegereDecrypt, vinegereReturn);
        sceneVinegere = new Scene(layoutVinegere, 320, 300);
        sceneVinegere.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());

        window.setTitle("Cipher Machine");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
