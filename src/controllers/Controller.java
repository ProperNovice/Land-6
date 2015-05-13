package controllers;

import enums.GameDifficultyEnum;
import enums.GameStateEnum;
import gameDifficulty.GameDifficultyController;
import gameDifficulty.GameDifficultyEasy;
import gameDifficulty.GameDifficultyHard;
import gameDifficulty.GameDifficultyNormal;
import gui.Panel;
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
	private Panel panel = null;

	public Controller(GameDifficultyEnum gameDifficultyEnum, Panel panel) {

		this.panel = panel;
		createInstances(gameDifficultyEnum);
		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances(GameDifficultyEnum gameDifficultyEnum) {

		Instances.createController(this);
		this.tileController = new TileController();
		this.diceArmyController = new DiceArmyController();
		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.credentialController = new CredentialController();
		this.cubeArmyController = new CubeArmyController();
		this.diceActionController = new DiceActionController();

		switch (gameDifficultyEnum) {

		case EASY:
			this.gameDifficultyController = new GameDifficultyEasy();
			break;

		case NORMAL:
			this.gameDifficultyController = new GameDifficultyNormal();
			break;

		case HARD:
			this.gameDifficultyController = new GameDifficultyHard();
			break;

		}

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

	public Panel panel() {
		return this.panel;
	}

}
