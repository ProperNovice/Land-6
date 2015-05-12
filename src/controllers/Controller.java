package controllers;

import enums.GameStateEnum;
import gameDifficulty.GameDifficultyController;
import gameDifficulty.GameDifficultyEasy;
import gui.PanelGame;
import instances.Instances;
import utils.Executor;

public class Controller {

	private TileController tileController = null;
	private DiceArmyController diceArmyController = null;
	private GameStateController gameStateController = null;
	private TextController textController = null;
	private CredentialController credentialController = null;
	private CubeArmyController cubeArmyController = null;
	private DiceActionController diceActionController = null;
	private GameDifficultyController gameDifficultyController = null;

	public Controller(PanelGame panelGame) {

		createInstances();
		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.createController(this);
		this.tileController = new TileController();
		this.diceArmyController = new DiceArmyController();
		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.credentialController = new CredentialController();
		this.cubeArmyController = new CubeArmyController();
		this.diceActionController = new DiceActionController();
		this.gameDifficultyController = new GameDifficultyEasy();

	}

	public TileController tileController() {
		return this.tileController;
	}

	public DiceArmyController diceArmyController() {
		return this.diceArmyController;
	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public CredentialController credentialController() {
		return this.credentialController;
	}

	public CubeArmyController cubeArmyController() {
		return this.cubeArmyController;
	}

	public DiceActionController diceActionController() {
		return this.diceActionController;
	}

	public GameDifficultyController gameDifficultyController() {
		return this.gameDifficultyController;
	}

}
