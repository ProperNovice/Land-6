package gameState;

import utils.ArrayList;
import components.Square;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class MoveArmyDestination extends GameState {

	@Override
	public void handleGameStateChange() {

		showTextList();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		setTextOptionVisibleFalse();
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_DESTINATION);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
