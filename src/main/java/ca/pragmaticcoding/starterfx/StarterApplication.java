package ca.pragmaticcoding.starterfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class StarterApplication extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Starter Application");
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    private Region createContent() {
        Label label = new Label("Starter Application");
        label.getStyleClass().add("red-box-label");
        VBox vBox = new VBox(label);
        vBox.setPadding(new Insets(40));
        vBox.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/css/starter.css")).toString());
        return vBox;
    }
}