package controllers;

import components.Square;

import enums.GameStateEnum;
import gameState.GameState;
import gameState.StartGame;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		}

		this.currentGameState.handleGameStateChange();

	}

	public void handleSquarePressed(Square square) {
		this.currentGameState.handleSquarePressed(square);
	}

}
