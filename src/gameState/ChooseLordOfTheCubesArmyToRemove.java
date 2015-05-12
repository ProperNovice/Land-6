package gameState;

import utils.Lock;
import components.CubeArmy;
import components.Tile;
import enums.GameStateEnum;
import enums.TextGameEnum;

public class ChooseLordOfTheCubesArmyToRemove extends GameState {

	@Override
	public void handleGameStateChange() {
		super.textShow(TextGameEnum.CHOOSE_ARMY_CUBE);
	}

	@Override
	public void handleCubeArmyPressed(Tile tile) {

		super.textConceal();
		super.resetDiceActionSide();

		super.setGameState(GameStateEnum.ANIMATING);

		CubeArmy cubeArmy = tile.removeCubeArmy();
		super.addCubeArmyToControllerAnimateSynchronous(cubeArmy);

		Lock.lock();

		super.setGameState(super.getGameStateNext());

	}

}
