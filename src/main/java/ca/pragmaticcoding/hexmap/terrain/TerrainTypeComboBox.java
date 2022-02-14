package ca.pragmaticcoding.hexmap.terrain;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.shape.Rectangle;

import java.util.List;

import static ca.pragmaticcoding.hexmap.terrain.TerrainType.*;

public class TerrainTypeComboBox extends ComboBox<TerrainType> {

    public TerrainTypeComboBox() {
        super();
        initialize();
        getItems().setAll(List.of(DESERT, WATER, FOREST, GRASS, NONE));
        setButtonCell(createListCell());
    }

    private void initialize() {
        setCellFactory(p -> createListCell());
    }

    private ListCell<TerrainType> createListCell() {
        return new ListCell<>() {
            private final Rectangle rectangle = new Rectangle(20, 20);

            @Override
            protected void updateItem(TerrainType item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                    setText("");
                } else {
                    rectangle.setFill(item.colour);
                    setGraphic(rectangle);
                    setText(item.label);
                }
            }
        };
    }
}
