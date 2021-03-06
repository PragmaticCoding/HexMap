package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.counters.CounterType;
import ca.pragmaticcoding.hexmap.tile.Location;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class HexMapInteractor {
    private final HexMapModel model;

    public HexMapInteractor(HexMapModel model) {
        this.model = model;
        initializeTiles();
    }

    private void initializeTiles() {
        model.getTileModels().addAll(IntStream.range(1, 10)
                .boxed()
                .flatMap(row -> IntStream.range(1, 12).mapToObj(column -> new TileModel(new Location(column, row), model.hexWidthProperty(), model.hexHeightProperty())))
                .toList());
        model.getTileModels().stream().filter(tileModel -> tileModel.getLocation().equals(new Location(5, 8))).findFirst().ifPresent(tileModel -> tileModel.setOccupier(CounterType.CT1));
    }

    public void activateTile(TileModel selectedModel) {
        model.getTileModels().forEach(tileModel -> tileModel.setSelected(false));
        selectedModel.setSelected(true);
        model.setActiveTile(selectedModel);
    }


    public void animateTank(List<Location> locations1) {
        Timeline timeline = new Timeline();
        IntegerProperty index = new SimpleIntegerProperty(0);
        AtomicInteger duration = new AtomicInteger(0);
        timeline.getKeyFrames().addAll(locations1.stream().map(location -> new KeyFrame(Duration.millis(duration.getAndAdd(800)), evt -> moveTank(location), new KeyValue(index, 10))).toList());
        timeline.play();
    }

    private void moveTank(Location newLoc) {
        for (TileModel tileModel : model.getTileModels()) {
            tileModel.setOccupier(CounterType.NONE);
        }
        model.getTileModels().stream()
                .filter(tileModel -> ((tileModel.getLocation().equals(newLoc))))
                .findAny()
                .ifPresent(tileModel -> tileModel.setOccupier(CounterType.CT3));
    }

    public List<Location> calculateTankPath() {
        return List.of(new Location(5, 10),
                new Location(5, 9),
                new Location(5, 8),
                new Location(6, 7),
                new Location(7, 7),
                new Location(8, 6),
                new Location(9, 6),
                new Location(10, 6)
        );
    }
}
