package gameState;

import components.DiceArmy;

import utils.Lock;
import utils.Logger;
import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = super.getDiceArmy();

		Logger.logNewLine("adding starting dice");
		super.addStartingDice(diceArmy);
		Lock.lock();

		diceArmy.setSide(6);

		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);

	}

}
