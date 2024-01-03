package view;

import controller.Controller;
import model.Wash;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * The <code>AddScene</code> class allows a user to enter the information to add a new Burrito to the collection
 * of reviews.  Some fields are validated (must be provided) before the user is able to save the information.
 *
 * @author Michael Paulding
 * @version 1.1
 */
public class AddScene extends Scene {
    private final Scene mPrevScene;

    private final Controller controller = Controller.getInstance();

    private final TextField scentTF = new TextField();
    private final Label scentLabel = new Label("Scent is required.");

    private final Button saveButton = new Button("Save");
    private final Button cancelButton = new Button("Cancel");


    /**
     * In the <code>AddScene</code>, a user is able to add a new AirFreshener to the collection of items.
     * Scent is a required field (error message will appear if not provided)
     * @param prevScene A reference to the MainScene so that after saving (or canceling), user
     *                  is returned back to the main scene.
     */
    public AddScene(Scene prevScene) {
        super(new GridPane(), 450, 250);
        mPrevScene = prevScene;

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(new Label("Scent:"), 0, 0);
        pane.add(scentTF, 1, 0);
        pane.add(scentLabel, 2, 0);
        scentLabel.setTextFill(Color.RED);
        scentLabel.setVisible(false);

        pane.add(cancelButton, 0, 6);
        pane.add(saveButton, 1, 6);



        saveButton.setOnAction(event -> save());
        cancelButton.setOnAction(event -> goBackToPrevScene());
        this.setRoot(pane);
    }


    /**
     * Reads each of the text fields and validates them.  If the required fields (location, name, neighborhood, price)
     * are empty, user will see an error message (red text) next to the text field and will be prevented from saving.
     * Otherwise a new Burrito object will be instantiated and added to the list of all burritos.
     */
    private void save() {
        //
        String scent;

        scent = scentTF.getText();
        scentLabel.setVisible(scent.isEmpty());

        //TODO: If any of the error labels are visible, return.
        if(scentLabel.isVisible())
        {
            return;
        }
        //TODO: Otherwise, instantiate a new Wash object and add it to the list of all burritos.
        controller.getAllWashes().add(new Wash("Basic Wash", 10.00));
        //TODO: Then go back to the previous scene.
        goBackToPrevScene();

    }

    /**
     * Navigates back to the previous scene without having to create a new one.
     */
    private void goBackToPrevScene() {
        //TODO: Navigate back to the previous scene (e.g. MainScene)
        ViewNavigator.loadScene("Santa Fe Car Wash", mPrevScene);
    }

}
