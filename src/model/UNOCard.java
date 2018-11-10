/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 12:28:04 PM
*
* Project: csci205FinalProject
* Package: Model
* File: UNOCard
* Description:
*
* ****************************************
 */
package model;

/**
 *
 * @author jameskelly
 */
public class UNOCard {

    /**
     * The color of the card
     */
    private final CardColor color;

    /**
     * The type of card
     */
    private final CardType type;

    /**
     * An explicit constructor for a Card
     *
     * @param color the color of the card
     * @param type the type of card
     */
    public UNOCard(CardColor color, CardType type) {
        this.color = color;
        this.type = type;
    }

    /**
     * Returns the enum CardColor of the card
     *
     * @return the enum CardColor of the card
     */
    public CardColor getColor() {
        return color;
    }

    /**
     * Returns the enum CardType of the card
     *
     * @return the enum CardType of the card
     */
    public CardType getType() {
        return type;
    }

}
