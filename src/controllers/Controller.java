package controllers;

import utils.Executor;
import enums.GameStateEnum;
import gui.PanelGame;
import instances.Instances;

public class Controller {

	private TileController tileController = null;
	private DiceArmyController diceArmyController = null;
	private GameStateController gameStateController = null;
	private TextOptionController textOptionController = null;

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
		this.textOptionController = new TextOptionController();

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

	public TextOptionController textOptionController() {
		return this.textOptionController;
	}

}
