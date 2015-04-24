package gameState;

import components.CubeArmy;

import enums.TextGameEnum;

public class FightLordOfTheCubes extends GameState {

	@Override
	public void handleGameStateChange() {

		super.rollDiceAction();

		int diceActionRoll = super.getDiceActionNumberSideShowing();

		switch (diceActionRoll) {

		case 1:
			handle1();
			break;

		case 2:
			handle23();
			break;

		case 3:
			handle23();
			break;

		case 4:
			handle4();
			break;

		case 5:
			handle56();
			break;

		case 6:
			handle56();
			break;

		}

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();

	}

	@Override
	public void handleCubeArmyPressed(CubeArmy cubeArmy) {

		if (super.cubeArmyControllerContainsCubeArmy(cubeArmy))
			return;

		super.textConceal();

	}

	private void handle1() {

	}

	private void handle23() {

	}

	private void handle4() {

	}

	private void handle56() {

	}
	
	private void setTextContinue() {
		super.textShow(TextGameEnum.CONTINUE);
	}

}
