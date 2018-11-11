/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 12:36:08 PM
*
* Project: csci205FinalProject
* Package: view
* File: UNOGameMain
* Description:
*
* ****************************************
 */
package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * GUI of the java playing screen.
 *
 * @author jameskelly
 */
public class UNOGameMain extends Application {

    /**
     * The model for the UNO game
     */
    private UNOGameModel theModel;

    /**
     * The view for the UNO game
     */
    private UNOGameView theView;

    /**
     * The controller for the UNO game
     */
    private UNOGameController theControl;

    /**
     * The primary method that is called by the JavaFX application to initialize
     * the GUI
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.theModel = new UNOGameModel();
        this.theView = new UNOGameView(theModel);
    }

    @Override
    public void start(Stage primaryStage) {

        this.theControl = new UNOGameController(theModel, theView);

        Scene scene = new Scene(this.theView.getRootNode(), 800, 800);
        scene.getStylesheets().add(
                getClass().getResource("stylesheet.css").toExternalForm());

        primaryStage.setTitle("B-UNO");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
