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

    private VBox rightBox;

    private Button UNOButton;

    private VBox leftBox;

    StackPane faceDown;
    StackPane faceUp;

    /**
     * An explicit constructor for the UNO game view
     *
     * @param theModel The model for the UNO game
     */
    public UNOGameView(UNOGameModel theModel) {

        /**
         * -----------------------------------------------------------------
         * this.theModel = theModel; this.userHBox = userHBox; this.buttonBox =
         * buttonBox; this.UNOButton = UNOButton;
         *
         * root = new BorderPane();
         *
         *
         *
         * createUNOButton();
         *
         * root.setBackground(new Background( // changes the background of the
         * main panel new BackgroundFill(Color.LIGHTSEAGREEN, CornerRadii.EMPTY,
         * Insets.EMPTY)));
         *
         * root.setRight(buttonBox); root.setBottom(userHBox);
         * ----------------------------------------------------------------------
         */
        this.theModel = theModel;

        root = new BorderPane();
        root.setId("rootNode");

        userHBox = new HBox();
        userHBox.setSpacing(100);
        userHBox.setPadding(new Insets(10, 10, 10, 10));

        GridPane handGrid = new GridPane();
        handGrid.setHgap(20);
        handGrid.setVgap(20);
        handGrid.setPadding(new Insets(40));

        //make list of cards, add each card to pane
        //ArrayList<Rectangle> hand = new ArrayList<Rectangle>();
        for (int i = 0; i <= 4; i++) {
            faceUp = new StackPane();
            handGrid.add(faceUp, i, 0);
            faceUp.setPrefSize(128, 178);
            faceUp.getStyleClass().add("card");

            //Set Inside of face
            VBox inside = new VBox();
            inside.getStyleClass().add("inside");
            faceUp.getChildren().add(inside);
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
        userHBox.getChildren().add(handGrid);

        //creat the center player grid
        GridPane centerGrid = new GridPane();
        faceDown = new StackPane();
        faceDown.setPrefSize(128, 178);
        faceDown.getStyleClass().add("card");
        centerGrid.setPadding(new Insets(20, 0, 0, 0));
        centerGrid.add(faceDown, 0, 0);
        centerGrid.setAlignment(Pos.TOP_CENTER);

        //create the right box that hold the button and right player
        rightBox = new VBox();
        rightBox.setPadding(new Insets(10, 50, 10, 10));
        rightBox.setAlignment(Pos.CENTER);
        rightBox.setSpacing(50);
        UNOButton = new Button();
        UNOButton.setText("B-UNO!");
        UNOButton.setPrefWidth(100);
        faceDown = new StackPane();
        faceDown.setPrefSize(128, 178);
        faceDown.getStyleClass().add("card");
        rightBox.getChildren().addAll(faceDown, UNOButton);

        //create left player box
        leftBox = new VBox();
        leftBox.setPadding(new Insets(10, 50, 10, 10));
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(50);
        faceDown = new StackPane();
        faceDown.setPrefSize(128, 178);
        faceDown.getStyleClass().add("card");
        leftBox.getChildren().add(faceDown);

        root.setLeft(leftBox);
        root.setCenter(centerGrid);
        root.setRight(rightBox);
        root.setBottom(userHBox);

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
        return faceDown;
    }

    public StackPane getFaceUp() {
        return faceUp;
    }

}
