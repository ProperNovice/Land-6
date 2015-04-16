package components;

import utils.ArrayList;
import enums.Dimensions;
import enums.SquareEnum;
import gui.ButtonOption;

public class Square {

	public SquareEnum squareEnum = null;
	private ArrayList<Square> adjacencies = new ArrayList<>();
	private double topLeftX, topLeftY;
	private DiceArmy dice = null;
	private ButtonOption buttonOption = new ButtonOption(this);

	public Square(SquareEnum squareEnum) {
		this.squareEnum = squareEnum;
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

		this.topLeftX = topLeftX
				+ (Dimensions.SQUARE.x() - Dimensions.DICE.x()) / 2;
		this.topLeftY = topLeftY
				+ (Dimensions.SQUARE.y() - Dimensions.DICE.y()) / 2;

		this.buttonOption.relocate(this.topLeftX, this.topLeftY);

	}

	public void addDiceAnimateSynchronous(DiceArmy dice) {
		this.dice = dice;
		this.dice.animateSynchronous(this.topLeftX, this.topLeftY);
		this.dice.setSquare(this);
	}

	public ArrayList<Square> getAdjacenciesClone() {
		return this.adjacencies.clone();
	}

	public boolean containsDice() {

		if (this.dice != null)
			return true;
		else
			return false;
	}

	public void substractOnePointToDice() {
		this.dice.substractOnePoint();
	}

	public void addOnePointToDice() {
		this.dice.addOnePoint();
	}

	public void setVisibleButtonOption(boolean value) {
		this.buttonOption.setVisible(value);
	}

	public DiceArmy getDiceArmy() {

		DiceArmy diceArmy = this.dice;
		System.out.println(diceArmy);
		this.dice = null;
		System.out.println(diceArmy);
		return diceArmy;

	}

}
