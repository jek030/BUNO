/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 12:43:19 PM
*
* Project: csci205FinalProject
* Package: view
* File: UNOGameController
* Description:
*
* ****************************************
 */
package view;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author jameskelly
 */
public class UNOGameController implements EventHandler<Event> {

    /**
     * The model for the UNO game
     */
    private final UNOGameModel theModel;

    /**
     * The view for the UNO game
     */
    private final UNOGameView theView;

    /**
     * An explicit constructor for the UNO game controller.
     *
     * @param theModel The model for the UNO game
     * @param theView The view for the UNO game
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public UNOGameController(UNOGameModel theModel,
            UNOGameView theView) {
        this.theModel = theModel;
        this.theView = theView;

        this.theView.getRootNode().addEventFilter(KeyEvent.KEY_PRESSED, this);
        this.theView.getFaceDown().setOnMouseClicked(this);
        this.theView.getFaceUp().setOnMouseClicked(this);

    }

    public void handle(Event event) {
        EventType eType = event.getEventType();

        if (eType == KeyEvent.KEY_PRESSED) {
            KeyEvent target = (KeyEvent) event;
            if (target.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        }
    }

}
