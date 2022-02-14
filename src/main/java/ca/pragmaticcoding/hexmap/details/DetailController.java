package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.scene.layout.Region;

public class DetailController {

    DetailModel model;
    DetailViewBuilder viewBuilder;
    DetailInteractor interactor;

    public DetailController(DetailModel model) {
        this.model = model;
        interactor = new DetailInteractor(model);
        viewBuilder = new DetailViewBuilder(model, this::handleUpdate);
    }

    private void handleUpdate(Runnable afterAction) {
        interactor.updateTile();
        afterAction.run();
    }

    public void changeTile(TileModel tileModel) {
        interactor.newTile(tileModel);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
