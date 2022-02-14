package ca.pragmaticcoding.hexmap.tile;

import ca.pragmaticcoding.hexmap.counters.CounterType;
import ca.pragmaticcoding.hexmap.terrain.TerrainType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableDoubleValue;

public class TileModel {
    private final ObservableDoubleValue width;
    private final ObservableDoubleValue height;
    private final ObjectProperty<Integer> terrain = new SimpleObjectProperty<>(0);
    private final ObjectProperty<TerrainType> terrainType = new SimpleObjectProperty<>(TerrainType.NONE);
    private final BooleanProperty selected = new SimpleBooleanProperty(false);
    private final ObjectProperty<CounterType> occupier = new SimpleObjectProperty<>(CounterType.NONE);
    private final ObjectProperty<Location> location = new SimpleObjectProperty<>(null);


    public TileModel(Location location, ObservableDoubleValue width, ObservableDoubleValue height) {
        this.location.set(location);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width.get();
    }

    public ObservableDoubleValue widthProperty() {
        return width;
    }

    public double getHeight() {
        return height.get();
    }

    public ObservableDoubleValue heightProperty() {
        return height;
    }

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

    public boolean isSelected() {
        return selected.get();
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public CounterType getOccupier() {
        return occupier.get();
    }

    public void setOccupier(CounterType occupier) {
        this.occupier.set(occupier);
    }

    public ObjectProperty<CounterType> occupierProperty() {
        return occupier;
    }

    public Location getLocation() {
        return location.get();
    }

    public ObjectProperty<Location> locationProperty() {
        return location;
    }
}
