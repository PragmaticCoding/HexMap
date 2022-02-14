package ca.pragmaticcoding.hexmap.terrain;

import javafx.scene.paint.Color;

public enum TerrainType {

    DESERT("Desert", Color.LIGHTYELLOW),
    FOREST("Forest", Color.FORESTGREEN),
    WATER("Water", Color.LIGHTSKYBLUE),
    NONE("None", Color.WHITE),
    GRASS("GrassLand", Color.LIGHTGREEN);


    public final String label;
    public final Color colour;

    TerrainType(String label, Color colour) {
        this.label = label;
        this.colour = colour;
    }

}
