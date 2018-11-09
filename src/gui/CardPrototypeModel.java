/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 9:56:23 AM
*
* Project: csci205FinalProject
* Package: gui
* File: CardPrototypeModel
* Description:
*
* ****************************************
 */
package gui;

import cards.Card;
import cards.Deck;

/**
 * A GUI Card Prototype MVC model
 *
 * @version 0.1
 * @author Lily Romano
 */
public class CardPrototypeModel {

    private Deck theDeck;

    /**
     * An explicit constructor for the Card Prototype Model
     */
    public CardPrototypeModel() {
        theDeck = new Deck();
        theDeck.shuffle();
    }

    public Deck getTheDeck() {
        return theDeck;
    }

    public Card getNextCard() {
        return theDeck.getNextCard();
    }

}
