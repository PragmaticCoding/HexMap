package ca.pragmaticcoding.hexmap.tile;

import ca.pragmaticcoding.hexmap.terrain.TerrainSprite;
import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;

public class HexTile extends StackPane {

    private final TileModel model;

    private final PseudoClass selected = PseudoClass.getPseudoClass("selected");

    public HexTile(TileModel model, Runnable clickHandler) {
        super();
        this.model = model;
        initialize();
        setOnMouseClicked(evt -> clickHandler.run());
    }

    private void initialize() {
        styleAndSizeTile();
        getChildren().addAll(createTerrainSprite(), createCoordinateLabel(), createOccupyingCounter());
    }

    private void styleAndSizeTile() {
        getStyleClass().add("hex-tile");
        maxHeightProperty().bind(model.heightProperty());
        maxWidthProperty().bind(model.widthProperty());
        minHeightProperty().bind(model.heightProperty());
        minWidthProperty().bind(model.widthProperty());
        setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null)));
        model.selectedProperty().addListener(observable -> pseudoClassStateChanged(selected, model.isSelected()));
        model.terrainTypeProperty().addListener(observable -> setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null))));
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
