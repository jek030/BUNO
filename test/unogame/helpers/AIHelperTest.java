/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 30, 2018
* Time: 8:58:46 AM
*
* Project: csci205FinalProject
* Package: unogame.helpers
* File: AIHelperTest
* Description:
*
* ****************************************
 */
package unogame.helpers;

import deck.PlayerHand;
import deck.card.Card;
import deck.card.CardColor;
import deck.card.CardType;
import static junit.framework.TestCase.fail;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import unogame.NoValidCardException;
import unogame.PlayCommand;

/**
 *
 * @author Lily Romano
 */
public class AIHelperTest {

    PlayerHand testHandDeck;

    public AIHelperTest() {
    }

    @Before
    public void setUp() {
        testHandDeck = new PlayerHand(0, true);

        //Add known set of cards
        //Hand does not have a Grey or number card greater than 3
        testHandDeck.addCard(new Card(CardColor.BLUE, CardType.ONE));
        testHandDeck.addCard(new Card(CardColor.ORANGE, CardType.TWO));
        testHandDeck.addCard(new Card(CardColor.YELLOW, CardType.THREE));

    }

    @After
    public void tearDown() {
        testHandDeck = null;
    }

    /**
     * Test of getValidCard method, of class AIHelper.
     */
    @Test
    public void testGetValidCardMatchColorOnly() throws Exception {
        System.out.println("testGetValidCardMatchColorOnly");

        Card discardCard = new Card(CardColor.BLUE, CardType.FOUR);
        int expResult = 0;

        int result = AIHelper.getValidCard(testHandDeck.getCopyOfHand(),
                                           discardCard);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValidCard method, of class AIHelper.
     */
    @Test
    public void testGetValidCardMatchTypeOnly() throws Exception {
        System.out.println("testGetValidCardMatchTypeOnly");

        Card discardCard = new Card(CardColor.GRAY, CardType.ONE);
        int expResult = 0;

        int result = AIHelper.getValidCard(testHandDeck.getCopyOfHand(),
                                           discardCard);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValidCard method, of class AIHelper.
     */
    @Test
    public void testGetValidCardNoMatch() {
        System.out.println("testGetValidCardNoMatch");

        Card discardCard = new Card(CardColor.GRAY, CardType.FOUR);

        //test if error is thrown when adding an employee that already exists
        try {
            int result = AIHelper.getValidCard(testHandDeck.getCopyOfHand(),
                                               discardCard);
            fail("addEmployee() doesn't error when adding an employee that already exists");
        } catch (NoValidCardException expected) {
        }

    }

    /**
     * Test of isTimeForBuno method, of class AIHelper.
     */
    @Test
    public void testIsTimeForBunoFalse() {
        System.out.println("testIsTimeForBunoFalse");

        //TODO [Unit Test] Loop 100(?) times and check that result is within range
        assertEquals(false, AIHelper.isTimeForBuno(testHandDeck));
    }

    /**
     * Test of isTimeForBuno method, of class AIHelper.
     */
    @Test
    public void testIsTimeForBunoTrue() {
        System.out.println("testIsTimeForBunoTrue");

        //drop a card
        testHandDeck.popTopCard();

        //TODO [Unit Test] Loop 100(?) times and check that result is within range
        assertEquals(true, AIHelper.isTimeForBuno(testHandDeck));
    }

    /**
     * Test of getPlayCommand method, of class AIHelper.
     */
    @Test
    public void testGetPlayCommandOnDraw() {
        System.out.println("getPlayCommand");

        Card discardCard = new Card(CardColor.GRAY, CardType.FOUR);

        PlayCommand result = AIHelper.getPlayCommand(
                testHandDeck.getCopyOfHand(), discardCard);

        assertEquals(PlayCommand.DRAW, result);
    }

    /**
     * Test of getPlayCommand method, of class AIHelper.
     */
    @Test
    public void testGetPlayCommandOnPlay() {
        System.out.println("getPlayCommand");

        Card discardCard = new Card(CardColor.GRAY, CardType.ONE);

        PlayCommand result = AIHelper.getPlayCommand(
                testHandDeck.getCopyOfHand(), discardCard);

        assertEquals(PlayCommand.PLAYCARD, result);
    }

    /**
     * Test of isTimeToBunoActivePlayer method, of class AIHelper.
     */
    @Test
    public void testIsTimeToBunoActivePlayerFalse() {
        System.out.println("testIsTimeToBunoActivePlayerFalse");

        //TODO [Unit Test] Loop 100(?) times and check that result is within range
        assertEquals(false, AIHelper.isTimeToBunoActivePlayer(testHandDeck));
    }

    /**
     * Test of isTimeToBunoActivePlayer method, of class AIHelper.
     */
    @Test
    public void testIsTimeToBunoActivePlayerTrue() {
        System.out.println("testIsTimeToBunoActivePlayerTrue");

        //drop two cards leaving one
        testHandDeck.popTopCard();
        testHandDeck.popTopCard();

        //TODO [Unit Test] Loop 100(?) times and check that result is within range
        assertEquals(true, AIHelper.isTimeToBunoActivePlayer(testHandDeck));
    }
}
