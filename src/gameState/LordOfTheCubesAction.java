package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CubeArmy;
import components.Square;
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

		handleDiceAction();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();

		switch (textOptionEnum) {

		case REROLL_DICE:
			handleRerollDice();
			break;

		case EXECUTE_DICE_ACTION:
			handleDiceAction();
			break;

		case CONTINUE_TILE_CONTAINS_DICE_ARMY:
			executeTileContainsDiceArmy(super.getDiceActionNumberSideShowing());
			break;

		case CONTINUE_ADDDING_ARMY_CUBE_ON_TILE:
			executeAddCubeArmyToEmptyTileAnimateSynchronous();

		default:
			break;

		}

	}

	private void handleDiceAction() {

		int diceActionNumberSideShowing = super
				.getDiceActionNumberSideShowing();

		if (!super.tileContainsCubeArmy(diceActionNumberSideShowing))
			setTextAddCubeArmyToEmptyTileAnimateSynchronous(diceActionNumberSideShowing);
		else if (super.tileContainsDiceArmy(diceActionNumberSideShowing))
			setTextTileContainsDiceArmy();
		else
			super.setGameState(GameStateEnum.CHOOSE_CITY_SQUARE_SUBSTRACT_ONE_POINT);

	}

	private void setTextTileContainsDiceArmy() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.SUBSTRACT_ONE_POINT);
		list.add(TextGameEnum.TO_EACH_DIE);
		list.add(TextGameEnum.CONTINUE_TILE_CONTAINS_DICE_ARMY);
		super.textShow(list);

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

	private void setTextAddCubeArmyToEmptyTileAnimateSynchronous(
			int diceActionNumberSideShowing) {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.ADDING_ARMY_CUBE_ON_TILE);
		list.add(TextGameEnum.CONTINUE_ADDDING_ARMY_CUBE_ON_TILE);
		super.textShow(list);

	}

	private void executeAddCubeArmyToEmptyTileAnimateSynchronous() {

		int diceActionNumberSideShowing = super
				.getDiceActionNumberSideShowing();

		CubeArmy cubeArmy = super.getCubeArmy();

		super.addCubeArmyToTileAnimateSynchronous(cubeArmy,
				diceActionNumberSideShowing);
		Logger.logNewLine("adding cube army to tile");
		Lock.lock();

		super.resetDiceActionSide();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
	}

	private void executeTileContainsDiceArmy(int diceActionNumberSideShowing) {

		ArrayList<Square> list = super
				.getSquaresThatContainDiceOnTileNumber(diceActionNumberSideShowing);

		super.substractPointsFromSquareDiceHandleIfMinLock(list, 1);
		super.resetDiceActionSide();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);

	}

}
