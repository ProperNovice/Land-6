package controllers;

import components.DiceAction;
import enums.Coordinates;

public class DiceActionController {

	private DiceAction diceAction = null;

	public DiceActionController() {
		createDiceSea();
	}

	private void createDiceSea() {

		this.diceAction = new DiceAction();
		this.diceAction.relocate(Coordinates.DICE_ACTION.x(),
				Coordinates.DICE_ACTION.y());

	}

	public void roll() {
		this.diceAction.roll();
	}

	public int getNumberSideShowing() {
		return this.diceAction.getSideNumberShowing();
	}

	public void resetSide() {
		this.diceAction.resetSide();
	}

}
