package gameState;

import instances.Instances;
import utils.ArrayList;
import utils.Lock;
import utils.Logger;

import components.DiceArmy;
import components.Square;

import controllers.Controller;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	public GameState() {

	}

	public void handleGameStateChange() {

	}

	public void handleSquareDicePressed(Square square) {

	}

	public void handleSquareButtonPressed(Square square) {

	}

	public void handleTextPressed(TextGameEnum textOptionEnum) {

	}

	public void setGameState(GameStateEnum gameStateEnum) {
		this.controller.gameStateController().setGameState(gameStateEnum);
	}

	public void addStartingDice(DiceArmy diceArmy) {
		this.controller.tileController().addStartingDice(diceArmy);
	}

	public DiceArmy getDiceArmy() {
		return this.controller.diceArmyController().getDice();
	}

	public void textShow(TextGameEnum textGameEnum) {
		this.controller.textController().setVisibleTrue(textGameEnum);
	}

	public void textShow(ArrayList<TextGameEnum> list) {
		this.controller.textController().setVisibleTrue(list);
	}

	public void textConceal() {
		this.controller.textController().setVisibleFalse();
	}

	public void setCredentialSquarePressedCity(Square square) {
		this.controller.credentialController().setSquarePressedCity(square);
	}

	public void setCredentialSquarePressedNonCity(Square square) {
		this.controller.credentialController().setSquarePressedNonCity(square);
	}

	public boolean armyDiceIsEmpty() {
		return this.controller.diceArmyController().isEmpty();
	}

	public void enableSquareButtonsForDeployArmy() {
		this.controller.tileController().enableButtonSquaresForDeployArmy();
	}

	public void setVisibleButtonOptionFalse() {

		ArrayList<Square> squareButtons = this.controller
				.credentialController().getSquareButtons();

		for (Square square : squareButtons)
			square.setVisibleButtonOption(false);

	}

	public void substractOnePointFromDiceCityHandleDiceIsMinLock() {

		Square squarePressedCity = this.controller.credentialController()
				.getSquarePressedCity();
		squarePressedCity.substractOnePointToDice();

		if (!squarePressedCity.diceArmyIsMinValue())
			return;

		DiceArmy diceArmy = squarePressedCity.removeDiceArmy();

		Logger.log("adding dice to diceArmy");
		this.controller.diceArmyController().addDice(diceArmy);

		Lock.lock();

	}

	public boolean squareDiceIsEligibleToMove(Square square) {

		SquareEnum squareEnum = square.getSquareEnum();

		if (squareEnum.equals(SquareEnum.CITY))
			return false;

		return true;

	}

	public void enableSquareButtonForMoveDestination() {

		Square squareToMoveFrom = this.controller.credentialController()
				.getSquarePressedNonCity();

		ArrayList<Square> squareAdjacencies = new ArrayList<>();

		for (Square square : squareToMoveFrom.getAdjacenciesClone())
			if (!square.containsDice()) {
				squareAdjacencies.add(square);
				square.setVisibleButtonOption(true);
			}

		this.controller.credentialController().setSquareAdjacencies(
				squareAdjacencies);

	}

	public void executeDiceMove(Square square) {

		Square squareMoveArmyOrigin = this.controller.credentialController()
				.getSquarePressedNonCity();
		DiceArmy diceArmy = squareMoveArmyOrigin.removeDiceArmy();
		square.addDiceAnimateSynchronous(diceArmy);

	}

	public void squareAdjacenciesSetVisibleFalse() {

		for (Square square : this.controller.credentialController()
				.getSquareAdjacencies())
			square.setVisibleButtonOption(false);

	}

}
