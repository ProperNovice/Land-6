package gameState;

import utils.ArrayList;
import utils.Logger;
import enums.TextOptionEnum;

public class SquareCityPressed extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.logNewLine("square city pressed");

		ArrayList<TextOptionEnum> list = new ArrayList<>();
		list.add(TextOptionEnum.DEPLOY_AN_ARMY);
		list.add(TextOptionEnum.MOVE_AN_ARMY);

		super.controller.textOptionController().setVisibleTrue(list);

	}

	@Override
	public void handleTextOptionPressed(TextOptionEnum textOptionEnum) {
		
		super.controller.textOptionController().setVisibleFalse();

	}

}
