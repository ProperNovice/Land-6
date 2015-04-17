package gameState;

import instances.Instances;
import utils.ArrayList;
import utils.Lock;
import utils.Logger;
import components.CubeArmy;
import components.DiceArmy;
import components.Square;
import controllers.Controller;
import enums.GameStateEnum;
import enums.SquareEnum;
import enums.TextGameEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();

	protected GameState() {

	}

	public void handleGameStateChange() {

	}

	public void handleSquareDicePressed(Square square) {

	}

	public void handleSquareButtonPressed(Square square) {

	}

	public void handleTextPressed(TextGameEnum textOptionEnum) {

	}

	protected void setGameState(GameStateEnum gameStateEnum) {
		this.controller.gameStateController().setGameState(gameStateEnum);
	}

	protected void addStartingDice(DiceArmy diceArmy) {
		this.controller.tileController().addStartingDice(diceArmy);
	}

	protected DiceArmy getDiceArmy() {
		return this.controller.diceArmyController().getDice();
	}

	protected CubeArmy getCubeArmy() {
		return this.controller.cubeArmyController().getDice();
	}

	protected void textShow(TextGameEnum textGameEnum) {
		this.controller.textController().setVisibleTrue(textGameEnum);
	}

	protected void textShow(ArrayList<TextGameEnum> list) {
		this.controller.textController().setVisibleTrue(list);
	}

	protected void textConceal() {
		this.controller.textController().setVisibleFalse();
	}

	protected void setCredentialSquarePressedCity(Square square) {
		this.controller.credentialController().setSquarePressedCity(square);
	}

	protected void setCredentialSquarePressedNonCity(Square square) {
		this.controller.credentialController().setSquarePressedNonCity(square);
	}

	protected boolean armyDiceIsEmpty() {
		return this.controller.diceArmyController().isEmpty();
	}

	protected void enableSquareButtonsForDeployArmy() {
		this.controller.tileController().enableButtonSquaresForDeployArmy();
	}

	protected void setVisibleButtonOptionFalse() {

		ArrayList<Square> squareButtons = this.controller
				.credentialController().getSquareButtons();

		for (Square square : squareButtons)
			square.setVisibleButtonOption(false);

	}

	protected void substractPointsFromCityDiceHandleDiceIsMinLock(int points) {

		Square squarePressedCity = this.controller.credentialController()
				.getSquarePressedCity();

		for (int counter = 1; counter <= points; counter++) {

			squarePressedCity.substractOnePointToDice();

			if (!squarePressedCity.diceArmyIsMinValue())
				continue;

			break;
		}

		if (!squarePressedCity.diceArmyIsMinValue())
			return;

		setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = squarePressedCity.removeDiceArmy();

		Logger.log("adding dice to diceArmy");
		this.controller.diceArmyController().addDice(diceArmy);

		Lock.lock();

	}

	protected void substractPointsFromNonCityDiceHandleDiceIsMinLock(int points) {

		Square squarePressedCity = this.controller.credentialController()
				.getSquarePressedNonCity();

		for (int counter = 1; counter <= points; counter++) {

			squarePressedCity.substractOnePointToDice();

			if (!squarePressedCity.diceArmyIsMinValue())
				continue;

			break;
		}

		if (!squarePressedCity.diceArmyIsMinValue())
			return;

		setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = squarePressedCity.removeDiceArmy();

		Logger.log("adding dice to diceArmy");
		this.controller.diceArmyController().addDice(diceArmy);

		Lock.lock();

	}

	protected boolean squareDiceIsEligibleToMove(Square square) {

		SquareEnum squareEnum = square.getSquareEnum();

		if (squareEnum.equals(SquareEnum.CITY))
			return false;

		return true;
	}

	protected void enableSquareButtonForMoveDestination() {

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

	protected void executeDiceMove(Square square) {

		Square squareMoveArmyOrigin = this.controller.credentialController()
				.getSquarePressedNonCity();
		DiceArmy diceArmy = squareMoveArmyOrigin.removeDiceArmy();
		square.addDiceAnimateSynchronous(diceArmy);

	}

	protected void squareAdjacenciesSetVisibleFalse() {

		for (Square square : this.controller.credentialController()
				.getSquareAdjacencies())
			square.setVisibleButtonOption(false);

	}

	protected boolean atLeastOneSquareDiceIsMovable() {
		return this.controller.tileController().atLeastOneSquareDiceIsMovable();
	}

	protected boolean atLeastOneSquareIsAvailableToDeployArmy() {
		return this.controller.tileController()
				.atLeastOneSquareIsAvailableToDeplyArmy();
	}

	protected boolean squareAdjacenciesIsEmpty() {
		return this.controller.credentialController()
				.squareAdjacenciesIsEmpty();
	}

	protected boolean moreThanOneCitiesContainDiceArmy() {
		return this.controller.tileController()
				.moreThanOneCitiesContainDiceArmy();
	}

	protected void addOneToDiceArmyInNonGrowingFieldSquare() {
		this.controller.tileController()
				.addOneToDiceArmyInNonGrowinfFieldSquare();
	}

	protected void rollDiceAction() {
		this.controller.diceActionController().roll();
	}

	protected int getDiceActionNumberSideShowing() {
		return this.controller.diceActionController().getNumberSideShowing();
	}

	protected void addCubeArmyToTileAnimateSynchronous(CubeArmy cubeArmy,
			int numberOfTile) {
		this.controller.tileController().addCubeArmyAnimateSynchronous(
				cubeArmy, numberOfTile);
	}

	protected void resetDiceActionSide() {
		this.controller.diceActionController().resetSide();
	}

}
