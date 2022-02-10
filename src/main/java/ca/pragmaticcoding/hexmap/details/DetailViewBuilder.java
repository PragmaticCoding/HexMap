package ca.pragmaticcoding.hexmap.details;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class DetailViewBuilder implements Builder<Region> {

    private final DetailModel model;

    public DetailViewBuilder(DetailModel model) {
        this.model = model;
    }

    @Override
    public Region build() {
        Label rowLabel = new Label();
        rowLabel.textProperty().bind(model.rowProperty().asString());
        HBox rowBox = new HBox(new Label("Row:"), rowLabel);
        Label columnLabel = new Label();
        columnLabel.textProperty().bind(model.columnProperty().asString());
        HBox columnBox = new HBox(new Label("Column:"), columnLabel);
        VBox results = new VBox(6, rowBox, columnBox);
        results.setMinWidth(100);
        return results;
    }
}
