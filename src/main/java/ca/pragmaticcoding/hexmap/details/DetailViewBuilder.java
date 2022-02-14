package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.terrain.TerrainComboBox;
import ca.pragmaticcoding.hexmap.terrain.TerrainTypeComboBox;
import ca.pragmaticcoding.widgetsfx.TextWidgets;
import ca.pragmaticcoding.widgetsfx.TwoColumnGridPane;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class DetailViewBuilder implements Builder<Region> {

    private final DetailModel model;
    private final Runnable updateHandler;

    public DetailViewBuilder(DetailModel model, Runnable updateHandler) {
        this.model = model;
        this.updateHandler = updateHandler;
    }

    @Override
    public Region build() {
        TwoColumnGridPane gridPane = new TwoColumnGridPane();
        gridPane.addTextRow("Location:", model.locationProperty().asString());
        TerrainComboBox terrainSelector = new TerrainComboBox();
        terrainSelector.valueProperty().bindBidirectional(model.terrainProperty());
        gridPane.addRow("Terrain:", terrainSelector);
        TerrainTypeComboBox terrainTypeSelector = new TerrainTypeComboBox();
        terrainTypeSelector.valueProperty().bindBidirectional(model.terrainTypeProperty());
        gridPane.addRow("Type:", terrainTypeSelector);
        gridPane.addEventFilter(ActionEvent.ANY, evt -> updateHandler.run());
        VBox results = new VBox(6, TextWidgets.styledText("Hex Details", "title-text"), gridPane);
        results.setMinWidth(200);
        results.setAlignment(Pos.TOP_CENTER);
        return results;
    }
}
