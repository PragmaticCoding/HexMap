package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.terrain.TerrainType;
import ca.pragmaticcoding.hexmap.tile.Location;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DetailModel {

    private final ObjectProperty<Location> location = new SimpleObjectProperty<>();
    private final ObjectProperty<Integer> terrain = new SimpleObjectProperty<>(0);
    private final ObjectProperty<TerrainType> terrainType = new SimpleObjectProperty<>(TerrainType.NONE);

    public int getTerrain() {
        return terrain.get();
    }

    public void setTerrain(int terrain) {
        this.terrain.set(terrain);
    }

    public ObjectProperty<Integer> terrainProperty() {
        return terrain;
    }

    public TerrainType getTerrainType() {
        return terrainType.get();
    }

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType.set(terrainType);
    }

    public ObjectProperty<TerrainType> terrainTypeProperty() {
        return terrainType;
    }

    public Location getLocation() {
        return location.get();
    }

    public void setLocation(Location location) {
        this.location.set(location);
    }

    public ObjectProperty<Location> locationProperty() {
        return location;
    }
}
