package gameState;

import components.Square;

import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class ChooseSquareDice extends GameState {

	@Override
	public void handleGameStateChange() {

		showText();

	}

	@Override
	public void handleSquareDicePressed(Square square) {

		setTextIndicatorsVisibilityFalse();

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			setCredentialSquarePressedCity(square);
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

	private void showText() {
		super.controller.textController().setVisibleTrue(
				TextGameEnum.CHOOSE_SQUARE_DIE);
	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextIndicatorsVisibilityFalse() {
		super.controller.textController().setVisibleFalse();
	}

	private void setCredentialSquarePressedCity(Square square) {
		super.controller.credentialController().setSquarePressedCity(square);
	}

}
