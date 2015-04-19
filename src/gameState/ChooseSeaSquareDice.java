package gameState;

import components.Square;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;
import utils.ArrayList;

public class ChooseSeaSquareDice extends GameState {

	@Override
	public void handleGameStateChange() {
		createText();
	}

	@Override
	public void handleSquareDicePressed(Square square) {

		if (!square.getSquareEnum().equals(SquareEnum.SEA))
			return;

		super.textConceal();

		super.setCredentialSquarePressedNonCity(square);
		super.setGameState(GameStateEnum.REROLL_DICE);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();
		super.setGameState(super.getGameStatePrevious());

	}

	private void createText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SEA_SQUARE);
		list.add(TextGameEnum.CANCEL);
		super.textShow(list);

	}

}
