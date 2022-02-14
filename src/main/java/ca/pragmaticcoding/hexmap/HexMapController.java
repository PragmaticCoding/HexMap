package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.details.DetailController;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.scene.layout.Region;

public class HexMapController {

    private final HexMapBuilder viewBuilder;
    private final HexMapInteractor interactor;
    private final DetailController detailController;

    public HexMapController() {
        HexMapModel model = new HexMapModel();
        interactor = new HexMapInteractor(model);
        detailController = new DetailController(model.getDetailModel());
        viewBuilder = new HexMapBuilder(model, detailController.getView(), this::handleHexClick, interactor::animateTanks);
    }

    private void handleHexClick(TileModel tileModel) {
        interactor.activateTile(tileModel);
        detailController.changeTile(tileModel);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
