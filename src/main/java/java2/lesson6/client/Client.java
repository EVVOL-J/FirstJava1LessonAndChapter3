package java2.lesson6.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Client.class.getResource("hellofx.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        Network network=new Network();

        if (!network.connect()){
            showNetworkError("Ошибка подключения к серверу", "Ошибка сети");
        }

        Controller controller=loader.getController();
        controller.setNetwork(network);
        network.read(controller);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showNetworkError(String errorDetails, String errorTitle) {
        System.out.println(errorDetails+" "+errorTitle);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Network Error");
        alert.setHeaderText(errorTitle);
        alert.setContentText(errorDetails);
        alert.showAndWait();
    }

}
