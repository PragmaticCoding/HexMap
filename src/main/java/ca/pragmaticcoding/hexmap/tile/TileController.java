package ca.pragmaticcoding.hexmap.tile;

import javafx.scene.layout.Region;

import java.util.function.Consumer;

public class TileController {

    HexTileBuilder hexTileBuilder;

    public TileController(TileModel model, Consumer<TileModel> tileClickHandler) {
        hexTileBuilder = new HexTileBuilder(model, () -> tileClickHandler.accept(model));
    }

    public Region getView() {
        return hexTileBuilder.build();
    }
}
