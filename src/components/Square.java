package components;

import utils.ArrayList;
import enums.Dimensions;
import enums.SquareEnum;
import gui.ButtonOption;

public class Square {

	public SquareEnum squareEnum = null;
	private ArrayList<Square> adjacencies = new ArrayList<>();
	private double topLeftX, topLeftY;
	private ArrayList<DiceArmy> diceArmy = new ArrayList<>();
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
		this.diceArmy.add(dice);
		dice.animateSynchronous(this.topLeftX, this.topLeftY);
		dice.setSquare(this);
	}

	public ArrayList<Square> getAdjacenciesClone() {
		return this.adjacencies.clone();
	}

	public boolean containsDiceArmy() {

		if (!this.diceArmy.isEmpty())
			return true;
		else
			return false;
	}

	public void substractOnePointToDice() {
		this.diceArmy.get(0).substractOnePoint();
	}

	public void addOnePointToDice() {
		this.diceArmy.get(0).addOnePoint();
	}

	public void setVisibleButtonOption(boolean value) {
		this.buttonOption.setVisible(value);
	}

	public DiceArmy removeDiceArmy() {
		this.diceArmy.get(0).setSquare(null);
		return this.diceArmy.remove(0);
	}

	public boolean diceArmyIsMaxValue() {
		return this.diceArmy.get(0).isMaxValue();
	}

	public boolean diceArmyIsMinValue() {
		return this.diceArmy.get(0).isMinValue();
	}

	public void rerollDiceArmy() {
		this.diceArmy.get(0).roll();
	}

	public boolean diceArmyIsShowingAtLeast3() {
		return this.diceArmy.get(0).isShowingAtLeast3();
	}

}
