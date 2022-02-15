package ca.pragmaticcoding.hexmap.terrain;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class TerrainSprite extends ImageView {

    private final ObjectProperty<Integer> imageIndex = new SimpleObjectProperty<>(0);

    public TerrainSprite() {
        initialize();
    }

    private void initialize() {
        Image image = new Image(Objects.requireNonNull(TerrainSprite.class.getResource("/images/sprites-terrains.png")).toExternalForm());
        setImage(image);
        double cellSize = image.getWidth();
        setPreserveRatio(true);
        setOpacity(0.8);
        setViewport(new Rectangle2D(0, 0, cellSize, cellSize));
        imageIndex.addListener(observable -> setViewport(new Rectangle2D(0, cellSize * imageIndex.get(), cellSize, cellSize)));
    }

    public ObjectProperty<Integer> imageIndexProperty() {
        return imageIndex;
    }
}
