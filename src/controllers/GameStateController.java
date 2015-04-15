package controllers;

import utils.Logger;
import components.Square;
import enums.GameStateEnum;
import enums.TextOptionEnum;
import gameState.ChooseSquareDice;
import gameState.DeployArmy;
import gameState.GameState;
import gameState.SquareCityPressed;
import gameState.StartGame;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState chooseSquareDice = new ChooseSquareDice();
	private GameState squareCityPressed = new SquareCityPressed();
	private GameState deployArmy = new DeployArmy();

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

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

	}

	public void handleSquarePressed(Square square) {
		this.currentGameState.handleSquarePressed(square);
	}

	public void handleTextOptionPressed(TextOptionEnum textOptionEnum) {
		this.currentGameState.handleTextOptionPressed(textOptionEnum);
	}

}
