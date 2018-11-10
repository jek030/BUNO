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

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

    private HBox userHBox;

    private VBox buttonBox;

    private Rectangle card;

    private Button UNOButton;

    /**
     * An explicit constructor for the UNO game view
     *
     * @param theModel The model for the UNO game
     */
    public UNOGameView(UNOGameModel theModel) {
        this.theModel = theModel;
        this.userHBox = userHBox;
        this.buttonBox = buttonBox;
        this.UNOButton = UNOButton;

        root = new BorderPane();

        createUsersHand();

        createUNOButton();

        root.setBackground(new Background( // changes the background of the main panel
                new BackgroundFill(Color.LIGHTSEAGREEN,
                        CornerRadii.EMPTY,
                        Insets.EMPTY)));

        root.setRight(buttonBox);
        root.setBottom(userHBox);

    }

    private void createUsersHand() {
        userHBox = new HBox();
        userHBox.setSpacing(100);
        userHBox.setPadding(new Insets(15, 15, 15, 15));

        GridPane handPane = new GridPane();
        //make list of cards, add each card to pane
        ArrayList<Rectangle> hand = new ArrayList<Rectangle>();
        for (int i = 0; i <= 6; i++) {
            card = new Rectangle(100, 128);
            card.setFill(Color.WHEAT);
            hand.add(card);
            handPane.add(card, i, 0);
            handPane.setHgap(10);
        }
        userHBox.getChildren().add(handPane);
    }

    private void createUNOButton() {
        buttonBox = new VBox();
        buttonBox.setPadding(new Insets(15, 15, 15, 15));
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        UNOButton = new Button();
        UNOButton.setText("UNO!");
        UNOButton.setPrefWidth(100);
        buttonBox.getChildren().add(UNOButton);
    }

    /**
     * Returns the root BorderPane node
     *
     * @return the root BorderPane node
     */
    public BorderPane getRootNode() {
        return root;
    }

}
