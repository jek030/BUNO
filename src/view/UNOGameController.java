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

/**
 *
 * @author jameskelly
 */
public class UNOGameController {

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
    public UNOGameController(UNOGameModel theModel,
            UNOGameView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

}
