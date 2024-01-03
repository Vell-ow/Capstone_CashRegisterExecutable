

package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class View extends Application {

    // All controls needed for viewing the Billionaire data

    // ListView<Billionaire> billionairesLV = new ListView<>();

    // Fields to link with the Controller
    // Controller theInstance;
    // ObservableList<Billionaire> billionairesList;


    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images\\burrito.png")));
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("Santa Fe Carwash", new MainScene());

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));


        Scene scene = new Scene(pane, 850, 600);
        primaryStage.setTitle("Santa Fe Car Wash");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Stop is called whenever the application shuts down (e.g. user closes the window).
     * In this case we request the Controller to initiate the saving of all burrito data to the binary file.
     * @throws Exception if one occurs during shutdown.
     */
    @Override
    public void stop() throws Exception {
        Controller.getInstance().saveData();
    }

    public static void main(String[] args)
    {
        Application.launch(args);

    }

}
