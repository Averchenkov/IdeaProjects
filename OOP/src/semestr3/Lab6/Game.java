package semestr3.Lab6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Game extends Application {

    int n;
    int number;
    @Override
    public void start(Stage stage) {

        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);

        Button button1 = new Button("Угадать");
        TextField str = new TextField();
        Random random = new Random();
        number = random.nextInt(21);
        n = 1;


        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if((n < 3) && (number < Integer.parseInt(str.getText()))){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText(null);
                    alert.setContentText("Меньше!");
                    alert.showAndWait();
                    n++;
                }
                else if((n < 3) && (number > Integer.parseInt(str.getText()))){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText(null);
                    alert.setContentText("Больше!");
                    alert.showAndWait();
                    n++;
                }
                else if((n <= 3) && (number == Integer.parseInt(str.getText()))){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Ура");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы угадали!");
                    alert.showAndWait();
                    stage.close();
                }
                else if((n >= 3) && (number != Integer.parseInt(str.getText()))){
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Конец");
                    alert.setHeaderText(null);
                    alert.setContentText("Вы исчерпали все попытки!");
                    alert.showAndWait();
                    stage.close();
                }
            }
        });

        root.getChildren().addAll(button1, str);

        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("Угадайка");
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }

}
