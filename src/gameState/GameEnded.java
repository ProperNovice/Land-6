package gameState;

import enums.GameResult;
import enums.TextGameEnum;
import utils.ArrayList;

public class GameEnded extends GameState {

	@Override
	public void handleGameStateChange() {

		showText();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.restartGame();

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		GameResult gameResult = super.getGameResult();

		switch (gameResult) {

		case LOSE:
			list.add(TextGameEnum.YOU_LOST);
			break;

		case WIN:
			list.add(TextGameEnum.YOU_WON);
			break;

		}

		list.add(TextGameEnum.RESTART_GAME);
		super.textShow(list);

	}

}
