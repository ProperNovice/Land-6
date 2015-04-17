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

		showTextList();
		enableButtonSquaresForDeployArmy();

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		setTextOptionVisibleFalse();
		handleCancel();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {

		setGameState(GameStateEnum.ANIMATING);

		setVisibleButtonOptionFalse();
		setTextOptionVisibleFalse();

		DiceArmy diceArmy = getDiceArmy();

		substractOnePointFromDiceCityHandleDiceIsMin();

		square.addDiceAnimateSynchronous(diceArmy);
		Logger.logNewLine("deploying army");
		Lock.lock();

		diceArmy.setSide(6);
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void substractOnePointFromDiceCityHandleDiceIsMin() {

		Square squarePressedCity = super.controller.credentialController()
				.getSquarePressedCity();
		squarePressedCity.substractOnePointToDice();

		if (!squarePressedCity.diceArmyIsMinValue())
			return;

		DiceArmy diceArmy = squarePressedCity.removeDiceArmy();

		Logger.log("adding dice to diceArmy");
		super.controller.diceArmyController().addDice(diceArmy);

	}

	private DiceArmy getDiceArmy() {
		return super.controller.diceArmyController().getDice();
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

	private void setVisibleButtonOptionFalse() {

		ArrayList<Square> squareButtons = super.controller
				.credentialController().getSquareButtons();

		for (Square square : squareButtons)
			square.setVisibleButtonOption(false);

	}

	private void handleCancel() {

		setVisibleButtonOptionFalse();
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();
		list.add(TextGameEnum.CHOOSE_SQUARE);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void enableButtonSquaresForDeployArmy() {
		super.controller.tileController().enableButtonSquaresForDeployArmy();
	}

}
