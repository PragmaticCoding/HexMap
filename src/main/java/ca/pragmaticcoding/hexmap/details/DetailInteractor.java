package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.application.Platform;

public class DetailInteractor {

    DetailModel model;
    TileModel currentTileModel = null;

    public DetailInteractor(DetailModel model) {
        this.model = model;
    }

    public void newTile(TileModel tileModel) {
        currentTileModel = tileModel;
        model.setLocation(tileModel.getLocation());
        model.setTerrain(tileModel.getTerrain());
        model.setTerrainType(tileModel.getTerrainType());
    }

    public void updateTile() {
        if (currentTileModel != null) {
            Platform.runLater(() -> {
                currentTileModel.setTerrain(model.getTerrain());
                currentTileModel.setTerrainType(model.getTerrainType());
            });
        }
    }
}
