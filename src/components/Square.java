package components;

import gui.PanelGame;
import instances.Instances;
import utils.ArrayList;
import utils.Button;
import enums.Dimensions;
import enums.SquareEnum;

public class Square {

	public SquareEnum squareEnum = null;
	private ArrayList<Square> adjacencies = new ArrayList<>();
	private double topLeftDiceX, topLeftDiceY;
	private DiceArmy dice = null;
	private Button button = null;

	public Square(SquareEnum squareEnum) {
		this.squareEnum = squareEnum;
		createButton();
	}

	private void createButton() {

		PanelGame panelGame = Instances.getPanelGameInstance();
		this.button = new Button(null, panelGame);
		this.button.setSize(Dimensions.BUTTON.x(), Dimensions.BUTTON.y());
		this.button.setText("*");
	}

	public SquareEnum getSquareEnum() {
		return this.squareEnum;
	}

	public void addAdjacent(Square square) {
		this.adjacencies.add(square);
	}

	public boolean isAdjacentWith(Square square) {

		for (Square squareTemp : this.adjacencies)
			if (squareTemp.equals(square))
				return true;

		return false;
	}

	public void setTopLeftCoordinates(double topLeftX, double topLeftY) {
		this.topLeftDiceX = topLeftX
				+ (Dimensions.SQUARE.x() - Dimensions.DICE.x()) / 2;
		this.topLeftDiceY = topLeftY
				+ (Dimensions.SQUARE.y() - Dimensions.DICE.y()) / 2;
		this.button.relocate(this.topLeftDiceX, this.topLeftDiceY);
	}

	public void addDiceAnimateSynchronous(DiceArmy dice) {
		this.dice = dice;
		this.dice.animateSynchronous(this.topLeftDiceX, this.topLeftDiceY);
		this.dice.setSquare(this);
	}

	public void handleSquarePressed() {
		Instances.getControllerInstance().gameStateController()
				.handleSquarePressed(this);
	}

}
