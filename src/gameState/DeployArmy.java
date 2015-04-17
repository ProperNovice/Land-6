package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;

import components.DiceArmy;
import components.Square;

import enums.GameStateEnum;
import enums.TextGameEnum;

public class DeployArmy extends GameState {

	@Override
	public void handleGameStateChange() {

		showText();
		super.enableSquareButtonsForDeployArmy();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		super.textConceal();
		handleCancel();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {

		super.setGameState(GameStateEnum.ANIMATING);

		super.setVisibleButtonOptionFalse();
		super.textConceal();

		DiceArmy diceArmy = super.getDiceArmy();

		square.addDiceAnimateSynchronous(diceArmy);
		Logger.logNewLine("deploying army");
		Lock.lock();

		diceArmy.setSide(6);

		super.substractOnePointFromDiceCityHandleDiceIsMinLock();

		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void handleCancel() {

		super.setVisibleButtonOptionFalse();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SQUARE);
		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
