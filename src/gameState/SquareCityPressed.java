package gameState;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextOptionEnum;

public class SquareCityPressed extends GameState {

	@Override
	public void handleGameStateChange() {

		ArrayList<TextOptionEnum> list = new ArrayList<>();
		list.add(TextOptionEnum.DEPLOY_AN_ARMY);
		list.add(TextOptionEnum.MOVE_AN_ARMY);
		list.add(TextOptionEnum.CANCEL);

		super.controller.textOptionController().setVisibleTrue(list);

	}

	@Override
	public void handleTextOptionPressed(TextOptionEnum textOptionEnum) {

		super.controller.textOptionController().setVisibleFalse();

		switch (textOptionEnum) {

		case CANCEL:
			setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);
			break;

		case DEPLOY_AN_ARMY:
			break;

		case MOVE_AN_ARMY:
			break;

		}

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

}
