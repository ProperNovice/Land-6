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
		showText();
		super.enableSquareButtonForMoveDestination();
	}

	@Override
	public void handleSquareButtonPressed(Square square) {

		super.squareAdjacenciesSetVisibleFalse();
		super.textConceal();

		Logger.logNewLine("moving dice");
		super.executeDiceMove(square);
		Lock.lock();

		super.substractOnePointFromDiceCityHandleDiceIsMinLock();

		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.squareAdjacenciesSetVisibleFalse();
		super.textConceal();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_DESTINATION);
		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
