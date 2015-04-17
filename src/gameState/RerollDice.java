package gameState;

import components.Square;
import utils.ArrayList;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class RerollDice extends GameState {

	@Override
	public void handleGameStateChange() {
		textCreate();
	}

	@Override
	public void handleSquareDicePressed(Square square) {

		SquareEnum squareEnumPressed = square.getSquareEnum();

		if (squareEnumPressed.equals(SquareEnum.SEA))
			return;

		super.textConceal();
		square.rerollDiceArmy();
		super.substractPointsFromNonCityDiceHandleDiceIsMinLock(1);
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void textCreate() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_DICE_TO_REROLL);
		list.add(TextGameEnum.CANCEL);
		super.textShow(list);

	}

}
