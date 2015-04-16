package gameState;

import utils.Lock;
import utils.Logger;

import components.DiceArmy;

import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = super.controller.diceArmyController().getDice();

		addStartingDice(diceArmy);
		Lock.lock();

		diceArmy.setSide(6);
		setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

	private void setGameState(GameStateEnum gameStateEnum) {
		super.controller.gameStateController().setGameState(gameStateEnum);
	}

	private void addStartingDice(DiceArmy diceArmy) {
		super.controller.tileController().addStartingDice(diceArmy);
		Logger.logNewLine("adding starting dice");
	}

}
