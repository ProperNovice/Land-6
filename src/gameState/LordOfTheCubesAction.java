package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CubeArmy;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class LordOfTheCubesAction extends GameState {

	@Override
	public void handleGameStateChange() {

		if (!super.diceActionIsRolled())
			super.rollDiceAction();

		if (super.atLeastOneSeaSquareHasDice()) {
			handleAtLeastOneSeaSquareHasDice();
			return;
		}

		executeDiceAction();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();

		switch (textOptionEnum) {

		case REROLL_DICE:
			handleRerollDice();
			break;

		case EXECUTE_DICE_ACTION:
			executeDiceAction();
			break;

		default:
			break;

		}

	}

	private void executeDiceAction() {

		int diceActionNumberSideShowing = super
				.getDiceActionNumberSideShowing();

		if (!super.tileContainsCubeArmy(diceActionNumberSideShowing)) {
			addCubeArmyToTileAnimateSynchronous(diceActionNumberSideShowing);
			return;
		}

	}

	private void handleRerollDice() {
		super.setGameStatePrevious(GameStateEnum.LORD_OF_THE_CUBES_ACTION);
		super.setGameState(GameStateEnum.CHOOSE_SEA_SQUARE_DICE);
	}

	private void handleAtLeastOneSeaSquareHasDice() {
		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.EXECUTE_DICE_ACTION);
		list.add(TextGameEnum.REROLL_DICE);
		super.textShow(list);
	}

	private void addCubeArmyToTileAnimateSynchronous(
			int diceActionNumberSideShowing) {

		CubeArmy cubeArmy = super.getCubeArmy();

		super.addCubeArmyToTileAnimateSynchronous(cubeArmy,
				diceActionNumberSideShowing);
		Logger.logNewLine("adding cube army to tile");
		Lock.lock();

		super.resetDiceActionSide();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);
	}

}
