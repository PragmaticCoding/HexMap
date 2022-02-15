package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.details.DetailController;
import ca.pragmaticcoding.hexmap.tile.Location;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;

import java.util.List;

public class HexMapController {

    private final HexMapBuilder viewBuilder;
    private final HexMapInteractor interactor;

    public HexMapController() {
        HexMapModel model = new HexMapModel();
        interactor = new HexMapInteractor(model);
        DetailController detailController = new DetailController(model.activeTileProperty());
        viewBuilder = new HexMapBuilder(model, detailController.getView(), this::handleHexClick, this::animateTank);
    }

    private void handleHexClick(TileModel tileModel) {
        interactor.activateTile(tileModel);
    }

    private void animateTank() {
        Task<List<Location>> tankTask = new Task<>() {
            @Override
            protected List<Location> call() {
                return interactor.calculateTankPath();
            }
        };
        tankTask.setOnSucceeded(evt -> interactor.animateTank(tankTask.getValue()));
        Thread tankThread = new Thread(tankTask);
        tankThread.start();
    }


    public Region getView() {
        return viewBuilder.build();
    }
}
