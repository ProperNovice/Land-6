package controllers;

import enums.GameStateEnum;
import enums.TextGameEnum;
import gameState.Animating;
import gameState.ChooseCitySquareSubstractOnePoint;
import gameState.ChooseForestSquareToSubstractOnePoint;
import gameState.ChooseLordOfTheCubesArmyToRemove;
import gameState.ChooseSeaSquareDice;
import gameState.ChooseSquareDiceAction;
import gameState.DeployArmy;
import gameState.FightLordOfTheCubes;
import gameState.GameState;
import gameState.LordOfTheCubesAction;
import gameState.MoveArmyDestination;
import gameState.MoveArmyOrigin;
import gameState.RerollDice;
import gameState.SquareCityPressed;
import gameState.StartGame;
import utils.Logger;

import components.Square;
import components.Tile;

public class GameStateController {

	private GameState currentGameState = null;
	private GameState startGame = new StartGame();
	private GameState chooseSquareDiceAction = new ChooseSquareDiceAction();
	private GameState squareCityPressed = new SquareCityPressed();
	private GameState deployArmy = new DeployArmy();
	private GameState animating = new Animating();
	private GameState moveArmyOrigin = new MoveArmyOrigin();
	private GameState moveArmyDestination = new MoveArmyDestination();
	private GameState lordOfTheCubesAction = new LordOfTheCubesAction();
	private GameState rerollDice = new RerollDice();
	private GameState chooseSeaSquareDice = new ChooseSeaSquareDice();
	private GameState chooseCitySquareSubstractOnePoint = new ChooseCitySquareSubstractOnePoint();
	private GameState fightLordOfTheCubes = new FightLordOfTheCubes();
	private GameState chooseForestSquareToSubstractOnePoint = new ChooseForestSquareToSubstractOnePoint();
	private GameState chooseLordOfTheCubesArmyToRemove = new ChooseLordOfTheCubesArmyToRemove();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		case CHOOSE_SQUARE_DICE_ACTION:
			this.currentGameState = this.chooseSquareDiceAction;
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

		case CHOOSE_CITY_SQUARE_SUBSTRACT_ONE_POINT:
			this.currentGameState = this.chooseCitySquareSubstractOnePoint;
			break;

		case FIGHT_LORD_OF_THE_CUBES:
			this.currentGameState = this.fightLordOfTheCubes;
			break;

		case CHOOSE_FOREST_SQUARE_SUBSTRACT_ONE_POINT:
			this.currentGameState = this.chooseForestSquareToSubstractOnePoint;
			break;

		case CHOOSE_LORD_OF_THE_CUBES_ARMY_TO_REMOVE:
			this.currentGameState = this.chooseLordOfTheCubesArmyToRemove;
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

	public void handleCubeArmyPressed(Tile tile) {
		this.currentGameState.handleCubeArmyPressed(tile);
	}

}
