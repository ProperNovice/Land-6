package gameState;

import utils.Logger;
import components.Square;
import enums.SquareEnum;
import enums.TextIndicatorEnum;

public class ChooseSquareDice extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.logNewLine("choose square dice");

		super.controller.textIndicatorController().setVisibleTrue(
				TextIndicatorEnum.CHOOSE_SQUARE_DIE);

	}

	@Override
	public void handleSquarePressed(Square square) {

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			System.out.println("city");
			break;
		case FOREST:
			break;
		case GROWING_FIELD:
			break;
		case SEA:
			break;

		}

	}

}
