package gameState;

import utils.Lock;
import utils.Logger;
import components.DiceArmy;
import components.Square;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		Logger.logNewLine("starting game");

		DiceArmy diceArmy = super.controller.diceArmyController().getDice();

		super.controller.tileController().addStartingDice(diceArmy);
		Logger.logNewLine("adding starting dice");
		Lock.lock();

		diceArmy.setSide(6);

	}

	@Override
	public void handleSquarePressed(Square square) {
		System.out.println(square.getSquareEnum());
	}

}
