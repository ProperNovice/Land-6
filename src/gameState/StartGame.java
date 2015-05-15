package gameState;

import components.DiceArmy;
import utils.Lock;
import utils.Logger;
import enums.GameResult;
import enums.GameStateEnum;

public class StartGame extends GameState {

	@Override
	public void handleGameStateChange() {

		super.setGameState(GameStateEnum.ANIMATING);

		DiceArmy diceArmy = super.getDiceArmy();

		Logger.log("adding starting dice");
		super.addStartingDiceArmy(diceArmy);

		if (super.gameDifficultyGameBeginsWithCubeArmy())
			super.addStartingCubeArmy();

		Logger.newLine();
		
		Lock.lock();

		diceArmy.setSide(6);

//		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE_ACTION);
		super.setGameResult(GameResult.LOSE);
		super.setGameState(GameStateEnum.GAME_ENDED);

	}

}
