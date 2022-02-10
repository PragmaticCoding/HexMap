package ca.pragmaticcoding.hexmap.tile;

import ca.pragmaticcoding.hexmap.TerrainSprite;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class HexTile extends StackPane {

    private final TileModel model;

    public HexTile(TileModel model, Runnable clickHandler) {
        super();
        this.model = model;
        initialize();
        setOnMouseClicked(evt -> clickHandler.run());
    }

    private void initialize() {
        getStyleClass().add("hex-tile");
        maxHeightProperty().bind(model.heightProperty());
        maxWidthProperty().bind(model.widthProperty());
        minHeightProperty().bind(model.heightProperty());
        minWidthProperty().bind(model.widthProperty());
        Label position = new Label(model.getRow() + ":" + model.getColumn());
        position.getStyleClass().add("coordinate-label");
        StackPane.setAlignment(position, Pos.BOTTOM_CENTER);
        getChildren().addAll(createTerrainSprite(), position);
    }

    private TerrainSprite createTerrainSprite() {
        TerrainSprite terrainSprite = new TerrainSprite();
        terrainSprite.fitWidthProperty().bind(Bindings.multiply(model.widthProperty(), 0.75));
        terrainSprite.imageIndexProperty().bind(model.terrainProperty());
        return terrainSprite;
    }
}
