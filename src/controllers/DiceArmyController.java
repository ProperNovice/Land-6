package controllers;

import utils.ArrayList;

import components.Dice;
import components.DiceArmy;

import enums.Coordinates;
import enums.Dimensions;

public class DiceArmyController {

	private ArrayList<DiceArmy> diceArmy = new ArrayList<>();

	public DiceArmyController() {
		createDice();
		relocateDice();
	}

	private void createDice() {
		for (int counter = 1; counter <= 6; counter++)
			this.diceArmy.add(new DiceArmy());
	}

	private void relocateDice() {

		int diceInRow = 3, dicePlaced = 0;
		double firstX = Coordinates.DICE_ARMY_TOP_LEFT.x();
		double x = firstX;
		double y = Coordinates.DICE_ARMY_TOP_LEFT.y();

		for (Dice dice : this.diceArmy) {

			dice.relocate(x, y);
			dicePlaced++;

			if (dicePlaced < diceInRow) {

				x += Dimensions.DICE.x();
				x += Dimensions.GAP_BETWEEN_DICE.x();

			} else if (dicePlaced == diceInRow) {

				dicePlaced = 0;
				x = firstX;
				y += Dimensions.DICE.y();
				y += Dimensions.GAP_BETWEEN_DICE.y();

			}

		}

	}

	public DiceArmy getDice() {
		return this.diceArmy.removeLast();
	}

}
