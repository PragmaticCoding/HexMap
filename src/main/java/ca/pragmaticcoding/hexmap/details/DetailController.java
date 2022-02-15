package ca.pragmaticcoding.hexmap.details;

import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.beans.value.ObservableObjectValue;
import javafx.scene.layout.Region;

public class DetailController {

    DetailModel model;
    DetailViewBuilder viewBuilder;
    DetailInteractor interactor;

    public DetailController(ObservableObjectValue<TileModel> activeTile) {
        model = new DetailModel();
        interactor = new DetailInteractor(model);
        viewBuilder = new DetailViewBuilder(model, interactor::updateTile);
        activeTile.addListener(observable -> changeTile(activeTile.getValue()));
        changeTile(activeTile.getValue());
    }

    private void changeTile(TileModel tileModel) {
        interactor.newTile(tileModel);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
