package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.terrain.TerrainType;
import ca.pragmaticcoding.hexmap.tile.Location;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.application.Platform;

public class DetailInteractor {

    DetailModel model;
    TileModel currentTileModel = null;

    public DetailInteractor(DetailModel model) {
        this.model = model;
    }

    public void newTile(TileModel tileModel) {
        if (tileModel != null) {
            currentTileModel = tileModel;
            model.setLocation(tileModel.getLocation());
            model.setTerrain(tileModel.getTerrain());
            model.setTerrainType(tileModel.getTerrainType());
        } else {
            model.setLocation(new Location(0, 0));
            model.setTerrain(0);
            model.setTerrainType(TerrainType.NONE);
        }
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
