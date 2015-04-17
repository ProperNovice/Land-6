package gameState;

import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.DiceArmy;
import components.Square;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class MoveArmyDestination extends GameState {

	private ArrayList<Square> squareAdjacencies = new ArrayList<>();

	@Override
	public void handleGameStateChange() {

		this.squareAdjacencies.clear();

		showTextList();
		enableSquareButtonForMoveDestination();

	}

	@Override
	public void handleSquareButtonPressed(Square square) {

		squareAdjacenciesSetVisibleFalse();
		setTextOptionVisibleFalse();
		executeMove(square);
		substractOnePointFromDiceCityHandleDiceIsMin();

		Logger.logNewLine("moving dice");
		Lock.lock();

		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	@Override
	public void handleTextPressed(TextGameEnum textOptionEnum) {

		squareAdjacenciesSetVisibleFalse();
		setTextOptionVisibleFalse();
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

	private void executeMove(Square square) {

		Square squareMoveArmyOrigin = super.controller.credentialController()
				.getSquarePressedNonCity();
		DiceArmy diceArmy = squareMoveArmyOrigin.removeDiceArmy();
		square.addDiceAnimateSynchronous(diceArmy);

	}

	private void enableSquareButtonForMoveDestination() {

		Square squareToMoveFrom = super.controller.credentialController()
				.getSquarePressedNonCity();

		this.squareAdjacencies.addAll(squareToMoveFrom.getAdjacenciesClone());

		for (Square square : this.squareAdjacencies)
			if (!square.containsDice())
				square.setVisibleButtonOption(true);

	}

	private void squareAdjacenciesSetVisibleFalse() {

		for (Square square : this.squareAdjacencies)
			square.setVisibleButtonOption(false);

	}

	private void showTextList() {

		ArrayList<TextGameEnum> list = new ArrayList<>();

		list.add(TextGameEnum.CHOOSE_ARMY_DESTINATION);
		list.add(TextGameEnum.CANCEL);

		super.controller.textController().setVisibleTrue(list);

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void setTextOptionVisibleFalse() {
		super.controller.textController().setVisibleFalse();
	}

}
