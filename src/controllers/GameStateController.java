package controllers;

import enums.GameStateEnum;
import enums.TextGameEnum;
import gameState.Animating;
import gameState.ChooseSeaSquareDice;
import gameState.ChooseSquareDice;
import gameState.DeployArmy;
import gameState.GameState;
import gameState.LordOfTheCubesAction;
import gameState.MoveArmyDestination;
import gameState.MoveArmyOrigin;
import gameState.RerollDice;
import gameState.SquareCityPressed;
import gameState.StartGame;
import utils.Logger;
import components.Square;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState chooseSquareDice = new ChooseSquareDice();
	private GameState squareCityPressed = new SquareCityPressed();
	private GameState deployArmy = new DeployArmy();
	private GameState animating = new Animating();
	private GameState moveArmyOrigin = new MoveArmyOrigin();
	private GameState moveArmyDestination = new MoveArmyDestination();
	private GameState lordOfTheCubesAction = new LordOfTheCubesAction();
	private GameState rerollDice = new RerollDice();
	private GameState chooseSeaSquareDice = new ChooseSeaSquareDice();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		case CHOOSE_SQUARE_DICE:
			this.currentGameState = this.chooseSquareDice;
			break;

		case SQUARE_CITY_PRESSED:
			this.currentGameState = this.squareCityPressed;
			break;

		case DEPLOY_ARMY:
			this.currentGameState = this.deployArmy;
			break;

		case ANIMATING:
			this.currentGameState = this.animating;
			break;

		case MOVE_ARMY_ORIGIN:
			this.currentGameState = this.moveArmyOrigin;
			break;

		case MOVE_ARMY_DESTINATION:
			this.currentGameState = this.moveArmyDestination;
			break;

		case LORD_OF_THE_CUBES_ACTION:
			this.currentGameState = this.lordOfTheCubesAction;
			break;

		case REROLL_DICE:
			this.currentGameState = this.rerollDice;
			break;

		case CHOOSE_SEA_SQUARE_DICE:
			this.currentGameState = this.chooseSeaSquareDice;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

	}

	public void handleSquareDicePressed(Square square) {
		this.currentGameState.handleSquareDicePressed(square);
	}

	public void handleSquareButtonPressed(Square square) {
		this.currentGameState.handleSquareButtonPressed(square);
	}

	public void handleTextPressed(TextGameEnum textOptionEnum) {
		this.currentGameState.handleTextPressed(textOptionEnum);
	}

	public void handleDiceActionPressed() {
		this.currentGameState.handleDiceActionPressed();
	}

}
