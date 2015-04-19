package controllers;

import components.DiceAction;

import enums.Coordinates;

public class DiceActionController {

	private DiceAction diceAction = null;
	private boolean isRolled = false;

	public DiceActionController() {
		createDiceSea();
	}

	private void createDiceSea() {

		this.diceAction = new DiceAction();
		this.diceAction.relocate(Coordinates.DICE_ACTION.x(),
				Coordinates.DICE_ACTION.y());

	}

	public void roll() {
		this.isRolled = true;
		this.diceAction.roll();
	}

	public int getNumberSideShowing() {
		return this.diceAction.getSideNumberShowing();
	}

	public void resetSide() {
		this.isRolled = false;
		this.diceAction.resetSide();
	}

	public boolean isRolled() {
		return this.isRolled;
	}

}
