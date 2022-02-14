package ca.pragmaticcoding.hexmap.counters;

import ca.pragmaticcoding.hexmap.terrain.TerrainSprite;
import javafx.scene.image.Image;

import java.util.Objects;

public enum CounterType {

    NONE("None", ""),
    CT1("CyberTank 1", "cybertank1"),
    CT2("CyberTank 1", "cybertank2"),
    CT3("CyberTank 1", "cybertank3"),
    HVTK("Heavy Tank", "tnkh1");

    public final Image image;
    public final String label;

    CounterType(String label, String resourceName) {
        this.label = label;
        if (!resourceName.isEmpty()) {
            this.image = new Image(Objects.requireNonNull(TerrainSprite.class.getResource("/images/" + resourceName + ".png")).toExternalForm());
        } else {
            this.image = null;
        }
    }
}
