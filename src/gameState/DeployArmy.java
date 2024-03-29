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

		int cubeArmyControllerSize = super.getCubeArmyControllerSize();
		diceArmy.setSide(cubeArmyControllerSize);

		Square squareCity = super.getSquarePressedCity();
		super.substractPointsFromSquareDiceHandleIfMinLock(squareCity, 1);

		super.setGameState(GameStateEnum.LORD_OF_THE_CUBES_ACTION);

	}

	private void handleCancel() {

		super.setVisibleButtonOptionFalse();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);

	}

	private void showText() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SQUARE);
		list.add(TextGameEnum.CANCEL);

		super.textShow(list);

	}

}
