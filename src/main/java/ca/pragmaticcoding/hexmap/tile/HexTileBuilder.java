package ca.pragmaticcoding.hexmap.tile;

import ca.pragmaticcoding.hexmap.terrain.TerrainSprite;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class HexTileBuilder implements Builder<Region> {

    private final TileModel model;

    private final PseudoClass selected = PseudoClass.getPseudoClass("selected");
    private final Runnable clickHandler;

    public HexTileBuilder(TileModel model, Runnable clickHandler) {
        super();
        this.model = model;
        this.clickHandler = clickHandler;
    }

    public Region build() {
        StackPane results = new StackPane();
        styleAndSizeTile(results);
        results.getChildren().addAll(createTerrainSprite(), createCoordinateLabel(), createOccupyingCounter());
        results.setOnMouseClicked(evt -> clickHandler.run());
        return results;
    }

    private void styleAndSizeTile(StackPane stackPane) {
        stackPane.getStyleClass().add("hex-tile");
        stackPane.maxHeightProperty().bind(model.heightProperty());
        stackPane.maxWidthProperty().bind(model.widthProperty());
        stackPane.minHeightProperty().bind(model.heightProperty());
        stackPane.minWidthProperty().bind(model.widthProperty());
        stackPane.setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null)));
        model.selectedProperty().addListener(observable -> stackPane.pseudoClassStateChanged(selected, model.isSelected()));
        model.terrainTypeProperty().addListener(observable -> stackPane.setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null))));
    }

    private TerrainSprite createTerrainSprite() {
        TerrainSprite terrainSprite = new TerrainSprite();
        terrainSprite.fitWidthProperty().bind(Bindings.multiply(model.widthProperty(), 0.75));
        terrainSprite.imageIndexProperty().bindBidirectional(model.terrainProperty());
        return terrainSprite;
    }

    private Label createCoordinateLabel() {
        Label position = new Label(model.getLocation().toString());
        position.getStyleClass().add("coordinate-label");
        StackPane.setAlignment(position, Pos.BOTTOM_CENTER);
        return position;
    }

    private ImageView createOccupyingCounter() {
        ImageView counterImage = new ImageView();
        counterImage.setPreserveRatio(true);
        counterImage.fitWidthProperty().bind(Bindings.multiply(model.widthProperty(), 0.75));
        counterImage.imageProperty().bind(Bindings.createObjectBinding(() -> model.getOccupier().image, model.occupierProperty()));
        return counterImage;
    }
}
