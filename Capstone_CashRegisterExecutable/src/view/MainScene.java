package view;

import controller.Controller;
import javafx.scene.paint.Color;
import model.Wash;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * The <code>MainScene</code> represents the very first scene for the SD Burritos application.
 * It contains filters for location (store), neighborhood, rating and price.
 * The <code>MainScene</code> also allows for a user to add a new burrito review or modify
 * existing reviews.
 */
public class MainScene extends Scene
{

    private Button washButton = new Button("CAR WASH");
    private Button extrasButton = new Button("EXTRAS");

    private Controller controller = Controller.getInstance();

    /**
     * In the <code>MainScene</code>, a user is able to add a new AirFreshener to the collection of items.
     * Scent is a required field (error message will appear if not provided)
     */
    public MainScene() {
        super(new GridPane(), 450, 250);

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(washButton, 0, 5, 2, 1);
        pane.add(extrasButton, 0, 7, 2, 1);

        washButton.setVisible(true);
        extrasButton.setVisible(true);

        this.setRoot(pane);
    }

    private void ExtrasScene()
    {
        // ViewNavigator.loadScene("Extras", new ExtrasScene(this, ));
    }


    /**
     * Reads each of the text fields and validates them.  If the required fields (location, name, neighborhood, price)
     * are empty, user will see an error message (red text) next to the text field and will be prevented from saving.
     * Otherwise a new Burrito object will be instantiated and added to the list of all burritos.
     */

    private void save() {
        controller.getAllWashes().add(new Wash("Basic Wash", 10.00));
        //TODO: Then go back to the previous scene.

    }

}