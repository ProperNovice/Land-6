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

		if (square.getSquareEnum().equals(SquareEnum.SEA))
			return;

		super.textConceal();

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			handleCityPressed(square);
			break;
		case FOREST:
			break;
		case GROWING_FIELD:
			handleGrowingFieldPressed(square);
			break;
		case SEA:
			break;

		}

	}

	private void showText() {
		super.textShow(TextGameEnum.CHOOSE_SQUARE_DIE);
	}

	private void handleCityPressed(Square square) {
		super.setCredentialSquarePressedCity(square);
		super.setGameState(GameStateEnum.SQUARE_CITY_PRESSED);
	}

	private void handleGrowingFieldPressed(Square square) {
		super.setCredentialSquarePressedNonCity(square);
		super.addOneToDiceArmyInNonGrowingFieldSquare();
		super.substractPointsFromNonCityDiceHandleDiceIsMinLock(1);
		super.setGameState(GameStateEnum.LORD_OF_THE_CUBES_ACTION);
	}

}
