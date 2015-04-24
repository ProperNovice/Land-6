package gameState;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class FightLordOfTheCubes extends GameState {

	@Override
	public void handleGameStateChange() {

		super.rollDiceAction();

		int diceActionRoll = super.getDiceActionNumberSideShowing();

		switch (diceActionRoll) {

		case 1:
			handleDiceActionRoll1();
			break;

		case 2:
			handleDiceActionRoll23();
			break;

		case 3:
			handleDiceActionRoll23();
			break;

		case 4:
			handleDiceActionRoll4();
			break;

		case 5:
			handleDiceActionRoll56();
			break;

		case 6:
			handleDiceActionRoll56();
			break;

		}

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();
		super.resetDiceActionSide();

		switch (textOptionEnum) {

		case CONTINUE:
			handleTextNothingHappens();
			break;

		default:
			break;

		}

	}

	private void handleDiceActionRoll1() {

		if (super.tileControllerContainsAtLeastOneForestSquareWithDiceAction())
			handleChooseForestSquareToSubstractOnePoint();
		else
			handleDiceActionRoll23();

	}

	private void handleDiceActionRoll23() {
		setTextNothingHappens();
	}

	private void handleDiceActionRoll4() {
		setGameStateNext(GameStateEnum.LORD_OF_THE_CUBES_ACTION);
		setGameState(GameStateEnum.CHOOSE_LORD_OF_THE_CUBES_ARMY_TO_REMOVE);
	}

	private void handleDiceActionRoll56() {
		setGameStateNext(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
		setGameState(GameStateEnum.CHOOSE_LORD_OF_THE_CUBES_ARMY_TO_REMOVE);
	}

	private void setTextNothingHappens() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.NOTHING_HAPPENS);
		list.add(TextGameEnum.CONTINUE);
		super.textShow(list);

	}

	private void handleTextNothingHappens() {
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
	}

	private void handleChooseForestSquareToSubstractOnePoint() {
		super.setGameState(GameStateEnum.CHOOSE_FOREST_SQUARE_SUBSTRACT_ONE_POINT);
	}

}
