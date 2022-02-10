package ca.pragmaticcoding.hexmap.details;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class DetailModel {

    private final IntegerProperty row = new SimpleIntegerProperty(0);
    private final IntegerProperty column = new SimpleIntegerProperty(0);

    public int getRow() {
        return row.get();
    }

    public void setRow(int row) {
        this.row.set(row);
    }

    public IntegerProperty rowProperty() {
        return row;
    }

    public int getColumn() {
        return column.get();
    }

    public void setColumn(int column) {
        this.column.set(column);
    }

    public IntegerProperty columnProperty() {
        return column;
    }
}
