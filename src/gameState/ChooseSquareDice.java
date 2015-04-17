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

		super.textConceal();

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			super.setCredentialSquarePressedCity(square);
			super.setGameState(GameStateEnum.SQUARE_CITY_PRESSED);
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
		super.textShow(TextGameEnum.CHOOSE_SQUARE_DIE);
	}

}
