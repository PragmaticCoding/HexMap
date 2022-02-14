package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.tile.TileModel;

public class DetailInteractor {

    DetailModel model;
    TileModel currentTileModel = null;

    public DetailInteractor(DetailModel model) {
        this.model = model;
    }

    public void newTile(TileModel tileModel) {
        currentTileModel = tileModel;
        model.setRow(tileModel.getRow());
        model.setColumn(tileModel.getColumn());
        model.setTerrain(tileModel.getTerrain());
        model.setTerrainType(tileModel.getTerrainType());
    }

    public void updateTile() {
        if (currentTileModel != null) {
            currentTileModel.setTerrain(model.getTerrain());
            currentTileModel.setTerrainType(model.getTerrainType());
        }
    }
}
