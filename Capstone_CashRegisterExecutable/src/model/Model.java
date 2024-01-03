package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The <code>Model</code> class represents the business logic (data and calculations) of the application.
 * In the San Diego Burritos app, it either loads burrito from a CSV file (first load) or a binary file (all
 * subsequent loads).  It is also responsible for saving data to a binary file.
 *
 * @author Michael Paulding
 * @version 1.0
 */
public class Model {

    public static final String BINARY_FILE = "CarWashes.dat";

    /**
     * Determines whether the binary file exists and has data (size/length > 0).
     *
     * @return True if the binary file exists and has data, false otherwise.
     */
    public static boolean binaryFileHasData() {
        // TODO: Create a File reference to the binary file
        File burritoRef = new File(BINARY_FILE);
        // TODO: Return whether the binary file exists and has data
        return burritoRef.exists() && burritoRef.length() > 0;
    }

    /**
     * Populates the list of all burritos from the binary file. This will be called everytime the application loads,
     * other than the very first time, since it needs initial data from CSV.
     *
     * @return The list of all burritos populated from the binary file
     */
    public static ObservableList<Wash> populateListFromBinaryFile() {
        ObservableList<Wash> allWashes = FXCollections.observableArrayList();
        // TODO: Create a File reference to the binary file
        File binaryFile = new File(BINARY_FILE);
        // TODO: Check to see if the binary file exists
        if (binaryFileHasData()) {
            // TODO: Instantiate an ObjectInputStream reference to the binary file for reading
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
                Wash[] tempArray = (Wash[]) fileReader.readObject();
                allWashes.addAll(tempArray);
                fileReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error reading: " + e.getMessage());
            }
        }

        // TODO: Create a temp array of Burrito objects to read from the binary file
        // TODO: Initialize the temp array from the binary file reader.
        // TODO: Add the temp array to the collection of all burritos (list)
        // TODO: Close the binary file reader.

        return allWashes;
    }

    /**
     * Saves the list of all burritos to the binary file. This will be called each time the application stops,
     * which occurs when the user exits/closes the app.  Note this method is called in the View, by the controller,
     * during the stop() method.
     *
     * @return True if the data were saved to the binary file successfully, false otherwise.
     */
    public static boolean writeDataToBinaryFile(ObservableList<Wash> allWashesList) {
        // TODO: Create a File reference to the binary file
        File binaryFile = new File(BINARY_FILE);
        // TODO: Instantiate an ObjectOutputStream reference to the binary file for writing
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
            // TODO: Create a temp array of Burrito objects to read from the binary file (length should match list size)
            Wash[] tempArray = new Wash[allWashesList.size()];
            // TODO: Loop through the temp array and initialize each element to the corresponding element in the list
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = allWashesList.get(i);

            }
            // TODO: Write the temp array object to the binary file writer
            fileWriter.writeObject(tempArray);
            // TODO: Close the binary file writer and return true.
            fileWriter.close();
            // TODO: If an exception occurs, print its message and return false.
        } catch (IOException e) {
            System.err.println("Error reading: " + e.getMessage());
        }
        return false;
    }
}
