package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;

import components.Square;

import enums.GameStateEnum;
import enums.TextGameEnum;

public class MoveArmyDestination extends GameState {

	@Override
	public void handleGameStateChange() {
		super.enableSquareButtonForMoveDestination();
		showText();
	}

	@Override
	public void handleSquareButtonPressed(Square square) {

		super.squareAdjacenciesSetVisibleFalse();
		super.textConceal();

		Logger.logNewLine("moving dice");
		super.executeDiceMove(square);
		Lock.lock();

		int substractFromCityDiceArmy = 1;

		if (super.moreThanOneCitiesContainDiceArmy())
			substractFromCityDiceArmy = 2;

		Square squareCity = super.getSquarePressedCity();
		super.substractPointsFromSquareDiceHandleIfMinLock(squareCity,
				substractFromCityDiceArmy);

		super.setGameState(GameStateEnum.LORD_OF_THE_CUBES_ACTION);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.squareAdjacenciesSetVisibleFalse();
		super.textConceal();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		if (!super.squareAdjacenciesIsEmpty())
			list.add(TextGameEnum.CHOOSE_ARMY_DESTINATION);

		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
