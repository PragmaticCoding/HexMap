package ca.pragmaticcoding.hexmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HexMapApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hexagons!");
        stage.setScene(new Scene(new HexMapController().getView()));
        stage.show();
    }
}