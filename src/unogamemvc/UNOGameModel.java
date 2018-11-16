/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 12:40:08 PM
*
* Project: csci205FinalProject
* Package: view
* File: UNOGameModel
* Description:
*
* ****************************************
 */
package unogamemvc;

import deck.DrawDeck;

/**
 * A GUI Card Prototype MVC model Main GUI
 *
 * @author Lily Romano
 */
public class UNOGameModel {

    /**
     * Creates a deck of cards
     */
    private final DrawDeck theDrawDeck;

    /**
     * An explicit constructor for the UNO Main GUI Model
     */
    public UNOGameModel() {
        theDrawDeck = new DrawDeck();
        theDrawDeck.shuffle();
    }

}
