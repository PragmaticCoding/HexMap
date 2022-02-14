module ca.pragmaticcoding.hexmap {
    requires javafx.controls;


    opens ca.pragmaticcoding.hexmap to javafx.controls;
    exports ca.pragmaticcoding.hexmap;
    exports ca.pragmaticcoding.hexmap.tile;
    opens ca.pragmaticcoding.hexmap.tile to javafx.controls;
    exports ca.pragmaticcoding.hexmap.terrain;
    opens ca.pragmaticcoding.hexmap.terrain to javafx.controls;
    exports ca.pragmaticcoding.hexmap.counters;
    opens ca.pragmaticcoding.hexmap.counters to javafx.controls;
}