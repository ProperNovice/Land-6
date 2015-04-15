package gameState;

import utils.Lock;
import utils.Logger;

import components.DiceArmy;

import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		DiceArmy diceArmy = super.controller.diceArmyController().getDice();

		super.controller.tileController().addStartingDice(diceArmy);
		Logger.logNewLine("adding starting dice");
		Lock.lock();

		diceArmy.setSide(6);
		super.controller.gameStateController().setGameState(
				GameStateEnum.CHOOSE_SQUARE_DICE);

	}

}
