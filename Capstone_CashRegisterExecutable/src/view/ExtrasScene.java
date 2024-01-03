package view;

import controller.Controller;
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
public class ExtrasScene extends Scene {

    private ComboBox<String> airFreshenerTypeCB;
    private ComboBox<String> walletCB;
    private ComboBox<String> freeWashCB;
    private ComboBox<String> vehicleCB;
    private Button airFreshenerButton = new Button("* Air Freshener");
    private Button walletButton = new Button("* Wallet");
    private Button freeWashButton = new Button("* Free Wash");
    private Button vehicleButton = new Button("* Large Vehicle Upcharge");

    private Controller controller = Controller.getInstance();

    /**
     * Constructs a new <code>MainScene</code>, representing the very first scene for the SD Burritos application.
     * It contains filters for location (store), neighborhood, rating and price.
     * The <code>ExtrasScene</code> also allows for a user to add a new burrito review or modify
     * existing reviews.
     */
    public ExtrasScene() {
        super(new GridPane(), 850, 400);


        //TODO: Add a listener on the selected item property of the burritosLV
        // burritosLV.getSelectionModel().selectedItemProperty().addListener((observableValue, burrito, t1) -> selectBurrito(t1));
        //TODO: In the changed(...) method, assign the selected burrito to the new value
        //TODO: If the selected burrito is null (no burrito selected), then disable the modifyBurritoButton
        //TODO: Otherwise, it should be enabled.


        airFreshenerTypeCB = new ComboBox<String>(controller.getDistinctScents());

        walletCB = new ComboBox<String>(controller.getDistinctWallets());

        freeWashCB = new ComboBox<String>(controller.getDistinctAssociations());

        vehicleCB = new ComboBox<String>(controller.getDistinctVehicleSizes());

        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.add(new Label("Scents:"), 0, 0);
        pane.add(airFreshenerTypeCB, 1, 1);

        pane.add(new Label("Fabric:"), 2, 0);
        pane.add(walletCB, 3, 1);

        pane.add(new Label("Association:"), 4, 0);
        pane.add(freeWashCB, 5, 1);

        pane.add(new Label("Vehicle Sizes:"), 6, 0);
        pane.add(vehicleCB, 7, 1);



        pane.add(airFreshenerButton, 0, 5, 2, 1);
        pane.add(walletButton, 0, 7, 2, 1);
        pane.add(freeWashButton, 0, 9, 2, 1);
        pane.add(vehicleButton, 0, 11, 2, 1);

        airFreshenerButton.setVisible(true);
        walletButton.setVisible(true);
        freeWashButton.setVisible(true);
        vehicleButton.setVisible(true);

        this.setRoot(pane);
    }

}
