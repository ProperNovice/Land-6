package controllers;

import gui.PanelGame;
import instances.Instances;

public class Controller {

	private TileController tileController = null;
	private ArmyDiceController armyDiceController = null;

	public Controller(PanelGame panelGame) {

		createInstances();

	}

	private void createInstances() {

		Instances.createController(this);
		this.tileController = new TileController();
		this.armyDiceController = new ArmyDiceController();

	}

	public TileController tileController() {
		return this.tileController;
	}

	public ArmyDiceController armyDiceController() {
		return this.armyDiceController;
	}

}
