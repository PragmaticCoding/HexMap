package ca.pragmaticcoding.hexmap.tile;

import javafx.scene.layout.Region;

import java.util.function.Consumer;

public class TileController {

    private final Consumer<TileModel> tileClickHandler;
    HexTile view;

    public TileController(TileModel model, Consumer<TileModel> tileClickHandler) {
        view = new HexTile(model, () -> tileClickHandler.accept(model));
        this.tileClickHandler = tileClickHandler;
    }

    public Region getView() {
        return view;
    }
}
