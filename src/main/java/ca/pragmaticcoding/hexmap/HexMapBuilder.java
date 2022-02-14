package ca.pragmaticcoding.hexmap;

import ca.pragmaticcoding.hexmap.tile.TileController;
import ca.pragmaticcoding.hexmap.tile.TileModel;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

import java.util.Objects;
import java.util.function.Consumer;

public class HexMapBuilder implements Builder<Region> {

    private final HexMapModel model;
    private final Region detailView;
    private final Consumer<TileModel> tileClickHandler;
    private final Runnable animator;

    public HexMapBuilder(HexMapModel model, Region detailView, Consumer<TileModel> tileClickHandler, Runnable animator) {
        this.model = model;
        this.detailView = detailView;
        this.tileClickHandler = tileClickHandler;
        this.animator = animator;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        results.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/css/hexmap.css")).toString());
        results.setCenter(createMap());
        results.setRight(detailView);
        results.setBottom(smallerButton());
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
        System.out.println("height: " + model.getHexHeight());
        int numColumns = model.getTileModels().stream().map(TileModel::getColumn).mapToInt(v -> v).max().orElse(0);
        int numRows = model.getTileModels().stream().map(TileModel::getRow).mapToInt(v -> v).max().orElse(0);
        pane.minWidthProperty().bind(Bindings.createDoubleBinding(() -> model.getHexWidth() * numColumns * 0.76667, model.hexWidthProperty()));
        pane.minHeightProperty().bind(Bindings.createDoubleBinding(() -> (numRows + 0.5) * model.getHexHeight(), model.hexHeightProperty()));
        pane.setStyle("-fx-background-color: teal;");
        StackPane stackPane = new StackPane(pane);
        stackPane.setPadding(new Insets(5));
        stackPane.maxWidthProperty().bind(pane.minWidthProperty().add(10));
        stackPane.maxHeightProperty().bind(pane.minHeightProperty().add(10));
        return stackPane;
    }

    private Region smallerButton() {
        Button button = new Button("Smaller");
        button.setOnAction(evt -> animator.run());
        return button;

    }

    private double calculateYTranslate(int row, int column) {
        return ((row - 1) * model.getHexHeight()) + (((column % 2) == 0) ? (model.getHexHeight() / 2) : 0);
    }

}
