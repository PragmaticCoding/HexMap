package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.details.DetailController;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.scene.layout.Region;

public class HexMapController {

    private final HexMapBuilder viewBuilder;
    private final HexMapInteractor interactor;

    public HexMapController() {
        HexMapModel model = new HexMapModel();
        interactor = new HexMapInteractor(model);
        viewBuilder = new HexMapBuilder(model, new DetailController(model.getDetailModel()).getView(), this::handleHexClick);
    }

    private void handleHexClick(TileModel tileModel) {
        interactor.handleTileClick(tileModel);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
