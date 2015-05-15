package gameState;

import utils.ArrayList;
import components.Square;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class ChooseSquareDiceAction extends GameState {

	@Override
	public void handleGameStateChange() {

		if (super.gameIsWon()) {
			super.handleGameIsWon();
			return;
		}

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
			handleForestPressed(square);
			break;
		case GROWING_FIELD:

			if (super.growingFieldCanBePressed(square))
				handleGrowingFieldPressed(square);

			else
				handleGameStateChange();

			break;
		case SEA:
			handleSeaPressed(square);
			break;

		}

	}

	private void showText() {
		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SQUARE_DIE);
		list.add(TextGameEnum.FOR_YOUR_ACTION);
		super.textShow(list);
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

	private void handleForestPressed(Square square) {

		if (!super.anyTileContainsCubeArmy()) {
			showText();
			return;
		}

		super.setCredentialSquarePressedNonCity(square);
		super.substractPointsFromSquareDiceHandleIfMinLock(square, 1);
		super.setGameState(GameStateEnum.FIGHT_LORD_OF_THE_CUBES);

	}

}
