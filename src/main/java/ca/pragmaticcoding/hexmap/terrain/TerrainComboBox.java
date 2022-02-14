package ca.pragmaticcoding.hexmap.terrain;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;

import java.util.List;

public class TerrainComboBox extends ComboBox<Integer> {

    public TerrainComboBox() {
        super();
        initialize();
        getItems().setAll(List.of(0, 1, 2, 3, 6, 7, 8, 9, 10, 11, 12, 13));
        setButtonCell(getListCell());
    }

    private void initialize() {
        setCellFactory(p -> getListCell());
    }

    private ListCell<Integer> getListCell() {
        return new ListCell<>() {
            private final TerrainSprite terrainSprite = new TerrainSprite();

            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                terrainSprite.setFitWidth(40);
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    terrainSprite.imageIndexProperty().set(item);
                    setGraphic(terrainSprite);
                }
            }
        };
    }
}
