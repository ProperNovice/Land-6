package gameState;

import utils.ArrayList;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class SquareCityPressed extends GameState {

	@Override
	public void handleGameStateChange() {
		showText();
	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();

		switch (textOptionEnum) {

		case CANCEL:
			super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);
			break;

		case DEPLOY_AN_ARMY:
			super.setGameState(GameStateEnum.DEPLOY_ARMY);
			break;

		case MOVE_AN_ARMY:
			super.setGameState(GameStateEnum.MOVE_ARMY_ORIGIN);
			break;

		default:
			break;

		}

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		if (!super.armyDiceIsEmpty())
			if (super.atLeastOneSquareIsAvailableToDeployArmy())
				list.add(TextGameEnum.DEPLOY_AN_ARMY);

		if (super.atLeastOneSquareDiceIsMovable())
			list.add(TextGameEnum.MOVE_AN_ARMY);

		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
