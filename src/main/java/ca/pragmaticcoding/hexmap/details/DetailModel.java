package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.terrain.TerrainType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DetailModel {

    private final IntegerProperty row = new SimpleIntegerProperty(0);
    private final IntegerProperty column = new SimpleIntegerProperty(0);
    private final ObjectProperty<Integer> terrain = new SimpleObjectProperty<>(0);
    private final ObjectProperty<TerrainType> terrainType = new SimpleObjectProperty<>(TerrainType.NONE);

    public int getRow() {
        return row.get();
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public IntegerProperty rowProperty() {
        return row;
    }

    public int getColumn() {
        return column.get();
    }

    public void setColumn(int column) {
        this.column.set(column);
    }

    public IntegerProperty columnProperty() {
        return column;
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
}
