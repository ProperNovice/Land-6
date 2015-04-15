package controllers;

import components.Dice;
import enums.Coordinates;
import enums.Dimensions;
import utils.ArrayList;

public class ArmyDiceController {

	private ArrayList<Dice> armyDice = new ArrayList<>();

	public ArmyDiceController() {
		createDice();
		relocateDice();
	}

	private void createDice() {
		for (int counter = 1; counter <= 6; counter++)
			this.armyDice.add(new Dice());
	}

	private void relocateDice() {

		int diceInRow = 3, dicePlaced = 0;
		double firstX = Coordinates.DICE_ARMY_TOP_LEFT.x();
		double x = firstX;
		double y = Coordinates.DICE_ARMY_TOP_LEFT.y();

		for (Dice dice : this.armyDice) {

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

}
