package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.terrain.TerrainComboBox;
import ca.pragmaticcoding.hexmap.terrain.TerrainTypeComboBox;
import ca.pragmaticcoding.widgetsfx.TextWidgets;
import ca.pragmaticcoding.widgetsfx.TwoColumnGridPane;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.function.Consumer;

public class DetailViewBuilder implements Builder<Region> {

    private final DetailModel model;
    Consumer<Runnable> updateHandler;

    public DetailViewBuilder(DetailModel model, Consumer<Runnable> updateHandler) {
        this.model = model;
        this.updateHandler = updateHandler;
    }

    @Override
    public Region build() {
        TwoColumnGridPane gridPane = new TwoColumnGridPane();
        gridPane.addTextRow("Row:", model.rowProperty().asString());
        gridPane.addTextRow("Column:", model.columnProperty().asString());
        TerrainComboBox terrainSelector = new TerrainComboBox();
        terrainSelector.valueProperty().bindBidirectional(model.terrainProperty());
        gridPane.addRow("Terrain:", terrainSelector);
        TerrainTypeComboBox terrainTypeSelector = new TerrainTypeComboBox();
        terrainTypeSelector.valueProperty().bindBidirectional(model.terrainTypeProperty());
        gridPane.addRow("Colour:", terrainTypeSelector);
        Button updateButton = new Button("Update");
        updateButton.setOnAction(evt -> {
            updateButton.setDisable(true);
            updateHandler.accept(() -> updateButton.setDisable(false));
        });
        VBox results = new VBox(6, TextWidgets.styledText("Hex Details", "title-text"), gridPane, updateButton);
        results.setMinWidth(200);
        results.setAlignment(Pos.TOP_CENTER);
        return results;
    }
}
