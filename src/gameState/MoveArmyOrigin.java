package gameState;

import utils.ArrayList;
import components.Square;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class MoveArmyOrigin extends GameState {

	@Override
	public void handleGameStateChange() {

		showTextList();

	}

	@Override
	public void handleSquareDicePressed(Square square) {

		if (!squareDiceIsEligibleToMove(square))
			return;

		setTextOptionVisibleFalse();
		setSquarePessedCredentialNonCity(square);
		setGameState(GameStateEnum.MOVE_ARMY_DESTINATION);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		setTextOptionVisibleFalse();
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_TO_MOVE);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void setSquarePessedCredentialNonCity(Square squarePressed) {
		super.controller.credentialController().setSquarePressedNonCity(
				squarePressed);
	}

	private boolean squareDiceIsEligibleToMove(Square square) {

		SquareEnum squareEnum = square.getSquareEnum();

		if (squareEnum.equals(SquareEnum.CITY))
			return false;

		return true;

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
