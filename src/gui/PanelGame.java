package gui;

import instances.Instances;
import utils.Parent;
import controllers.Controller;
import enums.GameDifficultyEnum;

public class PanelGame extends Parent {

	public PanelGame(GameDifficultyEnum gameDifficultyEnum, Panel panel) {

		Instances.createPanelGame(this);
		new Controller(gameDifficultyEnum, panel);

	}

}
