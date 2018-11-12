/* *****************************************
* CSCI205 - Software Engineering and Design
* Fall 2018
*
* Name: James Kelly, Scott Little, Rachel Wang, Lily Romano
* Date: Nov 9, 2018
* Time: 12:38:55 PM
*
* Project: csci205FinalProject
* Package: view
* File: UNOGameView
* Description:
*
* ****************************************
 */
package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.cards.Deck;

/**
 *
 * @author jameskelly
 */
public class UNOGameView {

    /**
     * The root node of the view which is a BorderPane
     */
    private final BorderPane root;

    /**
     * The model for the UNO game
     */
    private final UNOGameModel theModel;

    private HBox playersHand;

    private VBox rightPanel;

    private Button UNOButton;
    
    private GridPane cardsInPlayersHand;
    private GridPane opponents;
    private GridPane decks;
    

    StackPane faceDownCard;
    StackPane faceUpCard;

    /**
     * An explicit constructor for the UNO game view
     *
     * @param theModel The model for the UNO game
     */
    public UNOGameView(UNOGameModel theModel) {

 
        this.theModel = theModel;

        root = new BorderPane();
        root.setId("rootNode");

        playersHand = new HBox();
        playersHand.setSpacing(100);
        playersHand.setPadding(new Insets(10, 10, 10, 10));

        cardsInPlayersHand = new GridPane();
        cardsInPlayersHand.setHgap(20);
        cardsInPlayersHand.setVgap(20);
        cardsInPlayersHand.setPadding(new Insets(40));

        //make list of cards, add each card to pane, just pass future players hand of cards 
        //  instead of hardcoding
        
        for (int i = 0; i <= 7; i++) {
            faceUpCard = new StackPane();
            cardsInPlayersHand.add(faceUpCard, i, 0);
            faceUpCard.setPrefSize(128, 178);
            faceUpCard.getStyleClass().add("card");

            //Set Inside of face
            VBox inside = new VBox();
            inside.getStyleClass().add("inside");
            faceUpCard.getChildren().add(inside);
            StackPane.setMargin(inside, new Insets(5));

            String string = Integer.toString(i);

            Label top = new Label(string);
            top.getStyleClass().add("top");
            top.setMinWidth(118);
            top.setPrefHeight(20);

            Label middle = new Label(string);
            middle.getStyleClass().add("middle");
            middle.setMinWidth(118);
            middle.setPrefHeight(138);

            Label bottom = new Label(string);
            bottom.getStyleClass().add("bottom");
            bottom.setMinWidth(118);
            bottom.setPrefHeight(20);

            inside.getChildren().addAll(top, middle, bottom);
        }
        playersHand.getChildren().add(cardsInPlayersHand);

        
        VBox opponentsAndDeck = new VBox();
        opponentsAndDeck.setSpacing(100);
        opponentsAndDeck.setPadding(new Insets(10, 10, 10, 10));
        
        //create the model of opponents
        opponents = new GridPane();
        opponents.setHgap(20);
        opponents.setVgap(20);
        opponents .setPadding(new Insets(20, 0, 0, 0));
        opponents.setAlignment(Pos.TOP_CENTER);
        
        for(int i =0; i<=3; i++){
            faceDownCard = new StackPane();
        faceDownCard.setPrefSize(128, 178);
        faceDownCard.getStyleClass().add("card");
        opponents.add(faceDownCard, i, 0);
            
        }
        
        decks = new GridPane();
        decks.setHgap(20);
        decks.setVgap(20);
        decks.setPadding(new Insets(40));
        //create a card to represent the draw deck
        StackPane  drawDeck = new StackPane();
        drawDeck.setPrefSize(128, 178);
        drawDeck.setMaxSize(128, 178);
        drawDeck.getStyleClass().add("topCardOnDrawDeck");
        //create a card to represent the discard deck
        StackPane  discardDeck = new StackPane();
        discardDeck.setPrefSize(128, 178);
        discardDeck.setMaxSize(128, 178);
        discardDeck.getStyleClass().add("topCardOnDiscardDeck");
        decks.add(drawDeck, 0, 0);
        decks.add(discardDeck, 1, 0);
        decks.setAlignment(Pos.CENTER);
        
        opponentsAndDeck.getChildren().add(opponents);
        opponentsAndDeck.getChildren().add(decks);
        opponentsAndDeck.setAlignment(Pos.CENTER);
        
        

        //create the right box that hold the button
        rightPanel = new VBox();
        rightPanel.setPadding(new Insets(10, 50, 10, 10));
        rightPanel.setAlignment(Pos.BOTTOM_RIGHT);
        rightPanel.setSpacing(50);
        UNOButton = new Button();
        UNOButton.setText("B-UNO!");
        UNOButton.setPrefWidth(100);
        rightPanel.getChildren().add(UNOButton);
       
        
        root.setCenter(opponentsAndDeck);
        root.setRight(rightPanel);
        root.setBottom(playersHand);

    }

    /**
     * Returns the root BorderPane node
     *
     * @return the root BorderPane node
     */
    public BorderPane getRootNode() {
        return root;
    }

    public StackPane getFaceDown() {
        return faceDownCard;
    }

    public StackPane getFaceUp() {
        return faceUpCard;
    }

}
