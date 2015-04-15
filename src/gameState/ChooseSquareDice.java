package gameState;

import components.Square;
import enums.SquareEnum;
import enums.TextOptionEnum;
import gui.TextOption;
import utils.Logger;

public class ChooseSquareDice extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.logNewLine("choose square dice");

	}

	@Override
	public void handleSquarePressed(Square square) {

		SquareEnum squareEnumPressed = square.getSquareEnum();

		switch (squareEnumPressed) {

		case CITY:
			handleCityPressed(square);
			break;
		case FOREST:
			break;
		case GROWING_FIELD:
			break;
		case SEA:
			break;

		}

	}

	private void handleCityPressed(Square square) {
		
		new TextOption(TextOptionEnum.DEPLOY_THE_ARMY).relocate(50, 50);

	}

}
