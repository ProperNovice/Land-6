package gameState;

import utils.ArrayList;

import components.Square;

import enums.GameStateEnum;
import enums.TextGameEnum;

public class MoveArmyOrigin extends GameState {

	@Override
	public void handleGameStateChange() {
		showText();
	}

	@Override
	public void handleSquareDicePressed(Square square) {

		if (!super.squareDiceIsEligibleToMove(square))
			return;

		super.textConceal();
		super.setCredentialSquarePressedNonCity(square);
		super.setGameState(GameStateEnum.MOVE_ARMY_DESTINATION);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_TO_MOVE);
		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
