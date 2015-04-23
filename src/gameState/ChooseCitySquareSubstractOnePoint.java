package gameState;

import utils.ArrayList;

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

		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);

	}

	private void setText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_CITY_SQUARE);
		list.add(TextGameEnum.TO_SUBSTRACT_ONE_POINT);
		super.textShow(list);

	}

}
