package ca.pragmaticcoding.hexmap.details;

import javafx.scene.layout.Region;

public class DetailController {

    DetailModel model;
    DetailViewBuilder viewBuilder;

    public DetailController(DetailModel model) {
        this.model = model;
        viewBuilder = new DetailViewBuilder(model);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
