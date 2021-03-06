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
package unogamemvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * GUI of the java playing screen.
 *
 * @author James Kelly
 * @author Lily Romano
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
     * @author Lily Romano
     */
    @Override
    public void init() {
        this.theModel = new UNOGameModel();
        this.theView = new UNOGameView(theModel);

    }

    /**
     * The primary method that is called by the JavaFX application to set up the
     * initial stage
     *
     * @author James Kelly
     * @author Lily Romano
     *
     * @param primaryStage The initial stage
     */
    @Override
    public void start(Stage primaryStage) {
        this.theControl = new UNOGameController(theModel, theView);

        Scene scene = new Scene(this.theView.getRootNode());
        scene.getStylesheets().add(
                getClass().getResource("resource/stylesheet.css").toExternalForm());

        primaryStage.setTitle("BUno!");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    /**
     * Launches the UNO Game GUI
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
