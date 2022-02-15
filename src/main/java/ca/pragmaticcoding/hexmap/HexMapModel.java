package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HexMapModel {
    private final DoubleProperty hexWidth = new SimpleDoubleProperty(60.0);
    private final ObservableDoubleValue hexHeight;
    private final ObservableList<TileModel> tileModels = FXCollections.observableArrayList();
    private final ObjectProperty<TileModel> activeTile = new SimpleObjectProperty<>();

    public HexMapModel() {
        hexHeight = Bindings.createDoubleBinding(() -> Math.sin(Math.PI / 3) * hexWidth.getValue(), hexWidth);
    }

    public double getHexWidth() {
        return hexWidth.getValue();
    }

    public void setHexWidth(double newWidth) {
        hexWidth.set(newWidth);
    }

    public DoubleProperty hexWidthProperty() {
        return hexWidth;
    }

    public ObservableDoubleValue hexHeightProperty() {
        return hexHeight;
    }

    public double getHexHeight() {
        return hexHeight.get();
    }

    public ObservableList<TileModel> getTileModels() {
        return tileModels;
    }

    public TileModel getActiveTile() {
        return activeTile.get();
    }

    public void setActiveTile(TileModel activeTile) {
        this.activeTile.set(activeTile);
    }

    public ObjectProperty<TileModel> activeTileProperty() {
        return activeTile;
    }
}
