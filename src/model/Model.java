package model;

import instances.Instances;

import components.DiceArmy;

import controllers.Controller;
import enums.GameStateEnum;

public class Model {

	private Controller controller = Instances.getControllerInstance();

	public Model() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {
		this.controller.gameStateController().setGameState(gameStateEnum);
	}

	public void addStartingDice() {
		this.controller.tileController().addStartingDice(getDiceArmy());
	}

	public DiceArmy getDiceArmy() {
		return this.controller.diceArmyController().getDice();
	}

}
