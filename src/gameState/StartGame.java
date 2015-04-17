package gameState;

import components.DiceArmy;

import utils.Lock;
import utils.Logger;
import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.model.setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = super.model.getDiceArmy();

		Logger.logNewLine("adding starting dice");
		super.model.addStartingDice();
		Lock.lock();

		diceArmy.setSide(6);

//		super.model.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

}
