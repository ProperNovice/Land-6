package gameState;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class FightLordOfTheCubes extends GameState {

	@Override
	public void handleGameStateChange() {

		if (!super.diceActionIsRolled())
			super.rollDiceAction();

		if (super.atLeastOneSeaSquareHasDice())
			handleArLeastOneSeaSquareHasDice();
		else
			resolveDice();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();

		switch (textOptionEnum) {

		case CONTINUE_NOTHING_HAPPENS:
			handleTextNothingHappens();
			break;

		case REROLL_DICE:
			handleRerollDice();
			break;

		case RESOLVE_FIGHT:
			resolveDice();
			break;

		default:
			break;

		}

	}

	private void resolveDice() {

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
		list.add(TextGameEnum.CONTINUE_NOTHING_HAPPENS);
		super.textShow(list);

	}

	private void handleTextNothingHappens() {
		super.resetDiceActionSide();
		super.setGameState(GameStateEnum.LORD_OF_THE_CUBES_ACTION);
	}

	private void handleChooseForestSquareToSubstractOnePoint() {
		super.setGameState(GameStateEnum.CHOOSE_FOREST_SQUARE_SUBSTRACT_ONE_POINT);
	}

	private void handleArLeastOneSeaSquareHasDice() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.REROLL_DICE);
		list.add(TextGameEnum.RESOLVE_FIGHT);
		super.textShow(list);

	}

	private void handleRerollDice() {
		super.setGameStatePrevious(GameStateEnum.FIGHT_LORD_OF_THE_CUBES);
		super.setGameState(GameStateEnum.CHOOSE_SEA_SQUARE_DICE);
	}

}
