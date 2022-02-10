package ca.pragmaticcoding.hexmap.tile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableDoubleValue;

public class TileModel {

    private final ObjectProperty<Integer> row = new SimpleObjectProperty<>(0);
    private final ObjectProperty<Integer> column = new SimpleObjectProperty<>(0);
    private final ObservableDoubleValue width;
    private final ObservableDoubleValue height;
    private final IntegerProperty terrain = new SimpleIntegerProperty(0);


    public TileModel(int row, int column, ObservableDoubleValue width, ObservableDoubleValue height) {
        this.row.set(row);
        this.column.set(column);
        this.width = width;
        this.height = height;
    }

    public Integer getRow() {
        return row.get();
    }

    public ObjectProperty<Integer> rowProperty() {
        return row;
    }

    public Integer getColumn() {
        return column.get();
    }

    public ObjectProperty<Integer> columnProperty() {
        return column;
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

    public IntegerProperty terrainProperty() {
        return terrain;
    }
}
