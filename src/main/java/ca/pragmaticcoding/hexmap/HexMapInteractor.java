package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.tile.TileModel;

import java.util.stream.IntStream;

public class HexMapInteractor {
    private final HexMapModel model;

    public HexMapInteractor(HexMapModel model) {
        this.model = model;
        initializeTiles();
    }

    private void initializeTiles() {
        model.getTileModels().addAll(IntStream.range(1, 8)
                .boxed()
                .flatMap(row -> IntStream.range(1, 14).mapToObj(column -> new TileModel(row, column, model.hexWidthProperty(), model.hexHeightProperty())))
                .toList());
    }

    public void handleTileClick(TileModel tileModel) {
        System.out.println("Clicked: " + tileModel.getRow() + ":" + tileModel.getColumn());
        model.getDetailModel().setColumn(tileModel.getColumn());
        model.getDetailModel().setRow(tileModel.getRow());
        tileModel.setTerrain(tileModel.getTerrain() + 1);
    }
}
