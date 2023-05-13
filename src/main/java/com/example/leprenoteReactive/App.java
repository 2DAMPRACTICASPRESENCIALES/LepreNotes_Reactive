package com.example.leprenoteReactive;

import com.example.leprenoteReactive.controller.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
            //Cargamos el controlador de la pantalla inicial
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/leprenotessceen.fxml"));
            loader.setController(new AppController());
            AnchorPane anchorPane = loader.load();

            //Dibujamos la pantalla
            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);
            stage.setTitle("Lepre Notes");
            stage.setResizable(false);
            stage.show();
    }

    public static void main(String[] args) {launch();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
