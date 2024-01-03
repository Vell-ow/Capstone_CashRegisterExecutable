package controller;

import model.AirFreshener;
import model.Model;
import model.Wash;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Calendar;

/**
 * The <code>Controller</code> is a Singleton object that relays all commands between the Model and View
 * (and vice versa).  There is only one Controller object, accessible by a call to the static getInstance()
 * method.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Controller {

    private static Controller theInstance;
    private ObservableList<Wash> mAllWashesList;

    private Controller() {}

    /**
     * Gets the one instance of the Controller.
     * @return The instance
     */
    public static Controller getInstance() {
        if (theInstance == null) {
            theInstance = new Controller();
        }
        return theInstance;
    }

    /**
     * Gets the list of all burritos.
     * @return The list of all burritos.
     */

    /**
     * Gets a list of the distinct locations, without duplicates, in sorted order.
     * @return The list of distinct locations
     */
    public ObservableList<String> getDistinctScents()
    {
        ObservableList<String> scentsList = FXCollections.observableArrayList();
        scentsList.add(" ");
        scentsList.add("Cherry");
        scentsList.add("Pina Colada");
        return scentsList;
    }

    /**
     * Gets a list of the distinct neighborhoods, without duplicates, in sorted order.
     * @return The list of distinct neighborhoods
     */
    public ObservableList<String> getDistinctWallets()
    {
        ObservableList<String> walletsList = FXCollections.observableArrayList();
        walletsList.add(" ");
        walletsList.add("Leather");
        return walletsList;
    }

    public ObservableList<String> getDistinctAssociations()
    {
        ObservableList<String> freeWashesList = FXCollections.observableArrayList();
        freeWashesList.add(" ");
        freeWashesList.add("CHP");
        freeWashesList.add("VID");
        freeWashesList.add("TERI");
        return freeWashesList;
    }

    public ObservableList<String> getDistinctVehicleSizes()
    {
        ObservableList<String> vehicleList = FXCollections.observableArrayList();
        vehicleList.add(" ");
        vehicleList.add("Large SUV/Large Truck");
        vehicleList.add("Raised Truck");
        vehicleList.add("Business Truck");
        vehicleList.add("Recreational Vehicle");
        return vehicleList;
    }

    /**
     * Makes a request for the model to save all the burrito data (the list of all car washes) to
     * a persistent binary file.
     */
    public void saveData() {
        Model.writeDataToBinaryFile(mAllWashesList);
    }

    public ObservableList<Wash> getAllWashes() {
        return mAllWashesList;
    }
}
