package gameState;

import components.Square;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class SquareCityPressed extends GameState {

	@Override
	public void handleGameStateChange() {

		createTextList();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		setTextOptionVisibleFalse();

		switch (textOptionEnum) {

		case CANCEL:
			setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);
			break;

		case DEPLOY_AN_ARMY:
			substractOnePointToDice();
			setGameState(GameStateEnum.DEPLOY_ARMY);
			break;

		case MOVE_AN_ARMY:
			substractOnePointToDice();
			break;

		default:
			break;

		}

	}

	private void createTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.DEPLOY_AN_ARMY);
		list.add(TextGameEnum.MOVE_AN_ARMY);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void substractOnePointToDice() {

		Square squarePressed = super.controller.credentialController()
				.getSquarePressed();
		squarePressed.substractOnePointToDice();
	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
