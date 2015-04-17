package controllers;

import utils.ArrayList;

import components.Dice;
import components.DiceArmy;

import enums.Coordinates;
import enums.Dimensions;

public class DiceArmyController {

	private ArrayList<DiceArmy> diceArmy = new ArrayList<>();
	private double topLeftX, topLeftY;

	public DiceArmyController() {

		this.topLeftX = Coordinates.DICE_ARMY_TOP_LEFT.x();
		this.topLeftY = Coordinates.DICE_ARMY_TOP_LEFT.y();

		createDice();
		relocateDice();

	}

	private void createDice() {
		for (int counter = 1; counter <= 6; counter++)
			this.diceArmy.add(new DiceArmy());
	}

	private void relocateDice() {

		int diceInRow = 3, dicePlaced = 0;
		double x = this.topLeftX;
		double y = this.topLeftY;

		for (Dice dice : this.diceArmy) {

			dice.relocate(x, y);
			dicePlaced++;

			if (dicePlaced < diceInRow) {

				x += Dimensions.DICE.x();
				x += Dimensions.GAP_BETWEEN_DICE.x();

			} else if (dicePlaced == diceInRow) {

				dicePlaced = 0;
				x = this.topLeftX;
				y += Dimensions.DICE.y();
				y += Dimensions.GAP_BETWEEN_DICE.y();

			}

		}

	}

	public DiceArmy getDice() {
		return this.diceArmy.removeLast();
	}

	public boolean isEmpty() {
		return this.diceArmy.isEmpty();
	}

	public void addDice(DiceArmy diceArmy) {

		this.diceArmy.add(diceArmy);

		int row = this.diceArmy.indexOf(diceArmy) / 3;
		int column = this.diceArmy.indexOf(diceArmy) - row * 3;

		double endingX = this.topLeftX + column
				* (Dimensions.DICE.x() + Dimensions.GAP_BETWEEN_DICE.x());
		double endingY = this.topLeftY + row
				* (Dimensions.DICE.y() + Dimensions.GAP_BETWEEN_DICE.y());

		diceArmy.animateSynchronous(endingX, endingY);

	}

}
