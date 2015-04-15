package gameState;

import components.Square;

import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextIndicatorEnum;

public class ChooseSquareDice extends GameState {

	@Override
	public void handleGameStateChange() {

		super.controller.textIndicatorController().setVisibleTrue(
				TextIndicatorEnum.CHOOSE_SQUARE_DIE);

	}

	@Override
	public void handleSquarePressed(Square square) {

		super.controller.textIndicatorController().setVisibleFalse();

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			setGameState(GameStateEnum.SQUARE_CITY_PRESSED);
			break;
		case FOREST:
			break;
		case GROWING_FIELD:
			break;
		case SEA:
			break;

		}

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

}
