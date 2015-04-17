package gameState;

import utils.Lock;
import components.CubeArmy;
import enums.GameStateEnum;

public class LordOfTheCubesAction extends GameState {

	@Override
	public void handleGameStateChange() {

		super.rollDiceAction();

		int diceActionNumberSideShowing = super
				.getDiceActionNumberSideShowing();

		CubeArmy cubeArmy = super.getCubeArmy();

		super.setGameState(GameStateEnum.ANIMATING);

		super.addCubeArmyToTileAnimateSynchronous(cubeArmy,
				diceActionNumberSideShowing);
		Lock.lock();

		super.resetDiceActionSide();
		super.setGameState(GameStateEnum.CHOOSE_SQUARE_DICE);

	}

}
