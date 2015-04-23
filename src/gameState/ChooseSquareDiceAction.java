package gameState;

import components.Square;

import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class ChooseSquareDiceAction extends GameState {

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
			handleCityPressed(square);
			break;
		case FOREST:
			break;
		case GROWING_FIELD:
			handleGrowingFieldPressed(square);
			break;
		case SEA:
			handleSeaPressed(square);
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
		super.addOneToDiceArmyInNonGrowingFieldSquare();
		super.substractPointsFromSquareDiceHandleIfMinLock(square, 1);
		super.setGameState(GameStateEnum.LORD_OF_THE_CUBES_ACTION);
	}

	private void handleSeaPressed(Square square) {
		super.setCredentialSquarePressedNonCity(square);
		super.setGameStatePrevious(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
		super.setGameState(GameStateEnum.REROLL_DICE);
	}

}
