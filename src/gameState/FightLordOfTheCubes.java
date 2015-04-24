package gameState;

import utils.ArrayList;
import components.CubeArmy;
import enums.GameStateEnum;
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
		super.resetDiceActionSide();

		switch (textOptionEnum) {

		case CONTINUE:
			handleTextContinue();
			break;

		default:
			break;

		}

	}

	@Override
	public void handleCubeArmyPressed(CubeArmy cubeArmy) {

		if (super.cubeArmyControllerContainsCubeArmy(cubeArmy))
			return;

		super.textConceal();

	}

	private void handle1() {
		handle23();
	}

	private void handle23() {
		setTextNothingHappens();
	}

	private void handle4() {
		handle23();
	}

	private void handle56() {
		handle23();
	}

	private void setTextNothingHappens() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.NOTHING_HAPPENS);
		list.add(TextGameEnum.CONTINUE);
		super.textShow(list);

	}

	private void handleTextContinue() {
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
	}

}
