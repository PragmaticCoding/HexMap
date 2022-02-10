package ca.pragmaticcoding.hexmap;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class TerrainSprite extends ImageView {

    private final IntegerProperty imageIndex = new SimpleIntegerProperty(0);

    public TerrainSprite() {
        stuff();
    }

    private void stuff() {
        Image image = new Image(Objects.requireNonNull(TerrainSprite.class.getResource("/images/sprites-terrains.png")).toExternalForm());
        setImage(image);
        double cellSize = image.getWidth();
        setPreserveRatio(true);
        setOpacity(0.7);
        setViewport(new Rectangle2D(0, 0, cellSize, cellSize));
        imageIndex.addListener(observable -> setViewport(new Rectangle2D(0, cellSize * imageIndex.get(), cellSize, cellSize)));
    }

    public IntegerProperty imageIndexProperty() {
        return imageIndex;
    }
}
