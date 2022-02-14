package ca.pragmaticcoding.hexmap.tile;

public record Location(int column, int row) {

    public boolean equals(Location otherLocation) {
        if (otherLocation == null) {
            return false;
        }
        return ((this.row() == otherLocation.row()) && (this.column() == otherLocation.column()));
    }

    @Override
    public String toString() {
        return column + ":" + row;
    }
}
