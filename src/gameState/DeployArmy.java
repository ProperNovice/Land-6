package gameState;

import utils.ArrayList;

import components.Square;

import enums.TextGameEnum;

public class DeployArmy extends GameState {

	@Override
	public void handleGameStateChange() {

		createTextList();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {

	}

	private void createTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SQUARE);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

}
