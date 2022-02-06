module ca.pragmaticcoding.starterfx {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;

    requires org.kordamp.ikonli.javafx;

    opens ca.pragmaticcoding.starterfx to javafx.graphics;
    exports ca.pragmaticcoding.starterfx;
}