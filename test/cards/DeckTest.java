/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 2, 2018
* Time: 3:25:41 PM
*
* Project: csci205FinalProject
* Package: cards
* File: DeckTest
* Description:
*
* ****************************************
 */
package cards;

import deck.Deck;
import deck.card.Card;
import static junit.framework.TestCase.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Deck class
 *
 * @author Lily Romano
 */
public class DeckTest {

    /**
     * A new deck used for testing methods
     */
    Deck newDeck;

    /**
     * The default string a deck of 102 cards should display
     */
    String defaultDeckString = "New Deck: \n[Card{color=BLUE, type=ZERO}, Card{color=BLUE, type=ONE}, Card{color=BLUE, type=ONE}, Card{color=BLUE, type=TWO}, Card{color=BLUE, type=TWO}, Card{color=BLUE, type=THREE}, Card{color=BLUE, type=THREE}, Card{color=BLUE, type=FOUR}, Card{color=BLUE, type=FOUR}, Card{color=BLUE, type=FIVE}, Card{color=BLUE, type=FIVE}, Card{color=BLUE, type=SIX}, Card{color=BLUE, type=SIX}, Card{color=BLUE, type=SEVEN}, Card{color=BLUE, type=SEVEN}, Card{color=BLUE, type=EIGHT}, Card{color=BLUE, type=EIGHT}, Card{color=BLUE, type=NINE}, Card{color=BLUE, type=NINE}, Card{color=BLUE, type=DRAW2}, Card{color=BLUE, type=DRAW2}, Card{color=BLUE, type=REVERSE}, Card{color=BLUE, type=REVERSE}, Card{color=BLUE, type=SKIP}, Card{color=BLUE, type=SKIP}, Card{color=ORANGE, type=ZERO}, Card{color=ORANGE, type=ONE}, Card{color=ORANGE, type=ONE}, Card{color=ORANGE, type=TWO}, Card{color=ORANGE, type=TWO}, Card{color=ORANGE, type=THREE}, Card{color=ORANGE, type=THREE}, Card{color=ORANGE, type=FOUR}, Card{color=ORANGE, type=FOUR}, Card{color=ORANGE, type=FIVE}, Card{color=ORANGE, type=FIVE}, Card{color=ORANGE, type=SIX}, Card{color=ORANGE, type=SIX}, Card{color=ORANGE, type=SEVEN}, Card{color=ORANGE, type=SEVEN}, Card{color=ORANGE, type=EIGHT}, Card{color=ORANGE, type=EIGHT}, Card{color=ORANGE, type=NINE}, Card{color=ORANGE, type=NINE}, Card{color=ORANGE, type=DRAW2}, Card{color=ORANGE, type=DRAW2}, Card{color=ORANGE, type=REVERSE}, Card{color=ORANGE, type=REVERSE}, Card{color=ORANGE, type=SKIP}, Card{color=ORANGE, type=SKIP}, Card{color=YELLOW, type=ZERO}, Card{color=YELLOW, type=ONE}, Card{color=YELLOW, type=ONE}, Card{color=YELLOW, type=TWO}, Card{color=YELLOW, type=TWO}, Card{color=YELLOW, type=THREE}, Card{color=YELLOW, type=THREE}, Card{color=YELLOW, type=FOUR}, Card{color=YELLOW, type=FOUR}, Card{color=YELLOW, type=FIVE}, Card{color=YELLOW, type=FIVE}, Card{color=YELLOW, type=SIX}, Card{color=YELLOW, type=SIX}, Card{color=YELLOW, type=SEVEN}, Card{color=YELLOW, type=SEVEN}, Card{color=YELLOW, type=EIGHT}, Card{color=YELLOW, type=EIGHT}, Card{color=YELLOW, type=NINE}, Card{color=YELLOW, type=NINE}, Card{color=YELLOW, type=DRAW2}, Card{color=YELLOW, type=DRAW2}, Card{color=YELLOW, type=REVERSE}, Card{color=YELLOW, type=REVERSE}, Card{color=YELLOW, type=SKIP}, Card{color=YELLOW, type=SKIP}, Card{color=GRAY, type=ZERO}, Card{color=GRAY, type=ONE}, Card{color=GRAY, type=ONE}, Card{color=GRAY, type=TWO}, Card{color=GRAY, type=TWO}, Card{color=GRAY, type=THREE}, Card{color=GRAY, type=THREE}, Card{color=GRAY, type=FOUR}, Card{color=GRAY, type=FOUR}, Card{color=GRAY, type=FIVE}, Card{color=GRAY, type=FIVE}, Card{color=GRAY, type=SIX}, Card{color=GRAY, type=SIX}, Card{color=GRAY, type=SEVEN}, Card{color=GRAY, type=SEVEN}, Card{color=GRAY, type=EIGHT}, Card{color=GRAY, type=EIGHT}, Card{color=GRAY, type=NINE}, Card{color=GRAY, type=NINE}, Card{color=GRAY, type=DRAW2}, Card{color=GRAY, type=DRAW2}, Card{color=GRAY, type=REVERSE}, Card{color=GRAY, type=REVERSE}, Card{color=GRAY, type=SKIP}, Card{color=GRAY, type=SKIP}, Card{color=SPECIAL, type=WILD}, Card{color=SPECIAL, type=WILD}, Card{color=SPECIAL, type=WILD}, Card{color=SPECIAL, type=WILD}, Card{color=SPECIAL, type=WILDDRAW4}, Card{color=SPECIAL, type=WILDDRAW4}, Card{color=SPECIAL, type=WILDDRAW4}, Card{color=SPECIAL, type=WILDDRAW4}]";

    /**
     * Creates a new deck before every individual test
     */
    @Before
    public void setUp() {
        newDeck = new Deck();
    }

    /**
     * Deletes the deck before every individual test
     */
    @After
    public void tearDown() {
        newDeck = null;
    }

    /**
     * Tests creating a deck with the correct cards as well as the getDeck()
     * method.
     */
    @Test
    public void testFullDeck() {
        System.out.println("testFullDeck");

        String newDeckString = newDeck.toString();

        if (!defaultDeckString.equals(newDeckString)) {
            String errorMessage = "Expected: " + defaultDeckString + "\nActual: " + newDeckString;
            System.out.println(errorMessage);
        }

        assertEquals(defaultDeckString, newDeckString);
    }

    /**
     * Test the shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("testShuffle");

        String newDeckString = newDeck.toString();

        //Ensure unshuffed deck is correct, otherwise asserting false after shuffle would pass even if shuffle was not working
        assertEquals(defaultDeckString, newDeckString);

        //Shuffle and assert
        newDeck.shuffle();
        String newShuffledDeckString = newDeck.toString();

        if (defaultDeckString.equals(newShuffledDeckString)) {
            String errorMessage = "Unshuffled: " + defaultDeckString + "\nActual: " + newShuffledDeckString;
            System.out.println(errorMessage);
        }

        assertFalse(defaultDeckString.equals(newShuffledDeckString));
    }

    /**
     * Test of getNextCard method, of class Deck.
     */
    @Test
    public void testGetNextCard() {
        System.out.println("getNextCard");

        Card firstCard = newDeck.getNextCard();
        Card secondCard = newDeck.getNextCard();

        //test that second card does not equal first card
        assertFalse(firstCard.equals(secondCard));

        //cycle through remaining cards and test that first card is the same
        for (int i = 2; i < newDeck.getDeckSize(); i++) {
            newDeck.getNextCard();
        }

        Card nextCard = newDeck.getNextCard();

        assertTrue(firstCard.equals(nextCard));

    }
}