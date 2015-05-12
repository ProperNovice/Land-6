package gameState;

import components.Square;

import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class ChooseCitySquareSubstractOnePoint extends GameState {

	@Override
	public void handleGameStateChange() {
		setText();
	}

	@Override
	public void handleSquareDicePressed(Square square) {

		if (!square.getSquareEnum().equals(SquareEnum.CITY))
			return;

		super.textConceal();
		super.resetDiceActionSide();

		super.substractPointsFromSquareDiceHandleIfMinLock(square, 1);

		if (!super.atLeastOneCitySquareContainsDice()) {
			super.handleGameIsLost();
			return;
		}

		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);

	}

	private void setText() {
		super.textShow(TextGameEnum.CHOOSE_CITY_SQUARE_TO_SUBSTRACT);
	}

}
