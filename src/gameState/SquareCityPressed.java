package gameState;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class SquareCityPressed extends GameState {

	@Override
	public void handleGameStateChange() {

		showTextList();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		setTextOptionVisibleFalse();

		switch (textOptionEnum) {

		case CANCEL:
			setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);
			break;

		case DEPLOY_AN_ARMY:
			setGameState(GameStateEnum.DEPLOY_ARMY);
			break;

		case MOVE_AN_ARMY:
			setGameState(GameStateEnum.MOVE_ARMY_ORIGIN);
			break;

		default:
			break;

		}

	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		if (!armyDiceIsEmpty())
			list.add(TextGameEnum.DEPLOY_AN_ARMY);

		list.add(TextGameEnum.MOVE_AN_ARMY);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private boolean armyDiceIsEmpty() {
		return super.controller.diceArmyController().isEmpty();
	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
