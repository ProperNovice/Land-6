package controllers;

import gui.PanelGame;
import instances.Instances;

public class Controller {

	private TileController tileController = null;

	public Controller(PanelGame panelGame) {

		createInstances();

	}

	private void createInstances() {

		Instances.createController(this);
		this.tileController = new TileController();

	}

	public TileController tileController() {
		return this.tileController;
	}

}
