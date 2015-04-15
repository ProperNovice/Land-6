package controllers;

import utils.Logger;
import components.Square;
import enums.GameStateEnum;
import gameState.ChooseSquareDice;
import gameState.GameState;
import gameState.StartGame;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState chooseSquareDice = new ChooseSquareDice();

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

		}

		Logger.logNewLine("* changing gameState *");
		this.currentGameState.handleGameStateChange();

	}

	public void handleSquarePressed(Square square) {
		this.currentGameState.handleSquarePressed(square);
	}

}
