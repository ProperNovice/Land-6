package gameState;

import components.Square;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class ChooseForestSquareToSubstractOnePoint extends GameState {

	@Override
	public void handleGameStateChange() {
		super.textShow(TextGameEnum.CHOOSE_FOREST_SQUARE_TO_SUBSTRACT);
	}

	@Override
	public void handleSquareDicePressed(Square square) {

		if (!square.getSquareEnum().equals(SquareEnum.FOREST))
			return;

		super.textConceal();
		super.resetDiceActionSide();
		super.substractPointsFromSquareDiceHandleIfMinLock(square, 1);

		super.setGameState(GameStateEnum.FIGHT_LORD_OF_THE_CUBES);

	}

}
