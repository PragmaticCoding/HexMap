module ca.pragmaticcoding.hexmap {
    requires javafx.controls;


    opens ca.pragmaticcoding.hexmap to javafx.controls;
    exports ca.pragmaticcoding.hexmap;
    exports ca.pragmaticcoding.hexmap.tile;
    opens ca.pragmaticcoding.hexmap.tile to javafx.controls;
}