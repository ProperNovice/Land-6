package components;

import utils.ArrayList;
import enums.Dimensions;
import enums.SquareEnum;

public class Square {

	public SquareEnum squareEnum = null;
	private ArrayList<Square> adjacencies = new ArrayList<>();
	private double topLeftDiceX, topLeftDiceY;
	private Dice dice = null;

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
		this.topLeftDiceX = topLeftX
				+ (Dimensions.TILE.x() - Dimensions.DICE.x()) / 2;
		this.topLeftDiceY = topLeftY
				+ (Dimensions.TILE.y() - Dimensions.DICE.y()) / 2;
	}

	public void addDiceAnimateSynchronous(Dice dice) {
		this.dice = dice;
		this.dice.animateSynchronous(this.topLeftDiceX, this.topLeftDiceY);
	}

}
