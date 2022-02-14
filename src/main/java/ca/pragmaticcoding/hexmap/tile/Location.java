package ca.pragmaticcoding.hexmap.tile;

public record Location(int column, int row) {

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
