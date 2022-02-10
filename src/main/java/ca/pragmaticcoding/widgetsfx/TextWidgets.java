package ca.pragmaticcoding.widgetsfx;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class TextWidgets {

    public static Text labelText(String contents) {
        Text results = new Text(contents);
        results.getStyleClass().add("label-text");
        return results;
    }

    public static Text boundStyledText(ObservableStringValue contents, String styleClass) {
        Text results = new Text("");
        results.textProperty().bind(contents);
        results.getStyleClass().add(styleClass);
        return results;
    }


    public static Text boundDataText(ObservableStringValue contents) {
        Text results = new Text("");
        results.textProperty().bind(contents);
        results.getStyleClass().add("data-text");
        return results;
    }

    public static TextField boundTextField(StringProperty contents) {
        TextField results = new TextField();
        results.textProperty().bindBidirectional(contents);
        results.getStyleClass().add("data-text");
        return results;
    }
}
