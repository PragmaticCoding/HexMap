package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.tile.TileController;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.beans.binding.Bindings;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.Objects;
import java.util.function.Consumer;

public class HexMapBuilder implements Builder<Region> {

    private final HexMapModel model;
    private final Region detailView;
    private final Consumer<TileModel> tileClickHandler;

    public HexMapBuilder(HexMapModel model, Region detailView, Consumer<TileModel> tileClickHandler) {
        this.model = model;
        this.detailView = detailView;
        this.tileClickHandler = tileClickHandler;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        results.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/css/hexmap.css")).toString());
        results.setCenter(createMap());
        results.setRight(detailView);
        return results;
    }

    private Region createMap() {
        Pane pane = new Pane();
        pane.getChildren().addAll(model.getTileModels().stream().map(tileModel -> {
            Region hex = new TileController(tileModel, tileClickHandler).getView();
            hex.translateXProperty().bind(Bindings.createDoubleBinding(() -> (tileModel.getColumn() - 1) * this.model.getHexWidth() * 0.75, this.model.hexWidthProperty()));
            hex.translateYProperty().bind(Bindings.createDoubleBinding(() -> calculateYTranslate(tileModel.getRow(), tileModel.getColumn()), this.model.hexHeightProperty()));
            return hex;
        }).toList());
        pane.setMinSize(600, 400);
        pane.setStyle("-fx-background-color: teal;");
        return pane;
    }

    private double calculateYTranslate(int row, int column) {
        return ((row - 1) * model.getHexHeight()) + (((column % 2) == 0) ? (model.getHexHeight() / 2) : 0);
    }

}
