package ca.pragmaticcoding.widgetsfx;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TwoColumnGridPane extends GridPane {

    public TwoColumnGridPane() {
        ColumnConstraints labelColumn = new ColumnConstraints();
        labelColumn.setHalignment(HPos.RIGHT);
        ColumnConstraints dataColumn = new ColumnConstraints();
        dataColumn.setHalignment(HPos.LEFT);
        getColumnConstraints().addAll(labelColumn, dataColumn);
        setHgap(4d);
        setVgap(2d);
        setPadding(new Insets(8d));
    }

    public void addTextRow(String label, ObservableStringValue dataProperty) {
        addRow(label, TextWidgets.boundDataText(dataProperty));
    }

    public void addRow(String label, Node dataNode) {
        int row = getRowCount();
        add(TextWidgets.labelText(label), 0, row);
        add(dataNode, 1, row);
    }

    public void addTextFieldRow(String label, StringProperty dataProperty) {
        addRow(label, TextWidgets.boundTextField(dataProperty));
    }
}
